<?php
	header("Cache-Control: no-cache, must-revalidate"); 

	$minx = ($_REQUEST['minx']);
	$maxx = ($_REQUEST['maxx']);
	$miny = ($_REQUEST['miny']);
	$maxy = ($_REQUEST['maxy']);
	$parameters = "$minx,$maxx,$miny,$maxy";

	$height = ($_REQUEST['height']);
	$width = ($_REQUEST['width']);
?>
<html>
<head>
	<title></title>
	<!--
		API definition (page which used the viewer):
			onGisObjectClick(layername, objectkey);
	-->
	<!-- Attach the required events to the mapguide plugin-->
	<!-- C:\Program Files\Autodesk\MapGuideDocumentation6.5\ViewerAPIHelp\ViewerAPI\index.htm -->
	<SCRIPT LANGUAGE="VBScript">
		Sub mgmap_onAddMapLayer(URL, layer)
			onAddMapLayer URL, layer
		End Sub
		Sub mgmap_onBeginLayout (pgSetup, printInfo)
			onBeginLayout pgSetup, printInfo
		End Sub
		Sub mgmap_onBusyStateChanged(map, busyState)
			onBusyStateChanged map, busyState
		End Sub
		Sub mgmap_onDigitizedCircle(map, units, center, radius)
			onDigitizedCircle map, units, center, radius
		End Sub
		Sub mgmap_onDigitizedPoint(map, point)
			onDigitizedPoint map, point
		End Sub
		Sub mgmap_onDigitizedPolygon(map, numPoints, points)
			onDigitizedPolygon map, numPoints, points
		End Sub
		Sub mgmap_onDigitizedPolyline(map, numPoints, latlon)
			onDigitizedPolyline map, numPoints, latlon
		End Sub
		Sub mgmap_onDigitizedRectangle(map, anchorPt, endPt)
			onDigitizedRectangle map, anchorPt, endPt
		End Sub
		Sub mgmap_onDoubleClickObject(mapobject)
			mapObject.DoubleClickHandled = onDoubleClickObject(mapobject)
		End Sub
		Sub mgmap_onEndLayout (layout, printInfo)
			onEndLayout layout, printInfo
		End Sub
		Sub mgmap_onMapLoaded(map)
			onMapLoaded map
		End Sub
		Sub mgmap_onSelectionChanged(map)
			onSelectionChanged map
		End Sub
		Sub mgmap_onViewChanged(map)
			onViewChanged map
		End Sub
		Sub mgmap_onViewChanging(map)
			onViewChanging map
		End Sub
		Sub mgmap_onViewedDistance(map, totalDistance, distances, units)
			onViewedDistance map, totalDistance, distances, units
		End Sub
		Sub mgmap_onViewedDistanceEx(map, totalDistance, distances, units, useMcs)
			onViewedDistanceEx map, totalDistance, distances, units, useMcs
		End Sub
	</SCRIPT>
	<!-- the mapguide events are implemented below -->
	<script language="JavaScript">
		/*
		Description
		This event is fired when a new map layer has been added. It is initiated by a call to addMapLayer.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGAddMapLayerObserver.onAddMapLayer.
		
		Applies To
		ActiveX Control only
		
		Parameters
		URL - A string that will contain the URL of the map layer file as passed to the addMapLayer method. This can be used to 
		differentiate between multiple onAddMapLayer events if several layers are added to the map in succession. 
		
		layer - An MGMapLayer object for the new map layer. If unsuccessful, this parameter will be null. 
		
		Error Codes
		none
		*/
		function onAddMapLayer (URL, layer)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired right before the Autodesk MapGuide Viewer uses the internal algorithm to lay out the page elements.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGPrintingObserver.onBeginLayout.
		
		Applies To
		ActiveX Control only
		
		Parameters
		pgSetup - An MGPageSetup object representing the current page layout settings. 
		
		info - An MGPrintInfo object containing information about the current printing operation. 
		
		Error Codes
		none
		*/
		function onBeginLayout (pgSetup, printInfo)
		{
		// Event Handling Code Here ...
		}
		/*
		Description
		This event is fired when the Autodesk MapGuide Viewer enters and exits busy states. 
		
		Autodesk MapGuide enters busy states when users pan or zoom to view more map data.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGBusyStateChangedObserver.onBusyStateChanged.
		
		Parameters
		map - The map object that this event applies to. 
		
		busyState - The current busy state of Autodesk MapGuide Viewer. 
		
		Error Codes
		none
		*/
		function onBusyStateChanged(map, busyState)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when the user has finished digitizing a circle. 
		
		It is initiated by a call to digitizeCircle.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDigitizeCircleObserver.onDigitizedCircle.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred. 
		
		units - A string containing the units in which the radius is provided, one of the following codes: M (meters), KM 
		(kilometers), FT (feet), or MI (miles).
		
		center - An MGPoint object for the longitude/latitude center of the digitized circle. 
		
		radius - The radius of the digitized circle (a String). 
		
		Error Codes
		-1 (busy) 
		*/
		function onDigitizedCircle(map, units, center, radius)
		{
		 // event handling code here...
		}
		/*
		Description
		This event is fired when the user has finished digitizing a point. It is initiated by a call to digitizePoint.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDigitizePointObserver.onDigitizedPoint.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred. 
		
		point - The MGPoint object for the digitized longitude/latitude coordinate pair. 
		
		Error Codes
		none 
		*/
		function onDigitizedPoint(map, point)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when the user has finished digitizing a polygon. It is initiated by a call to digitizePolygonEx.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDigitizePolygonObserverEx.onDigitizedPolygon.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - Specifies the MGMap instance. 
		
		numPoints - The number of vertices of the polygon. 
		
		latlon - An MGCollection object that stores a list of MGPoint objects, each of which represents a longitude-latitude pair. 
		
		Error Codes
		none
		*/
		function onDigitizedPolygon(map, numPoints, points)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when the user has finished digitizing a polyline. It is initiated by a call to digitizePolylineEx. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDigitizePolylineObserverEx.onDigitizedPolyline.
		
		Parameters
		map - Specifies the MGMap instance. 
		
		numPoints - The number of vertices of the polyline. 
		
		latlon - An MGCollection object that stores a list of MGPoint objects, each of which represents a vertex of the polyline. 
		
		Error Codes
		none
		*/
		function onDigitizedPolyline(map, numPoints, latlon)
		{
		 // event handling code here...
		}
		/*
		Description
		This event is fired when the user has finished digitizing a rectangle. It is initiated by a call to digitizeRectangle.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDigitizeRectangleObserver.onDigitizedRectangle.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred. 
		
		anchorPt - The MGPoint object containing the longitude and latitude of the digitized rectangle's starting (anchor) point. 
		
		endPt - The MGPoint object containing the longitude and latitude of the digitized rectangle's ending point. 
		
		Error Codes
		none
		*/
		function onDigitizedRectangle(map, anchorPt, endPt)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when the user double-clicks on a map feature.
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGDoubleClickObjectObserver.onDoubleClickObject.
		
		Applies To
		ActiveX Control only
		
		Parameters
		obj - The MGMapObject map feature that was double-clicked. 
		
		Error Codes
		none
		*/
		function onDoubleClickObject(mapobject)
		{
			var maplayer = mapobject.getMapLayer();
			var layername = maplayer.getName();
			var layerlegendlabel = maplayer.getLegendLabel();
			var objectkey = mapobject.getKey();
			var objectname = mapobject.getName();
			//alert("Click on object:" + objectname  + "(key:" + objectkey + ") from layer:" + layerlegendlabel + "(name:" + layername + ")");
			
			// check if the page which included this viewer has 
			// the needed function
			var functionpointer = getParentWindow().onGisObjectClick;
			if(functionpointer) {
				functionpointer(layername, objectkey);
			} else alert("function not found!"); 		
		}
		/*
		Description
		This event is fired after the Autodesk MapGuide Viewer has finished the internal layout of the page elements but before the 
		map is sent to the printer. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGPrintingObserver.onEndLayout.
		
		Applies To
		ActiveX Control only
		
		Parameters
		layout - An MGPrintLayout object that represents the current page layout. 
		
		info - An MGPrintInfo object that contains information about the current printing operation. 
		
		Error Codes
		none
		*/
		function onEndLayout (layout, printInfo)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when Autodesk MapGuide loads an MWF into the Autodesk MapGuide Viewer, before the first refresh. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGMapLoadedObserver.onMapLoaded.
		
		A typical use of onMapLoaded is to set certain MWF properties, such as a SQL where clause, based on external variables, for 
		example, the user name. If you want to change settings every time the map is about to be refreshed, use the onViewChanging 
		event instead. 
		
		Note that Autodesk MapGuide disables the autoRefresh flag, set by setAutoRefresh, when it executes the onMapLoaded event. 
		Therefore, calling zoomGotoDlg, zoomGotoLocation, setUrl, or refresh in onMapLoaded has no effect. Additionally, 
		setAutoRefresh has no effect when called from onMapLoaded.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The MGMap map object that this event applies to. 
		
		Error Codes
		none 
		*/
		function onMapLoaded(map)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when the map selection has changed. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGSelectionChangedObserver.onSelectionChanged.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred. 
		
		Error Codes
		none 
		
		Note
		If your application has notify (the second argument of addObject) set to True, writing code in the onSelectionChanged event 
		that changes the selection will result in an infinite loop. For example:
		
		var mapSel = map.getSelection(); 
		var obj = layer.getMapObject('CA'); 
		mapSel.addObject(obj, true); 
		*/
		function onSelectionChanged(map)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired after the view of the map has been updated or refreshed. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGViewChangedObserver.onViewChanged.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred.
		
		Error Codes
		none
		
		Note 
		Writing code in the onViewChanged event that changes the map view, such as map.refresh(); results in an infinite loop.
		
		Example
		To handle this event from the Autodesk MapGuide ActiveX Control, define VBScript and JavaScript functions like the following:
		*/
		var firsttime = true;
		function onViewChanged(map)
		{
			if(firsttime) {
				zoomwindow(map, <?php echo($parameters) ?>);
				firsttime = false;
			}
		}
		/*
		Description
		This event is fired just before the map is refreshed. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see MGViewChangingObserver.onViewChanging.
		
		There are many useful actions you can execute with onViewChanging, for instance, customizing layer settings such as 
		visibility, the SQL Where clause, or the data file to which a layer refers. If you just want to initialize layer settings the 
		first time that Autodesk MapGuide Viewer displays a map, as opposed to every time that the map is refreshed, use the 
		onMapLoaded event instead.
		
		Note that Autodesk MapGuide disables the autoRefresh flag, set by setAutoRefresh, when it executes the onViewChanging event. 
		Therefore, calling zoomGotoDlg, zoomGotoLocation, setUrl, or refresh in onViewChanging has no effect. Additionally, 
		setAutoRefresh has no effect when called from within onViewChanging.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The map object for which the event occurred. 
		
		Error Codes
		none
		*/
		function onViewChanging(map)
		{
		// event handling code here...
		}
		/*
		Description
		This event is fired when a user has finished viewing distances. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGViewDistanceObserver.onViewedDistance.
		
		Note that the event is fired only if the distances were measured using the viewDistance method or the UI menu commands. If 
		the distances were measured using the viewDistanceEx method, onViewedDistanceEx is fired instead.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The MGMap object for which the event occurred. 
		
		totalDistance - The total distance viewed. 
		
		distances - An MGCollection object containing all the sub-distances. 
		
		units - The units used to quantify the distance. 
		
		Error Codes
		-1 (busy) 
		*/
		function onViewedDistance(map, totalDistance, distances, units)
		{
		 // event handling code here...
		}
		/*
		Description
		This event is fired when a user has finished viewing distances. 
		
		This topic describes this event for ActiveX Control. For Plug-In and Java Edition, see 
		MGViewDistanceExObserver.onViewedDistanceEx.
		
		Note that the event is fired only if the distances were measured using the viewDistanceEx method. If the distances were 
		measured using the viewDistance method (or the user interface menu commands), onViewedDistance is fired instead.
		
		Applies To
		ActiveX Control only
		
		Parameters
		map - The MGMap object for which the event occurred 
		
		totalDistance - The total distance viewed. 
		
		distances - An MGCollection object containing type-double objects representing all the sub-distances. 
		
		points - An MGCollection containing MGPoint objects representing all the points used in the view distance action; the points 
		will be in MCS or lat/lon coordinates, based on the setting of useMcs. 
		
		units - The units used to quantify the distance. 
		
		useMcs - A flag to indicate whether the points are in MCS or lat/lon. 
		
		Error Codes
		none
		*/
		function onViewedDistanceEx(map, totalDistance, distances, units, useMcs)
		{
		 // event handling code here...
		}
	</script>
	<!-- usefull methods -->
	<script language="JavaScript">
		function zoomwindow(map, minx, maxx, miny, maxy) {		
			var fminx = parseFloat(minx);
			var fminy = parseFloat(miny);
			var fmaxx = parseFloat(maxx);
			var fmaxy = parseFloat(maxy);				
			if(isNaN(fminx)) {
				alert("minx was not a number:" + minx);
				return;
			}
			if(isNaN(fminy)) {
				alert("miny was not a number:" + miny);
				return;
			}
			if(isNaN(fmaxx)) {
				alert("maxx was not a number:" + maxx);
				return;
			}
			if(isNaN(fmaxy)) {
				alert("maxy was not a number:" + maxy);
				return;
			}		
			//var map = getMap();
			//alert("minx:" + fminx + " miny:" + fminy + " maxx:" + fmaxx + " maxy:" + fmaxy);
			//alert("lat:" + map.getLat() + " lon:" + map.getLon());
			
			var xpos = (fmaxx +  fminx) / 2.0;
			var ypos = (fmaxy +  fminy) / 2.0;
			//alert("xpos:" + xpos + " ypos:" + ypos);
			
			// bepaal X en Y
			var latLonPt = map.mcsToLonLat(xpos/1, ypos/1);
			var lat = latLonPt.getY(); 
			var lon = latLonPt.getX();
			// bepaal de breedte en hoogte
			var breedte = (fmaxx - fminx);
			var hoogte = (fmaxy - fminy);
			var berekendebreedtevanhoogte = (hoogte / map.getHeight("M")) * map.getWidth("M");
			if (berekendebreedtevanhoogte > breedte) {
				breedte = berekendebreedtevanhoogte;
			}
			//alert(breedte);
			// maak hem 100 meter breder (huizen moeten er dan wel in vallen, 
			breedte = breedte + 100;
			map.zoomWidth(lat, lon,  breedte, "M");
			map.setAutoRefresh(true);
			map.refresh();		
		}
		function getParentWindow() {			
			return window.parent;
		}
	</script>
