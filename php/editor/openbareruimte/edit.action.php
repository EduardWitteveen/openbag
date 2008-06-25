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
			$sql .= "UPDATE VB_OPENBARERUIMTE\n";
			$sql .= "SET EXPIREDATE = 0\n";
			$sql .= "WHERE GID = '$gid'\n";
			$sql .= "AND EXPIREDATE = (SELECT MAX(EXPIREDATE) FROM VB_OPENBARERUIMTE)\n";
			if(!$connection->exec($sql)) {
				die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
			}
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
		// always ucase the first character
		$label = ucfirst(str_replace('\'', '\\\'', $_REQUEST['LABEL']));
		if(!$dodelete && empty($label)) {
			die("<pre>No label given");
		}			
		$woonplaatsid = str_replace('\'', '\\\'', $_REQUEST['WOONPLAATSID']);
		if(!$dodelete && empty($woonplaatsid)) {
			die("<pre>No woonplaatsid given");
		}
//			$feedback = str_replace('\'', '\\\'', $_REQUEST['FEEDBACK']);
		//$user = str_replace('\'', '\\\'', $_SERVER['REMOTE_USER']);
		
		$sql = "-- add the new record\n";
		$sql = "INSERT INTO VB_OPENBARERUIMTE\n";
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
		$sql .= "	  LABEL,\n";
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
		$sql .= "	    '$label',\n";
		$sql .= "	    '$woonplaatsid'\n";
		$sql .= "	    )\n";
		if(!$connection->exec($sql)) {
			die("<pre>execute error:" . print_r($connection->errorInfo(), TRUE) . "\n$sql");
		}
		if($doupdate || $dodelete) {
			$sql = "-- update the old record, so it reads a correct enddate\n";
			$sql .= "UPDATE VB_OPENBARERUIMTE\n";
			$sql .= "	SET EXPIREDATE = \n";
			$sql .= "	(\n";
			$sql .= "	  SELECT STARTDATE\n";
			$sql .= "	  FROM VB_OPENBARERUIMTE\n";
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
			$sql .= "UPDATE VB_OPENBARERUIMTE\n";
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
	else die("<pre>not known action");
?>