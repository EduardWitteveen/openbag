<?php
header("Content-Type:text/html;charset=utf-8");

include_once "../include/util/soapsettings.php";
include_once "../include/bag/adres.php";

	$client = getBagSoapClient();
	$filter = $_REQUEST['filter'];
	$filter =  new SoapVar($filter, XSD_STRING, 'string', 'http://www.w3.org/2001/XMLSchema');
	$gishtml = $client->GisHtmlViewAdres($filter, 550, 750);
?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>BAG voorlopige applicatie (<?php echo($client->Version()) ?>)</title>
	<script language="JavaScript">
		function onGisObjectClick(layername, objectkey) {
			window.location.href = "adresdetail.php?" + objectkey;
		}
	</script>
</head>
<body>
<?php echo($gishtml) ?>
</body>
</html>