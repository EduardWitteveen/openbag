<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
	xmlns:xlink="http://www.w3.org/1999/xlink">
	<!-- =========================================================== 
	This stylesheet is designed to be used on gml.xsd to produce gml.dep 
	for use by the gml schema subset utility gmlSubset.xslt to produce a specialized
	gmlSubset.xsd that contains only the specified types and elements, and the types 
	and elements on which they depend. 
	===========================================================-->
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:include href="utility.xslt"/>
	<!-- NEWLINE = &#xA; -->
	<xsl:param name="also"></xsl:param>
	<xsl:param name="alsoPre"></xsl:param>
	<xsl:param name="usePre"></xsl:param>
	<xsl:param name="schemas">basicTypes.xsd,coordinateOperations.xsd,coordinateReferenceSystems.xsd,coordinateSystems.xsd,coverage.xsd,dataQuality.xsd,datums.xsd,defaultStyle.xsd,dictionary.xsd,direction.xsd,dynamicFeature.xsd,feature.xsd,geometryAggregates.xsd,geometryBasic0d1d.xsd,geometryBasic2d.xsd,geometryComplexes.xsd,geometryPrimitives.xsd,gml.xsd,gmlBase.xsd,grids.xsd,measures.xsd,observation.xsd,referenceSystems.xsd,temporal.xsd,temporalReferenceSystems.xsd,temporalTopology.xsd,topology.xsd,units.xsd,valueObjects.xsd,</xsl:param>
	<xsl:param name="allSchemas">
		<xsl:call-template name="getUniqueSchemaList">
			<xsl:with-param name="list" select="$schemas"/>
			<xsl:with-param name="usePre" select="$usePre"/>
		</xsl:call-template>
	</xsl:param>
	<xsl:template match="/">
		<xsl:param name="docName">gml.xsd</xsl:param>
		<xsl:param name="top" select="true()"/>
		<xsl:param name="tns" select="//xsd:schema/@targetNamespace"/>
		<xsl:param name="vers" select="//xsd:schema/@version"/>
		<xsl:variable name="ltns">
			<xsl:for-each select="//xsd:schema/namespace::*">
				<xsl:if test="local-name() != 'targetNamespace' and string() = $tns">
					<xsl:value-of select="local-name()"/>
				</xsl:if>
			</xsl:for-each>
		</xsl:variable>
		<xsl:variable name="tnsp">
			<xsl:choose>
				<xsl:when test="$ltns = ''">
					<xsl:call-template name="getTargetNameSpacePrefix">
						<xsl:with-param name="list" select="$tns"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$ltns"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:text>&#xA;</xsl:text>
		<xsl:choose>
			<xsl:when test="$top">
				<xsl:text disable-output-escaping="yes">&lt;depends version="</xsl:text><xsl:value-of select="$vers"/><xsl:text disable-output-escaping="yes">"&gt;</xsl:text>
				<xsl:variable name="baseUri" select="document('')"/>
				<xsl:for-each select="document($also,$baseUri)">
					<xsl:for-each select="//def">
						<xsl:choose>
							<xsl:when test="$alsoPre='' ">
								<xsl:copy-of select="."/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:copy>
									<xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
									<xsl:attribute name="doc"><xsl:value-of select="$alsoPre"/><xsl:value-of select="@doc"/></xsl:attribute>
									<xsl:for-each select="*"><xsl:copy-of select="."/></xsl:for-each>
								</xsl:copy>				
							</xsl:otherwise>
						</xsl:choose>
					</xsl:for-each>				
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:for-each select="/xsd:schema">
					<xsl:for-each select="xsd:complexType | xsd:group | xsd:simpleType | xsd:element | xsd:attribute | xsd:attributeGroup">
						<xsl:variable name="type" select="local-name()"/>
						<xsl:choose>
							<xsl:when test="$type = 'complexType' ">
								<xsl:call-template name="complexType">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="$type = 'group' ">
								<xsl:call-template name="complexType">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="$type = 'simpleType' ">
								<xsl:call-template name="simpleType">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="$type = 'element' ">
								<xsl:call-template name="globalElement">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="$type = 'attribute' ">
								<xsl:call-template name="globalAtt">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="$type = 'attributeGroup' ">
								<xsl:call-template name="globalAtt">
									<xsl:with-param name="docName" select="$docName"/>
									<xsl:with-param name="targetNamespace" select="$tnsp"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise/>
						</xsl:choose>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
		<xsl:if test="$top">
			<xsl:call-template name="dependSchemas">
				<xsl:with-param name="list" select="$allSchemas"/>
			</xsl:call-template>
			<xsl:text disable-output-escaping="yes">&#xA;&lt;/depends&gt;&#xA;</xsl:text>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="complexType">
		<xsl:param name="docName"/>
		<xsl:param name="targetNamespace"/>
		<xsl:variable name="name" select="@name"/>
		<xsl:if test="$name">
			<xsl:element name="def">
				<xsl:attribute name="name"><xsl:value-of select="$targetNamespace"/>:<xsl:value-of select="$name"/></xsl:attribute>
				<xsl:attribute name="doc"><xsl:value-of select="$docName"/></xsl:attribute>
				<xsl:variable name="uses">
					<xsl:apply-templates select="./xsd:complexContent|./xsd:simpleContent"/>
					<xsl:call-template name="EltAndAtt"/>
				</xsl:variable><!-- USES <xsl:value-of select="$uses"/> -->
				<xsl:call-template name="writeUses">
					<xsl:with-param name="list" select="$uses"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="xsd:complexContent">
		<xsl:for-each select="descendant::xsd:extension">
			<xsl:value-of select="@base"/>
			<xsl:text>?extension|</xsl:text>
		</xsl:for-each>
		<xsl:for-each select="descendant::xsd:restriction">
			<xsl:value-of select="@base"/>
			<xsl:text>?restriction|</xsl:text>
		</xsl:for-each>		
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="xsd:simpleContent">
		<xsl:for-each select="descendant::xsd:extension">
			<xsl:value-of select="@base"/>
			<xsl:text>?extension|</xsl:text>
		</xsl:for-each>
		<xsl:for-each select="descendant::xsd:restriction">
			<xsl:value-of select="@base"/>
			<xsl:text>?restriction|</xsl:text>
		</xsl:for-each>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="EltAndAtt">
		<xsl:for-each select="descendant::xsd:element | descendant::xsd:group | descendant::xsd:attribute | descendant::xsd:attributeGroup">
			<xsl:variable name="name" select="@type | @ref"/>
			<xsl:if test="$name and contains($name,':')">
				<xsl:value-of select="$name"/>
				<xsl:text>|</xsl:text>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="simpleType">
		<xsl:param name="docName"/>
		<xsl:param name="targetNamespace"/>
		<xsl:variable name="name" select="@name"/>
		<xsl:if test="$name">
			<xsl:element name="def">
				<xsl:attribute name="name"><xsl:value-of select="$targetNamespace"/>:<xsl:value-of select="$name"/></xsl:attribute>
				<xsl:attribute name="doc"><xsl:value-of select="$docName"/></xsl:attribute><!-- SIMPLE <xsl:copy-of select="."/> -->
				<xsl:variable name="uses">
					<xsl:for-each select="xsd:union"><!-- UNION <xsl:value-of select="@memberTypes"/> -->
						<xsl:variable name="members" select="@memberTypes"/>
						<xsl:if test="$members">
							<xsl:value-of select="translate($members,' ','|')"/>
							<xsl:text>|</xsl:text>
						</xsl:if>
					</xsl:for-each>
					<xsl:for-each select="xsd:list">
						<xsl:variable name="items" select="@itemType"/>
						<xsl:if test="$items">
							<xsl:value-of select="$items"/>
							<xsl:text>|</xsl:text>
						</xsl:if>
					</xsl:for-each>
				</xsl:variable><!-- USES <xsl:value-of select="$uses"/> -->
				<xsl:call-template name="writeUses">
					<xsl:with-param name="list" select="$uses"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="globalElement">
		<xsl:param name="docName"/>
		<xsl:param name="targetNamespace"/>
		<xsl:variable name="name" select="@name"/>
		<xsl:if test="$name">
			<xsl:element name="def">
				<xsl:attribute name="name"><xsl:value-of select="$targetNamespace"/>:<xsl:value-of select="$name"/></xsl:attribute>
				<xsl:attribute name="doc"><xsl:value-of select="$docName"/></xsl:attribute>
				<xsl:variable name="uses">
					<xsl:variable name="type" select="@type"/>
					<xsl:if test="$type and contains($type,':')">
						<xsl:value-of select="$type"/>
						<xsl:text>|</xsl:text>
					</xsl:if>
					<xsl:variable name="sub" select="@substitutionGroup"/>
					<xsl:if test="$sub">
						<xsl:value-of select="$sub"/>
						<xsl:text>|</xsl:text>
					</xsl:if>
				</xsl:variable><!-- USES <xsl:value-of select="$uses"/> -->
				<xsl:call-template name="writeUses">
					<xsl:with-param name="list" select="$uses"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="globalAtt">
		<xsl:param name="docName"/>
		<xsl:param name="targetNamespace"/>
		<xsl:variable name="name" select="@name"/>
		<xsl:if test="$name">
			<xsl:element name="def">
				<xsl:attribute name="name"><xsl:value-of select="$targetNamespace"/>:<xsl:value-of select="$name"/></xsl:attribute>
				<xsl:attribute name="doc"><xsl:value-of select="$docName"/></xsl:attribute>
				<xsl:variable name="uses">
					<xsl:variable name="type" select="@type"/>
					<xsl:if test="$type and contains($type,':')">
						<xsl:value-of select="$type"/>
						<xsl:text>|</xsl:text>
					</xsl:if>
					<xsl:call-template name="EltAndAtt"/>
				</xsl:variable><!-- USES <xsl:value-of select="$uses"/> -->
				<xsl:call-template name="writeUses">
					<xsl:with-param name="list" select="$uses"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="writeUses">
		<xsl:param name="list"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, '|')"/>
			<xsl:variable name="eor" select="substring-after($first, '?')"/>
			<xsl:variable name="use">
				<xsl:choose>
					<xsl:when test="contains($first, '?')">
						<xsl:value-of select="substring-before($first, '?')"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$first"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:variable>
			<xsl:variable name="testp">
				<xsl:value-of select="$use"/>
				<xsl:text>|</xsl:text>
			</xsl:variable>
			<xsl:variable name="testq">
				<xsl:value-of select="$use"/>
				<xsl:text>?</xsl:text>
			</xsl:variable>
			<xsl:variable name="rest" select="substring-after($list, '|')"/>
			<xsl:choose>
				<xsl:when test="contains($rest, $testp)"/>
				<xsl:when test="contains($rest, $testq)"/>
				<xsl:when test="$use = ''"/>
				<xsl:otherwise>
					<xsl:element name="uses">
						<xsl:attribute name="name"><xsl:value-of select="$use"/></xsl:attribute>
						<xsl:if test="$eor != ''">
							<xsl:attribute name="derivation"><xsl:value-of select="$eor"/> </xsl:attribute>
						</xsl:if>
					</xsl:element>
				</xsl:otherwise>
			</xsl:choose>
			<xsl:call-template name="writeUses">
				<xsl:with-param name="list" select="$rest"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="dependSchemas">
		<xsl:param name="list"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, ',')"/>
			<xsl:variable name="rest" select="substring-after($list, ',')"/>
			<xsl:apply-templates select="document($first, /)"> 
				<xsl:with-param name="docName" select="$first"/>
				<xsl:with-param name="top" select="false()"/>
			</xsl:apply-templates>
			<xsl:choose>
				<xsl:when test="contains($rest,',')">
					<xsl:call-template name="dependSchemas">
						<xsl:with-param name="list" select="$rest"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise/>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- =========================================================== -->
</xsl:stylesheet>
