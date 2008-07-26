
/**
 * STUFBAGSynchroonStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */
        package nl.vrom.www.bag.stuf._0120;

        

        /*
        *  STUFBAGSynchroonStub java implementation
        */

        
        public class STUFBAGSynchroonStub extends org.apache.axis2.client.Stub
        implements STUFBAGSynchroon{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("STUFBAGSynchroon" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120", "ontvangKennisgeving"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120", "beantwoordVraag"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.StUF_Fout");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.StUF_Fout");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.FoutBerichtE");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.StUF_Fout");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.StUF_Fout");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","foutBericht"),"nl.vrom.www.bag.stuf._0120.FoutBerichtE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public STUFBAGSynchroonStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public STUFBAGSynchroonStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public STUFBAGSynchroonStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:8080/bag-web/services/BagWebService" );
                
    }

    /**
     * Default Constructor
     */
    public STUFBAGSynchroonStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:8080/bag-web/services/BagWebService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public STUFBAGSynchroonStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see nl.vrom.www.bag.stuf._0120.STUFBAGSynchroon#ontvangKennisgeving
                     * @param kennisgevingsBericht1
                    
                     * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
                     */

                    

                            public  nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht ontvangKennisgeving(

                            nl.vrom.www.bag.stuf._0120.KennisgevingsBericht kennisgevingsBericht1)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,nl.vrom.www.bag.stuf._0120.StUF_Fout{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:ontvangKennisgeving");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    kennisgevingsBericht1,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                    "ontvangKennisgeving")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof nl.vrom.www.bag.stuf._0120.StUF_Fout){
                          throw (nl.vrom.www.bag.stuf._0120.StUF_Fout)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see nl.vrom.www.bag.stuf._0120.STUFBAGSynchroon#beantwoordVraag
                     * @param vraagBericht3
                    
                     * @throws nl.vrom.www.bag.stuf._0120.StUF_Fout : 
                     */

                    

                            public  nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht beantwoordVraag(

                            nl.vrom.www.bag.stuf._0120.VraagBericht vraagBericht3)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,nl.vrom.www.bag.stuf._0120.StUF_Fout{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("urn:beantwoordVraag");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    vraagBericht3,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                    "beantwoordVraag")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof nl.vrom.www.bag.stuf._0120.StUF_Fout){
                          throw (nl.vrom.www.bag.stuf._0120.StUF_Fout)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost:8080/bag-web/services/BagWebService
            private  org.apache.axiom.om.OMElement  toOM(nl.vrom.www.bag.stuf._0120.KennisgevingsBericht param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(nl.vrom.www.bag.stuf._0120.KennisgevingsBericht.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(nl.vrom.www.bag.stuf._0120.FoutBerichtE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(nl.vrom.www.bag.stuf._0120.FoutBerichtE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(nl.vrom.www.bag.stuf._0120.VraagBericht param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(nl.vrom.www.bag.stuf._0120.VraagBericht.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, nl.vrom.www.bag.stuf._0120.KennisgevingsBericht param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(nl.vrom.www.bag.stuf._0120.KennisgevingsBericht.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, nl.vrom.www.bag.stuf._0120.VraagBericht param, boolean optimizeContent)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(nl.vrom.www.bag.stuf._0120.VraagBericht.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (nl.vrom.www.bag.stuf._0120.KennisgevingsBericht.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.KennisgevingsBericht.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (nl.vrom.www.bag.stuf._0120.FoutBerichtE.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.FoutBerichtE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (nl.vrom.www.bag.stuf._0120.VraagBericht.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.VraagBericht.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.SynchroonAntwoordBericht.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (nl.vrom.www.bag.stuf._0120.FoutBerichtE.class.equals(type)){
                
                           return nl.vrom.www.bag.stuf._0120.FoutBerichtE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   