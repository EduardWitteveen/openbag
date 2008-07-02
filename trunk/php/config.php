# CONFIG FILE FOR PHP-BAG IN INI-FORMAT<?php /**/
#used by soap communication
[internet]
#proxy_host		=	"proxyserver"
#proxy_port		=	8888
#proxy_login		=	"username"
#proxy_password	=	"password"

#used by front office
[frontoffice]
midoffice		=	"../midoffice/config.php?wsdl"
#midoffice		=	"http://192.168.198.118:8080/php/gui/midoffice/config.php?wsdl"	

#used by midoffice
[midoffice]
bag-gis			=	"../../gis/viewer.php"
#bag-gis			=	"http://192.168.198.118:8080/php/gui/gis/viewer.php"

#used by midoffice and editor
[database]
tnsname			=	"oci:dbname=(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = oraserver)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8"
username		=	"beheerder"
password		= 	"mart!n"
#  */ ?>