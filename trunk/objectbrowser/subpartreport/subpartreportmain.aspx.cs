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

namespace QI02.subpartreport
{
	/// <summary>
	/// Mainform for the pinpoint application.
	/// This form will show all available pinpoints.
	/// </summary>
	public class subpartreportmain : System.Web.UI.Page
	{
		private string mainInsert;

		protected HawarIT.WebLibrary.OracleDatabase database;
		protected System.Web.UI.WebControls.DropDownList filtertype;
		protected HawarIT.WebLibrary.LoginDetails login;


		private void Page_Load(object sender, System.EventArgs e)
		{
			//if (!IsPostBack)
			//{
				database = new HawarIT.WebLibrary.OracleDatabase(System.Configuration.ConfigurationSettings.AppSettings["subpart-connection-string"]);
				login = new HawarIT.WebLibrary.LoginDetails(User.Identity.Name, database);
				mainInsert = "\t\t\t\t\t<table>\n";	
				string rOpen = "\t\t\t\t\t\t<tr><td colspan='6' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr>\n";
				string rCleanOpen = "\t\t\t\t\t\t<tr>\n";
				string rClose = "\t\t\t\t\t\t</tr>\n";
				string cOpen = "\t\t\t\t\t\t\t<td class='ppcol'>";
				string mcOpen = "\t\t\t\t\t\t\t<td class='ppcol' colspan='3'>";
				string cClose = "</td>\n";
				string rHr = "<tr><td colspan='6' style='background-color: #CCCCCC; height: 1px;'></td></tr><tr><td><br></td></tr>";

				string mainQuery = "SELECT id, ORGRTYPE,ORGPAVEMENT,RTYPE,PAVEMENT,X,Y,AREA,NAMECOLUMN,SUBPARTCATEGORY,ZOOMSCALE ";
				mainQuery += "FROM HIT_SUBPARTREPORTDATA ";
				// MAX 100!
				//mainQuery += "WHERE ROWNUM < 350 ";				
			
				if(filtertype.SelectedValue != "*") 
				{
					mainQuery += " WHERE SUBPARTCATEGORY ='" + filtertype.SelectedValue + "' ";
				}

				mainQuery += "ORDER BY id ";

				DataTable myDataTable = database.Query(mainQuery);

				foreach(DataRow myDataRow in myDataTable.Rows)
				{
					string tempID = Convert.ToString(myDataRow["id"]);
					string tempOrgRtype = Convert.ToString(myDataRow["OrgRtype"]);
					string tempRtype = Convert.ToString(myDataRow["Rtype"]);
					string tempOrgPavement = Convert.ToString(myDataRow["OrgPavement"]);
					string tempPavement = Convert.ToString(myDataRow["Pavement"]);
					string tempX = Convert.ToString(myDataRow["x"]);
					string tempY = Convert.ToString(myDataRow["y"]);
					string tempZ = Convert.ToString(myDataRow["zoomscale"]);
					string tempCategory = Convert.ToString(myDataRow["subpartcategory"]);
					
					mainInsert += rOpen;
					
					// Zoomto afdrukken, of anders lege kolom afdrukken
					mainInsert += cOpen;
					if(tempX != "")
					{
						tempX = tempX.Replace(",",".");
						tempY = tempY.Replace(",",".");
						mainInsert += "<a href='#' onclick='dialogArguments.subpartreport_ZoomTo(" + tempX + "," + tempY + "," + tempZ + ")'>";
						mainInsert += "<img src='media/web_zoomto.png' alt='(" + tempX + " ; " + tempY + ") Scale: " + tempZ + "' border='0'></a>";
					}
					mainInsert += cClose;

					// DB rtype afdrukken
					mainInsert += cOpen + tempOrgRtype + cClose;

					// DB Pavement afdrukken
					mainInsert += cOpen + tempOrgPavement + cClose;

					// CAD rtype afdrukken
					mainInsert += cOpen + tempRtype + cClose;

					// CAD pavement afdrukken
					mainInsert += cOpen + tempPavement + cClose;

					// subpart status afdrukken
					mainInsert += cOpen + tempCategory + cClose;

					
					mainInsert += rClose;
				}	
				//				}
				mainInsert += rHr;
				mainInsert += "\t\t\t\t\t</table>\n";
			//}
		}
		
		protected string getAllsubpartreport()
		{
			return mainInsert;
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
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

	
		private void filtertype_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void chkShowClosed_CheckedChanged(object sender, System.EventArgs e)
		{
		
		}
	}
}