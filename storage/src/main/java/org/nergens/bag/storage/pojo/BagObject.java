package org.nergens.bag.storage.pojo;

import javax.persistence.*;


/**
 * generate id: javascript:var m=Math;r=m.random;(r()<0.5?'-':'')+m.round(m.pow(10,17)*r())+'L'
 * 
 * WHY DOESNT THIS WORK IN HIBERNATE? : http://opensource.atlassian.com/projects/hibernate/browse/ANN-562
 * 
 * CACHING: http://www.hibernate.org/hib_docs/reference/en/html/batch.html
 * @author Eduard Witteveen
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="BAGOBJECT_TYPE",length=20)   
@DiscriminatorValue("OBJECT")
@Table(name="DATA_OBJECT")
public abstract class BagObject {
	/**
	 * http://bag.vrom.nl/bag_com/32e4542e948d6a9d51d6c606bb70b88a.php
	 * Uit de veld definitie:
	 * Elke openbare ruimte waarvan gegevens zijn opgenomen in de adressenregistratie, 
	 * wordt uniek aangeduid door middel van een identificatiecode. Deze 
	 * identificatiecode bestaat uit de gemeentecode volgens GBA tabel 33 gevolgd 
	 * door een codering voor de objecttypering en een voor de registrerende gemeente 
	 * uniek volgnummer.
	 * Uit de domain definitie:
	 * Combinatie van het (viercijferig) subdomein 'gemeentecode' (volgens GBA tabel 33), 
	 * het (tweecijferig) subdomein 'objecttypecode' en een voor het betreffende 
	 * Waardenverzameling domein
	 *  20 nummeraanduiding
	 *  30 openbare ruimte
	 *  40 woonplaats
	 * objecttype binnen een gemeente uniek (tiencijferig) subdomein 'objectvolgnummer'.
	 * AN16
	 */
    /**
     * Combinatie van het (viercijferig) subdomein 'gemeentecode' 
     * (volgens GBA tabel 33), het (tweecijferig) subdomein 'objecttypecode'
     * en een voor het betreffende objecttype binnen een gemeente uniek 
     * (tiencijferig) subdomein 'objectvolgnummer'.
     * AN16
     * 
     * 01 verblijfsobject
     * 02 ligplaats
     * 03 standplaats
     * 10 pand
     */	
    @Id
    @Column(name="CODE")
    protected long code;
    public long getCode() {
        return code; 
    }
    public void setCode(long code) { 
        this.code = code; 
    }
    @Column(name="BAGOBJECT")
    protected boolean bagobject;
    public boolean getBagObject() {
        return bagobject; 
    }
    public void setBagObject(boolean bagobject) {    
        this.bagobject = bagobject; 
    }    
}