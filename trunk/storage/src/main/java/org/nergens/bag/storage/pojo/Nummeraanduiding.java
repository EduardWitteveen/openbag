package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

//import java.util.List;
import java.io.Serializable;
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
	private static final long serialVersionUID = -5955003661599474524L;
// referencing to other tables
    @ManyToOne
    @JoinColumn(name="OPENBARERUIMTE_CODE")
    protected Openbareruimte openbareruimte;
    public Openbareruimte getOpenbareruimte() {
        return openbareruimte;
    }
    public void setOpenbareruimte(Openbareruimte openbareruimte) { 
        this.openbareruimte = openbareruimte; 
    } 	    
    @ManyToOne
    @JoinColumn(name="ALT_WOONPLAATS_CODE")
    protected Woonplaats alternatieveWoonplaats;
    public Woonplaats getAlternatieveWoonplaats() {
        return alternatieveWoonplaats;
    }
    public void setAlternatieveWoonplaats(Woonplaats alternatieveWoonplaats) { 
        this.alternatieveWoonplaats = alternatieveWoonplaats; 
    }
// attributes    
    @Column(name="HUISNUMMER")
    protected Long huisnummer;    
    public Long getHuisnummer() {
        return huisnummer; 
    }
    public void setHuisnummer(Long huisnummer) { 
        this.huisnummer = huisnummer; 
    }
    @Column(name="HUISLETTER")
    protected String huisletter;
    public String getHuisletter() {
        return huisletter; 
    }
    public void setHuisletter(String huisletter) { 
        this.huisletter = huisletter; 
    }
    @Column(name="HUISNUMMERTOEVOEGING")
    protected String huisnummertoevoeging;
    public String getHuisnummertoevoeging() {
        return huisnummertoevoeging; 
    }
    public void setHuisnummertoevoeging(String huisnummertoevoeging) { 
        this.huisnummertoevoeging = huisnummertoevoeging; 
    }
    @Column(name="POSTCODE")
    protected String postcode;
    public String getPostcode() {
        return postcode; 
    }
    public void setPostcode(String postcode) { 
        this.postcode = postcode; 
    }
    /**
     * http://bag.vrom.nl/bag_com/4db79759b61f043aade4c98cc72dab01.php
     * Verblijfsobject
     * Standplaats
     * Ligplaats
     * AN..20
     */
    @Column(name="TYPE")    
    String type;            
    public String getType() {
        return type; 
    }
    public void setType(String type) { 
        this.type = type; 
    }
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
    @OneToMany(
    		targetEntity=org.nergens.bag.storage.pojo.Verblijfsplaats.class,
    		cascade=CascadeType.REMOVE, 
    		mappedBy="hoofdadres"
    )
    @OrderBy("code")
    protected java.util.Set<Verblijfsobject> verblijfsobjecten;
    public java.util.Set<Verblijfsobject> getVerblijfsobjecten() {
        return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(java.util.Set<Verblijfsobject> verblijfsobjecten) {
        this.verblijfsobjecten = verblijfsobjecten;
    }
// tostring    
    @Override
    public String toString() {
        return "\t\t\tnummeraanduiding #" + code + " :" + huisnummer + " " + huisletter + " " + huisnummertoevoeging + " " + postcode;
    }
}