# CONFIG FILE FOR PHP-BAG IN INI-FORMAT<?php /**/
#used by soap communication (debug with fiddler)
[internet]
#proxy_host		=	"localhost"
#proxy_port		=	8888
#proxy_login		=	"username"
#proxy_password		=	"password"

#used by front office
[frontoffice]
midoffice		=	"../midoffice/config.php?wsdl"
#midoffice		=	"http://midofficeserver/php/gui/midoffice/config.php?wsdl"	

#used by midoffice
[midoffice]
bag-gis			=	"../../gis/viewer.php"
#bag-gis			=	"http://gisserver/php/gui/gis/viewer.php"

#used by midoffice and editor
[database]
tnsname			=	"oci:dbname=(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = databaseserver)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8"
username		=	"username"
password		= 	"password"
#  */ ?>