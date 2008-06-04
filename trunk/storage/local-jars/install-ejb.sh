#!/bin/sh
mvn install:install-file -DgroupId=javax.ejb -DartifactId=ejb -Dversion=3.0 -Dpackaging=jar -Dfile=ejb-3_0-api.jar
