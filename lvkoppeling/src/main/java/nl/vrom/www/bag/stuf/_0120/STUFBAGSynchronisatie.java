

/**
 * STUFBAGSynchronisatie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package nl.vrom.www.bag.stuf._0120;

    /*
     *  STUFBAGSynchronisatie java interface
     */

    public interface STUFBAGSynchronisatie {
          

        /**
          * Auto generated method signature
          * 
                    * @param synchronisatieBericht0
                
             * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
         */

         
                     public nl.vrom.www.bag.stuf._0120.SynchronisatieAntwoordBericht verwerkSynchronisatie(

                        nl.vrom.www.bag.stuf._0120.SynchronisatieBericht synchronisatieBericht0)
                        throws java.rmi.RemoteException
             
          ,nl.vrom.www.bag.stuf._0120.StUF_Fout;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param synchronisatieBericht0
            
          */
        public void startverwerkSynchronisatie(

            nl.vrom.www.bag.stuf._0120.SynchronisatieBericht synchronisatieBericht0,

            final nl.vrom.www.bag.stuf._0120.STUFBAGSynchronisatieCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    