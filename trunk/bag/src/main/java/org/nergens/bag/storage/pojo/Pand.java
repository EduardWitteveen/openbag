package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import org.hibernate.annotations.Type;
/**
 * http://bag.vrom.nl/bag_com/8d71bd35f2b6b398d0b86868061681da.php
 * Code	Gegevensnaam
 * 55.01	Pandidentificatie
 * ?55.02	Indicatie geconstateerd pand	
 * 55.20	Pandgeometrie	
 * 55.30	Oorspronkelijk bouwjaar pand	
 * 55.31	Pandstatus	
 * ?55.91	Datum begin geldigheid pandgegevens	
 * ?55.92	Datum einde geldigheid pandgegevens	
 * ?55.93	Aanduiding pandgegevens in onderzoek	
 * ?55.97	Documentdatum mutatie pand	
 * ?55.98	Documentnummer mutatie pand
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("PAND")
@Table(name="DATA_PAND")
public class Pand extends BagObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6004787767635427969L;
	// referencing to other tables
    Gemeente gemeente;
    @ManyToOne
    public Gemeente getGemeente() {
        return gemeente;
    }
    public void setGemeente(Gemeente gemeente) { 
        this.gemeente = gemeente; 
    }    
    ArrayList<Verblijfsobject> verblijfsobjecten = new ArrayList<Verblijfsobject>();
//    @ManyToMany(mappedBy="panden")
    @ManyToMany()
    @OrderBy("code")
    @JoinTable(name = "DATA_VO_PAND")    
    public ArrayList<Verblijfsobject> getVerblijfsobjecten() {
        return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(ArrayList<Verblijfsobject> verblijfsobjecten) {
        this.verblijfsobjecten = verblijfsobjecten;
    }        
// attributes
//    long code;
    String bouwjaar;
    /**
     * Bouwvergunning verleend
     * Niet gerealiseerd pand
     * Bouw gestart
     * Pand in gebruik (niet ingemeten)
     * Pand in gebruik
     * Sloopvergunning verleend
     * Pand gesloopt
     * AN..80
     */
    String status;
    MultiPolygon grens;
//    @Id
//    @Column(name="CODE")
//    public long getCode() {
//        return code; 
//    }
//    public void setCode(long code) { 
//        this.code = code; 
//    }    
    @Column(name="BOUWJAAR")
    public String getBouwjaar() {
        return bouwjaar; 
    }
    public void setBouwjaar(String bouwjaar) { 
        this.bouwjaar = bouwjaar; 
    }       
    @Column(name="STATUS")
    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }    
    @Column(name="GRENS")
    @Type(type="org.hibernatespatial.GeometryUserType")
    public MultiPolygon getGrens() {
        return grens; 
    }
    public void setGrens(MultiPolygon grens) { 
        this.grens = grens; 
    }   
//    @Override
//    public Geometry getGeometry() {
//        return grens;
//    }
// tostring    
    @Override
    public String toString() {
        return "\tpand #" + code;
    }
}