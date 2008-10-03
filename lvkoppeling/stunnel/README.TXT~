Ga naar: http://www.stunnel.org/pem/
	Country:			NL
	State or Province Name:		Friesland
	Locality Name:			Bolsward
	Organization Name:		HawarIT
	Organizational Unit Name:	OpenBAG
	Common Name:			bolsward.hawarit.com

Copieer de key-output in een nieuw bestand: stunnel.pem

Nu maken we een crt bestand aan op basis van het stunnel.pem bestand:
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ openssl req -new -key stunnel.pem -out stunnel.csr
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
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ 

Rechten goed van dat ding
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ chmod 600 stunnel.pem 

Copieren van de configuratie bestanden:
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ sudo cp stunnel.pem  /etc/stunnel/
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ sudo cp stunnel.conf /etc/stunnel/

Bewerken van /etc/default/stunnel4 en wijzig:
-- ENABLED=0
++ ENABLED=1

Stunnel opnieuw opstarten:
	
	hawarit@hawarit-desktop:~/openbag/lvkoppeling/stunnel$ sudo /etc/init.d/stunnel4 restart
	
Logging valt te vinden in:
	/var/log/stunnel4/stunnel.log

Testen van de tunnel doen we door naar de volgende url te gaan:
	http://127.0.0.1/



