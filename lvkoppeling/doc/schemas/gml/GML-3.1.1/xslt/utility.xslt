<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<!-- ==================================================== -->
	<xsl:template name="getTargetNameSpacePrefix">
		<xsl:param name="list"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, '/')"/>
			<xsl:variable name="rest" select="substring-after($list, '/')"/>
			<xsl:choose>
				<xsl:when test="contains($rest,'/')">
					<xsl:call-template name="getTargetNameSpacePrefix">
						<xsl:with-param name="list" select="$rest"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="$rest =''">
					<xsl:value-of select="$first"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$rest"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="getPathPrefix">
		<xsl:param name="file"/>
		<xsl:if test="contains($file,'/')">
			<xsl:variable name="pre" select="substring-before($file,'/')"/>
			<xsl:variable name="suf" select="substring-after($file,'/')"/>
			<xsl:choose>
				<xsl:when test="contains($suf,'/')">
					<xsl:value-of select="$pre"/>
					<xsl:text>/</xsl:text>
					<xsl:call-template name="getPathPrefix">
						<xsl:with-param name="file" select="$suf"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:variable name="path">
						<xsl:call-template name="removeSuffix">
							<xsl:with-param name="name" select="$file"/>
							<xsl:with-param name="suf" select="$suf"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:value-of select="$path"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="removePrefix">
		<xsl:param name="name"/>
		<xsl:param name="pre"/>
		<xsl:variable name="npName">
			<xsl:choose>
				<xsl:when test="contains($name,$pre)">
					<xsl:value-of select="substring-after($name,$pre)"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$name"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:value-of select="$npName"/>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="removeSuffix">
		<xsl:param name="name"/>
		<xsl:param name="suf"/>
		<xsl:variable name="nsName">
			<xsl:choose>
				<xsl:when test="contains($name,$suf)">
					<xsl:value-of select="substring-before($name,$suf)"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$name"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:value-of select="$nsName"/>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="lowerLeading">
		<xsl:param name="name"/>
		<xsl:variable name="ch1" select="substring($name, 1, 1)"/>
		<xsl:variable name="lc1" select="translate($ch1,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')"/>
		<xsl:value-of select="concat($lc1, substring($name, 2))"/>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="getUnprefixedNameOrRef">
		<xsl:variable name="nameOrRef"><xsl:value-of select="@name"/><xsl:value-of select="@ref"/></xsl:variable>
		<xsl:choose>
			<xsl:when test="contains($nameOrRef,':' )">
				<xsl:value-of select="substring-after($nameOrRef,':' )"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$nameOrRef"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- ==================================================== -->
	<!-- this version is broken;  it will match FEATURENAME_ARRAY, with NAME_ARRAY, 
	<xsl:template name="uniqueList">
		<xsl:param name="list"/>
		<xsl:param name="sep"/>
		<xsl:param name="seen"/>
		<xsl:param name="pre">../base/</xsl:param>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, $sep)"/>
			<xsl:variable name="firstSep" select="concat($first,$sep)"/>
			<xsl:variable name="rest" select="substring-after($list, $sep)"/>
			<xsl:choose>
				<xsl:when test="contains($seen,$firstSep)">
					<xsl:call-template name="uniqueList">
						<xsl:with-param name="list" select="$rest"/>
						<xsl:with-param name="sep" select="$sep"/>
						<xsl:with-param name="seen" select="$seen"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$firstSep"/>
					<xsl:variable name="nowSeen" select="concat($seen, $firstSep)"/>
					<xsl:call-template name="uniqueList">
						<xsl:with-param name="list" select="$rest"/>
						<xsl:with-param name="sep" select="$sep"/>
						<xsl:with-param name="seen" select="$nowSeen"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
