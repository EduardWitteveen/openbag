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
	public class pinpointselect : System.Web.UI.Page
	{
		private string mainInsert;
		private string addPinpoint;
		private string textPinpoint;

		protected HawarIT.WebLibrary.OracleDatabase database;
		protected HawarIT.WebLibrary.LoginDetails login;


		private void Page_Load(object sender, System.EventArgs e)
		{
			database = new HawarIT.WebLibrary.OracleDatabase(System.Configuration.ConfigurationSettings.AppSettings["pinpoint-connection-string"]);
			login = new HawarIT.WebLibrary.LoginDetails(User.Identity.Name, database);
			mainInsert = "\t\t\t\t\t<table>\n";	
			string rOpen = "\t\t\t\t\t\t<tr><td colspan='5' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr>\n";
			string rCleanOpen = "\t\t\t\t\t\t<tr>\n";
			string rClose = "\t\t\t\t\t\t</tr>\n";
			string cOpen = "\t\t\t\t\t\t\t<td class='ppcol'>";
			string mcOpen = "\t\t\t\t\t\t\t<td class='ppcol' colspan='3'>";
			string cClose = "</td>\n";
			string rHr = "<tr><td colspan='5' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr><td><br></td></tr>";

			string ppId = Request.QueryString["id"];
			if(ppId == null|| ppId == "") 
			{
				// fallback, this is for the new situration,..
				ppId = Request.QueryString["key"];
				if(ppId == null) 
				{
					throw new HttpException("parameter id not specified!");
				}
			}

			addPinpoint = "<tr><td><a href='pinpointmain.aspx'>&laquo;&nbsp;&nbsp;Mainscreen</a><br><br></td></tr>";
			textPinpoint = "";
			
			string textQuery = " SELECT PINPOINT_MAIN.zoomscale, PINPOINT_MAIN.type_rq, PINPOINT_MAIN.x, PINPOINT_MAIN.y, PINPOINT_TEXT.TEXT, dsp_status.name as status, originator_user.username  as originator, PINPOINT_TEXT.id as text_id,  author_user.username  as author, action_by_dsp_user_id ";
			textQuery += " FROM PINPOINT_MAIN, PINPOINT_TEXT, dsp_status , dsp_user author_user, dsp_user originator_user ";
			//textQuery += " WHERE PINPOINT_MAIN.project =  '" + login.Project + "'";  
			//textQuery += " AND pinpoint_main.id = " + ppId;
			textQuery += " WHERE pinpoint_main.id = " + ppId;
			textQuery += " AND pinpoint_text.pinpoint_main_id = pinpoint_main.id";
			textQuery += " AND dsp_status.id = PINPOINT_MAIN.dsp_status_id ";
			textQuery += " AND author_user.id = dsp_user_id ";
			textQuery += " AND originator_user.id = originator_dsp_user_id ";
			textQuery += " ORDER BY pinpoint_text.id ";

			//OracleDataAdapter adptText = new OracleDataAdapter(textQuery,myConn);
			//DataSet myDataSetT = new DataSet();
			//adptText.Fill(myDataSetT);
			DataTable myDataTable = database.Query(textQuery);

			bool firstTime = true;
			
			foreach(DataRow myDataRow in myDataTable.Rows)
			{
				
				if(firstTime)
				{
					mainInsert += rCleanOpen;

					string tempType = Convert.ToString(myDataRow["type_rq"]);
					string tempX = Convert.ToString(myDataRow["x"]);
					string tempY = Convert.ToString(myDataRow["y"]);
					string tempZ = Convert.ToString(myDataRow["zoomscale"]);
					string status = Convert.ToString(myDataRow["status"]);						
					string tempOriginator = Convert.ToString(myDataRow["originator"]);
					string tempEditRoot = "<img src='media/edit_root.png' alt='Edit root element of pinpoint' border='0'>";

					if(tempType == "A") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_A.bmp' alt='A'>" + cClose;
					}
					else if(tempType == "B")
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_B.bmp' alt='B'>" + cClose;
					}
					else if(tempType == "C") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_C.bmp' alt='C'>" + cClose;
					}
					else if(tempType == "D") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_D.bmp' alt='D'>" + cClose;
					}
					else if(tempType == "E") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_E.bmp' alt='E'>" + cClose;
					}
					else if(tempType == "F") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_F.bmp' alt='F'>" + cClose;
					}
					else if(tempType == "G") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_G.bmp' alt='G'>" + cClose;
					}
					else if(tempType == "H") 
					{
						mainInsert += cOpen + "<img src='media/web_pinpoint_H.bmp' alt='H'>" + cClose;
					}
					else 
					{
						mainInsert += cOpen + "<img src='media/web_questionmark.png' alt='Question'>" + cClose;
					}
					string userrequired = Convert.ToString(myDataRow["action_by_dsp_user_id"]);
					if(login.DspUserId.Equals(userrequired)) 
					{
						textPinpoint = "<tr><td><a href='pinpointtext.aspx?mid=" + ppId + "'>Add Response&nbsp;&nbsp;»</a><br><br></td></tr>";
					}

					
					mainInsert += cOpen;
					if(tempX != "")
					{
						tempX = tempX.Replace(",",".");
						tempY = tempY.Replace(",",".");

						if(Request.QueryString["id"]!= null) 
						{
							mainInsert += "<a href='#' onclick='dialogArguments.PinPoint_ZoomTo(" + tempX + "," + tempY + "," + tempZ + ")'>";
						}
						else 
						{
							mainInsert += "<a href='#' onclick='opener.PinPoint_ZoomTo(" + tempX + "," + tempY + "," + tempZ + ")'>";
						}
						mainInsert += "<img src='media/web_zoomto.png' alt='(" + tempX + " ; " + tempY + ") Scale: " + tempZ + "' border='0'></a>";
					}
					mainInsert += cClose;
					
					mainInsert += cOpen + "Status:<br><b>" + status + "</b>" + cClose;
					mainInsert += cOpen + "Originator:<br><b>" + tempOriginator + "</b>" + cClose;
					mainInsert += cOpen + tempEditRoot + cClose;
					
					mainInsert += rClose;

					firstTime = false;
				}
				mainInsert += rOpen;
				
				string textId = Convert.ToString(myDataRow["text_id"]);
				string tempText = Convert.ToString(myDataRow["text"]);
				string tempAuthor = Convert.ToString(myDataRow["author"]);
				string editButton = "";
				if(tempAuthor == login.Username) 
				{
					editButton = "<a href='pinpointtext.aspx?mid=" + ppId + "&tid=" + textId + "'><img src='media/edit_record.png' border='0'></a>";
				}

				mainInsert += cOpen + editButton + cClose;
				mainInsert += mcOpen + tempText + cClose;
				mainInsert += cOpen + tempAuthor + cClose;
				
				mainInsert += rClose;
			}	

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
	}
}