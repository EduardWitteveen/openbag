// DEZE FILE IS BEDOELD OM TE COMMUNICEREN TUSSEN SUBPARTREPORT APP EN PROJECT
// SUBPARTREPORT functions

function subpartreport_ZoomTo(x,y,zoomfactor)
{
	var result
	var error;
	var MGMap = getMap();
	
	var latLonPt = MGMap.mcsToLonLat(x/1,y/1);
	MGMap.zoomScale(latLonPt.getY(),latLonPt.getX(), zoomfactor);
}


function SubpartReport_open(file, x, y) 
{
	//commentaar
	if((x == "n") || (y == "n"))
	{
		window.showModelessDialog("subpartreport/subpartreport.aspx?go=" + file,window,"dialogHeight: 500px; dialogWidth: 400px; dialogTop: 10px; dialogLeft: 10px; edge: Raised; center: No; help: No; resizable: Yes; status: Yes;");
	}
	else
	{
		window.showModelessDialog("subpartreport/subpartreport.aspx?x=" + x + "&y=" + y + "&go=" + file,window,"dialogHeight: 500px; dialogWidth: 400px; dialogTop: 10px; dialogLeft: 10px; edge: Raised; center: No; help: No; resizable: Yes; status: Yes;");
	}
}

