package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
/**
 * @author Eduard Witteveen
 */
@Entity
@DiscriminatorValue("STANDPLAATS")
@PrimaryKeyJoinColumn(name="CODE")
@Table(name="DATA_STANDPLAATS")
public class Standplaats extends Verblijfsplaats implements Serializable{
    private static final long serialVersionUID = 10228928494159240L;
// attributes      
    @Column(name="GRENS")
    @Type(type="org.hibernatespatial.GeometryUserType")
    MultiPolygon grens;
    public MultiPolygon getGrens() {
        return grens; 
    }
    public void setGrens(MultiPolygon grens) { 
        this.grens = grens; 
    }
// used in other tables
// tostring    
    @Override
    public String toString() {
        return "\tstandplaats #" + code;
    }
}