<?php
	if(!isset($_SERVER['REMOTE_USER'])) {
		// disable next line to test withouth authentication!
		die('[[SSPI not active]]');
		$_SERVER['REMOTE_USER'] = '[[SSPI not active]]';
	}

	function getCurrentPage() {
		// current page itselve
		$currentpage =  $_SERVER['PHP_SELF'];
		if(!empty($_SERVER['QUERY_STRING'])) {
			$currentpage .=  '?' . $_SERVER['QUERY_STRING'];
		}
		return $currentpage;
	}
	function getPreviousPageValue() {
		if(!isset($_REQUEST['returnpage'])) {
			// return page was not set, give an error 
			die(">parameter 'returnpage' was not set!");
		}
		else {
			$returnpage = $_REQUEST['returnpage'];
		}
		return $returnpage;
	}
//	function getPreviousPageParameter() {
//		return  'returnpage=' . urlencode(getPreviousPageValue());
//	}
	function getCurrentPageParameter() {
		return  'returnpage=' . urlencode(getCurrentPage());
	}
?>