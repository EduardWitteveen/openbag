<?php

include_once "url.php";

function getMidofficeConfig() {
	try {
		$configfile = getcwd() . '/../../config.php';
		file_exists($configfile) || die("config file: $configfile did not exist");
		$config = parse_ini_file($configfile, true);
		$options = $config['internet'];
		//print_r($options);
		if(!is_array($options)) {
			$options = array();
		}
		$url = getURL($config['frontoffice']['midoffice']);
		//echo($url);
		$client = new SoapClient($url, $options);		
		// convert the settings to something workable
		$retrievedsettings = $client->ConfigSettings();
		//print_r($retrievedsettings);
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
		$settings = getMidofficeConfig();
		//print_r($settings);
		$bagwsdlurl = $settings["bagservice"];
		$options = $settings["soapclient-options"]; 
		parse_str($options, $options);
		foreach($options as $key => $value) {
			// stupid options requires the proxyport to be a integer
			if($key == 'proxy_port') {
				$options[$key] = intval($value); 
			}						
		}
		//print_r($options);
		$client = new SoapClient($bagwsdlurl, $options);
		//print_r($client);
		return $client;
	}
	catch(SoapFault $e) {
		// print error
		?><pre style="color:red; background: white;"><?php print_r($e) ?></pre><?php		
	}
}
?>