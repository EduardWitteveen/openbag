#!/bin/sh
mvn install:install-file -DgroupId=postgresql -DartifactId=postgis -Dversion=1.3.2 -Dpackaging=jar -Dfile=postgis_1.3.2.jar
