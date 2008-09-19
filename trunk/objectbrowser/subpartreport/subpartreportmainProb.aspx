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
	<body  
		<form runat="server">
			<table width="100%">
  <TR>
    <TD class=heading>Subpart Report</TD></TR>
  <TR>
    <TD class=content><!-- BEGIN CONTENT -->
      <TABLE width="100%">
        <TR>
          <TD style="HEIGHT: 107px">Filter by:<BR>
<asp:DropDownList id=filtertype runat="server" AutoPostBack="True" Height="25px" Width="192px">
<asp:ListItem Value="New Subpart" Selected="True">New Subpart</asp:ListItem>
<asp:ListItem Value="Unable to Locate">Unable to Locate</asp:ListItem>
<asp:ListItem Value="*">All</asp:ListItem>
</asp:DropDownList></TD></TR>
        <TR>
          <TD>
									<%= getAllsubpartreport()%>
								</TD></TR></TABLE><!-- END CONTENT --></TD></TR>
			</table></FORM>
	</body>
</HTML>
