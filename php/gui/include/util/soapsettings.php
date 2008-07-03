<?php

include_once "url.php";

function getMidofficeConfig($filter) {
	try {
		$configfile = getcwd() . '/../../config.php';
		$config = parse_ini_file($configfile, true);
		$options = $config['internet'];
		if(!is_array($options)) {
			$options = array();
		}
		$url = getURL($config['frontoffice']['config']);
		// echo($url);
		$client = new SoapClient($url, $options);
		// convert the settings to something workable
		$retrievedsettings = $client->ConfigSettings($filter);
		print_r($retrievedsettings);
		$settings = array();
		foreach($retrievedsettings as $setting) {
			$settings[$setting->key] = $setting->value;			
		}
		//print_r($settings);
		return $settings;
	}
	catch(SoapFault $e) {
		// print error
		?><pre style="color:red; background: white;"><?php print_r($e) ?></pre><?php		
	}
}
function getBagSoapClient() {
	try {
		$settings = getMidofficeConfig('bag-soapclient');
		print_r($settings);
		$wsdl = $settings["soapclient-wsdl"];
		$options = $settings["soapclient-options"]; 
		parse_str($options, $options);
		foreach($options as $key => $value) {
			// stupid options requires the proxyport to be a integer
			if($key == 'proxy_port') {
				$options[$key] = intval($value); 
			}						
		}
		$client = new SoapClient($wsdl, $options);
		return $client;
	}
	catch(SoapFault $e) {
		// print error
		?><pre style="color:red; background: white;"><?php print_r($e) ?></pre><?php		
	}
}
?>