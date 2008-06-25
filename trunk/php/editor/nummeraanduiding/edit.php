<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>BEWERK NUMMERAANDUIDING</title>
	<link  type="text/css" rel="stylesheet" href="../style.css"> </link>
	<script language="JavaScript">
		function init() {
			changewoonplaats();
		}
		function changewoonplaats() {
			var openbareruimte = document.getElementById("openbareruimte");
			// change the woonplaats select, so it reads the correct woonplaats
			var index = openbareruimte.selectedIndex;
			// select.value
			var text = openbareruimte.options[index].text;
			// remove the stuff and the (
			var woonplaatsnaam = text.substring(text.indexOf('(') + 1);
			woonplaatsnaam = woonplaatsnaam.substring(0, woonplaatsnaam.indexOf(')'));
			
			// iterate over the options of the other select and set the 
			var woonplaats = document.getElementById("woonplaats");
			
			for(var i=0;i < woonplaats.options.length;i++){
				// alert(woonplaats.options[i].text);
				if(woonplaatsnaam == woonplaats.options[i].text) {
					woonplaats.selectedIndex = i;
				}
			}
		}
		var _giswindow = null;
		function openGisWindow(url) {
			if (_giswindow && !_giswindow.closed && _giswindow.location) {				
				if(_giswindow.location.href != url) {
					//alert('change url in window from:' + _giswindow.location.href  + ' to:' + url);
					// change the url back to our gisviewer,..
					//_giswindow.location.href = url;
				}
			}
			else {
				//alert('open window new window:' + url);
				_giswindow = window.open(url,'giswindow');
				if (!_giswindow.opener) {
					_giswindow.opener = self;
				}
			}
		}
		// seperator = ,		
		function getGisPos(control) {
			openGisWindow("../gis/gis.php");
			while(!_giswindow.window.getPosXY && confirm("Een moment geduld totdat de pagina is geladen,..."));
			if(window.focus) {
				_giswindow.window.focus();
			}
			_giswindow.window.getPosXY(control);
		}
		function showGisPos(x, y) {
			openGisWindow("../gis/gis.php");
			while(!_giswindow.window.getPosXY && confirm("Een moment geduld totdat de pagina is geladen,..."));
			_giswindow.window.showPosXY(x, y);
			if(!_giswindow) {
				alert("No giswindow found")
			}
			else if(window.focus) {
				_giswindow.focus();
			}
			else {
				alert("Could not send the focus on the Gis window")
			}
		}
	</script>
