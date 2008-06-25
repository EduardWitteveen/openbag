 <?php
 
include_once "../../common/util/url.php";
include_once "../../common/bag/adres.php";

function echoAdressen($adressen) {
	?>
	<table>
		<tr>
			<th>woonplaatsid</th>
			<th>openbareruimteid</th>
			<th>nummeraanduidingid</th>
			<th>authentiek</th>
			<th>onderzoek</th>
			<th>straatnaam</th>
			<th>huisnummer</th>
			<th>huisletter</th>
			<th>huistoevoeging</th>
			<th>woonplaats</th>
			<th>postcode</th>
		</tr>
	<?php
	foreach ($adressen as $adres) {
		// remove the soap stuff:		
		?>
		<tr>
			<td><?php echo($adres->woonplaatsid) ?></td>
			<td><?php echo($adres->openbareruimteid) ?></td>
			<td><?php echo($adres->nummeraanduidingid) ?></td>
			<td><?php echo($adres->authentiek) ?></td>
			<td><?php echo($adres->onderzoek) ?></td>
			<td><?php echo($adres->straatnaam) ?></td>
			<td><?php echo($adres->huisnummer) ?></td>
			<td><?php echo($adres->huisletter) ?></td>
			<td><?php echo($adres->huistoevoeging) ?></td>
			<td><?php echo($adres->woonplaats) ?></td>
			<td><?php echo($adres->postcode) ?></td>
		</tr>
		<?php
	}
	?>
	</table>
	<?php
}

try {
	$opties = array('proxy_host'     => "localhost",
                                            'proxy_port'     => 8888,
                                            'proxy_login'    => "ew886",
                                            'proxy_password' => "12345678");
	$client = new SoapClient(getURL("../..//midoffice/voorlopig/bag.php?wsdl"), $opties);

	// versie	
	?><h3>Version: <?php echo($client->Version()) ?></h3><?php

	// zoek adres (spiekersteeg 2)
	$adressen = $client->ZoekAdres('pieker 2');
	?>
	<h3>Zoek adres:</h3>
	<?php
	echoAdressen($adressen);
	
	// zoek adres met filter (spiekersteeg 2)
	$filter = new Adres(
		null,	// woonplaatsid
		null,	// openbareruimteid
		"EA0BBBC3B6B44993A218E73698A51A84",	// nummeraanduidingid
		null,	// authentiek
		null,	// onderzoek
		null, 	// straatnaam
		null,	// huisnummer
		null,	// huisletter
		null,	// huistoevoeging
		null,	// woonplaats
		null	// postcode	
	);	
	$adressen = $client->ZoekAdresMetFilter(new SoapVar($filter, SOAP_ENC_OBJECT, 'Adres', 'urn:bag'));
	?>
	<h3>Zoek adres met filter:</h3>
	<?php
	echoAdressen($adressen);
}
catch(SoapFault $e) {
	// print error
	?><pre><?php print_r($e) ?></pre><?php		
}
?> 