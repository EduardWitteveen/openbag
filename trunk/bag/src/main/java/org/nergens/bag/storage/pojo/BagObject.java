package org.nergens.bag.storage.pojo;

import com.vividsolutions.jts.geom.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 *
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
    //public abstract Geometry getGeometry();
    Date begingeldigheid;
    @Column(name="BEGINGELDIGHEID")
    public Date getBeginGeldigheid() {
        return begingeldigheid; 
    }
    public void setBeginGeldigheid(Date begingeldigheid) { 
        this.begingeldigheid = begingeldigheid; 
    }
    Date eindegeldigheid;
    @Column(name="EINDEGELDIGHEID")
    public Date getEindeGeldigheid() {
        return eindegeldigheid; 
    }
    public void setEindeGeldigheid(Date eindegeldigheid) { 
        this.eindegeldigheid = eindegeldigheid; 
    }
    Boolean inonderzoek = false;
    @Column(name="INONDERZOEK")
    public Boolean getInOnderzoek() {
        return inonderzoek; 
    }
    public void setInOnderzoek(Boolean inonderzoek) { 
        this.inonderzoek = inonderzoek; 
    }        
    Date documentdatum;
    @Column(name="DOCUMENTDATUM")
    public Date getDocumentDatum() {
        return documentdatum; 
    }
    public void setDocumentDatum(Date documentdatum) { 
        this.documentdatum = documentdatum; 
    }    
    String documentnummer;
    @Column(name="DOCUMENTNUMMER")
    public String getDocumentNummer() {
        return documentnummer; 
    }
    public void setDocumentNummer(String documentnummer) { 
        this.documentnummer = documentnummer; 
    }    
}
