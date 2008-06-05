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
    /**
     * GEBRUIKSCODE:
     *        10 = 'woning dienend tot hoofdverblijf'
     *        11 = 'woning met praktijkruimte'
     *        12 = 'recreatiewoning en overige woningen'
     *        20 = 'boerderij'
     *        21 = 'niet-woning deels in gebruik als woning'
     *        30 = 'niet-woning'
     *        31 = 'uitgezonderd gebouwd object'
     *        40 = 'terrein'
     *        80 = 'uitgezonderd ongebouwd object'
     *        90 = 'sluimerend WOZ-object'
     */
    /**
     * SOORTCODE:
0001	Nieuw, nader aan te geven                         
0002	vervallen, te verwijderen obj.                    
1000	Woningen                                          
1100	Normale woningen                                  
1110	Vrijstaand                                        
1111	Vrijstaande woning                                
1112	Vrijstaande semi-bungalow                         
1113	Vrijstaande bungalow                              
1114	Vrijstaande villa/landhuis                        
1115	Vrijstaande woonboerderij                         
1116	Vrijstaand  herenhuis                             
1117	Vrijstaande kwadrant-woning                       
1118	Vrijstaande drive-in-woning                       
1119	Vrijstaande patio-woning                          
1120	2^1 kap woning                                    
1121	2^1 kap woning                                    
1122	2^1 kap semi-bungalow                             
1123	2^1 kap bungalow                                  
1124	2^1 kap villa/landhuis                            
1125	2^1 kap woonboerderij                             
1126	2^1 kap herenhuis                                 
1127	2^1 kap kwadrant-woning                           
1128	2^1 kap drive-in-woning                           
1129	2^1 kap patio-woning                              
1130	Rijwoning                                         
1131	Rijwoning                                         
1132	Rij semi-bungalow                                 
1133	Rij bungalow                                      
1134	Rij villa/landhuis                                
1135	Rij woonboerderij                                 
1136	Rij herenhuis                                     
1137	Rij kwadrant-woning                               
1138	Rij drive-in-woning                               
1139	Rij patio-woning                                  
1140	Drive in woning                                   
1141	Hoekwoning                                        
1142	Hoek semi-bungalow                                
1143	Hoek bungalow                                     
1144	Hoek villa/landhuis                               
1145	Hoek woonboerderij                                
1146	Hoek herenhuis                                    
1147	Hoek kwadrant-woning                              
1148	Hoek drive-in-woning                              
1149	Hoek patio-woning                                 
1150	Woonboerderij                                     
1151	Tussenwoning                                      
1152	Tussen semi-bungalow                              
1153	Tussen bungalow                                   
1154	Tussen villa/landhuis                             
1155	Tussen woonboerderij                              
1156	Tussen herenhuis                                  
1157	Tussen kwadrant-woning                            
1158	Tussen drive-in-woning                            
1159	Tussen patio-woning                               
1160	Bovenwoning                                       
1161	Eindwoning                                        
1162	Eind semi-bungalow                                
1163	Eind bungalow                                     
1164	Eind villa/landhuis                               
1165	Eind woonboerderij                                
1166	Eind herenhuis                                    
1167	Eind kwadrant-woning                              
1168	Eind drive-in-woning                              
1169	Eind patio-woning                                 
1170	Benedenwoning                                     
1171	Geschakelde woning                                
1172	Geschakelde semi-bungalow                         
1173	Geschakelde bungalow                              
1174	Geschakelde villa/landhuis                        
1175	Geschakelde woonboerderij                         
1176	Geschakeld  herenhuis                             
1177	Geschakelde kwadrant-woning                       
1178	Geschakelde drive-in-woning                       
1179	Geschakelde patio-woning                          
1181	Flatwoning                                        
1182	Maisonnette                                       
1183	Appartement                                       
1184	Portiekwoning                                     
1185	Duplex-woning                                     
1186	Penthouse                                         
1187	Benedenwoning                                     
1188	Bovenwoning                                       
1189	Etagewoning                                       
1191	Woonwagen/-boot                                   
1192	Woonwagen/-boot semi-bungalow                     
1193	Woonwagen/-boot bungalow                          
1194	Woonwagen/-boot villa/landhuis                    
1195	Woonwagen/-boot woonboerderij                     
1196	Woonwagen/-boot herenhuis                         
1197	Woonwagen/-boot kwadrant                          
1198	Woonwagen/-boot drive-in                          
1199	Woonwagen/-boot patio                             
1200	Recreatiewoningen                                 
1210	duplexwoning beneden                              
1211	Vrijstaande recreatiewoning                       
1212	Vrijst. recr. semi-bungalow                       
1213	Vrijst. recr. bungalow                            
1214	Vrijst. recr. villa/landhuis                      
1215	Vrijst. recr. woonboerderij                       
1216	Vrijst. recr. herenhuis                           
1217	Vrijst. recr. kwadrant-woning                     
1218	Vrijst. recr. drive-in-woning                     
1219	Vrijst. recr. patio-woning                        
1220	duplexwoning boven                                
1221	2^1 kap recreatiewoning                           
1222	2^1 kap recr. semi-bungalow                       
1223	2^1 kap recr. bungalow                            
1224	2^1 kap recr. villa/landhuis                      
1225	2^1 kap recr. woonboerderij                       
1226	2^1 kap recr. herenhuis                           
1227	2^1 kap recr. kwadrant-woning                     
1228	2^1 kap recr. drive-in-woning                     
1229	2^1 kap recr. patio-woning                        
1230	flat (portiek/galerij)                            
1231	Rij recreatiewoning                               
1232	Rij recr. semi-bungalow                           
1233	Rij recr. bungalow                                
1234	Rij recr. villa/landhuis                          
1235	Rij recr. woonboerderij                           
1236	Rij recr. herenhuis                               
1237	Rij recr. kwadrant-woning                         
1238	Rij recr. drive-in-woning                         
1239	Rij recr. patio-woning                            
1240	appartement                                       
1241	Hoek recreatiewoning                              
1242	Hoek recr. semi-bungalow                          
1243	Hoek recr. bungalow                               
1244	Hoek recr. villa/landhuis                         
1245	Hoek recr. woonboerderij                          
1246	Hoek recr. herenhuis                              
1247	Hoek recr. kwadrant-woning                        
1248	Hoek recr. drive-in-woning                        
1249	Hoek recr. patio-woning                           
1250	benedenwoning                                     
1251	Tussen recreatiewoning                            
1252	Tussen recr. semi-bungalow                        
1253	Tussen recr. bungalow                             
1254	Tussen recr. villa/landhuis                       
1255	Tussen recr. woonboerderij                        
1256	Tussen recr. herenhuis                            
1257	Tussen recr. kwadrant-woning                      
1258	Tussen recr. drive-in-woning                      
1259	Tussen recr. patio-woning                         
1260	bovenwoning                                       
1261	Eind recreatiewoning                              
1262	Eind recr. semi-bungalow                          
1263	Eind recr. bungalow                               
1264	Eind recr. villa/landhuis                         
1265	Eind recr. woonboerderij                          
1266	Eind recr. herenhuis                              
1267	Eind recr. kwadrant-woning                        
1268	Eind recr. drive-in-woning                        
1269	Eind recr. patio-woning                           
1271	Geschakelde recreatiewoning                       
1272	Gesch. recr. semi-bungalow                        
1273	Gesch. recr. bungalow                             
1274	Gesch. recr. villa/landhuis                       
1275	Gesch. recr. woonboerderij                        
1276	Gesch. recr. herenhuis                            
1277	Gesch. recr. kwadrant-woning                      
1278	Gesch. recr. drive-in-woning                      
1279	Gesch. recr. patio-woning                         
1281	Recreatie flatwoning                              
1282	Recreatie maisonnette                             
1283	Recreatie appartement                             
1284	Recreatie portiekwoning                           
1285	Recreatie duplex-woning                           
1286	Recreatie penthouse                               
1287	Recreatie benedenwoning                           
1288	Recreatie bovenwoning                             
1289	Recreatie etagewoning                             
1291	Woonwagen/-boot recreatie                         
1292	Wnwgn/-boot recr.semi-bungalow                    
1293	Wnwgn/-boot recr.bungalow                         
1294	Wnwgn/-boot rec.villa/landhuis                    
1295	Wnwgn/-boot recr.woonboerderij                    
1296	Wnwgn/-boot recr.herenhuis                        
1297	Wnwgn/-boot recr.kwadrant                         
1298	Wnwgn/-boot recr.drive-in                         
1299	Wnwgn/-boot recr.patio                            
1300	Bejaarden-/aanleunwoningen                        
1310	bedrijfswoning                                    
1311	Vrijstaande bejaardenwoning                       
1312	Vrijst. bejrd. semi-bungalow                      
1313	Vrijst. bejrd. bungalow                           
1314	Vrijst. bejrd. villa/landhuis                     
1315	Vrijst. bejrd. woonboerderij                      
1316	Vrijst. bejrd. herenhuis                          
1317	Vrijst. bejrd. kwadrant-woning                    
1318	Vrijst. bejrd. drive-in-woning                    
1319	Vrijst. bejrd. patio-woning                       
1320	Aanleunwoning/Bejaardenwoning                     
1321	2^1 kap bejaardenwoning                           
1322	2^1 kap bejrd. semi-bungalow                      
1323	2^1 kap bejrd. bungalow                           
1324	2^1 kap bejrd. villa/landhuis                     
1325	2^1 kap bejrd. woonboerderij                      
1326	2^1 kap bejrd. herenhuis                          
1327	2^1 kap bejrd. kwadrant-woning                    
1328	2^1 kap bejrd. drive-in-woning                    
1329	2^1 kap bejrd. patio-woning                       
1330	recreatiewoning                                   
1331	Rij bejaardenwoning                               
1332	Rij bejrd. semi-bungalow                          
1333	Rij bejrd. bungalow                               
1334	Rij bejrd. villa/landhuis                         
1335	Rij bejrd. woonboerderij                          
1336	Rij bejrd. herenhuis                              
1337	Rij bejrd. kwadrant-woning                        
1338	Rij bejrd. drive-in-woning                        
1339	Rij bejrd. patio-woning                           
1341	Hoek bejaardenwoning                              
1342	Hoek bejrd. semi-bungalow                         
1343	Hoek bejrd. bungalow                              
1344	Hoek bejrd. villa/landhuis                        
1345	Hoek bejrd. woonboerderij                         
1346	Hoek bejrd. herenhuis                             
1347	Hoek bejrd. kwadrant-woning                       
1348	Hoek bejrd. drive-in-woning                       
1349	Hoek bejrd. patio-woning                          
1351	Tussen bejaardenwoning                            
1352	Tussen bejrd. semi-bungalow                       
1353	Tussen bejrd. bungalow                            
1354	Tussen bejrd. villa/landhuis                      
1355	Tussen bejrd. woonboerderij                       
1356	Tussen bejrd. herenhuis                           
1357	Tussen bejrd. kwadrant-woning                     
1358	Tussen bejrd. drive-in-woning                     
1359	Tussen bejrd. patio-woning                        
1361	Eind bejaardenwoning                              
1362	Eind bejrd. semi-bungalow                         
1363	Eind bejrd. bungalow                              
1364	Eind bejrd. villa/landhuis                        
1365	Eind bejrd. woonboerderij                         
1366	Eind bejrd. herenhuis                             
1367	Eind bejrd. kwadrant-woning                       
1368	Eind bejrd. drive-in-woning                       
1369	Eind bejrd. patio-woning                          
1371	Geschakelde bejaardenwoning                       
1372	Gesch. bejrd. semi-bungalow                       
1373	Gesch. bejrd. bungalow                            
1374	Gesch. bejrd. villa/landhuis                      
1375	Gesch. bejrd. woonboerderij                       
1376	Gesch. bejrd. herenhuis                           
1377	Gesch. bejrd. kwadrant-woning                     
1378	Gesch. bejrd. drive-in-woning                     
1379	Gesch. bejrd. patio-woning                        
1381	Bejaarden Flatwoning                              
1382	Bejaarden Maisonnette                             
1383	Bejaarden Appartement                             
1384	Bejaarden Portiekwoning                           
1385	Bejaarden Duplex-woning                           
1386	Bejaarden Penthouse                               
1387	Bejaarden Benedenwoning                           
1388	Bejaarden Bovenwoning                             
1389	Bejaarden Etagewoning                             
1390	overige woningen                                  
1391	Woonwagen/-boot bejaarden                         
1392	Wnwgn/-bt bejrd. semi-bungalow                    
1393	Wnwgn/-bt bejrd. bungalow                         
1394	Wnwgn/-bt bejrd.villa/landhuis                    
1395	Wnwgn/-bt bejrd. woonboerderij                    
1396	Wnwgn/-bt bejrd. herenhuis                        
1397	Wnwgn/-bt bejrd. kwadrant                         
1398	Wnwgn/-bt bejrd. drive-in                         
1399	Wnwgn/-bt bejrd. patio                            
1400	Studentenwoningen/kamerverhuur                    
1410	woonbootrecreatie                                 
1411	Vrijstaande studentenwoning                       
1412	Vrijst. stud. semi-bungalow                       
1413	Vrijst. stud. bungalow                            
1414	Vrijst. stud. villa/landhuis                      
1415	Vrijst. stud. woonboerderij                       
1416	Vrijst. stud. herenhuis                           
1417	Vrijst. stud. kwadrant-woning                     
1418	Vrijst. stud. drive-in-woning                     
1419	Vrijst. stud. patio-woning                        
1420	woonwagenlokatie                                  
1421	2^1 kap studentenwoning                           
1422	2^1 kap stud. semi-bungalow                       
1423	2^1 kap stud. bungalow                            
1424	2^1 kap stud. villa/landhuis                      
1425	2^1 kap stud. woonboerderij                       
1426	2^1 kap stud. herenhuis                           
1427	2^1 kap stud. kwadrant-woning                     
1428	2^1 kap stud. drive-in-woning                     
1429	2^1 kap stud. patio-woning                        
1430	recreatiewoning niet gefundeerd                   
1431	Rij studentenwoning                               
1432	Rij stud. semi-bungalow                           
1433	Rij stud. bungalow                                
1434	Rij stud. villa/landhuis                          
1435	Rij stud. woonboerderij                           
1436	Rij stud. herenhuis                               
1437	Rij stud. kwadrant-woning                         
1438	Rij stud. drive-in-woning                         
1439	Rij stud. patio-woning                            
1441	Hoek studentenwoning                              
1442	Hoek stud. semi-bungalow                          
1443	Hoek stud. bungalow                               
1444	Hoek stud. villa/landhuis                         
1445	Hoek stud. woonboerderij                          
1446	Hoek stud. herenhuis                              
1447	Hoek stud. kwadrant-woning                        
1448	Hoek stud. drive-in-woning                        
1449	Hoek stud. patio-woning                           
1451	Tussen studentenwoning                            
1452	Tussen stud. semi-bungalow                        
1453	Tussen stud. bungalow                             
1454	Tussen stud. villa/landhuis                       
1455	Tussen stud. woonboerderij                        
1456	Tussen stud. herenhuis                            
1457	Tussen stud. kwadrant-woning                      
1458	Tussen stud. drive-in-woning                      
1459	Tussen stud. patio-woning                         
1461	Eind studentenwoning                              
1462	Eind stud. semi-bungalow                          
1463	Eind stud. bungalow                               
1464	Eind stud. villa/landhuis                         
1465	Eind stud. woonboerderij                          
1466	Eind stud. herenhuis                              
1467	Eind stud. kwadrant-woning                        
1468	Eind stud. drive-in-woning                        
1469	Eind stud. patio-woning                           
1471	Geschakelde studentenwoning                       
1472	Gesch. stud. semi-bungalow                        
1473	Gesch. stud. bungalow                             
1474	Gesch. stud. villa/landhuis                       
1475	Gesch. stud. woonboerderij                        
1476	Gesch. stud. herenhuis                            
1477	Gesch. stud. kwadrant-woning                      
1478	Gesch. stud. drive-in-woning                      
1479	Gesch. stud. patio-woning                         
1481	Studenten Flatwoning                              
1482	Studenten Maisonnette                             
1483	Studenten Appartement                             
1484	Studenten Portiekwoning                           
1485	Studenten Duplex-woning                           
1486	Studenten Penthouse                               
1487	Studenten Benedenwoning                           
1488	Studenten Bovenwoning                             
1489	Studenten Etagewoning                             
1491	Woonwagen/-boot studenten                         
1492	Wnwgn/-bt stud. semi-bungalow                     
1493	Wnwgn/-bt stud. bungalow                          
1494	Wnwgn/-bt stud. villa/landhuis                    
1495	Wnwgn/-bt stud. woonboerderij                     
1496	Wnwgn/-bt stud. herenhuis                         
1497	Wnwgn/-bt stud. kwadrant                          
1498	Wnwgn/-bt stud. drive-in                          
1499	Wnwgn/-bt stud. patio                             
1500	Bedrijfswoningen                                  
1511	Vrijstaande bedrijfswoning                        
1512	Vrijst. bedr. semi-bungalow                       
1513	Vrijst. bedr. bungalow                            
1514	Vrijst. bedr. villa/landhuis                      
1515	Vrijst. bedr. woonboerderij                       
1516	Vrijst. bedr. herenhuis                           
1517	Vrijst. bedr. kwadrant-woning                     
1518	Vrijst. bedr. drive-in-woning                     
1519	Vrijst. bedr. patio-woning                        
1521	2^1 kap bedrijfswoning                            
1522	2^1 kap bedr. semi-bungalow                       
1523	2^1 kap bedr. bungalow                            
1524	2^1 kap bedr. villa/landhuis                      
1525	2^1 kap bedr. woonboerderij                       
1526	2^1 kap bedr. herenhuis                           
1527	2^1 kap bedr. kwadrant-woning                     
1528	2^1 kap bedr. drive-in-woning                     
1529	2^1 kap bedr. patio-woning                        
1531	Rij bedrijfswoning                                
1532	Rij bedr. semi-bungalow                           
1533	Rij bedr. bungalow                                
1534	Rij bedr. villa/landhuis                          
1535	Rij bedr. woonboerderij                           
1536	Rij bedr. herenhuis                               
1537	Rij bedr. kwadrant-woning                         
1538	Rij bedr. drive-in-woning                         
1539	Rij bedr. patio-woning                            
1541	Hoek bedrijfswoning                               
1542	Hoek bedr. semi-bungalow                          
1543	Hoek bedr. bungalow                               
1544	Hoek bedr. villa/landhuis                         
1545	Hoek bedr. woonboerderij                          
1546	Hoek bedr. herenhuis                              
1547	Hoek bedr. kwadrant-woning                        
1548	Hoek bedr. drive-in-woning                        
1549	Hoek bedr. patio-woning                           
1551	Tussen bedrijfswoning                             
1552	Tussen bedr. semi-bungalow                        
1553	Tussen bedr. bungalow                             
1554	Tussen bedr. villa/landhuis                       
1555	Tussen bedr. woonboerderij                        
1556	Tussen bedr. herenhuis                            
1557	Tussen bedr. kwadrant-woning                      
1558	Tussen bedr. drive-in-woning                      
1559	Tussen bedr. patio-woning                         
1561	Eind bedrijfswoning                               
1562	Eind bedr. semi-bungalow                          
1563	Eind bedr. bungalow                               
1564	Eind bedr. villa/landhuis                         
1565	Eind bedr. woonboerderij                          
1566	Eind bedr. herenhuis                              
1567	Eind bedr. kwadrant-woning                        
1568	Eind bedr. drive-in-woning                        
1569	Eind bedr. patio-woning                           
1571	Geschakelde bedrijfswoning                        
1572	Gesch. bedr. semi-bungalow                        
1573	Gesch. bedr. bungalow                             
1574	Gesch. bedr. villa/landhuis                       
1575	Gesch. bedr. woonboerderij                        
1576	Gesch. bedr. herenhuis                            
1577	Gesch. bedr. kwadrant-woning                      
1578	Gesch. bedr. drive-in-woning                      
1579	Gesch. bedr. patio-woning                         
1581	Bedrijfs Flatwoning                               
1582	Bedrijfs Maisonnette                              
1583	Bedrijfs Appartement                              
1584	Bedrijfs Portiekwoning                            
1585	Bedrijfs Duplex-woning                            
1586	Bedrijfs Penthouse                                
1587	Bedrijfs Benedenwoning                            
1588	Bedrijfs Bovenwoning                              
1589	Bedrijfs Etagewoning                              
1591	Woonwagen/-boot bedrijf                           
1592	Wnwgn/-bt bedr. semi-bungalow                     
1593	Wnwgn/-bt bedr. bungalow                          
1594	Wnwgn/-bt bedr. villa/landhuis                    
1595	Wnwgn/-bt bedr. woonboerderij                     
1596	Wnwgn/-bt bedr. herenhuis                         
1597	Wnwgn/-bt bedr. kwadrant                          
1598	Wnwgn/-bt bedr. drive-in                          
1599	Wnwgn/-bt bedr. patio                             
1600	Praktijkwoningen                                  
1610	Nat-wonig                                         
1611	Vrijstaande praktijkwoning                        
1612	Vrijst. prakt. semi-bungalow                      
1613	Vrijst. prakt. bungalow                           
1614	Vrijst. prakt. villa/landhuis                     
1615	Vrijst. prakt. woonboerderij                      
1616	Vrijst. prakt. herenhuis                          
1617	Vrijst. prakt. kwadrant-woning                    
1618	Vrijst. prakt. drive-in-woning                    
1619	Vrijst. prakt. patio-woning                       
1621	2^1 kap praktijkwoning                            
1622	2^1 kap prakt. semi-bungalow                      
1623	2^1 kap prakt. bungalow                           
1624	2^1 kap prakt. villa/landhuis                     
1625	2^1 kap prakt. woonboerderij                      
1626	2^1 kap prakt. herenhuis                          
1627	2^1 kap prakt. kwadrant-woning                    
1628	2^1 kap prakt. drive-in-woning                    
1629	2^1 kap prakt. patio-woning                       
1631	Rij praktijkwoning                                
1632	Rij prakt. semi-bungalow                          
1633	Rij prakt. bungalow                               
1634	Rij prakt. villa/landhuis                         
1635	Rij prakt. woonboerderij                          
1636	Rij prakt. herenhuis                              
1637	Rij prakt. kwadrant-woning                        
1638	Rij prakt. drive-in-woning                        
1639	Rij prakt. patio-woning                           
1641	Hoek praktijkwoning                               
1642	Hoek prakt. semi-bungalow                         
1643	Hoek prakt. bungalow                              
1644	Hoek prakt. villa/landhuis                        
1645	Hoek prakt. woonboerderij                         
1646	Hoek prakt. herenhuis                             
1647	Hoek prakt. kwadrant-woning                       
1648	Hoek prakt. drive-in-woning                       
1649	Hoek prakt. patio-woning                          
1651	Tussen praktijkwoning                             
1652	Tussen prakt. semi-bungalow                       
1653	Tussen prakt. bungalow                            
1654	Tussen prakt. villa/landhuis                      
1655	Tussen prakt. woonboerderij                       
1656	Tussen prakt. herenhuis                           
1657	Tussen prakt. kwadrant-woning                     
1658	Tussen prakt. drive-in-woning                     
1659	Tussen prakt. patio-woning                        
1661	Eind praktijkwoning                               
1662	Eind prakt. semi-bungalow                         
1663	Eind prakt. bungalow                              
1664	Eind prakt. villa/landhuis                        
1665	Eind prakt. woonboerderij                         
1666	Eind prakt. herenhuis                             
1667	Eind prakt. kwadrant-woning                       
1668	Eind prakt. drive-in-woning                       
1669	Eind prakt. patio-woning                          
1671	Geschakelde praktijkwoning                        
1672	Gesch. prakt. semi-bungalow                       
1673	Gesch. prakt. bungalow                            
1674	Gesch. prakt. villa/landhuis                      
1675	Gesch. prakt. woonboerderij                       
1676	Gesch. prakt. herenhuis                           
1677	Gesch. prakt. kwadrant-woning                     
1678	Gesch. prakt. drive-in-woning                     
1679	Gesch. prakt. patio-woning                        
1681	Praktijk Flatwoning                               
1682	Praktijk Maisonnette                              
1683	Praktijk Appartement                              
1684	Praktijk Portiekwoning                            
1685	Praktijk Duplex-woning                            
1686	Praktijk Penthouse                                
1687	Praktijk Benedenwoning                            
1688	Praktijk Bovenwoning                              
1689	Praktijk Etagewoning                              
1691	Woonwagen/-boot praktijk                          
1692	Wnwgn/-bt prakt. semi-bungalow                    
1693	Wnwgn/-bt prakt. bungalow                         
1694	Wnwgn/-bt prakt.villa/landhuis                    
1695	Wnwgn/-bt prakt. woonboerderij                    
1696	Wnwgn/-bt prakt. herenhuis                        
1697	Wnwgn/-bt prakt. kwadrant                         
1698	Wnwgn/-bt prakt. drive-in                         
1699	Wnwgn/-bt prakt. patio                            
1700	Garagebox                                         
1800	Specifieke woonobjecten                           
1900	Overige woonobjecten                              
2000	Woning met bedrijf                                
2010	Winkel met woning                                 
2020	Bank met woning                                   
2030	Kantoor met woning                                
2040	Horeca met woning                                 
2050	Agrarisch bedrijf met woning                      
2060	Garagebedrijf met woning                          
2070	Werkplaats met woning                             
2080	Kleine industrie met woning                       
2090	Grote industrie met woning                        
2100	winkels en toonzalen + bedr woning                
2110	Detailhandel                                      
2111	Winkel                                            
2112	Groothandel                                       
2113	Toonzaal                                          
2114	Kiosk                                             
2119	Overig                                            
2120	Horeca                                            
2121	Cafetaria/snackbar                                
2122	Cafébar/restaurant                                
2123	Bar/dancing                                       
2124	Hotel/motel                                       
2125	Pension/logiesgebouw                              
2140	Kantoren                                          
2141	Kantoor                                           
2142	Kantoor in bedrijfsverz.geb.                      
2143	Kantoor (solitair)                                
2144	Studiogebouw                                      
2150	toonzaal                                          
2160	Laboratoria en praktijk                           
2161	Laboratorium                                      
2162	Praktijkruimte                                    
2170	Bedrijven                                         
2171	Werkplaats/garage                                 
2172	Autoshowroom + garage                             
2173	Onderhoud/reparatie                               
2174	Produktie (fabriek)                               
2175	Opslag/distributie                                
2190	overige detailhandel                              
2200	horeca+bedr.woning                                
2210	cafetaria/snackbar                                
2211	Akkerbouwbedrijf                                  
2212	Tuinbouwbedrijf                                   
2213	Fruitkwekerij                                     
2214	Champignonteeltbedrijf                            
2215	Witlofteeltbedrijf                                
2216	Boomkwekerij (incl. sierteelt)                    
2217	Bosbouwbedrijf                                    
2218	Tuincentrum                                       
2220	cafe/bar/restaurant                               
2230	bar/dancing                                       
2240	hotel/motel                                       
2241	Proefboerderij                                    
2242	Gemengd bedrijf                                   
2243	Melkveebedrijf                                    
2244	Kaasboerderij                                     
2245	Veehouderij runderen                              
2246	Veehouderij varkens                               
2247	KI-station                                        
2248	Veehouderij pluimvee                              
2250	pension/logiesgebouw                              
2261	Stoeterij/manege/fokkerij                         
2262	Viskwekerij                                       
2263	Kinderboerderij                                   
2264	Loonwerkbedrijf                                   
2265	Pelsdierfokkerij                                  
2266	Broederij                                         
2299	Overige agrarische objecten                       
2300	kantoren en lab + bedr.woning                     
2310	Onderwijs                                         
2311	Crêche/peuterzaal                                 
2312	Basisschool                                       
2313	Onderwijs; MAVO-HAVO-VWO                          
2314	Beroepsonderwijs LBO/MBO                          
2315	Hogeschool/universiteit                           
2316	Vrije-tijdsonderwijs                              
2317	Speciaal onderwijs                                
2318	Dagverblijf                                       
2319	Overig onderwijs                                  
2320	kantoor in bedrijfsverzamelgebouw                 
2330	Medisch                                           
2331	Ziekenhuis                                        
2332	(Poli)Kliniek                                     
2333	Medisch dagverblijf                               
2334	Psychiatrische ziekenhuis                         
2335	Revalidatiecenrum                                 
2336	Verpleegtehuis                                    
2337	Gezinsvervangend tehuis                           
2338	Verstandelijk gehandicapten                       
2339	Medisch overig                                    
2350	Bijzondere woonfunctie                            
2351	Verzorgings/bejaardentehuis                       
2352	Kruisgebouw                                       
2353	Praktijkruimte tandarts+fysio                     
2354	Kindertehuis                                      
2355	Sociale werkvoorziening                           
2356	Gevangenis                                        
2357	Klooster                                          
2358	Kazerne                                           
2359	overige bijzondere woonfunctie                    
2360	laboratorium                                      
2370	Gemeenschapsgebouw overig                         
2371	Gemeentehuis                                      
2372	Gemeentewerken                                    
2373	Politiebureau                                     
2374	Gerechtsgebouw                                    
2375	Brandweerkazerne                                  
2376	Wijk/Buurtcentrum                                 
2377	Begraafplaats                                     
2378	Aula                                              
2379	Crematorium                                       
2400	Industrie/distributie + bedrijfswoning            
2410	Cultuur                                           
2411	Schouwburg/concertgebouw                          
2412	Congresgebouw                                     
2413	Museum                                            
2414	Expositiehal/evenementenhal                       
2415	Bioscoop                                          
2416	Bibliotheek                                       
2417	Kasteel                                           
2419	Overig Cultureel                                  
2420	Autoshowroom + garage                             
2430	Onderhoud/reparatie                               
2450	Religie                                           
2451	Kerk                                              
2452	Kapel                                             
2453	Moskee                                            
2459	Overige religieuze gebouwen                       
2460	produktie (fabriek)                               
2470	opslag/distributie                                
2500	agrarische + bedrijfswoning                       
2510	akkerbouwbedrijf                                  
2511	Sporthal/Sportzaal                                
2512	Sportterrein                                      
2513	Stadion                                           
2514	Tribune                                           
2515	Clubhuis                                          
2516	Kleedgebouw/toiletten                             
2517	Kantine                                           
2518	Recreatie/sportcentrum                            
2519	Tennisbaan                                        
2521	Zwembad                                           
2522	Sauna                                             
2523	Jachthaven                                        
2524	Botenhuis                                         
2525	Camping                                           
2526	Bungalowpark                                      
2527	Pretpark                                          
2528	Dierentuin                                        
2551	stoeterij/manege/paardenfokkerij                  
2591	overige agrarische objecten                       
2610	Energie en water                                  
2611	Waterleidingstation                               
2612	Reinwaterkelder                                   
2613	Drinkwaterzuiverings install.                     
2614	Watertoren                                        
2615	Waterverdediging/-Kering                          
2616	Rioolwaterzuiverings install.                     
2617	Gemaal                                            
2618	Gasdistributiestation                             
2619	Stroomdistributiestation                          
2621	Trafo                                             
2622	Hoogspanningsmast                                 
2623	Electriciteitscentrale                            
2624	Windmolen                                         
2629	Overig energie en water                           
2630	Transport                                         
2631	Luchthaven/Vliegbasis /-veld                      
2632	Zee/binnenhaven                                   
2633	Vuurtoren                                         
2634	NS-Station                                        
2635	Busstation                                        
2636	Parkeergarage                                     
2637	.                                                 
2638	Benzinestation                                    
2639	Overig transport                                  
2660	Communicatie                                      
2661	Postkantoor                                       
2662	Postkantoor (Specifiek)                           
2663	Postsorteerbedrijf                                
2664	Telefooncentrale                                  
2665	Zendmast                                          
2666	Televisiemast                                     
2667	Overig communicatie                               
2690	Overige nutsvoorzieningen                         
2691	Uitkijkpost                                       
2692	Schuilkelder                                      
2693	Bunker                                            
2800	Specifieke gemeentelijke obj.                     
2999	Overige Onroerende niet-woning                    
3000	Bedrijf (dienstverlenend)                         
3010	Winkel                                            
3020	Bank                                              
3030	Kantoor                                           
3040	Horeca                                            
3050	Agrarisch bedrijf                                 
3060	Garagebedrijf                                     
3070	Werkplaats                                        
3080	Kleine industrie                                  
3090	Grote industrie                                   
3100	Tuincentrum                                       
3110	Detailhandel                                      
3111	Winkel                                            
3112	Groothandel                                       
3113	Toonzaal                                          
3114	Kiosk                                             
3119	Overig                                            
3120	Horeca                                            
3121	Cafetaria/snackbar                                
3122	Cafébar/restaurant                                
3123	Bar/dancing                                       
3124	Hotel/motel                                       
3125	Pension/logiesgebouw                              
3140	Kantoren                                          
3141	Kantoor                                           
3142	Kantoor in bedrijfsverz.geb.                      
3143	Kantoor (solitair)                                
3144	Studiogebouw                                      
3150	toonzaal                                          
3161	Laboratorium                                      
3162	Praktijkruimte                                    
3171	Werkplaats/garage                                 
3172	Autoshowroom + garage                             
3173	Onderhoud/reparatie                               
3174	Produktie (fabriek)                               
3175	Opslag/distributie                                
3190	overige detailhandel                              
3200	horeca                                            
3210	cafetaria/snackbar                                
3211	Akkerbouwbedrijf                                  
3212	Tuinbouwbedrijf                                   
3213	Fruitkwekerij                                     
3214	Champignonteeltbedrijf                            
3215	Witlofteeltbedrijf                                
3216	Boomkwekerij (incl. sierteelt)                    
3217	Bosbouwbedrijf                                    
3218	Tuincentrum                                       
3220	cafe/bar/restaurant                               
3230	bar/dancing                                       
3240	hotel/motel                                       
3241	Proefboerderij                                    
3242	Gemengd bedrijf                                   
3243	Melkveebedrijf                                    
3244	Kaasboerderij                                     
3245	Veehouderij runderen                              
3246	Veehouderij varkens                               
3247	KI-station                                        
3248	Veehouderij pluimvee                              
3250	pension/logiesgebouw                              
3261	Stoeterij/manege/fokkerij                         
3262	Viskwekerij                                       
3263	Kinderboerderij                                   
3264	Loonwerkbedrijf                                   
3265	Pelsdierfokkerij                                  
3266	Broederij                                         
3299	Overige agrarische objecten                       
3300	kantoren en laboratoria                           
3310	kantoren/praktijkruimte                           
3311	Crêche/peuterzaal                                 
3312	Basisschool                                       
3313	Algem.Onderwijs; MAVO-HAVO-VWO                    
3314	Beroepsonderwijs LBO/MBO                          
3315	Hogeschool/universiteit                           
3316	Vrije-tijdsonderwijs                              
3317	Speciaal onderwijs                                
3318	Dagverblijf                                       
3319	Overig onderwijs                                  
3320	kantoor in bedrverzamelgebouw                     
3330	solitair kantoor                                  
3331	Ziekenhuis                                        
3332	(Poli)Kliniek                                     
3333	Medisch dagverblijf                               
3334	Psychiatrische ziekenhuis                         
3335	Revalidatiecenrum                                 
3336	Verpleegtehuis                                    
3337	Gezinsvervangend tehuis                           
3338	Verstandelijk gehandicapten                       
3339	Medisch overig                                    
3351	Verzorgings/bejaardentehuis                       
3352	Kruisgebouw                                       
3353	Praktijkruimte tandarts+fysio                     
3354	Kindertehuis                                      
3355	Sociale werkvoorziening                           
3356	Gevangenis                                        
3357	Klooster                                          
3358	Kazerne                                           
3359	Overige bijzondere woonfunctie                    
3360	laboratorium                                      
3371	Gemeentehuis                                      
3372	Gemeentewerken                                    
3373	Politiegebouw                                     
3374	Gerechtsgebouw                                    
3375	Brandweerkazerne                                  
3376	Wijk/Buurtcentrum                                 
3377	Begraafplaats                                     
3378	Aula                                              
3379	Crematorium                                       
3400	industrie/distributie                             
3410	werkplaats/garage                                 
3411	Schouwburg/concertgebouw                          
3412	Congresgebouw                                     
3413	Museum                                            
3414	Expositiehal/evenementenhal                       
3415	Bioscoop                                          
3416	Bibliotheek                                       
3417	Kasteel                                           
3419	Overig Cultureel                                  
3451	Kerk                                              
3452	Kapel                                             
3453	Moskee                                            
3459	Overige religieuze gebouwen                       
3460	produktie (fabriek)                               
3470	opslag/distributie                                
3500	agrarisch                                         
3511	Sporthal/Sportzaal                                
3512	Sportterrein                                      
3513	Stadion                                           
3514	Tribune                                           
3515	Clubhuis                                          
3516	Kleedgebouw/toiletten                             
3517	Kantine                                           
3518	Recreatie/sportcentrum                            
3519	Tennisbaan                                        
3520	IJsbaan
3521	Zwembad                                           
3522	Sauna                                             
3523	Jachthaven                                        
3524	Botenhuis                                         
3525	Camping                                           
3526	Bungalowpark                                      
3527	Pretpark                                          
3528	Dierentuin                                        
3542	intensieve veehouderij varkens                    
3544	Intensieve veehouderij pluimvee                   
3611	Waterleidingstation                               
3612	Reinwaterkelder                                   
3613	Drinkwaterzuiveringsinstall.                      
3614	Watertoren                                        
3615	Waterverdediging/-kering                          
3616	Rioolwaterzuiveringsinstall.                      
3617	Gemaal                                            
3618	Gasdistributiestation                             
3619	Stroomdistributiestation                          
3621	Trafo                                             
3622	Hoogspanningsmast                                 
3623	Electriciteitscentrale                            
3624	Windmolen                                         
3629	Overig energie en water                           
3631	Luchthaven/Vliegbasis/-veld                       
3632	Zee/binnenhaven                                   
3633	Vuurtoren                                         
3634	NS-Station                                        
3635	Busstation                                        
3636	Parkeerplaats in garage                           
3638	Benzinestation                                    
3639	Overig transport                                  
3661	Postkantoor                                       
3662	Postkantoor (specifiek)                           
3663	Postsorteerbedrijf                                
3664	Telefooncentrale                                  
3665	Zendmast                                          
3666	Televisiemast                                     
3667	Overig communicatie                               
3691	Uitkijkpost                                       
3692	Schuilkelder                                      
3693	Bunker                                            
3999	Overige onroerende niet-woning
4000	Ongebouwd                                         
4010	Bouwterrein                                       
4020	Opslagterrein                                     
4030	Volkstuin                                         
4040	Tuin of erf                                       
4050	Parkeerterrein                                    
4060	Terrein                                           
4070	Speeltuin                                         
4100	Ongebouwd                                         
4111	Bouwterrein                                       
4112	Stortplaats                                       
4113	Volkstuin                                         
4114	Speeltuin                                         
4115	Parkeerterrein/-plaats                            
4123	Natuurterrein
4126	Bos
4199	Overig ongebouwd                                  
5000	Overige                                           
5010	Garagebox                                         
5020	Transformatorhuisje                               
5030	Pen-centrale                                      
5040	PTT-centrale                                      
5050	Parkeergarage                                     
5060	Waterzuiveringsinstallatie                        
5070	Rioolwaterzuiveringsinstall.                      
5080	Watertoren                                        
5090	Gemaal                                            
5100	Woning in aanbouw                                 
5110	creche/peuterspeelzaal                            
5120	basisschool                                       
5130	Schuur                                            
5131	algemene voortgezet onderwijs                     
5132	beroepsonderwijs(LBO/MBO)                         
5140	Loods                                             
5150	Stal                                              
5170	Gas-olielocaties                                  
5180	Nutsvoorziening (N.E.G.)                          
5190	Brandweerkazerne                                  
5200	Niet woning met woonged. i.a.                     
5210	Overheidsgebouw                                   
5220	Gevangenis                                        
5230	Postkantoor                                       
5240	Kerk/kapel inkl. aanh.                            
5245	Toren bij kerk                                    
5250	Klooster                                          
5260	verpleegtehuis                                    
5270	Diversen                                          
5300	Niet woning znd. woonged. i.a.                    
5310	verzorgings-/bejaardentehuis                      
5320	kruisgebouw                                       
5330	praktijkruimte(tandarts/fysiotherapie             
5360	gevangenis                                        
5370	klooster                                          
5390	overige inrichting                                
5400	gemeenschapsgebouw                                
5411	schouwburg/concertgebouw                          
5412	congresgebouw                                     
5414	expositie                                         
5415	bioscoop                                          
5416	bibliotheek                                       
5441	kerk                                              
5442	kapel                                             
5443	moskee/overige religieuze gebouwen                
5450	kasteel                                           
5500	gemeenschapsgebouwen overig                       
5511	gemeentehuis                                      
5512	gemeentewerken                                    
5513	politiebureau                                     
5515	brandweerkazerne                                  
5530	wijk/buurtcentrum                                 
5541	begraafplaats                                     
5542	begraafplaatsgebouw                               
5543	aula                                              
5544	crematorium                                       
5700	sport -enrecreatievoorzieningen                   
5711	sporthal/sportzaal                                
5712	sportterrein                                      
5713	stadion                                           
5715	clubhuis                                          
5716	kleedgebouw/toilet                                
5717	kantine                                           
5718	recreatie/sportcentrum                            
5719	tennisbaan                                        
5721	zwembad                                           
5722	sauna                                             
5731	jachthaven                                        
5741	camping                                           
5742	bungalowpark                                      
5751	pretpark                                          
5900	Overige objecten in aanbouw                       
6000	Gebouwen voor onderwijs                           
6010	Kleuterschool                                     
6011	energie en water                                  
6020	Basisschool                                       
6030	School v.voortgez.hoger onderw                    
6040	Gymnastieklokaal                                  
6050	Peuterspeelzaal                                   
6060	Wetenschappelijk onderzoek                        
6111	waterleiding                                      
6112	reinwaterkelder                                   
6113	drinkwaterzuiveringsinstallatie                   
6114	watertoren                                        
6115	waterverdediging/-kering                          
6116	rioolwaterzuiveringsinstallatie                   
6120	gemaal                                            
6130	gasdistributie station                            
6140	trafo                                             
6141	stroomdistributiestation                          
6142	trafo                                             
6143	hoogspanningmast                                  
6144	elektriciteitcentrale                             
6200	transport                                         
6241	parkeergarage                                     
6242	garagebox                                         
6243	benzinestation                                    
6300	vrijgesteld ongebouwd
6311	postkantoor                                       
6500	Gemeenschapsgebouwen                              
6510	Cultureel gebouw                                  
6520	Verenigingsgebouw                                 
6530	Bioscoop                                          
6540	Schouwburg                                        
6550	Dansschool                                        
6560	Bibliotheek                                       
6570	Congrescentrum                                    
6580	Sportschool                                       
6600	Gemeentehuis                                      
6900	overig                                            
7000	Rekreatieve objecten                              
7010	Sportterreinen inkl.aanh.                         
7020	Sporthal                                          
7030	Zwembad                                           
7040	Sauna                                             
7050	Manege                                            
7060	Camping                                           
7070	Jachthaven                                        
7090	Tennisbaan                                        
7100	ongebouw                                          
7110	Stadion                                           
7111	bouwterrein                                       
7112	object in aan-/verbouw                            
7130	volkstuin                                         
7140	speeltuin                                         
7150	parkeerterrein                                    
7190	overig terrein                                    
7210	overig onroerend niet woning                      
7500	Gebouwen voor gezondheidszorg                     
7510	Ziekenhuis                                        
7520	Kruisgebouw                                       
7530	Verpleegtehuis                                    
7540	Verzorgingstehuis                                 
7550	Groepspraktijk                                    
7560	Consultatiebureau                                 
7570	Dienstencentrum                                   
7580	Inrichting                                        
8000	Defensieve/civiele objecten                       
8010	Defensieve/civiele objecten                       
9100	Sluimerend WOZ-object                             
9200	object bestaat niet meer                          
9222	niet woning samengevoegd                          
9900	onbekend                                          
9911	woning                                            
999 	Nog te bepalen                                    
9990	volledig onbekend                                 
9999	Nog te bepalen                                    
     */
    /**
     * <TABLE FRAME=VOID CELLSPACING=0 COLS=7 RULES=NONE BORDER=0>
	<COLGROUP><COL WIDTH=86><COL WIDTH=86><COL WIDTH=86><COL WIDTH=86><COL WIDTH=86><COL WIDTH=86><COL WIDTH=86></COLGROUP>
	<TBODY>
		<TR>
			<TD WIDTH=86 HEIGHT=17 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman">Voor 1945</FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman">1945-1970</FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman">1971-1990</FONT></TD>
			<TD WIDTH=86 ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman">Na 1990</FONT></TD>
		</TR>
		<TR>
			<TD ROWSPAN=9 HEIGHT=257 ALIGN=CENTER BGCOLOR="#000080"><B><FONT FACE="Times New Roman" COLOR="#FFFFFF">Woningtype</FONT></B></TD>
			<TD ALIGN=LEFT BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">In eensgezins-pand</FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Vrijstaande woning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,05</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,15</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,14</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,25</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">2^1 kap woning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,06</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,12</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,18</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,16</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Rijtjeswoning: hoek- en tussen </FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,16</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,21</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,10</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,15</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=LEFT BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">In meergezins-pand</FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Maisonnette</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,99</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,25</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,94</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,92</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Appartement</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,21</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,10<A HREF="http://mail.google.com/mail/?ui=2&amp;view=bsp&amp;ver=ymdfwq781tpu#11a2a5919350f969_sdfootnote1sym">1</A></FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,08</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,03</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Benedenwoning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,07</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,03</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,97</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,08</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Bovenwoning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,03</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,14</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,09</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,14</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Galerij-woning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,03</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,07</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,91</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,01</FONT></TD>
		</TR>
		<TR>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman"><BR></FONT></TD>
			<TD ALIGN=CENTER BGCOLOR="#000080"><FONT FACE="Times New Roman" COLOR="#FFFFFF">Portiek-woning</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,04</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,12</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">3,04</FONT></TD>
			<TD ALIGN=CENTER><FONT FACE="Times New Roman">2,96</FONT></TD>
		</TR>
	</TBODY>
</TABLE>
     */    
    public static Long getOppervlakte(String woznummer, Long jaartal, Long inhoud, Long	gebruikscode, Long soortcode, String soortomschrijving)
    {
    	String VRIJSTAANDE = "VRIJSTAANDE WONING";
    	String TWEE_KAP = "2^1 KAP WONING";
		String RIJTJES = "RIJTJESWONING: HOEK EN TUSSEN";
		String MAISONNETTE = "MAISONNETTE";
		String APPARTEMENT = "APPARTEMENT";
		String BENEDEN = "BENEDENWONING";
		String BOVEN = "BOVENWONING";
		String GALLERIJ = "GALLERIJ-WONING";
		String PORTIEK = "PORTIEK-WONING";
		
		if(soortomschrijving == null)  {
    		log.info("Oppervlakte: No soortomschrijving for wozobject:" + woznummer + " jaartal:" + jaartal + " soort:" + soortomschrijving);
    		return null;
    	}

		
    	// gebruik bovenstaande omreken tabel om tot iets zinnigs te komen
    	double factor = 0; 
    	if(jaartal.intValue() < 1945) {
    		if(soortomschrijving.toUpperCase().startsWith(VRIJSTAANDE)) factor = 3.05; 
    		if(soortomschrijving.toUpperCase().startsWith(TWEE_KAP)) factor = 3.06;
    		if(soortomschrijving.toUpperCase().startsWith(RIJTJES)) factor = 3.16;
    		if(soortomschrijving.toUpperCase().startsWith(MAISONNETTE)) factor = 2.99;
    		if(soortomschrijving.toUpperCase().startsWith(APPARTEMENT)) factor = 3.21;
    		if(soortomschrijving.toUpperCase().startsWith(BENEDEN)) factor = 3.07;
    		if(soortomschrijving.toUpperCase().startsWith(BOVEN)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(GALLERIJ)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(PORTIEK)) factor = 3.04;
    	}
    	else if(jaartal.intValue() < 1970) {
    		if(soortomschrijving.toUpperCase().startsWith(VRIJSTAANDE)) factor = 3.05; 
    		if(soortomschrijving.toUpperCase().startsWith(TWEE_KAP)) factor = 3.06;
    		if(soortomschrijving.toUpperCase().startsWith(RIJTJES)) factor = 3.16;
    		if(soortomschrijving.toUpperCase().startsWith(MAISONNETTE)) factor = 2.99;
    		if(soortomschrijving.toUpperCase().startsWith(APPARTEMENT)) factor = 3.21;
    		if(soortomschrijving.toUpperCase().startsWith(BENEDEN)) factor = 3.07;
    		if(soortomschrijving.toUpperCase().startsWith(BOVEN)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(GALLERIJ)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(PORTIEK)) factor = 3.04;
    	}
    	else if(jaartal.intValue() < 1990) {
    		if(soortomschrijving.toUpperCase().startsWith(VRIJSTAANDE)) factor = 3.05; 
    		if(soortomschrijving.toUpperCase().startsWith(TWEE_KAP)) factor = 3.06;
    		if(soortomschrijving.toUpperCase().startsWith(RIJTJES)) factor = 3.16;
    		if(soortomschrijving.toUpperCase().startsWith(MAISONNETTE)) factor = 2.99;
    		if(soortomschrijving.toUpperCase().startsWith(APPARTEMENT)) factor = 3.21;
    		if(soortomschrijving.toUpperCase().startsWith(BENEDEN)) factor = 3.07;
    		if(soortomschrijving.toUpperCase().startsWith(BOVEN)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(GALLERIJ)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(PORTIEK)) factor = 3.04;
    	}
    	else {	// Na 1990
    		if(soortomschrijving.toUpperCase().startsWith(VRIJSTAANDE)) factor = 3.05; 
    		if(soortomschrijving.toUpperCase().startsWith(TWEE_KAP)) factor = 3.06;
    		if(soortomschrijving.toUpperCase().startsWith(RIJTJES)) factor = 3.16;
    		if(soortomschrijving.toUpperCase().startsWith(MAISONNETTE)) factor = 2.99;
    		if(soortomschrijving.toUpperCase().startsWith(APPARTEMENT)) factor = 3.21;
    		if(soortomschrijving.toUpperCase().startsWith(BENEDEN)) factor = 3.07;
    		if(soortomschrijving.toUpperCase().startsWith(BOVEN)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(GALLERIJ)) factor = 3.03;
    		if(soortomschrijving.toUpperCase().startsWith(PORTIEK)) factor = 3.04;
    	}
    	if(factor == 0) {
    		log.info("Oppervlakte: No match for wozobject:" + woznummer + " jaartal:" + jaartal + " soort:" + soortomschrijving);
    		return null;
    	}
    	double oppervlakte = factor * inhoud; 
    	return new Long((int)oppervlakte);
    }
}
