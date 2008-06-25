<?php
header("Content-Type:text/html;charset=utf-8");

include_once "../../common/util/soapsettings.php";
include_once "../../common/bag/adres.php";

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

$urlfilter = "?";
if(isset($_REQUEST['straatnaam'])) {
	$straatnaam = $_REQUEST['straatnaam'];
	$urlfilter .= 'straatnaam=' . $_REQUEST['straatnaam'] . '&';
}
if(isset($_REQUEST['huisnummer'])) {
	$huisnummer = $_REQUEST['huisnummer'];
	$urlfilter .= 'huisnummer=' . $_REQUEST['huisnummer'] . '&';
}
if(isset($_REQUEST['huisletter'])) {
	$huisletter = $_REQUEST['huisletter'];
	$urlfilter .= 'huisletter=' . $_REQUEST['huisletter'] . '&';
}
if(isset($_REQUEST['huistoevoeging'])) {
	$huistoevoeging = $_REQUEST['huistoevoeging'];
	$urlfilter .= 'huistoevoeging=' . $_REQUEST['huistoevoeging'] . '&';
}
if(isset($_REQUEST['woonplaats'])) {
	$woonplaats = $_REQUEST['woonplaats'];
	$urlfilter .= 'woonplaats=' . $_REQUEST['woonplaats'] . '&';
}
if(isset($_REQUEST['postcode'])) {
	$postcode = $_REQUEST['postcode'];
	$urlfilter .= 'postcode=' . $_REQUEST['postcode'] . '&';
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
// maybe we are a postback!
$showrequiredfields = false;
if(isset($_REQUEST['action-cancel'])) {
	header("Location: adresdetail.php$urlfilter");
	exit();
}
else if(isset($_REQUEST['action-send'])) {
	if(!empty($_REQUEST['part']) && !empty($_REQUEST['feedback'])) {
		$part = $_REQUEST['part'];
		$feedback = $_REQUEST['feedback'];
		$client->Terugmelding($adresfilter, $_SERVER['REMOTE_USER'], $part, $feedback);
		
		header("Location: adresdetail.php$urlfilter");
		exit();		
	}
	else {
		$showrequiredfields = true;
	}
}
$adressen = $client->ZoekAdresMetFilter($adresfilter);
if(!isset($adressen)) die("adres niet gevonden");
if(sizeof($adressen) != 1) die("aantal adressen niet gelijk aan 1");
$adres = $adressen[0];
?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>Adres details</title>
	<link  type="text/css" rel="stylesheet" href="style.css"> </link>
	<script language="JavaScript">
		function onGisObjectClick(layername, objectkey) {
			window.location.href = "adresdetail.php?" + objectkey;
		}
		<?php if($showrequiredfields) { ?>
		alert("De velden 'onderdeel' en 'opmerking' moeten een waarde hebben");
		<?php } //if($showrequiredfields) ?>
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
				</table>				
			</td>
			<td>
			
<?php 
	$viewerheight = 250;
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
		<form method="post" action="">
		<tr>				
				<th colspan="2">
					Terugmelden opmerkingen:
<!--					
					<input type="hidden" name="straatnaam" value="<?php echo($straatnaam) ?>" />
					<input type="hidden" name="huisnummer" value="<?php echo($huisnummer) ?>" />
					<input type="hidden" name="huisletter" value="<?php echo($huisletter) ?>" />
					<input type="hidden" name="huistoevoeging" value="<?php echo($huistoevoeging) ?>" />
					<input type="hidden" name="postcode" value="<?php echo($postcode) ?>" />
-->					
				</th>
		</tr>		
		<tr>
				<td>Onderdeel:</td>
				<td>
					<input type="radio" name="part" value="nummeraanduiding">Nummeraanduiding</input>
					<br />
					<input type="radio" name="part" value="openbareruimte" disabled="disabled">Openbareruimte</input>
					<br />
					<input type="radio" name="part" value="woonplaats" disabled="disabled">Woonplaats</input>					
				</td>			
		</tr>
		<tr>
				<td>Gebruiker:</td>
				<td>
					<?php echo($_SERVER['REMOTE_USER']); ?>
				</td>
		</tr>
		<tr>
				<td>Opmerking:</td>
				<td>
					<textarea name="feedback" cols="60" rows="5"></textarea>
				</td>
		</tr>
		<tr>
				<td colspan="2"><hr /></td>
		</tr>
		<tr>
				<td>
				</td>
				<td>
					<input type="reset" name="action-reset" value="Beginwaarden">
					<input type="submit" name="action-cancel" value="Annuleren">
					<input type="submit" name="action-send" value="Verzenden gegevens">
				</td>
		</tr>		
		</form>
	</table>	
</html>
