

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
                    * @param kennisgevingsBericht
                
             * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
         */

         
                     public nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht ontvangKennisgeving(

                        nl.vrom.www.bag.stuf._0120.KennisgevingsBericht kennisgevingsBericht)
                        throws java.rmi.RemoteException
             
          ,nl.vrom.www.bag.stuf._0120.StUF_Fout;

        

        /**
          * Auto generated method signature
          * 
                    * @param vraagBericht
                
             * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
         */

         
                     public nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht beantwoordVraag(

                        nl.vrom.www.bag.stuf._0120.VraagBericht vraagBericht)
                        throws java.rmi.RemoteException
             
          ,nl.vrom.www.bag.stuf._0120.StUF_Fout;

        

        
       //
       }
    