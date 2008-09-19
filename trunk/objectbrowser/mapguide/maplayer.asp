<!-- #include file="../obrowser/common.asp"                   -->
<!-- #include file="../obrowser/include/db.asp"               -->
<!-- #include file="../obrowser/include/functions_system.asp" -->
<!-- #include file="../obrowser/include/classes/mapguide.asp" -->
<%
'*******************************************************************************
'***                                                                         ***
'*** File       : maplayer.asp                                               ***
'*** Author     : Edwin Poldervaart                                          ***
'*** Date       : 13-03-2006                                                 ***
'*** Copyright  : (C) 2006 HawarIT BV                                        ***
'*** Email      : info@hawarIT.com                                           ***
'***                                                                         ***
'*** Description: Common interface for adding map layers                     ***
'***                                                                         ***
'*******************************************************************************

Dim mwfDoc, gMGLayer, mwxName
Dim floor, featureTable, sdProvider, sqlWhere, themeTable

'*** Get defined feature table and 'WHERE' clause.
featureTable = gReport.Item("MG_FeatureTable")
sdProvider   = gReport.Item("MG_SDProvider")
sqlWhere     = gReport.Item("SQL_Where")
themeTable   = gReport.Item("SQL_From")

'*** Create Layer object.
Set gMGLayer = New MGMapLayer

'*** Set layer properties.
With gMGLayer
  '*** General layer properties.
  .DrawPriority  = "50"
  .LayerType     = gReport.Item("MG_MapLayerType")
  .LegendLabel   = "Custom Theme"
  .MapLayerGroup = "CustomThemes"
  .Name          = "CustomTheme"
  
  '*** DataSources properties.
  .ServerURL = MGDS_SERVERURL
  
  '*** Generic SDPFeatureDataSource properties.
  .SDPFeatureTable   = featureTable
  .SDPNameColumn     = gReport.Item("SQL_GroupBy")
  .SDPSQLWhereClause = sqlWhere
  
  '*** Database specific SDPFeatureDataSource properties.
  If (StrComp(sdProvider, "ORA", 1) = 0) Then
    '*** Oracle Spatial settings
    .SDPDataSource     = MGDS_ORACLE
    .SDPKeyColumn      = "GID"
    .SDPGeometryColumn = "GEOM"
  Else
    '*** SDF settings.
    .SDPDataSource     = MGDS_SDF
    .SDPKeyColumn      = "FEATURE_ID"
    .SDPGeometryColumn = "FEATURE_GEOM"
  End If
  
  If (StrComp(themeTable, featureTable, 1) <> 0) Then
    '*** Set Secondary DataSource properties.
    .SDPNameSource            = 1
    .SDPApplySQLWhereClauseTo = 1
    .SDDataSource             = MGDS_ORACLE
    .SDTable                  = themeTable
    .SDKeyColumn              = gReport.Item("MG_KeyColumn")
  End If
  
  '*** General theme properties.
  .ThemeDataSource  = MGDS_ORACLE
  .ThemeKeyColumn   = gReport.Item("MG_KeyColumn")
  .ThemeTable       = themeTable
  .ThemeValueColumn = gReport.Item("SQL_GroupBy")
  
  '*** Set theme list.
  Set .ThemeList = gThemeList
End With

'*** Get temporary file name.
mwxName = GetTempFileName()

'*** Save layer to temporary file.
Call gMGLayer.SaveAsMWX(mwxName)

'*** Read XML file.
Set mwfDoc = Server.CreateObject("Autodesk.MapWindowFile")

mwfDoc.ValidateMwx = False
mwfDoc.CompressMwf = False

mwfDoc.ReadFromMwx(mwxName)

'*** Delete temporary MWX file.
Call FileDelete(mwxName)

'*** Return the binary MLF information.
Response.Expires     = -1
Response.Buffer      = True
Response.ContentType = "application/x-mlf"

Call Response.BinaryWrite(mwfDoc.WriteToMlfStream("", gMGLayer.Name))
Call Response.End()
%>