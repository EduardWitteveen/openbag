/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nergens.bag.transformations.csv;

import com.Ostermiller.util.CSVParser;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.nergens.bag.storage.pojo.Gemeente;
import org.nergens.bag.storage.pojo.Nummeraanduiding;
import org.nergens.bag.storage.pojo.Openbareruimte;
import org.nergens.bag.storage.pojo.Pand;
import org.nergens.bag.storage.pojo.Verblijfsobject;
import org.nergens.bag.storage.pojo.Woonplaats;
import org.nergens.bag.transformations.Transformator;


/**
 *
 * @author Eduard Witteveen
 */
public class CsvTransformator implements Transformator {
	private static Logger log = Logger.getLogger(CsvTransformator.class.getName());
	
    @SuppressWarnings("unchecked")
	private static HashMap _cache= new HashMap();
    String path= null;
    public String help() {
        return "[path]";
    }
    public void configure(List<String> args) {
        if(args.size() > 0)
            path = args.get(0);
    }
    private File getPath() {
        if(path == null) {
            path = System.getProperty("user.dir") + "/";
            log.info("using path:" + path);
        }
        return new File(path);    
    }
    private String toString(String str) {
        if(str.length() == 0) {
            return null;
        }
        return str;
    }
    @SuppressWarnings("unchecked")
	private Gemeente toGemeente(Session session, String code) {
        if(code.length() == 0) {
            return null;
        }
        long lcode = Long.parseLong(code);
        if(_cache.containsKey(lcode)) {
            return (Gemeente)_cache.get(lcode);
        }
        // next code will not be reached, when started with a clean database
        String query = "from Gemeente gemeente where gemeente.code=?";
        Query q = session.createQuery(query).setLong(0, lcode);
        List<Gemeente> gemeenten = q.list();
        if(gemeenten.size() < 1) {
            log.info("found no objects for gemeente with code:" + code);
            return null;            
        }
        else if(gemeenten.size() == 1)
        {
            Gemeente result = gemeenten.get(0);
            _cache.put(result.getCode(), result);
            return result;
        }
        else {
            log.info("found multiple objects for gemeente with code:" + code);
            return null;
        }
    }
    @SuppressWarnings("unchecked")
	private Woonplaats toWoonplaats(Session session, String code) {
        if(code.length() == 0) {
            return null;
        }    	
        long lcode = Long.parseLong(code);        
        if(_cache.containsKey(lcode)) {
            return (Woonplaats)_cache.get(lcode);
        }
        // next code will not be reached, when started with a clean database
        String query = "from Woonplaats woonplaats where woonplaats.code=?";
        Query q = session.createQuery(query).setLong(0, lcode);
        List<Woonplaats> woonplaatsen = q.list();
        if(woonplaatsen.size() < 1) {
            log.info("found no objects for woonplaats with code:" + code);
            return null;            
        }
        else if(woonplaatsen.size() == 1)
        {
            Woonplaats result = woonplaatsen.get(0);
            _cache.put(result.getCode(), result);
            return result;            
        }
        else {
            log.info("found multiple objects for woonplaats with code:" + code);
            return null;
        }
    }
    @SuppressWarnings("unchecked")
	private Openbareruimte toOpenbareruimte(Session session, String code) {
        if(code.length() == 0) {
            return null;
        }    	
        long lcode = Long.parseLong(code);
        if(_cache.containsKey(lcode)) {
            return (Openbareruimte)_cache.get(lcode);
        }    
        // next code will not be reached, when started with a clean database
        String query = "from Openbareruimte openbareruimte where openbareruimte.code=?";
        Query q = session.createQuery(query).setLong(0, lcode);
        List<Openbareruimte> openbareruimten = q.list();
        if(openbareruimten.size() < 1) {
            log.info("found no objects for openbareruimte with code:" + code);
            return null;            
        }
        else if(openbareruimten.size() == 1)
        {
            Openbareruimte result = openbareruimten.get(0);
            _cache.put(result.getCode(), result);
            return result;            
        }
        else {
            log.info("found multiple objects for openbareruimte with code:" + code);
            return null;
        }
    }    
    @SuppressWarnings("unchecked")
	private Nummeraanduiding toAdres(Session session, String code) {
        if(code.length() == 0) {
            return null;
        }    	
        long lcode = Long.parseLong(code);
        if(_cache.containsKey(lcode)) {
            return (Nummeraanduiding)_cache.get(lcode);
        }
        // next code will not be reached, when started with a clean database
        String query = "from Nummeraanduiding nummeraanduiding where nummeraanduiding.code=?";
        Query q = session.createQuery(query).setLong(0, lcode);
        List<Nummeraanduiding> nummeraanduidingen = q.list();
        if(nummeraanduidingen.size() < 1) {
            log.info("found no objects for nummeraanduiding with code:" + code);
            return null;            
        }
        else if(nummeraanduidingen.size() == 1)
        {
            Nummeraanduiding result = nummeraanduidingen.get(0);
            _cache.put(result.getCode(), result);
            return result;            
        }
        else {
            log.info("found multiple objects for nummeraanduiding with code:" + code);
            return null;
        }
    } 
    private Geometry toGeometry(String str) {
        if(str.length() == 0) {
            return null;
        }
        try {
            WKTReader wkt = new WKTReader();
            return wkt.read(str);
        }
        catch(ParseException pe) {
            log.info("error parsing WKT string:" + str);
            pe.printStackTrace();
            return null;
        }
    }
    private MultiPolygon toMultiPolygon(String str) {
        Geometry g = toGeometry(str);
        if(g == null) return null;
        if("MultiPolygon".equals(g.getGeometryType())) {            
            return (MultiPolygon)g;
        }
        if("Polygon".equals(g.getGeometryType())) {
            GeometryFactory gf = new GeometryFactory();
            Polygon[] apoly =  new Polygon[1];
            apoly[0] = (Polygon)g;
            return gf.createMultiPolygon(apoly);
        }
        log.info("error converting WKT string to Polygon, found type:" + g.getGeometryType()+ " for string:"  + str);
        return null;
    }
    private Polygon toPolygon(String str) {
        Geometry g = toGeometry(str);
        if(g == null) return null;
        if("Polygon".equals(g.getGeometryType())) {            
            return (Polygon)g;
        }
        log.info("error converting WKT string to Polygon, found type:" + g.getGeometryType()+ " for string:"  + str);
        return null;
    }
    private Point toPoint(String str) {
        Geometry g = toGeometry(str);
        if(g == null) return null;
        if("Point".equals(g.getGeometryType())) {            
            return (Point)g;
        }
        log.info("error converting WKT string to Point, found type:" + g.getGeometryType()+ " for string:"  + str);
        return null;
    }
    private Long toLong(String str) {
        if(str.length() == 0) return null;
        Long l = new Long(str);
        return l;
    }
    @SuppressWarnings("unchecked")
	public boolean retrieveFromFormat(Session session) {
        final String FILE_STARTS_WITH = "gemeente";
        File dir = getPath();
        // first find our file
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(FILE_STARTS_WITH) && name.endsWith(".csv");
            }
        };        
        String[] files = dir.list(filter);
        String fileprefix = dir.getAbsolutePath();
        fileprefix = fileprefix + File.separator;
        if(files.length < 1) {
        	throw new RuntimeException("data-files were missing in directory:" + fileprefix);
        }
        String filepostfix = files[0];        
        try
        {
        	// counter, to prevent java.lang.OutOfMemoryError: Java heap space
        	// see also: http://www.hibernate.org/hib_docs/reference/en/html/batch.html
        	int insertCount = 0;
        	int maxInsertCount= 250;        	
        	
        // gemeente
        	String gemeentefilename = fileprefix+ "gemeente" + filepostfix.substring(FILE_STARTS_WITH.length());
            log.info("Processing: " + gemeentefilename);
            InputStream istream = new FileInputStream(gemeentefilename);
            CSVParser shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            String firstfield;
            while ((firstfield = shredder.nextValue()) != null) {
                //  gemeente
                //  code, naam, grens
//                log.info("gemeente #" + shredder.lastLineNumber());
                Gemeente gemeente = new Gemeente();
                gemeente.setCode(toLong(firstfield));
                gemeente.setNaam(toString(shredder.nextValue()));
                gemeente.setGrens(toPolygon(shredder.nextValue()));
                session.save(gemeente);
                _cache.put(gemeente.getCode(), gemeente);
                log.info("\t(" + shredder.lastLineNumber() + ")" + gemeente);
                
            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                
            }
            istream.close();

            // woonplaats
            String woonplaatsfilename = fileprefix+ "woonplaats" + filepostfix.substring(FILE_STARTS_WITH.length());
            log.info("Processing: " + woonplaatsfilename);
            istream = new FileInputStream(woonplaatsfilename);
            shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            while ((firstfield = shredder.nextValue()) != null) {
                //  woonplaats
                //  gemeente_code, code, naam, status, grens
//                log.info("woonplaats #" + shredder.lastLineNumber());
                Woonplaats woonplaats = new Woonplaats();                
                woonplaats.setGemeente(toGemeente(session, firstfield));               
                woonplaats.setCode(toLong(shredder.nextValue()));
                woonplaats.setNaam(toString(shredder.nextValue()));
                woonplaats.setStatus(toString(shredder.nextValue()));
                woonplaats.setGrens(toPolygon(shredder.nextValue()));
                session.save(woonplaats);
                _cache.put(woonplaats.getCode(), woonplaats);
                log.info("\t(" + shredder.lastLineNumber() + ")" + woonplaats);
                
            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                
            }
            istream.close();
            
        // openbareruimte
            String openbareruimtefilename = fileprefix+ "openbareruimte" + filepostfix.substring(FILE_STARTS_WITH.length());            
            log.info("Processing: " + openbareruimtefilename);
            istream = new FileInputStream(openbareruimtefilename);
            shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            while ((firstfield = shredder.nextValue()) != null) {
                //  openbareruimte
                //  woonplaats_code, code, naam, status, type, grens
//                log.info("openbareruimte #" + shredder.lastLineNumber());
                Openbareruimte openbareruimte = new Openbareruimte();                
                openbareruimte.setWoonplaats(toWoonplaats(session, firstfield));               
                openbareruimte.setCode(toLong(shredder.nextValue()));
                openbareruimte.setNaam(toString(shredder.nextValue()));
                openbareruimte.setStatus(toString(shredder.nextValue()));
                openbareruimte.setType(toString(shredder.nextValue()));
                openbareruimte.setGrens(toPolygon(shredder.nextValue()));
                session.save(openbareruimte);
                _cache.put(openbareruimte.getCode(), openbareruimte);
                log.info("\t(" + shredder.lastLineNumber() + ")" + openbareruimte);
                
            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                                
            }
            istream.close();
            
        // nummeraanduiding
            String nummeraanduidingfilename = fileprefix+ "nummeraanduiding" + filepostfix.substring(FILE_STARTS_WITH.length());            
            log.info("Processing: " + nummeraanduidingfilename);
            istream = new FileInputStream(nummeraanduidingfilename);
            shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            while ((firstfield = shredder.nextValue()) != null) {
                //  nummeraanduidingen
                //  openbareruimte_code, code, huisnummer, huisletter, huisnummertoevoeging, postcode, status, type, punt
//                log.info("nummeraanduiding #" + shredder.lastLineNumber());
                Nummeraanduiding nummeraanduiding = new Nummeraanduiding();                
                nummeraanduiding.setOpenbareruimte(toOpenbareruimte(session, firstfield));               
                nummeraanduiding.setCode(toLong(shredder.nextValue()));
                nummeraanduiding.setHuisnummer(toLong(shredder.nextValue()));
                nummeraanduiding.setHuisletter(toString(shredder.nextValue()));
                nummeraanduiding.setHuisnummertoevoeging(toString(shredder.nextValue()));
                nummeraanduiding.setPostcode(toString(shredder.nextValue()));
                nummeraanduiding.setStatus(toString(shredder.nextValue()));
                nummeraanduiding.setType(toString(shredder.nextValue()));
                nummeraanduiding.setPunt(toPoint(shredder.nextValue()));
                session.save(nummeraanduiding);
                _cache.put(nummeraanduiding.getCode(), nummeraanduiding);
                log.info("\t(" + shredder.lastLineNumber() + ")" + nummeraanduiding);

            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                
            }
            istream.close();
            
        // verblijfsobject
            String verblijfsobjectfilename = fileprefix+ "verblijfsobject" + filepostfix.substring(FILE_STARTS_WITH.length());            
            log.info("Processing: " + verblijfsobjectfilename);
            istream = new FileInputStream(verblijfsobjectfilename);
            shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            while ((firstfield = shredder.nextValue()) != null) {
                //  verblijfsobject
                //  gemeente_code, adres_code, code, oppervlakte, status, grens                    
//                log.info("verblijfsobject #" + shredder.lastLineNumber());
                Verblijfsobject verblijfsobject = new Verblijfsobject();                
                verblijfsobject.setGemeente(toGemeente(session, firstfield));
                verblijfsobject.setHoofdadres(toAdres(session, shredder.nextValue()));
                verblijfsobject.setCode(toLong(shredder.nextValue()));
                verblijfsobject.setOppervlakte(toLong(shredder.nextValue()));
                verblijfsobject.setStatus(toString(shredder.nextValue()));
                verblijfsobject.setPunt(toPoint(shredder.nextValue()));
                session.save(verblijfsobject);
                log.info("\t(" + shredder.lastLineNumber() + ")" + verblijfsobject);
                
            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                
            }
            istream.close();
            
        // pand
            String pandfilename = fileprefix+ "pand" + filepostfix.substring(FILE_STARTS_WITH.length());            
            log.info("Processing: " + pandfilename);
            istream = new FileInputStream(pandfilename);
            shredder = new CSVParser(istream);
            shredder.setCommentStart("#;!");
            shredder.setEscapes("nrtf", "\n\r\t\f");
            while ((firstfield = shredder.nextValue()) != null) {
                //  pand
                //  gemeente_code, code, bouwjaar, status, grens
//                log.info("pand #" + shredder.lastLineNumber());
                Pand pand = new Pand();                
                pand.setGemeente(toGemeente(session, firstfield));
                pand.setCode(toLong(shredder.nextValue()));
                pand.setBouwjaar(toString(shredder.nextValue()));
                pand.setStatus(toString(shredder.nextValue()));
                pand.setGrens(toMultiPolygon(shredder.nextValue()));
                session.save(pand);
                log.info("\t(" + shredder.lastLineNumber() + ")" + pand);
                
            	insertCount++;
            	if(insertCount >= maxInsertCount) {
            		insertCount = 0;
                    //flush a batch of inserts and release memory:
                    log.info("hibernate flush");
                    session.flush();
                    session.clear();            		
            	}                
            }
            istream.close();
            
            return true;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }        
    }
    private void writeValue(FileWriter writer, Geometry value, boolean comma) throws IOException {
        WKTWriter wkt = new WKTWriter();
        if(value != null) {
            String field =  "\"" +  wkt.write(value) + "\"";
            writer.write(field);
        }
        if(comma) {
            writer.write(",");
        }
    }    
    private void writeValue(FileWriter writer, Long value, boolean comma) throws IOException {
        if(value != null) {        
            String field = value.toString();
            writer.write(field);
        }
        if(comma) {
            writer.write(",");
        }
    }    
    private void writeValue(FileWriter writer, String value,boolean comma) throws IOException {
        if(value != null) {        
            String field = "\"" + value.replace("\"", "\"\"") + "\"" ;
            writer.write(field);
        }
        if(comma) {
            writer.write(",");
        }
    }
    private void writeNewLine(FileWriter writer) throws IOException {
        writer.write("\n\r");        
    }
    @SuppressWarnings("unchecked")
	public boolean exportToFormat(Session session) {
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String timestamp = formatter.format(now);
        File dir = getPath();
        
        try {
            File gemeentefilename = new File(dir + "/gemeente-" +  timestamp + ".csv");
            FileWriter gemeentewriter = new FileWriter(gemeentefilename, false);
            File woonplaatsfilename = new File(dir + "/woonplaats-" +  timestamp + ".csv");
            FileWriter woonplaatswriter = new FileWriter(woonplaatsfilename, false);
            File openbareruimtefilename = new File(dir + "/openbareruimte-" +  timestamp + ".csv");
            FileWriter openbareruimtewriter = new FileWriter(openbareruimtefilename, false);
            File nummeraanduidingfilename = new File(dir + "/nummeraanduiding-" +  timestamp + ".csv");
            FileWriter nummeraanduidingwriter = new FileWriter(nummeraanduidingfilename, false);
            File verblijfsobjectfilename = new File(dir + "/verblijfsobject-" +  timestamp + ".csv");
            FileWriter verblijfsobjectwriter = new FileWriter(verblijfsobjectfilename, false);
            File pandfilename = new File(dir + "/pand-" +  timestamp + ".csv");
            FileWriter pandwriter = new FileWriter(pandfilename, false);
            
            
            log.info("export to:\n\t" + 
                    gemeentefilename.getAbsolutePath() + "\n\t" +
                    woonplaatsfilename.getAbsolutePath() + "\n\t" +              
                    nummeraanduidingfilename.getAbsolutePath() + "\n\t" +
                    verblijfsobjectfilename.getAbsolutePath() + "\n\t" +              
                    pandfilename.getAbsolutePath()                              
                    );            
            //  iterate over the data
            List<Gemeente> gemeenten = session.createQuery("from Gemeente").list();
            for (Gemeente gemeente : gemeenten) {
                //  gemeente
                //  code, naam, grens
                writeValue(gemeentewriter, gemeente.getCode(), true);
                writeValue(gemeentewriter, gemeente.getNaam(), true);
                writeValue(gemeentewriter, gemeente.getGrens(), false);
                writeNewLine(gemeentewriter);
                List<Woonplaats> woonplaatsen = gemeente.getWoonplaatsen();
                for (Woonplaats woonplaats : woonplaatsen) {
                    //  woonplaats
                    //  gemeente_code, code, naam, status, grens
                    writeValue(woonplaatswriter, woonplaats.getGemeente().getCode(), true);
                    writeValue(woonplaatswriter, woonplaats.getCode(), true);
                    writeValue(woonplaatswriter, woonplaats.getNaam(), true);
                    writeValue(woonplaatswriter, woonplaats.getStatus(), true);
                    writeValue(woonplaatswriter, woonplaats.getGrens(), false);
                    writeNewLine(woonplaatswriter);                    
                    List<Openbareruimte> openbareruimten = woonplaats.getOpenbareruimten();
                    for (Openbareruimte openbareruimte : openbareruimten) {
                        //  openbareruimte
                        //  woonplaats_code, code, naam, status, type, grens
                        writeValue(openbareruimtewriter, openbareruimte.getWoonplaats().getCode(), true);
                        writeValue(openbareruimtewriter, openbareruimte.getCode(), true);
                        writeValue(openbareruimtewriter, openbareruimte.getNaam(), true);
                        writeValue(openbareruimtewriter, openbareruimte.getStatus(), true);
                        writeValue(openbareruimtewriter, openbareruimte.getType(), true);
                        writeValue(openbareruimtewriter, openbareruimte.getGrens(), false);
                        writeNewLine(openbareruimtewriter);
                        List<Nummeraanduiding> nummeraanduidingen = openbareruimte.getNummeraanduidingen();
                        for (Nummeraanduiding nummeraanduiding : nummeraanduidingen) {
                            //  nummeraanduidingen
                            //  openbareruimte_code, code, huisnummer, huisletter, huisnummertoevoegign, postcode, status, type, punt
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getOpenbareruimte().getCode(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getCode(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getHuisnummer(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getHuisletter(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getHuisnummertoevoeging(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getPostcode(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getStatus(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getType(), true);
                            writeValue(nummeraanduidingwriter, nummeraanduiding.getPunt(), false);
                            writeNewLine(nummeraanduidingwriter);
                        }
                    }                    
                }
                List<Verblijfsobject> verblijfsobjecten = gemeente.getVerblijfsobjecten();
                for (Verblijfsobject verblijfsobject : verblijfsobjecten) {
                    //  verblijfsobject
                    //  gemeente_code, adres_code, code, oppervlakte, status, grens                    
                    writeValue(verblijfsobjectwriter, verblijfsobject.getGemeente().getCode(), true);
                    writeValue(verblijfsobjectwriter, verblijfsobject.getHoofdadres().getCode(), true);
                    writeValue(verblijfsobjectwriter, verblijfsobject.getCode(), true);
                    writeValue(verblijfsobjectwriter, verblijfsobject.getOppervlakte(), true);
                    writeValue(verblijfsobjectwriter, verblijfsobject.getStatus(), true);
                    writeValue(verblijfsobjectwriter, verblijfsobject.getPunt(), false);
                    writeNewLine(verblijfsobjectwriter);
                }
                List<Pand> panden = gemeente.getPanden();
                for (Pand pand : panden) {
                    //  pand
                    //  gemeente_code, code, bouwjaar, status, grens
                    writeValue(pandwriter, pand.getGemeente().getCode(), true);
                    writeValue(pandwriter, pand.getCode(), true);
                    writeValue(pandwriter, pand.getBouwjaar(), true);
                    writeValue(pandwriter, pand.getStatus(), true);
                    writeValue(pandwriter, pand.getGrens(), false);
                    writeNewLine(pandwriter);
                }
            }
            pandwriter.close();
            verblijfsobjectwriter.close();
            nummeraanduidingwriter.close();
            openbareruimtewriter.close();
            woonplaatswriter.close();
            gemeentewriter.close();
            log.info("export done!");
            return true;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }
    public void compareWithFormat(Session session) {
        throw new RuntimeException("not implemented");
    }    
}