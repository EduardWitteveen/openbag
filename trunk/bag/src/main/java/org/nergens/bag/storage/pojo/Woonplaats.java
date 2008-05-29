package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

//import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
/**
 * http://bag.vrom.nl/bag_com/61e18ac553a26ebf1d2cb98a50242348.php
 * Code	Gegevensnaam
 * 11.03	Woonplaatsidentificatie
 * 11.70	Woonplaatsnaam
 * 11.71	Woonplaatsgeometrie
 * ?11.72	Indicatie geconstateerde woonplaats
 * ?11.73	Datum begin geldigheid woonplaatsgegevens
 * ?11.74	Datum einde geldigheid woonplaatsgegevens
 * ?11.75	Aanduiding woonplaatsgegevens in onderzoek
 * ?11.77	Documentdatum mutatie woonplaats
 * ?11.78	Documentnummer mutatie woonplaats
 * 11.79	Woonplaatsstatus
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("WOONPLAATS")
@Table(name="DATA_WOONPLAATS")
public class Woonplaats extends BagAuthentiekObject implements Serializable{
	private static final long serialVersionUID = -6718944186372946432L;
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
    @Column(name="NAAM")
    protected String naam;    
    public String getNaam() {
        return naam; 
    }    
    public void setNaam(String naam) { 
        this.naam = naam; 
    }
    /**
     * Woonplaats aangewezen
     * Woonplaats ingetrokken
     */
    @Column(name="STATUS")
    protected String status;    
    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }
    @Column(name="GRENS")
    @Type(type="org.hibernatespatial.GeometryUserType")
    protected Polygon grens;
    public Polygon getGrens() {
        return grens; 
    }
    public void setGrens(Polygon grens) { 
        this.grens = grens; 
    }
 // used in other tables
    @OneToMany(
    		targetEntity=org.nergens.bag.storage.pojo.Openbareruimte.class,
    		cascade=CascadeType.REMOVE, 
    		mappedBy="woonplaats"
    )
    @OrderBy("naam")
    protected java.util.Set<Openbareruimte> openbareruimten;
    public java.util.Set<Openbareruimte> getOpenbareruimten() {
        return openbareruimten;
    }
    public void setOpenbareruimten(java.util.Set<Openbareruimte> openbareruimten) {
        this.openbareruimten = openbareruimten;
    }    
// tostring    
    @Override
    public String toString() {
        return "\twoonplaats #" + code + " :" + naam;
    }
}