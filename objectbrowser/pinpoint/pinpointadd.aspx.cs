using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.OracleClient;
//using System.Data.SqlClient;

namespace QI02.pinpoint
{
	/// <summary>
	/// Summary description for pinpoint_add.
	/// </summary>
	public class pinpointadd : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.TextBox txtX;
		protected System.Web.UI.WebControls.TextBox txtY;
		protected System.Web.UI.WebControls.TextBox txtZoomscale;
		protected System.Web.UI.WebControls.TextBox txtOriginator;
		protected System.Web.UI.WebControls.TextBox txtComments;
		protected System.Web.UI.WebControls.Button butSubmit;
		protected System.Web.UI.WebControls.Button butCancel;
		protected System.Web.UI.WebControls.DropDownList drpStatus;
		protected System.Web.UI.WebControls.DropDownList drpTypeRQ;
		
		protected HawarIT.WebLibrary.OracleDatabase database;
		protected HawarIT.WebLibrary.LoginDetails login;


		private void Page_Load(object sender, System.EventArgs e)
		{
			database = new HawarIT.WebLibrary.OracleDatabase(System.Configuration.ConfigurationSettings.AppSettings["pinpoint-connection-string"]);
			login = new HawarIT.WebLibrary.LoginDetails(User.Identity.Name, database);


			if(Request["x"] != null && Request["y"]!= null)
			{	
				txtX.Text = Request["x"];
				txtY.Text = Request["y"];
			}	
			// txtOriginator.Text = (string) Session["user"];
			txtOriginator.Text = login.Username;
			
			long currentStatus = 0;

			//select dsp_workflow.*, dsp_user.username to_user, dsp_status.name as to_status
			//from dsp_workflow, dsp_user, dsp_status 
			//WHERE dsp_user_id = %userid%
			//AND dsp_status_id = %currentstatusid(when new, status=0)%
			//AND dsp_user.id = next_dsp_user_id
			//AND dsp_status.id = next_dsp_status_id
			string sql = "SELECT dsp_user.id as to_dsp_user_id, dsp_status.id as to_dsp_status_id, dsp_user.username to_user, dsp_status.name as to_status ";
			sql += " FROM dsp_workflow, dsp_user, dsp_status ";
			sql += " WHERE dsp_user_id = " + login.DspUserId;
			sql += " AND dsp_status_id = " + currentStatus;
			sql += " AND dsp_user.id = next_dsp_user_id ";
			sql += " AND dsp_status.id = next_dsp_status_id ";

			OracleConnection conn =  database.Connection;
			conn.Open();			
			OracleDataAdapter adapter = new OracleDataAdapter(sql, conn);
			DataTable statusTable = new DataTable();
			adapter.Fill(statusTable);
			conn.Close();

			// now fill our dropdown
			if(!IsPostBack) 
			{
				if(statusTable.Rows.Count < 1) 
				{
					throw new Exception("There were not statusses found intable dsp_workflow for user with id:"+ login.DspUserId+ " and status=" + currentStatus);
				}
				foreach(DataRow row in statusTable.Rows) 
				{
					ListItem listitem = new ListItem();
					listitem.Text = row["to_status"] + "("+ row["to_user"] + ")";
					listitem.Value= row["to_dsp_status_id"] + "|"+ row["to_dsp_user_id"];
					drpStatus.Items.Add(listitem);
				}				
			}
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
			this.butSubmit.Click += new System.EventHandler(this.butSubmit_Click);
			this.butCancel.Click += new System.EventHandler(this.butCancel_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void butCancel_Click(object sender, System.EventArgs e)
		{
			Response.Redirect("pinpointmain.aspx");
		}

		private void butSubmit_Click(object sender, System.EventArgs e)
		{
//			OracleConnection myConn = database.Connection;			
			int pinpointID = PinPoint.getNextMainID(database);
            int textID = PinPoint.getNextTextID(database);
//			myConn.Close();

			string mainInsert;
			string textInsert;
			
			// Generate queries.
			float xcoord = 0;
			float ycoord = 0;
			if((txtX.Text != "") && (txtY.Text != ""))
			{
				System.Globalization.NumberFormatInfo provider = new System.Globalization.NumberFormatInfo( );
				provider.NumberDecimalSeparator = ".";
				provider.NumberGroupSeparator = ",";
				provider.NumberGroupSizes = new int[ ] { 3 };
				xcoord = float.Parse(txtX.Text, provider);
				ycoord = float.Parse(txtY.Text, provider);
			}
			string statusValue = drpStatus.SelectedValue;
			statusValue = statusValue.Substring(0, statusValue.IndexOf("|"));
			string userValue = drpStatus.SelectedValue;
			userValue = userValue.Substring(userValue.IndexOf("|") + 1);

			/*
			string xstr = Convert.ToString(xcoord).Replace(",",".");
			string ystr = Convert.ToString(ycoord).Replace(",",".");
			string statusValue = drpStatus.SelectedValue;
			statusValue = statusValue.Substring(0, statusValue.IndexOf("|"));
			string userValue = drpStatus.SelectedValue;
			userValue = userValue.Substring(userValue.IndexOf("|") + 1);
			
			mainInsert  = "INSERT INTO PINPOINT_MAIN (ID,DSP_STATUS_ID,PROJECT,TYPE_RQ,ORIGINATOR_DSP_USER_ID,X,Y,ZOOMSCALE,ACTION_BY_DSP_USER_ID) ";
			mainInsert += "VALUES (" + Convert.ToString(pinpointID) + ", " + statusValue + ",'" + login.Project(this) + "','" + drpTypeRQ.SelectedItem.Text.Substring(0,1) + "\'," + login.DspUserId(this) +  "," + xstr + "," + ystr + "," + txtZoomscale.Text + "," + userValue + ")";			
			*/
			mainInsert = "INSERT INTO PINPOINT_MAIN (ID,DSP_STATUS_ID,TYPE_RQ,ORIGINATOR_DSP_USER_ID,X,Y,ZOOMSCALE,ACTION_BY_DSP_USER_ID) ";
			mainInsert += "VALUES (" + Convert.ToString(pinpointID) + ", " + statusValue + ",'" + drpTypeRQ.SelectedItem.Text.Substring(0,1) + "\'," + login.DspUserId + " ,  :xcoord,  :ycoord, " + txtZoomscale.Text + "," + userValue + ")";


			try 
			{
				OracleConnection connection = database.Connection;
				connection.Open();
				OracleCommand cmd = new  OracleCommand(mainInsert, connection);

				OracleParameter paramXCoord = cmd.Parameters.Add(":xcoord", OracleType.Float);
				OracleParameter paramYCoord = cmd.Parameters.Add(":ycoord", OracleType.Float);

				paramXCoord.Value = xcoord;
				paramYCoord.Value = ycoord;

				cmd.ExecuteNonQuery();
				connection.Close();
			}
			catch(OracleException oe) 
			{
				// throw a new expection with clearder message
				throw database.CreateException(oe, mainInsert);
			}

			textInsert  = "INSERT INTO PINPOINT_TEXT (ID,PINPOINT_MAIN_ID,TEXT,DSP_USER_ID, DSP_STATUS_ID) ";
			textInsert += "VALUES (" + Convert.ToString(textID) + "," + Convert.ToString(pinpointID) + ",\'" + txtComments.Text + "\',"  + login.DspUserId +  "," +  statusValue + ")";
									
			//Database.Execute(mainInsert);
			database.Execute(textInsert);
			//myConn.Close();
			Response.Redirect("pinpointmain.aspx");
		}
	}
}
