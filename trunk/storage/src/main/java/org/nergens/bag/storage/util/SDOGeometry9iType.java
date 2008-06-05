package org.nergens.bag.storage.util;

import com.vividsolutions.jts.geom.Geometry;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernatespatial.oracle.SDOGeometryType;

public class SDOGeometry9iType extends SDOGeometryType {
    private static String SQL_TYPE_NAME = "MDSYS.SDO_GEOMETRY";
    
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, sqlTypes()[0], SQL_TYPE_NAME);
        } 
        else {
            Geometry jtsGeom = (Geometry) value;
            // declared private in http://www.hibernatespatial.org/svn/hibernate-spatial/tags/1.0-M1/
            Object dbGeom = conv2DBGeometry(jtsGeom, findOracleConnection(st.getConnection()));
            st.setObject(index, dbGeom);
        }
    }    
}