</head>
<?php
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	$connection = openConnection();	
	// if we have an id,..
	if(!empty($_REQUEST['id'])) {
		$_REQUEST['id'] = str_replace("'", "",  $_REQUEST['id']);
		// retrieve the data from the current record
		$sql = "SELECT\n";
		$sql .= "  VB_NUMMERAANDUIDING.GID,\n";		
		$sql .= "  VB_NUMMERAANDUIDING.STARTDATE,\n";
		$sql .= "  VB_NUMMERAANDUIDING.AUTHENTIC,\n";
		$sql .= "  VB_NUMMERAANDUIDING.RESEARCH,\n";		
		$sql .= "  VB_NUMMERAANDUIDING.ACCEPTED,\n";
		$sql .= "  VB_NUMMERAANDUIDING.AUTHOR,\n";
		$sql .= "  VB_NUMMERAANDUIDING.REASONFORCHANGE,\n";
		$sql .= "  VB_NUMMERAANDUIDING.FEEDBACK,\n";
		$sql .= "  VB_NUMMERAANDUIDING.DOCUMENTID,\n";
		$sql .= "  VB_NUMMERAANDUIDING.DOCUMENTDATE,\n";		
  		$sql .= "  VB_NUMMERAANDUIDING.HUISNUMMER,\n";
  		$sql .= "  VB_NUMMERAANDUIDING.HUISLETTER,\n";
  		$sql .= "  VB_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,\n";
  		$sql .= "  VB_NUMMERAANDUIDING.POSTCODE,\n";
  		$sql .= "  VB_NUMMERAANDUIDING.GEOM.sdo_point.X AS X,\n";
  		$sql .= "  VB_NUMMERAANDUIDING.GEOM.sdo_point.Y AS Y,\n";
  		$sql .= "  VB_OPENBARERUIMTE.LABEL || '(' || OR_WOONPLAATS.LABEL || ')' AS OPENBARERUIMTE,\n";
		$sql .= "  VB_NUMMERAANDUIDING.OPENBARERUIMTEID,\n";
  		$sql .= "  NA_WOONPLAATS.LABEL AS WOONPLAATS,\n";
		$sql .= "  VB_NUMMERAANDUIDING.WOONPLAATSID\n";
		$sql .= "FROM VB_NUMMERAANDUIDING\n";
		$sql .= "-- de woonplaats van de plek\n";
		$sql .= "LEFT OUTER JOIN VB_WOONPLAATS NA_WOONPLAATS\n";
		$sql .= "ON VB_NUMMERAANDUIDING.WOONPLAATSID = NA_WOONPLAATS.GID\n";
		$sql .= "AND NA_WOONPLAATS.EXPIREDATE = 99999999999999\n";
		$sql .= "-- de straat\n";
		$sql .= "LEFT OUTER JOIN VB_OPENBARERUIMTE\n";
		$sql .= "ON VB_NUMMERAANDUIDING.OPENBARERUIMTEID = VB_OPENBARERUIMTE.GID\n";
		$sql .= "AND VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
		$sql .= "-- de woonplaats van de straat\n";
		$sql .= "LEFT OUTER JOIN VB_WOONPLAATS OR_WOONPLAATS\n";
		$sql .= "ON VB_OPENBARERUIMTE.WOONPLAATSID = OR_WOONPLAATS.GID\n";
		$sql .= "AND OR_WOONPLAATS.EXPIREDATE = 99999999999999\n";
		$sql .= "WHERE VB_NUMMERAANDUIDING.GID = '${_REQUEST['id']}'\n";
		$sql .= "ORDER BY VB_NUMMERAANDUIDING.STARTDATE DESC\n";
		$records = getRecords($connection, $sql);
		if(sizeof($records) <1) {
			die("<pre>not records for sql:\n$sql");
		}
		$record = $records[0];

		$huisnummer = $record['HUISNUMMER'];	
		$huisletter = $record['HUISLETTER'];	
		$huisnummertoevoeging = $record['HUISNUMMERTOEVOEGING'];	
		$postcode = $record['POSTCODE'];	
		$x = $record['X'];
		$y = $record['Y'];
		$openbareruimte = $record['OPENBARERUIMTE'];
		$openbareruimteid = $record['OPENBARERUIMTEID'];
		$woonplaats = $record['WOONPLAATS'];
		$woonplaatsid = $record['WOONPLAATSID'];
		$startdate = $record['STARTDATE'];
		$reasonforchange = $record['REASONFORCHANGE'];
		$author = $record['AUTHOR'];
		$feedback = $record['FEEDBACK'];
		$authentic = $record['AUTHENTIC'];
		$research = $record['RESEARCH'];
		$accepted = $record['ACCEPTED'];
		$documentid = $record['DOCUMENTID'];
		$documentdate = $record['DOCUMENTDATE'];
		$gid = $record['GID'];
		//print_r($record);
	}	
	else {
		$huisnummer = '';
		$huisletter = '';
		$huisnummertoevoeging = '';
		$postcode = '';
		$x = '';
		$y = '';
		$openbareruimte = '';
		$openbareruimteid = '';
		$woonplaats = '';
		$woonplaatsid = '';
		$startdate = '';
		$reasonforchange = '';
		$author = '';
		$feedback = '';
		$authentic = '';
		$research = '';
		$accepted = '';
		$documentid = '';
		$documentdate = '';
		$gid = '';
	}	
	// do not list the geom field, will freeze!
	$sql = "SELECT gid, label\n";
	$sql .= "FROM VB_WOONPLAATS\n";
	$sql .= "WHERE expiredate = 99999999999999\n";	
	$sql .= "ORDER BY label\n";
	$woonplaatsrecords = getRecords($connection, $sql);	

	// do not list the geom field, will freeze!
	$sql = "SELECT VB_OPENBARERUIMTE.GID, VB_OPENBARERUIMTE.LABEL || '(' || VB_WOONPLAATS.LABEL || ')' AS LABEL\n";
	$sql .= "FROM VB_OPENBARERUIMTE\n";
	$sql .= "LEFT OUTER JOIN VB_WOONPLAATS\n";
	$sql .= "ON VB_WOONPLAATS.GID = VB_OPENBARERUIMTE.WOONPLAATSID\n";
	$sql .= "AND VB_WOONPLAATS.EXPIREDATE = 99999999999999\n";
	$sql .= "WHERE VB_OPENBARERUIMTE.EXPIREDATE = 99999999999999\n";
	$sql .= "ORDER BY VB_OPENBARERUIMTE.LABEL, VB_WOONPLAATS.LABEL\n";
	$openbareruimterecords = getRecords($connection, $sql);		
