<%@ Page language="c#" Codebehind="GrijsDetails.aspx.cs" AutoEventWireup="false" Inherits="qi02.details.GrijsDetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Grijs Details</title>
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
						Grijs
					</th>
				</tr>
				<tr>
					<td style="HEIGHT: 12px">Object ID:
					</td>
					<td style="HEIGHT: 12px"><asp:label id="lblHandle" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["HIT_CTR"].DefaultView[0], "handle") %>'></asp:label></td>
				</tr>
				<tr>
					<td style="HEIGHT: 1px">Type:
					</td>
					<td style="HEIGHT: 1px">
						<asp:dropdownlist id="ddlRType" runat="server"  DataMember="HIT_RTypes" DataValueField="RType" DataTextField="Description" DataSource="<%# dataSet %>" Width="200px" SelectedValue='<%# DataBinder.Eval(dataSet.Tables["HIT_CTR"].DefaultView[0], "Rtype") %>'>
						</asp:dropdownlist>
					</td>
				</tr>
				<tr>
					<td style="HEIGHT: 25px">Materiaal:
					</td>
					<td style="HEIGHT: 25px">
						<asp:dropdownlist id="ddlPavement" runat="server"  DataMember="HIT_Pavements" DataValueField="Pavement" DataTextField="Pavement" DataSource="<%# dataSet %>" Width="200px" SelectedValue='<%# DataBinder.Eval(dataSet.Tables["HIT_CTR"].DefaultView[0], "Pavement") %>'>
						</asp:dropdownlist>
					</td>
				</tr>
				<tr>
					<td>Oppervlakte:
					</td>
					<td><asp:label id="Label1" runat="server" Text='<%# DataBinder.Eval(dataSet.Tables["HIT_CTR"].DefaultView[0], "area") %>'></asp:label>
						m<sup>2</sup></td>
				</tr>
			</table>
			<hr>
			<div align="center">
				<asp:button id="btnCancel" runat="server" Text="Cancel" Width="100px"></asp:button>
				<asp:button id="btnSave" runat="server" Text="Save" Width="100px"></asp:button>
			</div>
			<hr>
		</form>
	</body>
</HTML>
