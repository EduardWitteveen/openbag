package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.nergens.bag.storage.pojo.util.Gebruiksdoel;
/**
 * http://bag.vrom.nl/bag_com/8319873ede336f261b6053313db429ba.php
 * Code	Gegevensnaam
 * 56.01	Verblijfsobjectidentificatie
 * ?56.02	Indicatie geconstateerd verblijfsobject
 * 56.10	Aanduiding hoofdadres verblijfsobject
 * 56.11	Aanduiding nevenadressen verblijfsobject
 * 56.20	Verblijfsobjectgeometrie
 * 56.30	Gebruiksdoel verblijfsobject
 * 56.31	Oppervlakte verblijfsobject
 * 56.32	Verblijfsobjectstatus
 * 56.90	Pandrelatering
 * ?56.91	Datum begin geldigheid verblijfsobjectgegevens
 * ?56.92	Datum einde geldigheid verblijfsobjectgegevens
 * ?56.93	Aanduiding verblijfsobjectgegevens in onderzoek
 * ?56.97	Documentdatum mutatie verblijfsobject
 * ?56.98	Documentnummer mutatie verblijfsobject
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("VERBLIJFSOBJECT")
@PrimaryKeyJoinColumn(name="CODE")
@Table(name="DATA_VERBLIJFSOBJECT")
public class Verblijfsobject extends BagObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6171936434187699536L;
	// referencing to other tables
    Gemeente gemeente;
    @ManyToOne
    public Gemeente getGemeente() {
        return gemeente;
    }
    public void setGemeente(Gemeente gemeente) { 
        this.gemeente = gemeente; 
    }            
    Nummeraanduiding hoofdadres;
    @ManyToOne
    public Nummeraanduiding getHoofdadres() {
        return hoofdadres;
    }
    @Column(name="NUMMERAANDUIDING_CODE")
    public void setHoofdadres(Nummeraanduiding hoofdadres) { 
        this.hoofdadres = hoofdadres; 
    }        
    ArrayList<Nummeraanduiding> nevenadressen;
    @ManyToMany
    @JoinTable(
        name = "DATA_VO_NEVENADRES", 
        joinColumns=@JoinColumn(name="VERBLIJFSOBJECT_CODE"),
        inverseJoinColumns=@JoinColumn(name="NUMMERAANDUIDING_CODE")
    )
    public ArrayList<Nummeraanduiding> getNevenadressen() {
        return nevenadressen;
    }
    public void setNevenadressen(ArrayList<Nummeraanduiding> nevenadressen) { 
        this.nevenadressen = nevenadressen; 
    }        
    ArrayList<Gebruiksdoel> gebruiksdoeleinden = new ArrayList<Gebruiksdoel>();
    @ManyToMany
    @JoinTable(name = "DATA_VO_GEBRUIKSDOELEIND")
    //http://opensource.atlassian.com/projects/hibernate/browse/ANN-6?rc=1
    public ArrayList<Gebruiksdoel> getGebruiksdoeleinden() {
        return gebruiksdoeleinden;
    }
    public void setGebruiksdoeleinden(ArrayList<Gebruiksdoel> gebruiksdoeleinden) { 
        this.gebruiksdoeleinden = gebruiksdoeleinden; 
    }        
    ArrayList<Pand> panden = new ArrayList<Pand>();
    @ManyToMany(mappedBy="verblijfsobjecten")
//    @ManyToMany
    @OrderBy("code")
    public ArrayList<Pand> getPanden() {
        return panden;
    }
    public void setPanden(ArrayList<Pand> panden) {
        this.panden = panden;
    }    
    // attributes
    /**
     * Combinatie van het (viercijferig) subdomein 'gemeentecode' 
     * (volgens GBA tabel 33), het (tweecijferig) subdomein 'objecttypecode'
     * en een voor het betreffende objecttype binnen een gemeente uniek 
     * (tiencijferig) subdomein 'objectvolgnummer'.
     * AN16
     * 
     * 01 verblijfsobject
     * 02 ligplaats
     * 03 standplaats
     * 10 pand
     */    
//    long code;
    /**
     * Alle natuurlijke getallen van 1 tot en met 999.999
     * N..6
    */    
    Long oppervlakte;
    /**
     * Verblijfsobject gevormd
     * Niet gerealiseerd verblijfsobject
     * Verblijfsobject in gebruik (niet ingemeten)
     * Verblijfsobject in gebruik
     * Verblijfsobject ingetrokken
     * Verblijfsobject buiten gebruik
     * AN..80
     */    
    String status;       
    Point punt;
//    @Id
//    @Column(name="CODE")
//    public long getCode() {
//        return code; 
//    }
//    public void setCode(long code) { 
//        this.code = code; 
//    }
    @Column(name="OPPERVLAKTE")
    public Long getOppervlakte() {
        return oppervlakte; 
    }
    public void setOppervlakte(Long oppervlakte) { 
        this.oppervlakte = oppervlakte; 
    }    
    @Column(name="STATUS")
    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }    
    @Column(name="PUNT")
    @Type(type="org.hibernatespatial.GeometryUserType")
    public Point getPunt() {
        return punt; 
    }
    public void setPunt(Point punt) { 
        this.punt = punt; 
    }
//    @Override    
//    public Geometry getGeometry() {
//        return punt;
//    }
// used in other tables    
// tostring    
    @Override
    public String toString() {
        return "\tverblijfsobject #" + code;
    }
}