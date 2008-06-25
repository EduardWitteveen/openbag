<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>ZOEK NUMMERAANDUIDING</title>
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
					$where = addEqualsStatement('VB_NUMMERAANDUIDING.HUISNUMMER', $searchword, $where, 'OR');
					$where = addEqualsStatement('VB_NUMMERAANDUIDING.HUISLETTER', $searchword, $where, 'OR');
					$where = addEqualsStatement('VB_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING', $searchword, $where, 'OR');
					$where = addEqualsStatement('VB_NUMMERAANDUIDING.POSTCODE', $searchword, $where, 'OR');										
					$where = addContainsStatement('NA_WOONPLAATS.LABEL', $searchword, $where, 'OR');					
					// openbare ruimte gegevens
					$where = addContainsStatement('VB_OPENBARERUIMTE.LABEL', $searchword, $where, 'OR');
					$where = addContainsStatement('OR_WOONPLAATS.LABEL', $searchword, $where, 'OR');					

					if(empty($totalwhere)) {
						$totalwhere = "(\n $where )\n";
					}
					else {
						$totalwhere .= "AND\n(\n $where )\n ";
					}
				}				
			}
		break;
		case 'terugmelding':
				$totalwhere = "VB_NUMMERAANDUIDING.RESEARCH='Y'\n";
		break;
		case 'geenopenbareruimte':
				$totalwhere = "VB_NUMMERAANDUIDING.OPENBARERUIMTEID IS NULL\n";
		break;
		case 'geenwoonplaats':
				$totalwhere = "VB_NUMMERAANDUIDING.WOONPLAATSID IS NULL\n";
		break;
		case 'geengeom':
				$totalwhere = "VB_NUMMERAANDUIDING.GEOM IS NULL\n";
		break;
		case 'geenpostcode':
				$totalwhere = "VB_NUMMERAANDUIDING.POSTCODE IS NULL\n";
		break;
		case 'nietuniek':
				$totalwhere = "VB_NUMMERAANDUIDING.POSTCODE IN (\n";
				$totalwhere .= "    SELECT dubbel_postcode\n";
				$totalwhere .= "    FROM\n";
				$totalwhere .= "    (\n";
				$totalwhere .= "      SELECT\n";
				$totalwhere .= "        postcode as dubbel_postcode, \n";
				$totalwhere .= "        huisnummer as dubbel_nummer, \n";
				$totalwhere .= "        huisletter as dubbel_letter, \n";
				$totalwhere .= "        huisnummertoevoeging as dubbel_toev,\n";
				$totalwhere .= "        authentic as dubbel_authentic\n";
				$totalwhere .= "      FROM\n";
				$totalwhere .= "      (\n";
				$totalwhere .= "        SELECT DISTINCT postcode, huisnummer, huisletter, huisnummertoevoeging, authentic, count(*) as aantal\n";
				$totalwhere .= "        FROM  vb_nummeraanduiding\n";
				$totalwhere .= "  		WHERE EXPIREDATE = 99999999999999\n";
				$totalwhere .= "        GROUP BY postcode, huisnummer, huisletter, huisnummertoevoeging\n";
				$totalwhere .= "      )\n";
				$totalwhere .= "      WHERE aantal > 1\n";
				$totalwhere .= "    )\n";
				$totalwhere .= "    WHERE VB_NUMMERAANDUIDING.HUISNUMMER = dubbel_nummer\n";
				$totalwhere .= "    AND\n";
				$totalwhere .= "    (\n";
				$totalwhere .= "      VB_NUMMERAANDUIDING.HUISLETTER = dubbel_letter\n";
				$totalwhere .= "      OR\n";
				$totalwhere .= "      (VB_NUMMERAANDUIDING.HUISLETTER  IS NULL AND dubbel_letter IS NULL)\n";
				$totalwhere .= "    )\n";
				$totalwhere .= "    AND\n";
				$totalwhere .= "    (\n";
				$totalwhere .= "      VB_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING = dubbel_toev\n";
				$totalwhere .= "      OR\n";
				$totalwhere .= "      (VB_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING  IS NULL AND dubbel_toev IS NULL)\n";
				$totalwhere .= "    )\n";
				$totalwhere .= "  )\n";				
		break;		
		case 'dubbelpostcode':
				$totalwhere = "VB_NUMMERAANDUIDING.POSTCODE IN (\n";
				$totalwhere .= "  SELECT postcode\n";
				$totalwhere .= "  FROM\n";
				$totalwhere .= "  (\n";
				$totalwhere .= "    SELECT DISTINCT(postcode), COUNT(*) as aantal\n";
				$totalwhere .= "    FROM\n";
				$totalwhere .= "    (\n";
				$totalwhere .= "      SELECT DISTINCT postcode, openbareruimteid\n";
				$totalwhere .= "      FROM  vb_nummeraanduiding\n";
				$totalwhere .= "      WHERE vb_nummeraanduiding.EXPIREDATE = 99999999999999\n";
				$totalwhere .= "      GROUP BY postcode, openbareruimteid\n";
				$totalwhere .= "    )\n";
				$totalwhere .= "    GROUP BY postcode\n";
				$totalwhere .= "  )\n";
				$totalwhere .= "  WHERE aantal > 1\n";
				$totalwhere .= ")\n";
		break;
		default:
			die("unknown behaviour: $behaviour");
	}
	if(!empty($totalwhere)) {
		$sql = "SELECT\n";
		$sql .= "  VB_NUMMERAANDUIDING.GID,\n";
		$sql .= "  VB_NUMMERAANDUIDING.AUTHENTIC,\n";
		$sql .= "  VB_NUMMERAANDUIDING.RESEARCH,\n";
		//$sql .= "  VB_NUMMERAANDUIDING.ACCEPTED,\n";
		$sql .= "  VB_NUMMERAANDUIDING.HUISNUMMER,\n";
		$sql .= "  VB_NUMMERAANDUIDING.HUISLETTER,\n";
		$sql .= "  VB_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,\n";
		$sql .= "  VB_NUMMERAANDUIDING.POSTCODE,\n";
		$sql .= "  VB_OPENBARERUIMTE.LABEL AS OR_STRAAT,\n";
		$sql .= "  OR_WOONPLAATS.LABEL AS OR_WOONPLAATS,\n";
		$sql .= "  NA_WOONPLAATS.LABEL AS NA_WOONPLAATS\n";
		$sql .= "FROM VB_NUMMERAANDUIDING\n";
		$sql .= "-- de woonplaats van de plek\n";
		$sql .= "LEFT OUTER JOIN VB_WOONPLAATS NA_WOONPLAATS\n";
		$sql .= "ON VB_NUMMERAANDUIDING.WOONPLAATSID = NA_WOONPLAATS.GID\n";
		$sql .= "AND NA_WOONPLAATS.EXPIREDATE = 99999999999999\n";
		$sql .= "-- de straat\n";
		$sql .= "LEFT OUTER JOIN VB_OPENBARERUIMTE\n";
		$sql .= "ON VB_NUMMERAANDUIDING.OPENBARERUIMTEID = VB_OPENBARERUIMTE.GID\n";
		$sql .= "AND VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
		$sql .= "-- de woonplaats van de straat\n";
		$sql .= "LEFT OUTER JOIN VB_WOONPLAATS OR_WOONPLAATS\n";
		$sql .= "ON VB_OPENBARERUIMTE.WOONPLAATSID = OR_WOONPLAATS.GID\n";
		$sql .= "AND OR_WOONPLAATS.EXPIREDATE = 99999999999999\n";
		$sql .= "WHERE VB_NUMMERAANDUIDING.EXPIREDATE = 99999999999999\n";
		$sql .= "AND $totalwhere";
		if($behaviour != 'nietuniek') {
			// no order for nietuniek, maybe faster!
			$sql .= "ORDER BY VB_NUMMERAANDUIDING.AUTHENTIC DESC,VB_NUMMERAANDUIDING.POSTCODE, 0 + HUISNUMMER, HUISLETTER, HUISNUMMERTOEVOEGING, VB_NUMMERAANDUIDING.OPENBARERUIMTEID \n";
		}
		else {
			$sql .= "ORDER BY VB_NUMMERAANDUIDING.AUTHENTIC DESC, VB_NUMMERAANDUIDING.POSTCODE, 0 + HUISNUMMER, HUISLETTER, HUISNUMMERTOEVOEGING, VB_NUMMERAANDUIDING.OPENBARERUIMTEID \n";
		}
		//die($sql);			
	}
	// flush output
	ob_flush();
