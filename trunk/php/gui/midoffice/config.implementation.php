<?php
include_once "../include/config/setting.php";

class config {
	public function Version() {
		return 'config-voorlopig-0.1';
	}
	public function ConfigSettings($filter) {
		$settings = array();
		$setting = new Setting($filter. "-filter", $filter);
		$configfile = getcwd() . '/../../config.php';
		$config = parse_ini_file($configfile, true);		
		if($filter == "bag-soapclient") {
			$wsdl = getURL($config['midoffice']['bag-wsdl']);
			$setting = new Setting("soapclient-wsdl", $wsdl);
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');			
			$internet = $config['internet'];
			if(!is_array($internet)) {
				$internet = array();
			}			
			$setting = new Setting("soapclient-options", http_build_query($internet));
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');									
		}
//		elseif($filter == "bag-oracle") {
//			$setting = new Setting('oracle-username', $config['database']['username']);
//			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
//			$setting = new Setting('oracle-password', $config['database']['password']);
//			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
//			$setting = new Setting('oracle-tnsname', $config['database']['tnsname']);
//			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');			
//		}
//		elseif($filter == "bag-gis") {		
//			$viewerurl =  '<iframe id="gisviewer" SCROLLING="NO" FRAMEBORDER="0" width="%width%" height="%height%" src="' .  getURL("/gis/voorlopig/viewer.php") . '?minx=%minx%&miny=%miny%&maxx=%maxx%&maxy=%maxy%&height=%height%&width=%width%&"></iframe>';
//			$setting = new Setting('gis-adres-detail', "$viewerurl\n");
//			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
//		}
		else return new SoapFault("Config", "Config:Settings filter with name '$filter' is unknown!");
		return $settings;
	}
}
?>