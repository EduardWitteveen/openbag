

/**
 * STUFBAGSynchroon.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package nl.vrom.www.bag.stuf._0120;

    /*
     *  STUFBAGSynchroon java interface
     */

    public interface STUFBAGSynchroon {
          

        /**
          * Auto generated method signature
          * 
                    * @param kennisgevingsBericht1
                
             * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
         */

         
                     public nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht ontvangKennisgeving(

                        nl.vrom.www.bag.stuf._0120.KennisgevingsBericht kennisgevingsBericht1)
                        throws java.rmi.RemoteException
             
          ,nl.vrom.www.bag.stuf._0120.StUF_Fout;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param kennisgevingsBericht1
            
          */
        public void startontvangKennisgeving(

            nl.vrom.www.bag.stuf._0120.KennisgevingsBericht kennisgevingsBericht1,

            final nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param vraagBericht3
                
             * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
         */

         
                     public nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht beantwoordVraag(

                        nl.vrom.www.bag.stuf._0120.VraagBericht vraagBericht3)
                        throws java.rmi.RemoteException
             
          ,nl.vrom.www.bag.stuf._0120.StUF_Fout;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param vraagBericht3
            
          */
        public void startbeantwoordVraag(

            nl.vrom.www.bag.stuf._0120.VraagBericht vraagBericht3,

            final nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    