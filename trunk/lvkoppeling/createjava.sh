wget http://apache.hippo.nl/ws/axis2/1_4/axis2-1.4-bin.zip
unzip axis2-1.4-bin.zip
chmod +x axis2-1.4/bin/wsdl2java.sh
# into src/main/java
# generate interface: -ssi
axis2-1.4/bin/wsdl2java.sh -u -s -S src/main/java -R wsdl2java_resources -uri 06-StUF0206/bag/0120/bagstuf.wsdl
axis2-1.4/bin/wsdl2java.sh -u -s -S src/main/java -R wsdl2java_resources  -uri 06-StUF0206/bag/0120/bag-sync-stuf.wsdl
