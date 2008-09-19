<%@ Page language="c#" Codebehind="GroenDetails.aspx.cs" AutoEventWireup="false" Inherits="qi02.details.GroenDetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
  <HEAD>
		<title>Groen Details</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="../media/style.css" type="text/css" rel="stylesheet">
  </HEAD>
	<body>
		<form id="Form1" method="post" runat="server">
			<table width="100%" border="0">
				<tr>
					<th colspan="2">
						Groen
					</th>
				</tr>
				<tr>
					<td>Object ID:
					</td>
					<td><asp:label id="lblHandle" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["HIT_GVC"].DefaultView[0], "handle") %>'></asp:label></td>
				</tr>
				<tr>
					<td>Type:
					</td>
					<td>
						<asp:dropdownlist id="ddlGrType" runat="server" SelectedValue='<%# DataBinder.Eval(dataSet.Tables["HIT_GVC"].DefaultView[0], "grtype") %>' DataMember="GBGRTYP" DataValueField="grtype" DataTextField="om_grtyp" DataSource="<%# dataSet %>" Width="200px">
						</asp:dropdownlist>
					</td>
				</tr>
				<tr>
					<td>Oppervlakte:
					</td>
					<td><asp:label id="Label1" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["HIT_GVC"].DefaultView[0], "hoeveelheid") %>'></asp:label> m<sup>2</sup></td>
				</tr>
			</table>
			<hr >
			<div align="center">
				<asp:button id="btnCancel" runat="server" Text="Cancel" Width="100px"></asp:button>
				<asp:button id="btnSave" runat="server" Text="Save" Width="100px"></asp:button>
			</div>
			<hr >
		</form>
	</body>
</HTML>
