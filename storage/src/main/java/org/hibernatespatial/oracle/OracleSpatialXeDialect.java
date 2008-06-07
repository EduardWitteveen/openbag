package org.hibernatespatial.oracle;

import java.sql.Types;
import org.hibernatespatial.SpatialDialect;

public class OracleSpatialXeDialect extends OracleSpatial10gDialect implements SpatialDialect {
    private static String SQL_TYPE_NAME = "MDSYS.SDO_GEOMETRY";
    
    public OracleSpatialXeDialect() {
        super();
        registerColumnType(Types.STRUCT, SQL_TYPE_NAME);        
        SDOGeometryType.SQL_TYPE_NAME = SQL_TYPE_NAME;
    }
}