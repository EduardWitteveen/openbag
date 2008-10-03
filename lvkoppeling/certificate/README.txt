// http://www.herongyang.com/crypto/Key_Formats_PKCS8_PKCS12.html
eduard@eduard-desktop:~$ openssl genrsa -des3 -out hawarit-key.pem 1024
Generating RSA private key, 1024 bit long modulus
...........................................................................................++++++
....++++++
e is 65537 (0x10001)
Enter pass phrase for hawarit-key.pem:
Verifying - Enter pass phrase for hawarit-key.pem:
eduard@eduard-desktop:~$ openssl req -new -key hawarit-key.pem -out hawarit.csr
Enter pass phrase for hawarit-key.pem:
You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) [AU]:NL
State or Province Name (full name) [Some-State]:Friesland
Locality Name (eg, city) []:Bolsward
Organization Name (eg, company) [Internet Widgits Pty Ltd]:HawarIT
Organizational Unit Name (eg, section) []:OpenBAG
Common Name (eg, YOUR name) []:bolsward.hawarit.com
Email Address []:h.klandermans@hawarit.com

Please enter the following 'extra' attributes
to be sent with your certificate request
A challenge password []:
An optional company name []:
eduard@eduard-desktop:~$ openssl x509 -req -days 365 -in hawarit.csr -signkey hawarit-key.pem -out hawarit.crt
Signature ok
subject=/C=NL/ST=Friesland/L=Bolsward/O=HawarIT/OU=OpenBAG/CN=bolsward.hawarit.com/emailAddress=h.klandermans@hawarit.com
Getting Private key
Enter pass phrase for hawarit-key.pem:
eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ openssl rsa -in hawarit-key.pem -out server.unencrypted.pem
Enter pass phrase for hawarit-key.pem:
writing RSA key

hawarit@hawarit-desktop:~/openbag/lvkoppeling/certificate$ openssl rsa -in hawarit-key.pem -out hawarit-key.zonderpass.pem 
Enter pass phrase for hawarit-key.pem:
writing RSA key

ubuntu@ubuntu:/media/disk-1/bag/lvkoppeling/certificate$ openssl pkcs12 -export -inkey hawarit-key.pem -in  hawarit.crt -out hawarit-key-crt.p12 -name hawarit-key-crt
Enter pass phrase for hawarit-key.pem:
Enter Export Password:
Verifying - Enter Export Password:

ubuntu@ubuntu:/media/disk-1/bag/lvkoppeling/certificate$ openssl pkcs12 -in hawarit-key-crt.p12 -out hawarit-key-crt-enc.pem
Enter Import Password:
MAC verified OK
Enter PEM pass phrase:
Verifying - Enter PEM pass phrase:


eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ wget ftp://ftp.mortbay.org/pub/jetty-6.1.x/jetty-6.1.3.zip
--2008-09-19 20:05:51--  ftp://ftp.mortbay.org/pub/jetty-6.1.x/jetty-6.1.3.zip
           => `jetty-6.1.3.zip'
Resolving ftp.mortbay.org... 209.235.245.74
Connecting to ftp.mortbay.org|209.235.245.74|:21... connected.
Logging in as anonymous ... Logged in!
==> SYST ... done.    ==> PWD ... done.
==> TYPE I ... done.  ==> CWD /pub/jetty-6.1.x ... done.
==> SIZE jetty-6.1.3.zip ... 17653472
==> PASV ... done.    ==> RETR jetty-6.1.3.zip ... done.
Length: 17653472 (17M)

100%[===================================================================================================================>] 17,653,472   283K/s   in 61s     

2008-09-19 20:06:53 (283 KB/s) - `jetty-6.1.3.zip' saved [17653472]

eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ unzip jetty-6.1.3.zip  | more
Archive:  jetty-6.1.3.zip
   creating: jetty-6.1.3/logs/
  inflating: jetty-6.1.3/patches/j2mecdc.patch  
  inflating: jetty-6.1.3/patches/java5.patch  
....
....
....  
  inflating: jetty-6.1.3/javadoc/org/mortbay/jetty/handler/class-use/AbstractHandlerContainer.html  
  inflating: jetty-6.1.3/javadoc/org/mortbay/jetty/handler/class-use/RequestLogHandler.html  


eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ java -classpath jetty-6.1.3/lib/jetty-6.1.3.jar org.mortbay.jetty.security.PKCS12Import hawarit-key-crt.p12 hawarit-javakeystore.jks
Enter input keystore passphrase: hawarit
Enter output keystore passphrase: hawarit
Alias 0: hawarit-key-crt
Adding key for alias hawarit-key-crt

eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ keytool -list -v -keystore hawarit-javakeystore.jks 
Enter keystore password:  

Keystore type: JKS
Keystore provider: SUN

Your keystore contains 1 entry

Alias name: hawarit-key-crt
Creation date: Sep 19, 2008
Entry type: PrivateKeyEntry
Certificate chain length: 1
Certificate[1]:
Owner: EMAILADDRESS=h.klandermans@hawarit.com, CN=bolsward.hawarit.com, OU=OpenBAG, O=HawarIT, L=Bolsward, ST=Friesland, C=NL
Issuer: EMAILADDRESS=h.klandermans@hawarit.com, CN=bolsward.hawarit.com, OU=OpenBAG, O=HawarIT, L=Bolsward, ST=Friesland, C=NL
Serial number: 9a1cc39ee26ed6fe
Valid from: Tue Jul 22 09:33:31 CEST 2008 until: Wed Jul 22 09:33:31 CEST 2009
Certificate fingerprints:
	 MD5:  4C:CA:EB:57:31:FD:5B:02:26:4F:8E:39:0F:F7:25:5A
	 SHA1: 8B:56:11:80:F2:42:44:BF:31:43:10:60:54:CF:B6:F4:72:4E:12:80
	 Signature algorithm name: SHA1withRSA
	 Version: 1


*******************************************
*******************************************


eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ 


# We now got the following error in java:
# PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
# http://blogs.sun.com/andreas/entry/no_more_unable_to_find
# We solve this by doing the following: java InstallCert test.baglv.nl


