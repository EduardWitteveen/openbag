
/**
 * StUFBerichtenSetChoice_type1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0205;
            

            /**
            *  StUFBerichtenSetChoice_type1 bean class
            */
        
        public  class StUFBerichtenSetChoice_type1
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = StUF-berichtenSetChoice_type1
                Namespace URI = http://www.egem.nl/StUF/StUF0205
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.egem.nl/StUF/StUF0205")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        
            /** Whenever a new property is set ensure all others are unset
             *  There can be only one choice and the last one wins
             */
            private void clearAllSettingTrackers() {
            
                   localKennisgevingsBerichtTracker = false;
                
                   localVraagBerichtTracker = false;
                
                   localAsynchroonAntwoordBerichtTracker = false;
                
                   localFoutBerichtTracker = false;
                
            }
        

                        /**
                        * field for KennisgevingsBericht
                        */

                        
                                    protected java.lang.Object localKennisgevingsBericht ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localKennisgevingsBerichtTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.Object
                           */
                           public  java.lang.Object getKennisgevingsBericht(){
                               return localKennisgevingsBericht;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param KennisgevingsBericht
                               */
                               public void setKennisgevingsBericht(java.lang.Object param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localKennisgevingsBerichtTracker = true;
                                       } else {
                                          localKennisgevingsBerichtTracker = false;
                                              
                                       }
                                   
                                            this.localKennisgevingsBericht=param;
                                    

                               }
                            

                        /**
                        * field for VraagBericht
                        */

                        
                                    protected java.lang.Object localVraagBericht ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVraagBerichtTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.Object
                           */
                           public  java.lang.Object getVraagBericht(){
                               return localVraagBericht;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VraagBericht
                               */
                               public void setVraagBericht(java.lang.Object param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVraagBerichtTracker = true;
                                       } else {
                                          localVraagBerichtTracker = false;
                                              
                                       }
                                   
                                            this.localVraagBericht=param;
                                    

                               }
                            

                        /**
                        * field for AsynchroonAntwoordBericht
                        */

                        
                                    protected java.lang.Object localAsynchroonAntwoordBericht ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAsynchroonAntwoordBerichtTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.Object
                           */
                           public  java.lang.Object getAsynchroonAntwoordBericht(){
                               return localAsynchroonAntwoordBericht;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AsynchroonAntwoordBericht
                               */
                               public void setAsynchroonAntwoordBericht(java.lang.Object param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAsynchroonAntwoordBerichtTracker = true;
                                       } else {
                                          localAsynchroonAntwoordBerichtTracker = false;
                                              
                                       }
                                   
                                            this.localAsynchroonAntwoordBericht=param;
                                    

                               }
                            

                        /**
                        * field for FoutBericht
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.FoutBericht_type1 localFoutBericht ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFoutBerichtTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.FoutBericht_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.FoutBericht_type1 getFoutBericht(){
                               return localFoutBericht;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FoutBericht
                               */
                               public void setFoutBericht(nl.egem.www.stuf.stuf0205.FoutBericht_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFoutBerichtTracker = true;
                                       } else {
                                          localFoutBerichtTracker = false;
                                              
                                       }
                                   
                                            this.localFoutBericht=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       StUFBerichtenSetChoice_type1.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.egem.nl/StUF/StUF0205");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":StUF-berichtenSetChoice_type1",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "StUF-berichtenSetChoice_type1",
                           xmlWriter);
                   }

               
                   }
                if (localKennisgevingsBerichtTracker){
                            
                            if (localKennisgevingsBericht!=null){
                                if (localKennisgevingsBericht instanceof org.apache.axis2.databinding.ADBBean){
                                    ((org.apache.axis2.databinding.ADBBean)localKennisgevingsBericht).serialize(
                                               new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","kennisgevingsBericht"),
                                               factory,xmlWriter,true);
                                 } else {
                                    java.lang.String namespace2 = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace2.equals("")) {
                                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                        if (prefix2 == null) {
                                            prefix2 = generatePrefix(namespace2);

                                            xmlWriter.writeStartElement(prefix2,"kennisgevingsBericht", namespace2);
                                            xmlWriter.writeNamespace(prefix2, namespace2);
                                            xmlWriter.setPrefix(prefix2, namespace2);

                                        } else {
                                            xmlWriter.writeStartElement(namespace2,"kennisgevingsBericht");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("kennisgevingsBericht");
                                    }
                                    org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localKennisgevingsBericht, xmlWriter);
                                    xmlWriter.writeEndElement();
                                 }
                            } else {
                                
                                         throw new org.apache.axis2.databinding.ADBException("kennisgevingsBericht cannot be null!!");
                                    
                            }


                        } if (localVraagBerichtTracker){
                            
                            if (localVraagBericht!=null){
                                if (localVraagBericht instanceof org.apache.axis2.databinding.ADBBean){
                                    ((org.apache.axis2.databinding.ADBBean)localVraagBericht).serialize(
                                               new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","vraagBericht"),
                                               factory,xmlWriter,true);
                                 } else {
                                    java.lang.String namespace2 = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace2.equals("")) {
                                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                        if (prefix2 == null) {
                                            prefix2 = generatePrefix(namespace2);

                                            xmlWriter.writeStartElement(prefix2,"vraagBericht", namespace2);
                                            xmlWriter.writeNamespace(prefix2, namespace2);
                                            xmlWriter.setPrefix(prefix2, namespace2);

                                        } else {
                                            xmlWriter.writeStartElement(namespace2,"vraagBericht");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("vraagBericht");
                                    }
                                    org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localVraagBericht, xmlWriter);
                                    xmlWriter.writeEndElement();
                                 }
                            } else {
                                
                                         throw new org.apache.axis2.databinding.ADBException("vraagBericht cannot be null!!");
                                    
                            }


                        } if (localAsynchroonAntwoordBerichtTracker){
                            
                            if (localAsynchroonAntwoordBericht!=null){
                                if (localAsynchroonAntwoordBericht instanceof org.apache.axis2.databinding.ADBBean){
                                    ((org.apache.axis2.databinding.ADBBean)localAsynchroonAntwoordBericht).serialize(
                                               new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","asynchroonAntwoordBericht"),
                                               factory,xmlWriter,true);
                                 } else {
                                    java.lang.String namespace2 = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace2.equals("")) {
                                        java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                        if (prefix2 == null) {
                                            prefix2 = generatePrefix(namespace2);

                                            xmlWriter.writeStartElement(prefix2,"asynchroonAntwoordBericht", namespace2);
                                            xmlWriter.writeNamespace(prefix2, namespace2);
                                            xmlWriter.setPrefix(prefix2, namespace2);

                                        } else {
                                            xmlWriter.writeStartElement(namespace2,"asynchroonAntwoordBericht");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("asynchroonAntwoordBericht");
                                    }
                                    org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localAsynchroonAntwoordBericht, xmlWriter);
                                    xmlWriter.writeEndElement();
                                 }
                            } else {
                                
                                         throw new org.apache.axis2.databinding.ADBException("asynchroonAntwoordBericht cannot be null!!");
                                    
                            }


                        } if (localFoutBerichtTracker){
                                            if (localFoutBericht==null){
                                                 throw new org.apache.axis2.databinding.ADBException("foutBericht cannot be null!!");
                                            }
                                           localFoutBericht.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","foutBericht"),
                                               factory,xmlWriter);
                                        }

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localKennisgevingsBerichtTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "kennisgevingsBericht"));
                            
                            
                                    if (localKennisgevingsBericht==null){
                                         throw new org.apache.axis2.databinding.ADBException("kennisgevingsBericht cannot be null!!");
                                    }
                                    elementList.add(localKennisgevingsBericht);
                                } if (localVraagBerichtTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "vraagBericht"));
                            
                            
                                    if (localVraagBericht==null){
                                         throw new org.apache.axis2.databinding.ADBException("vraagBericht cannot be null!!");
                                    }
                                    elementList.add(localVraagBericht);
                                } if (localAsynchroonAntwoordBerichtTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "asynchroonAntwoordBericht"));
                            
                            
                                    if (localAsynchroonAntwoordBericht==null){
                                         throw new org.apache.axis2.databinding.ADBException("asynchroonAntwoordBericht cannot be null!!");
                                    }
                                    elementList.add(localAsynchroonAntwoordBericht);
                                } if (localFoutBerichtTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "foutBericht"));
                            
                            
                                    if (localFoutBericht==null){
                                         throw new org.apache.axis2.databinding.ADBException("foutBericht cannot be null!!");
                                    }
                                    elementList.add(localFoutBericht);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static StUFBerichtenSetChoice_type1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            StUFBerichtenSetChoice_type1 object =
                new StUFBerichtenSetChoice_type1();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","kennisgevingsBericht").equals(reader.getName())){
                                
                                     object.setKennisgevingsBericht(org.apache.axis2.databinding.utils.ConverterUtil.getAnyTypeObject(reader,
                                                nl.vrom.www.bag.stuf._0120.ExtensionMapper.class));
                                       
                                         reader.next();
                                     
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","vraagBericht").equals(reader.getName())){
                                
                                     object.setVraagBericht(org.apache.axis2.databinding.utils.ConverterUtil.getAnyTypeObject(reader,
                                                nl.vrom.www.bag.stuf._0120.ExtensionMapper.class));
                                       
                                         reader.next();
                                     
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","asynchroonAntwoordBericht").equals(reader.getName())){
                                
                                     object.setAsynchroonAntwoordBericht(org.apache.axis2.databinding.utils.ConverterUtil.getAnyTypeObject(reader,
                                                nl.vrom.www.bag.stuf._0120.ExtensionMapper.class));
                                       
                                         reader.next();
                                     
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","foutBericht").equals(reader.getName())){
                                
                                                object.setFoutBericht(nl.egem.www.stuf.stuf0205.FoutBericht_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          