<?php
header("Content-Type:text/html;charset=utf-8");

include_once "../common/util/url.php";
include_once "config.implementation.php";

// disabling WSDL cache (4 debugging)
ini_set("soap.wsdl_cache_enabled", "0"); 

if(!isset($HTTP_RAW_POST_DATA)) {
	// make the parameters working
	$HTTP_RAW_POST_DATA = file_get_contents('php://input');
}

//$options = array('uri' => getURL("bag.php"));
$server = new SoapServer(getURL("config.wsdl.php"));
$server->setClass('config');
$server->handle();
?>
