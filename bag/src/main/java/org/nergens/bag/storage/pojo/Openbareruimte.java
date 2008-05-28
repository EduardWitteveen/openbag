package org.nergens.bag.storage.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = -8915684457507855214L;
	// referencing to other tables
    Woonplaats woonplaats;
    @ManyToOne
    public Woonplaats getWoonplaats() {
        return woonplaats;
    }
    public void setWoonplaats(Woonplaats woonplaats) { 
        this.woonplaats = woonplaats; 
    }        
// attributes
/**
 * http://bag.vrom.nl/bag_com/32e4542e948d6a9d51d6c606bb70b88a.php
 * Uit de veld definitie:
 * Elke openbare ruimte waarvan gegevens zijn opgenomen in de adressenregistratie, 
 * wordt uniek aangeduid door middel van een identificatiecode. Deze 
 * identificatiecode bestaat uit de gemeentecode volgens GBA tabel 33 gevolgd 
 * door een codering voor de objecttypering en een voor de registrerende gemeente 
 * uniek volgnummer.
 * Uit de domain definitie:
 * Combinatie van het (viercijferig) subdomein 'gemeentecode' (volgens GBA tabel 33), 
 * het (tweecijferig) subdomein 'objecttypecode' en een voor het betreffende 
 * Waardenverzameling domein
 *  20 nummeraanduiding
 *  30 openbare ruimte
 *  40 woonplaats
 * objecttype binnen een gemeente uniek (tiencijferig) subdomein 'objectvolgnummer'.
 * AN16
 */        
//    long code;
    String naam;
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
    String type;  
    /**
     * http://bag.vrom.nl/bag_com/c198ee23107145c3b531e2dd71f7372b.php
     * Naamgeving uitgegeven
     * Naamgeving ingetrokken
     * AN..80
     */
    String status;
    Polygon grens;    
//    @Id
//    @Column(name="CODE", precision=16, scale=0)
//    public long getCode() {
//        return code; 
//    }
//    public void setCode(long code) { 
//        this.code = code; 
//    }    
    @Column(name="NAAM")
    public String getNaam() {
        return naam; 
    }
    public void setNaam(String naam) { 
        this.naam = naam; 
    }
    @Column(name="TYPE")
    public String getType() {
        return type; 
    }
    public void setType(String type) { 
        this.type = type; 
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
    public Polygon getGrens() {
        return grens; 
    }
    public void setGrens(Polygon grens) { 
        this.grens = grens; 
    } 
//    @Override    
//    public Geometry getGeometry() {
//        return grens;
//    }    
// used in other tables
    ArrayList<Nummeraanduiding> nummeraanduidingen = new ArrayList<Nummeraanduiding>();;
    @OneToMany(mappedBy="openbareruimte")
    @OrderBy("huisnummer")
    public ArrayList<Nummeraanduiding> getNummeraanduidingen() {
        return nummeraanduidingen;
    }
    public void setNummeraanduidingen(ArrayList<Nummeraanduiding> nummeraanduidingen) {
        this.nummeraanduidingen = nummeraanduidingen;
    }       
// tostring    
    @Override
    public String toString() {
        return "\t\topenbareruimte #" + code + " :" + naam;
    }
}