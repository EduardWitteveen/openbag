package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Type;
/**
 *
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("GEMEENTE")
@Table(name="DATA_GEMEENTE")
public class Gemeente extends BagObject {
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
    List<Woonplaats> woonplaatsen = new ArrayList<Woonplaats>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("naam")
    public List<Woonplaats> getWoonplaatsen() {
        return woonplaatsen;
    }
    public void setWoonplaatsen(List<Woonplaats> woonplaatsen) {
        this.woonplaatsen = woonplaatsen;
    }    
    List<Verblijfsobject> verblijfsobjecten = new ArrayList<Verblijfsobject>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("code")
    public List<Verblijfsobject> getVerblijfsobjecten() {
        return verblijfsobjecten;
    }
    public void setVerblijfsobjecten(List<Verblijfsobject> verblijfsobjecten) {
        this.verblijfsobjecten = verblijfsobjecten;
    }    
    List<Pand> panden = new ArrayList<Pand>();
    @OneToMany(mappedBy="gemeente")
    @OrderBy("code")
    public List<Pand> getPanden() {
        return panden;
    }
    public void setPanden(List<Pand> panden) {
        this.panden = panden;
    }        
// tostring    
    @Override
    public String toString() {
        return "gemeente #" + code + " :" + naam;
    }
}