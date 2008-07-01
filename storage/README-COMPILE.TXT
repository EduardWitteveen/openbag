MAVEN
===== 
- Install Standalone Maven: >= 2.0.8
- Run all the script file(s) in: .\local-jars\
- Optional
	~/openbag/bag$ export JAVA_HOME=/usr/lib/jvm/java-6-sun
- Run in the root of the project:  ~/openbag/bag$ mvn compile

POSTGRES
========
- Install postgresql like documented in the file: postgis.pdf


ECLIPSE
=======
- Use Eclise Version: >= 3.2.2
- Install maven plugin:
	help > software updates > find and install:
	- search for new software to install
	- new remote site...
		name:	m2eclipse	
		url:	http://m2eclipse.sonatype.org/update/
	Finish
	- Select everything execpt the optional parts
	- accept
	Finish
	- Install all

PROJECT
=======
- File > New > Project ...
- Java Project > Existing source 
	- Create project from existing source
	- JRE: java-6
	- Properties > Java Compiler > Compiler compliance leven: 6.0
	- Import existing project from workspace

FILL THE DATABASE
=================
The initial database can be loaded by running the java application in eclipse: 
	org.nergens.bag.storage.Main

This class will import the files(not part of the project):
	- gemeente.csv
	- woonplaats.csv
	- openbareruimte.csv
	- nummeraanduiding.csv
	- verblijfsobject.csv
	- pand.csv	
