// http://www.herongyang.com/crypto/Key_Formats_PKCS8_PKCS12.html
eduard@eduard-desktop:~$ openssl genrsa -des3 -out hawarit-key.pem 1024
Generating RSA private key, 1024 bit long modulus
...........................................................................................++++++
....++++++
e is 65537 (0x10001)
Enter pass phrase for hawarit-key.pem:
Verifying - Enter pass phrase for hawarit-key.pem:
eduard@eduard-desktop:~$ openssl req -new -key hawarit-key.pem -out hawarit-csr.pem
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
eduard@eduard-desktop:~$ openssl x509 -req -days 365 -in hawarit-csr.pem -signkey hawarit-key.pem -out hawarit.crt
Signature ok
subject=/C=NL/ST=Friesland/L=Bolsward/O=HawarIT/OU=OpenBAG/CN=bolsward.hawarit.com/emailAddress=h.klandermans@hawarit.com
Getting Private key
Enter pass phrase for hawarit-key.pem:
eduard@eduard-desktop:~/openbag/lvkoppeling/certificate$ openssl rsa -in hawarit-key.pem -out server.unencrypted.pem
Enter pass phrase for hawarit-key.pem:
writing RSA key

openssl pkcs12 -export -inkey openssl_key.pem -in openssl_crt.pem -out openssl_key_crt.p12 -name openssl_key_crt




