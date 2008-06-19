<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
	xmlns:xlink="http://www.w3.org/1999/xlink"> 
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<!-- =========================================================== 
	This stylesheet is designed to be used on gml.dep (produced from 
	gml.xsd by depends.xslt) to produce a specialized gmlSubset.xsd that 
	contains only the types and elements specified in the "wanted" parameter,
	and the types and elements on which they depend.  Note that the type and
	element items in the "wanted" parameter must include namespace prefixes, 
	and that they must be separated by commas, including a trailing comma after 
	the last item.  
	===========================================================-->
	<xsl:include href="utility.xslt"/>
	<xsl:param name="baseUri" select="document('../base/gml.xsd')"/>
	<!-- sample1 <xsl:param name="wanted">gml:featureProperty,gml:lineStringProperty,gml:polygonProperty,</xsl:param> -->
	<!-- sample2 <xsl:param name="wanted">gml:GeographicCRS,gml:_Coverage,gml:track,</xsl:param> -->
	<!-- sample3 <xsl:param name="wanted">gml:_FeatureCollection,gml:ItemStyleDescriptorType,gml:FeatureConstraintType,</xsl:param> -->
	<!-- original <xsl:param name="wanted">gml:AbstractObject,gml:abstractMetaDataProperty,gml:abstractAssociation,gml:AssociationType,gml:members,gml:Collection,gml:curveProperty,gml:LineString,gml:LinearRing,gml:exterior,gml:interior,gml:Polygon,gml:surfaceMember,gml:surfaceProperty,gml:MultiSurface,gml:multiSurfaceProperty,gml:SurfaceInterpolationType,gml:Node,gml:directedNode,gml:topoPrimitiveMembers,gml:Edge,gml:directedEdge,gml:isolated,gml:container,gml:Face,gml:directedFace,gml:TopoComplex,gml:superComplex,gml:subComplex,gml:maximalComplex,gml:IsolatedProperty,gml:AbstractFeature,gml:featureProperty,gml:featureMembers,gml:AbstractFeatureCollection,gml:featureMember,gml:featureMembers,gml:AbstractFeatureCollection,gml:Dictionary,gml:topoCurveProperty,gml:topoSurfaceProperty,</xsl:param> -->