?>
<body>
	<a href="<?php echo(getPreviousPageValue()) ?>"><< VORIGE</a>
	<?php
		if($behaviour=='nietuniek') {
	?>				
	<p>Deze bewerking kan enige tijd in duren</p>
	<?php
			// flush output
			ob_flush();
			// 120 seconds
			set_time_limit(180);
			//die($sql);
		}
		if(isset($sql)) {
			$connection = openConnection();
			$records = getRecords($connection, $sql);
			//echo("<pre>$sql</pre><br />SIZE:". sizeof($records));		
		}
	?>
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
					Toevoegen nieuwe nummeraanduiding
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
						<th>Huisnummer</th>
						<th>Huisletter</th>
						<th>Huisnummertoevoeging</th>
						<th>Postcode</th>
						<th>Openbareruimte naam</th>
						<th>OR Woonplaats naam</th>
						<th>NA Woonplaats naam</th>						
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
						<td><?php echo($record['HUISNUMMER']) ?></td>
						<td><?php echo($record['HUISLETTER']) ?></td>
						<td><?php echo($record['HUISNUMMERTOEVOEGING']) ?></td>
						<td><?php echo($record['POSTCODE']) ?></td>
						<td><?php echo($record['OR_STRAAT']) ?></td>
						<td><?php echo($record['OR_WOONPLAATS']) ?></td>
						<td><?php echo($record['NA_WOONPLAATS']) ?></td>					
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