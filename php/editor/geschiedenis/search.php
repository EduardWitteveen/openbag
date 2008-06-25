<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>GESCHIEDENIS</title>
	<link  type="text/css" rel="stylesheet" href="../style.css"> </link>
	<script language="JavaScript">
	</script>
</head>
<?php
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	$checkowner = true;	
	// ONLY the author can delete his own changes!
	$author = str_replace('\\', '/', $_SERVER['REMOTE_USER']);			
	$connection = openConnection();
	
	if(!empty($_REQUEST['gid'])) {
		$gid = str_replace('\'', '\\\'', $_REQUEST['gid']);
		$tablename = "VB_" . str_replace('\'', '\\\'', $_REQUEST['source']);
		$startdate = str_replace('\'', '\\\'', $_REQUEST['startdate']);
		$expiredate = str_replace('\'', '\\\'', $_REQUEST['expiredate']);
		
		$connection->beginTransaction();
		// first check if the record really exists (ea spoofing and such)
		$sql = "SELECT gid, startdate, expiredate\n";
		$sql .= "FROM $tablename\n";
		$sql .= "WHERE gid = '$gid'\n";
		$sql .= "AND startdate = $startdate\n";
		$sql .= "AND expiredate = $expiredate\n";
		if($checkowner) {
			$sql .= "AND AUTHOR = '" . $author .  "'\n";
		}
		$records = getRecords($connection, $sql);
		if(sizeof($records) != 1) {
			die("fetched #" . sizeof($records) . " records instead of 1, with sql: $sql");
		}
		// now set the values back, so we know for certain they are correct
		$gid = $records[0]['GID'];
		$startdate = $records[0]['STARTDATE'];
		$expiredate = $records[0]['EXPIREDATE'];		
		
		// delete the specfic record
		$sql = "DELETE FROM $tablename\n";
		$sql .= "WHERE gid = '$gid'\n";
		$sql .= "AND startdate = $startdate\n";
		$sql .= "AND expiredate = $expiredate\n";
		echo($sql);
		if(!$connection->exec($sql)) {
			die("<pre>execute error: no records changed.\n$sql");
		}		
		// if exists, update the record before this record to have the expire date of this record so our history is correct
		// also keep in mind that if it was a delete record (expiredata=startdate) we need to update the expiredate to max(expiredate)
		if($expiredate == $startdate) {
			$expiredate = 99999999999999;
		}
		if($expiredate == $startdate) {
			// we deleted a =delete= record
			$sql = "UPDATE $tablename SET EXPIREDATE = (SELECT MAX(EXPIREDATE) FROM $tablename)\n";
		}
		else {
			// update to the previous expiredate
			$sql = "UPDATE $tablename SET EXPIREDATE = $expiredate\n";
		}
		$sql .= "WHERE gid = '$gid'\n";
		$sql .= "AND expiredate = $startdate\n";
		$connection->exec($sql);
		if(!$connection->commit()) {
			die("<pre>commit error:" . print_r($connection->errorInfo(), TRUE));
		}
		header('Location: ' . getPreviousPageValue());
		// leave our redirect info behind us.
		exit();
	}	
	$sql = "SELECT RAWTOHEX(GID) AS ID, SOURCE, STARTDATE, EXPIREDATE, DESCRIPTION, REASONFORCHANGE, AUTHOR\n";
	$sql .= "FROM BACKCHANGESBYDATE\n";
	if($checkowner && $author != 'AAENHUNZE/ew886') {
		$sql .= "WHERE AUTHOR = '" . $author .  "'\n";
	}
	$records = getRecords($connection, $sql);
		
?>
<body>
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
	<h1>LET OP, DEZE WIJZIGINGEN ZIJN PERMANENT!</h1>
	<hr />
	<table>
		<tr>
			<td>				
				<table>
					<tr>
						<th>Mutaties verwijderen</th>
						<th>Bron</th>
						<th>Van datum</th>
						<th>Tot datum</th>
						<th>Omschrijving</th>
						<th>Reden tot wijziging</th>
						<th>Auteur</th>
					</tr>
					<?php
					// only loop if records isset
					if(isset($records)) {
						foreach($records as $record) {
					?>
					<tr>
						<td>
							<?php
								$identifier = '?' . getCurrentPageParameter();
								$identifier .= '&gid=' . $record['ID'];
								$identifier .= '&source=' . $record['SOURCE'];
								$identifier .= '&startdate=' . $record['STARTDATE'];
								$identifier .= '&expiredate='. $record['EXPIREDATE'];
							?>
							<a href="search.php<?php echo($identifier ) ?>" onclick="return confirm('Weet u zeker dat u deze gegevens wilt verwijderen?');">
								<img alt="verwijderen" src="../image/delete.gif">
							</a>
						</td>
						<td><?php echo($record['SOURCE']) ?></td>
						<td><?php echo($record['STARTDATE']) ?></td>
						<td><?php echo($record['EXPIREDATE']) ?></td>
						<td><?php echo($record['DESCRIPTION']) ?></td>
						<td><?php echo($record['REASONFORCHANGE']) ?></td>
						<td><?php echo($record['AUTHOR']) ?></td>
					</tr>
					<?php
						}
					}
					?>
				</table>
			</td>
		</tr>
	</table>
	<hr />
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
</body>
</html>
<?php
	$connection = null;
?>