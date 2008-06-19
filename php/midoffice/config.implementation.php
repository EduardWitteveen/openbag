<?php
include_once "../common/config/setting.php";

class config {
	public function Version() {
		return 'config-voorlopig-0.1';
	}
	public function ConfigSettings($filter) {
		$settings = array();
		$setting = new Setting($filter. "-filter", $filter);
		if($filter == "bag-soapclient") {
			$wsdl = getURL("/midoffice/voorlopig/bag.php?wsdl");
			$setting = new Setting("soapclient-wsdl", $wsdl);
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
			
			$options = array();
			// TO USE THE PROXY
			$setting = new Setting("soapclient-options", http_build_query($options));
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');									
		}
		elseif($filter == "bag-oracle") {
			$setting = new Setting('oracle-username', '');
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
			$setting = new Setting('oracle-password', '');
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
			$setting = new Setting('oracle-tnsname', '(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = orascleerver)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8');
//			$setting = new Setting('oracle-tnsname', '(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = orascleerver)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=WE8ISO8859P1');
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');			
		}
		elseif($filter == "bag-gis") {		
			$viewerurl =  '<iframe id="gisviewer" SCROLLING="NO" FRAMEBORDER="0" width="%width%" height="%height%" src="' .  getURL("/gis/voorlopig/viewer.php") . '?minx=%minx%&miny=%miny%&maxx=%maxx%&maxy=%maxy%&height=%height%&width=%width%&"></iframe>';
			$setting = new Setting('gis-adres-detail', "$viewerurl\n");
			$settings[] = new SoapVar($setting, SOAP_ENC_OBJECT, 'Setting', 'urn:config');
		}
		else return new SoapFault("Config", "Config:Settings filter with name '$filter' is unknown!");
		return $settings;
	}
}
?>