package org.nergens.bag.storage.util;

import java.sql.Types;
import org.hibernatespatial.SpatialDialect;
import org.hibernatespatial.oracle.OracleSpatial10gDialect;
import org.hibernatespatial.oracle.SDOGeometryType;

public class OracleSpatial9iDialect extends OracleSpatial10gDialect implements SpatialDialect {
    private static String SQL_TYPE_NAME = "MDSYS.SDO_GEOMETRY";
    
    public OracleSpatial9iDialect() {
        super();
        // override the registerColumnType of super class
        registerColumnType(Types.STRUCT, SQL_TYPE_NAME);        
        //  HACK: on code from subversion:
        //       http://www.hibernatespatial.org/svn/hibernate-spatial/tags/1.0-M1/
        //  follow patch is required:
        /*
            Index: SDOGeometryType.java
            ===================================================================
            --- SDOGeometryType.java	(revision 96)
            +++ SDOGeometryType.java	(working copy)
            @@ -75,7 +75,7 @@

                    private static final int[] geometryTypes = new int[] { Types.STRUCT };

            -	private static String SQL_TYPE_NAME = "SDO_GEOMETRY";
            +	public static String SQL_TYPE_NAME = "SDO_GEOMETRY";

                    @Override
                    public void nullSafeSet(PreparedStatement st, Object value, int index)
        */
        SDOGeometryType.SQL_TYPE_NAME = SQL_TYPE_NAME;
    }
}