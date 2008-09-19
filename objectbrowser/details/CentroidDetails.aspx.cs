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
	/// Summary description for CentroidDetails.
	/// </summary>
	public class CentroidDetails : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Web.UI.WebControls.Label lblVerhardingOrgineel;
		protected System.Web.UI.WebControls.Label lblRtypeOrgineel;
		protected System.Web.UI.WebControls.Button btnSave;
		protected System.Web.UI.WebControls.DropDownList ddVerharding;
		protected System.Web.UI.WebControls.DropDownList ddRtype;
		protected System.Data.OleDb.OleDbConnection oleDbConnection;
		protected System.Data.OleDb.OleDbCommand oleDbSelectCommand;
		protected System.Data.OleDb.OleDbCommand oleDbInsertCommand;
		protected System.Data.OleDb.OleDbCommand oleDbUpdateCommand;
		protected System.Data.OleDb.OleDbCommand oleDbDeleteCommand;
		protected System.Web.UI.WebControls.Label lblHandle;
		protected System.Data.OleDb.OleDbDataAdapter CentroidDataAdapter;
		protected System.Data.OleDb.OleDbDataAdapter RTypesDataAdapter;
		protected System.Data.OleDb.OleDbCommand oleDbSelectCommand1;
		protected System.Data.OleDb.OleDbDataAdapter VTypesDataAdapter;
		protected qi02.details.Centroid centroid;
		protected System.Data.OleDb.OleDbCommand oleDbSelectCommand2;

		private void Page_Load(object sender, System.EventArgs e)
		{
			if(Request.Params["key"] == null) 
			{
				throw new HttpException("Parameter 'key' is missing");
			}
			if(Request.Params["layer"] == null) 
			{	
				throw new HttpException("Parameter 'layer' is missing");
			}
			oleDbSelectCommand.Parameters["Handle"].Value = Request.Params["key"];				
			CentroidDataAdapter.Fill(centroid);

			if(centroid.Tables["HIT_CTR"].Rows.Count != 1) 
			{
				throw new HttpException("Did not find a single record for key:" + Request.Params["key"]);
			}

			if (!this.IsPostBack ) 
			{
				RTypesDataAdapter.Fill(centroid);
				VTypesDataAdapter.Fill(centroid);

				BindData();

				// not very elegant, but we want to set the values to the correct values
				ddVerharding.SelectedValue = centroid.Tables["HIT_CTR"].Rows[0]["Pavement"].ToString();
				ddRtype.SelectedValue = centroid.Tables["HIT_CTR"].Rows[0]["RType"].ToString();
			}
		}
		private void BindData() 
		{
			lblHandle.DataBind();
			lblVerhardingOrgineel.DataBind();
			lblRtypeOrgineel.DataBind();
			
			ddVerharding.DataBind();
			ddRtype.DataBind();
		}

		private void btnSave_Click(object sender, System.EventArgs e)
		{
			// not very elegant, but we want to set the values to the correct values
			centroid.Tables["HIT_CTR"].Rows[0]["Pavement"] = ddVerharding.SelectedValue;
			centroid.Tables["HIT_CTR"].Rows[0]["RType"] = ddRtype.SelectedValue;
			CentroidDataAdapter.Update(centroid);
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
			System.Configuration.AppSettingsReader configurationAppSettings = new System.Configuration.AppSettingsReader();
			this.oleDbConnection = new System.Data.OleDb.OleDbConnection();
			this.CentroidDataAdapter = new System.Data.OleDb.OleDbDataAdapter();
			this.oleDbDeleteCommand = new System.Data.OleDb.OleDbCommand();
			this.oleDbInsertCommand = new System.Data.OleDb.OleDbCommand();
			this.oleDbSelectCommand = new System.Data.OleDb.OleDbCommand();
			this.oleDbUpdateCommand = new System.Data.OleDb.OleDbCommand();
			this.RTypesDataAdapter = new System.Data.OleDb.OleDbDataAdapter();
			this.oleDbSelectCommand1 = new System.Data.OleDb.OleDbCommand();
			this.VTypesDataAdapter = new System.Data.OleDb.OleDbDataAdapter();
			this.oleDbSelectCommand2 = new System.Data.OleDb.OleDbCommand();
			this.centroid = new qi02.details.Centroid();
			((System.ComponentModel.ISupportInitialize)(this.centroid)).BeginInit();
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			// 
			// oleDbConnection
			// 
			this.oleDbConnection.ConnectionString = ((string)(configurationAppSettings.GetValue("oledetails-connection-string", typeof(string))));
			// 
			// CentroidDataAdapter
			// 
			this.CentroidDataAdapter.DeleteCommand = this.oleDbDeleteCommand;
			this.CentroidDataAdapter.InsertCommand = this.oleDbInsertCommand;
			this.CentroidDataAdapter.SelectCommand = this.oleDbSelectCommand;
			this.CentroidDataAdapter.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																										  new System.Data.Common.DataTableMapping("Table", "HIT_CTR", new System.Data.Common.DataColumnMapping[] {
																																																					 new System.Data.Common.DataColumnMapping("AUTONUM", "AUTONUM"),
																																																					 new System.Data.Common.DataColumnMapping("HANDLE", "HANDLE"),
																																																					 new System.Data.Common.DataColumnMapping("MAPID", "MAPID"),
																																																					 new System.Data.Common.DataColumnMapping("PARENTCADID", "PARENTCADID"),
																																																					 new System.Data.Common.DataColumnMapping("RTYPE", "RTYPE"),
																																																					 new System.Data.Common.DataColumnMapping("PAVEMENT", "PAVEMENT"),
																																																					 new System.Data.Common.DataColumnMapping("AREA", "AREA"),
																																																					 new System.Data.Common.DataColumnMapping("ORGRTYPE", "ORGRTYPE"),
																																																					 new System.Data.Common.DataColumnMapping("ORGPAVEMENT", "ORGPAVEMENT"),
																																																					 new System.Data.Common.DataColumnMapping("ATT1", "ATT1"),
																																																					 new System.Data.Common.DataColumnMapping("ATT2", "ATT2"),
																																																					 new System.Data.Common.DataColumnMapping("ATT3", "ATT3"),
																																																					 new System.Data.Common.DataColumnMapping("ATT4", "ATT4"),
																																																					 new System.Data.Common.DataColumnMapping("ATT5", "ATT5"),
																																																					 new System.Data.Common.DataColumnMapping("X", "X"),
																																																					 new System.Data.Common.DataColumnMapping("Y", "Y")})});
			this.CentroidDataAdapter.UpdateCommand = this.oleDbUpdateCommand;
			// 
			// oleDbDeleteCommand
			// 
			this.oleDbDeleteCommand.CommandText = "DELETE FROM HIT_CTR WHERE (HANDLE = ?)";
			this.oleDbDeleteCommand.Connection = this.oleDbConnection;
			this.oleDbDeleteCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("HANDLE", System.Data.OleDb.OleDbType.VarWChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			// 
			// oleDbInsertCommand
			// 
			this.oleDbInsertCommand.CommandText = "INSERT INTO HIT_CTR (HANDLE, MAPID, PARENTCADID, RTYPE, PAVEMENT, AREA, ORGRTYPE," +
				" ORGPAVEMENT, ATT1, ATT2, ATT3, ATT4, ATT5, X, Y) VALUES (?, ?, ?, ?, ?, ?, ?, ?" +
				", ?, ?, ?, ?, ?, ?, ?)";
			this.oleDbInsertCommand.Connection = this.oleDbConnection;
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("HANDLE", System.Data.OleDb.OleDbType.VarWChar, 10, "HANDLE"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("MAPID", System.Data.OleDb.OleDbType.UnsignedTinyInt, 0, "MAPID"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("PARENTCADID", System.Data.OleDb.OleDbType.VarWChar, 10, "PARENTCADID"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("RTYPE", System.Data.OleDb.OleDbType.VarWChar, 4, "RTYPE"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("PAVEMENT", System.Data.OleDb.OleDbType.VarWChar, 50, "PAVEMENT"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("AREA", System.Data.OleDb.OleDbType.VarWChar, 10, "AREA"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ORGRTYPE", System.Data.OleDb.OleDbType.VarWChar, 10, "ORGRTYPE"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ORGPAVEMENT", System.Data.OleDb.OleDbType.VarWChar, 50, "ORGPAVEMENT"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT1", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT1"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT2", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT2"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT3", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT3"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT4", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT4"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT5", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT5"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("X", System.Data.OleDb.OleDbType.Double, 0, "X"));
			this.oleDbInsertCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("Y", System.Data.OleDb.OleDbType.Double, 0, "Y"));
			// 
			// oleDbSelectCommand
			// 
			this.oleDbSelectCommand.CommandText = "SELECT * FROM HIT_CTR WHERE (HANDLE = ?)";
			this.oleDbSelectCommand.Connection = this.oleDbConnection;
			this.oleDbSelectCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("HANDLE", System.Data.OleDb.OleDbType.VarWChar, 10, "HANDLE"));
			// 
			// oleDbUpdateCommand
			// 
			this.oleDbUpdateCommand.CommandText = "UPDATE HIT_CTR SET HANDLE = ?, MAPID = ?, PARENTCADID = ?, RTYPE = ?, PAVEMENT = " +
				"?, AREA = ?, ORGRTYPE = ?, ORGPAVEMENT = ?, ATT1 = ?, ATT2 = ?, ATT3 = ?, ATT4 =" +
				" ?, ATT5 = ?, X = ?, Y = ? WHERE (HANDLE = ?)";
			this.oleDbUpdateCommand.Connection = this.oleDbConnection;
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("HANDLE", System.Data.OleDb.OleDbType.VarWChar, 10, "HANDLE"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("MAPID", System.Data.OleDb.OleDbType.UnsignedTinyInt, 0, "MAPID"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("PARENTCADID", System.Data.OleDb.OleDbType.VarWChar, 10, "PARENTCADID"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("RTYPE", System.Data.OleDb.OleDbType.VarWChar, 4, "RTYPE"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("PAVEMENT", System.Data.OleDb.OleDbType.VarWChar, 50, "PAVEMENT"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("AREA", System.Data.OleDb.OleDbType.VarWChar, 10, "AREA"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ORGRTYPE", System.Data.OleDb.OleDbType.VarWChar, 10, "ORGRTYPE"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ORGPAVEMENT", System.Data.OleDb.OleDbType.VarWChar, 50, "ORGPAVEMENT"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT1", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT1"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT2", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT2"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT3", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT3"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT4", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT4"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("ATT5", System.Data.OleDb.OleDbType.VarWChar, 50, "ATT5"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("X", System.Data.OleDb.OleDbType.Double, 0, "X"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("Y", System.Data.OleDb.OleDbType.Double, 0, "Y"));
			this.oleDbUpdateCommand.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_HANDLE", System.Data.OleDb.OleDbType.VarWChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			// 
			// RTypesDataAdapter
			// 
			this.RTypesDataAdapter.SelectCommand = this.oleDbSelectCommand1;
			this.RTypesDataAdapter.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																										new System.Data.Common.DataTableMapping("Table", "OrgRTypes_", new System.Data.Common.DataColumnMapping[] {
																																																					  new System.Data.Common.DataColumnMapping("Rtype", "Rtype"),
																																																					  new System.Data.Common.DataColumnMapping("cwvo_omschrijving", "cwvo_omschrijving")})});
			// 
			// oleDbSelectCommand1
			// 
			this.oleDbSelectCommand1.CommandText = "SELECT * FROM OrgRTypes_";
			this.oleDbSelectCommand1.Connection = this.oleDbConnection;
			// 
			// VTypesDataAdapter
			// 
			this.VTypesDataAdapter.SelectCommand = this.oleDbSelectCommand2;
			this.VTypesDataAdapter.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																										new System.Data.Common.DataTableMapping("Table", "OrgPavements_", new System.Data.Common.DataColumnMapping[] {
																																																						 new System.Data.Common.DataColumnMapping("cvha_omschrijving", "cvha_omschrijving"),
																																																						 new System.Data.Common.DataColumnMapping("cvht_omschrijving", "cvht_omschrijving")})});
			// 
			// oleDbSelectCommand2
			// 
			this.oleDbSelectCommand2.CommandText = "SELECT * FROM OrgPavements_";
			this.oleDbSelectCommand2.Connection = this.oleDbConnection;
			// 
			// centroid
			// 
			this.centroid.DataSetName = "Centroid";
			this.centroid.Locale = new System.Globalization.CultureInfo("en-US");
			this.Load += new System.EventHandler(this.Page_Load);
			((System.ComponentModel.ISupportInitialize)(this.centroid)).EndInit();

		}
			#endregion

	}
}
