package org.nergens.bag.storage.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AUTHENTIEK")
@Table(name="DATA_AUTHENTIEK")
public class BagAuthentiekObject extends BagObject implements Serializable {
	private static final long serialVersionUID = -59139009969185816L;
// referencing to other tables            
 // attributes    
    @Column(name="BEGINGELDIGHEID")
    protected Date begingeldigheid;
    public Date getBeginGeldigheid() {
        return begingeldigheid; 
    }
    public void setBeginGeldigheid(Date begingeldigheid) { 
        this.begingeldigheid = begingeldigheid; 
    }    
    @Column(name="EINDEGELDIGHEID")
    protected Date eindegeldigheid;
    public Date getEindeGeldigheid() {
        return eindegeldigheid; 
    }
    public void setEindeGeldigheid(Date eindegeldigheid) { 
        this.eindegeldigheid = eindegeldigheid; 
    }    
    @Column(name="INONDERZOEK")
    protected Boolean inonderzoek = false;
    public Boolean getInOnderzoek() {
        return inonderzoek; 
    }
    public void setInOnderzoek(Boolean inonderzoek) { 
        this.inonderzoek = inonderzoek; 
    }
    /**
     * 
     * 
     * http://bag.vrom.nl/bag_com/c198ee23107145c3b531e2dd71f7372b.php
     * Naamgeving uitgegeven
     * Naamgeving ingetrokken
     * AN..80
     * 
     * http://bag.vrom.nl/bag_com/c198ee23107145c3b531e2dd71f7372b.php
     * Naamgeving uitgegeven 
     * Naamgeving ingetrokken
     * 
     * Verblijfsobject gevormd
     * Niet gerealiseerd verblijfsobject
     * Verblijfsobject in gebruik (niet ingemeten)
     * Verblijfsobject in gebruik
     * Verblijfsobject ingetrokken
     * Verblijfsobject buiten gebruik
     * AN..80
     *      
     * Bouwvergunning verleend
     * Niet gerealiseerd pand
     * Bouw gestart
     * Pand in gebruik (niet ingemeten)
     * Pand in gebruik
     * Sloopvergunning verleend
     * Pand gesloopt
     * AN..80
     * 
     */
    @Column(name="STATUS")    
    protected String status;    
    public String getStatus() {
        return status; 
    }
    public void setStatus(String status) { 
        this.status = status; 
    }    
    @Column(name="DOCUMENTDATUM")
    protected Date documentdatum;    
    public Date getDocumentDatum() {
        return documentdatum; 
    }
    public void setDocumentDatum(Date documentdatum) { 
        this.documentdatum = documentdatum; 
    }
    @Column(name="DOCUMENTNUMMER")
    protected String documentnummer;    
    public String getDocumentNummer() {
        return documentnummer; 
    }
    public void setDocumentNummer(String documentnummer) { 
        this.documentnummer = documentnummer; 
    }
 // used in other tables    
}