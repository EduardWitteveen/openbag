/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nergens.bag.storage.pojo.util;

import javax.persistence.*;

/**
 *
 * @author eduard
 */
@Entity
@Table(name="UTIL_GEBRUIKSDOEL")
public class Gebruiksdoel  {
    // attributes
	/**
	 * http://bag.vrom.nl/bag_com/e8a25c6d62e561373145554b7979823b.php
	 * woonfunctie
	 * bijeenkomstfunctie
	 * celfunctie
	 * gezondheidszorgfunctie
	 * industriefunctie
	 * kantoorfunctie
	 * logiesfunctie
	 * onderwijsfunctie
	 * sportfunctie
	 * winkelfunctie
	 * overige gebruiksfunctie
	 * AN..80
	 */    
    @Id
    @Column(name="NAAM")	
    protected String naam;
    public String getNaam() {
        return naam; 
    }
    public void setNaam(String naam) { 
        this.naam = naam; 
    }
// tostring    
    @Override
    public String toString() {
        return "gebruiksdoel:" + naam;
    }
}