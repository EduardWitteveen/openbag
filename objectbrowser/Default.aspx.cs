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

using System.Xml;
using System.Xml.XPath;
using System.Configuration;
using HawarIT.WebLibrary;

namespace QI02
{
	/// <summary>
	/// Summary description for Viewer.
	/// </summary>
	public class Viewer : System.Web.UI.Page
	{
		protected XmlParser parser;
		protected XmlNodeList legendaColors;
		protected XmlNodeList mapLayers;
		protected XmlNodeList menuLayerNodes;
		protected XmlNodeList menuHeaderNodes;
		protected XmlNode filterNode;
		protected XmlNodeList filterLayers;
		protected XmlNodeList startswithLayers;


		private void Page_Load(object sender, System.EventArgs e)
		{
			string filename = Request.MapPath(ConfigurationSettings.AppSettings["viewer-config"]);
			parser = new XmlParser(filename);
			mapLayers = parser.Query("/viewer/layers/layer");
			menuLayerNodes = parser.Query("/viewer/legenda/legenda-header/legenda-item");
			menuHeaderNodes = parser.Query("/viewer/legenda/legenda-header");
			legendaColors = parser.Query("/viewer/legenda/legenda-colors/color-legenda");
			
			filterNode = parser.QueryNode("/viewer/legenda/legenda-header[@type=\"filter\"]");
			filterLayers = parser.Query("/viewer/layers/layer[@filter]");
			startswithLayers = parser.Query("/viewer/layers/layer[@startswith]");
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
