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
	/// Summary description for bestemmingsvlak.
	/// </summary>
	public class bestemmingsvlak : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.TextBox txtPlangebiedNaam;
		protected System.Web.UI.WebControls.TextBox txtBestemmingIdn;
		protected System.Web.UI.WebControls.TextBox txtBestemmingCategorie;
		protected System.Web.UI.WebControls.Button btnCancel;
		protected System.Web.UI.WebControls.Button btnSave;
		protected System.Data.DataSet dataSet;
		protected System.Data.OleDb.OleDbConnection odcDetailsDatabase;
		protected System.Data.OleDb.OleDbDataAdapter dtaBestemmingsNamen;
		protected System.Data.OleDb.OleDbCommand cmdBestemmingsNamenSelect;
		protected System.Web.UI.WebControls.DropDownList ddlBestemmingNaam;
		protected System.Data.OleDb.OleDbDataAdapter dtaBestemmingsVlakken;
		protected System.Data.OleDb.OleDbCommand cmdBestemmingsVlakkenSelect;
		protected System.Data.OleDb.OleDbCommand cmdBestemmingsVlakkenInsert;
		protected System.Data.OleDb.OleDbCommand cmdBestemmingsVlakkenUpdate;
		protected System.Data.OleDb.OleDbCommand cmdBestemmingsVlakkenDelete;
		protected System.Web.UI.WebControls.TextBox txtPlanGebiedIdn;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// check if params were supplied
			if(Request.Params["key"] == null)  throw new HttpException("parameter 'key' was not provided!");
			if(Request.Params["layer"] == null)  throw new HttpException("parameter 'layer' was not provided!");

			if(!IsPostBack)
			{
				// lookup data,...
				dtaBestemmingsNamen.Fill(dataSet,"bestemmings_namen");
				dtaBestemmingsVlakken.SelectCommand.Parameters["bestemming_idn"].Value = Request.Params["key"];
				dtaBestemmingsVlakken.Fill(dataSet,"bestemmingsvlak");
				
				if(dataSet.Tables["bestemmingsvlak"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["bestemmingsvlak"].Rows.Count + " found!)");
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

				if(dataSet.Tables["bestemmingsvlak"].Rows.Count != 1) throw new HttpException("expected to find 1 record for key:" + Request.Params["key"]+ "("+ dataSet.Tables["bestemmingsvlak"].Rows.Count + " found!)");

				// set values if they were changed
				DataRow row = dataSet.Tables["bestemmingsvlak"].Rows[0];
				row["bestemmings_naam"] = ddlBestemmingNaam.SelectedValue;
				row["categorie"] = txtBestemmingCategorie.Text;
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
			this.dataSet = new System.Data.DataSet();
			this.odcDetailsDatabase = new System.Data.OleDb.OleDbConnection();
			this.dtaBestemmingsNamen = new System.Data.OleDb.OleDbDataAdapter();
			this.cmdBestemmingsNamenSelect = new System.Data.OleDb.OleDbCommand();
			this.dtaBestemmingsVlakken = new System.Data.OleDb.OleDbDataAdapter();
			this.cmdBestemmingsVlakkenDelete = new System.Data.OleDb.OleDbCommand();
			this.cmdBestemmingsVlakkenInsert = new System.Data.OleDb.OleDbCommand();
			this.cmdBestemmingsVlakkenSelect = new System.Data.OleDb.OleDbCommand();
			this.cmdBestemmingsVlakkenUpdate = new System.Data.OleDb.OleDbCommand();
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).BeginInit();
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			// 
			// dataSet
			// 
			this.dataSet.DataSetName = "NewDataSet";
			this.dataSet.Locale = new System.Globalization.CultureInfo("en-US");
			// 
			// odcDetailsDatabase
			// 
			this.odcDetailsDatabase.ConnectionString = ((string)(configurationAppSettings.GetValue("details-connection-string", typeof(string))));
			// 
			// dtaBestemmingsNamen
			// 
			this.dtaBestemmingsNamen.SelectCommand = this.cmdBestemmingsNamenSelect;
			this.dtaBestemmingsNamen.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																										  new System.Data.Common.DataTableMapping("Table", "bestemmings_namen", new System.Data.Common.DataColumnMapping[] {
																																																							   new System.Data.Common.DataColumnMapping("naam", "naam")})});
			// 
			// cmdBestemmingsNamenSelect
			// 
			this.cmdBestemmingsNamenSelect.CommandText = "SELECT naam FROM bestemmings_namen";
			this.cmdBestemmingsNamenSelect.Connection = this.odcDetailsDatabase;
			// 
			// dtaBestemmingsVlakken
			// 
			this.dtaBestemmingsVlakken.DeleteCommand = this.cmdBestemmingsVlakkenDelete;
			this.dtaBestemmingsVlakken.InsertCommand = this.cmdBestemmingsVlakkenInsert;
			this.dtaBestemmingsVlakken.SelectCommand = this.cmdBestemmingsVlakkenSelect;
			this.dtaBestemmingsVlakken.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																											new System.Data.Common.DataTableMapping("Table", "bestemmingsvlak", new System.Data.Common.DataColumnMapping[] {
																																																							   new System.Data.Common.DataColumnMapping("bestemming_idn", "bestemming_idn"),
																																																							   new System.Data.Common.DataColumnMapping("bestemmings_naam", "bestemmings_naam"),
																																																							   new System.Data.Common.DataColumnMapping("categorie", "categorie"),
																																																							   new System.Data.Common.DataColumnMapping("plangebied_idn", "plangebied_idn"),
																																																							   new System.Data.Common.DataColumnMapping("plangebied_naam", "plangebied_naam")})});
			this.dtaBestemmingsVlakken.UpdateCommand = this.cmdBestemmingsVlakkenUpdate;
			// 
			// cmdBestemmingsVlakkenDelete
			// 
			this.cmdBestemmingsVlakkenDelete.CommandText = @"DELETE FROM bestemmingsvlak WHERE (bestemming_idn = ?) AND (plangebied_idn = ?) AND (bestemmings_naam = ? OR ? IS NULL AND bestemmings_naam IS NULL) AND (categorie = ? OR ? IS NULL AND categorie IS NULL) AND (plangebied_naam = ? OR ? IS NULL AND plangebied_naam IS NULL)";
			this.cmdBestemmingsVlakkenDelete.Connection = this.odcDetailsDatabase;
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemming_idn", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemming_idn", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_idn", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_idn", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemmings_naam", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemmings_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemmings_naam1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemmings_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_categorie", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "categorie", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_categorie1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "categorie", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_naam", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenDelete.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_naam1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_naam", System.Data.DataRowVersion.Original, null));
			// 
			// cmdBestemmingsVlakkenInsert
			// 
			this.cmdBestemmingsVlakkenInsert.CommandText = "INSERT INTO bestemmingsvlak(bestemming_idn, bestemmings_naam, categorie, plangebi" +
				"ed_idn, plangebied_naam) VALUES (?, ?, ?, ?, ?)";
			this.cmdBestemmingsVlakkenInsert.Connection = this.odcDetailsDatabase;
			this.cmdBestemmingsVlakkenInsert.Parameters.Add(new System.Data.OleDb.OleDbParameter("bestemming_idn", System.Data.OleDb.OleDbType.VarWChar, 50, "bestemming_idn"));
			this.cmdBestemmingsVlakkenInsert.Parameters.Add(new System.Data.OleDb.OleDbParameter("bestemmings_naam", System.Data.OleDb.OleDbType.VarWChar, 50, "bestemmings_naam"));
			this.cmdBestemmingsVlakkenInsert.Parameters.Add(new System.Data.OleDb.OleDbParameter("categorie", System.Data.OleDb.OleDbType.VarWChar, 50, "categorie"));
			this.cmdBestemmingsVlakkenInsert.Parameters.Add(new System.Data.OleDb.OleDbParameter("plangebied_idn", System.Data.OleDb.OleDbType.VarWChar, 50, "plangebied_idn"));
			this.cmdBestemmingsVlakkenInsert.Parameters.Add(new System.Data.OleDb.OleDbParameter("plangebied_naam", System.Data.OleDb.OleDbType.VarWChar, 50, "plangebied_naam"));
			// 
			// cmdBestemmingsVlakkenSelect
			// 
			this.cmdBestemmingsVlakkenSelect.CommandText = "SELECT bestemming_idn, bestemmings_naam, categorie, plangebied_idn, plangebied_na" +
				"am FROM bestemmingsvlak WHERE (bestemming_idn = ?)";
			this.cmdBestemmingsVlakkenSelect.Connection = this.odcDetailsDatabase;
			this.cmdBestemmingsVlakkenSelect.Parameters.Add(new System.Data.OleDb.OleDbParameter("bestemming_idn", System.Data.OleDb.OleDbType.VarWChar, 50, "bestemming_idn"));
			// 
			// cmdBestemmingsVlakkenUpdate
			// 
			this.cmdBestemmingsVlakkenUpdate.CommandText = @"UPDATE bestemmingsvlak SET bestemming_idn = ?, bestemmings_naam = ?, categorie = ?, plangebied_idn = ?, plangebied_naam = ? WHERE (bestemming_idn = ?) AND (plangebied_idn = ?) AND (bestemmings_naam = ? OR ? IS NULL AND bestemmings_naam IS NULL) AND (categorie = ? OR ? IS NULL AND categorie IS NULL) AND (plangebied_naam = ? OR ? IS NULL AND plangebied_naam IS NULL)";
			this.cmdBestemmingsVlakkenUpdate.Connection = this.odcDetailsDatabase;
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("bestemming_idn", System.Data.OleDb.OleDbType.VarWChar, 50, "bestemming_idn"));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("bestemmings_naam", System.Data.OleDb.OleDbType.VarWChar, 50, "bestemmings_naam"));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("categorie", System.Data.OleDb.OleDbType.VarWChar, 50, "categorie"));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("plangebied_idn", System.Data.OleDb.OleDbType.VarWChar, 50, "plangebied_idn"));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("plangebied_naam", System.Data.OleDb.OleDbType.VarWChar, 50, "plangebied_naam"));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemming_idn", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemming_idn", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_idn", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_idn", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemmings_naam", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemmings_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_bestemmings_naam1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "bestemmings_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_categorie", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "categorie", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_categorie1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "categorie", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_naam", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_naam", System.Data.DataRowVersion.Original, null));
			this.cmdBestemmingsVlakkenUpdate.Parameters.Add(new System.Data.OleDb.OleDbParameter("Original_plangebied_naam1", System.Data.OleDb.OleDbType.VarWChar, 50, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "plangebied_naam", System.Data.DataRowVersion.Original, null));
			this.Load += new System.EventHandler(this.Page_Load);
			((System.ComponentModel.ISupportInitialize)(this.dataSet)).EndInit();

		}
		#endregion

		private void btnSave_Click(object sender, System.EventArgs e)
		{
			// save
			dtaBestemmingsVlakken.Update(dataSet,"bestemmingsvlak");
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
