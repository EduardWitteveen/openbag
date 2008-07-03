package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
public class Verblijfsobject extends Verblijfsplaats implements Serializable{
	private static final long serialVersionUID = 6171936434187699536L;
// attributes      
    /**
     * Alle natuurlijke getallen van 1 tot en met 999.999
     * N..6
    */
    @Column(name="OPPERVLAKTE")
    protected Integer oppervlakte;   
    public Integer getOppervlakte() {
        return oppervlakte; 
    }
    public void setOppervlakte(Integer oppervlakte) { 
        this.oppervlakte = oppervlakte; 
    }
    /**
     * NOT FROM BAG!!!
    */
    @Column(name="WOZOBJEKTNR")
    protected Long wozObjectNumber;   
    public Long getWozObjectNumber() {
        return wozObjectNumber; 
    }
    public void setWozObjectNumber(Long wozObjectNumber) { 
        this.wozObjectNumber = wozObjectNumber; 
    }        
    /**
     * STATUS:
     * Verblijfsobject gevormd
     * Niet gerealiseerd verblijfsobject
     * Verblijfsobject in gebruik (niet ingemeten)
     * Verblijfsobject in gebruik
     * Verblijfsobject ingetrokken
     * Verblijfsobject buiten gebruik
     * AN..80
     */    
    @Column(name="PUNT")
    @Type(type="org.hibernatespatial.GeometryUserType")
    protected Point punt;
    public Point getPunt() {
        return punt; 
    }
    public void setPunt(Point punt) { 
        this.punt = punt; 
    }
// used in other tables
    //http://opensource.atlassian.com/projects/hibernate/browse/ANN-6?rc=1
    @ManyToMany(    		
    		targetEntity=org.nergens.bag.storage.pojo.util.Gebruiksdoel.class,
    	    cascade=CascadeType.REMOVE
    )
    @JoinTable(
        name = "DATA_VO_GEBRUIKSDOELEIND", 
        joinColumns= @JoinColumn(name="VERBLIJFSOBJECT_CODE"),
        inverseJoinColumns=@JoinColumn(name="GEBRUIKSDOEL_NAAM")
    )
    protected Set<Gebruiksdoel> gebruiksdoeleinden = new HashSet<Gebruiksdoel>();
    public Set<Gebruiksdoel> getGebruiksdoeleinden() {
        return gebruiksdoeleinden;
    }
    public void setGebruiksdoeleinden(java.util.Set<Gebruiksdoel> gebruiksdoeleinden) { 
        this.gebruiksdoeleinden = gebruiksdoeleinden; 
    }
    // to make live easier
    public void addGebruiksdoeleind(Gebruiksdoel gebruiksdoel) {
        gebruiksdoeleinden.add(gebruiksdoel);
    }
    @ManyToMany(    		
    		targetEntity=org.nergens.bag.storage.pojo.Pand.class,
    	    cascade=CascadeType.REMOVE
    )
    @JoinTable(
        name = "DATA_VO_PAND", 
        joinColumns= @JoinColumn(name="VERBLIJFSOBJECT_CODE"),
        inverseJoinColumns=@JoinColumn(name="PAND_CODE")
    )
    protected Set<Pand> panden = new HashSet<Pand>();
    public Set<Pand> getPanden() {
        return panden;
    }    
    public void setPanden(java.util.Set<Pand> panden) {
        this.panden = panden;
    }
    // to make live easier
    public void addPand(Pand pand) {
        this.panden.add(pand);
    }    
// tostring    
    @Override
    public String toString() {
        return "\tverblijfsobject #" + code;
    }
}