/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nergens.bag.transformations;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eduard Witteveen
 */
public interface Transformator {
    public String help();
    public void configure(List<String> args);
    public boolean retrieveFromFormat(Session session);
    public boolean exportToFormat(Session session);
    public void compareWithFormat(Session session);
}
