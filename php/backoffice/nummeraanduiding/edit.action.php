<?php
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	// what do we want?
	if(isset($_REQUEST['action-cancel'])) {
		header('Location: ' . getPreviousPageValue());
	}
	elseif(isset($_REQUEST['action-change']) || isset($_REQUEST['action-delete'])) {
		$doinsert  = false;
		$doupdate  = false;
		$dodelete  = false;

		if(!empty($_REQUEST['id'])) {
			$gid = str_replace('\'', '\\\'', $_REQUEST['id']);
			$doupdate = isset($_REQUEST['action-change']);
			$dodelete = isset($_REQUEST['action-delete']);
		}
		else {
			$doinsert  = true;
		}		
		if(!$doinsert && !$doupdate && !$dodelete) {
			die("action was selected");
		}

		$connection = openConnection();
		$connection->beginTransaction();

		if($doupdate || $dodelete) {
			$sql = 	"-- update the record to a value we can recognise and is expired\n";
			$sql .= "UPDATE VB_NUMMERAANDUIDING\n";
			$sql .= "SET EXPIREDATE = 0\n";
			$sql .= "WHERE GID = '$gid'\n";
			$sql .= "AND EXPIREDATE =(SELECT MAX(EXPIREDATE) FROM VB_NUMMERAANDUIDING)\n";
			if(!$connection->exec($sql)) {
				die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
		}
		$sql = "-- We need to add the record in the correct projection\n"; 
		$sql .= "UPDATE  MDSYS.USER_SDO_GEOM_METADATA SET SRID = 90112  WHERE TABLE_NAME = 'VB_NUMMERAANDUIDING'\n";
		if(!$connection->exec($sql)) {
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
		}			
		
		$reasonforchange = str_replace('\'', '\\\'', $_REQUEST['REASONFORCHANGE']);
		if(empty($reasonforchange)) {
			die("<pre>No reason given");
		}
		$author = str_replace('\\', '/', $_SERVER['REMOTE_USER']);
		$authentic = isset($_REQUEST['AUTHENTIC'])?'Y':'N';
		$research = isset($_REQUEST['RESEARCH'])?'Y':'N';
		$accepted = isset($_REQUEST['ACCEPTED'])?'Y':'N';
		$documentid = str_replace('\'', '\\\'', $_REQUEST['DOCUMENTID']);
//			$documentdate = str_replace('\'', '\\\'', $_REQUEST['DOCUMENTDATE']);
		$huisnummer = str_replace('\'', '\\\'', $_REQUEST['HUISNUMMER']);
		if(!$dodelete && empty($huisnummer)) {
				die("<pre>No huisnummer given");
		}
		if(!$dodelete && !ctype_digit($huisnummer)) {
			die("<pre>huisnummer not a number: $huisnummer");
		}			
		$huisletter = str_replace('\'', '\\\'', $_REQUEST['HUISLETTER']);
		$huisletter = strtoupper($huisletter);
		if(!$dodelete && sizeof($huisletter) > 1) {
				die("<pre>Huisletter max 1 character");
		}
		$huisnummertoevoeging = str_replace('\'', '\\\'', $_REQUEST['HUISNUMMERTOEVOEGING']);
		$huisnummertoevoeging = strtoupper($huisnummertoevoeging);		
				
		$postcode = str_replace('\'', '\\\'', $_REQUEST['POSTCODE']);
		$postcode  = strtoupper($postcode);
		$postcode = str_replace(' ', '', $postcode);
		if(!$dodelete && empty($postcode)) {
			die("<pre>No postcode given");
		}
		$locatiexy = str_replace('\'', '\\\'', $_REQUEST['LOCATIE_X_Y']);
		if(empty($locatiexy) || trim($locatiexy) == ",") {
			if($dodelete) {
				$locatiexy = "0,0";
			}
			else die("<pre>No locatiexy given");
		}
		$openbareruimteid = str_replace('\'', '\\\'', $_REQUEST['OPENBARERUIMTEID']);
		if(!$dodelete && empty($openbareruimteid)) {
			die("<pre>No openbareruimteid given");
		}
		$woonplaatsid = str_replace('\'', '\\\'', $_REQUEST['WOONPLAATSID']);
		if(!$dodelete && empty($woonplaatsid)) {
			die("<pre>No woonplaatsid given");
		}
//			$feedback = str_replace('\'', '\\\'', $_REQUEST['FEEDBACK']);
		//$user = str_replace('\'', '\\\'', $_SERVER['REMOTE_USER']);
		
		$sql = "-- add the new record\n";
		$sql = "INSERT INTO VB_NUMMERAANDUIDING\n";
		$sql .= "	(\n";
		if($doupdate || $dodelete) {
			$sql .= "	  GID,\n";
		}
/* default				$sql .= "	  STARTDATE,\n";	*/
/* default				$sql .= "	  EXPIREDATE,\n";	*/
		$sql .= "	  REASONFORCHANGE,\n";
		$sql .= "	  AUTHOR,\n";
		$sql .= "	  AUTHENTIC,\n";
		$sql .= "	  RESEARCH,\n";
		$sql .= "	  ACCEPTED,\n";
		$sql .= "	  DOCUMENTID,\n";
//			$sql .= "	  DOCUMENTDATE,\n";
		$sql .= "	  HUISNUMMER,\n";
		$sql .= "	  HUISLETTER,\n";
		$sql .= "	  HUISNUMMERTOEVOEGING,\n";
		$sql .= "	  POSTCODE,\n";
		$sql .= "	  GEOM,\n";
		$sql .= "	  OPENBARERUIMTEID,\n";
		$sql .= "	  WOONPLAATSID\n";
		$sql .= "	)\n";

		$sql .= "	VALUES (\n";
		if($doupdate || $dodelete) {
			$sql .= "	  '$gid',\n";
		}				
/*				$sql .= "	    to_char(sysdate, 'YYYYMMDD'),\n";	*/
/*				$sql .= "	    99999999,\n";	*/
		$sql .= "	    '$reasonforchange',\n";
		$sql .= "	    '$author',\n";
		$sql .= "	    '$authentic',\n";
		$sql .= "	    '$research',\n";
		$sql .= "	    '$accepted',\n";
		$sql .= "	    '$documentid',\n";
//			$sql .= "	    '$documentdate',\n";
		$sql .= "	    $huisnummer,\n";
		$sql .= "	    '$huisletter',\n";
		$sql .= "	    '$huisnummertoevoeging',\n";
		$sql .= "	    '$postcode',\n";
		$sql .= "	    MDSYS.SDO_GEOMETRY(\n";
		$sql .= "	    	    2001,\n";
		$sql .= "	    	    90112,\n";
		$sql .= "	    	    MDSYS.SDO_POINT_TYPE(\n";
		$sql .= "	    	    	    $locatiexy,\n"; 
		$sql .= "	    	    	    NULL\n";
		$sql .= "	    	    ),\n";
		$sql .= "	    	    NULL,\n";
		$sql .= "	    	    NULL\n";
		$sql .= "	    ),\n";
		$sql .= "	    '$openbareruimteid',\n";
		$sql .= "	    '$woonplaatsid'\n";
		$sql .= "	    )\n";
		if(!$connection->exec($sql)) {
			die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
		}
		
		$sql = "-- mapguide doesnt like the projection, so we set it back to null\n"; 
		$sql .= "UPDATE  MDSYS.USER_SDO_GEOM_METADATA SET SRID = NULL  WHERE TABLE_NAME = 'VB_NUMMERAANDUIDING'\n";
		if(!$connection->exec($sql)) {					
			logmessage(LOG_LEVEL::error, __CLASS__,__FUNCTION__, "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			return new SoapFault('BAG', "execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
		}
		if($doupdate || $dodelete) {
			$sql = "-- update the old record, so it reads a correct enddate\n";
			$sql .= "UPDATE VB_NUMMERAANDUIDING\n";
			$sql .= "	SET EXPIREDATE = \n";
			$sql .= "	(\n";
			$sql .= "	  SELECT STARTDATE\n";
			$sql .= "	  FROM VB_NUMMERAANDUIDING\n";
			$sql .= "	  WHERE GID = '$gid' \n";
			$sql .= "	  AND EXPIREDATE = (SELECT MAX(EXPIREDATE) FROM VB_OPENBARERUIMTE)\n";
			$sql .= "	)\n";
			$sql .= "	WHERE GID = '$gid'\n"; 
			$sql .= "	AND EXPIREDATE = 0\n";
			
			if(!$connection->exec($sql)) {
				die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
		}
		if($dodelete) {
			$sql = "-- update new record, so the end date is the startdate\n";
			$sql .= "UPDATE VB_NUMMERAANDUIDING\n";
			$sql .= "	SET EXPIREDATE = STARTDATE";
			$sql .= "	WHERE GID = '$gid'\n"; 
			$sql .= "	AND EXPIREDATE = (SELECT MAX(EXPIREDATE) FROM VB_OPENBARERUIMTE)\n";
			
			if(!$connection->exec($sql)) {
				die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
		}
		if(!$connection->commit()) {
			die("<pre>commit error:" . print_r($connection->errorInfo(), TRUE));
		}
		$connection = null;		
		
		header('Location: ' . getPreviousPageValue());
	}
	else die("<pre>not known action<br>" . print_r($_REQUEST, TRUE));
?>
