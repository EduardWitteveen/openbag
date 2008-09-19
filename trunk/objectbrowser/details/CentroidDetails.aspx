<%@ Page language="c#" Codebehind="CentroidDetails.aspx.cs" AutoEventWireup="false" Inherits="qi02.details.CentroidDetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>CentroidDetails</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="../media/style.css" type="text/css" rel="stylesheet">
		<%
		// refresh the layer that has been changed
		if (this.IsPostBack ) 
		{
	%>
		<script>
			window.opener.refreshLayer("<%= Request.Params["layer"] %>");
			window.close();
		</script>
		<%
		}	
	%>
	</HEAD>
	<body>
		<form id="Form1" method="post" runat="server">
			<p><asp:label id="Label1" runat="server">Bewerk centroid:</asp:label><asp:label id=lblHandle runat="server" Text='<%# DataBinder.Eval(centroid, "Tables[HIT_CTR].DefaultView.[0].Handle") %>'>
				</asp:label></p>
			<table width="100%">
				<tr>
					<th>
					</th>
					<th>
						Oude waarde:</th>
					<th>
						Nieuwe waarde:</th></tr>
				<tr>
					<th style="HEIGHT: 17px">
						Verhardings soort:</th>
					<td style="HEIGHT: 17px"><asp:label id=lblVerhardingOrgineel runat="server" Text='<%# DataBinder.Eval(centroid, "Tables[HIT_CTR].DefaultView.[0].OrgPavement") %>'>
						</asp:label></td>
					<td style="HEIGHT: 17px"><asp:dropdownlist id=ddVerharding runat="server" SelectedValue='<%# DataBinder.Eval(centroid, "Tables[HIT_CTR].DefaultView.[0].Pavement") %>' DataSource="<%# centroid %>" DataMember="OrgPavements_" DataTextField="cvha_omschrijving" Width="156px">
						</asp:dropdownlist></td>
				</tr>
				<tr>
					<th>
						Weg type:</th>
					<td><asp:label id=lblRtypeOrgineel runat="server" Text='<%# DataBinder.Eval(centroid, "Tables[HIT_CTR].DefaultView.[0].ORGRTYPE") %>'>
						</asp:label></td>
					<td><asp:dropdownlist id=ddRtype runat="server" SelectedValue='<%# DataBinder.Eval(centroid, "Tables[HIT_CTR].DefaultView.[0].RType") %>' DataSource="<%# centroid %>" DataMember="OrgRTypes_" DataTextField="Rtype" Width="156px" DataValueField="Rtype">
						</asp:dropdownlist></td>
				</tr>
			</table>
			<hr>
			<center><asp:button id="btnSave" runat="server" Text="Save"></asp:button></center>
		</form>
	</body>
</HTML>
