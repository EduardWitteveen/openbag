package org.nergens.bag.storage;

/*
 * This main function will export all data from the database to csv files
 * When there is no data, it will import all available data into the database
 */

import java.io.FileNotFoundException;
import java.io.IOException;
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
                log.info("import failed!");
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
}
