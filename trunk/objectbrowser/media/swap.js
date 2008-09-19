
defaultStatus="Hawar Information Technology"

var pressed;
var curbtn;

function swap(id)
{	
	if (!curbtn)
	{
		curbtn = id;
		swapLayers(curbtn);
	}
	else if (curbtn == id)
	{
		swapLayers(id);
		curbtn=111;
	}
	else if ((curbtn != id) && (curbtn != 111))
	{
		swapLayers(id);
		curbtn = id;
	}
	else if (curbtn == 111)
	{
		swapLayers(id);
		curbtn = id;
	}
}

function swapOnly(id,how)
{	
	if((how == 'large') || (how == 'small'))
	{
		onLayer(id,how);
	}
	else if (how == 'swap')
	{
		swapLayer(id);
	}
	else
	{}
}


var origWidth, origHeight;

if (document.layers) 
{
	origWidth = window.innerWidth; origHeight = window.innerHeight;
	window.onresize = function() { if (window.innerWidth != origWidth || window.innerHeight != origHeight) history.go(0); }
}

var cur_lyr;
var visible;
function swapLayers(id) 
{
	var lyr = getElemRefs(id);
	if((cur_lyr == id) && (lyr.css.visibility == "visible")) 
	{
		hideLayer(cur_lyr);
		lyr.css.height = "8px";
	}
	else if((cur_lyr == id) && (lyr.css.visibility == "hidden"))
	{
		showLayer(cur_lyr);
		lyr.css.height = "auto";
	}
	else
	{
		if (cur_lyr) hideLayer(cur_lyr);
		showLayer(id);
		cur_lyr = id;
	}
}

function swapLayer(id) 
{
	var lyr = getElemRefs(id);
	if(lyr.css.visibility == "visible")
	{
		hideLayer(id);
		lyr.css.height = "8px";
	}
	else if(lyr.css.visibility == "hidden")
	{
		showLayer(id);
		lyr.css.height = "auto";
	}
}

function onLayer(id,format) 
{
	var lyr = getElemRefs(id);
	showLayer(id);
	if(format == 'large')
	{
		lyr.css.height = "270px";
	}
	else if (format == 'small')
	{
		lyr.css.height = "70px";
	}
}

function showLayer(id) 
{
	var lyr = getElemRefs(id);
	if (lyr && lyr.css) 
	{
		lyr.css.visibility = "visible";
		lyr.css.height = "auto";
	}
}

function hideLayer(id) 
{
	var lyr = getElemRefs(id);
	if (lyr && lyr.css)
	{
		lyr.css.visibility = "hidden";
		lyr.css.height = "8px";
	}
}

function getElemRefs(id) 
{
	var el = (document.getElementById)? document.getElementById(id): (document.all)? document.all[id]: (document.layers)? document.layers[id]: null;
	if (el) el.css = (el.style)? el.style: el;
	return el;
}