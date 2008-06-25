<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
	<title>BEWERK OPENBARERUIMTE</title>
	<link  type="text/css" rel="stylesheet" href="../style.css"> </link>
	<script language="JavaScript">
	</script>
</head>
<?php
	include_once '../include/database.php';
	include_once '../include/util.php';
	
	$connection = openConnection();	
	// if we have an id,..
	if(!empty($_REQUEST['id'])) {
		// retrieve the data from the current record
		$sql = "SELECT VB_OPENBARERUIMTE.*, VB_WOONPLAATS.label AS WOONPLAATSLABEL\n";
		$sql .= "FROM VB_OPENBARERUIMTE\n";		
		$sql .= "LEFT OUTER JOIN VB_WOONPLAATS\n";
		$sql .= "ON VB_OPENBARERUIMTE.woonplaatsid = VB_WOONPLAATS.gid\n";
		$sql .= "AND VB_WOONPLAATS.expiredate = 99999999999999\n";
		$sql .= "WHERE VB_OPENBARERUIMTE.gid = '${_REQUEST['id']}'\n";
		$sql .= "ORDER BY VB_OPENBARERUIMTE.startdate DESC\n";				
		$records = getRecords($connection, $sql);
		if(sizeof($records) <1) {
			die("<pre>not records for sql:\n$sql");
		}
		$record = $records[0];
		$label = $record['LABEL'];	
		$woonplaatslabel = $record['WOONPLAATSLABEL'];
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
	}	
	else {
		$gid = '';
		$label = '';
		$woonplaatslabel = '';
		$woonplaatsid = '';
		$startdate = '';
		$reasonforchange = '';
		$author = '';
		$feedback = '';
		$authentic = '';
		$research = '';
		$accepted ='';
		$documentid = '';
		$documentdate = '';
	}
	
	// do not list the geom field, very large!!
	$sql = "SELECT gid, label\n";
	$sql .= "FROM VB_WOONPLAATS\n";
	$sql .= "WHERE expiredate = 99999999999999\n";	
	$sql .= "ORDER BY label\n";
	$woonplaats = getRecords($connection, $sql);	
?>
<body>
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
			<th>Gegevens</th>
			<th>Naam:</th>
			<td><?php echo($label) ?></td>
			<td><input type="text" name="LABEL" value="<?php echo($label) ?>" /></td>
			<td style="color:red;">*</td>
		</tr>
		<tr>
			<th><!--Gegevens--></th>
			<th>Woonplaats:</th>
			<td><?php echo($woonplaatslabel) ?></td>
			<td>
				<select name="WOONPLAATSID">
					<?php
						foreach($woonplaats as $plaats) {
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
