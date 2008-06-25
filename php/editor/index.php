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
		<th>Bag relevant</th>
		<th>Additionele</th>
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_WOONPLAATS\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE\n";
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE EINDEGELDIGHEID IS NULL\n";
	$records = getRecords($connection, $sql);
?>
		<!-- 
<?php echo($sql) ?> 
		-->
		<td><?php echo($records[0]['RELEVANT']); ?></td>
		<td><?php echo($records[0]['ADDITIONEEL']); ?></td>
		<td><?php echo($records[0]['TOTAAL']); ?></td>		
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_OPENBARERUIMTE\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE\n";
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";	
	$records = getRecords($connection, $sql);
?>
		<!-- 
<?php echo($sql) ?> 
		-->
		<td><?php echo($records[0]['RELEVANT']); ?></td>
		<td><?php echo($records[0]['ADDITIONEEL']); ?></td>
		<td><?php echo($records[0]['TOTAAL']); ?></td>		
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$records = getRecords($connection, $sql);
?>
		<!-- 
<?php echo($sql) ?> 
		-->
		<td><?php echo($records[0]['RELEVANT']); ?></td>
		<td><?php echo($records[0]['ADDITIONEEL']); ?></td>
		<td><?php echo($records[0]['TOTAAL']); ?></td>		
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_WOONPLAATS\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_AUTHENTIEK.INONDERZOEK = 1\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<!-- 
<?php echo($sql) ?> 
		-->
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_OPENBARERUIMTE\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_AUTHENTIEK.INONDERZOEK = 1\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<!-- 
<?php echo($sql) ?> 
		-->
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_OPENBARERUIMTE\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND  DATA_OPENBARERUIMTE.WOONPLAATS_CODE IS NULL\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
	$sql = "SELECT COUNT(*) AS TOTAAL\n";
	$sql .= "FROM (\n";
	$sql .= "  SELECT DISTINCT\n";
	$sql .= "    DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISLETTER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,\n";
	$sql .= "    COUNT(*) AS AANTAL\n";
	$sql .= "  FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "  LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "  ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";
	$sql .= "  LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "  ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "  AND DATA_OBJECT.BAGOBJECT = 1\n";
	$sql .= "  WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "  GROUP BY \n";
	$sql .= "    DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE, \n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMER, \n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISLETTER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING\n";
	$sql .= ")\n";
	$sql .= "WHERE AANTAL > 1\n";
	$records = getRecords($connection, $sql);
	echo("<!-- $sql -->");
	$relevant = $records[0]['TOTAAL'];
	$sql = "SELECT COUNT(*) AS TOTAAL\n";
	$sql .= "FROM (\n";
	$sql .= "  SELECT DISTINCT\n";
	$sql .= "    DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISLETTER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,\n";
	$sql .= "    COUNT(*) AS AANTAL\n";
	$sql .= "  FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "  LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "  ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";
	$sql .= "  LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "  ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "  AND DATA_OBJECT.BAGOBJECT = 1\n";
	$sql .= "  WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "  GROUP BY \n";
	$sql .= "    DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE, \n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMER, \n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISLETTER,\n";
	$sql .= "    DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING\n";
	$sql .= ")\n";
	$sql .= "WHERE AANTAL > 1\n";
	$records = getRecords($connection, $sql);
	echo("<!-- $sql -->");
	$totaal = $records[0]['TOTAAL'];
	$additoneel = $totaal - $relevant;
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
		<td>Postcode niet uniek(niet fout!)</td>
