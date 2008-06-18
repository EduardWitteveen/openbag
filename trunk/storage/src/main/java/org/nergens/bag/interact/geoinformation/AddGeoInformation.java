package org.nergens.bag.interact.geoinformation;

import com.vividsolutions.jts.geom.Polygon;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.nergens.bag.storage.pojo.Gemeente;
import org.nergens.bag.storage.pojo.Nummeraanduiding;
import org.nergens.bag.storage.pojo.Openbareruimte;
import org.nergens.bag.storage.pojo.Pand;
import org.nergens.bag.storage.pojo.Verblijfsobject;
import org.nergens.bag.storage.util.HibernateFactory;

/**
 *
 * @author Eduard Witteveen
 */
public class AddGeoInformation {
    private static Logger log = Logger.getLogger(AddGeoInformation.class.getName());
    
    public static void main(String[] args) {
        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        // UPDATE DE GEMEENTE GRENZEN
        log.info("Update the gemeentegrenzen");
        List<Gemeente> gemeenten = session.createQuery("from Gemeente").list();
        for (Gemeente gemeente : gemeenten) {
            // retrieve the data for this gemeente
            String sql = "select aggr_union(woonplaats.grens) "; 
            sql += "from Woonplaats woonplaats ";
            sql += "where woonplaats.gemeente = :gemeente";
            Query query = session.createQuery(sql);
            query.setParameter("gemeente", gemeente);
            Polygon grens = (Polygon)query.uniqueResult();
            gemeente.setGrens(grens);
            session.save(gemeente);
        }      
        // UPDATE DE NUMMERAANDUIDING COORDS, VOOR DE ONBEKENDEN
        log.info("Update the nummeraanduiding");
        List<Verblijfsobject> verblijfsobjecten = session.createQuery("from Verblijfsobject verblijfsobject where verblijfsobject.hoofdadres.punt is null").list();
        for (Verblijfsobject verblijfsobject : verblijfsobjecten) {
            Nummeraanduiding na = verblijfsobject.getHoofdadres();
            na.setPunt(na.getPunt());
            session.save(na);
        }
        // UPDATE DE OPENBARERUIMTE POLYGON, VOOR DE ONBEKENDEN
        log.info("Update the openbareruimte");
        List<Openbareruimte> openbareruimten = session.createQuery("from Openbareruimte openbareruimte where openbareruimte.grens is null").list();
        for (Openbareruimte openbareruimte : openbareruimten) {
            // retrieve the data for this gemeente
            String sql = "select aggr_convexhull(nummeraanduiding.punt) "; 
            sql += "from Nummeraanduiding nummeraanduiding ";
            sql += "where nummeraanduiding.openbareruimte = :openbareruimte";
            Query query = session.createQuery(sql);
            query.setParameter("openbareruimte", openbareruimte);
            Polygon grens = (Polygon)query.uniqueResult();
            openbareruimte.setGrens(grens);                
            session.save(openbareruimte);
        }
        // UPDATE DE VERBLIJFSOBJECT IN PAND(-EN)
        log.info("Update the pand <--> verblijfsobject");
        // Iterate over de verblijfsobjecten en zie welke panden het in ligt
        // (immers elk verblijfsobject zou in een pand moeten liggen)
        // TODO: do we want a filter here?
        /**
         * SELECT   
         *   DATA_NUMMERAANDUIDING.CODE AS NUMMERAANDUIDING_CODE,
         *   DATA_PAND.CODE AS PAND_CODE,
         *   DATA_PAND.GRENS, 
         *   DATA_NUMMERAANDUIDING.PUNT
         * FROM DATA_NUMMERAANDUIDING
         * INNER JOIN DATA_PAND
         * ON SDO_GEOM.RELATE(DATA_NUMMERAANDUIDING.PUNT, 'INSIDE', DATA_PAND.GRENS, 0.001) = 'TRUE'
         * 
         * 
         * ANALYZE TABLE data_object COMPUTE STATISTICS;
         * ANALYZE TABLE data_authentiek COMPUTE STATISTICS;
         * ANALYZE TABLE data_verblijfsplaats COMPUTE STATISTICS;
         * ANALYZE TABLE data_verblijfsobject COMPUTE STATISTICS;
         * */
        verblijfsobjecten = session.createQuery("from Verblijfsobject verblijfsobject where verblijfsobject.code = 1680010000000001").list();
        for (Verblijfsobject verblijfobject : verblijfsobjecten) {
            // retrieve the pand(-en) for this verblijfsobject
            Query query = session.createQuery("from Pand pand where contains(pand.grens, :punt) = true");
            query.setParameter("punt", verblijfobject.getPunt());
            List<Pand> panden = query.list(); 
            verblijfobject.setPanden(new HashSet<Pand>(panden));
            session.save(verblijfobject);
        }
        // store the data,..
        session.getTransaction().commit();
    }
}