?>
<body onload="init();">
	<form method="post" action="edit.action.php">
	<input type="hidden" name="id" value="<?php echo($gid) ?>">
	<input type="hidden" name="returnpage" value="<?php echo(getPreviousPageValue()) ?>">
	<?php echo($gid) ?>
	<hr />
	<table>
		<tr>
			<th></th>
			<th></th>
			<th>Huidige gegevens</th>
			<th>Nieuwe gegevens</th>
			<th></th>
		</tr>
		<tr>
			<th>Gegevens:</th>
			<th>Openbareruimte:</th>
			<td><?php echo($openbareruimte) ?></td>
			<td>
				<select name="OPENBARERUIMTEID" id="openbareruimte" onchange="changewoonplaats();">
					<!-- value: '<?php echo($openbareruimteid); ?>' -->
					<option value="" <?php 
						if($openbareruimteid == "") {
							echo('selected="selected"');
						}
					?>>()</option>
					<?php
						foreach($openbareruimterecords as $ruimte) {
					?>					
						<option value="<?php 
							echo($ruimte['GID']); 
						?>" <?php 
							if($ruimte['GID'] == $openbareruimteid ) {
								echo('selected="selected"');
							}
						?>><?php 
							echo($ruimte['LABEL']); 
						?></option>
					<?php
						}
					?>				
				</select>
			</td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!-- Gegevens --></th>
			<th>huisnummer:</th>
			<td><?php echo($huisnummer) ?></td>
			<td><input type="text" name="HUISNUMMER" value="<?php echo($huisnummer) ?>" /></td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!-- Gegevens --></th>
			<th>huisletter:</th>
			<td><?php echo($huisletter) ?></td>
			<td><input type="text" name="HUISLETTER" value="<?php echo($huisletter) ?>" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<th><!-- Gegevens --></th>
			<th>huisnummertoevoeging:</th>
			<td><?php echo($huisnummertoevoeging) ?></td>
			<td><input type="text" name="HUISNUMMERTOEVOEGING" value="<?php echo($huisnummertoevoeging) ?>" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<th><!-- Gegevens --></th>
			<th>postcode:</th>
			<td><?php echo($postcode) ?></td>
			<td><input type="text" name="POSTCODE" value="<?php echo($postcode) ?>" /></td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!-- Gegevens --></th>
			<th>locatie:</th>
			<td><?php echo("$x,$y") ?><a href="javascript:showGisPos(<?php echo("$x,$y") ?>);"><img src="../image/detail.gif"></a></td>
			<td>
				<input type="text" name="LOCATIE_X_Y" value="<?php echo("$x,$y") ?>" />
				<button onclick="getGisPos(this.form.LOCATIE_X_Y);" style="width:20px;">...</button>
			</td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!--Gegevens--></th>
			<th>Woonplaats:</th>
			<td><?php echo($woonplaats) ?></td>
			<td>
				<select name="WOONPLAATSID" id="woonplaats">
					<!-- value: '<?php echo($woonplaatsid); ?>' -->
					<option value="" <?php 
						if($woonplaatsid == "") {
							echo('selected="selected"');
						}
					?>></option>
					<?php
						foreach($woonplaatsrecords as $plaats) {
					?>					
						<option value="<?php 
							echo($plaats['GID']); 
						?>" <?php 
							if($plaats['GID'] == $woonplaatsid ) {
								echo('selected="selected"');
							}
						?>><?php 
							echo($plaats['LABEL']); 
						?></option>
					<?php
						}
					?>				
				</select>
			</td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th>Veranderingen</th>
			<th>Datum:</th>
			<td><?php echo($startdate) ?></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<th><!-- Veranderingen --></th>
			<th>Reden:</th>
			<td><?php echo($reasonforchange) ?></td>
			<td><input type="text" name="REASONFORCHANGE" /></td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!-- Veranderingen --></th>
			<th>Auteur:</th>
			<td><?php echo($author) ?></td>
			<td><?php echo($_SERVER['REMOTE_USER']) ?></td>
			<td></td>
		</tr>
		<tr>
			<th><!-- Veranderingen --></th>
			<th>Terugmelding:</th>
			<td><?php echo($feedback) ?></td>
			<td></td>
			<td></td>
		</tr>		
		<tr>
			<th>Metadata:</th>
			<th>Authentiek:</th>
			<td><?php echo($authentic) ?></td>
			<td><input type="checkbox" name="AUTHENTIC" value="Y" <?php 
				if($authentic == 'Y') {
					echo('checked="checked"');
				}
			?> /></td>
			<td></td>
		</tr>
		<tr>
			<th><!--Metadata:--></th>
			<th>Onderzoek:</th>
			<td><?php echo($research) ?></td>
			<td><input type="checkbox" name="RESEARCH" value="Y" <?php 
				if($research == 'Y') {
					echo('checked="checked"');
				}
			?> /></td>
			<td></td>
		</tr>
		<tr>
			<th><!--Metadata:--></th>
			<th>Goedgekeurd:</th>
			<td><?php echo($accepted) ?></td>
			<td><input type="checkbox" name="ACCEPTED" value="Y" <?php 
				if($accepted == 'Y') {
					echo('checked="checked"');
				}
			?> /></td>
			<td></td>
		</tr>
		<tr>
			<th>Document</th>
			<th>Id:</th>
			<td><?php echo($documentid) ?></td>
			<td><input type="text" name="DOCUMENTID" value="<?php echo($documentid) ?>" /></td>
			<td></td>
		</tr>
