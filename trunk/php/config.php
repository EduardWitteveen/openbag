#used by soap communication
[internet]
#proxy_host		=	"127.0.0.1"
#proxy_port		=	8888
#proxy_login		=	"username"
#proxy_password	=	"password"

#used by front office
[frontoffice]
midoffice		=	"../midoffice/config.php?wsdl"
#midoffice		=	"http://192.168.198.118:8080/php/gui/midoffice/config.php?wsdl"

#used by midoffice
[midoffice]
bagservice			=	"../gui/midoffice/bag/bag.php?wsdl"	
#bagservice			=	"http://192.168.198.118:8080/php/gui/midoffice/bag/bag.php?wsdl"

[bag]
gis			=	"../../gis/viewer.php"
#gis			=	"http://192.168.198.118:8080/php/gui/gis/viewer.php"

#used by midoffice and editor
[database]
tnsname			=	"oci:dbname=(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = databaseservername)(PORT = 1521)))(CONNECT_DATA =(SERVICE_NAME = bag)));charset=UTF8"
username		=	"username"
password		= 	"password"