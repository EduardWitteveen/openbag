<?php
function strleft($input, $search) {
    return substr($input, 0, strpos($input, $search));
}
function strright($input, $search) {
    return substr($input, 0, strrpos($input, $search) + 1);
}
// maybe nexttime use: str_replace??
function stringreplace($input, $search, $replace) {
	return str_replace($search, $replace, $input);
/*	while(($pos = strpos($input, $search)) > -1) {
		$begin = substr($input, 0, $pos);
		$end = substr($input, $pos + strlen($search));
		$input = $begin . $replace . $end;
	}
	return $input;
*/
}
function htmlpath($path) {
	$pathparts = explode("/",  $path);
	// remove any empty value's and .'s
	$parts = array();
	foreach($pathparts as $value) {
		if(!empty($value) && $value != '.') {
			// echo("value: '$value'<br>");
			$parts[]  = $value;
		}
	}
	// remove the ..'s	
	while($offset = array_search('..', $parts)) {
		// remove current and previous
		unset($parts[$offset]);
		unset($parts[$offset - 1]);
		// reindex the array after unset
		$parts = array_values($parts);
		//echo("[ remove .. offset: $offset loop with:" .implode("/", $parts) . "]<br>");
	}
	return "/" . implode("/", $parts);
}
function getURL($filename) {
    $s = empty($_SERVER["HTTPS"]) ? '' : ($_SERVER["HTTPS"] == "on") ? "s" : "";
    $protocol = strleft(strtolower($_SERVER["SERVER_PROTOCOL"]), "/").$s;
    $port = ($_SERVER["SERVER_PORT"] == "80") ? "" : (":".$_SERVER["SERVER_PORT"]);
    $path  = strright($_SERVER['REQUEST_URI'], "/");
    if($filename[0] == '/') {
	    // absolute path
	    $htmlpath =  htmlpath($filename);
    }
    else {
	    // relative path
	    $htmlpath =  htmlpath($path.$filename);
    }
    $url =  $protocol."://".$_SERVER['SERVER_NAME'].$port.$htmlpath;
    return $url;
} 
?>
