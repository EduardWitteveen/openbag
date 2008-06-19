This set of scripts support the extraction of a subset of GML, as per Annex H in the GML 3.1.0 specification. 
Below are the instructions from Paul Daisey to use these scripts to assemble gml4CRS. 
These can be used as a model for other subsets.


      Here are the Ant tasks:

<!-- for CRS WG -->

  <target name="crs.get.bases">
    <!-- list in crs.bases for wanted parameter in gmlSubset.xslt -->
    <java classname="com.icl.saxon.StyleSheet" fork="yes">
      <arg line="-o xslt/crs.bases base/coordinateReferenceSystems.xsd
xslt/getBases.xslt
schemas=coordinateReferenceSystems.xsd,coordinateSystems.xsd,coordinateOperations.xsd,datums.xsd,referenceSystems.xsd,"/>
      <classpath path="${saxon.home}saxon.jar"/>
    </java>
  </target>

  <target name="crs.prune.bases">
    <!-- list in crsPruned.bases for wanted parameter in gmlSubset.xslt -->
    <java classname="com.icl.saxon.StyleSheet" fork="yes">
      <arg line="-o xslt/crsPruned.bases xslt/gml.dep xslt/pruneBases.xslt schemas=coordinateReferenceSystems.xsd,coordinateSystems.xsd,coordinateOperations.xsd,datums.xsd,referenceSystems.xsd,

wanted=gml:AbstractSingleCRSType,gml:AbstractCRS,gml:AbstractCRSType,gml:AbstractSingleCRS,gml:OwnershipAttributeGroup,gml:AssociationAttributeGroup,gml:CompoundCRSType,gml:SingleCRSPropertyType,gml:CompoundCRS,gml:GeographicCRSType,gml:EllipsoidalCSPropertyType,gml:GeodeticDatumPropertyType,gml:GeographicCRS,gml:VerticalCRSType,gml:VerticalCSPropertyType,gml:VerticalDatumPropertyType,gml:VerticalCRS,gml:GeocentricCRSType,gml:GeocentricCSPropertyType,gml:CartesianCS,gml:SphericalCS,gml:GeocentricCRS,gml:AbstractGeneralDerivedCRSType,gml:ConversionPropertyType,gml:AbstractGeneralDerivedCRS,gml:ProjectedCRSType,gml:GeographicCRSPropertyType,gml:CartesianCSPropertyType,gml:ProjectedCRS,gml:DerivedCRSType,gml:CodeType,gml:CoordinateSystemPropertyType,gml:DerivedCRS,gml:EngineeringCRSType,gml:EngineeringDatumPropertyType,gml:EngineeringCRS,gml:ImageCRSType,gml:ImageCSPropertyType,gml:ImageDatumPropertyType,gml:AffineCS,gml:ImageCRS,gml:TemporalCRSType,gml:TimeCSPropertyType,gml:T!
 emporalDatumPropertyType,gml:TemporalCRS,gml:CoordinateSystemAxisType,gml:Definition,gml:DefinitionType,gml:CodeWithAuthorityType,gml:unitOfMeasure,gml:CoordinateSystemAxis,gml:AbstractCoordinateSystemType,gml:CoordinateSystemAxisPropertyType,gml:AggregationAttributeGroup,gml:AbstractCoordinateSystem,gml:EllipsoidalCSType,gml:EllipsoidalCS,gml:CartesianCSType,gml:VerticalCSType,gml:VerticalCS,gml:TimeCSType,gml:TimeCS,gml:UserDefinedCSType,gml:UserDefinedCS,gml:SphericalCSType,gml:PolarCSType,gml:PolarCS,gml:CylindricalCSType,gml:CylindricalCS,gml:AffineCSType,gml:LinearCSType,gml:LinearCS,gml:AbstractCoordinateOperationType,gml:operationVersion,gml:domainOfValidity,gml:scope,gml:sourceCRS,gml:targetCRS,gml:CRSPropertyType,gml:AbstractCoordinateOperation,gml:ConcatenatedOperationType,gml:SingleOperationPropertyType,gml:AbstractSingleOperationType,gml:AbstractSingleOperation,gml:PassThroughOperationType,gml:modifiedCoordinate,gml:OperationPropertyType,gml:AbstractOperationTy!
 pe,gml:usesMethod,gml:usesValue,gml:AbstractOperation,gml:ConversionTy
pe,gml:Conversion,gml:TransformationType,gml:id,gml:TransformationPropertyType,gml:Transformation,gml:AbstractGeneralParameterValueCompositionType,gml:AbstractGeneralParameterValue,gml:AbstractGeneralParameterValueType,gml:ParameterValueType,gml:MeasureType,gml:MeasureListType,gml:integerList,gml:valueOfParameter,gml:ParameterValueGroupType,gml:OperationParameterGroupPropertyType,gml:OperationMethodType,gml:AbstractGeneralOperationParameterPropertyType,gml:OperationMethodPropertyType,gml:OperationMethod,gml:AbstractGeneralOperationParameterType,gml:AbstractGeneralOperationParameter,gml:OperationParameterType,gml:OperationParameterPropertyType,gml:OperationParameter,gml:OperationParameterGroupType,gml:OperationParameterGroup,gml:AbstractDatumType,gml:CalDate,gml:AbstractDatum,gml:EngineeringDatumType,gml:EngineeringDatum,gml:ImageDatumType,gml:ImageDatum,gml:VerticalDatumType,gml:VerticalDatumTypeType,gml:VerticalDatum,gml:TemporalDatumType,gml:TemporalDatumBaseType,gml:TimeP!
 ositionType,gml:TemporalDatum,gml:GeodeticDatumType,gml:PrimeMeridianPropertyType,gml:EllipsoidPropertyType,gml:GeodeticDatum,gml:EllipsoidType,gml:LengthType,gml:ScaleType,gml:Ellipsoid,gml:PrimeMeridianType,gml:AngleType,gml:PrimeMeridian,gml:ExtentPropertyType,gml:AbstractReferenceSystemType,gml:AbstractReferenceSystem,"/>
      <classpath path="${saxon.home}saxon.jar"/>
    </java>
  </target>

  <target name="crs.subset"> <!-- depends="crs.get.bases gml.depends" -->
    <!-- make sure smil and x namespace prefixes are not used -->
    <java classname="com.icl.saxon.StyleSheet" fork="yes">
      <arg line="-o base/gml4crs.xsd xslt/gml.dep xslt/gmlSubset.xslt wanted=gml:OwnershipAttributeGroup,gml:AssociationAttributeGroup,gml:CodeType,gml:Definition,gml:DefinitionType,gml:unitOfMeasure,gml:AggregationAttributeGroup,gml:id,gml:MeasureType,gml:MeasureListType,gml:integerList,gml:CalDate,gml:TimePositionType,gml:LengthType,gml:ScaleType,gml:AngleType,gml:ExtentPropertyType,"/>
      <classpath path="${saxon.home}saxon.jar"/>
    </java>
  </target>

<!-- end for CRS WG -->
