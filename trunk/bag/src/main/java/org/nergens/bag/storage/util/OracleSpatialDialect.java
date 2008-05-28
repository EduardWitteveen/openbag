/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.nergens.bag.storage.util;

import java.sql.Types;
import org.hibernate.dialect.Oracle9Dialect;

/**
 *
 * @author Administrator
 */
public class OracleSpatialDialect extends Oracle9Dialect {
    /**
     * FIX THE: org.hibernate.tool.hbm2ddl.SchemaUpdate - could not complete schema update
     * org.hibernate.MappingException: No Dialect mapping for JDBC type: 2002
     */
    public OracleSpatialDialect() {
        super();
        // JDBC type: 2002 = Types.STRUCT
        registerColumnType( Types.STRUCT, "MDSYS.SDO_GEOMETRY");
    }
}