</head>
<body style="margin:0px;">
<OBJECT 
	id="mgmap"
	name="mgmap"
	height="<?php echo($height); ?>px"
	width="<?php echo($width); ?>px"
	classid="clsid:62789780-B744-11D0-986B-00609731A21D" 
	codeBase="ftp://adeskftp.autodesk.com/webpub/mapguide/ver6/viewer/en/mgaxctrl.cab#Version=6,0,2,2"
	border="0"
	VIEWASTEXT="VIEWASTEXT">
	<PARAM NAME="URL" VALUE="adres.mwf" />
	<PARAM NAME="Lat" VALUE="0" />
	<PARAM NAME="Lon" VALUE="0" />
	<PARAM NAME="MapScale" VALUE="0" />
	<PARAM NAME="MapWidth" VALUE="0" />
	<PARAM NAME="MapUnits" VALUE="M" />
	<PARAM NAME="ToolBar" VALUE="Off" />
	<PARAM NAME="StatusBar" VALUE="Off" />
	<PARAM NAME="LayersViewWidth" VALUE="0" />
	<PARAM NAME="BSCRC" VALUE="0" />
	<PARAM NAME="DefaultTarget" VALUE="" />
	<PARAM NAME="ErrorTarget" VALUE="" />
	<PARAM NAME="ObjectLinkTarget" VALUE="" />
	<PARAM NAME="ReportTarget" VALUE="" />
	<PARAM NAME="URLList" VALUE="Off" />
	<PARAM NAME="URLListTarget" VALUE="" />
	<PARAM NAME="AutoLinkLayers" VALUE="" />
	<PARAM NAME="AutoLinkTarget" VALUE="" />
	<PARAM NAME="AutoLinkDelay" VALUE="20" />
</OBJECT>
</body>
</html>