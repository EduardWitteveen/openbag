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

namespace qi02.details
{
	/// <summary>
	/// Summary description for GreenDetails.
	/// </summary>
	public class GreenDetails : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.DropDownList drpKWO;
		protected System.Web.UI.WebControls.Button btnSave;
		protected System.Web.UI.WebControls.Label lblHandle;
		protected System.Web.UI.WebControls.DropDownList drpGRType;
		protected System.Web.UI.WebControls.TextBox txtVak;

		public string sqlSelect="";
		public static string key="";
		public string layerName="";
		public string kwo="";
		public static bool g_object = false;
		public static bool g_point = false;
		public static bool g_line = false;
		public static bool g_area = false;

		private void Page_Load(object sender, System.EventArgs e)
		{
			// Put user code to initialize the page here
			if(!IsPostBack)
			{
				if(Request.Params["key"]!=null)
				{
					lblHandle.Text = Request.Params["key"].ToString();
					key = Request.Params["key"].ToString();
				}
				else
				{
					throw new HttpException("Parameter 'key' is missing");
				}
				if(Request.Params["layer"]!=null)
				{
					string setSel = "";
					string allKwo = "select CO_KERN+ '.'+CO_WIJK+'.'+ CO_OBJEC as kwo from gbobjec order by 1";

					layerName = Request.Params["layer"].ToString();
					if(layerName.ToUpper()=="GREENOBJECT")
					{
						g_object = true;
						g_point = false;
						g_line = false;
						g_area = false;

						setSel = "select KWO from GIS_GroenObject where handle = '" + key+"'";
						LoadKWO(setSel, allKwo);
					}
					else if(layerName.ToUpper()=="GREENPOINT")
					{
						g_object = false;
						g_point = true;
						g_line = false;
						g_area = false;

						setSel = "select KWO from GIS_GroenPunt where handle = '" + key+"'";
						LoadKWO(setSel, allKwo);
						
						setSel = "select grType from GIS_GroenPunt where handle = '" + key+"'";
						string allGRType  = "SELECT co_grgrp & co_grtyp AS grtype, om_grtyp AS omschrijving FROM gbgrtyp where co_eenhe='st' order by 1";
						LoadGRType(setSel,allGRType);
						
						setSel = "select vak from GIS_GroenPunt where handle = '" + key+"'";
						LoadVak(setSel);
					}
					else if(layerName.ToUpper()=="GREENLINE")
					{
						g_object = false;
						g_point = false;
						g_line = true;
						g_area = false;

						setSel = "select KWO from GIS_GroenLijn where handle = '" + key+"'";
						LoadKWO(setSel, allKwo);

						setSel = "select grType from GIS_GroenLijn where handle = '" + key+"'";
						string allGRType  = "SELECT co_grgrp & co_grtyp AS grtype, om_grtyp AS omschrijving FROM gbgrtyp where co_eenhe ='m'";
						LoadGRType(setSel,allGRType);
						
						setSel = "select vak from GIS_GroenLijn where handle = '" + key + "'";
						LoadVak(setSel);
					}
					else if(layerName.ToUpper()=="GREENAREA"||layerName.ToUpper()=="GV_TYPE"||layerName.ToUpper()=="GV_KWO")
					{
						g_object = false;
						g_point = false;
						g_line = false;
						g_area = true;

						setSel = "select KWO from Gis_Groenvlak where handle = '" + key+"'";
//						allKwo = "select CO_KERN+ '.'+CO_WIJK+'.'+ CO_OBJEC as kwo from gbobjec";
						LoadKWO(setSel, allKwo);

						setSel = "select grType from Gis_Groenvlak where handle = '" + key+"'";
						string allGRType  = "SELECT co_grgrp & co_grtyp AS grtype, om_grtyp AS omschrijving FROM gbgrtyp where co_eenhe ='m2' order by 1";
						LoadGRType(setSel,allGRType);
						
						setSel = "select vak from Gis_Groenvlak where handle = '" + key + "'";
						LoadVak(setSel);
					}
				}
				else
				{
					throw new HttpException("Parameter 'layer' is missing");
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
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		/// <summary>
		/// This routine Executes query taking a valid QueryString
		/// and Returns a DataTable
		/// </summary>
		/// <param name="myQuery">Query String</param>
		/// <returns>Result DataTable</returns>
		public static DataTable GetDataTable(string myQuery)
		{
			DataTable dataTable = new DataTable();
			try
			{
				string myConnectionString = System.Configuration.ConfigurationSettings.AppSettings["oledetails-connection-string"];
				System.Data.OleDb.OleDbConnection myConnection = new  System.Data.OleDb.OleDbConnection(myConnectionString);

				System.Data.OleDb.OleDbDataAdapter adapter = new System.Data.OleDb.OleDbDataAdapter();
				adapter.SelectCommand = new System.Data.OleDb.OleDbCommand(myQuery, myConnection);
				adapter.Fill(dataTable);
			}
			catch(Exception ex)
			{
				throw new HttpException( "SQL:" + myQuery +" Error found"+ex.ToString() );
			}
			return dataTable;	
		}

		private void LoadKWO(string select, string getAll)
		{
			kwo = GetDataTable(select).Rows[0]["kwo"].ToString();
			DataTable dt = GetDataTable(getAll);
			drpKWO.DataSource = dt;
			drpKWO.DataTextField = dt.Columns["kwo"].ToString();
			if(kwo != "")
                drpKWO.SelectedValue = kwo;
			drpKWO.DataBind();
		}

		private void LoadGRType(string select, string getAll)
		{
			bool found = false;
			string grType = GetDataTable(select).Rows[0]["grType"].ToString();
			DataTable dt = GetDataTable(getAll);
			drpGRType.DataSource = dt;
			drpGRType.DataTextField = dt.Columns["grtype"].ToString();
			drpGRType.DataBind();
			for(int index=0; index<drpGRType.Items.Count; index++)
			{
				if(drpGRType.Items[index].ToString()==grType)
				{
					found = true;
					break;
				}
			}
			if(found)
			{
				drpGRType.SelectedValue = grType;
			}
			else
			{
				drpGRType.SelectedIndex = 0;
			}
		}

		private void LoadVak(string select)
		{
			string vak = GetDataTable(select).Rows[0]["vak"].ToString();
			txtVak.Text = vak;
//			DataTable dt = GetDataTable(getAll);
//			drpVak.DataSource = dt;
//			drpVak.DataTextField = dt.Columns["vak"].ToString();
//			if(vak != "")
//				txtVak.Text = vak;
//			drpVak.DataBind();
		}

		private void btnSave_Click(object sender, System.EventArgs e)
		{
			string errVak = "Sorry...Maximum 5 charecter allowed.";
			string sqlUpdate="";
			if(g_object)
			{
				sqlUpdate = "Update GIS_GroenObject set kwo = '"+ drpKWO.SelectedValue + "' where handle='"+key+"'";
				GetDataTable(sqlUpdate);
			}
			else if(g_point)
			{
				if(txtVak.Text.Length <= 5)
				{
					sqlUpdate = "Update GIS_GroenPunt set kwo = '"+ drpKWO.SelectedValue + "', grType = '"+ drpGRType.SelectedValue + "', vak = '"+ txtVak.Text + "' where handle='"+key+"'";
					GetDataTable(sqlUpdate);
				}
				else
				{
					RegisterStartupScript("err",errVak);
				}
			}
			else if(g_line)
			{
				if(txtVak.Text.Length <= 5)
				{
					sqlUpdate = "Update GIS_GroenLijn set kwo = '"+ drpKWO.SelectedValue + "', grType = '"+ drpGRType.SelectedValue + "', vak = '"+ txtVak.Text + "' where handle='"+key+"'";
					GetDataTable(sqlUpdate);
				}
				else
				{
					RegisterStartupScript("err",errVak);
				}
			}
			else if(g_area)
			{
				if(txtVak.Text.Length <= 5)
				{
					sqlUpdate = "Update Gis_Groenvlak set kwo = '"+ drpKWO.SelectedValue + "', grType = '"+ drpGRType.SelectedValue + "', vak = '"+ txtVak.Text + "' where handle='"+key+"'";
					GetDataTable(sqlUpdate);
				}
				else
				{
					RegisterStartupScript("err",errVak);
				}
			}
		}
	}
}
