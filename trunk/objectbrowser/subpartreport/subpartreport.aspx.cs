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

namespace QI02.subpartreport
{
	/// <summary>
	/// Summary description for pinpoint.
	/// </summary>
	public class subpartreport : System.Web.UI.Page
	{
		private string framedFile;

		private void Page_Load(object sender, System.EventArgs e)
		{
			framedFile = Request.QueryString["go"] + ".aspx";
			if((Request.QueryString["x"] != null) && (Request.QueryString["y"] != null))
			{
				framedFile += "?x=" + Request.QueryString["x"];
				framedFile += "&y=" + Request.QueryString["y"];
			}
		}
		
		protected string getFramedFile()
		{
			return framedFile;
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
	}
}