<!--		
		<tr>
			<th>< ! - - Document - - ></th>
			<th>Datum:</th>
			<td><?php echo($documentdate) ?></td>
			<td><input type="text" name="DOCUMENTDATE" value="<?php echo($documentdate) ?>" /></td>
			<td></td>
		</tr>
-->		
	</table>
	
	<hr />
	<br />
	<center>
	<input type="reset" name="action-reset" value="Beginwaarden">
	<input type="submit" name="action-cancel" value="Annuleren">
	<input type="submit" name="action-change" value="Veranderen">
	<?php 
	if(isset($record)) {
	?>
	<input type="submit" name="action-delete" value="Verwijderen">
	<?php 
	}
	?>	
	</center>
	</form>
	<br />
	<hr />
	<?php 
	if(isset($record)) {
	?>
	<table>
		<!-- header -->
		<tr>
		<?php
			foreach($record as $key => $value) {
				if($key != 'GID' && $key != 'WOONPLAATSID' && $key != 'EXPIREDATE') {
		?>
			<th><?php echo($key) ?></th>
		<?php
				}
			}
		?>
		</tr>
		<!-- rows -->
		<?php
		foreach($records as $r) {
		?>
		<tr>				
		<?php
			foreach($r as $key => $value) {
				if($key != 'GID' && $key != 'WOONPLAATSID'  && $key != 'EXPIREDATE') {
		?>
				<td>
					<?php echo($value) ?>
				</td>
		<?php
				}
			}
		?>				
		</tr>
		<?php
		}
		?>
	</table>
	<?php 
	}
	?>
</body>
</html>	
