<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>ZOEK OPENBARERUIMTE</title>
	<link  type="text/css" rel="stylesheet" href="../style.css"> </link>
	<script language="JavaScript">
	</script>
</head>
<?php
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	if(empty($_REQUEST['behaviour'])) {
		die('parameter behaviour was not defined!');
	}
	$behaviour = $_REQUEST['behaviour'];
	switch($behaviour) {
		// search displays a search display
		case 'search':
		// search doenst display the searchbar
		case 'keysearch':
			$filter = '';
			if(isset($_REQUEST['filter'])) {
				$filter = $_REQUEST['filter'];
			}
			if(!empty($filter)) {
				$totalwhere = '';
				// the filter can contain multiple search items, so we need to create a search based upon the multiple fields
				foreach(explode(" ", $filter) as $searchword) {
					$where = '';
					$where = addContainsStatement('VB_OPENBARERUIMTE.LABEL', $searchword, $where, 'OR');
					$where = addContainsStatement('VB_WOONPLAATS.LABEL', $searchword, $where, 'OR');
					$where = addEqualsStatement('VB_OPENBARERUIMTE.GID', $searchword, $where, 'OR');
					$where = addEqualsStatement('VB_OPENBARERUIMTE.WOONPLAATSID', $searchword, $where, 'OR');

					if(empty($totalwhere)) {
						$totalwhere = "(\n $where )\n";
					}
					else {
						$totalwhere .= "AND\n(\n $where )\n ";
					}
				}			
				$sql = "SELECT VB_OPENBARERUIMTE.*, VB_WOONPLAATS.LABEL AS WOONPLAATSLABEL\n";
				$sql .= "FROM VB_OPENBARERUIMTE\n";
				$sql .= "LEFT OUTER JOIN VB_WOONPLAATS\n";
				$sql .= "ON VB_OPENBARERUIMTE.WOONPLAATSID = VB_WOONPLAATS.GID\n";
				$sql .= "AND VB_WOONPLAATS.EXPIREDATE = 99999999999999\n";
				$sql .= "WHERE VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
				$sql .= "AND $totalwhere";
				$sql .= "ORDER BY VB_OPENBARERUIMTE.AUTHENTIC DESC, VB_OPENBARERUIMTE.LABEL,  VB_WOONPLAATS.LABEL\n";
			}
		break;
		case 'terugmelding':
				$sql = "SELECT VB_OPENBARERUIMTE.*, VB_WOONPLAATS.LABEL AS WOONPLAATSLABEL\n";
				$sql .= "FROM VB_OPENBARERUIMTE\n";
				$sql .= "LEFT OUTER JOIN VB_WOONPLAATS\n";
				$sql .= "ON VB_OPENBARERUIMTE.WOONPLAATSID = VB_WOONPLAATS.GID\n";
				$sql .= "AND VB_WOONPLAATS.EXPIREDATE = 99999999999999\n";
				$sql .= "WHERE VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
				$sql .= "AND VB_OPENBARERUIMTE.RESEARCH='Y'";
				$sql .= "ORDER BY VB_OPENBARERUIMTE.AUTHENTIC DESC,VB_OPENBARERUIMTE.LABEL,  VB_WOONPLAATS.LABEL\n";
		break;
		case 'geenwoonplaats':
				$sql = "SELECT VB_OPENBARERUIMTE.*, 'NULL' AS WOONPLAATSLABEL\n";
				$sql .= "FROM VB_OPENBARERUIMTE\n";
				$sql .= "WHERE VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
				$sql .= "AND VB_OPENBARERUIMTE.WOONPLAATSID IS NULL\n";
				$sql .= "ORDER BY VB_OPENBARERUIMTE.AUTHENTIC DESC,VB_OPENBARERUIMTE.LABEL\n";
		break;
		default:
			die("unknown behaviour: $behaviour");
	}
	if(!empty($sql)) {	
		$connection = openConnection();
		$records = getRecords($connection, $sql);
	}
?>
<body>
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
	<hr />
	<table>
		<?php
		if($behaviour == "search") {
		?>
		<tr>
			<td>				
				<form>
					<input type="hidden" name="behaviour" value="search">
					<input type="hidden" name="returnpage" value="<?php echo(getPreviousPageValue()) ?>">
					<input type="text"   name="filter" value="<?php echo($filter) ?>">
					<input type="submit" name="action" value="Zoeken">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<a href="edit.php?<?php echo(getCurrentPageParameter()); ?>">
					Toevoegen nieuwe openbareruimte
				</a>
			</td>
		</tr>
		<?php		
		}
		?>
		<tr>
			<td>				
				<table>
					<tr>
						<th>Bewerken</th>
						<th>Authentiek</th>
						<th>Research</th>
						<th>Openbareruimte naam</th>
						<th>Woonplaats naam</th>						
					</tr>
					<?php
					// only loop if records isset
					if(isset($records)) {
						foreach($records as $record) {
					?>
					<tr>
						<td>
							<a href="edit.php?<?php echo(getCurrentPageParameter() . "&id=" . $record['GID']); ?>">
								<img alt="details" src="../image/detail.gif">
							</a>
						</td>
						<td><?php echo($record['AUTHENTIC']) ?></td>
						<td><?php echo($record['RESEARCH']) ?></td>
						<td><?php echo($record['LABEL']) ?></td>
						<td><?php echo($record['WOONPLAATSLABEL']) ?></td>
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


