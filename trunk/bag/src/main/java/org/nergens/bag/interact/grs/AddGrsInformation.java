/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nergens.bag.interact.grs;

import java.sql.Connection;
import java.sql.SQLSyntaxErrorException;
import java.text.Format;
import java.text.SimpleDateFormat;
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
    private static Logger log = Logger.getLogger(AddGeotaxInformation.class.getName());
    private static final java.lang.String BAG_ORACLE_SERVER = "";
    private static final java.lang.Integer BAG_ORACLE_PORT = 1521;
    private static final java.lang.String BAG_ORACLE_SID = "";
    private static final java.lang.String BAG_ORACLE_USERNAME = "";
    private static final java.lang.String BAG_ORACLE_PASSWORD = "";
    private static final java.lang.String BAG_ORACLE_SQL = "SELECT *\n" + 
    "     FROM (\n" +
    "       SELECT\n" +
    "         SUBSTR('00000000000000000000', 20 - LENGTH(STUKNR))\n" +
    "         || \n" +
    "         STUKNR AS DOCUMENTNR,\n" + 
    "         TO_DATE(STUKDAT) DOCUMENTDATUM,\n" +  
    "         OMSLANG DOCUMENTOMSCHRIJVING\n" +
    "       FROM GRS.STUK\n" +
    "       UNION SELECT \n" +
    "         SUBSTR('dossier:000000000000', 20 - LENGTH(DOSSIERKODE))\n" +
    "         ||   \n" +
    "         DOSSIERKODE,\n" + 
    "         NULL, \n" +
    "         OMSLANG\n" +
    "       FROM GRS.DOSSIER\n" +
    "     ) DOCUMENT\n";
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
	            String filter = "BOUW%VERGUNNING%" + straatnaam.toUpperCase() + "%" + huisnummer + "%";
	            if(huisletter != null) {
	            	filter += huisletter.toUpperCase() + "%";
	            }
	            if(huisnummertoevoeging != null) {
	            	filter += huisnummertoevoeging.toUpperCase() + "%";
	            }
	            filter += woonplaatsnaam.toUpperCase();
	            sql += "    WHERE UPPER(DOCUMENTOMSCHRIJVING) LIKE ('" + filter +"')\n";
	            // find the minimal string with this result, and the latest result
	            sql += "    ORDER BY LENGTH(DOCUMENTOMSCHRIJVING) ASC, DOCUMENTDATUM DESC";
	            log.info(sql);
	            java.sql.Statement statement = connection.createStatement();
	            java.sql.ResultSet recordset = statement.executeQuery(sql);
	            if(recordset.next()) {	                
	                String documentnr = recordset.getString("DOCUMENTNR");
	                String documentdatum = recordset.getString("DOCUMENTDATUM");
	                String documentomschrijving = recordset.getString("DOCUMENTOMSCHRIJVING");
	                // TODO: see if documentomschrijving - matching fields does not contain any characters!
	                verblijfsobject.setDocumentNummer(documentnr);
	                Format formatter = new SimpleDateFormat("DD-MMM-yy");
	                if(documentdatum != null) {
	                	verblijfsobject.setDocumentDatum((java.util.Date)formatter.parseObject(documentdatum));
	                }
	                session.save(verblijfsobject);
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
}
