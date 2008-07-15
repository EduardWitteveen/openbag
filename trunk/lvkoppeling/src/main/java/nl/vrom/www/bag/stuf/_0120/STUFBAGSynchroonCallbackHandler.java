
/**
 * STUFBAGSynchroonCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package nl.vrom.www.bag.stuf._0120;

    /**
     *  STUFBAGSynchroonCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class STUFBAGSynchroonCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public STUFBAGSynchroonCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public STUFBAGSynchroonCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for ontvangKennisgeving method
            * override this method for handling normal response from ontvangKennisgeving operation
            */
           public void receiveResultontvangKennisgeving(
                    nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub.SynchroonAntwoordBericht result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from ontvangKennisgeving operation
           */
            public void receiveErrorontvangKennisgeving(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for beantwoordVraag method
            * override this method for handling normal response from beantwoordVraag operation
            */
           public void receiveResultbeantwoordVraag(
                    nl.vrom.www.bag.stuf._0120.STUFBAGSynchroonStub.SynchroonAntwoordBericht result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from beantwoordVraag operation
           */
            public void receiveErrorbeantwoordVraag(java.lang.Exception e) {
            }
                


    }
    