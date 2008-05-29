package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;
import java.util.Set;

import java.io.Serializable;
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
	private static final long serialVersionUID = 2281648105067142468L;
// referencing to other tables
	
// attributes        
    @Column(name="NAAM")
    protected String naam;
    public String getNaam() {
        return naam; 
    }
    public void setNaam(String naam) { 
        this.naam = naam; 
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
    		targetEntity=org.nergens.bag.storage.pojo.Woonplaats.class,
    		cascade=CascadeType.REMOVE, 
    		mappedBy="gemeente"
    )
    @OrderBy("naam")
    protected Set<Woonplaats> woonplaatsen;
    public Set<Woonplaats> getWoonplaatsen() {
        return woonplaatsen;
    }
    public void setWoonplaatsen(Set<Woonplaats> woonplaatsen) {
        this.woonplaatsen = woonplaatsen;
    }        
    @OneToMany(
    		targetEntity=org.nergens.bag.storage.pojo.Verblijfsobject.class,
    		cascade=CascadeType.REMOVE, 
    		mappedBy="gemeente"
    )
//    protected Set<Verblijfsobject> verblijfsobjecten;
//    public Set<Verblijfsobject> getVerblijfsobjecten() {
//        return verblijfsobjecten;
//    }
//    public void setVerblijfsobjecten(Set<Verblijfsobject> verblijfsobjecten) {
//        this.verblijfsobjecten = verblijfsobjecten;
//    }    
//    @OneToMany(
//    		targetEntity=org.nergens.bag.storage.pojo.Pand.class,
//    		cascade=CascadeType.REMOVE, 
//    		mappedBy="gemeente"
//    )
//    protected Set<Pand> panden;
//    public Set<Pand> getPanden() {
//        return panden;
//    }
//    public void setPanden(Set<Pand> panden) {
//        this.panden = panden;
//    }        
// tostring    
    @Override
    public String toString() {
        return "gemeente #" + code + " :" + naam;
    }
}