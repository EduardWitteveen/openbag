<%@ Page language="c#" Codebehind="Default.aspx.cs" AutoEventWireup="false" Inherits="QI02.Viewer" %>
<%@ Register TagPrefix="hawarit" TagName="MapguideViewer" Src="MapguideViewer.ascx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>HawarIT Viewer</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="media/style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="media/swap.js"></script>
		<script language="javascript" src="pinpoint/media/pinpoint.js"></script>
		<script language="javascript" src="media/subpartreport.js"></script>
		<script language="javascript" src="media/tasks.js"></script>

		<script language="javascript">
			function getMap()
			{
				return document.getElementById("MGMainViewer").object;
			}
			function openWindow(url) {			
				var w = window.open(url, "window", "height=300,width=400");
				if (window.focus) {
					w.focus();
				}				
			}
			function addLayer(layername)
			{
				var map = getMap();
				
				if (map)
				{
				  var maproot = map.getUrl();
				  
				  //*** Extract everything after last slash.
				  maproot = maproot.substring(0, maproot.lastIndexOf("/") + 1);
				  
				  //*** Disable auto refresh.
				  map.setAutoRefresh(false);
				  
				  //*** Remove theme layer if exist.
				  map.removeMapLayer(layername);
				  
				  //*** Add new theme.
				  map.addMapLayer(maproot + "maplayer.asp");
				  
				  //*** Refresh map.
				  map.setAutoRefresh(true);
				  map.refresh();
				  
				  //*** Bring viewer to front.
				  window.focus();
				}
			}
			function removeLayer(layerName)
			{
			  var map = getMap();
			  
			  //*** Remove layer (if exist).
			  if (map) map.removeMapLayer(layerName);
			}
			function zoomXY(posX, posY)
			{
				var map = getMap();
				
				if (map)
				{
					map.setAutoRefresh(false);
					
					//*** Now zoom in...
					map.zoomScale(posY, posX, 500);
					map.setAutoRefresh(true);
					map.refresh();
					
					//*** Bring viewer to front.
				  window.focus();
				}
			}
			function refreshLayer(layername) {
				// alert("refresh layer:" + layername);
				var mgmap = getMap();
				var mglayer = mgmap.getMapLayer(layername);
				mglayer.setRebuild(true);
				mgmap.Refresh();
			}
			// START LAYER FUNCTIONALITY
			function layersRefresh(callerform) {
				if(callerform == null) {
					callerform = document.getElementById("submitform");;
				}
				var layersVisible = new Array;
							
				// all layers are on, except when checkboxes are checked,.. so first set all layers to "true"				
				<% foreach(System.Xml.XmlNode node in mapLayers) { %>
				layersVisible["<%= node.Attributes["name"].Value %>"] = true;
				<% } %>
				// now process all the checkboxes, and if they are not checked, and all the layers[%legenda-includes%] will be turned 
				// to false
				<%
				
				int counter = 1;
				string currentHeaderName = "";
				foreach(System.Xml.XmlNode node in menuLayerNodes) {
					if(currentHeaderName != node.ParentNode.Attributes["headername"].Value) {
						currentHeaderName = node.ParentNode.Attributes["headername"].Value;
						// the value 0 is reserved for no selection
						counter = 1;
					}
					if(node.ParentNode.Attributes["type"].Value == "checkbox") {
				%>								
				if(!callerform.chklayer_<%= node.Attributes["name"].Value %>.checked){
					// alert("checkbox: <%= node.Attributes["name"].Value %> was not checked");
					// turn all corresponding layersVisible to false,...
					<% foreach(System.Xml.XmlNode layer in node.SelectNodes("legenda-includes/@layer")) { %>
					if(layersVisible["<%= layer.Value %>"] == null) {
						alert("layer with name <%= layer.Value %> was not defined in the layers section");
					}
					layersVisible["<%= layer.Value %>"] = false;
					<% } %>
				}
					<% } else { %>
				// OBSOLETE: if(callerform.rdblayer_<%= node.ParentNode.Attributes["headername"].Value %>.value == "<%= node.Attributes["name"].Value %>"){
				if(callerform.rdblayer_<%= node.ParentNode.Attributes["headername"].Value %>[<%= counter %>].value != "<%= node.Attributes["name"].Value %>"){
					alert("ASSERTION FAILED: if(callerform.rdblayer_<%= node.ParentNode.Attributes["headername"].Value %>[<%= counter %>].value != \"<%= node.Attributes["name"].Value %>\" {");
				}
				if(!callerform.rdblayer_<%= node.ParentNode.Attributes["headername"].Value %>[<%= counter %>].checked){
					// alert("radiobutton with value: <%= node.Attributes["name"].Value %> was not checked");
					// turn all corresponding layersVisible to false,...
					<% foreach(System.Xml.XmlNode layer in node.SelectNodes("legenda-includes/@layer")) { %>
					if(layersVisible["<%= layer.Value %>"] == null) {
						alert("layer with name <%= layer.Value %> was not defined in the layers section");
					}
					layersVisible["<%= layer.Value %>"] = false;
					<% } %>			
					}
				<%	
					counter ++;
					}
				} 
				%>
				
				// now our layers visible contains the information for all the layers
				// so we can loop over the entries and set all the layers to the corresponding values
				// this could also be a foreach loop on the layersVisible, but i dont know how to do this :D
				var viewer = getMap();
				var maplayer = null;
				
				// changes will not be drawn from this point on
				viewer.setAutoRefresh(false);							
				<% foreach(System.Xml.XmlNode node in mapLayers) { %>
				maplayer = viewer.getMapLayer("<%= node.Attributes["name"].Value %>");
				if(maplayer == null) {
					alert("maplayer with name: <%= node.Attributes["name"].Value %> is in the viewer.xml but not in the mapguide viewer");
				}
				else {
					maplayer.setVisibility(layersVisible["<%= node.Attributes["name"].Value %>"]);
					// alert("maplayer with name: <%= node.Value %> has for property visible:" + maplayer.getVisibility());
				}
				<% }
				// start filter code,.. do we have filter?				
				if(filterNode != null) {
					%>
					var filterFields = new Array();
					<%
					//===========================================================================================
					if(filterNode.Attributes["database"] == null) throw new Exception("parameter database not defined");
					if(filterNode.Attributes["query"] == null) throw new Exception("parameter query not defined");
													
					HawarIT.WebLibrary.OleDbDatabase db = new HawarIT.WebLibrary.OleDbDatabase(filterNode.Attributes["database"].Value);
					System.Data.DataTable table = db.Query(filterNode.Attributes["query"].Value);
					foreach(System.Data.DataRow row in table.Rows)
					{
					%>						
						if(callerform.chklayer_filter_<%= row[0] %>.checked){
							// add the selected value to the filter
							filterFields.push("<%= row[0] %>");
						}
					<%
					}
					%>
					// alert(filterFields);
					<%
					// apply the filter to each filterlayer
					foreach(System.Xml.XmlNode node in filterLayers) {
						%>						
						// layer: <%= node.Attributes["name"].Value %>, does exist, was asserted earlier,..
						maplayer = viewer.getMapLayer("<%= node.Attributes["name"].Value %>");
						if(filterFields.length > 0) {							
							maplayer.setSQLWhere("<%= node.Attributes["filter"].Value %> IN (" + filterFields + ")");
							// alert("layer: <%= node.Attributes["name"].Value %> with sql:" + "<%= node.Attributes["filter"].Value %> IN (" + filterFields + ")")
						}
						else {
							maplayer.setSQLWhere("");	//everything on
						}						
						<%
					}
					// apply the filter to each starts-with-layer
					foreach(System.Xml.XmlNode node in startswithLayers) {
						%>						
						// layer: <%= node.Attributes["name"].Value %>, does exist, was asserted earlier,..
						maplayer = viewer.getMapLayer("<%= node.Attributes["name"].Value %>");
						if(filterFields.length > 0) {							
							var currentpos;
							var sqlCondition = null
							for(currentpos = 0; currentpos < filterFields.length; currentpos++)
							{
								if(sqlCondition) {
									sqlCondition = sqlCondition + " OR <%= node.Attributes["startswith"].Value %> LIKE '" +  filterFields[currentpos] + "%' ";
								}
								else {
									sqlCondition = "<%= node.Attributes["startswith"].Value %> LIKE '" +  filterFields[currentpos] + "%' ";
								}																
							} 
							// alert(sqlCondition);
							maplayer.setSQLWhere(sqlCondition);
						}
						else {
							maplayer.setSQLWhere("");	//everything on
						}						
						<%
					}
				}
				%>
				// changes may be drawn from this point on
				viewer.setAutoRefresh(true);
				viewer.Refresh();
			}
			//	STOP LAYER FUNCTIONALITY
			//	START BOOKMARK FUNCTIONALITY
			function getBookmark()
			{
				var bookmark = "<bookmark ";
				var map = getMap();	

				bookmark = bookmark + "width='" + map.MapWidth + "' ";
				bookmark = bookmark + "lon='" + map.Lon + "' ";
				bookmark = bookmark + "lat='" + map.Lat + "'>";
				
				// layer info
				bookmark = bookmark + "<sections>";
				// active controls
				var inputcontrols = document.getElementsByTagName("input");
				for (var counter = 0; counter < inputcontrols.length; counter++) {
					var control = inputcontrols[counter];
					// active checkboxes
					if(control.type == "checkbox" && control.checked) {
						bookmark = bookmark + "<section name='" + control.name.substring("chklayer_".length) + "'>checked</section>";
					}
					// active radiobuttons
					else if(control.type == "radio" && control.checked) {
						bookmark = bookmark + "<section name='" + control.name.substring("rdblayer_".length) + "'>" + control.value + "</section>";
					}
				}
				// close layer info
				bookmark = bookmark + "</sections>";
				// close bookmark
				bookmark = bookmark + "</bookmark>";
				return bookmark;
			}
			
			function setBookmark(bookmark)
			{
				var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
				xmlDoc.async = "false";
				xmlDoc.loadXML(bookmark);				
								
				// map things				
				var map = getMap();
				map.MapWidth = xmlDoc.documentElement.selectSingleNode("/bookmark/@width").text;
				map.Lon = xmlDoc.documentElement.selectSingleNode("/bookmark/@lon").text;
				map.Lat = xmlDoc.documentElement.selectSingleNode("/bookmark/@lat").text;
								
				// layers,..
				var inputcontrols = document.getElementsByTagName("input");
				for (var counter = 0; counter < inputcontrols.length; counter++) {
					var control = inputcontrols[counter];
					var xpath = "/bookmark/sections/section[@name='" + control.name.substring("chklayer_".length) + "']";
					// alert(xpath);
					if(control.type == "checkbox") {
						// is checkbox active
						control.checked = (xmlDoc.documentElement.selectNodes(xpath).length > 0);
						//alert("control:" + control.name + " has checked=" + control.checked);
					}
					else if(control.type == "radio") {
						// is radio button checkbox active
						control.checked = (control.value == xmlDoc.documentElement.selectSingleNode(xpath).text);
						//alert("control:" + control.name + " with value:" + control.value + " has checked=" + control.checked);
					}
				}
				// layers need call to be refreshed
				layersRefresh();
			}
			//	STOP BOOKMARK FUNCTIONALITY
			//	START CALLBACK FUNCTIONALITY
			var mapGuideDigitizeFunctionPointer = null;
			function attachFunctionXYClick(functionpointer)
			{				
				mapGuideDigitizeFunctionPointer = functionpointer;
				getMap().digitizePoint();
			}
			var mapGuideSelectionChangedFunctionPointer = null;			
			function attachFunctionObjectClick(functionpointer) {				
				mapGuideSelectionChangedFunctionPointer = functionpointer;
			}
			//	STOP CALLBACK FUNCTIONALITY
			//	START TOOLBAR FUNCTIONALITY
			var TOOLBTN_ACTIVE		= "active";
			var TOOLBTN_DOWN		= "down";
			var TOOLBTN_INACTIVE	= "inactive";
			var TOOLBTN_NORMAL		= "normal";
			
			function toolbarChangeStatus(isBusy) {
				var buttonarray = document.getElementsByName("toolbar");
				
				toolbarButtonChangeStatus(buttonarray["Stop"], isBusy);
				toolbarButtonChangeStatus(buttonarray["Select"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["Pan"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["Distance"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["ZoomIn"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["ZoomOut"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["ZoomPrev"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["ZoomExt"], !isBusy);
				toolbarButtonChangeStatus(buttonarray["ZoomScale"], !isBusy);
			}
			function toolbarButtonChangeStatus(button, active) {
				button.disabled = !active;
				toolbarChangeButton(button, TOOLBTN_NORMAL);
			}						
			function toolbarOnClick(caller)
			{
			  var map = getMap();
			  
				switch(caller.id)
				{
					case "Stop":
						map.stop();
						break;
					case "Select":
						map.selectMode();
						break;
					case "Pan":
						map.panMode();
						break;						
					case "Distance":
						map.viewDistance(map.getUnits());
						break;
					case "ZoomIn":
						map.zoomInMode();
						break;
					case "ZoomOut":
						map.zoomOutMode();
						break;
					case "ZoomPrev":
						map.zoomPrevious();
						break;
					case "ZoomExt":
						map.zoomOut();
						break;
					case "ZoomScale":
						map.zoomScaleDlg();
						break;						
					case "LogOff":
						document.location = "login/Logout.aspx"
						break;
					default:
						alert("toolbar: unhandled click:'" + caller.id + "'");
				}
			}
			function toolbarOnMouseEnter(caller) {
				toolbarChangeButton(caller, TOOLBTN_ACTIVE);
			}
			function toolbarOnMouseLeave(caller) {
				toolbarChangeButton(caller, TOOLBTN_NORMAL);
			}
			function toolbarOnMouseDown(caller) {
				//*** Only act on left button.
				if (window.event.button != 1) {
					window.event.srcElement.src = toolbarImageSrc(window.event.srcElement.id, TOOLBTN_INACTIVE);
				}
				toolbarChangeButton(caller, TOOLBTN_DOWN);
			}
			function toolbarOnMouseUp(caller) {
				toolbarChangeButton(caller, TOOLBTN_ACTIVE);
			}
			function toolbarChangeButton(button, state) {
				if (button.disabled) {
					button.src = toolbarImageSrc(button.id, TOOLBTN_INACTIVE);
				}
				else {
					button.src = toolbarImageSrc(button.id, state);
				}
			}
			function toolbarImageSrc(buttonname, state) {
				return "media/toolbar/" + state + "/" + buttonname + ".gif";
			}
		//	START TOOLBAR FUNCTIONALITY
		</script>
		

		<!-- START MAPGUIDE EVENTS -->
		<!-- below the mapguide control events -->
		<!-- waring, not all parameter lists are correct! -->
		<!--
		<script language="javascript" event="onAddMapLayer(mapObject)" for="MGMainViewer">
			alert("onAddMapLayer");
		</script>
		<script language="javascript" event="onBeginLayout(mapObject)" for="MGMainViewer">
			alert("onBeginLayout");
		</script>
		-->
		<script language="javascript" event="onBusyStateChanged(mapObject, isBusy)" for="MGMainViewer">
			toolbarChangeStatus(isBusy);
			// alert("onBusyStateChanged");
		</script>
		<!--
		<script language="javascript" event="onDigitizedCircle(mapObject)" for="MGMainViewer">
			alert("onDigitizedCircle");
		</script>
		-->
		<script language="javascript" event="onDigitizedPoint(map, point)" for="MGMainViewer">								
			if(mapGuideDigitizeFunctionPointer!=null) {
				var latLonPt = map.mcsToLonLat(point.getX(),point.getY());
				
				// call the method which was attached
				mapGuideDigitizeFunctionPointer(latLonPt.getX(), latLonPt.getY());
				// reset the mode
				map.selectMode();
			}			
		</script>
		<!--
		<script language="javascript" event="onDigitizedPolygon(mapObject)" for="MGMainViewer">
			alert("onDigitizedPolygon");
		</script>
		<script language="javascript" event="onDigitizedPolyline(mapObject)" for="MGMainViewer">
			alert("onDigitizedPolyline");
		</script>
		<script language="javascript" event="onDigitizedRectangle(mapObject)" for="MGMainViewer">
			alert("onDigitizedRectangle");
		</script>
		-->
		<script language="javascript" event="onDoubleClickObject(mapObject)" for="MGMainViewer">
			//alert("onDoubleClickObject: key:" + mapObject.Key + " layer:" + mapObject.MapLayer.Name);
			var key = mapObject.Key;
			var layer = mapObject.MapLayer.Name;
			
			// iterate all layers, when details are specified, couple the double click on the 
			// screen specified,..
			<% 
			foreach(System.Xml.XmlNode node in mapLayers) { 
				System.Xml.XmlNode name = node.Attributes["name"];
				System.Xml.XmlNode details = node.Attributes["details"];
				System.Xml.XmlNode windowstate = node.Attributes["windowstate"];
				
				// do we have details?
				if(details != null) {
					// create the javascript if-statement
					%>
					if(layer == "<%= name.Value %>") {
					<%
					
					// what kind of javascript is our output?
					if(windowstate != null && windowstate.Value == "modal") {
						// arjen code to display a modal window,..
						%>												
							// alert("arjen code here!");
							var urlwin = "pinpoint/pinpoint.aspx?go=<%= details.Value %>&key=" + key +  "&layer=" + layer;
							top.showModelessDialog(urlwin,top,"dialogHeight: 500px; dialogWidth: 400px; dialogTop: 10px; dialogLeft: 10px; edge: Raised; center: No; help: No; resizable: Yes; status: Yes;");
						<% 
					} else {
						// the "NORMAL" popup
						%>
							openWindow("<%= details.Value %>?key=" + key +  "&layer=" + layer);
						<%
					}
					// close the javascript if-statement
					%>
					}
					<%					
				}
			} 
			%>
		</script>
		<!--
		<script language="javascript" event="onViewedDistanceEx(mapObject)" for="MGMainViewer">
			alert("onViewedDistanceEx");
		</script>
		<script language="javascript" event="onViewedDistance(mapObject)" for="MGMainViewer">
			alert("onViewedDistance");
		</script>
		<script language="javascript" event="onViewChanging(mapObject)" for="MGMainViewer">
			//alert("onViewChanging");
		</script>
		<script language="javascript" event="onViewChanged(mapObject)" for="MGMainViewer">
			// alert("onViewChanged");
		</script>
		-->
		<script language="javascript" event="onSelectionChanged(mapObject)" for="MGMainViewer">
			if(mapGuideSelectionChangedFunctionPointer != null) {
				var key = mapObject.Key;
				// the object on which we clicked didnt contain a key, so quit
				if(key == "" )
				{
					alert("no key!");
					return;
				}
				// we should start a new screen based on the settings for that layer in the xml!
				// this means that some clever javascript should be generated here,...
				alert("Select details url for layer:" + MapObject.MapLayer.Name);
				mapGuideSelectionChangedFunctionPointer(MapObject.MapLayer.Name, key);
				mapGuideSelectionChangedFunctionPointer = null;
			}
		</script>
		<!--
		<script language="javascript" event="OnReadyStateChange(mapObject)" for="MGMainViewer">
			//alert("OnReadyStateChange");
		</script>
		-->
		<script language="javascript" event="onMapLoaded(mapObject)" for="MGMainViewer">
			// alert("onMapLoaded");
			// Change the layer settings, according to the checkboxes
			layersRefresh();
		</script>
		<script language="javascript" event="onEndLayout(mapObject)" for="MGMainViewer">
			alert("onEndLayout");
		</script>
		<!-- STOP MAPGUIDE EVENTS -->
	</HEAD>
	<BODY 
<% if (Request.QueryString["bookmark"] != null) { %>
	onload='setBookmark("<%= Request.QueryString["bookmark"] %>")'>
<% } %>
	>
		<form method="post" runat="server" id="submitform">
			<table height="100%" width="100%">
				<tr>
					<td class="menubar" vAlign="top" width="180" height="100%">
						<!-- START menu -->
						<table width="100%">
							<tr>
								<td colspan="2" class="dropmenu">Layers <A onclick="swap('menu-layers')" href="#">
										<IMG src="media/controlbox-resize.gif" border="0"></A>
								</td>
							</tr>
							<tr>
								<td>
									<div class="menubaritems" id="menu-layers" style="overflow: no-scroll">
										<div  style="overflow: auto;height: 430px; width=160px">
										<table width="100%">
				<% foreach(System.Xml.XmlNode header in menuHeaderNodes) { %>
											<tr>
												<td colSpan="2">
													<small><%= header.Attributes["description"].Value %></small>
												</td>
											</tr>
											<% if(header.Attributes["type"].Value == "radiobutton") { %>
												<tr>
													<td>
														<input type="radio" name="rdblayer_<%= header.Attributes["headername"].Value %>"  value="" onclick="layersRefresh(this.form)" checked>
													</td>
													<td><small>Nothing</small></td>
												</tr>
											<% }
						if(header.Attributes["type"].Value != "filter") {
							foreach(System.Xml.XmlNode item in header.SelectNodes("legenda-item")) { %>
											<tr>
												<td>
													<% if(item.ParentNode.Attributes["type"].Value == "checkbox") { %>
													<input type="checkbox" name="chklayer_<%= item.Attributes["name"].Value %>"
													<%= item.Attributes["visible"].Value == "true" ? "CHECKED" : ""%>
													onclick="layersRefresh(this.form)"
													>
													<% } else if(item.ParentNode.Attributes["type"].Value == "radiobutton") { %>
													<input type="radio" name="rdblayer_<%= item.ParentNode.Attributes["headername"].Value %>"
													value="<%= item.Attributes["name"].Value %>"
													<%= item.Attributes["visible"].Value == "true" ? "CHECKED" : ""%>
													onclick="layersRefresh(this.form)"
													>
													<% } else throw new Exception("legenda-item type:" + item.ParentNode.Attributes["type"].Value + " not supported"); %>
												</td>
												<td><small><%= item.Attributes["description"].Value %></small></td>
											</tr>
					<%
							}
							// for each xmlnode
						}
						// is filter
						else {
							if(header.Attributes["database"] == null) throw new Exception("parameter database not defined");
							if(header.Attributes["query"] == null) throw new Exception("parameter query not defined");

							HawarIT.WebLibrary.OleDbDatabase db = new HawarIT.WebLibrary.OleDbDatabase(header.Attributes["database"].Value);
							System.Data.DataTable table = db.Query(header.Attributes["query"].Value);
							foreach(System.Data.DataRow row in table.Rows)
							{
								%>
											<tr>
												<td>
													<input type="checkbox" name="chklayer_filter_<%= row[0] %>" checked onclick="layersRefresh(this.form)" />
												</td>
												<td><small><%=  row[1] %></small></td>
											</tr>
								<%
							}
						}
						// is filter
					} %>
										</table>
										</div>
									</div>
								</td>
							</tr>
						</table>						
						<table width="100%">
							<tr>
								<td class="dropmenu" colSpan="2">Tasks <a onclick="swap('menu-tasks')" href="#">
										<img src="media/controlbox-resize.gif" border="0"></a>
								</td>
							</tr>
							<tr>
								<td>
									<div class="menubaritems" id="menu-tasks">
									  <a href="#" onclick="TaskObjectBrowser();"><FONT color=#ffff66>Object Browser</FONT></a>
<!--
										<br />
										<a href="#" onclick="TaskPinPoint();"><FONT color=#ffff66>Pinpoint</FONT></a>
-->
										<br />
										<a href="#" onclick="TaskCoordinates();"><FONT color=#ffff66>Coordinates</FONT></a>
										<!-- <br />
										<a href="#" onclick="TaskBookmark();"><FONT color=#ffff66>Bookmark</FONT></a> 
										-->
										<br />
										<a href="#" onclick="TaskSubpartReport();"><FONT color=#ffff66>Subpart Report</FONT></a> 
									</div>
								</td>
							</tr>
						</table>
						<% int count=0; // Provas for legenda verharding
						foreach(System.Xml.XmlNode colorLegenda in legendaColors) {count++; %>

						<table width="100%">
							<tr>
								<td class="dropmenu" colSpan="2">
									Legenda <%= colorLegenda.Attributes["name"].Value %><a onclick="swap('menu-legenda-<%= colorLegenda.Attributes["name"].Value %>')" href="#"><img src="media/controlbox-resize.gif" border="0"></a>
								</td>
							</tr>
							<tr>
								<td>
									<div class="menubaritems" id="menu-legenda-<%= colorLegenda.Attributes["name"].Value %>" style="overflow: no-scroll">
									<%if(count==2){ // provas for Legenda Verharding,  count=2,  it may be changed%>
									<div style="overflow:-moz-scrollbars-vertical;overflow-x:hidden;overflow-y:hidden;width=160px">
									<%}else{%>
									<div style="overflow:auto; height:420; width=160">
									<%}%>


											<!-- start items from the database -->
											<table width="100%" cellspacing="5px" cellpadding="0px" border="0">
											<% if(colorLegenda.Attributes["database"] != null || colorLegenda.Attributes["query"] != null) {
													if(colorLegenda.Attributes["database"] == null) throw new Exception("parameter database not defined");
													if(colorLegenda.Attributes["query"] == null) throw new Exception("parameter query not defined");
													HawarIT.WebLibrary.OleDbDatabase db = new HawarIT.WebLibrary.OleDbDatabase(colorLegenda.Attributes["database"].Value);
													System.Data.DataTable table = db.Query(colorLegenda.Attributes["query"].Value);
													foreach(System.Data.DataRow row in table.Rows)
													{
														%>
												<tr>
													<td style='background-color: #<%= row[0] %>; width: 15px; border-color: #000000; border-width: 1px;'>
														&nbsp;&nbsp;
													</td>
													<td><small><%= row[1] %></small></td>
												</tr>
														<%														
													}	
												}					
											%>
											<!-- stop items from the database -->
											<!-- start items from the config file -->
											<% foreach(System.Xml.XmlNode color in colorLegenda.SelectNodes("color")) { %>
												<tr>
													<td style='background-color: <%= color.InnerText %>; width: 15px; border-color: #000000; border-width: 1px;'>&nbsp;</td>
													<td><small><%= color.Attributes["description"].Value %>  (<%= color.Attributes["key"].Value %>)</small></td>
												</tr>
											<% } %>
											<!-- stop items from the database -->
											</table>
										</div></div>
								</td>
							</tr>
						</table>
						<% } %>
						<!-- STOP menu --></td>
					<td vAlign="top" width="100%">
						<!-- START toolbar -->
						<table height="25" cellSpacing="0" cellPadding="0" width="100%" border="0">
							<tr>
								<td class="toolbar" vAlign="middle" height="25">
									<center><IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="Select"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Selecteren" src="media/toolbar/inactive/Select.gif" name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="Pan"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)" alt="Pan" src="media/toolbar/inactive/Pan.gif"
											name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="Distance"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Measure Distance" src="media/toolbar/inactive/Distance.gif" name="toolbar">
										<IMG src="media/toolbar/Seperator.gif"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="ZoomIn"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Zoom In" src="media/toolbar/inactive/ZoomIn.gif" name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="ZoomOut"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)" alt="Zoom Out" src="media/toolbar/inactive/ZoomOut.gif"
											name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="ZoomPrev"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Zoom Back" src="media/toolbar/inactive/ZoomPrev.gif" name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="ZoomExt"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)" alt="Zoom Extends" src="media/toolbar/inactive/ZoomExt.gif"
											name="toolbar"> <IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="ZoomScale"
											onmouseleave="toolbarOnMouseLeave(this)" disabled onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Zoom Scale" src="media/toolbar/inactive/ZoomScale.gif" name="toolbar"> <IMG src="media/toolbar/Seperator.gif">
										<IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="Stop"
											onmouseleave="toolbarOnMouseLeave(this)" onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Stop" src="media/toolbar/normal/Stop.gif" name="toolbar"> <IMG src="media/toolbar/Seperator.gif">
										<IMG onmouseup="toolbarOnMouseUp(this)" onmousedown="toolbarOnMouseDown(this)" id="LogOff"
											onmouseleave="toolbarOnMouseLeave(this)" onclick="toolbarOnClick(this)" onmouseenter="toolbarOnMouseEnter(this)"
											alt="Log Off" src="media/toolbar/normal/LogOff.gif" name="toolBtn">
									</center>
								</td>
								<td class="logo" align="right" width="180"><IMG src="media/logo.png" border="0">
								</td>
							</tr>
						</table>
						<!-- STOP toolbar -->
						<hawarit:MapguideViewer id="MGMainViewer" runat="server" Url="mapguide/MapWindowXMLProcessor.aspx">
						</hawarit:MapguideViewer>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>