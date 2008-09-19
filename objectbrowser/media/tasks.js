function TaskPinPoint()
{
	// method can be found in pinpoint.js
	PinPoint_openPinpoint('pinpointmain','n','n');
}


function TaskCoordinatesShow(x, y)
{
	alert("Found the following Coordinates:\nX: " + x + "\nY: " + y);
}


function TaskCoordinates()
{
	attachFunctionXYClick(TaskCoordinatesShow);
}


function TaskBookmark()
{
  var bookmark = getBookmark();
  
  bookmark = prompt("Below is the current book mark. This bookmark can be changed to navigate to an other position.", bookmark);
  
  if (bookmark)
  {
    //*** Not pressed cancel.
    setBookmark(bookmark);
  }
}


function TaskObjectBrowser()
{
  //*** Open Object Browser in new window.
  window.open("obrowser/index.asp", "ObjectBrowser", "toolbar=no,directories=no,status=no,scrollbars=no,menubar=no,location=no,resizable=yes,width=800,height=644");
}


function TaskSubpartReport()
{
  //*** Method can be found in subpartreport.js
  SubpartReport_open('subpartreportmain','n','n');
}