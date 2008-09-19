using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.OracleClient;

namespace QI02.pinpoint
{
	/// <summary>
	/// Mainform for the pinpoint application.
	/// This form will show all available pinpoints.
	/// </summary>
	public class pinpointmain : System.Web.UI.Page
	{
		private string mainInsert;
		private string addPinpoint;
		private string textPinpoint;

		protected HawarIT.WebLibrary.OracleDatabase database;
		protected System.Web.UI.WebControls.DropDownList filtertype;
		protected System.Web.UI.WebControls.CheckBox chkShowClosed;
		protected System.Web.UI.WebControls.DropDownList filtertype2;
		protected HawarIT.WebLibrary.LoginDetails login;


		private void Page_Load(object sender, System.EventArgs e)
		{
			database = new HawarIT.WebLibrary.OracleDatabase(System.Configuration.ConfigurationSettings.AppSettings["pinpoint-connection-string"]);
			login = new HawarIT.WebLibrary.LoginDetails(User.Identity.Name, database);
			mainInsert = "\t\t\t\t\t<table>\n";	
			string rOpen = "\t\t\t\t\t\t<tr><td colspan='6' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr>\n";
//			string rCleanOpen = "\t\t\t\t\t\t<tr>\n";
			string rClose = "\t\t\t\t\t\t</tr>\n";
			string cOpen = "\t\t\t\t\t\t\t<td class='ppcol'>";
//			string mcOpen = "\t\t\t\t\t\t\t<td class='ppcol' colspan='3'>";
			string cClose = "</td>\n";
			string rHr = "<tr><td colspan='6' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr><td><br></td></tr>";

			string mainQuery = "SELECT PINPOINT_MAIN.id, dsp_status.name as status,type_rq, owner_user.username as action_by,from_user.username as created_by,x,y,zoomscale,text ";
			mainQuery += "FROM PINPOINT_MAIN, PINPOINT_TEXT, dsp_status, dsp_user from_user, dsp_user owner_user ";
			mainQuery += "WHERE owner_user.id = action_by_dsp_user_id ";
			mainQuery += "AND from_user.id = originator_dsp_user_id ";
			mainQuery += "AND owner_user.id = action_by_dsp_user_id ";
			mainQuery += "AND PINPOINT_TEXT.id = (SELECT MIN(T.id) FROM PINPOINT_TEXT T WHERE pinpoint_main_id = PINPOINT_MAIN.id) ";
			mainQuery += "AND dsp_status.id = PINPOINT_MAIN.dsp_status_id ";
			if(filtertype.SelectedValue != "*") 
			{
				mainQuery += "AND " + filtertype.SelectedValue + " = " +  login.DspUserId  + " ";
			}
			if(filtertype2.SelectedValue != "*") 
			{
				mainQuery += "AND  type_rq  = '" +  filtertype2.SelectedValue+"' ";
			}
			if (!chkShowClosed.Checked)  
			{
				mainQuery += "AND dsp_status.name <> 'Solved' ";
			}
			// MAX 100!
			mainQuery += "AND ROWNUM < 100 ";				
			mainQuery += "ORDER BY PINPOINT_MAIN.id ";

			DataTable myDataTable = database.Query(mainQuery);

			addPinpoint = "";
			if(MayAddPinPoints(login.DspUserId)) 
			{		
				addPinpoint = "<tr><td><a href='pinpointadd.aspx'>Add Pinpoint&nbsp;&nbsp;»</a><br><br></td></tr>";
			}
			textPinpoint = "";

//				foreach(DataTable myDataTable in myDataSet.Tables)
//				{
				foreach(DataRow myDataRow in myDataTable.Rows)
				{
					string tempID = Convert.ToString(myDataRow["id"]);
					string tempType = Convert.ToString(myDataRow["type_rq"]);
					string tempX = Convert.ToString(myDataRow["x"]);
					string tempY = Convert.ToString(myDataRow["y"]);
					string tempZ = Convert.ToString(myDataRow["zoomscale"]);
					string status = Convert.ToString(myDataRow["status"]);
					string tempText = Convert.ToString(myDataRow["text"]);
					string tempOwner = Convert.ToString(myDataRow["action_by"]);
					string tempOriginator = Convert.ToString(myDataRow["created_by"]);

					mainInsert += rOpen;
					
					// Type afdrukken
					if(tempType == "A")
						mainInsert += cOpen + "<a href='pinpointselect.aspx?id=" + tempID + "'><img src='media/web_pinpoint_A.bmp' alt='A Algemeen' border='0'></a>" + cClose;
					else if(tempType == "B")
						mainInsert += cOpen + "<a href='pinpointselect.aspx?id=" + tempID + "'><img src='media/web_pinpoint_B.bmp' alt='B Wegen' border='0'></a>" + cClose;
					else if(tempType == "C")
						mainInsert += cOpen + "<a href='pinpointselect.aspx?id=" + tempID + "'><img src='media/web_pinpoint_C.bmp' alt='C Groen' border='0'></a>" + cClose;
					else if(tempType == "D")
						mainInsert += cOpen + "<a href='pinpointselect.aspx?id=" + tempID + "'><img src='media/web_pinpoint_D.bmp' alt='D Riool' border='0'></a>" + cClose;
					else	mainInsert += cOpen + "<a href='pinpointselect.aspx?id=" + tempID + "'><img src='media/web_questionmark.png' alt='Question' border='0'></a>" + cClose;
					
					// Zoomto afdrukken, of anders lege kolom afdrukken
					mainInsert += cOpen;
					if(tempX != "")
					{
						tempX = tempX.Replace(",",".");
						tempY = tempY.Replace(",",".");
						mainInsert += "<a href='#' onclick='dialogArguments.PinPoint_ZoomTo(" + tempX + "," + tempY + "," + tempZ + ")'>";
						mainInsert += "<img src='media/web_zoomto.png' alt='(" + tempX + " ; " + tempY + ") Scale: " + tempZ + "' border='0'></a>";
					}
					mainInsert += cClose;

					// Status afdrukken
					mainInsert += cOpen + status + cClose;

					// Text afdrukken
					mainInsert += cOpen + tempText + cClose;

					// Originator afdrukken
					mainInsert += cOpen + tempOriginator + cClose;

					// Eigenaar afdrukken
					mainInsert += cOpen + tempOwner + cClose;

					
					mainInsert += rClose;
				}	
//				}
			mainInsert += rHr;
			mainInsert += "\t\t\t\t\t</table>\n";
		}
		
