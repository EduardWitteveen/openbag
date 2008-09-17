package org.nergens.bag.lvkoppeling;

// import javax.management.modelmbean.RequiredModelMBean;

import nl.egem.www.stuf.stuf0205.Stuurgegevens_type0;
import nl.vrom.www.bag.stuf._0120.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setProperty("javax.net.debug", "all");
		
		// test for sun.security.provider.Sun
		try {
		    Class.forName("com.sun.net.ssl.internal.ssl.Provider");
		    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		}
		catch(Exception e) {
		    System.out.println("JSSE is NOT installed correctly! (com.sun.net.ssl.internal.ssl.Providercom.sun.net.ssl.internal.ssl.Provider)");
		    System.exit(1);
		}
				
		// Enabel SSL via JSSE
		// Needs to be a PKCS#7 format certificate, convert a 
		String KEYSTORE_FILE = new java.io.File(".").getCanonicalPath() +  "/certificate/server.key";
		String PASSWORD = "hawarit";
//		// set trust store
//		System.setProperty("javax.net.ssl.trustStore", KEYSTORE_FILE);
//		System.setProperty("javax.net.ssl.trustStorePassword", PASSWORD);
		// set key store
		System.setProperty("javax.net.ssl.keyStore", KEYSTORE_FILE);
		System.setProperty("javax.net.ssl.keyStorePassword", PASSWORD);
		
//		 use Sun’s reference implementation of a URL handler for the “https” URL protocol type.
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");		
		
		String SERVER_URL = "https://test.baglv.nl/";;
		// test connection
		try {
			URL url = new URL(SERVER_URL);

			System.out.println("open stream");
			BufferedReader in = new BufferedReader(
					new InputStreamReader(url.openStream())
			);
			String line;
			System.out.println("read from server:\n");
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("\nclose connection.");
			in.close();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
		// create the client stub
        STUFBAGSynchroon stub = new STUFBAGSynchroonStub(SERVER_URL);
	    // Create the request
        VraagBericht vraagbericht = new VraagBericht();
        Stuurgegevens_type0 stuurgegevens = new Stuurgegevens_type0();
        vraagbericht.setStuurgegevens(stuurgegevens);
        Body_type1 vraagBody = new Body_type1();
        vraagbericht.setBody(vraagBody);
        // Invoke the service
        SynchroonAntwoordBericht antwoord = stub.beantwoordVraag(vraagbericht);
        Body_type2 antwoordBody = antwoord.getBody();
        System.out.println(antwoordBody.toString());
	}
}
