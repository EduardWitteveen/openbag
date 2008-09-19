<%@ Page language="c#" Codebehind="subpartreportmain.aspx.cs" AutoEventWireup="false" Inherits="QI02.subpartreport.subpartreportmain" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Subpart Reporting</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="C#" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<script language="javascript" src="media/subpartreport.js"></script>
		<LINK href="media/subpartreport.css" type="text/css" rel="stylesheet">
		<!-- username:<%= login.Username%> userid<%= login.DspUserId %> -->
	</HEAD>
	<body onload="dialogArguments">
		<form runat="server">
			<table width="100%">
				<tr>
					<td class="heading">Subpart Report</td>
				</tr>
				<tr>
					<td class="content">
						<!-- BEGIN CONTENT -->
						<table width="100%">
							<tr>
								<td style="HEIGHT: 77px">Filter by:<br>
									<asp:dropdownlist id="filtertype" runat="server" AutoPostBack="True" Height="25px" Width="276px">
										<asp:ListItem Value="New Subpart" Selected="True">New Subpart</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 1st Page">Unable to Locate 1st Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 2nd Page">Unable to Locate 2nd Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 3rd Page">Unable to Locate 3rd Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 4th Page">Unable to Locate 4th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 5th Page">Unable to Locate 5th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 6th Page">Unable to Locate 6th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 7th Page">Unable to Locate 7th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 8th Page">Unable to Locate 8th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 9th Page">Unable to Locate 9th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 10th Page">Unable to Locate 10th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 11th Page">Unable to Locate 11th Page</asp:ListItem>
										<asp:ListItem Value="Unable to Locate 12th Page">Unable to Locate 12th Page</asp:ListItem>
										
										
									</asp:dropdownlist></td>
							</tr>
							<tr>
								<td>
									<%= getAllsubpartreport()%>
								</td>
							</tr>
						</table>
						<!-- END CONTENT --></td>
				</tr>
			</table>
		</form>
	</body>
</HTML>
