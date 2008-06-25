# CONFIG FILE FOR PHP-BAG IN INI-FORMAT<?php /*
[internet]
#used by frontoffice and midoffice
proxy_host		=	"proxyserver"
proxy_port		=	8888
proxy_login		=	"username"
proxy_password	=	"password"

[frontoffice]
#used by front office
midoffice		=	"../midoffice/config.php?wsdl"

[midoffice]
#used by midoffice
bag-wsdl		=	"../midoffice/bag/bag.php?wsdl"
bag-gis			=	"../../gis/viewer.php"

[database]
#used by midoffice and editor
tnsname			=	"oci:dbname=(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = oracleserver)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8"
username		=	"username"
password		= 	"password"
#  */ ?>