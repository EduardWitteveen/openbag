<?xml version="1.0" encoding="UTF-8"?> 
<!-- getBases.xslt 
	This stylesheet generates the value of the "wanted" parameter in gmlSubset.xslt
	Set the "schemas" parameter to contain a comma separated and terminated list 
	of the GML application schemas for which you want to identifiy GML
	definition dependencies.
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsd="http://www.w3.org/2001/XMLSchema" >
	<xsl:output method="text" indent="no"/>
	<xsl:strip-space  elements="*"/>
	<!-- NEWLINE = &#xA; -->
	<xsl:include href="utility.xslt"/>
	<xsl:param name="schemas">CensusTigerMetadata.xsd,CensusTigerBasicTypes.xsd,CensusTigerSpatialTypes.xsd,CensusTiger123.xsd, CensusTiger.xsd,</xsl:param>
	<!-- =========================================================== -->
	<xsl:template match="/">
		<xsl:call-template name="getUniqueBaseList">
			<xsl:with-param name="schemaList" select="$schemas"/>
		</xsl:call-template>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:element" >
		<xsl:call-template name="type"/>
		<xsl:call-template name="ref"/>
		<xsl:call-template name="sub"/>
		<xsl:apply-templates/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:attribute" >
		<xsl:call-template name="ref"/>
		<xsl:call-template name="type"/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:attributeGroup">
		<xsl:call-template name="ref"/>
		<xsl:apply-templates/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:restriction" >
		<xsl:call-template name="base"/>
		<xsl:apply-templates/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:extension" >
		<xsl:call-template name="base"/>
		<xsl:apply-templates/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="//xsd:annotation"></xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="ref">
		<xsl:variable name="value" select="@ref"/>
		<xsl:call-template name="attVal">
			<xsl:with-param name="value" select="$value"/>
		</xsl:call-template>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="type">
		<xsl:variable name="value" select="@type"/>
		<xsl:call-template name="attVal">
			<xsl:with-param name="value" select="$value"/>
		</xsl:call-template>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="sub">
		<xsl:variable name="value" select="@substitutionGroup"/>
		<xsl:call-template name="attVal">
			<xsl:with-param name="value" select="$value"/>
		</xsl:call-template>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="base">
		<xsl:variable name="value" select="@base"/>
		<xsl:call-template name="attVal">
			<xsl:with-param name="value" select="$value"/>
		</xsl:call-template>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="attVal">
		<xsl:param name="value"/>
		<xsl:variable name="nsp" select="substring-before($value,':')"/>
		<xsl:if test="$nsp = 'gml'">
			<xsl:value-of select="$value"/><xsl:text disable-output-escaping="yes">,</xsl:text>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="getBaseList">
		<xsl:param name="schemaList"/>
		<xsl:if test="$schemaList != ''">
			<xsl:variable name="first" select="substring-before($schemaList, ',')"/>
			<xsl:variable name="rest" select="substring-after($schemaList, ',')"/>
			<xsl:message>Schema: <xsl:value-of select="$first"/></xsl:message>
			<xsl:variable name="bases">
				<xsl:for-each select="document($first, / )">
					<xsl:apply-templates/>
				</xsl:for-each>
			</xsl:variable>
			<xsl:value-of select="$bases"/>
			<xsl:if test="contains($rest,',')">
				<xsl:call-template name="getBaseList">
					<xsl:with-param name="schemaList" select="$rest"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="getUniqueBaseList">
		<xsl:param name="schemaList"/>
		<xsl:variable name="allBases">
			<xsl:call-template name="getBaseList">
				<xsl:with-param name="schemaList" select="$schemaList"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="uniqueBases">
			<xsl:call-template name="uniqueList">
				<xsl:with-param name="list" select="$allBases"/>
				<xsl:with-param name="sep">,</xsl:with-param>
			</xsl:call-template>
		</xsl:variable>
		<xsl:value-of select="$uniqueBases"/> 
	</xsl:template>
	<!-- ==================================================== -->
</xsl:stylesheet>
