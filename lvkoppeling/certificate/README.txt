hawarit@hawarit-desktop:~/openbag/lvkoppeling/certificate$ openssl req -new -nodes -keyout private.key -out public.csr
Generating a 1024 bit RSA private key
...................++++++
..................++++++
writing new private key to 'private.key'
-----
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
A challenge password []:HawarIT1
An optional company name []:
hawarit@hawarit-desktop:~/openbag/lvkoppeling/certificate$ openssl rsa -in private.key -des3 -out secureprivate.key
writing RSA key
Enter PEM pass phrase:
Verifying - Enter PEM pass phrase:
hawarit@hawarit-desktop:~/openbag/lvkoppeling/certificate$ 

