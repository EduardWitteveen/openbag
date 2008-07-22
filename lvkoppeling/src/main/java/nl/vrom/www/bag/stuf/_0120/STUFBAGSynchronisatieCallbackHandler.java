
/**
 * STUFBAGSynchronisatieCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package nl.vrom.www.bag.stuf._0120;

    /**
     *  STUFBAGSynchronisatieCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class STUFBAGSynchronisatieCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public STUFBAGSynchronisatieCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public STUFBAGSynchronisatieCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for verwerkSynchronisatie method
            * override this method for handling normal response from verwerkSynchronisatie operation
            */
           public void receiveResultverwerkSynchronisatie(
                    nl.vrom.www.bag.stuf._0120.SynchronisatieAntwoordBericht result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verwerkSynchronisatie operation
           */
            public void receiveErrorverwerkSynchronisatie(java.lang.Exception e) {
            }
                


    }
    