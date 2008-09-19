<%@ Page language="c#" Codebehind="pinpointselect.aspx.cs" AutoEventWireup="false" Inherits="QI02.pinpoint.pinpointselect" %>
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
	<%
		// only execute the onload, when we are a modal thing,...
	%>
	<body <%if(Request.QueryString["id"] != null) {%> onload='dialogArguments.PinPoint_RefreshPinpoints()' <% } %>>
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
