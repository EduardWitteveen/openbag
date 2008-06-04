package org.nergens.bag.storage.util;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.*;
/**
 *
 * @author Eduard Witteveen
 */
public class HibernateFactory {
    private static String RESOURCE_NAME = "bag.cfg.xml";
    private static final SessionFactory sessionFactory;            
    static {
        try {
            AnnotationConfiguration annotation = new AnnotationConfiguration();            
            // We have to find our bag.cfg.xml            
            File file = new File(RESOURCE_NAME);
            System.out.println("looking for config:" + file.getAbsolutePath());
            if(file.exists() && file.canRead()) {
                // first look in our root (so it can be overriden)
                annotation = annotation.configure(file);
                
            }
            else {
                System.out.println("could not find the file:" + file.getAbsolutePath());
                System.out.println("working directory:" + System.getProperty("user.dir"));
                file = new File("./../Storage/src/" + RESOURCE_NAME);
                System.out.println("looking for config:" + file.getAbsolutePath());
                if(file.exists() && file.canRead()) {
                    // first look in our root (so it can be overriden)
                    annotation = annotation.configure(file);                
                }
                else {
                    System.out.println("could not find the file:" + file.getAbsolutePath());
                    throw new RuntimeException("file:" + RESOURCE_NAME + " was not found!");
                }
            }                        
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = annotation.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}