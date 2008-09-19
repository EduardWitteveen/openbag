<%@ Page language="c#" Codebehind="pinpointmain.aspx.cs" AutoEventWireup="false" Inherits="QI02.pinpoint.pinpointmain" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Pinpoint application</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<script language="javascript" src="media/pinpoint.js"></script>
		<LINK href="media/pinpoint.css" type="text/css" rel="stylesheet">
		<!-- username:<%= login.Username%> userid<%= login.DspUserId %> -->
	</HEAD>
	<body onload='dialogArguments.PinPoint_RefreshPinpoints()'>
		<form runat="server">
			<table width="100%">
				<tr>
					<td class="heading">Pinpoint Application</td>
				</tr>
				<tr>
					<td class="content">
						<!-- BEGIN CONTENT -->
						<table width="100%">
							<%=getAddPinpoint()%>
							<tr>
								<td style="HEIGHT: 62px">
									Filter by:<br>
									<asp:DropDownList id="filtertype" runat="server" Width="120px" Height="88px" AutoPostBack="True">
										<asp:ListItem Value="action_by_dsp_user_id" Selected="True">Owner</asp:ListItem>
										<asp:ListItem Value="originator_dsp_user_id">From</asp:ListItem>
										<asp:ListItem Value="*">All user</asp:ListItem>
									</asp:DropDownList>
									<asp:CheckBox id="chkShowClosed" runat="server" Width="208px" Text="Show Closed Pinpoints Also"
										AutoPostBack="True"></asp:CheckBox>
								</td>
							</tr>
							<tr>
								<td>
									<asp:DropDownList id="filtertype2" runat="server" Width="200px" Height="88px" AutoPostBack="True">
										<asp:ListItem Value="A" Selected="True">A- Algemeen</asp:ListItem>
										<asp:ListItem Value="B">B- Wegen</asp:ListItem>
										<asp:ListItem Value="C">C- Groen</asp:ListItem>
										<asp:ListItem Value="D">D- Riool</asp:ListItem>
										<asp:ListItem Value="Q">Q- Questions/overig</asp:ListItem>
										<asp:ListItem Value="*">Everything</asp:ListItem>
									</asp:DropDownList>
								</td>
							</tr>
							<tr>
								<td>
									<%= getAllPinpoints()%>
								</td>
							</tr>
							<%=getTextPinpoint()%>
						</table>
						<!-- END CONTENT -->
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
