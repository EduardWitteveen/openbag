package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import org.hibernate.annotations.Type;
/**
 *
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("GEMEENTE")
@Table(name="DATA_GEMEENTE")
public class Gemeente extends BagObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2281648105067142468L;
	// referencing to other tables
// attributes
//    long code;
    String naam;
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
    ArrayList<Woonplaats> woonplaatsen = new ArrayList<Woonplaats>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("naam")
    public ArrayList<Woonplaats> getWoonplaatsen() {
        return woonplaatsen;
    }
    public void setWoonplaatsen(ArrayList<Woonplaats> woonplaatsen) {
        this.woonplaatsen = woonplaatsen;
    }    
    ArrayList<Verblijfsobject> verblijfsobjecten = new ArrayList<Verblijfsobject>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("code")
    public ArrayList<Verblijfsobject> getVerblijfsobjecten() {
        return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(ArrayList<Verblijfsobject> verblijfsobjecten) {
        this.verblijfsobjecten = verblijfsobjecten;
    }    
    ArrayList<Pand> panden = new ArrayList<Pand>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("code")
    public ArrayList<Pand> getPanden() {
        return panden;
    }
    public void setPanden(ArrayList<Pand> panden) {
        this.panden = panden;
    }        
// tostring    
    @Override
    public String toString() {
        return "gemeente #" + code + " :" + naam;
    }
}