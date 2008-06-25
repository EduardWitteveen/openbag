<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>BAG ONDERHOUD</title>
	<link  type="text/css" rel="stylesheet" href="style.css"> </link>
	<script language="JavaScript">
	</script>
</head>
<?php
	include_once "include/database.php";
	include_once "include/util.php";
	$connection = openConnection();
?>
<body>
<h1>BAG BEHEER</h1>
<h2>Status gegevens</h2>
<p>Status gegevens vermeld de informatie over het huidige systeem.</p>
<table>
	<tr>
		<th>Bewerken</th>
		<th>Onderdeel</th>
		<th>Omschrijving</th>
		<th>Aantal authentiek</th>
		<th>Aantal overig</th>
		<th>Totaal</th>
	</tr>
	<tr>	
		<td>
			<a href="javascript:alert('not yet implemented');">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Woonplaats</td>
		<td>Totalen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "COUNT(*) AS TOTAL\n";
	$sql .= "FROM  VB_WOONPLAATS\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
?>
		<td><?php echo($authentiek); ?></td>
		<td><?php echo($overig); ?></td>
		<td><?php echo($totaal); ?></td>		
	</tr>
	<tr>		
		<td>	
			<a href="openbareruimte/search.php?behaviour=search&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Openbareruimte</td>
		<td>Totalen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "COUNT(*) AS TOTAL\n";
	$sql .= "FROM  VB_OPENBARERUIMTE\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
?>
		<td><?php echo($authentiek); ?></td>
		<td><?php echo($overig); ?></td>
		<td><?php echo($totaal); ?></td>		
	</tr>
	<tr>		
		<td>
			<a href="nummeraanduiding/search.php?behaviour=search&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>
		<td>Totalen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "COUNT(*) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
?>
		<td><?php echo($authentiek); ?></td>
		<td><?php echo($overig); ?></td>
		<td><?php echo($totaal); ?></td>		
	</tr>
</table>
<!--
<a href="javascript:alert('not yet implemented');">Benoemen woonplaats (blz 93)</a><br />
<a href="javascript:alert('not yet implemented');">Hernoemen woonplaats (blz 95)</a><br />
<a href="javascript:alert('not yet implemented');">Intrekken woonplaats (blz 97)</a><br />
-->
<!--
<a href="javascript:alert('not yet implemented');">Benoemen openbareruimte (blz 87)</a><br />
<a href="javascript:alert('not yet implemented');">Hernoemen openbareruimte (blz 89)</a><br />
<a href="javascript:alert('not yet implemented');">Intrekken openbareruimte (blz 91)</a><br />
-->
<!--
<a href="javascript:alert('not yet implemented');">Opvoeren nummeraanduiding (blz 141)</a><br />
<a href="javascript:alert('not yet implemented');">Muteren gegevens nummeraanduiding (blz 142)</a><br />
<a href="javascript:alert('not yet implemented');">Afvoeren nummeraanduiding (blz 142)</a><br />
-->
<hr />
<table>
	<tr>
		<th>Bewerken</th>
		<th>Onderdeel</th>
		<th>Omschrijving</th>		
		<th>Aantal authentiek</th>
		<th>Aantal overig</th>
		<th>Totaal</th>
	</tr>
	<tr>
		<td>
			<a href="javascript:alert('not yet implemented');">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Woonplaats</td>
		<td>Terugmeldingen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND research = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND research = 'Y' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN research = 'Y' THEN  1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_WOONPLAATS\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="openbareruimte/search.php?behaviour=terugmelding&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Openbareruimte</td>
		<td>Terugmeldingen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND research = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND research = 'Y' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN research = 'Y' THEN  1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_OPENBARERUIMTE\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="openbareruimte/search.php?behaviour=geenwoonplaats&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Openbareruimte</td>
		<td>Missende woonplaats</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND woonplaatsid IS NULL THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND woonplaatsid IS NULL THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN woonplaatsid IS NULL THEN 1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_OPENBARERUIMTE\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=nietuniek&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Openbareruimte</td>
		<td>Nummeraanduiding niet uniek</td>
<?php
	$sql = "SELECT COUNT(*) AS aantal_na\n";
	$sql .= "FROM \n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT postcode, huisnummer, huisletter, huisnummertoevoeging, count(*) as aantal\n";
	$sql .= "  FROM  vb_nummeraanduiding\n";
	$sql .= "  WHERE authentic = 'Y'\n";
	$sql .= "  AND EXPIREDATE = 99999999999999\n";
	$sql .= "  GROUP BY postcode, huisnummer, huisletter, huisnummertoevoeging\n";
	$sql .= ")\n";
	$sql .= "WHERE aantal > 1\n";

	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AANTAL_NA'];

	$sql = "SELECT COUNT(*) AS aantal_na\n";
	$sql .= "FROM \n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT postcode, huisnummer, huisletter, huisnummertoevoeging, count(*) as aantal\n";
	$sql .= "  FROM  vb_nummeraanduiding\n";
	$sql .= "  WHERE EXPIREDATE = 99999999999999\n";
	$sql .= "  GROUP BY postcode, huisnummer, huisletter, huisnummertoevoeging\n";
	$sql .= ")\n";
	$sql .= "WHERE aantal > 1\n";
	$records = getRecords($connection, $sql);
	$totaal = $records[0]['AANTAL_NA'];
	$overig = $totaal - $authentiek;
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=dubbelpostcode&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Openbareruimte</td>
		<td>Postcode niet uniek</td>
