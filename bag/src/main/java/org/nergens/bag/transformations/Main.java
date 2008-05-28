package org.nergens.bag.transformations;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import org.nergens.bag.storage.util.HibernateFactory;
import org.nergens.bag.transformations.csv.CsvTransformator;
/**
 *
 * @author Eduard Witteveen
 */
public class Main {
    public static void main(String[] args) {
        // do some commandline processing
        String direction = null;
        String format = null;
        if(args.length < 1) {
            throw new RuntimeException("usage: [import|export|compare] [csv]");
        }
        direction = args[0];
        format = args[1];
        // load our backend
        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        // our transformers
        HashMap<String,Transformator> transformers = new HashMap<String,Transformator>();
        transformers.put("csv", new CsvTransformator());
        
        // look if the transformer exists
        Transformator trans = null;
        if(transformers.containsKey(format)) {
            trans = transformers.get(format);
            // de we really have to wrap around?
            List<String> aargs = new ArrayList<String>();
            for(String arg : args) {            
                aargs.add(arg);
            }
            // skip the first arguments
            trans.configure(aargs.subList(2, aargs.size()));            
        }                        
        // de we have an import or an export?
        if(trans != null && "import".equals(direction)) {
            trans.retrieveFromFormat(session);
        }
        else if(trans != null && "export".equals(direction)) {
            trans.exportToFormat(session);
        }
        else if(trans != null && "compare".equals(direction)) {
            trans.compareWithFormat(session);        
        }
        else {
            System.out.println("Usage import|export|compare format [formatspecific options]");
            System.out.println("\tThe following formats with options:");
            for(Object oformat: transformers.keySet()) {
                String f= (String)oformat;
                System.out.println("\t\t" + f + "\t:" + transformers.get(f).help());   
            }            
        }
        session.getTransaction().commit();                
    }
}