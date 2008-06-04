/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nergens.bag.interact.grs;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
    private static Logger log = Logger.getLogger(AddGeotaxInformation.class.getName());
    private static final java.lang.String BAG_ORACLE_SERVER = "";
    private static final java.lang.Integer BAG_ORACLE_PORT = 1521;
    private static final java.lang.String BAG_ORACLE_SID = "";
    private static final java.lang.String BAG_ORACLE_USERNAME = "";
    private static final java.lang.String BAG_ORACLE_PASSWORD = "";
    private static final java.lang.String BAG_ORACLE_SQL = "SELECT \n" +
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
        // the basic sql is like the following,...
        log.info(BAG_ORACLE_SQL);
        
        Session session = HibernateFactory.getSessionFactory().getCurrentSession();
        session.beginTransaction();                
        List<Verblijfsobject> verblijfsobjecten = session.createQuery("from Verblijfsobject verblijfsobject where verblijfsobject.documentnummer is null").list();
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
	            String filter = "BOUW%VERGUNNING%" + straatnaam.toUpperCase() + "%" + huisnummer + "%";
	            if(huisletter != null) {
	            	filter += huisletter.toUpperCase() + "%";
	            }
	            if(huisnummertoevoeging != null) {
	            	filter += huisnummertoevoeging.toUpperCase() + "%";
	            }
	            filter += woonplaatsnaam.toUpperCase();
	            sql += "    AND UPPER(DOCUMENTOMSCHRIJVING) LIKE ('" + filter +"')\n";
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
	                String[] details = getVergunningDetails(documentomschrijving);
	                if(details[0].equals(straat.getNaam().toUpperCase())) {
	                	String nummeraanduiding = nummer.getHuisnummer().toString();
	                	if(nummer.getHuisletter() != null ) nummeraanduiding += nummer.getHuisletter();
	                	if(nummer.getHuisnummertoevoeging() != null ) nummeraanduiding += nummer.getHuisnummertoevoeging();
	                	if (details[1].equals(nummeraanduiding.toUpperCase())) {
	                		if (details[2].equals(woonplaats.getNaam().toUpperCase())) {
	    		                verblijfsobject.setDocumentNummer(documentnr);
	    		                Format formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
	    		                if(documentdatum != null) {
	    		                	verblijfsobject.setDocumentDatum((java.util.Date)formatter.parseObject(documentdatum));
	    		                }
	    		                log.info("SAVE:" + verblijfsobject + " OMSCHRIJVING:" + documentomschrijving + " DOCUMENTNR:" + documentnr);
	    		                session.save(verblijfsobject);
	    		                break;
	                		}
	                		else log.info("RECORD DOES NOT MATCH ON WOONPLAATS(" + woonplaats + " !=  " + details[2] + "):" + documentomschrijving);
	                	}
		                //else log.info("RECORD DOES NOT MATCH ON NUMBER(" + nummeraanduiding + " !=  " + details[1] + "):" + documentomschrijving);	                	
	                }
	                else log.info("RECORD DOES NOT MATCH ON STRAAT(" + straat  + " !=  " + details[0] + "):" + documentomschrijving);
	            }	            	            
	            recordset.close();
	            statement.close();	        
        	}
        	catch(SQLSyntaxErrorException ssee) {
        		log.info(sql);
        		ssee.printStackTrace();
        	}
        	catch(Exception ex) {
        		log.info(sql);
        		ex.printStackTrace();
        	}
        }
        session.getTransaction().commit();        
        connection.close();
        // datasource.close();
    }
    private static String[] getVergunningDetails(String str) {    	    	
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
    	while(todo.length() > 0 
    	    	// skip any leading "0"
    			&&(todo.charAt(0) == '0'))
    	{
    		todo = todo.substring(1);
    	}
    	while(todo.length() > 0 
    	    	// skip any trailing "," or " "-es
    			&&(todo.charAt(todo.length() -1) == ' ' || todo.charAt(todo.length() -1) == ','))
    	{
    		todo = todo.substring(0, todo.length()  - 1);
    	}
    	String nummeraanduiding = todo;
    	if(straatnaam.length() == 0) {
    		log.info("no straatnaam for:" + str);
    	}
    	else if(woonplaatsnaam.length() == 0) {
    		log.info("no woonplaats for:" + str);
    	}
    	else if(nummeraanduiding.length() == 0) {
    		log.info("no nummeraanduiding for:" + str);
    	}
    	else {
    		log.info("omschrijving:"+ str +"\n\tstraat:"+ straatnaam+"\n\tnummer:"+nummeraanduiding+"\n\twoonplaats:"+woonplaatsnaam);
    	}
    	return new String[]{straatnaam, nummeraanduiding, woonplaatsnaam};
    }
}