<!-- 2004-09-10 from CensusTigerAll.xsd 	<xsl:param name="wanted">gml:id,gml:AbstractMetaDataPropertyType,gml:abstractMetaDataProperty,gml:AbstractObject,gml:AbstractMemberType,gml:AbstractGMLType,gml:AggregationAttributeGroup,gml:AssociationAttributeGroup,gml:CurvePropertyType,gml:LineString,gml:OwnershipAttributeGroup,gml:curveProperty,gml:AbstractRingPropertyType,gml:LinearRing,gml:exterior,gml:interior,gml:PolygonType,gml:Polygon,gml:SurfacePropertyType,gml:surfaceMember,gml:surfaceProperty,gml:MultiSurfaceType,gml:metaDataProperty,gml:description,gml:descriptionReference,gml:name,gml:surfaceMembers,gml:MultiSurface,gml:MultiSurfacePropertyType,gml:multiSurfaceProperty,gml:NodeType,gml:pointProperty,gml:Node,gml:DirectedNodePropertyType,gml:directedNode,gml:TopoPrimitiveArrayAssociationType,gml:topoPrimitiveMembers,gml:EdgeType,gml:Edge,gml:DirectedEdgePropertyType,gml:directedEdge,gml:TopoCurveType,gml:TopoCurve,gml:TopoCurvePropertyType,gml:topoCurveProperty,gml:IsolatedPropertyType,gml:isolated,gml:ContainerPropertyType,gml:container,gml:FaceType,gml:Face,gml:DirectedFacePropertyType,gml:directedFace,gml:TopoSurfaceType,gml:TopoSurface,gml:TopoSurfacePropertyType,gml:topoSurfaceProperty,gml:TopoComplexType,gml:topoPrimitiveMember,gml:TopoPrimitiveMemberType,gml:TopoComplex,gml:TopoComplexMemberType,gml:superComplex,gml:subComplex,gml:maximalComplex,gml:AbstractFeatureType,gml:boundedBy,gml:location,gml:AbstractFeatureMemberType,gml:AbstractFeature,
</xsl:param> -->
	<!-- from census/CensusTigerFlatAnXDB.xsd -->
	<xsl:param name="wanted">gml:id,gml:OwnershipAttributeGroup,gml:AggregationAttributeGroup,gml:AssociationAttributeGroup,gml:LineString,gml:LinearRing,gml:abstractMetaDataProperty,gml:pointProperty,gml:SignType,gml:description,gml:descriptionReference,gml:name,gml:boundedBy,</xsl:param><!-- be sure it does not contain any newlines!!! -->
	<xsl:template match="/">
		<xsl:variable name="wantedList">
			<xsl:call-template name="getWantedList">
				<xsl:with-param name="list" select="$wanted"/>
				<xsl:with-param name="seen">-</xsl:with-param>
				<xsl:with-param name="from">BEGIN</xsl:with-param>
				<xsl:with-param name="depth">0</xsl:with-param>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="vers"  select="//depends/@version"/>	
		<schema targetNamespace="http://www.opengis.net/gml" xmlns="http://www.w3.org/2001/XMLSchema" xmlns:sch="http://www.ascc.net/xml/schematron" xmlns:gml="http://www.opengis.net/gml" xmlns:xlink="http://www.w3.org/1999/xlink" elementFormDefault="qualified" version="{$vers}"><!-- xmlns:smil20="http://www.w3.org/2001/SMIL20/" xmlns:smil20lang="http://www.w3.org/2001/SMIL20/Language"  xmlns:x="http://www.w3.org/XML/1998/namespace" -->
			<annotation>
				<documentation>GML Subset schema for: <xsl:value-of select="$wanted"/> including used  types: <xsl:value-of select="$wantedList"/>  written by gmlSubset.xslt. </documentation>
			</annotation>
			<xsl:if test="contains($wantedList,'xlink:')">
				<import namespace="http://www.w3.org/1999/xlink" schemaLocation="../xlink/xlinks.xsd"/>
			</xsl:if>
			<xsl:if test="contains($wantedList,'smil20:')">
				<import namespace="http://www.w3.org/2001/SMIL20/" schemaLocation="../../smil/smil20.xsd"/>
			</xsl:if>
			<xsl:if test="contains($wantedList,'smil20lang:')">
				<import namespace="http://www.w3.org/2001/SMIL20/Language" schemaLocation="../../smil/smil20-language.xsd"/>
			</xsl:if>
			<xsl:call-template name="writeWantedList">
				<xsl:with-param name="list" select="$wantedList"/>
			</xsl:call-template>
		</schema>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="getDocName">
		<xsl:param name="wanted"/>
		<xsl:for-each select="//depends/def[@name=$wanted]">
			<xsl:value-of select="@doc"/>
		</xsl:for-each>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="getUses">
		<xsl:param name="wanted"/>
		<!-- <xsl:message>GET USES WANTED <xsl:value-of select="$wanted"/></xsl:message> -->
		<xsl:for-each select="//depends/def[@name=$wanted]">
			<xsl:for-each select="uses">
				<!-- <xsl:message>WANTED <xsl:value-of select="$wanted"/> USES <xsl:value-of select="@name"/></xsl:message> -->
				<xsl:value-of select="@name"/>
				<xsl:text>,</xsl:text>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="writeWanted">
		<xsl:param name="wanted"/>
		<xsl:choose>
			<xsl:when test="contains($wanted,'xlink:') or contains($wanted,'wfs:') or contains($wanted,'smil20')"/>
			<xsl:otherwise>
				<xsl:variable name="docName">
					<xsl:call-template name="getDocName">
						<xsl:with-param name="wanted" select="$wanted"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:variable name="localName">
					<xsl:call-template name="removePrefix">
						<xsl:with-param name="name" select="$wanted"/>
						<xsl:with-param name="pre">:</xsl:with-param>
					</xsl:call-template>
				</xsl:variable>
				<!-- <xsl:message>localname <xsl:value-of select="$localName"/></xsl:message> -->
				<xsl:call-template name="Separator"/>
				<xsl:for-each select="document($docName,$baseUri)">
					<xsl:for-each select="//xsd:schema/*[@name = $localName]"><xsl:copy-of select="."/></xsl:for-each>
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="writeWantedList">
		<xsl:param name="list"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, ',')"/>
			<xsl:variable name="rest" select="substring-after($list, ',')"/>
			<xsl:call-template name="writeWanted">
				<xsl:with-param name="wanted" select="$first"/>
			</xsl:call-template>
			<xsl:if test="contains($rest,',')">
				<xsl:call-template name="writeWantedList">
					<xsl:with-param name="list" select="$rest"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="getWantedList">
		<xsl:param name="list"/>
		<xsl:param name="seen"/>
		<xsl:param name="from"/>
		<xsl:param name="depth"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, ',')"/>
			<xsl:variable name="firstSep" select="concat($first,',')"/>
			<xsl:variable name="rest" select="substring-after($list, ',')"/>
			<!-- <xsl:message>FIRST <xsl:value-of select="$first"/> SEP <xsl:value-of select="$firstSep"/> SEEN<xsl:value-of select="$seen"/>SEEN</xsl:message> -->
			<xsl:choose>
				<xsl:when test=" contains($seen,$firstSep) ">
				<!--	<xsl:message>CONTAINS <xsl:value-of select="$seen"/> SEP <xsl:value-of select="$firstSep"/> </xsl:message> -->
					<xsl:call-template name="getWantedList">
						<xsl:with-param name="list" select="$rest"/>
						<xsl:with-param name="seen" select="$seen"/>
						<xsl:with-param name="from">REST</xsl:with-param>
						<xsl:with-param name="depth" select="$depth + 1"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
				<!-- 	<xsl:message>OTHER</xsl:message> -->
					<xsl:value-of select="$firstSep"/>
					<xsl:variable name="usesList">
						<xsl:call-template name="getUses">
							<xsl:with-param name="wanted" select="$first"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:variable name="toDo" select="concat($usesList,$rest)"/>
					<xsl:variable name="nowSeen" select="concat($seen,$firstSep)"/>
					<xsl:call-template name="getWantedList">
						<xsl:with-param name="list" select="$toDo"/>
						<xsl:with-param name="seen" select="$nowSeen"/>
						<xsl:with-param name="from">USES</xsl:with-param>
						<xsl:with-param name="depth" select="$depth + 1"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
</xsl:stylesheet>
