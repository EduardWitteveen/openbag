package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
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
public class Pand extends BagAuthentiekObject implements Serializable{
	private static final long serialVersionUID = -6004787767635427969L;
// referencing to other tables    
    @ManyToOne
    @JoinColumn(name="GEMEENTE_CODE")
    protected Gemeente gemeente;
    public Gemeente getGemeente() {
        return gemeente;
    }
    public void setGemeente(Gemeente gemeente) { 
        this.gemeente = gemeente; 
    }
// attributes
    @Column(name="BOUWJAAR")
    Integer bouwjaar;    
    public Integer getBouwjaar() {
        return bouwjaar; 
    }
    public void setBouwjaar(Integer bouwjaar) { 
        this.bouwjaar = bouwjaar; 
    }
    @Column(name="GRENS")
    @Type(type="org.hibernatespatial.GeometryUserType")
    MultiPolygon grens;
    public MultiPolygon getGrens() {
        return grens; 
    }
    public void setGrens(MultiPolygon grens) { 
        this.grens = grens; 
    }
 // used in other tables
    @ManyToMany(
    		cascade = CascadeType.REMOVE,
            mappedBy = "panden",
            targetEntity = org.nergens.bag.storage.pojo.Verblijfsobject.class
    )    
	java.util.Set<Verblijfsobject> verblijfsobjecten;
    public java.util.Set<Verblijfsobject> getVerblijfsobjecten() {
    	return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(java.util.Set<Verblijfsobject> verblijfsobjecten) {
    	this.verblijfsobjecten = verblijfsobjecten;
    }    
// tostring    
    @Override
    public String toString() {
        return "\tpand #" + code;
    }
}