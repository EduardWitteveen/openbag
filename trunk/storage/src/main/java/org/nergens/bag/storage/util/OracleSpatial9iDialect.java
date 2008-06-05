package org.nergens.bag.storage.util;

import java.sql.Types;
import org.hibernatespatial.SpatialDialect;
import org.hibernatespatial.oracle.OracleSpatial10gDialect;

public class OracleSpatial9iDialect extends OracleSpatial10gDialect implements SpatialDialect {
//public class OracleSpatial9iDialect extends org.hibernatespatial.oracle.OracleSpatial10gDialect {
    public OracleSpatial9iDialect() {
        super();
        // JDBC type: 2002 = Types.STRUCT
        //  error:  SEVERE: could not complete schema update
        //          org.hibernate.MappingException: No Dialect mapping for JDBC type: 2002
        //  or:     type geometry is used, while MDSYS.SDO_GEOMETRY should be used!
        // 
        
        // override the registerColumnType of super class
        registerColumnType(Types.STRUCT, "MDSYS.SDO_GEOMETRY");        
    }
}