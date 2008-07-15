
/**
 * StUF_Fout.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

package nl.vrom.www.bag.stuf._0120;

public class StUF_Fout extends java.lang.Exception{
    
    private nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub.FoutBerichtE faultMessage;
    
    public StUF_Fout() {
        super("StUF_Fout");
    }
           
    public StUF_Fout(java.lang.String s) {
       super(s);
    }
    
    public StUF_Fout(java.lang.String s, java.lang.Throwable ex) {
      super(s, ex);
    }
    
    public void setFaultMessage(nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub.FoutBerichtE msg){
       faultMessage = msg;
    }
    
    public nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub.FoutBerichtE getFaultMessage(){
       return faultMessage;
    }
}
    