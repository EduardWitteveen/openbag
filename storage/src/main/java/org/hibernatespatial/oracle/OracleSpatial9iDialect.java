package org.hibernatespatial.oracle;

import java.sql.Types;
import org.hibernatespatial.SpatialDialect;
import org.hibernatespatial.oracle.criterion.OracleSpatialAggregate;

public class OracleSpatial9iDialect extends OracleSpatial10gDialect implements SpatialDialect {
    private static String SQL_TYPE_NAME = "MDSYS.SDO_GEOMETRY";
    
    public OracleSpatial9iDialect() {
        super();
        registerColumnType(Types.STRUCT, SQL_TYPE_NAME);
        SDOGeometryType.SQL_TYPE_NAME = SQL_TYPE_NAME;
    }
    @Override
    public String getNativeSpatialAggregateSQL(String arg1, int aggregation) {

            StringBuffer aggregateFunction = new StringBuffer();

            SpatialAggregate sa = new SpatialAggregate(aggregation);

            if (sa._aggregateSyntax == null) {
                    throw new IllegalArgumentException("Unknown Spatial Aggregation ("
                                    + aggregation + ").");
            }

            aggregateFunction.append(sa._aggregateSyntax);

            aggregateFunction.append("(");
            if (sa.isAggregateType()) {
                    aggregateFunction.append("MDSYS.SDOAGGRTYPE(");
            }
            aggregateFunction.append(arg1);
            //TODO tolerance must by configurable
            if (sa.isAggregateType()) {
                    aggregateFunction.append(", ").append(.001).append(")");
            }
            aggregateFunction.append(")");

            return aggregateFunction.toString();
    }
	private class SpatialAggregate {

		boolean _aggregateType;

		String _aggregateSyntax;

		private final String SDO_AGGR = "SDO_AGGR_";

		private SpatialAggregate() {
		}

		private SpatialAggregate(int aggregation) {

			String specificAggrSyntax;

			switch (aggregation) {
			case org.hibernatespatial.SpatialAggregate.EXTENT:
				specificAggrSyntax = "MBR";
				_aggregateType = false;
				break;
			case OracleSpatialAggregate.LRS_CONCAT:
				specificAggrSyntax = "LRS_CONCAT";
				_aggregateType = true;
				break;
			case OracleSpatialAggregate.CENTROID:
				specificAggrSyntax = "CENTROID";
				_aggregateType = true;
				break;
			case OracleSpatialAggregate.CONCAT_LINES:
				specificAggrSyntax = "CONCAT_LINES";
				_aggregateType = false;
				break;
			case OracleSpatialAggregate.UNION:
				specificAggrSyntax = "UNION";
				_aggregateType = true;
				break;
			case OracleSpatialAggregate.CONVEXHULL:
				specificAggrSyntax = "CONVEXHULL";
				_aggregateType = true;
				break;				
			default:
				specificAggrSyntax = null;
				break;
			}
			if (specificAggrSyntax != null) {
				_aggregateSyntax = SDO_AGGR + specificAggrSyntax;
			}
		}
		public boolean isAggregateType() {
			return _aggregateType;
		}

		public String getAggregateSyntax() {
			return _aggregateSyntax;
		}

	}    
}