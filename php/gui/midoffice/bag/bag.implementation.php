<?php
include_once "../../include/bag/adres.php";
//include_once "../../include/util/soapsettings.php";
include_once "../../include/util/logging.php";

class bag {
	private function addContainsStatement($fieldname, $fieldvalue, $whereclause, $operator) {
		// $whereclause should always be defined, say incase of no filters		 
		if(!empty($fieldvalue)) {
			$fieldvalue = str_replace("'", "''", $fieldvalue);
			// case insensitive
//USE THE SAME TO UPPER FUNCTION, OTHERWISE PROBLEMS WITH ë to Ë
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
//USE THE SAME TO UPPER FUNCTION, OTHERWISE PROBLEMS WITH ë to Ë
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
		return $connection;
	}
	private function FetchSoapAdressen($sql) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "start with: $sql");				
		$connection = $this->OpenConnection();
		//die("FetchSoapAdressen:$sql");						
		$statement =  $connection->query($sql);
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
			$sql = "SELECT *\n";
			$sql .= "FROM mid_adres\n";		 					
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
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception ZoekAdres($filter)");
			return new SoapFault('BAG', "BAG:ZoekAdres: PDOError: " . $e->getMessage() . " SQL: $sql");
		}
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception ZoekAdres($filter)");
			return new SoapFault('BAG', "BAG:ZoekAdres: Unknown error: " . $e->getMessage() . " SQL: $sql");
		}
	}
	public function GisHtmlViewAdres($filter, $height, $width) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: $filter $height $width");
		try {			
			$sql = "SELECT min(x) AS minx, max(x) AS maxx, min(y) AS miny, max(y) AS maxy\n";
			$sql .= "FROM midadres\n";
			$where = $this->getSqlWhere($filter);
			if(!empty($where)) {
				$sql .= "WHERE $where";
			} 															
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
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
		$where = $this->addEqualsStatement('straatnaam', $filter->straatnaam, $where, 'AND');
		$where = $this->addEqualsStatement('huisnummer', $filter->huisnummer, $where, 'AND');
		$where = $this->addEqualsStatement('huisletter', $filter->huisletter, $where, 'AND');
		$where = $this->addEqualsStatement('huistoevoeging', $filter->huistoevoeging, $where, 'AND');
		$where = $this->addEqualsStatement('woonplaats', $filter->woonplaats, $where, 'AND');
		$where = $this->addEqualsStatement('postcode', $filter->postcode, $where, 'AND');		
		return $where;
	}
	public function ZoekAdresMetFilter($filter) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "Begin ZoekAdresMetFilter($filter)");
		try {			
			$sql = "SELECT *\n";
			//$sql = "SELECT AUTHENTIEK, WOONPLAATS_AUTHENTIEK, OPENBARERUIMTE_AUTHENTIEK, NUMMERAANDUIDING_AUTHENTIEK, ONDERZOEK, WOONPLAATS_ONDERZOEK, OPENBARERUIMTE_ONDERZOEK, NUMMERAANDUIDING_ONDERZOEK, STRAATNAAM, HUISNUMMER, HUISLETTER, HUISTOEVOEGING, WOONPLAATS, POSTCODE\n";
			$sql .= "FROM midadres\n";
			$where = $this->getSqlWhereMetFilter($filter);
			if(empty($where)) {
				return new SoapFault('BAG', "BAG:ZoekAdresMetFilter: geen filter gedefinieerd!");
			} 							
			$sql .= "WHERE $where";		
			$sql .= 'ORDER BY straatnaam, woonplaats, 0 + huisnummer, huisletter, huistoevoeging';
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
		$viewerurl =  '<iframe id="gisviewer" SCROLLING="NO" FRAMEBORDER="0" width="%width%" height="%height%" src="' .  getURL($config['midoffice']['bag-gis']) . '?minx=%minx%&miny=%miny%&maxx=%maxx%&maxy=%maxy%&height=%height%&width=%width%&"></iframe>';
		return $viewerurl;
	}
	public function GisHtmlViewAdresMetFilter($filter, $height, $width) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: $filter $height $width");
		try {			
			$sql = "SELECT min(x) AS minx, max(x) AS maxx, min(y) AS miny, max(y) AS maxy\n";
			$sql .= "FROM midadres\n";										
			$where = $this->getSqlWhereMetFilter($filter);
			if(!empty($where)) {
				$sql .= "WHERE $where";
			} 															
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
			// since the query will take some time, add 30 seconds to execution time
			// keep in mind that the webserver also has a timeout of around 300 seconds
			set_time_limit(180);					
			$record = $statement->fetch(); 
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
			return new SoapFault('BAG', "BAG:ZoekAdresMetFilter: PDOError: " . $e->getMessage() . " SQL: $sql");
		}		
		catch (Exception $e)
		{
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Exception");
			return new SoapFault('BAG', "BAG:ZoekAdres: Unknown error: " . $e->getMessage() ." SQL: $sql");
		}
	}
	public function Terugmelding($filter, $username, $onderdeel, $opmerking) {
		logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "SoapCall: filter $filter username $username onderdeel $onderdeel opmerking $opmerking");
		try {
			$where = $this->getSqlWhereMetFilter($filter);
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
			default:
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "Unknown part: $onderdeel");
				return new SoapFault('BAG', "BAG:Terugmelding: Unknown part: $onderdeel");
			}
			$sql = "SELECT ${sqlname}_id AS gid\n";
			$sql .= "FROM midadres\n";
			$where = $this->getSqlWhereMetFilter($filter);
			if(empty($where)) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "geen filter gedefinieerd!");
				return new SoapFault('BAG', "BAG:Terugmelding: geen filter gedefinieerd!");
			}
			$sql .= "WHERE $where";
			// retrieve our gid						
			$connection = $this->OpenConnection();
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sql: $sql");
			$statement =  $connection->query($sql);
			if(!$record = $statement->fetch()) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "geen record gevonden voor sql: $sql");
				return new SoapFault('BAG', "BAG:Terugmelding: geen record gevonden voor sql: $sql");
			}
			$gid = $record['GID'];
			if($statement->fetch()) {
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "meer dan 1 record gevonden voor sql: $sql");
				return new SoapFault('BAG', "BAG:Terugmelding: meer dan 1 record gevonden voor sql: $sql");
			}
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "gid: $gid");			
			// update the value's so they cannot harm us,..
			$username =  str_replace('\\', '/', $username);
			$opmerking =  str_replace('\'', '\'\'', $opmerking);
			$opmerking =  str_replace('\n', '', $opmerking);
			// and here we have our sql script!
			logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, "sqlname: $sqlname");
			switch($sqlname) {
			case 'woonplaats':
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "WOONPLAATS NOT YET IMPLEMENTED");
				return new SoapFault('BAG', "BAG:Terugmelding: WOONPLAATS NOT YET IMPLEMENTED");
				break;
			case 'openbareruimte':
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "OPENBARERUIMTE NOT YET IMPLEMENTED");
				return new SoapFault('BAG', "BAG:Terugmelding: OPENBARERUIMTE NOT YET IMPLEMENTED");
				break;
			case 'nummeraanduiding':
				$connection->beginTransaction();
				$sql = 	"-- first update the record to a value we can recognise and is expired\n";
				$sql .= "UPDATE VB_NUMMERAANDUIDING\n";
				$sql .= "SET EXPIREDATE = 0\n";
				$sql .= "WHERE GID = '$gid'\n";;
				if(!$connection->exec($sql)) {
					logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
					return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				}
				$sql = "-- We need to add the record in the correct projection\n"; 
				$sql .= "UPDATE  MDSYS.USER_SDO_GEOM_METADATA SET SRID = 90112  WHERE TABLE_NAME = 'VB_NUMMERAANDUIDING'\n";
				if(!$connection->exec($sql)) {
					logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
					return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				}
				$sql = "-- now add the new record\n";
				$sql = "INSERT INTO VB_NUMMERAANDUIDING\n";
				$sql .= "	(\n";
				$sql .= "	  GID,\n";
