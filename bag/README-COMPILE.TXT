ECLIPSE
=======
- Install Eclise Version: 3.3.1.1

MAVEN
=====
- Install Standalone Maven: 2.x
- Run all the bat files in: local-jars\*.bat
- Install maven plugin: 		http://m2eclipse.codehaus.org/
	(dont select the  Subclipse Integration for Maven (Optional))

POSTGRES
========
- Install postgresql like documented in the file: postgis.pdf

PROJECT
=======
- ? Change the org.maven.ide.eclipse.MAVEN2_CLASSPATH_CONTAINER(unbound)
- Properties > Java Compiler > Compiler compliance leven: 6.0
- Import existing project from workspace

FILL THE DATABASE
=================
The initial database can be loaded by running: 
	org.nergens.bag.storage.Main

This class import the files:
	- gemeente.csv
	- woonplaats.csv
	- openbareruimte.csv
	- nummeraanduiding.csv
	- verblijfsobject.csv
	- pand.csv	