/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nergens.bag.interact.geotax;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.nergens.bag.storage.pojo.*;
import org.nergens.bag.storage.util.HibernateFactory;

import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author Eduard Witteveen
 */
public class AddGeotaxInformation {
//SELECT
//  -- wozobject
//  WOZOBJECT.WOZOBJEKTNR,
//  WOZOBJECT.IND_HOOFDADRES,
//  -- adres
//  ADRES.STRAATNAAM,
//  ADRES.HUISNR,
//  ADRES.HUISLT,
//  ADRES.HUISTOEV,
//  ADRES.HUISAAND,
//  ADRES.POSTCODE,
//  ADRES.WOONPLAATS,
//  -- kenmerk
//  KENMERK.BOUWJAARVAN AS BOUWJAAR,
//  KENMERK.INHOUD_BTO_HFDGEB AS INHOUD,
//  KENMERK.SOORT_OBJ_GT AS GEBRUIKSCODE,
//  CASE
//    WHEN KENMERK.SOORT_OBJ_GT = 10
//      THEN 'woning dienend tot hoofdverblijf'
//    WHEN KENMERK.SOORT_OBJ_GT = 11
//      THEN 'woning met praktijkruimte'
//    WHEN KENMERK.SOORT_OBJ_GT = 12
//      THEN 'recreatiewoning en overige woningen'
//    WHEN KENMERK.SOORT_OBJ_GT = 20
//      THEN 'boerderij'
//    WHEN KENMERK.SOORT_OBJ_GT = 21
//      THEN 'niet-woning deels in gebruik als woning'
//    WHEN KENMERK.SOORT_OBJ_GT = 30
//      THEN 'niet-woning'
//    WHEN KENMERK.SOORT_OBJ_GT = 31
//      THEN 'uitgezonderd gebouwd object'
//    WHEN KENMERK.SOORT_OBJ_GT = 40
//      THEN 'terrein'
//    WHEN KENMERK.SOORT_OBJ_GT = 80
//      THEN 'uitgezonderd ongebouwd object'
//    WHEN KENMERK.SOORT_OBJ_GT = 90
//      THEN 'sluimerend WOZ-object'
//    ELSE
//      'onbekend gebruikscode:' || KENMERK.SOORT_OBJ_GT
//  END AS GEBRUIKSOMSCHRIJVING,
//  KENMERK.SOORT_OBJ_GEM AS SOORTCODE,
//  SOORT.OMSGEBRUIK AS SOORTOMSCHRIJVING
//FROM GEOTAX.GT_REL_WOZ_ADR WOZOBJECT
//LEFT OUTER JOIN GEOTAX.GT_ADRES ADRES
//ON ADRES.ADRESNR = WOZOBJECT.ADRESNR
//LEFT OUTER JOIN GEOTAX.GT_WOZKENMERK KENMERK
//ON KENMERK.WOZOBJEKTNR = WOZOBJECT.WOZOBJEKTNR
//AND KENMERK.DTB < sysdate
//AND KENMERK.DTE >= sysdate
//LEFT OUTER JOIN GEOTAX.GT_SRT_OBJ_GEM SOORT
//ON SOORT.SOORT_OBJ_GEM = KENMERK.SOORT_OBJ_GEM
//WHERE
// WOZOBJECT.DTB < sysdate
//AND
// WOZOBJECT.DTE >= sysdate
//ORDER BY WOZOBJEKTNR
//
//
//-- WOZ ONDERDEEL
//SELECT 
//  ONDERDEEL.WOZOBJEKTNR, 
//  ONDERDEEL.WOZ_ONDERDLNR,  
//  ONDERDEEL.SRT_WOZ_ONDERDL,
//--??  SOORT.OMSGEBRUIK,
//  ONDERDEEL.BOUWJAARODLVAN,
//  ONDERDEEL.INHOUD,
//  ONDERDEEL.OPP,
//  ONDERDEEL.VWAARDE_ODL_WOZ,
//  OWAARDE_ODL_WOZ  
//FROM GEOTAX.GT_ONDERDEEL ONDERDEEL
//--LEFT OUTER JOIN GEOTAX.??? SOORT
//--ON SOORT.SOORT_OBJ_GEM = ONDERDEEL.SRT_WOZ_ONDERDL
//WHERE
// ONDERDEEL.DTB < sysdate
//AND
// ONDERDEEL.DTE >= sysdate
//-- AND ONDERDEEL.WOZOBJEKTNR = '168040000654'
// ORDER BY ONDERDEEL.WOZOBJEKTNR, ONDERDEEL.WOZ_ONDERDLNR
//
//
//-- WOZ PERCEEL
//SELECT 
//  PERCEEL.WOZOBJEKTNR,
//  PERCEEL.KADGEMCODE,
//  PERCEEL.SECTIE,
//  PERCEEL.PERCEELNR,
//  PERCEEL.TOEG_OPP_KAD
//FROM GEOTAX.GT_REL_WOZ_KAD PERCEEL
//WHERE
// PERCEEL.DTB < sysdate
//AND
// PERCEEL.DTE >= sysdate    
    private static Logger log = Logger.getLogger(AddGeotaxInformation.class.getName());
    private static final java.lang.String BAG_ORACLE_SERVER = "";
    private static final java.lang.Integer BAG_ORACLE_PORT = 1521;
    private static final java.lang.String BAG_ORACLE_SID = "";
    private static final java.lang.String BAG_ORACLE_USERNAME = "";
    private static final java.lang.String BAG_ORACLE_PASSWORD = "";
    private static final java.lang.String BAG_ORACLE_SQL = "SELECT\n" + 
            "   -- wozobject\n" + 
            "   WOZOBJECT.WOZOBJEKTNR,\n" + 
            "   WOZOBJECT.IND_HOOFDADRES,\n" + 
            "   -- adres\n" + 
            "   ADRES.STRAATNAAM,\n" + 
            "   ADRES.HUISNR,\n" + 
            "   ADRES.HUISLT,\n" + 
            "   ADRES.HUISTOEV,\n" + 
            "   ADRES.HUISAAND,\n" + 
            "   ADRES.POSTCODE,\n" + 
            "   ADRES.WOONPLAATS,\n" + 
          "     -- kenmerk\n" + 
          "     KENMERK.BOUWJAARVAN AS BOUWJAAR,\n" + 
          "     KENMERK.INHOUD_BTO_HFDGEB AS INHOUD,\n" + 
          "     KENMERK.SOORT_OBJ_GT AS GEBRUIKSCODE,\n" + 
          "     CASE\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 10\n" + 
          "         THEN 'woning dienend tot hoofdverblijf'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 11\n" + 
          "         THEN 'woning met praktijkruimte'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 12\n" + 
          "         THEN 'recreatiewoning en overige woningen'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 20\n" + 
          "         THEN 'boerderij'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 21\n" + 
          "         THEN 'niet-woning deels in gebruik als woning'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 30\n" + 
          "         THEN 'niet-woning'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 31\n" + 
          "         THEN 'uitgezonderd gebouwd object'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 40\n" + 
          "         THEN 'terrein'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 80\n" + 
          "         THEN 'uitgezonderd ongebouwd object'\n" + 
          "       WHEN KENMERK.SOORT_OBJ_GT = 90\n" + 
          "         THEN 'sluimerend WOZ-object'\n" + 
          "       ELSE\n" + 
          "         'onbekend gebruikscode:' || KENMERK.SOORT_OBJ_GT\n" + 
          "     END AS GEBRUIKSOMSCHRIJVING,\n" + 
          "     KENMERK.SOORT_OBJ_GEM AS SOORTCODE,\n" + 
          "     SOORT.OMSGEBRUIK AS SOORTOMSCHRIJVING\n" + 
          "   FROM GEOTAX.GT_REL_WOZ_ADR WOZOBJECT\n" + 
          "   LEFT OUTER JOIN GEOTAX.GT_ADRES ADRES\n" + 
          "   ON ADRES.ADRESNR = WOZOBJECT.ADRESNR\n" + 
          "   LEFT OUTER JOIN GEOTAX.GT_WOZKENMERK KENMERK\n" + 
          "   ON KENMERK.WOZOBJEKTNR = WOZOBJECT.WOZOBJEKTNR\n" + 
          "   AND KENMERK.DTB < sysdate\n" + 
          "   AND KENMERK.DTE >= sysdate\n" + 
          "   LEFT OUTER JOIN GEOTAX.GT_SRT_OBJ_GEM SOORT\n" + 
          "   ON SOORT.SOORT_OBJ_GEM = KENMERK.SOORT_OBJ_GEM\n" + 
          "   WHERE\n" + 
          "    WOZOBJECT.DTB < sysdate\n" + 
          "   AND\n" + 
          "    WOZOBJECT.DTE >= sysdate\n";
    private static Connection getConnection() throws java.sql.SQLException {        
        log.info("java.library.path:" + System.getProperty("java.library.path"));
        // open bag connection
        OracleDataSource bagOds = new OracleDataSource();
        bagOds.setDriverType("oci");
        bagOds.setNetworkProtocol("tcp");
        bagOds.setServerName(BAG_ORACLE_SERVER);        
        bagOds.setPortNumber(BAG_ORACLE_PORT);
        bagOds.setDatabaseName(BAG_ORACLE_SID);        
        bagOds.setUser(BAG_ORACLE_USERNAME);
        bagOds.setPassword(BAG_ORACLE_PASSWORD);
        log.info("bag url:" + bagOds.getURL());
        Connection bagConn = bagOds.getConnection();
        log.info("We have an bag connection(jdbc-version:" + bagConn.getMetaData().getDriverVersion() + ")");
        bagConn.setAutoCommit(true);        
        return bagConn;
    }
    public static void main(String[] args) throws java.sql.SQLException {
        Connection connection = getConnection();
        // the basic sql is like the following,...
        log.info(BAG_ORACLE_SQL);
        
        // we will now iterate over all the verblijfsobjecten, to see if we 
        // can assign the geotax information:
        //	
        //		verblijfsobject:
        //			- wozobjectnumber
        //			- gebruiksdoeleinden
        //			- oppervlakte
        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();                
        List<Verblijfsobject> verblijfsobjecten = session.createQuery("from Verblijfsobject").list();
        for (Verblijfsobject verblijfsobject : verblijfsobjecten) {
            //log.info(verblijfsobject.toString());
            Nummeraanduiding nummer = verblijfsobject.getHoofdadres();
            //log.info(nummer.toString());
            Long huisnummer = nummer.getHuisnummer(); 
            String huisletter = nummer.getHuisletter();
            String huisnummertoevoeging = nummer.getHuisnummertoevoeging();
            String postcode = nummer.getPostcode();
            Openbareruimte straat = nummer.getOpenbareruimte();
            //log.info(straat.toString());
            String straatnaam = straat.getNaam();
            Woonplaats woonplaats = straat.getWoonplaats();
            //log.info(woonplaats.toString());
            String woonplaatsnaam = woonplaats.getNaam();
            // now we will make a nice sql statement of the stuff above,..
            String sql = BAG_ORACLE_SQL;
            sql += "    -- sepecific filter:\n";
            sql += "AND UPPER(WOONPLAATS) LIKE '" + woonplaatsnaam.toUpperCase() +  "'\n";
            sql += "AND UPPER(STRAATNAAM) LIKE '" + straatnaam.toUpperCase() +  "'\n";
            sql += "AND UPPER(POSTCODE) LIKE '" + postcode.toUpperCase() +  "'\n";
            sql += "AND HUISNR = " + huisnummer +  "\n";
            if(huisletter != null || huisnummertoevoeging != null) {
            	if(huisletter != null) {
                    sql += "AND(\n";
                    sql += "	UPPER(HUISLT) LIKE '" + huisletter.toUpperCase() + "'\n";
                    sql += "	OR	UPPER(HUISTOEV) LIKE '" + huisletter.toUpperCase() + "'\n";
                    sql += "	OR	UPPER(HUISAAND) LIKE '" + huisletter.toUpperCase() + "'\n";
            	}
            	if(huisnummertoevoeging != null) {
                    sql += "AND(\n";
                    sql += "	UPPER(HUISLT) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";
                    sql += "	OR	UPPER(HUISTOEV) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";
                    sql += "	OR	UPPER(HUISAAND) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";            		
            	}
            }
            else {
            	// no additional stuff:
                sql += "AND HUISLT IS NULL\n";
                sql += "AND HUISTOEV IS NULL\n";
                sql += "AND HUISAAND IS NULL\n";
            }
            log.info(sql);
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet recordset = statement.executeQuery(sql);
            // we only want 1 record
            String woznummer = null;
            if(recordset.next()) {
                log.info("WOZNR:"  + recordset.getString("WOZOBJEKTNR"));
                woznummer = recordset.getString("WOZOBJEKTNR");
            }
            if(recordset.next()) {
            	// is stom!!! meer dan 1 gevonden!!!
            	log.info("Found multiple records!!!");
            }
            else {
            	verblijfsobject.setWozObjectNumber(Long.parseLong(woznummer));
            	session.save(verblijfsobject);
            }
            recordset.close();
            statement.close();
        }
        session.getTransaction().commit();
        
        connection.close();
        // datasource.close();
    }
}
