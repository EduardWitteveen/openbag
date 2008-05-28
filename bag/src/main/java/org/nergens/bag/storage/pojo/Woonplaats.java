package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

//import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Woonplaats extends BagObject implements Serializable{
// referencing to other tables
    Gemeente gemeente;
    @ManyToOne
    public Gemeente getGemeente() {
        return gemeente;
    }
    public void setGemeente(Gemeente gemeente) { 
        this.gemeente = gemeente; 
    }        
// attributes
//    long code;
    String naam;
    /**
     * Woonplaats aangewezen
     * Woonplaats ingetrokken
     */
    String status;
    Polygon grens;
//    @Id
//    @Column(name="CODE")
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
    ArrayList<Openbareruimte> openbareruimten = new ArrayList<Openbareruimte>();;
    @OneToMany(mappedBy="woonplaats")
    @OrderBy("naam")
    public ArrayList<Openbareruimte> getOpenbareruimten() {
        return openbareruimten;
    }
    public void setOpenbareruimten(ArrayList<Openbareruimte> openbareruimten) {
        this.openbareruimten = openbareruimten;
    }    
// tostring    
    @Override
    public String toString() {
        return "\twoonplaats #" + code + " :" + naam;
    }
}