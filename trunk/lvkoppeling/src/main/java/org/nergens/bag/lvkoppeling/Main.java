package org.nergens.bag.lvkoppeling;

import nl.egem.www.stuf.stuf0205.Administratie_type1;
import nl.egem.www.stuf.stuf0205.Applicatie_type0;
import nl.egem.www.stuf.stuf0205.Applicatie_type1;
import nl.egem.www.stuf.stuf0205.Berichtsoort_type1;
import nl.egem.www.stuf.stuf0205.Gebruiker_type1;
import nl.egem.www.stuf.stuf0205.Organisatie_type1;
import nl.egem.www.stuf.stuf0205.RefNummer;
import nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0;
import nl.egem.www.stuf.stuf0205.Stuurgegevens_type0;
import nl.egem.www.stuf.stuf0205.Systeem;
import nl.egem.www.stuf.stuf0205.Tijdstip;
import nl.egem.www.stuf.stuf0205.Versienr;
import nl.vrom.www.bag.stuf._0120.*;

public class Main {
	private static VraagBericht getVraagBericht() {
        VraagBericht vraagbericht = new VraagBericht();
        Stuurgegevens_type0 stuurgegevens = new Stuurgegevens_type0();
        Berichtsoort_type1 berichtsoort =new Berichtsoort_type1();
        berichtsoort.setBerichtsoort_type0("Fo01");
        stuurgegevens.setBerichtsoort(berichtsoort);
        stuurgegevens.setSectormodel("sectormodel");
        Versienr versienrStUF = new Versienr();
        versienrStUF.setVersienr("0205");
        stuurgegevens.setVersieStUF(versienrStUF);
        Versienr versienrSectormodel = new Versienr();
        versienrSectormodel.setVersienr("0205");        
        stuurgegevens.setVersieSectormodel(versienrSectormodel);
        Systeem systeem = new Systeem();
        Applicatie_type1 applicatie = new Applicatie_type1();
        applicatie.setApplicatie_type0("OpenBAG");
        systeem.setApplicatie(applicatie);
        Administratie_type1 administratie = new Administratie_type1();
        administratie.setAdministratie_type0("?");
        systeem.setAdministratie(administratie);
        Gebruiker_type1 gebruiker = new Gebruiker_type1();
        gebruiker.setGebruiker_type0("Eduard Witteveen");
        systeem.setGebruiker(gebruiker);
        Organisatie_type1 organisatie = new Organisatie_type1();
        organisatie.setOrganisatie_type0("Hawar IT");
        systeem.setOrganisatie(organisatie);
        stuurgegevens.setZender(systeem); 
        // do we need another systeem here?
        stuurgegevens.setOntvanger(systeem);
        RefNummer refnummer = new RefNummer();
        refnummer.setRefNummer("1");
        stuurgegevens.setReferentienummer(refnummer);
        Tijdstip tijdstip = new Tijdstip();
        tijdstip.setTijdstip("2008080815000000");
        stuurgegevens.setTijdstipBericht(tijdstip);
        StuurgegevensChoice_type0 stuurgegevensChoice = new StuurgegevensChoice_type0();
        stuurgegevens.setStuurgegevensChoice_type0(stuurgegevensChoice);
        vraagbericht.setStuurgegevens(stuurgegevens);
        Body_type1 vraagBody = new Body_type1();
        vraagbericht.setBody(vraagBody);
        return vraagbericht;
	}
	public static void main(String[] args) throws Exception {
		String SERVER_URL = "https://test.baglv.nl/";
		String KEYSTORE_FILE = new java.io.File(".").getCanonicalPath() +  "/certificate/hawarit-javakeystore.jks";
		String KEYSTORE_PASSWORD = "hawarit";
		String TRUSTSTORE_FILE = new java.io.File(".").getCanonicalPath() +  "/jssecacerts";
		//String TRUSTSTORE_PASSWORD = "hawarit";
		
		// System.setProperty("javax.net.debug", "all");

		// test for sun.security.provider.Sun
		try {
		    Class.forName("com.sun.net.ssl.internal.ssl.Provider");
		}
		catch(Exception e) {
		    System.out.println("JSSE is NOT installed correctly! (com.sun.net.ssl.internal.ssl.Providercom.sun.net.ssl.internal.ssl.Provider)");
		    System.exit(1);
		}
	    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());		
					    	    
		// Enabel SSL via JSSE
	    java.io.File file = new java.io.File(KEYSTORE_FILE);
	    if(!file.exists()) {
		    System.out.println("Keystore:" + KEYSTORE_FILE + " does not exist");
		    System.exit(1);	 
	    }
		System.setProperty("javax.net.ssl.trustStore", TRUSTSTORE_FILE);
		//System.setProperty("javax.net.ssl.trustStorePassword", TRUSTSTORE_PASSWORD);			    
		System.setProperty("javax.net.ssl.keyStore", KEYSTORE_FILE);
		System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);		
		
		// create the client stub
        STUFBAGSynchroon stub = new STUFBAGSynchroonStub(SERVER_URL);
	    // Create the request
        VraagBericht vraagbericht = getVraagBericht();
        // Invoke the service
        System.out.println("Sending:" + vraagbericht.toString());
        SynchroonAntwoordBericht antwoord = stub.beantwoordVraag(vraagbericht);
        Body_type2 antwoordBody = antwoord.getBody();
        System.out.println("Received:" + antwoordBody.toString());
	}
}