<?php
	$sql = "SELECT COUNT(*) AS aantal_or, SUM(aantal_na) AS aantal_na\n";
	$sql .= "FROM\n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT(postcode), COUNT(*) AS aantal_or, SUM(aantal_na) AS aantal_na\n";
	$sql .= "  FROM\n";
	$sql .= "  (\n";
	$sql .= "    SELECT DISTINCT postcode, openbareruimteid, COUNT(*) AS aantal_na\n";
	$sql .= "    FROM  vb_nummeraanduiding\n";
	$sql .= "    WHERE authentic = 'Y'\n";
	$sql .= "    AND EXPIREDATE = 99999999999999\n";
	$sql .= "    GROUP BY postcode, openbareruimteid\n";
	$sql .= "  )\n";
	$sql .= "  GROUP BY postcode\n";
	$sql .= ")\n";
	$sql .= "WHERE aantal_or > 1\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AANTAL_OR'];

	$sql = "SELECT COUNT(*) AS aantal_or, SUM(aantal_na) AS aantal_na\n";
	$sql .= "FROM\n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT(postcode), COUNT(*) AS aantal_or, SUM(aantal_na) AS aantal_na\n";
	$sql .= "  FROM\n";
	$sql .= "  (\n";
	$sql .= "    SELECT DISTINCT postcode, openbareruimteid, COUNT(*) AS aantal_na\n";
	$sql .= "    FROM  vb_nummeraanduiding\n";
	$sql .= "    WHERE EXPIREDATE = 99999999999999\n";
	$sql .= "    GROUP BY postcode, openbareruimteid\n";
	$sql .= "  )\n";
	$sql .= "  GROUP BY postcode\n";
	$sql .= ")\n";
	$sql .= "WHERE aantal_or > 1\n";
	$records = getRecords($connection, $sql);
	$totaal = $records[0]['AANTAL_OR'];
	$overig = $totaal - $authentiek;
	if($totaal > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=terugmelding&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>
		<td>Terugmeldingen</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND research = 'Y' THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND research = 'Y' THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN research = 'Y' THEN  1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=geenwoonplaats&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>
		<td>Missende woonplaats</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND woonplaatsid IS NULL THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND woonplaatsid IS NULL THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN woonplaatsid IS NULL THEN 1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>	
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=geenopenbareruimte&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>
		<td>Missende openbareruimte</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND openbareruimteid IS NULL THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND openbareruimteid IS NULL THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN openbareruimteid IS NULL THEN 1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=geengeom&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>		
		<td>Missende coordinaten</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND geom IS NULL THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND geom IS NULL THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN geom IS NULL THEN 1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="nummeraanduiding/search.php?behaviour=geenpostcode&<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Nummeraanduiding</td>
		<td>Missende postcode</td>
<?php
	$sql = "SELECT\n";
	$sql .= "SUM(CASE WHEN authentic = 'Y' AND postcode IS NULL THEN  1 ELSE 0 END) AS AUTHENTIC,\n";
	$sql .= "SUM(CASE WHEN authentic = 'N' AND postcode IS NULL THEN  1 ELSE 0 END) AS OTHER,\n";
	$sql .= "SUM(CASE WHEN postcode IS NULL THEN 1 ELSE 0 END) AS TOTAL\n";
	$sql .= "FROM  VB_NUMMERAANDUIDING\n";
	$sql .= "WHERE EXPIREDATE = 99999999999999\n";
	$records = getRecords($connection, $sql);
	$authentiek = $records[0]['AUTHENTIC'];
	$overig = $records[0]['OTHER'];
	$totaal = $records[0]['TOTAL'];
	
	if($authentiek > 0) {
		$statuscolor = "red";
	}
	else if($overig > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($authentiek); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($overig); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
	<tr>
		<td>
			<a href="synchronisatie/brs.php?<?php echo(getCurrentPageParameter())  ?>">
				<img alt="details" src="image/detail.gif">
			</a>
		</td>
		<td>Synchronisatie</td>
		<td>Missend (wel in BRS)</td>
<?php
	$sql = "SELECT *\n"; 
	$sql .= "FROM brsadresunknown\n"; 
	$sql .= "WHERE ROWNUM = 1\n"; 	
	$records = getRecords($connection, $sql);
	$aantal = array();
	$aantal = sizeof($records);
	if($aantal > 0) {
?>
		<td colspan="3" style="background-color: red">
			Database verschillen gevonden!
		</td>
<?php	
	}
	else {
?>	
		<td colspan="3" style="background-color: green">
			Database vergelijking succesvol!
		</td>
<?php		
	}	
?>
	</tr>
</table>
<h2>Geschiedenis gegevens</h2>
<p>
	<a href="geschiedenis/search.php?<?php echo(getCurrentPageParameter())  ?>">
		<img alt="details" src="image/detail.gif">
	</a>
	Hier kunt u de geschiedenis van de gegevens bekijken.
</p>
</body>
</html>
<?php
	$connection = null;
?>