-->
	<!-- ==================================================== -->
	<xsl:template name="uniqueList">
		<xsl:param name="list"/>
		<xsl:param name="sep"/>
		<xsl:param name="seen"/>
		<xsl:param name="pre">../base/</xsl:param>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, $sep)"/>
			<xsl:variable name="rest" select="substring-after($list, $sep)"/>
			<xsl:variable name="firstSep" select="concat($first,$sep)"/>
			<xsl:variable name="sepFirstSep" select="concat($sep,$first,$sep)"/>
			<xsl:choose>
				<xsl:when test="contains($seen,$sepFirstSep)">
					<xsl:call-template name="uniqueList">
						<xsl:with-param name="list" select="$rest"/>
						<xsl:with-param name="sep" select="$sep"/>
						<xsl:with-param name="seen" select="$seen"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$firstSep"/>
					<xsl:variable name="nowSeen" select="concat($seen, $sepFirstSep)"/>
					<xsl:call-template name="uniqueList">
						<xsl:with-param name="list" select="$rest"/>
						<xsl:with-param name="sep" select="$sep"/>
						<xsl:with-param name="seen" select="$nowSeen"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="getIncludedDocs">
		<xsl:param name="docName"/>
		<xsl:param name="usePre"/>
		<xsl:param name="seenList"/>
		<xsl:param name="sep">,</xsl:param>
		<xsl:value-of select="$docName"/>
		<xsl:text>,</xsl:text>
		<xsl:variable name="pathPre">
			<xsl:call-template name="getPathPrefix">
				<xsl:with-param name="file" select="$docName"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="callPathPre">
			<xsl:choose>
				<xsl:when test="$pathPre = '' or $pathPre = './' ">
					<xsl:value-of select="$usePre"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$pathPre"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:for-each select="document($docName, / )">
			<xsl:for-each select="//xsd:include | //xsd:import">
				<xsl:variable name="iDoc" select="@schemaLocation"/>
				<xsl:variable name="iPathPre">
					<xsl:call-template name="getPathPrefix">
						<xsl:with-param name="file" select="$iDoc"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:variable name="iDocSuf">
					<xsl:call-template name="removePrefix">
						<xsl:with-param name="name" select="$iDoc"/>
						<xsl:with-param name="pre" select="$iPathPre"/>
					</xsl:call-template>
				</xsl:variable>
				<xsl:variable name="usePathPre">
					<xsl:choose>
						<xsl:when test="$iPathPre = '' or $iPathPre = './' ">
							<xsl:value-of select="$callPathPre"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$iPathPre"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
				<xsl:variable name="uDoc">
					<xsl:value-of select="concat($usePathPre,$iDocSuf)"/>
				</xsl:variable>
				<xsl:variable name="uDocSep">
					<xsl:value-of select="concat($uDoc,$sep)"/>
				</xsl:variable>
				<xsl:if test="not(contains($seenList,$uDocSep))">
					<xsl:variable name="seenListPlus" select="concat($seenList,$uDocSep)"/>
					<xsl:call-template name="getIncludedDocs">
						<xsl:with-param name="docName" select="$uDoc"/>
						<xsl:with-param name="usePre" select="$usePathPre"/>
						<xsl:with-param name="seenList" select="$seenListPlus"/>
					</xsl:call-template>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="getDocumentList">
		<xsl:param name="list"/>
		<xsl:param name="seenList"/>
		<xsl:param name="usePre"/>
		<xsl:if test="$list != ''">
			<xsl:variable name="first" select="substring-before($list, ',')"/>
			<xsl:variable name="rest" select="substring-after($list, ',')"/>
			<xsl:variable name="included">
				<xsl:call-template name="getIncludedDocs">
					<xsl:with-param name="docName" select="$first"/>
					<xsl:with-param name="usePre" select="$usePre"/>
					<xsl:with-param name="seenList" select="$seenList"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:value-of select="$included"/>
			<xsl:variable name="seenListIncluded" select="concat($seenList,$included)"/>
			<xsl:if test="contains($rest,',')">
				<xsl:call-template name="getDocumentList">
					<xsl:with-param name="list" select="$rest"/>
					<xsl:with-param name="seenList" select="$seenListIncluded"/>
					<xsl:with-param name="usePre" select="$usePre"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<!-- ==================================================== -->
	<xsl:template name="getUniqueSchemaList">
		<xsl:param name="list"/>
		<xsl:param name="usePre"/>
		<xsl:variable name="allSchemas">
			<xsl:call-template name="getDocumentList">
				<xsl:with-param name="list" select="$list"/>
				<xsl:with-param name="usePre" select="$usePre"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="uniqueSchemas">
			<xsl:call-template name="uniqueList">
				<xsl:with-param name="list" select="$allSchemas"/>
				<xsl:with-param name="sep">,</xsl:with-param>
			</xsl:call-template>
		</xsl:variable>
		<xsl:value-of select="$uniqueSchemas"/>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="Separator">
		<xsl:param name="comment" select="'=========='"/>
		<!--<xsl:text>&#xA;</xsl:text> -->
		<xsl:text disable-output-escaping="yes">
       &lt;!-- ==================</xsl:text>
		<xsl:value-of select="$comment"/>
		<xsl:text disable-output-escaping="yes">===================== --&gt;
   </xsl:text>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template match="node()" mode="escapeCommentCopy">
		<xsl:variable name="comment">
			<xsl:value-of select="self::comment()"/>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="string-length($comment) != 0">
				<xsl:element name="escapedComment">
					<xsl:value-of select="$comment"/>
				</xsl:element>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy>
					<xsl:for-each select="@*">
						<xsl:copy/>
					</xsl:for-each>
					<xsl:apply-templates mode="escapeCommentCopy"/>
				</xsl:copy>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="elid">
		<xsl:param name="caller">elid template</xsl:param>
		<xsl:param name="mode"/>
		<!-- all following list parameters should be lists separated by ^ with a trailing ^ 
		      leave attributeList and valueList blank if you don't need to select element by an attribute -->
		<xsl:param name="elementList"/>
		<xsl:param name="attributeList"/>
		<xsl:param name="valueList"/>
		<xsl:param name="commentList"/>
		<xsl:variable name="element" select="substring-before($elementList, '^')"/>
		<xsl:variable name="elementRest" select="substring-after($elementList, '^')"/>
		<xsl:variable name="attribute" select="substring-before($attributeList, '^')"/>
		<xsl:variable name="attributeRest" select="substring-after($attributeList, '^')"/>
		<xsl:variable name="value" select="substring-before($valueList, '^')"/>
		<xsl:variable name="valueRest" select="substring-after($valueList, '^')"/>
		<xsl:variable name="comment" select="substring-before($commentList, '^')"/>
		<xsl:variable name="commentRest" select="substring-after($commentList, '^')"/>
		<xsl:variable name="av">
			<xsl:for-each select="@*">
				<xsl:if test="local-name() = $attribute">
					<xsl:value-of select="."/>
				</xsl:if>
			</xsl:for-each>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="local-name() = $element and $av=$value">
				<xsl:text disable-output-escaping="yes">&#xA;&lt;!-- Commented Out by </xsl:text>
				<xsl:value-of select="$caller"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="$comment"/>
				<xsl:text disable-output-escaping="yes">&#xA;</xsl:text>
				<xsl:for-each select=".">
					<xsl:copy>
						<xsl:for-each select="@*">
							<xsl:copy/>
						</xsl:for-each>
						<xsl:apply-templates mode="escapeCommentCopy"/>
					</xsl:copy>
				</xsl:for-each>
				<xsl:text disable-output-escaping="yes">--&gt;&#xA;</xsl:text>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="etext">
					<xsl:if test="contains($elementRest,'^')">
						<xsl:call-template name="elid">
							<xsl:with-param name="caller" select="$caller"/>
							<xsl:with-param name="mode">list</xsl:with-param>
							<xsl:with-param name="elementList" select="$elementRest"/>
							<xsl:with-param name="attributeList" select="$attributeRest"/>
							<xsl:with-param name="valueList" select="$valueRest"/>
							<xsl:with-param name="commentList" select="$commentRest"/>
						</xsl:call-template>
					</xsl:if>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="not(contains($etext,'Commented'))">
						<xsl:choose>
							<xsl:when test="local-name() = 'documentation'">
								<xsl:copy-of select="."/>
							</xsl:when>
							<xsl:when test="$mode='children' ">
								<xsl:copy>
									<xsl:for-each select="@*">
										<xsl:copy/>
									</xsl:for-each>
									<xsl:for-each select="* | comment()">
										<xsl:call-template name="elid">
											<xsl:with-param name="caller" select="$caller"/>
											<xsl:with-param name="mode">children</xsl:with-param>
											<xsl:with-param name="elementList" select="$elementList"/>
											<xsl:with-param name="attributeList" select="$attributeList"/>
											<xsl:with-param name="valueList" select="$valueList"/>
											<xsl:with-param name="commentList" select="$commentList"/>
										</xsl:call-template>
									</xsl:for-each>
								</xsl:copy>
							</xsl:when>
						</xsl:choose>
					</xsl:when>
					<xsl:otherwise>
						<xsl:copy-of select="$etext"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- =========================================================== -->
	<xsl:template name="elidUseOptional"><!-- use only for xsd:attribute elements as there is not test-->
		<xsl:for-each select="@*">
			<xsl:variable name="value"><xsl:value-of select="."/></xsl:variable>
			<xsl:choose>
				<xsl:when test="local-name() = 'use' and $value='optional' ">
				</xsl:when>
				<xsl:otherwise>
					<xsl:copy-of select="."/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<!-- =========================================================== -->
</xsl:stylesheet>
