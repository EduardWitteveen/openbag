package org.nergens.bag.storage;

/*
 * This main function will export all data from the database to csv files
 * When there is no data, it will import all available data into the database
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.nergens.bag.storage.pojo.*;
import org.nergens.bag.storage.pojo.util.Gebruiksdoel;
import org.nergens.bag.storage.util.HibernateFactory;
import org.nergens.bag.transformations.Transformator;
import org.nergens.bag.transformations.csv.CsvTransformator;
/**
 *
 * @author Eduard Witteveen
 */
public class Main {
	private static Logger log = Logger.getLogger(Main.class.getName());
	
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException {
        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        // start our transaction
        session.beginTransaction();        
        List<Gemeente> gemeenten = session.createQuery("from Gemeente").list();
        if(gemeenten.size() == 0) {
            // when we have no data, try to import data 
            // use the cvs files to fill our system
            Transformator trans = new CsvTransformator();
            if(trans.retrieveFromFormat(session))  {
                log.info("import succesfull to transaction!");
            }
            else {
                // we will load the data as supplied by VROM
                // in "Processenhandboek Basisregistraties voor Adressen en Gebouwen"
                loadVromData_1_6(session);
                log.info("Loaded VROM data");
                session.flush();
                session.clear();
                if(trans.exportToFormat(session)) {
                    log.info("export data succesfull to csv files");
                }
                else {
                    log.info("failure while exporting the csv-data");
                }
            }
        }
        else {
            // export the data
            for (Gemeente gemeente : gemeenten) {
                log.info(gemeente.toString());
                // woonplaats
                java.util.Iterator<Woonplaats> woonplaatsen = gemeente.getWoonplaatsen().iterator();
                while(woonplaatsen.hasNext()) {
                	Woonplaats woonplaats = woonplaatsen.next();     
                    log.info(woonplaats.toString());
                    // openbareruimte
                    java.util.Iterator<Openbareruimte> openbareruimten = woonplaats.getOpenbareruimten().iterator();
                    while(openbareruimten.hasNext()) {
                    	Openbareruimte openbareruimte = openbareruimten.next();     
                        log.info(openbareruimte.toString());
                        // nummeraanduiding
                        java.util.Iterator<Nummeraanduiding> nummeraanduidingen = openbareruimte.getNummeraanduidingen().iterator();
                        while(nummeraanduidingen.hasNext()) {
                        	Nummeraanduiding nummeraanduiding = nummeraanduidingen.next();     
                            log.info(nummeraanduiding.toString());
                        }                        
                    }
                }
            }
            // verblijfsobject
            List<Verblijfsobject> verblijfsobjecten = session.createQuery("from Verblijfsobject").list();
            for (Verblijfsobject verblijfsobject : verblijfsobjecten) { 
                log.info(verblijfsobject.toString());
            }
            // pand
		    List<Pand> panden = session.createQuery("from Pand").list();
		    for (Pand pand : panden) {
		        log.info(pand.toString());
		    }
        }
        log.info("start transaction commit");
        session.getTransaction().commit();
        log.info("done transaction commit");
    }
    private static void loadVromData_1_6(Session session)  {
        HashMap cache= new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {                            
        // no gemeente in VROM data, but we need it for the application
            Gemeente gemeente = new Gemeente();
            gemeente.setCode(1000);
            gemeente.setNaam("VROM fictieve gemeente");        
            session.save(gemeente);        
        // woonplaats: blz 11
            Woonplaats woonplaats = new Woonplaats();
            woonplaats.setGemeente(gemeente);
            woonplaats.setCode(246);
            woonplaats.setNaam("Het Dorp");
            woonplaats.setBeginGeldigheid(formatter.parse("9-6-1968"));
            woonplaats.setStatus("Woonplaats aangewezen");
            woonplaats.setDocumentDatum(formatter.parse("9-6-1968"));
            woonplaats.setDocumentNummer("936");
            session.save(woonplaats);
            cache.put(woonplaats.getCode(), woonplaats);
            
            woonplaats = new Woonplaats();
            woonplaats.setGemeente(gemeente);
            woonplaats.setCode(247);
            woonplaats.setNaam("Oostdorp");
            woonplaats.setBeginGeldigheid(formatter.parse("9-6-1968"));
            woonplaats.setStatus("Woonplaats aangewezen");
            woonplaats.setDocumentDatum(formatter.parse("9-6-1968"));
            woonplaats.setDocumentNummer("936");
            session.save(woonplaats);
            cache.put(woonplaats.getCode(), woonplaats);            
            
        // openbare ruimte blz 10
            Openbareruimte openbareruimte = new Openbareruimte();
            openbareruimte.setCode(95);
            openbareruimte.setNaam("Hyacinten laan");
            openbareruimte.setWoonplaats((Woonplaats)cache.get(new Long(246)));
            openbareruimte.setBeginGeldigheid(formatter.parse("1-7-1980"));
            openbareruimte.setStatus("Naamgeving uitgegeven");
            openbareruimte.setDocumentDatum(formatter.parse("1-7-1980"));
            openbareruimte.setDocumentNummer("2468");
            session.save(openbareruimte);
            cache.put(openbareruimte.getCode(), openbareruimte);
            
            openbareruimte = new Openbareruimte();
            openbareruimte.setCode(96);
            openbareruimte.setNaam("Crocussen laan");
            openbareruimte.setWoonplaats((Woonplaats)cache.get(new Long(246)));
            openbareruimte.setBeginGeldigheid(formatter.parse("8-6-1980"));
            openbareruimte.setStatus("Naamgeving uitgegeven");
            openbareruimte.setDocumentDatum(formatter.parse("8-6-1980"));
            openbareruimte.setDocumentNummer("2769");
            session.save(openbareruimte);
            cache.put(openbareruimte.getCode(), openbareruimte);
            
            openbareruimte = new Openbareruimte();
            openbareruimte.setCode(97);
            openbareruimte.setNaam("Narcissen laan");
            openbareruimte.setWoonplaats((Woonplaats)cache.get(new Long(246)));
            openbareruimte.setBeginGeldigheid(formatter.parse("1-7-1980"));
            openbareruimte.setStatus("Naamgeving uitgegeven");
            openbareruimte.setDocumentDatum(formatter.parse("1-7-1980"));
            openbareruimte.setDocumentNummer("2468");
            session.save(openbareruimte);
            cache.put(openbareruimte.getCode(), openbareruimte);
                        
            openbareruimte = new Openbareruimte();
            openbareruimte.setCode(98);
            openbareruimte.setNaam("Steegje");
            openbareruimte.setWoonplaats((Woonplaats)cache.get(new Long(246)));
            openbareruimte.setBeginGeldigheid(formatter.parse("1-7-1995"));
            openbareruimte.setStatus("Naamgeving uitgegeven");
            openbareruimte.setDocumentDatum(formatter.parse("1-7-1995"));
            openbareruimte.setDocumentNummer("4203");
            session.save(openbareruimte);
            cache.put(openbareruimte.getCode(), openbareruimte);
            
            openbareruimte = new Openbareruimte();
            openbareruimte.setCode(103);
            openbareruimte.setNaam("Boterbloem laan");
            openbareruimte.setWoonplaats((Woonplaats)cache.get(new Long(246)));
            openbareruimte.setBeginGeldigheid(formatter.parse("1-7-1980"));
            openbareruimte.setStatus("Naamgeving uitgegeven");
            openbareruimte.setDocumentDatum(formatter.parse("1-7-1980"));
            openbareruimte.setDocumentNummer("2468");
            session.save(openbareruimte);
            cache.put(openbareruimte.getCode(), openbareruimte);
            
        // nummeraanduiding: blz 9
            Nummeraanduiding nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12349);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(10));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12350);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(12));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12351);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(14));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);        

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12352);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(16));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);                    

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12353);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(18));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("25-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("25-1-2006"));
            nummeraanduiding.setDocumentNummer("55286");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);      
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12354);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(4));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12355);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(6));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
           
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12356);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(8));
            nummeraanduiding.setBeginGeldigheid(formatter.parse("31-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("31-1-2006"));
            nummeraanduiding.setDocumentNummer("53429");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12357);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(10));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("15-8-2005"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("15-8-2005"));
            nummeraanduiding.setDocumentNummer("53422");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12358);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(12));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);                        

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12359);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(14));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("31-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("31-1-2006"));
            nummeraanduiding.setDocumentNummer("53431");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);   
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12360);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(16));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("53550");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);  

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12361);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(18));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("42386");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12362);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(24));
            nummeraanduiding.setBeginGeldigheid(formatter.parse("31-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("31-1-2006"));
            nummeraanduiding.setDocumentNummer("53435");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding); 
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12363);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(20));
            nummeraanduiding.setPostcode("1954RR");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("53550");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);       
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12364);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(98)));
            nummeraanduiding.setHuisnummer(new Long(2));
            nummeraanduiding.setPostcode("1954AM");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("31-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("31-1-2006"));
            nummeraanduiding.setDocumentNummer("53885");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12493);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(42));
            nummeraanduiding.setPostcode("1954AH");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("44884");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12500);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(100));
            nummeraanduiding.setPostcode("1954NC");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("25-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("25-1-2006"));
            nummeraanduiding.setDocumentNummer("55500");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
                        
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12501);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(101));
            nummeraanduiding.setPostcode("1954NC");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("25-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("25-1-2006"));
            nummeraanduiding.setDocumentNummer("55500");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);            
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12600);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(40));
            nummeraanduiding.setPostcode("1954LT");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("25-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("25-1-2006"));
            nummeraanduiding.setDocumentNummer("55500");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);                        

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12601);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(96)));
            nummeraanduiding.setHuisnummer(new Long(42));
            nummeraanduiding.setPostcode("1954LT");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("25-1-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("25-1-2006"));
            nummeraanduiding.setDocumentNummer("55500");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);                        

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12735);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(22));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);                        

            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12736);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(24));
            nummeraanduiding.setPostcode("1954ML");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("36483");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12737);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(24));
            nummeraanduiding.setHuisletter("A");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("28-3-2006"));
            nummeraanduiding.setStatus("Naamgeving ingetrokken");
            nummeraanduiding.setDocumentDatum(formatter.parse("28-3-2006"));
            nummeraanduiding.setDocumentNummer("16307");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12738);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(26));
            nummeraanduiding.setBeginGeldigheid(formatter.parse("28-3-2006"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("28-3-2006"));
            nummeraanduiding.setDocumentNummer("17307");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
                        
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12828);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(103)));
            nummeraanduiding.setHuisnummer(new Long(2));
            nummeraanduiding.setPostcode("1954AM");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("34398");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12829);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(103)));
            nummeraanduiding.setHuisnummer(new Long(3));
            nummeraanduiding.setPostcode("1954AM");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("34399");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
            
            nummeraanduiding = new Nummeraanduiding();
            nummeraanduiding.setCode(12922);
            nummeraanduiding.setOpenbareruimte((Openbareruimte)cache.get(new Long(95)));
            nummeraanduiding.setHuisnummer(new Long(34));
            nummeraanduiding.setPostcode("1954AM");
            nummeraanduiding.setBeginGeldigheid(formatter.parse("1-7-1980"));
            nummeraanduiding.setStatus("Naamgeving uitgegeven");
            nummeraanduiding.setDocumentDatum(formatter.parse("1-7-1980"));
            nummeraanduiding.setDocumentNummer("64833");
            session.save(nummeraanduiding);
            cache.put(nummeraanduiding.getCode(), nummeraanduiding);
                        
        // pand: blz 8
            Pand pand = new Pand();            
            pand.setCode(406);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");            
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("41475");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(407);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("41475");            
            session.save(pand);
            cache.put(pand.getCode(), pand);
 
            pand = new Pand();
            pand.setCode(408);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("41475");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(409);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("41475");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(410);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("25-1-2006"));
            pand.setStatus("pand in gebruik(niet ingemeten)");
            pand.setDocumentDatum(formatter.parse("25-1-2006"));
            pand.setDocumentNummer("83831");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(411);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("41475");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(412);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("31-1-2006"));
            pand.setStatus("bouwvergunning verleend");
            pand.setDocumentDatum(formatter.parse("31-1-2006"));
            pand.setDocumentNummer("14430");            
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(413);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("15-8-2005"));
            pand.setStatus("bouw gestart");
            pand.setDocumentDatum(formatter.parse("15-8-2005"));
            pand.setDocumentNummer("14380");            
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(414);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("15-8-2005"));
            pand.setStatus("sloopvergunning verleend");
            pand.setDocumentDatum(formatter.parse("31-1-2006"));
            pand.setDocumentNummer("14388");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(415);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("31-1-2006"));
            pand.setStatus("bouwvergunning verleend");
            pand.setDocumentDatum(formatter.parse("31-1-2006"));
            pand.setDocumentNummer("14389");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(416);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("14389");            
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(417);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("42386");            
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(418);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("31-1-2006"));
            pand.setStatus("bouwvergunning verleend");
            pand.setDocumentDatum(formatter.parse("31-1-2006"));
            pand.setDocumentNummer("14430");            
            session.save(pand);
            cache.put(pand.getCode(), pand);

            pand = new Pand();
            pand.setCode(419);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("42394");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(441);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("44884");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(629);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("14388");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(630);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-2005"));
            pand.setStatus("pand in gebruik(niet ingemeten)");
            pand.setDocumentDatum(formatter.parse("1-7-2005"));
            pand.setDocumentNummer("20486");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(631);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("28-3-2006"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("28-3-2006"));
            pand.setDocumentNummer("16307");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(632);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(2006);
            pand.setBeginGeldigheid(formatter.parse("28-3-2006"));
            pand.setStatus("pand in gebruik(niet ingemeten)");
            pand.setDocumentDatum(formatter.parse("28-3-2006"));
            pand.setDocumentNummer("17307");
            session.save(pand);
            cache.put(pand.getCode(), pand);
            
            pand = new Pand();
            pand.setCode(635);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("62282");
            session.save(pand);
            cache.put(pand.getCode(), pand);            

            pand = new Pand();
            pand.setCode(636);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("62283");
            session.save(pand);
            cache.put(pand.getCode(), pand);            
            
            pand = new Pand();
            pand.setCode(816);
            pand.setGemeente(gemeente);
            pand.setBouwjaar(1980);
            pand.setBeginGeldigheid(formatter.parse("1-7-1980"));
            pand.setStatus("pand in gebruik");
            pand.setDocumentDatum(formatter.parse("1-7-1980"));
            pand.setDocumentNummer("14754");
            session.save(pand);
            cache.put(pand.getCode(), pand);            

            // benodigde gebruiksdoeleinden
            Gebruiksdoel gebruiksdoel =  new Gebruiksdoel();
            gebruiksdoel.setNaam("woon functie");
            session.save(gebruiksdoel);
            cache.put(gebruiksdoel.getNaam(), gebruiksdoel);            
            
            // verblijsobject: blz 9
            Verblijfsobject verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234793);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12349)));
            verblijfsobject.addPand((Pand)cache.get(new Long(407)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);            
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);                        
                      
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234794);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12350)));
            verblijfsobject.addPand((Pand)cache.get(new Long(407)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(190);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);                        

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234795);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12351)));
            verblijfsobject.addPand((Pand)cache.get(new Long(408)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);            

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234796);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12352)));
            verblijfsobject.addPand((Pand)cache.get(new Long(409)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(400);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234797);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12353)));
            verblijfsobject.addPand((Pand)cache.get(new Long(410)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("25-1-2006"));
            verblijfsobject.setStatus("verblijfsobject in gebruik (niet ingemeten)");
            verblijfsobject.setDocumentDatum(formatter.parse("25-1-2006"));
            verblijfsobject.setDocumentNummer("83831");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234798);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12354)));
            verblijfsobject.addPand((Pand)cache.get(new Long(411)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234799);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12355)));
            verblijfsobject.addPand((Pand)cache.get(new Long(406)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234800);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12356)));
            verblijfsobject.addPand((Pand)cache.get(new Long(412)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("31-1-2006"));
            verblijfsobject.setStatus("verblijfsobject gevormd");
            verblijfsobject.setDocumentDatum(formatter.parse("31-1-2006"));
            verblijfsobject.setDocumentNummer("14430");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234801);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12357)));
            verblijfsobject.addPand((Pand)cache.get(new Long(413)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(200);
            verblijfsobject.setBeginGeldigheid(formatter.parse("15-8-2005"));
            verblijfsobject.setStatus("verblijfsobject gevormd");
            verblijfsobject.setDocumentDatum(formatter.parse("15-8-2005"));
            verblijfsobject.setDocumentNummer("62146");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234802);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12358)));
            verblijfsobject.addPand((Pand)cache.get(new Long(414)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
 
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234803);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12359)));
            verblijfsobject.addPand((Pand)cache.get(new Long(415)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("31-1-2006"));
            verblijfsobject.setStatus("verblijfsobject gevormd");
            verblijfsobject.setDocumentDatum(formatter.parse("31-1-2006"));
            verblijfsobject.setDocumentNummer("14389");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);       
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234804);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12360)));
            verblijfsobject.addPand((Pand)cache.get(new Long(416)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("42385");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);   
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234805);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12361)));
            verblijfsobject.addPand((Pand)cache.get(new Long(417)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("42386");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234806);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12362)));
            verblijfsobject.addPand((Pand)cache.get(new Long(418)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("31-1-2006"));
            verblijfsobject.setStatus("verblijfsobject gevormd");
            verblijfsobject.setDocumentDatum(formatter.parse("31-1-2006"));
            verblijfsobject.setDocumentNummer("14430");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(234808);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12363)));
            verblijfsobject.addPand((Pand)cache.get(new Long(419)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("42394");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236889);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12493)));
            verblijfsobject.addPand((Pand)cache.get(new Long(441)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(90);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("44884");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
  
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236806);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12735)));
            verblijfsobject.addPand((Pand)cache.get(new Long(629)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("41475");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236807);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12736)));
            verblijfsobject.addPand((Pand)cache.get(new Long(630)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(190);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-2005"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-2005"));
            verblijfsobject.setDocumentNummer("36483");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  
            
            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236808);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12737)));
            verblijfsobject.addPand((Pand)cache.get(new Long(631)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("28-3-2006"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("28-3-2006"));
            verblijfsobject.setDocumentNummer("16307");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236809);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12738)));
            verblijfsobject.addPand((Pand)cache.get(new Long(632)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("28-3-2006"));
            verblijfsobject.setStatus("verblijfsobject in gebruik (niet ingemeten)");
            verblijfsobject.setDocumentDatum(formatter.parse("28-3-2006"));
            verblijfsobject.setDocumentNummer("17307");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);  

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236828);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12828)));
            verblijfsobject.addPand((Pand)cache.get(new Long(635)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(100);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("62282");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);              

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(236829);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12829)));
            verblijfsobject.addPand((Pand)cache.get(new Long(636)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(100);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("62283");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);              

            verblijfsobject = new Verblijfsobject();
            verblijfsobject.setCode(123684);
            verblijfsobject.setGemeente(gemeente);
            verblijfsobject.setHoofdadres((Nummeraanduiding)cache.get(new Long(12922)));
            verblijfsobject.addPand((Pand)cache.get(new Long(816)));
            verblijfsobject.addGebruiksdoeleind((Gebruiksdoel)cache.get("woon functie"));
            verblijfsobject.setOppervlakte(180);
            verblijfsobject.setBeginGeldigheid(formatter.parse("1-7-1980"));
            verblijfsobject.setStatus("verblijfsobject in gebruik");
            verblijfsobject.setDocumentDatum(formatter.parse("1-7-1980"));
            verblijfsobject.setDocumentNummer("14754");
            session.save(verblijfsobject);
            cache.put(verblijfsobject.getCode(), verblijfsobject);
            
            // Standplaats: blz 11
            Standplaats standplaats = new Standplaats();
            standplaats.setCode(72100);
            standplaats.setGemeente(gemeente);
            standplaats.setHoofdadres((Nummeraanduiding)cache.get(new Long(12500)));
            standplaats.setBeginGeldigheid(formatter.parse("25-1-2006"));
            standplaats.setStatus("Plaats aangewezen");
            standplaats.setDocumentDatum(formatter.parse("25-1-2006"));
            standplaats.setDocumentNummer("55500");
            session.save(standplaats);
            cache.put(standplaats.getCode(), standplaats);
            
            standplaats = new Standplaats();
            standplaats.setCode(72500);
            standplaats.setGemeente(gemeente);
            standplaats.setHoofdadres((Nummeraanduiding)cache.get(new Long(12501)));
            standplaats.setBeginGeldigheid(formatter.parse("25-1-2006"));
            standplaats.setStatus("Plaats aangewezen");
            standplaats.setDocumentDatum(formatter.parse("25-1-2006"));
            standplaats.setDocumentNummer("55500");
            session.save(standplaats);
            cache.put(standplaats.getCode(), standplaats);            

            // Ligplaats: blz 11
            Ligplaats ligplaats = new Ligplaats();
            ligplaats.setCode(72200);
            ligplaats.setGemeente(gemeente);
            ligplaats.setHoofdadres((Nummeraanduiding)cache.get(new Long(12600)));
            ligplaats.setBeginGeldigheid(formatter.parse("25-1-2006"));
            ligplaats.setStatus("Plaats aangewezen");
            ligplaats.setDocumentDatum(formatter.parse("25-1-2006"));
            ligplaats.setDocumentNummer("55500");
            session.save(ligplaats);
            cache.put(ligplaats.getCode(), ligplaats);
            
            ligplaats = new Ligplaats();
            ligplaats.setCode(72600);
            ligplaats.setGemeente(gemeente);
            ligplaats.setHoofdadres((Nummeraanduiding)cache.get(new Long(12601)));
            ligplaats.setBeginGeldigheid(formatter.parse("25-1-2006"));
            ligplaats.setStatus("Plaats aangewezen");
            ligplaats.setDocumentDatum(formatter.parse("25-1-2006"));
            ligplaats.setDocumentNummer("55500");
            session.save(ligplaats);
            cache.put(ligplaats.getCode(), ligplaats);
        }
        catch (ParseException pe) {
            pe.printStackTrace();
            throw new RuntimeException(pe);
        }
    }
}
