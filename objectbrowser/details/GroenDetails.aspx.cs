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
	/// Summary description for BomenDetails.
	/// </summary>
	public class GroenDetails : System.Web.UI.Page
	{
		protected System.Data.SqlClient.SqlDataAdapter dtaHitGvc;
		protected System.Data.SqlClient.SqlCommand cmdSelectHitGvc;
		protected System.Data.SqlClient.SqlCommand cmdInsertHitGvc;
		protected System.Data.SqlClient.SqlCommand cmdUpdateHitGvc;
		protected System.Web.UI.WebControls.Label lblHandle;
		protected System.Web.UI.WebControls.Button btnSave;
		protected System.Data.DataSet dataSet;
		protected System.Data.SqlClient.SqlDataAdapter dtaGbGrTyp;
		protected System.Data.SqlClient.SqlCommand sqlSelectCommand1;
		protected System.Data.SqlClient.SqlCommand sqlInsertCommand1;
		protected System.Web.UI.WebControls.DropDownList ddlGrType;
		protected System.Web.UI.WebControls.Button btnCancel;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Data.SqlClient.SqlConnection sqlConnection;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// check if params were supplied
			if(Request.Params["key"] == null)  throw new HttpException("parameter 'key' was not provided!");
			if(Request.Params["layer"] == null)  throw new HttpException("parameter 'layer' was not provided!");

			if(!IsPostBack)
			{
				// lookup data,...
				dtaHitGvc.SelectCommand.Parameters["@handle"].Value = Request.Params["key"];
				dtaHitGvc.Fill(dataSet,"HIT_GVC");
				dtaGbGrTyp.Fill(dataSet,"GBGRTYP");
				//				dtaBestemmingsVlakken.SelectCommand.Parameters["bestemming_idn"].Value = Request.Params["key"];
				//				dtaBestemmingsVlakken.Fill(dataSet,"bestemmingsvlak");
				
				if(dataSet.Tables["HIT_GVC"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["HIT_GVC"].Rows.Count + " found!)");
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
				if(dataSet.Tables["HIT_GVC"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["HIT_GVC"].Rows.Count + " found!)");

				// lookup the values inside the datatable
				DataRow lookupRow = dataSet.Tables["GBGRTYP"].Select("grtype = '" + ddlGrType.SelectedValue + "'")[0];
				// set values if they were changed
				DataRow row = dataSet.Tables["HIT_GVC"].Rows[0];
				row["GRTYPE"] = lookupRow["grtype"];
				row["OM_GRTYPE"] = lookupRow["OM_GRTYP"];
				row["AF_GRTYPE"] = lookupRow["AF_GRTYP"];
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
			this.dtaHitGvc = new System.Data.SqlClient.SqlDataAdapter();
			this.cmdInsertHitGvc = new System.Data.SqlClient.SqlCommand();
			this.cmdSelectHitGvc = new System.Data.SqlClient.SqlCommand();
			this.cmdUpdateHitGvc = new System.Data.SqlClient.SqlCommand();
			this.dataSet = new System.Data.DataSet();
			this.dtaGbGrTyp = new System.Data.SqlClient.SqlDataAdapter();
			this.sqlInsertCommand1 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand1 = new System.Data.SqlClient.SqlCommand();
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).BeginInit();
			// 
			// sqlConnection
			// 
			this.sqlConnection.ConnectionString = ((string)(configurationAppSettings.GetValue("details-connection-string", typeof(string))));
			// 
			// dtaHitGvc
			// 
			this.dtaHitGvc.InsertCommand = this.cmdInsertHitGvc;
			this.dtaHitGvc.SelectCommand = this.cmdSelectHitGvc;
			this.dtaHitGvc.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																								new System.Data.Common.DataTableMapping("Table", "HIT_GVC", new System.Data.Common.DataColumnMapping[] {
																																																		   new System.Data.Common.DataColumnMapping("AUTONUM", "AUTONUM"),
																																																		   new System.Data.Common.DataColumnMapping("HANDLE", "HANDLE"),
																																																		   new System.Data.Common.DataColumnMapping("MAPID", "MAPID"),
																																																		   new System.Data.Common.DataColumnMapping("BLOCK", "BLOCK"),
																																																		   new System.Data.Common.DataColumnMapping("LAYER", "LAYER"),
																																																		   new System.Data.Common.DataColumnMapping("OBJECTID", "OBJECTID"),
																																																		   new System.Data.Common.DataColumnMapping("VAK", "VAK"),
																																																		   new System.Data.Common.DataColumnMapping("GRTYPE", "GRTYPE"),
																																																		   new System.Data.Common.DataColumnMapping("OM_GRTYPE", "OM_GRTYPE"),
																																																		   new System.Data.Common.DataColumnMapping("AF_GRTYPE", "AF_GRTYPE"),
																																																		   new System.Data.Common.DataColumnMapping("HOEVEELHEID", "HOEVEELHEID"),
																																																		   new System.Data.Common.DataColumnMapping("ATT1", "ATT1"),
																																																		   new System.Data.Common.DataColumnMapping("X", "X"),
																																																		   new System.Data.Common.DataColumnMapping("Y", "Y"),
																																																		   new System.Data.Common.DataColumnMapping("STATUS", "STATUS"),
																																																		   new System.Data.Common.DataColumnMapping("LastUpdate", "LastUpdate"),
																																																		   new System.Data.Common.DataColumnMapping("rowguid", "rowguid")})});
			this.dtaHitGvc.UpdateCommand = this.cmdUpdateHitGvc;
			// 
			// cmdInsertHitGvc
			// 
			this.cmdInsertHitGvc.CommandText = @"INSERT INTO HIT_GVC(AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid) VALUES (@AUTONUM, @HANDLE, @MAPID, @BLOCK, @LAYER, @OBJECTID, @VAK, @GRTYPE, @OM_GRTYPE, @AF_GRTYPE, @HOEVEELHEID, @ATT1, @X, @Y, @STATUS, @LastUpdate, @rowguid); SELECT AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid FROM HIT_GVC WHERE (HANDLE = @HANDLE)";
			this.cmdInsertHitGvc.Connection = this.sqlConnection;
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.Int, 4, "MAPID"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@BLOCK", System.Data.SqlDbType.NVarChar, 50, "BLOCK"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LAYER", System.Data.SqlDbType.NVarChar, 50, "LAYER"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OBJECTID", System.Data.SqlDbType.NVarChar, 50, "OBJECTID"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@VAK", System.Data.SqlDbType.NVarChar, 50, "VAK"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@GRTYPE", System.Data.SqlDbType.NVarChar, 50, "GRTYPE"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "OM_GRTYPE"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "AF_GRTYPE"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, "HOEVEELHEID"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LastUpdate", System.Data.SqlDbType.NVarChar, 14, "LastUpdate"));
			this.cmdInsertHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@rowguid", System.Data.SqlDbType.UniqueIdentifier, 16, "rowguid"));
			// 
			// cmdSelectHitGvc
			// 
			this.cmdSelectHitGvc.CommandText = "SELECT AUTONUM, HANDLE, MAPID, BLOCK, LAYER, OBJECTID, VAK, GRTYPE, OM_GRTYPE, AF" +
				"_GRTYPE, HOEVEELHEID, ATT1, X, Y, STATUS, LastUpdate, rowguid FROM HIT_GVC WHERE" +
				" handle = @handle";
			this.cmdSelectHitGvc.Connection = this.sqlConnection;
			this.cmdSelectHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@handle", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			// 
			// cmdUpdateHitGvc
			// 
			this.cmdUpdateHitGvc.CommandText = "UPDATE HIT_GVC SET AUTONUM = @AUTONUM, HANDLE = @HANDLE, MAPID = @MAPID, BLOCK = " +
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
			this.cmdUpdateHitGvc.Connection = this.sqlConnection;
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AUTONUM", System.Data.SqlDbType.Int, 4, "AUTONUM"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HANDLE", System.Data.SqlDbType.NVarChar, 10, "HANDLE"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MAPID", System.Data.SqlDbType.Int, 4, "MAPID"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@BLOCK", System.Data.SqlDbType.NVarChar, 50, "BLOCK"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LAYER", System.Data.SqlDbType.NVarChar, 50, "LAYER"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OBJECTID", System.Data.SqlDbType.NVarChar, 50, "OBJECTID"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@VAK", System.Data.SqlDbType.NVarChar, 50, "VAK"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@GRTYPE", System.Data.SqlDbType.NVarChar, 50, "GRTYPE"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "OM_GRTYPE"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, "AF_GRTYPE"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, "HOEVEELHEID"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ATT1", System.Data.SqlDbType.NVarChar, 50, "ATT1"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@X", System.Data.SqlDbType.Float, 8, "X"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Y", System.Data.SqlDbType.Float, 8, "Y"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@STATUS", System.Data.SqlDbType.NVarChar, 15, "STATUS"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@LastUpdate", System.Data.SqlDbType.NVarChar, 14, "LastUpdate"));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HANDLE", System.Data.SqlDbType.NVarChar, 10, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HANDLE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AF_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AF_GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ATT1", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ATT1", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_AUTONUM", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "AUTONUM", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_BLOCK", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "BLOCK", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_HOEVEELHEID", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "HOEVEELHEID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_LAYER", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "LAYER", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_LastUpdate", System.Data.SqlDbType.NVarChar, 14, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "LastUpdate", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MAPID", System.Data.SqlDbType.Int, 4, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MAPID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_OBJECTID", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "OBJECTID", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_OM_GRTYPE", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "OM_GRTYPE", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_STATUS", System.Data.SqlDbType.NVarChar, 15, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "STATUS", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_VAK", System.Data.SqlDbType.NVarChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "VAK", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_X", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "X", System.Data.DataRowVersion.Original, null));
			this.cmdUpdateHitGvc.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_Y", System.Data.SqlDbType.Float, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "Y", System.Data.DataRowVersion.Original, null));
			// 
			// dataSet
			// 
			this.dataSet.DataSetName = "NewDataSet";
			this.dataSet.Locale = new System.Globalization.CultureInfo("nl-NL");
			// 
			// dtaGbGrTyp
			// 
			this.dtaGbGrTyp.InsertCommand = this.sqlInsertCommand1;
			this.dtaGbGrTyp.SelectCommand = this.sqlSelectCommand1;
			this.dtaGbGrTyp.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																								 new System.Data.Common.DataTableMapping("Table", "GBGRTYP", new System.Data.Common.DataColumnMapping[] {
																																																			new System.Data.Common.DataColumnMapping("grtype", "grtype"),
																																																			new System.Data.Common.DataColumnMapping("CO_GRGRP", "CO_GRGRP"),
																																																			new System.Data.Common.DataColumnMapping("CO_GRTYP", "CO_GRTYP"),
																																																			new System.Data.Common.DataColumnMapping("OM_GRTYP", "OM_GRTYP"),
																																																			new System.Data.Common.DataColumnMapping("AF_GRTYP", "AF_GRTYP"),
																																																			new System.Data.Common.DataColumnMapping("CO_EENHE", "CO_EENHE"),
																																																			new System.Data.Common.DataColumnMapping("LD_GRTYP", "LD_GRTYP"),
																																																			new System.Data.Common.DataColumnMapping("VV_GRTYP", "VV_GRTYP"),
																																																			new System.Data.Common.DataColumnMapping("CO_KLEUR", "CO_KLEUR"),
																																																			new System.Data.Common.DataColumnMapping("ID_SYMB", "ID_SYMB"),
																																																			new System.Data.Common.DataColumnMapping("rowguid", "rowguid")})});
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
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			this.Load += new System.EventHandler(this.Page_Load);
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).EndInit();

		}
		#endregion

		private void btnSave_Click(object sender, System.EventArgs e)
		{
			// save
			dtaHitGvc.Update(dataSet,"HIT_GVC");
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
	}
}
