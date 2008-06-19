<?php

include_once "url.php";

function getSettings($filter) {
	try {
		$options = array();
		// TO USE THE PROXY
/*
		$options = array(
				'proxy_host'     => "localhost",
			 	'proxy_port'     => 8888,
                     	'proxy_login'    => "ew886",
                        'proxy_password' => "12345678"
			);
*/
/*
		$options = array(
				'proxy_host'     => "localhost",
			 	'proxy_port'     => 8888
			);
*/
		$client = new SoapClient(getURL("../../midoffice/config.php?wsdl"), $options);
		// convert the settings to something workable
		$retrievedsettings = $client->ConfigSettings($filter);
		$settings = array();
		foreach($retrievedsettings as $setting) {
			$settings[$setting->key] = $setting->value;			
		}
		return $settings;
	}
	catch(SoapFault $e) {
		// print error
		?><pre style="color:red; background: white;"><?php print_r($e) ?></pre><?php		
	}
}
function getSoapClient($configfilter) {
	try {
		$settings = getSettings($configfilter);				
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
