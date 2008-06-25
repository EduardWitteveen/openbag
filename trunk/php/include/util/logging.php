<?php
final class LOG_LEVEL {
    const trace		= 0x00000001;
    const debug		= 0x00000010;
    const error		= 0x00000100;

    // ensures that this class acts like an enum
    // and that it cannot be instantiated
    private function __construct(){}
}
//logmessage(LOG_LEVEL::trace, __CLASS__,__FUNCTION__, 'blabla'); 
function logmessage($level, $class, $function, $message) {
	date_default_timezone_set('Europe/Amsterdam');
	$stamp = date('Ymd H:i:s');	
	switch($level) {
	case LOG_LEVEL::trace:
		$levelmessage = 'trace';
		break;
	case LOG_LEVEL::debug:
		$levelmessage = 'debug';
		break;
	case LOG_LEVEL::error:
		$levelmessage = 'error';
		break;
	default:
		die('unknown log level');
	}
	$writeline = "[$stamp : \t$levelmessage : \t $class -> $function]\t$message.\r\n";		
	$filename = 'c:\\www\\log.txt';
	if (!$handle = fopen($filename, 'a+')) {
		die("Cannot open file ($filename)");
	}
	if (fwrite($handle, $writeline) === FALSE) {
		die("Cannot write to file ($filename)");
	}
	fclose($handle);
}
?>
