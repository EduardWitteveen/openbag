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
	/// Summary description for GrijsDetails.
	/// </summary>
	public class GrijsDetails : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label lblHandle;
		protected System.Web.UI.WebControls.Button btnSave;
		protected System.Data.DataSet dataSet;
		protected System.Data.SqlClient.SqlCommand sqlSelectCommand1;
		protected System.Data.SqlClient.SqlCommand sqlInsertCommand1;
		protected System.Web.UI.WebControls.Button btnCancel;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Data.SqlClient.SqlDataAdapter dtaHitCrt;
		protected System.Data.SqlClient.SqlCommand cmdInsertHitCrt;
		protected System.Data.SqlClient.SqlCommand cmdSelectHitCrt;
		protected System.Data.SqlClient.SqlCommand cmdUpdateHitCrt;
		protected System.Data.SqlClient.SqlDataAdapter dtaHitPavement;
		protected System.Data.SqlClient.SqlCommand sqlSelectCommand2;
		protected System.Data.SqlClient.SqlCommand sqlInsertCommand2;
		protected System.Data.SqlClient.SqlCommand sqlUpdateCommand1;
		protected System.Data.SqlClient.SqlCommand sqlDeleteCommand1;
		protected System.Data.SqlClient.SqlCommand sqlSelectCommand3;
		protected System.Data.SqlClient.SqlCommand sqlInsertCommand3;
		protected System.Data.SqlClient.SqlCommand sqlUpdateCommand2;
		protected System.Data.SqlClient.SqlCommand sqlDeleteCommand2;
		protected System.Data.SqlClient.SqlDataAdapter dtaHitRtype;
		protected System.Data.SqlClient.SqlCommand sqlSelectCommand4;
		protected System.Data.SqlClient.SqlCommand sqlInsertCommand4;
		protected System.Web.UI.WebControls.DropDownList ddlRType;
		protected System.Web.UI.WebControls.DropDownList ddlPavement;
		protected System.Data.SqlClient.SqlConnection sqlConnection;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// check if params were supplied
			if(Request.Params["key"] == null)  throw new HttpException("parameter 'key' was not provided!");
			if(Request.Params["layer"] == null)  throw new HttpException("parameter 'layer' was not provided!");

			if(!IsPostBack)
			{
				// lookup data,...
				dtaHitCrt.SelectCommand.Parameters["@handle"].Value = Request.Params["key"];
				dtaHitCrt.Fill(dataSet,"HIT_CTR");
				dtaHitPavement.Fill(dataSet,"HIT_Pavements");
				dtaHitRtype.Fill(dataSet,"HIT_RTypes");
				//				dtaBestemmingsVlakken.SelectCommand.Parameters["bestemming_idn"].Value = Request.Params["key"];
				//				dtaBestemmingsVlakken.Fill(dataSet,"bestemmingsvlak");
				
				if(dataSet.Tables["HIT_CTR"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["HIT_GVC"].Rows.Count + " found!)");
				// if already something stored with same key, remove,.. (lazy, but better for demo purposes)
				Session.Remove(this.GetType().FullName);

				// store settings in the session
				Session.Add(this.GetType().FullName, dataSet);
			}
			else 
			{
				// retrieve data from the session
				dataSet = (DataSet) Session[this.GetType().FullName];
				
				if(dataSet == null) throw new HttpException("dataset not found in session");
				if(dataSet.Tables["HIT_CTR"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["HIT_GVC"].Rows.Count + " found!)");

				// set values if they were changed
				DataRow row = dataSet.Tables["HIT_CTR"].Rows[0];
				row["RType"] = ddlRType.SelectedValue;
				row["Pavement"] = ddlPavement.SelectedValue;
			}
			// fill the controls
			DataBind();
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
			this.sqlConnection = new System.Data.SqlClient.SqlConnection();
			this.dtaHitCrt = new System.Data.SqlClient.SqlDataAdapter();
			this.sqlDeleteCommand1 = new System.Data.SqlClient.SqlCommand();
			this.sqlInsertCommand2 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand2 = new System.Data.SqlClient.SqlCommand();
			this.sqlUpdateCommand1 = new System.Data.SqlClient.SqlCommand();
			this.cmdInsertHitCrt = new System.Data.SqlClient.SqlCommand();
			this.cmdSelectHitCrt = new System.Data.SqlClient.SqlCommand();
			this.cmdUpdateHitCrt = new System.Data.SqlClient.SqlCommand();
			this.dataSet = new System.Data.DataSet();
			this.dtaHitPavement = new System.Data.SqlClient.SqlDataAdapter();
			this.sqlDeleteCommand2 = new System.Data.SqlClient.SqlCommand();
			this.sqlInsertCommand3 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand3 = new System.Data.SqlClient.SqlCommand();
			this.sqlUpdateCommand2 = new System.Data.SqlClient.SqlCommand();
			this.sqlInsertCommand1 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand1 = new System.Data.SqlClient.SqlCommand();
			this.dtaHitRtype = new System.Data.SqlClient.SqlDataAdapter();
			this.sqlInsertCommand4 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand4 = new System.Data.SqlClient.SqlCommand();
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).BeginInit();
			this.ddlRType.SelectedIndexChanged += new System.EventHandler(this.Dropdownlist1_SelectedIndexChanged);
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			// 
			// sqlConnection
			// 
			this.sqlConnection.ConnectionString = ((string)(configurationAppSettings.GetValue("details-connection-string", typeof(string))));
			// 
			// dtaHitCrt
			// 
			this.dtaHitCrt.DeleteCommand = this.sqlDeleteCommand1;
			this.dtaHitCrt.InsertCommand = this.sqlInsertCommand2;
			this.dtaHitCrt.SelectCommand = this.sqlSelectCommand2;
			this.dtaHitCrt.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
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
																																																		   new System.Data.Common.DataColumnMapping("Y", "Y"),
																																																		   new System.Data.Common.DataColumnMapping("STATUS", "STATUS"),
																																																		   new System.Data.Common.DataColumnMapping("rowguid", "rowguid")})});
			this.dtaHitCrt.UpdateCommand = this.sqlUpdateCommand1;
			// 
			// sqlDeleteCommand1
			// 
			this.sqlDeleteCommand1.CommandText = @"DELETE FROM HIT_CTR WHERE (HANDLE = @Original_HANDLE) AND (AREA = @Original_AREA OR @Original_AREA IS NULL AND AREA IS NULL) AND (ATT1 = @Original_ATT1 OR @Original_ATT1 IS NULL AND ATT1 IS NULL) AND (ATT2 = @Original_ATT2 OR @Original_ATT2 IS NULL AND ATT2 IS NULL) AND (ATT3 = @Original_ATT3 OR @Original_ATT3 IS NULL AND ATT3 IS NULL) AND (ATT4 = @Original_ATT4 OR @Original_ATT4 IS NULL AND ATT4 IS NULL) AND (ATT5 = @Original_ATT5 OR @Original_ATT5 IS NULL AND ATT5 IS NULL) AND (AUTONUM = @Original_AUTONUM) AND (MAPID = @Original_MAPID OR @Original_MAPID IS NULL AND MAPID IS NULL) AND (ORGPAVEMENT = @Original_ORGPAVEMENT OR @Original_ORGPAVEMENT IS NULL AND ORGPAVEMENT IS NULL) AND (ORGRTYPE = @Original_ORGRTYPE OR @Original_ORGRTYPE IS NULL AND ORGRTYPE IS NULL) AND (PARENTCADID = @Original_PARENTCADID OR @Original_PARENTCADID IS NULL AND PARENTCADID IS NULL) AND (PAVEMENT = @Original_PAVEMENT OR @Original_PAVEMENT IS NULL AND PAVEMENT IS NULL) AND (RTYPE = @Original_RTYPE OR @Original_RTYPE IS NULL AND RTYPE IS NULL) AND (STATUS = @Original_STATUS OR @Original_STATUS IS NULL AND STATUS IS NULL) AND (X = @Original_X OR @Original_X IS NULL AND X IS NULL) AND (Y = @Original_Y OR @Original_Y IS NULL AND Y IS NULL) AND (rowguid = @Original_rowguid)";
			this.sqlDeleteCommand1.Connection = this.sqlConnection;
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HANDLE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AREA", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AREA", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT1", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT1", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT2", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT2", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT3", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT3", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT4", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT4", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT5", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT5", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AUTONUM", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AUTONUM", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MAPID", System.Data.SqlDbType.TinyInt, 1, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MAPID", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ORGPAVEMENT", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ORGPAVEMENT", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ORGRTYPE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ORGRTYPE", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_PARENTCADID", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "PARENTCADID", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_PAVEMENT", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "PAVEMENT", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_RTYPE", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "RTYPE", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_STATUS", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "STATUS", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_X", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "X", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Y", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Y", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "rowguid", System.Data.DataRowVersion.Original, null));
			// 
			// sqlInsertCommand2
			// 
			this.sqlInsertCommand2.CommandText = @"INSERT INTO HIT_CTR(AUTONUM, HANDLE, MAPID, PARENTCADID, RTYPE, PAVEMENT, AREA, ORGRTYPE, ORGPAVEMENT, ATT1, ATT2, ATT3, ATT4, ATT5, X, Y, STATUS, rowguid) VALUES (@AUTONUM, @HANDLE, @MAPID, @PARENTCADID, @RTYPE, @PAVEMENT, @AREA, @ORGRTYPE, @ORGPAVEMENT, @ATT1, @ATT2, @ATT3, @ATT4, @ATT5, @X, @Y, @STATUS, @rowguid); SELECT AUTONUM, HANDLE, MAPID, PARENTCADID, RTYPE, PAVEMENT, AREA, ORGRTYPE, ORGPAVEMENT, ATT1, ATT2, ATT3, ATT4, ATT5, X, Y, STATUS, rowguid FROM HIT_CTR WHERE (HANDLE = @HANDLE)";
			this.sqlInsertCommand2.Connection = this.sqlConnection;
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.TinyInt, 1, "MAPID"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@PARENTCADID", System.Data.SqlDbType.NVarChar, 10, "PARENTCADID"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@RTYPE", System.Data.SqlDbType.NVarChar, 4, "RTYPE"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@PAVEMENT", System.Data.SqlDbType.NVarChar, 50, "PAVEMENT"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AREA", System.Data.SqlDbType.NVarChar, 10, "AREA"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ORGRTYPE", System.Data.SqlDbType.NVarChar, 10, "ORGRTYPE"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ORGPAVEMENT", System.Data.SqlDbType.NVarChar, 50, "ORGPAVEMENT"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT2", System.Data.SqlDbType.NVarChar, 50, "ATT2"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT3", System.Data.SqlDbType.NVarChar, 50, "ATT3"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT4", System.Data.SqlDbType.NVarChar, 50, "ATT4"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT5", System.Data.SqlDbType.NVarChar, 50, "ATT5"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.sqlInsertCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// sqlSelectCommand2
			// 
			this.sqlSelectCommand2.CommandText = "SELECT AUTONUM, HANDLE, MAPID, PARENTCADID, RTYPE, PAVEMENT, AREA, ORGRTYPE, ORGP" +
				"AVEMENT, ATT1, ATT2, ATT3, ATT4, ATT5, X, Y, STATUS, rowguid FROM HIT_CTR WHERE " +
				"handle = @handle";
			this.sqlSelectCommand2.Connection = this.sqlConnection;
			this.sqlSelectCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@handle", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			// 
			// sqlUpdateCommand1
			// 
			this.sqlUpdateCommand1.CommandText = "UPDATE HIT_CTR SET AUTONUM = @AUTONUM, HANDLE = @HANDLE, MAPID = @MAPID, PARENTCA" +
				"DID = @PARENTCADID, RTYPE = @RTYPE, PAVEMENT = @PAVEMENT, AREA = @AREA, ORGRTYPE" +
				" = @ORGRTYPE, ORGPAVEMENT = @ORGPAVEMENT, ATT1 = @ATT1, ATT2 = @ATT2, ATT3 = @AT" +
				"T3, ATT4 = @ATT4, ATT5 = @ATT5, X = @X, Y = @Y, STATUS = @STATUS WHERE (HANDLE =" +
				" @Original_HANDLE) AND (AREA = @Original_AREA OR @Original_AREA IS NULL AND AREA" +
				" IS NULL) AND (ATT1 = @Original_ATT1 OR @Original_ATT1 IS NULL AND ATT1 IS NULL)" +
				" AND (ATT2 = @Original_ATT2 OR @Original_ATT2 IS NULL AND ATT2 IS NULL) AND (ATT" +
				"3 = @Original_ATT3 OR @Original_ATT3 IS NULL AND ATT3 IS NULL) AND (ATT4 = @Orig" +
				"inal_ATT4 OR @Original_ATT4 IS NULL AND ATT4 IS NULL) AND (ATT5 = @Original_ATT5" +
				" OR @Original_ATT5 IS NULL AND ATT5 IS NULL) AND (AUTONUM = @Original_AUTONUM) A" +
				"ND (MAPID = @Original_MAPID OR @Original_MAPID IS NULL AND MAPID IS NULL) AND (O" +
				"RGPAVEMENT = @Original_ORGPAVEMENT OR @Original_ORGPAVEMENT IS NULL AND ORGPAVEM" +
				"ENT IS NULL) AND (ORGRTYPE = @Original_ORGRTYPE OR @Original_ORGRTYPE IS NULL AN" +
				"D ORGRTYPE IS NULL) AND (PARENTCADID = @Original_PARENTCADID OR @Original_PARENT" +
				"CADID IS NULL AND PARENTCADID IS NULL) AND (PAVEMENT = @Original_PAVEMENT OR @Or" +
				"iginal_PAVEMENT IS NULL AND PAVEMENT IS NULL) AND (RTYPE = @Original_RTYPE OR @O" +
				"riginal_RTYPE IS NULL AND RTYPE IS NULL) AND (STATUS = @Original_STATUS OR @Orig" +
				"inal_STATUS IS NULL AND STATUS IS NULL) AND (X = @Original_X OR @Original_X IS N" +
				"ULL AND X IS NULL) AND (Y = @Original_Y OR @Original_Y IS NULL AND Y IS NULL); S" +
				"ELECT AUTONUM, HANDLE, MAPID, PARENTCADID, RTYPE, PAVEMENT, AREA, ORGRTYPE, ORGP" +
				"AVEMENT, ATT1, ATT2, ATT3, ATT4, ATT5, X, Y, STATUS, rowguid FROM HIT_CTR WHERE " +
				"(HANDLE = @HANDLE)";
			this.sqlUpdateCommand1.Connection = this.sqlConnection;
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.TinyInt, 1, "MAPID"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@PARENTCADID", System.Data.SqlDbType.NVarChar, 10, "PARENTCADID"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@RTYPE", System.Data.SqlDbType.NVarChar, 4, "RTYPE"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@PAVEMENT", System.Data.SqlDbType.NVarChar, 50, "PAVEMENT"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AREA", System.Data.SqlDbType.NVarChar, 10, "AREA"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ORGRTYPE", System.Data.SqlDbType.NVarChar, 10, "ORGRTYPE"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ORGPAVEMENT", System.Data.SqlDbType.NVarChar, 50, "ORGPAVEMENT"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT2", System.Data.SqlDbType.NVarChar, 50, "ATT2"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT3", System.Data.SqlDbType.NVarChar, 50, "ATT3"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT4", System.Data.SqlDbType.NVarChar, 50, "ATT4"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT5", System.Data.SqlDbType.NVarChar, 50, "ATT5"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HANDLE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AREA", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AREA", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT1", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT1", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT2", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT2", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT3", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT3", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT4", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT4", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT5", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT5", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AUTONUM", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AUTONUM", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MAPID", System.Data.SqlDbType.TinyInt, 1, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MAPID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ORGPAVEMENT", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ORGPAVEMENT", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ORGRTYPE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ORGRTYPE", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_PARENTCADID", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "PARENTCADID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_PAVEMENT", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "PAVEMENT", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_RTYPE", System.Data.SqlDbType.NVarChar, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "RTYPE", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_STATUS", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "STATUS", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_X", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "X", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Y", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Y", System.Data.DataRowVersion.Original, null));
			// 
			// cmdInsertHitCrt
			// 
			this.cmdInsertHitCrt.CommandText = @"INSERT INTO HIT_GVC(AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid) VALUES (@AUTONUM, @HANDLE, @MAPID, @BLOCK, @LAYER, @OBJECTID, @VAK, @GRTYPE, @OM_GRTYPE, @AF_GRTYPE, @HOEVEELHEID, @ATT1, @X, @Y, @STATUS, @LastUpdate, @rowguid); SELECT AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid FROM HIT_GVC WHERE (HANDLE = @HANDLE)";
			this.cmdInsertHitCrt.Connection = this.sqlConnection;
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.Int, 4, "MAPID"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@BLOCK", System.Data.SqlDbType.NVarChar, 50, "BLOCK"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LAYER", System.Data.SqlDbType.NVarChar, 50, "LAYER"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OBJECTID", System.Data.SqlDbType.NVarChar, 50, "OBJECTID"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@VAK", System.Data.SqlDbType.NVarChar, 50, "VAK"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@GRTYPE", System.Data.SqlDbType.NVarChar, 50, "GRTYPE"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "OM_GRTYPE"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "AF_GRTYPE"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, "HOEVEELHEID"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LastUpdate", System.Data.SqlDbType.NVarChar, 14, "LastUpdate"));
			this.cmdInsertHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// cmdSelectHitCrt
			// 
			this.cmdSelectHitCrt.CommandText = "SELECT AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF" +
				"_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid FROM HIT_GVC WHERE" +
				" handle = @handle";
			this.cmdSelectHitCrt.Connection = this.sqlConnection;
			this.cmdSelectHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@handle", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			// 
			// cmdUpdateHitCrt
			// 
			this.cmdUpdateHitCrt.CommandText = "UPDATE HIT_GVC SET AUTONUM = @AUTONUM, HANDLE = @HANDLE, MAPID = @MAPID, BLOCK = " +
				"@BLOCK, LAYER = @LAYER, OBJECTID = @OBJECTID, VAK = @VAK, GRTYPE = @GRTYPE, OM_G" +
				"RTYPE = @OM_GRTYPE, AF_GRTYPE = @AF_GRTYPE, HOEVEELHEID = @HOEVEELHEID, ATT1 = @" +
				"ATT1, X = @X, Y = @Y, STATUS = @STATUS, LastUpdate = @LastUpdate WHERE (HANDLE =" +
				" @Original_HANDLE) AND (AF_GRTYPE = @Original_AF_GRTYPE OR @Original_AF_GRTYPE I" +
				"S NULL AND AF_GRTYPE IS NULL) AND (ATT1 = @Original_ATT1 OR @Original_ATT1 IS NU" +
				"LL AND ATT1 IS NULL) AND (AUTONUM = @Original_AUTONUM) AND (BLOCK = @Original_BL" +
				"OCK OR @Original_BLOCK IS NULL AND BLOCK IS NULL) AND (GRTYPE = @Original_GRTYPE" +
				" OR @Original_GRTYPE IS NULL AND GRTYPE IS NULL) AND (HOEVEELHEID = @Original_HO" +
				"EVEELHEID OR @Original_HOEVEELHEID IS NULL AND HOEVEELHEID IS NULL) AND (LAYER =" +
				" @Original_LAYER OR @Original_LAYER IS NULL AND LAYER IS NULL) AND (LastUpdate =" +
				" @Original_LastUpdate OR @Original_LastUpdate IS NULL AND LastUpdate IS NULL) AN" +
				"D (MAPID = @Original_MAPID OR @Original_MAPID IS NULL AND MAPID IS NULL) AND (OB" +
				"JECTID = @Original_OBJECTID OR @Original_OBJECTID IS NULL AND OBJECTID IS NULL) " +
				"AND (OM_GRTYPE = @Original_OM_GRTYPE OR @Original_OM_GRTYPE IS NULL AND OM_GRTYP" +
				"E IS NULL) AND (STATUS = @Original_STATUS OR @Original_STATUS IS NULL AND STATUS" +
				" IS NULL) AND (VAK = @Original_VAK OR @Original_VAK IS NULL AND VAK IS NULL) AND" +
				" (X = @Original_X OR @Original_X IS NULL AND X IS NULL) AND (Y = @Original_Y OR " +
				"@Original_Y IS NULL AND Y IS NULL); SELECT AUTONUM, HANDLE, MAPID, BLOCK, LAYER," +
				" OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, L" +
				"astUpdate, rowguid FROM HIT_GVC WHERE (HANDLE = @HANDLE)";
			this.cmdUpdateHitCrt.Connection = this.sqlConnection;
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.Int, 4, "MAPID"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@BLOCK", System.Data.SqlDbType.NVarChar, 50, "BLOCK"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LAYER", System.Data.SqlDbType.NVarChar, 50, "LAYER"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OBJECTID", System.Data.SqlDbType.NVarChar, 50, "OBJECTID"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@VAK", System.Data.SqlDbType.NVarChar, 50, "VAK"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@GRTYPE", System.Data.SqlDbType.NVarChar, 50, "GRTYPE"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "OM_GRTYPE"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "AF_GRTYPE"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, "HOEVEELHEID"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LastUpdate", System.Data.SqlDbType.NVarChar, 14, "LastUpdate"));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HANDLE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AF_GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT1", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT1", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AUTONUM", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AUTONUM", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_BLOCK", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "BLOCK", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HOEVEELHEID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_LAYER", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "LAYER", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_LastUpdate", System.Data.SqlDbType.NVarChar, 14, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "LastUpdate", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MAPID", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MAPID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_OBJECTID", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "OBJECTID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "OM_GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_STATUS", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "STATUS", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_VAK", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "VAK", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_X", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "X", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitCrt.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Y", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Y", System.Data.DataRowVersion.Original, null));
			// 
			// dataSet
			// 
			this.dataSet.DataSetName = "NewDataSet";
			this.dataSet.Locale = new System.Globalization.CultureInfo("nl-NL");
			// 
			// dtaHitPavement
			// 
			this.dtaHitPavement.DeleteCommand = this.sqlDeleteCommand2;
			this.dtaHitPavement.InsertCommand = this.sqlInsertCommand3;
			this.dtaHitPavement.SelectCommand = this.sqlSelectCommand3;
			this.dtaHitPavement.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																									 new System.Data.Common.DataTableMapping("Table", "HIT_Pavements", new System.Data.Common.DataColumnMapping[] {
																																																					  new System.Data.Common.DataColumnMapping("Pavement", "Pavement"),
																																																					  new System.Data.Common.DataColumnMapping("Description_Eng", "Description_Eng"),
																																																					  new System.Data.Common.DataColumnMapping("Color_Name", "Color_Name"),
																																																					  new System.Data.Common.DataColumnMapping("rowguid", "rowguid")})});
			this.dtaHitPavement.UpdateCommand = this.sqlUpdateCommand2;
			// 
			// sqlDeleteCommand2
			// 
			this.sqlDeleteCommand2.CommandText = @"DELETE FROM HIT_Pavements WHERE (Pavement = @Original_Pavement) AND (Color_Name = @Original_Color_Name OR @Original_Color_Name IS NULL AND Color_Name IS NULL) AND (Description_Eng = @Original_Description_Eng OR @Original_Description_Eng IS NULL AND Description_Eng IS NULL) AND (rowguid = @Original_rowguid)";
			this.sqlDeleteCommand2.Connection = this.sqlConnection;
			this.sqlDeleteCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Pavement", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Pavement", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Color_Name", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Color_Name", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Description_Eng", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Description_Eng", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "rowguid", System.Data.DataRowVersion.Original, null));
			// 
			// sqlInsertCommand3
			// 
			this.sqlInsertCommand3.CommandText = "INSERT INTO HIT_Pavements(Pavement, Description_Eng, Color_Name, rowguid) VALUES " +
				"(@Pavement, @Description_Eng, @Color_Name, @rowguid); SELECT Pavement, Descripti" +
				"on_Eng, Color_Name, rowguid FROM HIT_Pavements WHERE (Pavement = @Pavement)";
			this.sqlInsertCommand3.Connection = this.sqlConnection;
			this.sqlInsertCommand3.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Pavement", System.Data.SqlDbType.NVarChar, 50, "Pavement"));
			this.sqlInsertCommand3.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Description_Eng", System.Data.SqlDbType.NVarChar, 20, "Description_Eng"));
			this.sqlInsertCommand3.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Color_Name", System.Data.SqlDbType.NVarChar, 15, "Color_Name"));
			this.sqlInsertCommand3.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// sqlSelectCommand3
			// 
			this.sqlSelectCommand3.CommandText = "SELECT Pavement, Description_Eng, Color_Name, rowguid FROM HIT_Pavements";
			this.sqlSelectCommand3.Connection = this.sqlConnection;
			// 
			// sqlUpdateCommand2
			// 
			this.sqlUpdateCommand2.CommandText = @"UPDATE HIT_Pavements SET Pavement = @Pavement, Description_Eng = @Description_Eng, Color_Name = @Color_Name, rowguid = @rowguid WHERE (Pavement = @Original_Pavement) AND (Color_Name = @Original_Color_Name OR @Original_Color_Name IS NULL AND Color_Name IS NULL) AND (Description_Eng = @Original_Description_Eng OR @Original_Description_Eng IS NULL AND Description_Eng IS NULL) AND (rowguid = @Original_rowguid); SELECT Pavement, Description_Eng, Color_Name, rowguid FROM HIT_Pavements WHERE (Pavement = @Pavement)";
			this.sqlUpdateCommand2.Connection = this.sqlConnection;
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Pavement", System.Data.SqlDbType.NVarChar, 50, "Pavement"));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Description_Eng", System.Data.SqlDbType.NVarChar, 20, "Description_Eng"));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Color_Name", System.Data.SqlDbType.NVarChar, 15, "Color_Name"));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Pavement", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Pavement", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Color_Name", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Color_Name", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Description_Eng", System.Data.SqlDbType.NVarChar, 20, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Description_Eng", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand2.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "rowguid", System.Data.DataRowVersion.Original, null));
			// 
			// sqlInsertCommand1
			// 
			this.sqlInsertCommand1.CommandText = @"INSERT INTO GBGRTYP(CO_GRGRP, CO_GRTYP, OM_GRTYP, AF_GRTYP, CO_EENHE, LD_GRTYP, VV_GRTYP, CO_KLEUR, ID_SYMB, rowguid) VALUES (@CO_GRGRP, @CO_GRTYP, @OM_GRTYP, @AF_GRTYP, @CO_EENHE, @LD_GRTYP, @VV_GRTYP, @CO_KLEUR, @ID_SYMB, @rowguid); SELECT { fn CONCAT(CO_GRGRP, CO_GRTYP) } AS grtype, CO_GRGRP, CO_GRTYP, OM_GRTYP, AF_GRTYP, CO_EENHE, LD_GRTYP, VV_GRTYP, CO_KLEUR, ID_SYMB, rowguid FROM GBGRTYP";
			this.sqlInsertCommand1.Connection = this.sqlConnection;
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CO_GRGRP", System.Data.SqlDbType.NVarChar, 1, "CO_GRGRP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CO_GRTYP", System.Data.SqlDbType.NVarChar, 3, "CO_GRTYP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OM_GRTYP", System.Data.SqlDbType.NVarChar, 30, "OM_GRTYP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AF_GRTYP", System.Data.SqlDbType.NVarChar, 5, "AF_GRTYP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CO_EENHE", System.Data.SqlDbType.NVarChar, 6, "CO_EENHE"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LD_GRTYP", System.Data.SqlDbType.Float, 8, "LD_GRTYP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@VV_GRTYP", System.Data.SqlDbType.Float, 8, "VV_GRTYP"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CO_KLEUR", System.Data.SqlDbType.Float, 8, "CO_KLEUR"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ID_SYMB", System.Data.SqlDbType.Float, 8, "ID_SYMB"));
			this.sqlInsertCommand1.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// sqlSelectCommand1
			// 
			this.sqlSelectCommand1.CommandText = "SELECT { fn CONCAT(CO_GRGRP, CO_GRTYP) } AS grtype, CO_GRGRP, CO_GRTYP, OM_GRTYP," +
				" AF_GRTYP, CO_EENHE, LD_GRTYP, VV_GRTYP, CO_KLEUR, ID_SYMB, rowguid FROM GBGRTYP" +
				" WHERE (CO_EENHE = \'m2\')";
			this.sqlSelectCommand1.Connection = this.sqlConnection;
			// 
			// dtaHitRtype
			// 
			this.dtaHitRtype.InsertCommand = this.sqlInsertCommand4;
			this.dtaHitRtype.SelectCommand = this.sqlSelectCommand4;
			this.dtaHitRtype.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																								  new System.Data.Common.DataTableMapping("Table", "HIT_RTypes", new System.Data.Common.DataColumnMapping[] {
																																																				new System.Data.Common.DataColumnMapping("RType", "RType"),
																																																				new System.Data.Common.DataColumnMapping("Description", "Description"),
																																																				new System.Data.Common.DataColumnMapping("Description_Eng", "Description_Eng"),
																																																				new System.Data.Common.DataColumnMapping("Color_Name", "Color_Name"),
																																																				new System.Data.Common.DataColumnMapping("rowguid", "rowguid")})});
			// 
			// sqlInsertCommand4
			// 
			this.sqlInsertCommand4.CommandText = "INSERT INTO HIT_RTypes(RType, Description, Description_Eng, Color_Name, rowguid) " +
				"VALUES (@RType, @Description, @Description_Eng, @Color_Name, @rowguid); SELECT R" +
				"Type, Description, Description_Eng, Color_Name, rowguid FROM HIT_RTypes";
			this.sqlInsertCommand4.Connection = this.sqlConnection;
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@RType", System.Data.SqlDbType.NVarChar, 4, "RType"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Description", System.Data.SqlDbType.NVarChar, 50, "Description"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Description_Eng", System.Data.SqlDbType.NVarChar, 50, "Description_Eng"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Color_Name", System.Data.SqlDbType.NVarChar, 15, "Color_Name"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// sqlSelectCommand4
			// 
			this.sqlSelectCommand4.CommandText = "SELECT RType, Description, Description_Eng, Color_Name, rowguid FROM HIT_RTypes";
			this.sqlSelectCommand4.Connection = this.sqlConnection;
			this.Load += new System.EventHandler(this.Page_Load);
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).EndInit();

		}
		#endregion

		private void btnSave_Click(object sender, System.EventArgs e)
		{
			// save
			dtaHitCrt.Update(dataSet,"HIT_CTR");
			// javascript
			Response.Write("<script>\n");
			// refresh the changed layer
			Response.Write("if(window.opener)\n{\n\twindow.opener.refreshLayer('" + Request.Params["layer"]+ "');\n}\n");
			// close window
			Response.Write("window.close();\n");
			Response.Write("</script>");
		}

		private void btnCancel_Click(object sender, System.EventArgs e)
		{
			// close window
			Response.Write("<script>window.close();</script>");
		}

		private void Dropdownlist1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}
	}
}
