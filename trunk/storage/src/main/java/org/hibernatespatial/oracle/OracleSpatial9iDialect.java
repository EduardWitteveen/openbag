package org.hibernatespatial.oracle;

import java.sql.Types;
import org.hibernatespatial.SpatialDialect;

public class OracleSpatial9iDialect extends OracleSpatial10gDialect implements SpatialDialect {
    private static String SQL_TYPE_NAME = "MDSYS.SDO_GEOMETRY";
    
    public OracleSpatial9iDialect() {
        super();
        registerColumnType(Types.STRUCT, SQL_TYPE_NAME);
        SDOGeometryType.SQL_TYPE_NAME = SQL_TYPE_NAME;
    }
}