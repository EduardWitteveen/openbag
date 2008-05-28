package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

//import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import org.hibernate.annotations.Type;
/**
 * http://bag.vrom.nl/bag_com/73a2fa2db0ae59b7b025b577a51f5c1c.php
 * Code	Gegevensnaam
 * 11.02	Identificatiecode nummeraanduiding
 * 11.20	Huisnummer
 * ?11.21	Indicatie geconstateerde nummeraanduiding
 * 11.30	Huisletter
 * 11.40	Huisnummertoevoeging
 * 11.60	Postcode
 * 11.61	Identificatiecode bijbehorende woonplaats
 * ?11.62	Datum begin geldigheid nummeraanduidinggegevens
 * ?11.63	Datum einde geldigheid nummeraanduidinggegevens
 * ?11.64	Aanduiding nummeraanduidinggegevens in onderzoek
 * 11.65	Identificatiecode bijbehorende openbare ruimte
 * 11.66	Type adresseerbaar object
 * 11.67	Documentdatum mutatie nummeraanduiding
 * 11.68	Documentnummer mutatie nummeraanduiding
 * 11.69	Nummeraanduidingstatus
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("NUMMERAANDUIDING")
@Table(name="DATA_NUMMERAANDUIDING")
public class Nummeraanduiding extends BagAuthentiekObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5955003661599474524L;
	// referencing to other tables
    Openbareruimte openbareruimte;
    @ManyToOne(targetEntity=Openbareruimte.class)
    public Openbareruimte getOpenbareruimte() {
        return openbareruimte;
    }
    public void setOpenbareruimte(Openbareruimte openbareruimte) { 
        this.openbareruimte = openbareruimte; 
    }
    Woonplaats alternatieveWoonplaats;
    @ManyToOne
    public Woonplaats getAlternatieveWoonplaats() {
        return alternatieveWoonplaats;
    }
    public void setAlternatieveWoonplaats(Woonplaats alternatieveWoonplaats) { 
        this.alternatieveWoonplaats = alternatieveWoonplaats; 
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
    Long huisnummer;
    String huisletter;
    String huisnummertoevoeging;
    String postcode;
    /**
     * http://bag.vrom.nl/bag_com/4db79759b61f043aade4c98cc72dab01.php
     * Verblijfsobject
     * Standplaats
     * Ligplaats
     * AN..20
     */    
    String type;    
    /**
     * http://bag.vrom.nl/bag_com/c198ee23107145c3b531e2dd71f7372b.php
     * Naamgeving uitgegeven 
     * Naamgeving ingetrokken
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
    @Column(name="HUISNUMMER")
    public Long getHuisnummer() {
        return huisnummer; 
    }
    public void setHuisnummer(Long huisnummer) { 
        this.huisnummer = huisnummer; 
    }
    @Column(name="HUISLETTER")
    public String getHuisletter() {
        return huisletter; 
    }
    public void setHuisletter(String huisletter) { 
        this.huisletter = huisletter; 
    }
    @Column(name="HUISNUMMERTOEVOEGING")
    public String getHuisnummertoevoeging() {
        return huisnummertoevoeging; 
    }
    public void setHuisnummertoevoeging(String huisnummertoevoeging) { 
        this.huisnummertoevoeging = huisnummertoevoeging; 
    }
    @Column(name="POSTCODE")
    public String getPostcode() {
        return postcode; 
    }
    public void setPostcode(String postcode) { 
        this.postcode = postcode; 
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
    ArrayList<Verblijfsobject> verblijfsobjecten = new ArrayList<Verblijfsobject>();
//    @OneToMany(mappedBy="hoofdadres,nevenadressen")
    @OneToMany(mappedBy="hoofdadres")
    @OrderBy("code")
    public ArrayList<Verblijfsobject> getVerblijfsobjecten() {
        return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(ArrayList<Verblijfsobject> verblijfsobjecten) {
        this.verblijfsobjecten = verblijfsobjecten;
    }    
// tostring    
    @Override
    public String toString() {
        return "\t\t\tnummeraanduiding #" + code + " :" + huisnummer + " " + huisletter + " " + huisnummertoevoeging + " " + postcode;
    }
}