package org.nergens.bag.storage.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("VERBLIJFSPLAATS")
@PrimaryKeyJoinColumn(name="CODE")
@Table(name="DATA_VERBLIJFSPLAATS")
public class Verblijfsplaats extends BagAuthentiekObject implements Serializable{
	private static final long serialVersionUID = -1533562097481767L;
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
    @ManyToOne
    @JoinColumn(name="NUMMERAANDUIDING_CODE")
    protected Nummeraanduiding hoofdadres;
    public Nummeraanduiding getHoofdadres() {
        return hoofdadres;
    }
    public void setHoofdadres(Nummeraanduiding hoofdadres) { 
        this.hoofdadres = hoofdadres; 
    }
// used in other tables
    @ManyToMany(
    		targetEntity=org.nergens.bag.storage.pojo.Nummeraanduiding.class,
    		cascade=CascadeType.REMOVE    		
    )
    @JoinTable(
        name = "DATA_VO_NEVENADRES", 
        joinColumns= @JoinColumn(
        		name="VERBLIJFSOBJECT_CODE"
        ),
        inverseJoinColumns=@JoinColumn(
        		name="NUMMERAANDUIDING_CODE"
        )
    )
    protected java.util.Set<Nummeraanduiding> nevenadressen;
    public java.util.Set<Nummeraanduiding> getNevenadressen() {
        return nevenadressen;
    }
    public void setNevenadressen(java.util.Set<Nummeraanduiding> nevenadressen) { 
        this.nevenadressen = nevenadressen; 
    }
    //http://opensource.atlassian.com/projects/hibernate/browse/ANN-6?rc=1
    @ManyToMany(    		
    		targetEntity=org.nergens.bag.storage.pojo.util.Gebruiksdoel.class,
    	    cascade=CascadeType.REMOVE
    )
// tostring    
    @Override
    public String toString() {
        return "\tverblijfsplaats #" + code;
    }
}