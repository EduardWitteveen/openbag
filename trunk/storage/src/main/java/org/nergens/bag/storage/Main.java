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
                loadVromData(session);
                log.info("Loaded VROM data");
                session.flush();
                session.clear();
                trans.exportToFormat(session);
                log.info("export data succesfull to csv files");
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
    private static void loadVromData(Session session)  {
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
        // TODO: pand
        // TODO: verblijsobject
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
