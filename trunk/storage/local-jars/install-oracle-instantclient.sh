#!/bin/sh
# HACKHACK, the following path did not work: ~/instantclient_11_1/ojdbc6.jar
mvn install:install-file -DgroupId=oracle -DartifactId=oracle-instantclient -Dversion=11.1.0.6.0 -Dpackaging=jar -Dfile=/home/`whoami`/instantclient_11_1/ojdbc6.jar
