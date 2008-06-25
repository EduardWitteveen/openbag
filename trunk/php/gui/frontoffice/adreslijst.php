<?php
header("Content-Type:text/html;charset=utf-8"); 

if(!isset($_SERVER['REMOTE_USER'])) {
	//die('[[SSPI not active]]');
}

include_once "../include/util/soapsettings.php";
include_once "../include/bag/adres.php";

function echoAdressen($adressen) {
	?>
	<hr />
	<div id="tableContainer" class="tableContainer">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable">
		<thead class="fixedHeader">
			<tr>				
				<th><!-- authentiek -->&nbsp;</th>
				<th><!-- onderzoek -->&nbsp;</th>
				<th>straat</th>
				<th>nummer</th>
				<th>letter</th>
				<th>toevoeging</th>
				<th>woonplaats</th>
				<th>postcode</th>				
			</tr>
		</thead>
		<tbody class="scrollContent">
	<?php
	foreach ($adressen as $adres) {
		//$straatnaam = stringreplace($adres->straatnaam, "'", "\\'");
		$details = "adresdetail('". urlencode($adres->straatnaam) . "', 
					'". urlencode($adres->huisnummer) . "', 
					'". urlencode($adres->huisletter) . "', 
					'". urlencode($adres->huistoevoeging) . "',
					'". urlencode($adres->postcode) . "'
					);";
		?>
			<tr 
				onMouseOver="this.bgColor='<?php echo($adres->authentiek == "Y"?'#8888FF':'red') ?>';" 
				onMouseOut="this.bgColor='white';"
				onClick="<?php echo($details) ?>"
			>
				<td>
					<img 	
						alt="<?php echo($adres->authentiek == "Y"?'Authentieke':'NIET authentiek') ?> gegevens" 
						src="image/authentiek_<?php echo($adres->authentiek) ?>.gif"
					/>
				</td>
				<td>
					<img 
						alt="<?php echo($adres->onderzoek == "Y"?'Geen opmerkingen':'Opmerkingen geplaatst') ?> gegevens" 
						src="image/onderzoek_<?php echo($adres->onderzoek) ?>.gif"
					/>
				</td>
				<td>
					<?php echo($adres->straatnaam) ?>&nbsp;
				</td>
				<td>
					<?php echo($adres->huisnummer) ?>&nbsp;
				</td>
				<td>
					<?php echo($adres->huisletter) ?>&nbsp;
				</td>
				<td>
					<?php echo($adres->huistoevoeging) ?>&nbsp;
				</td>
				<td>
					<?php echo($adres->woonplaats) ?>&nbsp;
				</td>
				<td>
					<?php echo($adres->postcode) ?>&nbsp;
				</td>				
			</tr>
			</a>
		<?php
	}
	?>
		</tbody>
	</table>
	</div>
	<?php
}
	$client = getSoapClient('bag-soapclient');
?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html>
<head>
	<title>BAG voorlopige applicatie (<?php echo($client->Version()) ?>)</title>
	<link  type="text/css" rel="stylesheet" href="style.css"> </link>
	<link  type="text/css" rel="stylesheet" href="scrolltable.css"> </link>
	<script type="text/javascript" src="window.js"> </script>
	<script type="text/javascript">	
	function adresdetail(straatnaam, huisnummer, huisletter, huistoevoeging, postcode) {
		//showmodaldialog(nummeraanduidingid);
		showmodaldialog("adresdetail.php?straatnaam=" + straatnaam  + "&huisnummer=" + huisnummer + "&huisletter=" + huisletter + "&huistoevoeging=" + huistoevoeging + "&postcode=" + postcode + "&");
	}
	function gisviewer(filter) {
		//showmodaldialog(nummeraanduidingid);
		showmodaldialog("adresgis.php?filter=" + filter  + "&");
	}
	</script> 
</head>
<body onload="document.adresform.filter.focus();">
<div id="modaldialog">
	<div>
		<a href="javascript:hidemodaldialog();">
			<img src="image/close.gif" />
		</a>
		Details
	</div>
	<iframe></iframe>
</div>
<form name="adresform">
	<p>Zoek een adres:
	<input 
		type="text" 
		name="filter" 
		value="<?php
			if(isset($_REQUEST['filter']) && !empty($_REQUEST['filter'])) {
				echo $_REQUEST['filter'];
			}			
		?>"
		onKeyDown="if (window.event.keyCode==13) adresform.submit;"
	>
	<input 
		type="submit" 
		value="zoek"
	>	
	</p>                                                            
</form>
<?php	
	if(isset($_REQUEST['filter']) && !empty($_REQUEST['filter'])) {
		$filter = $_REQUEST['filter'];
		$filter =  new SoapVar($filter, XSD_STRING, 'string', 'http://www.w3.org/2001/XMLSchema');
		$adressen = $client->ZoekAdres($filter);
		if(isset($adressen) && sizeof($adressen) > 0) {
			echoAdressen($adressen);
		}
		else {
			?><div style="color:red; background: white;">Geen adressen gevonden voor filter: <?php echo($_REQUEST['filter']) ?></div><?php
		}
	}	
	// footer
	?>
		<p>Bekijk huidige selectie in de <input type="submit" value="gisviewer" onclick="gisviewer(adresform.filter.value);"></p>
		<p class="footer">
			Eduard Witteveen
			-
			2008
		</p>
</body>
</html>