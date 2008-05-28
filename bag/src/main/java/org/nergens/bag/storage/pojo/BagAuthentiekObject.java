package org.nergens.bag.storage.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DATA_AUTHENTIEK")
public class BagAuthentiekObject extends BagObject implements Serializable {
	private static final long serialVersionUID = -59139009969185816L;
	
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
