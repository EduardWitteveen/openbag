<%@ Page language="c#" Codebehind="GreenDetails.aspx.cs" AutoEventWireup="false" Inherits="qi02.details.GreenDetails" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>GreenDetails</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="../media/style.css" type="text/css" rel="stylesheet">
	</HEAD>
	<body MS_POSITIONING="flowlayout">
		<form id="Form1" method="post" runat="server">
			Handle: &nbsp;
			<asp:Label id="lblHandle" runat="server"></asp:Label>
			<table align="center">
				<tr>
					<td height="50">
					</td>
					<td></td>
				</tr>
				<tr>
					<td>KWO:</td>
					<td><asp:dropdownlist id="drpKWO" runat="server"></asp:dropdownlist></td>
				</tr>
				<% if(g_point || g_line || g_area){%>
				<tr>
					<td>GRType:</td>
					<td>
						<asp:DropDownList id="drpGRType" runat="server"></asp:DropDownList></td>
				</tr>
				<tr>
					<td>VAK:</td>
					<td>
						<asp:TextBox id="txtVak" runat="server" Width="80px"></asp:TextBox></td>
				</tr>
				<% } %>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><asp:button id="btnSave" runat="server" Text="Save"></asp:button></td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
