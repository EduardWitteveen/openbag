<?php
include_once "../include/config/setting.php";

class config {
	public function Version() {
		return 'config-voorlopig-0.1';
	}
	public function ConfigSettings() {
		$settings = array();
		//$setting = new Setting($filter. "-filter", $filter);
		
		$configfile = getcwd() . '/../../config.php';
		if(!file_exists($configfile)) {
			return new SoapFault("config error", "config file: $configfile did not exist");
		}
		$config = parse_ini_file($configfile, true);

		$bagservice = getURL($config['midoffice']['bagservice']);		
		$setting = new Setting("bagservice", $bagservice);
		$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');		
		
//		$baggis = getURL($config['midoffice']['baggis']);
//		$setting = new Setting("baggis", $bagservice);
//		$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');

		$internet = $config['internet'];
		if(!is_array($internet)) {
			$internet = array();
		}			
		$setting = new Setting("soapclient-options", http_build_query($internet));
		$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');									
		
		return $settings;
	}
}
?>