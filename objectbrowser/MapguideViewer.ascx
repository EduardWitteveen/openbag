<%@ Control Language="c#" AutoEventWireup="false" Codebehind="MapguideViewer.ascx.cs" Inherits="qi02.MapguideViewer" TargetSchema="http://schemas.microsoft.com/intellisense/ie5" debug="True"%>
<!-- START viewer -->
<OBJECT id="<%= ID %>" name="<%= ID %>" height="100%" width="100%" classid="clsid:62789780-B744-11D0-986B-00609731A21D" codeBase="http://www.mapguide.com/Downloads/MG_R6.5/En/Viewer/mgaxctrl.cab" VIEWASTEXT>
	<PARAM NAME="URL" VALUE="<%= Url %>">
	<PARAM NAME="Lat" VALUE="0">
	<PARAM NAME="Lon" VALUE="0">
	<PARAM NAME="MapScale" VALUE="0">
	<PARAM NAME="MapWidth" VALUE="0">
	<PARAM NAME="MapUnits" VALUE="M">
	<PARAM NAME="ToolBar" VALUE="Off">
	<PARAM NAME="StatusBar" VALUE="Off">
	<PARAM NAME="LayersViewWidth" VALUE="0">
	<PARAM NAME="BSCRC" VALUE="0">
	<PARAM NAME="DefaultTarget" VALUE="">
	<PARAM NAME="ErrorTarget" VALUE="">
	<PARAM NAME="ObjectLinkTarget" VALUE="">
	<PARAM NAME="ReportTarget" VALUE="">
	<PARAM NAME="URLList" VALUE="Off">
	<PARAM NAME="URLListTarget" VALUE="">
	<PARAM NAME="AutoLinkLayers" VALUE="">
	<PARAM NAME="AutoLinkTarget" VALUE="">
	<PARAM NAME="AutoLinkDelay" VALUE="20">
	<!-- the activex object was not installed, try it with the applet -->	
<!--	
	<APPLET id="<%= ID %>" name="<%= ID %>" code="com.autodesk.mgjava.MGMapApplet" archive="mapguide/mgjava.jar"  height="100%" width="100%" VIEWASTEXT>
		<PARAM name="mwfurl" value="<%= Url %>?LayersViewWidth=0&StatusBar=off&ToolBar=Off" >
	</APPLET>
-->	
</OBJECT>
<!-- STOP viewer -->