		protected string getAllPinpoints()
		{
			return mainInsert;
		}

		protected string getAddPinpoint()
		{
			return addPinpoint;
		}

		protected string getTextPinpoint()
		{
			return textPinpoint;
		}

		private bool MayAddPinPoints(string userid) 
		{
			// 0 is the begin status
			return CanChangeStatus(userid, 0 );
		}
		private bool CanChangeStatus(string userid, int currentstatus) 
		{
			OracleConnection connection = database.Connection;
			string sql = "select * from dsp_workflow where dsp_user_id = " + userid + " and dsp_status_id = " + currentstatus;
			DataTable table = new DataTable();
			OracleDataAdapter adapter = new OracleDataAdapter(sql,connection);
			connection.Open();
			adapter.Fill(table);
			connection.Close();
			return table.Rows.Count > 0;
		}

		#region Web Form Designer generated code
		override protected void OnInit(EventArgs e)
		{
			//
			// CODEGEN: This call is required by the ASP.NET Web Form Designer.
			//
			InitializeComponent();
			base.OnInit(e);
		}
		
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{    
			this.filtertype.SelectedIndexChanged += new System.EventHandler(this.filtertype_SelectedIndexChanged);
			this.chkShowClosed.CheckedChanged += new System.EventHandler(this.chkShowClosed_CheckedChanged);
			this.filtertype2.SelectedIndexChanged += new System.EventHandler(this.filtertype2_SelectedIndexChanged);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void butAddPinpoint_Click(object sender, System.EventArgs e)
		{
			Response.Redirect("pinpointadd.aspx");
		}

		private void filtertype_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void chkShowClosed_CheckedChanged(object sender, System.EventArgs e)
		{
		
		}

		private void filtertype2_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}
	}
}