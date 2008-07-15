<?php
include_once "../../include/bag/adres.php";
include_once "../../include/util/logging.php";

class bag {
	private function addContainsStatement($fieldname, $fieldvalue, $whereclause, $operator) {
		// $whereclause should always be defined, say incase of no filters		 
		if(!empty($fieldvalue)) {
			$fieldvalue = str_replace("'", "''", $fieldvalue);
			// case insensitive
//USE THE SAME TO UPPER FUNCTION, OTHERWISE PROBLEMS WITH � to �
//			$fieldvalue = strtoupper($fieldvalue);
//			$condition = "UPPER($fieldname) LIKE('%$fieldvalue%')\n";
			$condition = "UPPER($fieldname) LIKE(UPPER('%$fieldvalue%'))\n";
			if(empty($whereclause)) {
				return $condition;
			}
			else {
				return "$whereclause $operator $condition";
			}
		}
		else {
			return $whereclause;
		}
	}
	private function addEqualsStatement($fieldname, $fieldvalue, $whereclause, $operator) {
		// $whereclause should always be defined, say incase of no filters		 
		if(!is_null($fieldvalue)){
			if(!is_numeric($fieldvalue) && empty($fieldvalue)) {
				$condition = "$fieldname IS NULL";
			}			
			else {			
				$fieldvalue = str_replace("'", "''", $fieldvalue);
				// case insensitive
//USE THE SAME TO UPPER FUNCTION, OTHERWISE PROBLEMS WITH � to �
//				$fieldvalue = strtoupper($fieldvalue);
//				$condition = "UPPER($fieldname) LIKE('%$fieldvalue%')\n";
				$condition = "UPPER($fieldname) LIKE(UPPER('$fieldvalue'))\n";
			}
			if(empty($whereclause)) {
				return $condition;
			}
			else {
				return "$whereclause $operator $condition";
			}
		}
		else {
			return $whereclause;
		}
	}	
	public function Version() {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall");
		return 'bag-voorlopig-0.1';
	}
	private function OpenConnection() {
		//$settings = getSettings("bag-oracle");
		$configfile = getcwd() . '/../../../config.php';
		$config = parse_ini_file($configfile, true);
		$tnsname = $config['database']['tnsname'];
		$username = $config['database']['username'];
		$password = $config['database']['password'];
		$connection = new PDO($tnsname , $username , $password);
		if(!$connection) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "could not create connection:". $tnsname);
			throw new Exception('Error in ' .  __CLASS__ . ' ' . __FUNCTION__  .  ": could not create connection");
		}
		return $connection;
	}
	private function FetchSoapAdressen($sql) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "start with: $sql");				
		$connection = $this->OpenConnection();
		
		//die("FetchSoapAdressen:$sql");						
		$statement =  $connection->query($sql);
		if(!$statement) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "error in query: $sql \nerror:" . print_r($connection->errorInfo(), true));
			throw new Exception('Error in' .  __CLASS__ . ' ' . __FUNCTION__  .  "error in query: $sql \nerror:" . print_r($connection->errorInfo(), true));
		}
		// since the query will take some time, add 30 seconds to execution time
		// keep in mind that the webserver also has a timeout of around 300 seconds
		$adressen = array();
		//while($record = $statement->fetch(PDO::FETCH_OBJ)) {
		while($record = $statement->fetch()) {
			$adres = Adres::CreateFromRecord($record);
			$adressen[] = new SoapVar($adres, SOAP_ENC_OBJECT, 'Adres', 'urn:bag');
		}
		$connection = null;
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "end with #" . count($adressen) . " adresses (sql: $sql)" );
		return $adressen;
	}
	private function getSqlWhere($filter) {
		$totalwhere = '';
		// the filter can contain multiple search items, so we need to create a search based upon the multiple fields
		foreach(explode(" ", $filter) as $searchword) {
			$where = '';
			$where = $this->addContainsStatement('openbareruimtenaam', $searchword, $where, 'OR');
			$where = $this->addEqualsStatement('huisnummer', $searchword, $where, 'OR');
			$where = $this->addEqualsStatement('huisletter', $searchword, $where, 'OR');
			$where = $this->addContainsStatement('huisnummertoevoeging', $searchword, $where, 'OR');
			$where = $this->addContainsStatement('woonplaatsnaam', $searchword, $where, 'OR');
			$where = $this->addEqualsStatement('postcode', $searchword, $where, 'OR');
			if(empty($totalwhere)) {
				$totalwhere = "(\n $where )\n";
			}
			else {
				$totalwhere .= "AND\n(\n $where )\n ";
			}
		}
		return $totalwhere;
	}
	public function ZoekAdres($filter) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "Begin ZoekAdres($filter)");
		try {
			$sql = "SELECT\n";
			$sql .= "CASE WHEN BAGADRES + BAGNUMMERAANDUIDING + BAGOPENBARERUIMTE + BAGWOONPLAATS = 4  THEN 1 ELSE 0 END AS BAGOBJECT, \n";
			$sql .= "BAGWOONPLAATS,BAGOPENBARERUIMTE, BAGNUMMERAANDUIDING,\n";
			$sql .= "CASE WHEN ONDERZOEKADRES + ONDERZOEKNUMMERAANDUIDING + ONDERZOEKOPENBARERUIMTE + ONDERZOEKWOONPLAATS = 3  THEN 1 ELSE 0 END AS ONDERZOEKOBJECT,\n"; 
			$sql .= "ONDERZOEKWOONPLAATS, ONDERZOEKOPENBARERUIMTE,  ONDERZOEKNUMMERAANDUIDING,  OPENBARERUIMTENAAM, HUISNUMMER, HUISLETTER, HUISNUMMERTOEVOEGING,  WOONPLAATSNAAM, POSTCODE\n";
			$sql .= "FROM MID_ADRES\n";		 							
			$where = $this->getSqlWhere($filter);
			if(empty($where)) {
				return new SoapFault('BAG', "BAG:ZoekAdres: geen filter gedefinieerd!");
			}		
			$sql .= "WHERE $where";
			$sql .= 'ORDER BY openbareruimtenaam, woonplaatsnaam, 0 + huisnummer, huisletter, huisnummertoevoeging';
			//return new SoapFault("Bag", "Bag:ZoekAdres filter with value '$filter' generated followin sql: '$sql'");
			$adressen =  $this->FetchSoapAdressen($sql);
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "End ZoekAdres($filter)");
			return $adressen;
		}
		catch(PDOException $e) {
			$message = "BAG:ZoekAdres: PDOError: " . $e->getMessage() . " SQL: $sql";
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception ZoekAdres($filter)" . $message);
			return new SoapFault('BAG', $message);
		}
		catch (Exception $e)
		{
			$message = "BAG:ZoekAdres: Unknown error: " . $e->getMessage() . " SQL: $sql";
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception ZoekAdres($filter)" . $message );
			return new SoapFault('BAG', $message);
		}
	}
	public function GisHtmlViewAdres($filter, $height, $width) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: $filter $height $width");
		try {
			$sql = "SELECT min(adres_x) AS minx, max(adres_x) AS maxx, min(adres_y) AS miny, max(adres_y) AS maxy\n";
			$sql .= "FROM MID_ADRES\n";		 							
			$where = $this->getSqlWhere($filter);
			if(!empty($where)) {
				$sql .= "WHERE $where";
			} 															
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
			if(!$statement) {
				throw new Exception('Error in' .  __CLASS__ . ' ' . __FUNCTION__  .  " : in query:\n .  $sql");
			}			
			// since the query will take some time, add 30 seconds to execution time
			// keep in mind that the webserver also has a timeout of around 300 seconds
			$record = $statement->fetch();  
			$connection = null;	
			//return new SoapFault("Bag", "Bag:ZoekAdresMetFilter filter with value '$filter' generated followin sql: '$sql'");
			//return $this->FetchSoapAdressen($sql);
			
			// $settings = getSettings('bag-gis');
			// $gishtml = $settings['gis-adres-detail'];
			$gishtml = $this->getGisAdresDetail();		
			$gishtml = stringreplace($gishtml, '%height%', $height);
			$gishtml = stringreplace($gishtml, '%width%', $width);
			$gishtml = stringreplace($gishtml, '%minx%', $record['MINX']);
			$gishtml = stringreplace($gishtml, '%miny%', $record['MINY']);
			$gishtml = stringreplace($gishtml, '%maxx%', $record['MAXX']);
			$gishtml = stringreplace($gishtml, '%maxy%', $record['MAXY']);
			return $gishtml;			
		}
		catch(PDOException $e) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:GisHtmlViewAdres: PDOError: " . $e->getMessage() . " SQL: $sql");
		}		
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:GisHtmlViewAdres: Unknown error: " . $e->getMessage() ." SQL: $sql");
		}
	}
	private function getSqlWhereMetFilter($filter) {
		// convert soap to normat string:
		$filter = $filter->enc_value;		
		$where = '';				
		$where = $this->addEqualsStatement('authentiek', $filter->authentiek, $where, 'AND');
		$where = $this->addEqualsStatement('onderzoek', $filter->onderzoek, $where, 'AND');			
		$where = $this->addEqualsStatement('OPENBARERUIMTENAAM', $filter->straatnaam, $where, 'AND');
		$where = $this->addEqualsStatement('huisnummer', $filter->huisnummer, $where, 'AND');
		$where = $this->addEqualsStatement('huisletter', $filter->huisletter, $where, 'AND');
		$where = $this->addEqualsStatement('HUISNUMMERTOEVOEGING', $filter->HUISNUMMERTOEVOEGING, $where, 'AND');
		$where = $this->addEqualsStatement('woonplaats', $filter->woonplaats, $where, 'AND');
		$where = $this->addEqualsStatement('postcode', $filter->postcode, $where, 'AND');		
		return $where;
	}
	public function ZoekAdresMetFilter($filter) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "Begin ZoekAdresMetFilter($filter)");
		try {			
/*
SELECT 
  CASE WHEN BAGADRES + BAGNUMMERAANDUIDING + BAGOPENBARERUIMTE + BAGWOONPLAATS = 4  THEN 1 ELSE 0 END AS BAGOBJECT, 
  BAGWOONPLAATS,
  BAGOPENBARERUIMTE,
  BAGNUMMERAANDUIDING,
  CASE WHEN ONDERZOEKADRES + ONDERZOEKNUMMERAANDUIDING + ONDERZOEKOPENBARERUIMTE + ONDERZOEKWOONPLAATS = 3  THEN 1 ELSE 0 END AS ONDERZOEKOBJECT, 
  ONDERZOEKWOONPLAATS 
  ONDERZOEKOPENBARERUIMTE,
  ONDERZOEKNUMMERAANDUIDING,
  OPENBARERUIMTENAAM,
  HUISNUMMER,
  HUISLETTER,
  HUISNUMMERTOEVOEGING,
  WOONPLAATSNAAM,
  POSTCODE
*/		
			//$sql = "SELECT *\n";
			//$sql = "SELECT AUTHENTIEK, WOONPLAATS_AUTHENTIEK, OPENBARERUIMTE_AUTHENTIEK, NUMMERAANDUIDING_AUTHENTIEK, ONDERZOEK, WOONPLAATS_ONDERZOEK, OPENBARERUIMTE_ONDERZOEK, NUMMERAANDUIDING_ONDERZOEK, OPENBARERUIMTENAAM, HUISNUMMER, HUISLETTER, HUISNUMMERTOEVOEGING, WOONPLAATS, POSTCODE\n";
			$sql = "SELECT\n";
			$sql .= "CASE WHEN BAGADRES + BAGNUMMERAANDUIDING + BAGOPENBARERUIMTE + BAGWOONPLAATS = 4  THEN 1 ELSE 0 END AS BAGOBJECT, \n";
			$sql .= "BAGWOONPLAATS,BAGOPENBARERUIMTE, BAGNUMMERAANDUIDING,\n";
			$sql .= "CASE WHEN ONDERZOEKADRES + ONDERZOEKNUMMERAANDUIDING + ONDERZOEKOPENBARERUIMTE + ONDERZOEKWOONPLAATS = 3  THEN 1 ELSE 0 END AS ONDERZOEKOBJECT,\n"; 
			$sql .= "ONDERZOEKWOONPLAATS, ONDERZOEKOPENBARERUIMTE,  ONDERZOEKNUMMERAANDUIDING,  OPENBARERUIMTENAAM, HUISNUMMER, HUISLETTER, HUISNUMMERTOEVOEGING,  WOONPLAATSNAAM, POSTCODE\n";
			$sql .= "FROM MID_ADRES\n";		 							
			$where = $this->getSqlWhereMetFilter($filter);
			if(empty($where)) {
				return new SoapFault('BAG', "BAG:ZoekAdresMetFilter: geen filter gedefinieerd!");
			} 							
			$sql .= "WHERE $where";		
			$sql .= 'ORDER BY OPENBARERUIMTENAAM, WOONPLAATSNAAM, 0 + huisnummer, huisletter, HUISNUMMERTOEVOEGING';
			//return new SoapFault("Bag", "Bag:ZoekAdresMetFilter filter with value '$filter' generated followin sql: '$sql'");
			return $this->FetchSoapAdressen($sql);
		}
		catch(PDOException $e) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:ZoekAdresMetFilter: PDOError: " . $e->getMessage() . " SQL: $sql");
		}		
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:ZoekAdresMetFilter: Unknown error: " . $e->getMessage() ." SQL: $sql");
		}
	}	
	private function getGisAdresDetail() {
		$configfile = getcwd() . '/../../../config.php';
		$config = parse_ini_file($configfile, true);		
		$viewerurl =  '<iframe id="gisviewer" SCROLLING="NO" FRAMEBORDER="0" width="%width%" height="%height%" src="' .  getURL($config['bag']['gis']) . '?minx=%minx%&miny=%miny%&maxx=%maxx%&maxy=%maxy%&height=%height%&width=%width%&"></iframe>';
		return $viewerurl;
	}
	public function GisHtmlViewAdresMetFilter($filter, $height, $width) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: $filter $height $width");
		try {			
			$sql = "SELECT min(adres_x) AS minx, max(adres_x) AS maxx, min(adres_y) AS miny, max(adres_y) AS maxy\n";
			$sql .= "FROM mid_adres\n";										
			$where = $this->getSqlWhereMetFilter($filter);
			if(!empty($where)) {
				$sql .= "WHERE $where";
			} 															
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
			if(!$statement) {
				throw new Exception('Error in' .  __CLASS__ . ' ' . __FUNCTION__  . " : in query:\n $sql");
			}			
			// since the query will take some time, add 30 seconds to execution time
			// keep in mind that the webserver also has a timeout of around 300 seconds
			set_time_limit(180);					
			$record = $statement->fetch(); 
			if(!$record) {			
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Error fetching result for SQL: $sql");			
				return new SoapFault('BAG', "BAG:GisHtmlViewAdresMetFilter: Error fetching result for SQL: $sql");
			}
			$connection = null;	
			//return new SoapFault("Bag", "Bag:ZoekAdresMetFilter filter with value '$filter' generated followin sql: '$sql'");
			//return $this->FetchSoapAdressen($sql);
			
			$gishtml = $this->getGisAdresDetail();
			$gishtml = stringreplace($gishtml, '%height%', $height);			
			$gishtml = stringreplace($gishtml, '%width%', $width);
			$gishtml = stringreplace($gishtml, '%minx%', $record['MINX']);
			$gishtml = stringreplace($gishtml, '%miny%', $record['MINY']);
			$gishtml = stringreplace($gishtml, '%maxx%', $record['MAXX']);
			$gishtml = stringreplace($gishtml, '%maxy%', $record['MAXY']);
			return $gishtml;			
		}
		catch(PDOException $e) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:GisHtmlViewAdresMetFilter: PDOError: " . $e->getMessage() . " SQL: $sql");
		}		
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:GisHtmlViewAdresMetFilter: Unknown error: " . $e->getMessage() ." SQL: $sql");
		}
	}
	public function Terugmelding($filter, $username, $onderdeel, $opmerking) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: filter $filter username $username onderdeel $onderdeel opmerking $opmerking");
		try {
			// retrieve our code
			$sqlname = '';
			switch($onderdeel) {
			case 'woonplaats':
				$sqlname = 'woonplaats';
				break;
			case 'openbareruimte':
				$sqlname = 'openbareruimte';
				break;
			case 'nummeraanduiding':
				$sqlname = 'nummeraanduiding';
				break;			
			case 'verblijfsobject':
				$sqlname = 'adres';
				break;
			default:
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Unknown part: $onderdeel");
				return new SoapFault('BAG', "BAG:Terugmelding: Unknown part: $onderdeel");
			}
			$sql = "SELECT ${sqlname}code AS code\n";
			$sql .= "FROM mid_adres\n";
			$where = $this->getSqlWhereMetFilter($filter);
			if(empty($where)) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "geen filter gedefinieerd!");
				return new SoapFault('BAG', "BAG:Terugmelding: geen filter gedefinieerd!");
			}
			$sql .= "WHERE $where";
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
			if(!$record = $statement->fetch()) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "geen record gevonden voor sql: $sql");
				return new SoapFault('BAG', "BAG:Terugmelding: geen record gevonden voor sql: $sql");
			}
			
			$code = $record[0];
						
			if($statement->fetch()) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "meer dan 1 record gevonden voor sql: $sql");
				return new SoapFault('BAG', "BAG:Terugmelding: meer dan 1 record gevonden voor sql: $sql");
			}
			
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "code: $code");			
			// update the value's so they cannot harm us,..
			$username =  str_replace('\\', '/', $username);
			$opmerking =  str_replace('\'', '\'\'', $opmerking);
			$opmerking =  str_replace('\n', '', $opmerking);
			// and here we have our sql script!
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sqlname: $sqlname");

		
			// in a transaction....
			$connection->beginTransaction();
			// UPDATE DATA_AUTHENTIEK  SET INONDERZOEK = 1 WHERE CODE = CODE
			$sql = "UPDATE DATA_AUTHENTIEK  SET INONDERZOEK = 1 WHERE CODE = $code";
			if(!$connection->exec($sql)) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
			$sql = "INSERT INTO UTIL_TERUGMELDING (id, bagobject_code, username, melding) VALUES (COALESCE((select max(id) + 1 from util_terugmelding),1), ${code}, '${username}', '${opmerking}')";
			if(!$connection->exec($sql)) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
			if(!$connection->commit()) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "commit error:" . print_r($connection->errorInfo(), TRUE));
				return new SoapFault('BAG', "commit error:" . print_r($connection->errorInfo(), TRUE));
			}
			$connection = null;
			logmessage(LOG_LEVEL::debug, __CLASS__,__FUNCTION__, "SUCCESSFUL! executed feedback on $sqlname: $gid");
		}
		catch(PDOException $e) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:Terugmelding: PDOError: " . $e->getMessage() . " SQL: $sql");
		}		
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:Terugmelding: Unknown error: " . $e->getMessage() ." SQL: $sql");
		}				
	}	
}
?>