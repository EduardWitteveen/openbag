<?php
	function addContainsStatement($fieldname, $fieldvalue, $whereclause, $operator) {
		// $whereclause should always be defined, say incase of no filters		 
		if(!is_null($fieldvalue)) {
			$fieldvalue = str_replace("'", "''", $fieldvalue);
			// case insensitive
			$fieldvalue = strtoupper($fieldvalue);			
			$condition = "UPPER($fieldname) LIKE('%$fieldvalue%')\n";
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
	function addEqualsStatement($fieldname, $fieldvalue, $whereclause, $operator) {
		// $whereclause should always be defined, say incase of no filters		 
		if(!is_null($fieldvalue)){
			if(empty($fieldvalue)) {
				$condition = "$fieldname IS NULL";
			}
			else {			
				$fieldvalue = str_replace("'", "''", $fieldvalue);
				// case insensitive
				$fieldvalue = strtoupper($fieldvalue);
				$condition = "UPPER($fieldname) LIKE('$fieldvalue')\n";
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
	function openConnection() {
		try {	
			$configfile = getcwd() . '/../config.inc';
			$config = parse_ini_file($configfile, true);
			$tnsname = $config['database']['tnsname'];
			$username = $config['database']['username'];
			$password = $config['database']['password'];
			$connection = new PDO($tnsname, $username, $password);
			if(!$connection) {
				die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::" . __FUNCTION__ . " could not create connection: error:" . print_r($connection->errorInfo(), TRUE));
			}
			return $connection;
		}
		catch(Exception $e) {
			die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::" . __FUNCTION__ . " exception: error:" . $e);
		}
	}
	function getRecords($connection, $sql) {
		try {
			$statement = $connection->query($sql);
			if(!$statement) {
				die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::". __FUNCTION__ . " could query, sql: $sql error:" . print_r($connection->errorInfo(), TRUE));
			}
			$result = array();			
			while($record = $statement->fetch(PDO::FETCH_ASSOC)) {				
				$result[] = $record;
			}
			$statement = null;
			return $result;
		}
		catch(Exception $e) {
			die("file:" . __FILE__ . " #" . __LINE__ . "  location:" . __CLASS__ . "::". __FUNCTION__ . " exception: error:" . print_r($connection->errorInfo(), TRUE));
		}
	}	
?>