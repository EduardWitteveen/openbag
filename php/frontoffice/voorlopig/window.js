function setiframeurl(modaldialog, url) {
	//search for the iframe
	var iframe = null;
	for(var i=0; i < modaldialog.childNodes.length; i++) {
		var element = modaldialog.childNodes[i];
		if(element.nodeName == "IFRAME") {
			iframe = element;
		}
	}
	if(!iframe) {
		alert("iframe not found!");
	}
	//iframe.location.href = iframeurl;
	iframe.src = url;
}
function showmodaldialog(iframeurl) {
	var modaldialog = document.getElementById("modaldialog");
	setiframeurl(modaldialog, iframeurl);
	modaldialog.style.visibility = "visible";
}
function hidemodaldialog() {
	var modaldialog = document.getElementById("modaldialog");
	setiframeurl(modaldialog, "about:blank");
	modaldialog.style.visibility = "hidden";		
}

