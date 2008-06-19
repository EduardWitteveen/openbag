<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>BRS GEGEVENS NIET TERUGGEVONDEN</title>
	<link  type="text/css" rel="stylesheet" href="../style.css"> </link>
	<script language="JavaScript">
	</script>
</head>
<?php
	$IGNORE_PREFIX = "ignore";
	
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	$connection = openConnection();
	
	// do we need to ignore something?
	if(isset($_REQUEST['action-change'])) {
		$connection->beginTransaction();
		foreach($_REQUEST as $key => $value) {			
			if(substr($key, 0, strlen($IGNORE_PREFIX )) == $IGNORE_PREFIX) {
				$values = explode("|", $value);
				$nummer = intval(str_replace('\'', '\'\'', $values[0]));
				$letter = strtoupper (trim(str_replace('\'', '\'\'', $values[1])));
				$toevoeging = strtoupper (trim(str_replace('\'', '\'\'', $values[2])));
				$postcode = strtoupper (trim(str_replace('\'', '\'\'', $values[3])));
				// echo("nummer: $nummer letter: $letter toevoeging: $toevoeging postcode $postcode");
				$sql = "INSERT INTO VB_NUMMERAANDUIDING\n";
				$sql .= "	(\n";
				$sql .= "	  EXPIREDATE,\n";
				$sql .= "	  REASONFORCHANGE,\n";
				$sql .= "	  AUTHOR,\n";
				$sql .= "	  AUTHENTIC,\n";
				$sql .= "	  RESEARCH,\n";
				$sql .= "	  ACCEPTED,\n";
//				$sql .= "	  WOONPLAATSID,\n";
//				$sql .= "	  OPENBARERUIMTEID,\n";
				$sql .= "	  HUISNUMMER,\n";
				$sql .= "	  HUISLETTER,\n";
				$sql .= "	  HUISNUMMERTOEVOEGING,\n";
				$sql .= "	  POSTCODE\n";
				$sql .= "	)\n";
				$sql .= "	VALUES\n";
				$sql .= "	(\n";
				$sql .= "	0,						--EXPIREDATE\n";
				$sql .= "	'ignore with sync',		--REASONFORCHANGE\n";
				$sql .= "	'" . str_replace('\\', '/', $_SERVER['REMOTE_USER']) . "',		--AUTHOR\n";
				$sql .= "	'N',		--AUTHENTIC\n";
				$sql .= "	'N',		--RESEARCH\n";
				$sql .= "	'N',		--ACCEPTED\n";
				$sql .= "	'" . $nummer . "',		--HUISNUMMER\n";
				$sql .= "	'" . $letter . "',		--HUISLETTER\n";
				$sql .= "	'" . $toevoeging . "',		--HUISNUMMERTOEVOEGING\n";
				$sql .= "	'" . $postcode . "'		--POSTCODE\n";
				$sql .= ")";
				
				if(!$connection->exec($sql)) {
					die("ERROR IN EXECUTE:" . print_r($connection->errorInfo(), TRUE) . "\n\nsql:\n$sql");
				}								
			}
		}
		$sql = "UPDATE VB_NUMMERAANDUIDING\n";
		$sql .= "	SET EXPIREDATE = STARTDATE\n";
		$sql .= "	WHERE EXPIREDATE = 0\n";
		if(!$connection->exec($sql)) {
			die("ERROR IN EXECUTE:" . print_r($connection->errorInfo(), TRUE) . "\n\nsql:\n$sql");
		}
		if(!$connection->commit()) {
			die("ERROR IN COMMIT:" . print_r($connection->errorInfo(), TRUE));
		}
		header('Location: ' . getPreviousPageValue());
		// stop omdat het anders teveel tijd inneemt!!
		$connection = null;
		exit();
	}
	else if(isset($_REQUEST['action-cancel'])) {
		header('Location: ' . getPreviousPageValue());
		exit();
	}	
?>
<body>
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
	<hr />
	<p>Het ophalen van deze pagina kan even duren, een ogenblik geduld graag,...</p>
	<form method="post">
	<input type="hidden" name="returnpage" value="<?php echo(getPreviousPageValue()) ?>">
	<input type="reset" />
	<input type="submit" name="action-cancel" value="Annuleren">
	<input type="submit" name="action-change" value="Negeren selectie">
		
	<table>
		<tr>
			<th>Negeren</th>
			<th>Woonplaats</th>
			<th>Straatnaam</th>
			<th>Huisnummer</th>
			<th>Huisletter</th>
			<th>Huistoevoeging</th>
			<th>Huisaanduiding</th>
			<th>Postcode</th>
			<th>Locatiebeschrijving</th>
		</tr>
<?php
	// we can already send this,..
	ob_flush();
		
	$sql = "SELECT *\n";
	$sql .= "FROM BRSADRESUNKNOWN\n";
	$sql .= "ORDER BY ADTWPLNAM, ADTSTTNAM, ADTHUINUM, ADTHUILET, ADTHUITVG, ADTHUIAND";
	
	// 120 seconds
	set_time_limit(120);
	
	// do not use the getRecords, this one can display while fetching
	try {
		$statement = $connection->query($sql);
		if(!$statement) {
			die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::". __FUNCTION__ . " could query, sql: $sql error:" . print_r($connection->errorInfo(), TRUE));
		}
		$i = 0;
		while($record = $statement->fetch(PDO::FETCH_ASSOC)) {
			$nummer = trim($record['ADTHUINUM']);
			$letter = trim($record['ADTHUILET']);			
			$toevoeging = trim($record['ADTHUITVG']);
			//$aanduiding = $record['ADTHUIAND'];
			$postcode = trim($record['ADTPKDNUM']);
			
			$identifier = array($nummer, $letter, $toevoeging, $postcode);
			$identifier = implode("|", $identifier);
			
?>
		<tr>
			<td>
				<input type="checkbox" value="<?php echo($identifier) ?>" name="<?php echo("$IGNORE_PREFIX-$i"); $i++; ?>">
			</td>
			<td><?php echo($record['ADTWPLNAM']) ?></td>
 			<td><?php echo($record['ADTSTTNAM']) ?></td>
			<td><?php echo($record['ADTHUINUM']) ?></td>
			<td><?php echo($record['ADTHUILET']) ?></td>
			<td><?php echo($record['ADTHUITVG']) ?></td>
			<td><?php echo($record['ADTHUIAND']) ?></td>
			<td><?php echo($record['ADTPKDNUM']) ?></td>
			<td><?php echo($record['ADTLOKBSC']) ?></td>
		</tr>
<?php
			// flush output
			ob_flush();
		}
		$statement = null;
	}
	catch(Exception $e) {
		die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::". __FUNCTION__ . " exception: error:" . print_r($connection->errorInfo(), TRUE));
	}
?>
	</table>
	<p>Totaal aantal mismatches: <?php echo($i); ?></p>
	<input type="reset" />
	<input type="submit" name="action-cancel" value="Annuleren">
	<input type="submit" name="action-change" value="Negeren selectie">
	</form>
	<hr />
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
</body>
</html>
<?php
	$connection = null;
?>