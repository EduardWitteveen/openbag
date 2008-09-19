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

namespace QI02.pinpoint
{
	/// <summary>
	/// Summary description for pinpointtext.
	/// </summary>
	public class pinpointtext : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.TextBox txtOriginator;
		protected System.Web.UI.WebControls.TextBox txtComments;
		protected System.Web.UI.WebControls.Button butSubmit;
		protected System.Web.UI.WebControls.Button butCancel;
		
		private string mainId;
		private string textId;
		private OracleConnection myConn;
		protected System.Web.UI.WebControls.DropDownList drpStatus;
		protected string mode;

		protected HawarIT.WebLibrary.OracleDatabase database;
		protected HawarIT.WebLibrary.LoginDetails login;


		private void Page_Load(object sender, System.EventArgs e)
		{
			database = new HawarIT.WebLibrary.OracleDatabase(System.Configuration.ConfigurationSettings.AppSettings["pinpoint-connection-string"]);
			login = new HawarIT.WebLibrary.LoginDetails(User.Identity.Name, database);

			mainId = Request.QueryString["mid"];
			textId = Request.QueryString["tid"];
			myConn = database.Connection;

			long currentstatus = 0;

			if(textId != null)
			{
				mode = "update";
				string textQuery = "SELECT text, (SELECT username from dsp_user where id = dsp_user_id ) as author, dsp_status_id FROM PINPOINT_TEXT WHERE id = " + textId + " AND pinpoint_main_id = " + mainId;
				OracleDataAdapter adptText = new OracleDataAdapter(textQuery,myConn);
				DataSet myDataSetT = new DataSet();
				adptText.Fill(myDataSetT,"PINPOINT_TEXT");
								
				foreach(DataTable myDataTable in myDataSetT.Tables)
				{
					foreach(DataRow myDataRow in myDataTable.Rows)
					{
						string tempText = Convert.ToString(myDataRow["text"]);
						string tempAuthor = Convert.ToString(myDataRow["author"]);
						//currentstatus = Convert.ToInt16(myDataRow["dsp_status_id"]);
						
						if(!IsPostBack)
						{
							txtComments.Text = tempText;
							txtOriginator.Text = tempAuthor;
						}
					}	
				}
			}
			else
			{
				if(!IsPostBack)
				{
					txtOriginator.Text = login.Username;

					string sql = "SELECT dsp_user.id as to_dsp_user_id, dsp_status.id as to_dsp_status_id, dsp_user.username to_user, dsp_status.name as to_status ";
					sql += " FROM dsp_workflow, dsp_user, dsp_status, pinpoint_main ";
					sql += " WHERE dsp_user_id = " + login.DspUserId;
					sql += " AND dsp_workflow.dsp_status_id = pinpoint_main.dsp_status_id ";
					sql += " AND pinpoint_main.id = " + mainId;
					sql += " AND dsp_user.id = next_dsp_user_id ";
					sql += " AND dsp_status.id = next_dsp_status_id ";
					OracleConnection conn =  database.Connection;
					conn.Open();			
					OracleDataAdapter adapter = new OracleDataAdapter(sql, conn);
					DataTable statusTable = new DataTable();
					adapter.Fill(statusTable);
					conn.Close();
					if(statusTable.Rows.Count < 1) 
					{
						throw new Exception("There were not statusses found intable dsp_workflow for user with id:"+ login.DspUserId+ " and status=" + currentstatus);
					}
					foreach(DataRow row in statusTable.Rows) 
					{
						ListItem listitem = new ListItem();
						listitem.Text = row["to_status"] + "("+ row["to_user"] + ")";
						listitem.Value= row["to_dsp_status_id"] + "|"+ row["to_dsp_user_id"];
						drpStatus.Items.Add(listitem);
					}
				}
				mode = "add";
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
			Response.Redirect("pinpointmain.aspx?id=" + mainId);
		}

		private void butSubmit_Click(object sender, System.EventArgs e)
		{
			if(mode == "add") 
			{
				string statusValue = drpStatus.SelectedValue;
				statusValue = statusValue.Substring(0, statusValue.IndexOf("|"));
				string userValue = drpStatus.SelectedValue;
				userValue = userValue.Substring(userValue.IndexOf("|") + 1);
				PinPoint.AddText(database,txtComments.Text, login.DspUserId,mainId,Convert.ToInt16(userValue),Convert.ToInt16(statusValue));
			}
			else if(mode == "update") 
			{
				PinPoint.UpdateText(database,txtComments.Text,login.DspUserId,mainId,textId);
			}
			Response.Redirect("pinpointselect.aspx?id=" + mainId);
		}
	}
}
