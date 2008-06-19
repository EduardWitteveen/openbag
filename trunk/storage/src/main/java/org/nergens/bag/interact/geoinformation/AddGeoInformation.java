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
            gemeente.setBagObject(false);
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
        verblijfsobjecten = session.createQuery("from Verblijfsobject verblijfsobject").list();
        log.info("Retrieved all verblijfsobjecten, now iterating");
        for (Verblijfsobject verblijfobject : verblijfsobjecten) {
            try {
                // retrieve the pand(-en) for this verblijfsobject
                // does not work!! 
                /*
                Query query = session.createQuery("from Pand pand where within(pand.grens, :punt) = true");            
                query.setParameter("punt", verblijfobject.getPunt());
                List<Pand> panden = query.list();
                verblijfobject.setPanden(new HashSet<Pand>(panden));
                */

                // START WORKAROUND!!
                // http://www.oreillynet.com/pub/a/network/2003/11/10/oracle_spatial.html?page=2
                String sql = "SELECT data_pand.code\n";
                sql += "FROM data_verblijfsobject\n";
                sql += "LEFT JOIN data_pand\n";
                sql += "ON MDSYS.SDO_FILTER(data_verblijfsobject.punt, data_pand.grens, 'querytype = JOIN') = 'TRUE' \n";
                sql += "AND MDSYS.SDO_RELATE(data_verblijfsobject.punt, data_pand.grens, 'mask = INSIDE querytype = JOIN') = 'TRUE'\n";
                sql += "WHERE data_verblijfsobject.code = :verblijfsobjectcode\n";
                Query query = session.createSQLQuery(sql);
                query.setParameter("verblijfsobjectcode", verblijfobject.getCode());
                log.info("Checking verblijsobject:" + verblijfobject.getCode());
                List<java.math.BigDecimal> pandcodes = query.list();
                Set panden = new HashSet<Pand>();
                for(java.math.BigDecimal code: pandcodes) {
                    Query qpand = session.createQuery("from Pand pand where pand.code = :code");
                    qpand.setParameter("code", code.longValue());
                    log.info("Found pand:" + code.longValue() + "verblijsobject:" + verblijfobject.getCode());
                    panden.add(qpand.uniqueResult());
                }
                verblijfobject.setPanden(panden);
                // END WORKAROUND!!

                session.save(verblijfobject);
            }
            catch(Exception e) {
                // protect our mainloop
                e.printStackTrace();
            }
        }
        // store the data,..
        session.getTransaction().commit();
    }
}
