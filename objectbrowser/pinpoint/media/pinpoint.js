// DEZE FILE IS BEDOELD OM TE COMMUNICEREN TUSSEN PINPOINT APP EN PROJECT
// VAN PINPOINT NAAR PROJECT
function PinPoint_ChangeOnClickAction(value)
{
	attachFunctionXYClick(PinPoint_AddPoint);
}

function PinPoint_AddPoint(x,y)
{
	// alert("x:" + x + "y:" + y);
	PinPoint_openPinpoint("pinpointadd", x, y);
}

function PinPoint_ZoomTo(x,y,zoomfactor)
{
	var result
	var error;
	var MGMap = getMap();
	
	var latLonPt = MGMap.mcsToLonLat(x/1,y/1);
	MGMap.zoomScale(latLonPt.getY(),latLonPt.getX(), zoomfactor);
}
function PinPoint_RefreshPinpoints()
{
	var MGMap = getMap();
	var MLayerA = MGMap.getMapLayer("A");
	if(MLayerA == null) {
		alert("no map with name A");
		return;
	}
	var MLayerB = MGMap.getMapLayer("B");
	if(MLayerB == null) {
		alert("no map with name B");
		return;
	}
	var MLayerC = MGMap.getMapLayer("C");
	if(MLayerC == null) {
		alert("no map with name C");
		return;
	}
	var MLayerD = MGMap.getMapLayer("D");
	if(MLayerD == null) {
		alert("no map with name D");
		return;
	}
	var MLayerE = MGMap.getMapLayer("E");
	if(MLayerE == null) {
		alert("no map with name E");
		return;
	}
	var MLayerF = MGMap.getMapLayer("F");
	if(MLayerF == null) {
		alert("no map with name F");
		return;
	}
	var MLayerG = MGMap.getMapLayer("G");
	if(MLayerG == null) {
		alert("no map with name G");
		return;
	}
	var MLayerH = MGMap.getMapLayer("H");
	if(MLayerH == null) {
		alert("no map with name H");
		return;
	}
	
	var MLayerQ = MGMap.getMapLayer("Q");
	if(MLayerQ == null) {
		alert("no map with name Q");
		return;
	}
        // rebuild the stuff
	MLayerA.setRebuild(true);
        MLayerB.setRebuild(true);
        MLayerC.setRebuild(true);
        MLayerD.setRebuild(true);
        MLayerE.setRebuild(true);
        MLayerF.setRebuild(true);
        MLayerH.setRebuild(true);

	MLayerQ.setRebuild(true);
	MGMap.Refresh();
}

// VAN PROJECT NAAR PINPOINT
function PinPoint_openPinpoint(file, x, y) 
{
	//commentaar
	if((x == "n") || (y == "n"))
	{
		window.showModelessDialog("pinpoint/pinpoint.aspx?go=" + file,window,"dialogHeight: 500px; dialogWidth: 400px; dialogTop: 10px; dialogLeft: 10px; edge: Raised; center: No; help: No; resizable: Yes; status: Yes;");
	}
	else
	{
		window.showModelessDialog("pinpoint/pinpoint.aspx?x=" + x + "&y=" + y + "&go=" + file,window,"dialogHeight: 500px; dialogWidth: 400px; dialogTop: 10px; dialogLeft: 10px; edge: Raised; center: No; help: No; resizable: Yes; status: Yes;");
	}
}

