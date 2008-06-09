/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nergens.bag.interact.geotax;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;
import java.sql.SQLSyntaxErrorException;

import org.hibernate.Session;
import org.nergens.bag.storage.pojo.*;
import org.nergens.bag.storage.util.HibernateFactory;

import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author Eduard Witteveen
 */
public class AddGeotaxInformation {
    private static Logger log = Logger.getLogger(AddGeotaxInformation.class.getName());
    private static final java.lang.String BAG_ORACLE_SERVER = "servername";
    private static final java.lang.Integer BAG_ORACLE_PORT = 1521;
    private static final java.lang.String BAG_ORACLE_SID = "databasename";
    private static final java.lang.String BAG_ORACLE_USERNAME = "username";
    private static final java.lang.String BAG_ORACLE_PASSWORD = "password";
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
    @SuppressWarnings("unchecked")
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
        String sql = null;
        for (Verblijfsobject verblijfsobject : verblijfsobjecten) {
        	try 
        	{
	            //log.info(verblijfsobject.toString());
	            Nummeraanduiding nummer = verblijfsobject.getHoofdadres();
	            //log.info(nummer.toString());
	            Long huisnummer = nummer.getHuisnummer(); 
	            String huisletter = nummer.getHuisletter();
	            if(huisletter != null) {
	            	huisletter = huisletter.replace("'", "''");
	            }
	            String huisnummertoevoeging = nummer.getHuisnummertoevoeging();
	            if(huisnummertoevoeging != null) {
	            	huisnummertoevoeging = huisnummertoevoeging.replace("'", "''");
	            }
	            String postcode = nummer.getPostcode();
	            if(postcode != null) {
	            	postcode = postcode.replace("'", "''");
	            }	            
	            Openbareruimte straat = nummer.getOpenbareruimte();
	            //log.info(straat.toString());
	            String straatnaam = straat.getNaam();
	            if(straatnaam != null) {
	            	straatnaam = straatnaam.replace("'", "''");
	            }		            
	            Woonplaats woonplaats = straat.getWoonplaats();
	            //log.info(woonplaats.toString());
	            String woonplaatsnaam = woonplaats.getNaam().replace("'", "''");
	            if(woonplaatsnaam != null) {
	            	woonplaatsnaam = woonplaatsnaam.replace("'", "''");
	            }		            	            
	            // now we will make a nice sql statement of the stuff above,..
	            sql = BAG_ORACLE_SQL;
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
	                    sql += ")\n";
	            	}
	            	if(huisnummertoevoeging != null) {
	                    sql += "AND(\n";
	                    sql += "	UPPER(HUISLT) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";
	                    sql += "	OR	UPPER(HUISTOEV) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";
	                    sql += "	OR	UPPER(HUISAAND) LIKE '" + huisnummertoevoeging.toUpperCase() + "'\n";
	                    sql += ")\n";
	            	}
	            	if(huisletter != null && huisnummertoevoeging != null) {
		            	// at least 1 time null
		            	sql += "AND(\n";
		                sql += "	HUISLT IS NULL\n";
		                sql += "	OR	HUISTOEV IS NULL\n";
		                sql += "	OR	HUISAAND IS NULL\n";
		                sql += ")\n";	            		
	            	}	            	
	            	else {
	            		// 2 times null (1 value was provided)
		            	sql += "AND(\n";
		                sql += "	(HUISLT IS NULL AND HUISTOEV IS NULL)\n";
		                sql += "	OR	(HUISLT IS NULL AND HUISAAND IS NULL)\n";
		                sql += "	OR	(HUISTOEV IS NULL AND HUISAAND IS NULL)\n";
		                sql += ")\n";	            		
	            	}
	            }
	            else {
	            	// no additional stuff:
	                sql += "AND HUISLT IS NULL\n";
	                sql += "AND HUISTOEV IS NULL\n";
	                sql += "AND HUISAAND IS NULL\n";
	            }
	            // log.info(sql);
	            java.sql.Statement statement = connection.createStatement();
	            java.sql.ResultSet recordset = statement.executeQuery(sql);
	            // we only want 1 record
	            String 	woznummer = null;
	            Long	jaartal = null;
	            Long	inhoud = null;
	            Long	gebruikscode = null;
	            Long 	soortcode = null;
	            String 	soortomschrijving = null;
	            if(recordset.next()) {
	                // log.info("WOZNR:"  + recordset.getString("WOZOBJEKTNR"));
	                woznummer = recordset.getString("WOZOBJEKTNR");
	                jaartal = recordset.getLong("BOUWJAAR");
	                inhoud =  recordset.getLong("INHOUD");
	                gebruikscode =  recordset.getLong("GEBRUIKSCODE");
	                soortcode =  recordset.getLong("SOORTCODE");
	                soortomschrijving = recordset.getString("SOORTOMSCHRIJVING");
	            }
	            if(recordset.next()) {
	            	// is stom!!! meer dan 1 gevonden!!!
	            	log.info("[MULTIPLE RECORDS]" + woonplaats + " " + straat + " " + nummer + " " + verblijfsobject);
	            }
	            else {
	            	if(woznummer != null) {
	            		// whoot, we can continue (what a dirty syntax construction :D :D)
	            		// well we can even make it more dirty :D :D
	            		verblijfsobject.setWozObjectNumber(Long.parseLong(woznummer));

	            		if(jaartal != null) {
	            			// we need to have the ground area:
	            			verblijfsobject.setOppervlakte(
	            					getOppervlakte(
	            							woznummer, 
	            							jaartal, 
	            							inhoud, 
	            							gebruikscode, 
	            							soortcode, 
	            							soortomschrijving
	            							)
	            					);
	            		}
	            		else {
	            			log.info("[GEEN INHOUD] woz:" + woznummer + " -->"  + woonplaats + " " + straat + " " + nummer + " " + verblijfsobject);
	            		}
                                log.info("[SAVE #" + woznummer + "]"  + verblijfsobject);
	            		session.save(verblijfsobject);
	            	}
	            	else {
	            		log.info("[NO RECORDS]" + woonplaats + " " + straat + " " + nummer + " " + verblijfsobject);
	            	}
	            }
	            recordset.close();
	            statement.close();	        
        	}
        	catch(SQLSyntaxErrorException ssee) {
        			log.info(sql);
        			ssee.printStackTrace();
        	}
        	catch(Exception ex) {
        		ex.printStackTrace();
        	}
        }
        session.getTransaction().commit();
        
        connection.close();
        // datasource.close();
    }
    enum WONINGTYPE {            
        VRIJSTAANDE_WONING, 
        TWEE_KAP_WONING, 
        RIJ_WONING, 
        MAISONNETTE, 
        APPARTEMENT,
        BENEDEN_WONING, 
        BOVEN_WONING, 
        GALLERIJ, 
        PORTIEK,
        OVERIGE
    
    }     
    private static WONINGTYPE getWoningtype(int soortcode, String soortomschrijving) {
        switch(soortcode) {
            case 1000:  // Woningen
            case 1100:  // Normale woningen
            case 1110:  // Vrijstaand
            case 1111:  // Vrijstaande woning
            case 1112:  // Vrijstaande semi-bungalow
            case 1113:  // Vrijstaande bungalow
            case 1114:  // Vrijstaande villa/landhuis
            case 1115:  // Vrijstaande woonboerderij
            case 1116:  // Vrijstaand  herenhuis
                return WONINGTYPE.VRIJSTAANDE_WONING;
            case 1120:  // 2^1 kap woning
            case 1121:  // 2^1 kap woning
            case 1122:  // 2^1 kap semi-bungalow
            case 1125:  // 2^1 kap woonboerderij
                return WONINGTYPE.TWEE_KAP_WONING;
            case 1130:  // Rijwoning
            case 1131:  // Rijwoning
            case 1141:  // Hoekwoning
                return WONINGTYPE.RIJ_WONING;
            case 1150:  // Woonboerderij
                return WONINGTYPE.VRIJSTAANDE_WONING;
            case 1151:  // Tussenwoning
            case 1155:  // Tussen woonboerderij
            case 1161:  // Eindwoning
            case 1165:  // Eind woonboerderij
                return WONINGTYPE.RIJ_WONING;
            case 1170:  // Benedenwoning
                return WONINGTYPE.BENEDEN_WONING;
            case 1171:  // Geschakelde woning                                     	
            case 1173:  // Geschakelde bungalow                                   	
            case 1175:  // Geschakelde woonboerderij                              	
                return WONINGTYPE.TWEE_KAP_WONING;                
            case 1181:  // Flatwoning                                             	
                return WONINGTYPE.APPARTEMENT;                                                                
            case 1183:  // Appartement                                          
                return WONINGTYPE.APPARTEMENT;                                                                
            case 1184:  // Portiekwoning                                        
                return WONINGTYPE.PORTIEK;                                                                
            case 1185:  // Duplex-woning                                        
                return WONINGTYPE.TWEE_KAP_WONING;                                                                
            case 1187:  // Benedenwoning                                         
                return WONINGTYPE.BENEDEN_WONING;                                                
            case 1188:  // Bovenwoning                                         
                return WONINGTYPE.BOVEN_WONING;                                                
            case 1200:  // Recreatiewoningen                                      	
            case 1211:  // Vrijstaande recreatiewoning                            	
                return WONINGTYPE.VRIJSTAANDE_WONING;                                
            case 1221:  // 2^1 kap recreatiewoning                                	
                return WONINGTYPE.TWEE_KAP_WONING;                
            case 1283:  // Recreatie appartement                                  	
                return WONINGTYPE.APPARTEMENT;                
            case 1311:  // Vrijstaande bejaardenwoning                            	
                return WONINGTYPE.VRIJSTAANDE_WONING;                
            case 1321:  // 2^1 kap bejaardenwoning                                	
                return WONINGTYPE.TWEE_KAP_WONING;                
            case 1341:  // Hoek bejaardenwoning                                   
            case 1351:  // Tussen bejaardenwoning                                 	
                return WONINGTYPE.RIJ_WONING;                
            case 1383:  // Bejaarden Appartement                                  	
                return WONINGTYPE.APPARTEMENT;
            case 1387:  // Bejaarden Benedenwoning                                	
                return WONINGTYPE.BENEDEN_WONING;
            case 1388:  // Bejaarden Bovenwoning                                  	
                return WONINGTYPE.BOVEN_WONING;
            case 1500:  // Bedrijfswoningen                                       	
            case 1511:  // Vrijstaande bedrijfswoning                             	
            case 1513:  // Vrijst. bedr. bungalow                                 	
            case 1515:  // Vrijst. bedr. woonboerderij                            	
                return WONINGTYPE.VRIJSTAANDE_WONING;
            case 1521:  // 2^1 kap bedrijfswoning                                 	
            case 1525:  // 2^1 kap bedr. woonboerderij                            	
            case 1571:  // Geschakelde bedrijfswoning                             	
            case 1573:  // Gesch. bedr. bungalow                                  	
            case 1575:  // Gesch. bedr. woonboerderij                             	
                return WONINGTYPE.TWEE_KAP_WONING;
            case 1611:  // Vrijstaande praktijkwoning                             	
            case 1615:  // Vrijst. prakt. woonboerderij                           	
                return WONINGTYPE.VRIJSTAANDE_WONING;
            case 1621:  // 2^1 kap praktijkwoning                                 	
                return WONINGTYPE.TWEE_KAP_WONING;
            case 1700:  // Garagebox                                              	
                return WONINGTYPE.RIJ_WONING;
            default:
                log.info("OVERIGE: Soort #" + soortcode + " omschrijving:" + soortomschrijving);
                return WONINGTYPE.OVERIGE;
        }
    }
    private  static Long getOppervlakte(String woznummer, Long jaartal, Long inhoud, Long gebruikscode, Long soortcode, String soortomschrijving)
    {
	if(soortcode == null)  {
            log.info("Oppervlakte: No soortcode for wozobject:" + woznummer + " jaartal:" + jaartal + " soort:" + soortomschrijving);
            return null;
    	}		
        WONINGTYPE type = getWoningtype(soortcode.intValue(), soortomschrijving);
    	if(type == WONINGTYPE.OVERIGE) {
    		log.info("type of woning not found in table");
    		return null;
    	}          
    	// gebruik bovenstaande omreken tabel om tot iets zinnigs te komen
    	double factor = 0;
    	if(jaartal.intValue() < 1945) {
    		if(type == WONINGTYPE.VRIJSTAANDE_WONING) factor = 3.05; 
    		if(type == WONINGTYPE.TWEE_KAP_WONING) factor = 3.06;
    		if(type == WONINGTYPE.RIJ_WONING) factor = 3.16;
    		if(type == WONINGTYPE.MAISONNETTE) factor = 2.99;
    		if(type == WONINGTYPE.APPARTEMENT) factor = 3.21;
    		if(type == WONINGTYPE.BENEDEN_WONING) factor = 3.07;
    		if(type == WONINGTYPE.BOVEN_WONING) factor = 3.03;
    		if(type == WONINGTYPE.GALLERIJ) factor = 3.03;
    		if(type == WONINGTYPE.PORTIEK) factor = 3.04;
    	}
    	else if(jaartal.intValue() < 1970) {
    		if(type == WONINGTYPE.VRIJSTAANDE_WONING) factor = 3.05; 
    		if(type == WONINGTYPE.TWEE_KAP_WONING) factor = 3.06;
    		if(type == WONINGTYPE.RIJ_WONING) factor = 3.16;
    		if(type == WONINGTYPE.MAISONNETTE) factor = 2.99;
    		if(type == WONINGTYPE.APPARTEMENT) factor = 3.21;
    		if(type == WONINGTYPE.BENEDEN_WONING) factor = 3.07;
    		if(type == WONINGTYPE.BOVEN_WONING) factor = 3.03;
    		if(type == WONINGTYPE.GALLERIJ) factor = 3.03;
    		if(type == WONINGTYPE.PORTIEK) factor = 3.04;
    	}
    	else if(jaartal.intValue() < 1990) {
    		if(type == WONINGTYPE.VRIJSTAANDE_WONING) factor = 3.05; 
    		if(type == WONINGTYPE.TWEE_KAP_WONING) factor = 3.06;
    		if(type == WONINGTYPE.RIJ_WONING) factor = 3.16;
    		if(type == WONINGTYPE.MAISONNETTE) factor = 2.99;
    		if(type == WONINGTYPE.APPARTEMENT) factor = 3.21;
    		if(type == WONINGTYPE.BENEDEN_WONING) factor = 3.07;
    		if(type == WONINGTYPE.BOVEN_WONING) factor = 3.03;
    		if(type == WONINGTYPE.GALLERIJ) factor = 3.03;
    		if(type == WONINGTYPE.PORTIEK) factor = 3.04;
    	}
    	else {	// Na 1990
    		if(type == WONINGTYPE.VRIJSTAANDE_WONING) factor = 3.05; 
    		if(type == WONINGTYPE.TWEE_KAP_WONING) factor = 3.06;
    		if(type == WONINGTYPE.RIJ_WONING) factor = 3.16;
    		if(type == WONINGTYPE.MAISONNETTE) factor = 2.99;
    		if(type == WONINGTYPE.APPARTEMENT) factor = 3.21;
    		if(type == WONINGTYPE.BENEDEN_WONING) factor = 3.07;
    		if(type == WONINGTYPE.BOVEN_WONING) factor = 3.03;
    		if(type == WONINGTYPE.GALLERIJ) factor = 3.03;
    		if(type == WONINGTYPE.PORTIEK) factor = 3.04;
    	}
    	if(factor == 0) {
    		log.info("Oppervlakte: No match for wozobject:" + woznummer + " jaartal:" + jaartal + " soort:" + soortomschrijving);
    		return null;
    	}    	
    	if(inhoud == 0) {
    		log.info("Oppervlakte: No inhoud = 0  for wozobject:" + woznummer + " jaartal:" + jaartal + " soort:" + soortomschrijving);
    		return null;
    	}    	
    	double oppervlakte = factor * inhoud;
        // round should work correctly, therefore add 0.5
        oppervlakte += .5;
    	return new Long((int)oppervlakte);
    }
}
