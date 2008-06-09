/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nergens.bag.interact.grs;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import oracle.jdbc.pool.OracleDataSource;

import org.hibernate.Session;
import org.nergens.bag.interact.geotax.AddGeotaxInformation;
import org.nergens.bag.storage.pojo.Nummeraanduiding;
import org.nergens.bag.storage.pojo.Openbareruimte;
import org.nergens.bag.storage.pojo.Verblijfsobject;
import org.nergens.bag.storage.pojo.Woonplaats;
import org.nergens.bag.storage.util.HibernateFactory;

/**
 *
 * @author Administrator
 */
public class AddGrsInformation {
	class AdresGegeven {
    	AdresGegeven() {
    	}
    	public String woonplaatsnaam = null;
    	public HashMap<String, String> huisnummers = new HashMap<String, String>(); 
    	public String straatnaam = null;
        @Override
    	public String toString() {
    		String nummers = "";
    		for(String nummer : huisnummers.keySet()) {
    			nummers += "[" + nummer + "] "; 
    		}
    		return "straat:" + straatnaam+"\n\tnummer:" + nummers+"\n\twoonplaats:" + woonplaatsnaam;
    	}
    }	
    private static Logger log = Logger.getLogger(AddGeotaxInformation.class.getName());
    private static final java.lang.String BAG_ORACLE_SERVER = "servername";
    private static final java.lang.Integer BAG_ORACLE_PORT = 1521;
    private static final java.lang.String BAG_ORACLE_SID = "databasename";
    private static final java.lang.String BAG_ORACLE_USERNAME = "username";
    private static final java.lang.String BAG_ORACLE_PASSWORD = "password";
    private static final java.lang.String BAG_ORACLE_VERBLIJFSOBJECT_SQL = "SELECT \n" +
    	"           DOCUMENTNR, \n" +
    	"           DOCUMENTDATUM, \n" +
    	"           DOCUMENTOMSCHRIJVING\n" +
    	"              FROM (\n" +
    	"                SELECT\n" +
    	"                  SUBSTR('00000000000000000000', 0, (20 - LENGTH(STUKNR)))\n" +
    	"                  || \n" +
    	"                  STUKNR AS DOCUMENTNR,\n" +
    	"                  TO_DATE(STUKDAT) DOCUMENTDATUM,\n" +
    	"                  OMSLANG DOCUMENTOMSCHRIJVING,\n" +
    	"                  CLS CLASSIFICATIE\n" +
    	"                FROM GRS.STUK\n" +
    	"                UNION SELECT \n" +
    	"                  SUBSTR('dossier:000000000000', 0, (20 - LENGTH(DOSSIERKODE)))\n" +
    	"                  ||   \n" +
    	"                  DOSSIERKODE,\n" +
    	"                 CASE \n" +
    	"                   WHEN ARCHIEFNAAM = 'KELDERB' THEN TO_DATE('01-JAN-1998')\n" +
    	"                   ELSE TO_DATE('01-JAN-1998')\n" +
    	"                  END, \n" +
    	"                  OMSLANG,\n" +
    	"                  CLASSIFICATIE\n" +         
    	"                FROM GRS.DOSSIER\n" +
    	"              ) DOCUMENT\n" +
    	"    WHERE CLASSIFICATIE = 'B'\n";
    
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

        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = null;
        List<Woonplaats> woonplaatsen = session.createQuery("from Woonplaats woonplaats where woonplaats.documentnummer is null").list();        
        for (Woonplaats woonplaats :  woonplaatsen) {
        	try 
        	{
	            // all the woonplaats have the same document!
	            sql = "SELECT\n";
                    sql += "  SUBSTR('00000000000000000000', 0, (20 - LENGTH(STUKNR)))\n";
                    sql += "  ||\n";
                    sql += "  STUKNR AS DOCUMENTNR,\n";
                    sql += "  TO_DATE(STUKDAT) DOCUMENTDATUM,\n";
                    sql += "  OMSLANG DOCUMENTOMSCHRIJVING,\n";
                    sql += "  CLS CLASSIFICATIE\n";
                    sql += "FROM GRS.STUK\n";
                    sql += "WHERE UPPER(OMSLANG) LIKE ('%WOONPLAATS%')\n";
                    sql += "AND UPPER(OMSLANG) LIKE ('%BESLUIT%')\n";
                    sql += "ORDER BY LENGTH(DOCUMENTOMSCHRIJVING) ASC, DOCUMENTDATUM DESC";
	            java.sql.Statement statement = connection.createStatement();
	            java.sql.ResultSet recordset = statement.executeQuery(sql);	            
	            if(recordset.next()) {
	                String documentnr = recordset.getString("DOCUMENTNR");
	                String documentdatum = recordset.getString("DOCUMENTDATUM");
	                String documentomschrijving = recordset.getString("DOCUMENTOMSCHRIJVING");
	                
                        woonplaats.setDocumentNummer(documentnr);
	    		Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
	    		if(documentdatum != null) {
                            woonplaats.setDocumentDatum((java.util.Date)formatter.parseObject(documentdatum));
                        }
	    		log.info("SAVE:" + woonplaats + " OMSCHRIJVING:" + documentomschrijving + " DOCUMENTNR:" + documentnr);
	    		session.save(woonplaats);
                    }	            	            
	            recordset.close();
	            statement.close();	        
        	}
        	catch(SQLSyntaxErrorException ssee) {
        		log.info(sql);
        		ssee.printStackTrace();
        	}
        	catch(Exception ex) {
        		//log.info(sql);
        		ex.printStackTrace();
        	}
        }

        
        List<Verblijfsobject> verblijfsobjecten = session.createQuery("from Verblijfsobject verblijfsobject where verblijfsobject.documentnummer is null").list();
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
                    if(straat == null) {
                        continue;
                    }
	            //log.info(straat.toString());
	            String straatnaam = straat.getNaam();
	            if(straatnaam != null) {
	            	straatnaam = straatnaam.replace("'", "''");
	            }		            
	            Woonplaats woonplaats = straat.getWoonplaats();
                    if(woonplaats == null) {
                        continue;
                    }                    
	            //log.info(woonplaats.toString());
	            String woonplaatsnaam = woonplaats.getNaam().replace("'", "''");
	            if(woonplaatsnaam != null) {
	            	woonplaatsnaam = woonplaatsnaam.replace("'", "''");
	            }		            	            
	            // now we will make a nice sql statement of the stuff above,..
	            sql = BAG_ORACLE_VERBLIJFSOBJECT_SQL;
	            sql += "    -- sepecific filter:\n";
	            String filter = "BOUW%VERGUNNING%" + straatnaam.toUpperCase() + "%" + huisnummer + "%";
	            if(huisletter != null) {
	            	filter += huisletter.toUpperCase() + "%";
	            }
	            if(huisnummertoevoeging != null) {
	            	filter += huisnummertoevoeging.toUpperCase() + "%";
	            }
	            filter += woonplaatsnaam.toUpperCase();
	            sql += "    AND (\n";
	            sql += "    UPPER(DOCUMENTOMSCHRIJVING) LIKE ('" + filter +"')\n";
	            sql += "    OR\n";
	            filter = "BOUW%VERGUNNING%" + straatnaam.toUpperCase() + "%T/M%" + woonplaatsnaam.toUpperCase();
	            sql += "    UPPER(DOCUMENTOMSCHRIJVING) LIKE ('" + filter +"')\n";
	            sql += "    )\n";
	            // find the minimal string with this result, and the latest result
	            sql += "    ORDER BY LENGTH(DOCUMENTOMSCHRIJVING) ASC, DOCUMENTDATUM DESC";
	            //log.info(sql);
	            java.sql.Statement statement = connection.createStatement();
	            java.sql.ResultSet recordset = statement.executeQuery(sql);	            
	            while(recordset.next()) {
	                String documentnr = recordset.getString("DOCUMENTNR");
	                String documentdatum = recordset.getString("DOCUMENTDATUM");
	                String documentomschrijving = recordset.getString("DOCUMENTOMSCHRIJVING");
	                
	                // DOUBLE CHECK!
	                // check if documentomschrijving is the same thing as we are searhcing for
	                log.info("CHECK: object:		\n\t" + woonplaats + "\n\t" + nummer +  "\n\t" + straat);
	                log.info("DOUBLE CHECK: document#	" + documentnr);
	                log.info("DOUBLE CHECK: document:	" + documentomschrijving);
	                AdresGegeven details = getVergunningDetails(documentomschrijving);
	                if(details == null) {
	                	// could not process this omschrijving
	                	log.info("DOUBLE CHECK: COULD NOT PARSE STRING");
	                	continue;
	                }
	                // some output
	                log.info("DOUBLE CHECK:\n\t" + details);	               
	                
	                if(details.straatnaam.equals(straat.getNaam().toUpperCase())) {
	                	String nummeraanduiding = nummer.getHuisnummer().toString();
	                	if(nummer.getHuisletter() != null ) nummeraanduiding += nummer.getHuisletter();
	                	if(nummer.getHuisnummertoevoeging() != null ) nummeraanduiding += nummer.getHuisnummertoevoeging();
	                	if (details.huisnummers.containsKey(nummeraanduiding.toUpperCase())) {
	                		if (details.woonplaatsnaam.equals(woonplaats.getNaam().toUpperCase())) {
	    		                verblijfsobject.setDocumentNummer(documentnr);
	    		                Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
	    		                if(documentdatum != null) {
	    		                	verblijfsobject.setDocumentDatum((java.util.Date)formatter.parseObject(documentdatum));
	    		                }
	    		                log.info("SAVE:" + verblijfsobject + " OMSCHRIJVING:" + documentomschrijving + " DOCUMENTNR:" + documentnr);
	    		                session.save(verblijfsobject);
	    		                break;
	                		}
	                		else log.info("RECORD DOES NOT MATCH ON WOONPLAATS(" + woonplaats + ")");
	                	}
		                else log.info("RECORD DOES NOT MATCH ON NUMBER(" + nummeraanduiding + ")");	                	
	                }
	                else log.info("RECORD DOES NOT MATCH ON STRAAT(" + straat   + ")");
	            }	            	            
	            recordset.close();
	            statement.close();	        
        	}
        	catch(SQLSyntaxErrorException ssee) {
        		log.info(sql);
        		ssee.printStackTrace();
        	}
        	catch(Exception ex) {
        		//log.info(sql);
        		ex.printStackTrace();
        	}
        }
        session.getTransaction().commit();        
        connection.close();
        // datasource.close();
    }
    private static String cleanHuisnummerString(String todo) {
    	while(todo.length() > 0 
    	    	// skip any leading "0" and " "-es
    			&&(todo.charAt(0) == ' ' || todo.charAt(0) == '0'))
    	{
    		todo = todo.substring(1);
    	}
    	while(todo.length() > 0 
    	    	// skip any trailing "," or " "-es
    			&&(todo.charAt(todo.length() -1) == ' ' || todo.charAt(todo.length() -1) == ','))
    	{
    		todo = todo.substring(0, todo.length()  - 1);
    	}
    	return todo;
    }
    private static HashMap<String, String> getHuisNummers(String nummeraanduiding) {
    	HashMap<String, String> result = new HashMap<String, String>();
    	// clean the string
    	nummeraanduiding = cleanHuisnummerString(nummeraanduiding);
    	
		// now do the huisnummer logic:
		if(nummeraanduiding.contains("T/M")) {
			// break down with ranges
			String[] nummers = nummeraanduiding.split("T/M");
			if(nummers.length != 2) {
				log.info("Found T/M but not 2 strings:" + nummeraanduiding);
				return null;
			}
			int start;
			int stop;
			try {
				start = Integer.parseInt(nummers[0].trim());
				stop = Integer.parseInt(nummers[1].trim());    				
			}
			catch(java.lang.NumberFormatException nfe) {
				// 1 try more, maybe something like:
				//		"Bouwvergunningen, Markeweg 13 t/m 31 en Schoolstraat 04, Annen"
				// therefore, look if there is an "EN" in the end, ifso, skip tail!
				if(nummers[1].contains("EN")) {
					try {
						start = Integer.parseInt(nummers[0].trim());
						String[] end = nummers[1].split("EN");
						stop = Integer.parseInt(end[0].trim());
						
						log.info("SKIPPING TAIL:" + (end[1]));
					}
					catch(Exception e) {
						log.info("Found not 2 decimal values in string, but found 'EN':" + nummeraanduiding);
						nfe.printStackTrace();    				
						return null;
					}
				}
				else {
					log.info("Found not 2 decimal values in string, but found 'EN':" + nummeraanduiding);
					nfe.printStackTrace();    				
					return null;
				}
			}
			if(start > stop) {
				int swap = start;
				start = stop;
				stop = swap;
			}
			if((stop - start)%2 != 0) {
				log.info("Found 2 numbers which are not both on 1 side of the street:" + nummeraanduiding);
				return null;    				
			}
			// increment by 2 (1 side of the street
			for(int i = start; i <= stop; i = i + 2) {
				result.put("" + (i), nummeraanduiding);
			}
		}
		else if(nummeraanduiding.contains("-")) {
			// break down with "-"
			String[] nummers = nummeraanduiding.split("-");
			for(String nummer : nummers) {
				nummer = cleanHuisnummerString(nummer); 
				result.put(nummer, nummeraanduiding);
			}    			
		}
		else if(nummeraanduiding.contains("EN")) {
			// break down with "-"
			String[] nummers = nummeraanduiding.split("EN");
			for(String nummer : nummers) {
				nummer = cleanHuisnummerString(nummer);
				result.put(nummer, nummeraanduiding);
			}    			
		}    		    		
		else {
			result.put(nummeraanduiding, nummeraanduiding);
		}    	
    	return result;
    }
    private static AdresGegeven getVergunningDetails(String str) {    	    	
    	/**
    	 * Bouwvergunningen, Amen 26c, Amen
    	 * Bouwvergunningen, 't Veld 17, Annen
    	 */    	
    	String todo = str.toUpperCase();
    	String search = "BOUWVERGUNNINGEN";
    	int pos = todo.indexOf(search);
    	if(pos == -1) {
    		search = "BOUWVERGUNNING";
    		pos = todo.indexOf(search);
    	}    	    	
    	if(pos == -1) {
    		log.info("BOUWVERGUNNING NOT FOUND:" + str);
    		return null;    		
    	}
    	todo = todo.substring(pos + search.length());
    	while(todo.length() > 0 
    	    	// skip any leading "," or " "-es
    			&&(todo.charAt(0) == ' ' || todo.charAt(0) == ','))
    	{
    		todo = todo.substring(1);
    	}    	
    	// we can fill the straatnaam
    	String straatnaam = "";
    	while(todo.length() > 0 
    			// we like everything, except a number (housenumbers typically start with that kinda info)
    			&&(todo.charAt(0) < '0' || todo.charAt(0) > '9'))
    	{    		
    		char c = todo.charAt(0);
    		straatnaam += c;
    		todo = todo.substring(1);
    	}
    	// now trim the straatnaam
    	straatnaam = straatnaam.trim();
    	
    	// the part at the end should be the city, and it ends with the ","
    	String woonplaatsnaam = "";
    	while(todo.length() > 0 
    			// seach till the beginnign of the woonplaats
    			&&((todo.charAt(todo.length() -1) != ',') && todo.charAt(todo.length() -1) != ' '))
    	{    		
    		char c = todo.charAt(todo.length() -1);
    		woonplaatsnaam = c + woonplaatsnaam;  
    		todo = todo.substring(0, todo.length()  - 1);
    	}
    	woonplaatsnaam = woonplaatsnaam.trim();    	
    	AddGrsInformation agi = new AddGrsInformation();
    	AddGrsInformation.AdresGegeven result = agi.new AdresGegeven();    	
    	
    	if(straatnaam.length() == 0) {
    		log.info("no straatnaam for:" + str);
    	}
    	else if(woonplaatsnaam.length() == 0) {
    		log.info("no woonplaats for:" + str);
    	}
    	else if(todo.length() == 0) {
    		log.info("no nummeraanduiding for:" + str);
    	}
    	else {
    		result.woonplaatsnaam = woonplaatsnaam;
    		result.straatnaam = straatnaam;
    		result.huisnummers = getHuisNummers(todo);
                if(result.huisnummers == null) {
                    return null;
                }
    		return result;
    	}
    	return null;
    }
}
