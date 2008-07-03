# CONFIG FILE FOR PHP-BAG IN INI-FORMAT<?php /**/
#used by soap communication
[internet]
proxy_host		=	"localhost"
proxy_port		=	8888
#proxy_login		=	"username"
#proxy_password		=	"password"

#used by front office
[frontoffice]
config		=	"http://192.168.198.118:8080/php/gui/midoffice/config.php?wsdl"	
#config		=	"../midoffice/config.php?wsdl"

#used by midoffice
[midoffice]
#bag-service			=	"../gui/midoffice/bag/bag.php?wsdl"	
bag-service		=	"http://midserver/php/gui/midoffice/bag/bag.php?wsdl"
#bag-gis			=	"../../gis/viewer.php"
bag-gis			=	"http://gisserver/php/gui/gis/viewer.php"

#used by midoffice and editor
[database]
tnsname			=	"oci:dbname=(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = servername)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8"
username		=	"username"
password		= 	"password"
#  */ ?>