<%@ Page language="c#" Codebehind="Login.aspx.cs" AutoEventWireup="false" Inherits="QI02.login.Login" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>Login</title>
		<LINK href="media/style.css" type="text/css" rel="stylesheet">
	</HEAD>
	<body>
		<center>
			<form runat="server" ID="Form1">
				<table height="100%" cellSpacing="0" cellPadding="0" width="100%">
					<tr>
						<td class="main" vAlign="top" height="100%"><br>
							<IMG height="7" src="media/bullet.png" width="12" border="0"><b class="title">Online 
								services</b><br>
							<table class="maintext" width="560">
								<tr>
									<td vAlign="top" colSpan="2" height="12"><IMG height="1" src="media/spacer_grey.png" width="560" border="0"></td>
								</tr>
								<tr>
									<td><IMG class="img" src="media/os.gif" width="154" align="left" border="0">
										<p>
										Hawar Information Technology Data Service Provider instantly provides access to your 
										geographical data.
										</p>

										<p>As per agreement, we assure you that we will process corresponding changes and 
										will update your geographical information system upon request.</p>

										<asp:label runat="server" id="lblInstructionText">
											Please enter in your username and your password.
										</asp:label>
										<table>
											<tr>
												<td>Username:</td>
												<td><asp:textbox id="txtUsername" runat="Server" Width="180px" /></td>
											</tr>
											<tr>
												<td>Password:</td>
												<td><asp:textbox id="txtPassword" textmode="Password" runat="Server" Width="180px" /></td>
											</tr>
											<tr>
												<td></td>
												<td><asp:Button id="btnLogin" runat="server" Text="Login" Width="180px"></asp:Button></td>
											</tr>
											<tr>
												<td colSpan="2">
													<p>For questions and comments, please <A href="mailto:dsp@hawarit.com">e-mail</A> Hawar 
													Information Technology Data Service Providing.</p>
											</td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td height='20' valign='bottom' align='right' colspan='2'><img src='media/corner.png' width='12' height='12' border='0'></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</center>
		<P></P>
	</body>
</HTML>
