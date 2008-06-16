package org.nergens.bag.storage.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Polygon;
/**
 * http://bag.vrom.nl/bag_com/f8bf8e4cdf87d10b37ca25a20e027c4f.php	
 * Code	Gegevensnaam
 * 11.01	Identificatiecode openbare ruimte
 * 11.10	Naam openbare ruimte
 * ?11.11	Indicatie geconstateerde openbare ruimte
 * ?11.12	Datum begin geldigheid gegevens openbare ruimte
 * ?11.13	Datum einde geldigheid gegevens openbare ruimte
 * ?11.14	Aanduiding gegevens openbare ruimte in onderzoek
 * 11.15	Identificatiecode bijbehorende woonplaats
 * 11.16	Type openbare ruimte
 * ?11.17	Documentdatum mutatie openbare ruimte
 * ?11.18	Documentnummer mutatie openbare ruimte
 * 11.19	Status openbare ruimte
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("OPENBARERUIMTE")
@Table(name="DATA_OPENBARERUIMTE")
public class Openbareruimte extends BagAuthentiekObject implements Serializable {
	private static final long serialVersionUID = -8915684457507855214L;
// referencing to other tables    
    @ManyToOne
    @JoinColumn(name="WOONPLAATS_CODE")
    protected Woonplaats  woonplaats;
    public Woonplaats getWoonplaats() {
        return woonplaats;
    }
    public void setWoonplaats(Woonplaats woonplaats) { 
        this.woonplaats = woonplaats; 
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
     * http://bag.vrom.nl/bag_com/d7afb8e8b4923f160eb98923c0a6592b.php
     * Weg
     * Water
     * Spoorbaan
     * Terrein
     * Kunstwerk
     * Landschappelijk gebied
     * Administratief gebied
     * AN..40
     **/
    @Column(name="TYPE")
    protected String type;    
    public String getType() {
        return type; 
    }
    public void setType(String type) { 
        this.type = type; 
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
    		targetEntity=org.nergens.bag.storage.pojo.Nummeraanduiding.class,
    		cascade=CascadeType.REMOVE, 
    		mappedBy="openbareruimte"
    )
    @OrderBy("huisnummer")
    java.util.Set<Nummeraanduiding> nummeraanduidingen;
    public java.util.Set<Nummeraanduiding> getNummeraanduidingen() {
        return nummeraanduidingen;
    }
    public void setNummeraanduidingen(java.util.Set<Nummeraanduiding> nummeraanduidingen) {
        this.nummeraanduidingen = nummeraanduidingen;
    }       
// tostring    
    @Override
    public String toString() {
        return "\t\topenbareruimte #" + code + " :" + naam;
    }
}