/* default				$sql .= "	  STARTDATE,\n";	*/
/* default				$sql .= "	  EXPIREDATE,\n";	*/
				$sql .= "	  REASONFORCHANGE,\n";
				$sql .= "	  AUTHOR,\n";
				$sql .= "	  AUTHENTIC,\n";
				$sql .= "	  RESEARCH,\n";
				$sql .= "	  ACCEPTED,\n";
				$sql .= "	  DOCUMENTID,\n";
				$sql .= "	  DOCUMENTDATE,\n";
				$sql .= "	  WOONPLAATSID,\n";
				$sql .= "	  OPENBARERUIMTEID,\n";
				$sql .= "	  HUISNUMMER,\n";
				$sql .= "	  HUISLETTER,\n";
				$sql .= "	  HUISNUMMERTOEVOEGING,\n";
				$sql .= "	  POSTCODE,\n";
				$sql .= "	  GEOM,\n";
				$sql .= "	  FEEDBACK\n";
				$sql .= "	)\n";
				$sql .= "	SELECT\n"; 
//				$sql .= "	    RAWTOHEX(GID),\n";
				$sql .= "	    GID,\n";
/*				$sql .= "	    to_char(sysdate, 'YYYYMMDD'),\n";	*/
/*				$sql .= "	    99999999,\n";	*/
				$sql .= "	    'FEEDBACK',\n";
				$sql .= "	    '$username',\n";
				$sql .= "	    AUTHENTIC,\n";
				$sql .= "	    'Y',\n";
				$sql .= "	    ACCEPTED,\n";
				$sql .= "	    DOCUMENTID,\n";
				$sql .= "	    DOCUMENTDATE,\n";
				$sql .= "	    WOONPLAATSID,\n";
				$sql .= "	    OPENBARERUIMTEID,\n";
				$sql .= "	    HUISNUMMER,\n";
				$sql .= "	    HUISLETTER,\n";
				$sql .= "	    HUISNUMMERTOEVOEGING,\n";
				$sql .= "	    POSTCODE,\n";
				$sql .= "	    GEOM,\n";
				$sql .= "	    '$opmerking'\n";
				$sql .= "	  FROM VB_NUMMERAANDUIDING\n";
				$sql .= "	  WHERE EXPIREDATE = 0\n";
				if(!$connection->exec($sql)) {
					logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
					return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				}
				$sql = "-- mapguide doesnt like the projection, so we set it back to null\n"; 
				$sql .= "UPDATE  MDSYS.USER_SDO_GEOM_METADATA SET SRID = NULL  WHERE TABLE_NAME = 'VB_NUMMERAANDUIDING'\n";
				if(!$connection->exec($sql)) {					
					logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
					return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				}
				$sql = "-- update the old record, so it reads a correct enddate\n";
				$sql .= "UPDATE VB_NUMMERAANDUIDING\n";
				$sql .= "	SET EXPIREDATE = \n";
				$sql .= "	(\n";
				$sql .= "	  SELECT STARTDATE\n";
				$sql .= "	  FROM VB_NUMMERAANDUIDING\n";
				$sql .= "	  WHERE GID = '$gid' \n";
				$sql .= "	  AND EXPIREDATE = (SELECT MAX(EXPIREDATE) FROM VB_NUMMERAANDUIDING)\n";
				$sql .= "	)\n";
				$sql .= "	WHERE GID = '$gid'\n"; 
				$sql .= "	AND EXPIREDATE = 0\n";
				if(!$connection->exec($sql)) {
					logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
					return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
				}
				break;
			default:
				logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "ongeldige sqlname: $sqlname");
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