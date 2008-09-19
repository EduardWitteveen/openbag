<%@ Page language="c#" Codebehind="pinpointtext.aspx.cs" AutoEventWireup="false" Inherits="QI02.pinpoint.pinpointtext" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>pinpoint_add</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<LINK href="media/pinpoint.css" type="text/css" rel="stylesheet">
	</HEAD>
	<body>
		<form id="Form1" method="post" runat="server">
			<table width="100%">
				<tr>
					<td class="heading">Pinpoint Text</td>
				</tr>
				<tr>
					<td class="content">
						<table width="100%">
							<tr>
								<td>1.</td>
								<td>Author</td>
								<td><asp:textbox id="txtOriginator" runat="server" CssClass="inputnonedit" Width="144px" ReadOnly="True"
										BackColor="#EEEEEE"></asp:textbox></td>
							</tr>
							<tr>
								<td>2.</td>
								<td colSpan="2">Text:</td>
							</tr>
							<% if(mode == "add") { %>
							<tr>
								<td></td>
								<td>Status type:</td>
								<td><asp:dropdownlist id="drpStatus" runat="server" Width="144px" DataValueField=" to_user" DataTextFormatString=" to_status"></asp:dropdownlist></td>
							</tr>
							<% } %>
							<tr>
								<td></td>
								<td colSpan="2"><asp:textbox id="txtComments" runat="server" CssClass="inputbigedit" Width="296px" TextMode="MultiLine"
										Height="96px"></asp:textbox></td>
							</tr>
							<tr>
								<td>3.</td>
								<td><asp:button id="butSubmit" runat="server" CssClass="button" Width="144px" Text="Save"></asp:button></td>
								<td><asp:button id="butCancel" tabIndex="1" runat="server" CssClass="button" Width="144px" Text="Cancel"></asp:button></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
