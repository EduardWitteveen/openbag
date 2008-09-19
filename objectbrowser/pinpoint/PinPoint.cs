using System;
using System.Collections;
using System.Data;
using System.Data.OracleClient;

namespace QI02.pinpoint
{
	public class PinPoint
	{
		public static int getNextTextID(HawarIT.WebLibrary.OracleDatabase conn)
		{
			string textMaxQuery = "SELECT MAX(ID) AS MAXID FROM PINPOINT_TEXT";				//Query for maximum value ID Text
			//OracleDataAdapter adptTextMax = new OracleDataAdapter(textMaxQuery,conn);		//Data Adapter MaxText
			//DataSet myDataSet = new DataSet();												//Dataset for storage of tables MaxMain and MaxText
			//adptTextMax.Fill(myDataSet,"PINPOINT_TEXT_MAXID");

			//DataTable tableTextMax = myDataSet.Tables["PINPOINT_TEXT_MAXID"];
			DataTable tableTextMax = conn.Query(textMaxQuery);

			object[] arrTextMax = tableTextMax.Rows[0].ItemArray;
			int textMaxVal = 0;

			try
			{    
				textMaxVal = Convert.ToInt16(arrTextMax[0]);
			}
			catch(Exception exc)
			{
				//conversion did not succeed because no maximum value was available
				exc = exc;
			}

			return textMaxVal + 1;
		}

		public static int getNextMainID(HawarIT.WebLibrary.OracleDatabase conn)
		{
			string mainMaxQuery = "SELECT MAX(ID) AS MAXID FROM PINPOINT_MAIN";				//Query for maximum value ID Text
//			OracleDataAdapter adptMainMax = new OracleDataAdapter(mainMaxQuery,conn);		//Data Adapter MaxMain
//			DataSet myDataSet = new DataSet();												//Dataset for storage of tables MaxMain and MaxText
//			adptMainMax.Fill(myDataSet,"PINPOINT_MAIN_MAXID");
//
//			DataTable tableMainMax = myDataSet.Tables["PINPOINT_MAIN_MAXID"];
			DataTable tableMainMax = conn.Query(mainMaxQuery);
			object[] arrMainMax = tableMainMax.Rows[0].ItemArray;
			int mainMaxVal = 0;

			try
			{    
				mainMaxVal = Convert.ToInt16(arrMainMax[0]);
			}
			catch(Exception exc)
			{
				//conversion did not succeed because no maximum value was available
				exc = exc;
			}

			return mainMaxVal + 1;
		}

		public static void UpdateText(HawarIT.WebLibrary.OracleDatabase conn,string text, string dsp_user_id, string mId, string tId)
		{
			int textId = PinPoint.getNextTextID(conn);
			string query = "";
			
			if((tId != "-"))
			{
				query = "UPDATE PINPOINT_TEXT SET text = '" + text + "', dsp_user_id = " + dsp_user_id + " WHERE id = '" + tId + "'";
			}
			conn.Execute(query);
		}
		public static void AddText(HawarIT.WebLibrary.OracleDatabase conn, string text, string dsp_user_id, string mId, string tId, int nextuser, int status)
		{
			int textId = PinPoint.getNextTextID(conn);
			string query = "";
			
			// wtf the tid = "-"???
			if((tId == "-"))
			{
				query = "INSERT INTO PINPOINT_TEXT (ID,PINPOINT_MAIN_ID,TEXT,dsp_user_id, dsp_status_id) VALUES (" + Convert.ToString(textId) + "," + Convert.ToString(mId) + ",\'" + text + "\'," + dsp_user_id + "," + status + ")";
				conn.Execute(query);
				query = "UPDATE  PINPOINT_MAIN SET action_by_dsp_user_id = " + nextuser + ",  dsp_status_id = " +  status + " where id = " + Convert.ToString(mId);
				conn.Execute(query);
			}			
		}
		public static void UpdateText(HawarIT.WebLibrary.OracleDatabase conn,string text, string dsp_user_id,string mId)
		{
			UpdateText(conn,text,dsp_user_id,mId,"-");
		}
		public static void AddText(HawarIT.WebLibrary.OracleDatabase conn, string text, string dsp_user_id,string mId, int nextuser, int status)
		{
			AddText(conn,text,dsp_user_id,mId,"-",nextuser,status);
		}
	}
}