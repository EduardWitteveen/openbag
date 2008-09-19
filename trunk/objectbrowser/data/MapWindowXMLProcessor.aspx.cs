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

using System.IO;

namespace QI02.mapguide
{
	/// <summary>
	/// Summary description for MapWindowXMLProcessor.
	/// </summary>
	public class MapWindowXMLProcessor : System.Web.UI.Page
	{
		private void Page_Load(object sender, System.EventArgs e)
		{
			try 
			{
				// do we have a filter?
				Hashtable filter =  new Hashtable();

				// now do the processing,..
				string file = System.Configuration.ConfigurationSettings.AppSettings["mwx-location"];
				if(file==null) 
				{
					throw new HttpException("the key mwx-location was not found in the web.config");
				}

				file = Server.MapPath("../" + file);
				byte [] data = GetMapguideBytes(file, filter);

				Response.ContentType = "application/x-mwf";
				Response.Expires = -1;
				Response.Buffer = true;			
				Response.BinaryWrite(data);
			}
			catch(Exception ex) 
			{
				Response.ContentType = "text/html";
				Response.Expires = -1;
				Response.Buffer = true;			
				Response.Write("<html><pre>" + ex.ToString() + "</pre></html>");
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
			this.Load += new System.EventHandler(this.Page_Load);
		}
		#endregion

		public byte [] GetMapguideBytes(string mwxfile, Hashtable filter)
		{
			// we will copy the mwx file and replace a certain string,..
			string filename = Path.GetTempFileName();
			// we use 'using', so the stream is closed afterwards :D
			using(StreamWriter sw = new StreamWriter(filename)) 
			{
				using (StreamReader sr = new StreamReader(mwxfile)) 
				{
					String line;
					while ((line = sr.ReadLine()) != null) 
					{
						sw.Write(line);
					}					
				}
			}
			// convert from mwx to mwf
			DynamicAuthoringToolkit.MapWindowFileClass mwf = new DynamicAuthoringToolkit.MapWindowFileClass();
			mwf.ValidateMwx = true;
			mwf.CompressMwf = false;
			mwf.ReadFromMwx(filename);

			// return the bytes
			return (byte [])mwf.WriteToMwfStream();
		}
	}
}
