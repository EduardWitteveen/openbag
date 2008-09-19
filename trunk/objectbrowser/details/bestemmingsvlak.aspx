<%@ Page language="c#" Codebehind="bestemmingsvlak.aspx.cs" AutoEventWireup="false" Inherits="qi02.details.bestemmingsvlak" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>bestemmingsvlak</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="./../media/style.css" type="text/css" rel="stylesheet">
	</HEAD>
	<body>
		<form id="Form1" method="post" runat="server">
			<hr>
			<h3>Details van bestemmings vlak</h3>
			<hr>
			<table width="100%" border="0">
				<tr>
					<td style="WIDTH: 196px">Plangebied idn</td>
					<td><asp:textbox id="txtPlanGebiedIdn" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["bestemmingsvlak"].DefaultView[0], "plangebied_idn") %>' Width="200px" Enabled="False"></asp:textbox></td>
				</tr>
				<tr>
					<td style="WIDTH: 196px">Plangebied naam</td>
					<td><asp:textbox id="txtPlangebiedNaam" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["bestemmingsvlak"].DefaultView[0], "plangebied_naam") %>' Width="200px" Enabled="False"></asp:textbox></td>
				</tr>
				<tr>
					<td style="WIDTH: 196px">Bestemming idn</td>
					<td><asp:textbox id="txtBestemmingIdn" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["bestemmingsvlak"].DefaultView[0], "bestemming_idn") %>' Width="200px" Enabled="False" ReadOnly="True"></asp:textbox></td>
				</tr>
				<tr>
					<td style="WIDTH: 196px; HEIGHT: 22px">Bestemming naam</td>
					<td style="HEIGHT: 22px"><asp:dropdownlist id=ddlBestemmingNaam runat="server" Width="200px" DataSource="<%# dataSet %>" DataTextField="naam" DataValueField="naam" DataMember="bestemmings_namen" SelectedValue='<%# DataBinder.Eval(dataSet.Tables["bestemmingsvlak"].DefaultView[0], "bestemmings_naam") %>'></asp:dropdownlist></td>
				</tr>
				<tr>
					<td style="WIDTH: 196px">Categorie</td>
					<td><asp:textbox id="txtBestemmingCategorie" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["bestemmingsvlak"].DefaultView[0], "categorie") %>' Width="200px"></asp:textbox></td>
				</tr>
				<tr>
					<td align="right" colSpan="2">
						<hr>
						<asp:button id="btnCancel" runat="server" Width="100px" Text="Cancel"></asp:button>&nbsp;
						<asp:button id="btnSave" runat="server" Width="100px" Text="Save"></asp:button>&nbsp;
						<hr>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
