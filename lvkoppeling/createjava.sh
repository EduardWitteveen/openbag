wget http://apache.hippo.nl/ws/axis2/1_4/axis2-1.4-bin.zip
unzip axis2-1.4-bin.zip
chmod +x axis2-1.4/bin/wsdl2java.sh
axis2-1.4/bin/wsdl2java.sh -uri 06-StUF0206/bag/0120/bagstuf.wsdl
axis2-1.4/bin/wsdl2java.sh -uri 06-StUF0206/bag/0120/bag-sync-stuf.wsdl