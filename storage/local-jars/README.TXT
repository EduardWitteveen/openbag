This folder contains jars necessary to build the project. 
You should add them to your local maven repository. 
This requires a seperate install of Maven2 which can be run from the command line.

- Download maven2 from http://maven.apache.org
- Set sytem variable M2_HOME to your installation directory (e.g. C:\Dev\Maven2 or equivalent linux path)
- Windows: Add to path variable: %M2_HOME%/bin
- Run in project dir: 'mvn clean' to see if everything works ok
- If you are behind a proxy look at the conf/settings.xml file in you maven directory and enable the proxy there.

Run the scripts from the local-jars directory and not from within eclipse or other editor. This should import
the jar files into your local maven repository.
