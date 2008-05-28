package org.nergens.bag.storage.pojo;

import javax.persistence.*;


/**
 * generate id: javascript:var m=Math;r=m.random;(r()<0.5?'-':'')+m.round(m.pow(10,17)*r())+'L'
 * @author Eduard Witteveen
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS )
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE )
// WHY DOESNT THIS WORK IN HIBERNATE? : http://opensource.atlassian.com/projects/hibernate/browse/ANN-562
// VERY NICE :D
@DiscriminatorColumn(name="BAGOBJECT_TYPE",length=20)   
@Table(name="DATA_OBJECT")
public abstract class BagObject {    
    @Id
    @Column(name="CODE")
    protected long code;
    public long getCode() {
        return code; 
    }
    public void setCode(long code) { 
        this.code = code; 
    }
}