<?php
	$sql = "SELECT COUNT(*) AS TOTAAL\n";
	$sql .= "FROM\n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT \n";
	$sql .= "    POSTCODE,\n";
	$sql .= "    COUNT(OPENBARERUIMTE_CODE) AS AANTAL\n";
	$sql .= "  FROM \n";
	$sql .= "  (\n";
	$sql .= "    SELECT DISTINCT\n";
	$sql .= "      DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "      DATA_NUMMERAANDUIDING.POSTCODE\n";
	$sql .= "    FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "    LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "    ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";
	$sql .= "    LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "    ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "    AND DATA_OBJECT.BAGOBJECT = 1\n";
	$sql .= "    WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "    GROUP BY \n";
	$sql .= "      DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "      DATA_NUMMERAANDUIDING.POSTCODE\n";
	$sql .= "  )\n";
	$sql .= "  GROUP BY POSTCODE\n";
	$sql .= ")\n";
	$sql .= "WHERE AANTAL > 1\n";
	$records = getRecords($connection, $sql);
	echo("<!-- $sql -->");	
	$relevant = $records[0]['TOTAAL'];
	$sql = "SELECT COUNT(*) AS TOTAAL\n";
	$sql .= "FROM\n";
	$sql .= "(\n";
	$sql .= "  SELECT DISTINCT \n";
	$sql .= "    POSTCODE,\n";
	$sql .= "    COUNT(OPENBARERUIMTE_CODE) AS AANTAL\n";
	$sql .= "  FROM \n";
	$sql .= "  (\n";
	$sql .= "    SELECT DISTINCT\n";
	$sql .= "      DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "      DATA_NUMMERAANDUIDING.POSTCODE\n";
	$sql .= "    FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "    LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "    ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";
	$sql .= "    LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "    ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "    WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "    GROUP BY \n";
	$sql .= "      DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE,\n";
	$sql .= "      DATA_NUMMERAANDUIDING.POSTCODE\n";
	$sql .= "  )\n";
	$sql .= "  GROUP BY POSTCODE\n";
	$sql .= ")\n";
	$sql .= "WHERE AANTAL > 1\n";
	$records = getRecords($connection, $sql);
	echo("<!-- $sql -->");	
	$totaal = $records[0]['TOTAAL'];
	$additoneel = $totaal - $relevant;
	if($totaal > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_AUTHENTIEK.INONDERZOEK = 1\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
		<td>Missende openbareruimte</td>
<?php
	$sql = "SELECT\n";
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE IS NULL\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
		<td>Missende coordinaten</td>
<?php
	$sql = "SELECT\n";
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_NUMMERAANDUIDING.PUNT IS NULL\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "red";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
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
		<td>Missende postcode(niet fout!)</td>
<?php
	$sql = "SELECT\n";
	$sql .= "COALESCE(SUM(DATA_OBJECT.BAGOBJECT), 0) AS RELEVANT,\n";
	$sql .= "COALESCE(SUM(1 - DATA_OBJECT.BAGOBJECT), 0) AS ADDITIONEEL,\n";
	$sql .= "COUNT(*) AS TOTAAL\n";
	$sql .= "FROM DATA_NUMMERAANDUIDING\n";
	$sql .= "LEFT OUTER JOIN DATA_AUTHENTIEK\n";
	$sql .= "ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE\n";	
	$sql .= "LEFT OUTER JOIN DATA_OBJECT\n";
	$sql .= "ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE\n";
	$sql .= "WHERE DATA_AUTHENTIEK.EINDEGELDIGHEID IS NULL\n";
	$sql .= "AND DATA_NUMMERAANDUIDING.POSTCODE IS NULL\n";
	$records = getRecords($connection, $sql);
	$relevant = $records[0]['RELEVANT'];
	$additoneel = $records[0]['ADDITIONEEL'];
	$totaal = $records[0]['TOTAAL'];
	
	if($relevant > 0) {
		$statuscolor = "orange";
	}
	else if($additoneel > 0) {
		$statuscolor = "orange";
	}
	else {
		$statuscolor = "green";
	}	
?>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($relevant); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($additoneel); ?>
		</td>
		<td style="background-color: <?php echo($statuscolor); ?>;">
			<?php echo($totaal); ?>
		</td>
	</tr>
</table>
<!--
<h2>Geschiedenis gegevens</h2>
<p>
	<a href="geschiedenis/search.php?<?php echo(getCurrentPageParameter())  ?>">
		<img alt="details" src="image/detail.gif">
	</a>
	Hier kunt u de geschiedenis van de gegevens bekijken.
</p>
-->
</body>
</html>
<?php
	$connection = null;
?>