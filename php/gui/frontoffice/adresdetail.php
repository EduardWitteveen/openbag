<?php
header("Content-Type:text/html;charset=utf-8");

include_once "../include/util/soapsettings.php";
include_once "../include/bag/adres.php";

$client = getSoapClient("bag-soapclient");
// find our record:
$authentiek = null;
$woonplaatsauthentiek = null; 
$openbareruimteauthentiek = null;
$nummeraanduidingauthentiek = null;

$onderzoek = null;
$woonplaatsonderzoek = null;
$openbareruimteonderzoek = null;
$nummeraanduidingonderzoek = null;

$woonplaatsterugmelding = null;
$openbareruimteterugmelding = null;
$nummeraanduidingterugmelding = null;

$straatnaam = null;
$huisnummer = null;
$huisletter = null;
$huistoevoeging = null;
$woonplaats = null;
$postcode = null;

if(isset($_REQUEST['straatnaam'])) {
	$straatnaam = $_REQUEST['straatnaam'];
}
if(isset($_REQUEST['huisnummer'])) {
	$huisnummer = $_REQUEST['huisnummer'];
}
if(isset($_REQUEST['huisletter'])) {
	$huisletter = $_REQUEST['huisletter'];
}
if(isset($_REQUEST['huistoevoeging'])) {
	$huistoevoeging = $_REQUEST['huistoevoeging'];
}
if(isset($_REQUEST['huistoevoeging'])) {
	$huistoevoeging = $_REQUEST['huistoevoeging'];
}
if(isset($_REQUEST['woonplaats'])) {
	$woonplaats = $_REQUEST['woonplaats'];
}
if(isset($_REQUEST['postcode'])) {
	$postcode = $_REQUEST['postcode'];
}

$adresfilter = new Adres(
	$authentiek, 
	$woonplaatsauthentiek, 
	$openbareruimteauthentiek, 
	$nummeraanduidingauthentiek, 
	$onderzoek,
	$woonplaatsonderzoek,
	$openbareruimteonderzoek,
	$nummeraanduidingonderzoek,
	$woonplaatsterugmelding,
	$openbareruimteterugmelding,
	$nummeraanduidingterugmelding,
	$straatnaam, 
	$huisnummer, 
	$huisletter, 
	$huistoevoeging, 
	$woonplaats, 
	$postcode
);
$adresfilter  = new SoapVar($adresfilter, SOAP_ENC_OBJECT, 'Adres', 'urn:bag');
$adressen = $client->ZoekAdresMetFilter($adresfilter);
if(!isset($adressen)) die("adres niet gevonden");
if(sizeof($adressen) != 1) die("aantal adressen niet gelijk aan 1");
$adres = $adressen[0];
?><?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>Adres details</title>
	<link  type="text/css" rel="stylesheet" href="style.css"> </link>
	<script language="JavaScript">
		function onGisObjectClick(layername, objectkey) {
			window.location.href = "adresdetail.php?" + objectkey;
		}
	</script>
</head>	
<body>
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<th>Straatnaam</th>
						<td><?php echo($adres->straatnaam) ?></td>
					</tr>
					<tr>
						<th>Huisnummer</th>
						<td><?php echo($adres->huisnummer) ?></td>
					</tr>
					<tr>
						<th>Huisletter</th>
						<td><?php echo($adres->huisletter) ?></td>
					</tr>		
					<tr>
						<th>Huistoevoeging</th>
						<td><?php echo($adres->huistoevoeging) ?></td>
					</tr>		
					<tr>
						<th>Woonplaats</th>
						<td><?php echo($adres->woonplaats) ?></td>
					</tr>		
					<tr>
						<th>Postcode</th>
						<td><?php echo($adres->postcode) ?></td>
					</tr>
					<tr>						
						<td colspan="2">
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<center>
								<a href="adresfeedback.php?<?php echo($_SERVER['QUERY_STRING']) ?>">
									<img alt="lever commentaar" src="image/feedback.gif" />
								</a>
							</center>
						</td>
					</tr>
				</table>				
			</td>
			<td>
			
<?php 
	$viewerheight = 350;
	$viewerwidth = 450;
	$viewerhtml = $client->GisHtmlViewAdresMetFilter($adresfilter, $viewerheight, $viewerwidth);	
?>				
				<?php echo($viewerhtml); ?>
			</td>
		</tr>
		<tr>		
			<td colspan="2">
				<hr>
			</td>
		</tr>
		<tr>		
			<td colspan="2">
				<table>
					<tr>
						<th></th>
						<th>Woonplaats</th>
						<th>Openbareruimte</th>
						<th>Nummeraanduiding</th>
					</tr>
					<tr>
						<th>Authentiek</th>
						<td>
							<img 	
								alt="<?php echo($adres->woonplaatsauthentiek == 1?'Authentiek':'NIET authentiek') ?> gegevens" 
								src="image/authentiek_<?php echo($adres->woonplaatsauthentiek) ?>.gif"
							/>
						</td>
						<td>
							<img 	
								alt="<?php echo($adres->openbareruimteauthentiek == 1?'Authentieke':'NIET authentiek') ?> gegevens" 
								src="image/authentiek_<?php echo($adres->openbareruimteauthentiek) ?>.gif"
							/>					
						</td>
						<td>
							<img 	
								alt="<?php echo($adres->nummeraanduidingauthentiek == "Y"?'Authentieke':'NIET authentiek') ?> gegevens" 
								src="image/authentiek_<?php echo($adres->nummeraanduidingauthentiek) ?>.gif"
							/>					
						</td>
					</tr>
					<tr>
						<th>Betrouwbaarheid</th>
						<td>
							<img 
								alt="<?php echo($adres->woonplaatsonderzoek == "Y"?'Geen opmerkingen':'Opmerkingen geplaatst') ?> gegevens" 
								src="image/onderzoek_<?php echo($adres->woonplaatsonderzoek) ?>.gif"
							/>
						</td>
						<td>
							<img 
								alt="<?php echo($adres->openbareruimteonderzoek == "Y"?'Geen opmerkingen':'Opmerkingen geplaatst') ?> gegevens" 
								src="image/onderzoek_<?php echo($adres->openbareruimteonderzoek) ?>.gif"
							/>
						</td>
						<td>
							<img 
								alt="<?php echo($adres->nummeraanduidingonderzoek == "Y"?'Geen opmerkingen':'Opmerkingen geplaatst') ?> gegevens" 
								src="image/onderzoek_<?php echo($adres->nummeraanduidingonderzoek) ?>.gif"
							/>
						</td>
					</tr>
					<tr>
						<th>Terugmelding</th>
						<td><?php echo($adres->woonplaatsterugmelding) ?></td>
						<td><?php echo($adres->openbareruimteterugmelding) ?></td>
						<td><?php echo($adres->nummeraanduidingterugmelding) ?></td>
					</tr>
				</table>				
			</td>
		</tr>
	</table>	
</html>
