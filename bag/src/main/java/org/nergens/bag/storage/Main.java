package org.nergens.bag.storage;

/*
 * This main function will export all data from the database to csv files
 * When there is no data, it will import all available data into the database
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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
                System.out.println("import succesfull to transaction!");
            }
            else {
                System.out.println("import failed!");
            }
        }
        else {
            // export the data
            for (Gemeente gemeente : gemeenten) {
                System.out.println(gemeente);
                // woonplaats
                java.util.Iterator<Woonplaats> woonplaatsen = gemeente.getWoonplaatsen().iterator();
                while(woonplaatsen.hasNext()) {
                	Woonplaats woonplaats = woonplaatsen.next();     
                    System.out.println(woonplaats);
                    // openbareruimte
                    java.util.Iterator<Openbareruimte> openbareruimten = woonplaats.getOpenbareruimten().iterator();
                    while(openbareruimten.hasNext()) {
                    	Openbareruimte openbareruimte = openbareruimten.next();     
                        System.out.println(openbareruimte);
                        // nummeraanduiding
                        java.util.Iterator<Nummeraanduiding> nummeraanduidingen = openbareruimte.getNummeraanduidingen().iterator();
                        while(nummeraanduidingen.hasNext()) {
                        	Nummeraanduiding nummeraanduiding = nummeraanduidingen.next();     
                            System.out.println(nummeraanduiding);
                        }                        
                    }
                }
                // verblijfsobject
                java.util.Iterator<Verblijfsobject> verblijfsobjecten = gemeente.getVerblijfsobjecten().iterator();
                while(verblijfsobjecten.hasNext()) {
                	Verblijfsobject verblijfsobject = verblijfsobjecten.next();                
                    System.out.println(verblijfsobject);
                }
                // pand
                java.util.Iterator<Pand> panden = gemeente.getPanden().iterator();
                while(panden.hasNext()) {
                	Pand pand = panden.next();        
                    System.out.println(pand);
                }            
            }
        }
        System.out.println("start transaction commit");
        session.getTransaction().commit();
        System.out.println("done transaction commit");
    }
}
