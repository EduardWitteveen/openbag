package org.nergens.bag.storage.pojo.util;

import javax.persistence.*;
import org.nergens.bag.storage.pojo.BagObject;

/**
 * @author eduard
 */
@Entity
@Table(name="UTIL_TERUGMELDING")
public class Terugmelding  {
    // attributes
    // referencing to other tables
    @Id
    protected long id;
    public Long getId() { return id; }
    
    @ManyToOne
    @JoinColumn(name="BAGOBJECT_CODE")
    protected BagObject  bagobject;
    public BagObject getBagObject() {
        return bagobject;
    }
    public void setBagObject(BagObject bagobject) { 
        this.bagobject  = bagobject;
    }
    @Column(name="USERNAME")	
    protected String username;
    public String getUsername() {
        return username; 
    }
    public void setUsername(String username) { 
        this.username = username; 
    }
    @Column(name="MELDING")	
    protected String melding;
    public String getMelding() {
        return melding; 
    }
    public void setMelding(String melding) { 
        this.melding = melding; 
    }
// tostring    
    @Override
    public String toString() {
        return "melding:" + melding;
    }
}