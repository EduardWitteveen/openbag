
/**
 * GerelateerdOpenbareRuimte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.vrom.www.bag.stuf._0120;
            

            /**
            *  GerelateerdOpenbareRuimte bean class
            */
        
        public  class GerelateerdOpenbareRuimte extends nl.vrom.www.bag.stuf._0120.GerelateerdBagObject
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = GerelateerdOpenbareRuimte
                Namespace URI = http://www.vrom.nl/bag/stuf/0120
                Namespace Prefix = ns5
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.vrom.nl/bag/stuf/0120")){
                return "ns5";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for OpenbareruimteStatus
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.OpenbareruimteStatus_type4 localOpenbareruimteStatus ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOpenbareruimteStatusTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.OpenbareruimteStatus_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.OpenbareruimteStatus_type4 getOpenbareruimteStatus(){
                               return localOpenbareruimteStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OpenbareruimteStatus
                               */
                               public void setOpenbareruimteStatus(nl.vrom.www.bag.stuf._0120.OpenbareruimteStatus_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOpenbareruimteStatusTracker = true;
                                       } else {
                                          localOpenbareruimteStatusTracker = true;
                                              
                                       }
                                   
                                            this.localOpenbareruimteStatus=param;
                                    

                               }
                            

                        /**
                        * field for OpenbareRuimteNaam
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.OpenbareRuimteNaam_type4 localOpenbareRuimteNaam ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOpenbareRuimteNaamTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.OpenbareRuimteNaam_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.OpenbareRuimteNaam_type4 getOpenbareRuimteNaam(){
                               return localOpenbareRuimteNaam;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OpenbareRuimteNaam
                               */
                               public void setOpenbareRuimteNaam(nl.vrom.www.bag.stuf._0120.OpenbareRuimteNaam_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOpenbareRuimteNaamTracker = true;
                                       } else {
                                          localOpenbareRuimteNaamTracker = true;
                                              
                                       }
                                   
                                            this.localOpenbareRuimteNaam=param;
                                    

                               }
                            

                        /**
                        * field for OpenbareRuimteType
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.OpenbareRuimteType_type4 localOpenbareRuimteType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOpenbareRuimteTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.OpenbareRuimteType_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.OpenbareRuimteType_type4 getOpenbareRuimteType(){
                               return localOpenbareRuimteType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OpenbareRuimteType
                               */
                               public void setOpenbareRuimteType(nl.vrom.www.bag.stuf._0120.OpenbareRuimteType_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOpenbareRuimteTypeTracker = true;
                                       } else {
                                          localOpenbareRuimteTypeTracker = true;
                                              
                                       }
                                   
                                            this.localOpenbareRuimteType=param;
                                    

                               }
                            

                        /**
                        * field for SoortEntiteit
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localSoortEntiteit ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSoortEntiteit(){
                               return localSoortEntiteit;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SoortEntiteit
                               */
                               public void setSoortEntiteit(java.lang.String param){
                            
                                            this.localSoortEntiteit=param;
                                    

                               }
                            

                        /**
                        * field for SleutelVerzendend
                        * This was an Attribute!
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Sleutel localSleutelVerzendend ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Sleutel
                           */
                           public  nl.egem.www.stuf.stuf0205.Sleutel getSleutelVerzendend(){
                               return localSleutelVerzendend;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SleutelVerzendend
                               */
                               public void setSleutelVerzendend(nl.egem.www.stuf.stuf0205.Sleutel param){
                            
                                            this.localSleutelVerzendend=param;
                                    

                               }
                            

                        /**
                        * field for SleutelOntvangend
                        * This was an Attribute!
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Sleutel localSleutelOntvangend ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Sleutel
                           */
                           public  nl.egem.www.stuf.stuf0205.Sleutel getSleutelOntvangend(){
                               return localSleutelOntvangend;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SleutelOntvangend
                               */
                               public void setSleutelOntvangend(nl.egem.www.stuf.stuf0205.Sleutel param){
                            
                                            this.localSleutelOntvangend=param;
                                    

                               }
                            

                        /**
                        * field for SleutelGegevensbeheer
                        * This was an Attribute!
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Sleutel localSleutelGegevensbeheer ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Sleutel
                           */
                           public  nl.egem.www.stuf.stuf0205.Sleutel getSleutelGegevensbeheer(){
                               return localSleutelGegevensbeheer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SleutelGegevensbeheer
                               */
                               public void setSleutelGegevensbeheer(nl.egem.www.stuf.stuf0205.Sleutel param){
                            
                                            this.localSleutelGegevensbeheer=param;
                                    

                               }
                            

                        /**
                        * field for Verwerkingssoort
                        * This was an Attribute!
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Verwerkingssoort localVerwerkingssoort ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Verwerkingssoort
                           */
                           public  nl.egem.www.stuf.stuf0205.Verwerkingssoort getVerwerkingssoort(){
                               return localVerwerkingssoort;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Verwerkingssoort
                               */
                               public void setVerwerkingssoort(nl.egem.www.stuf.stuf0205.Verwerkingssoort param){
                            
                                            this.localVerwerkingssoort=param;
                                    

                               }
                            

                        /**
                        * field for NoValue
                        * This was an Attribute!
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.NoValue localNoValue ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.NoValue
                           */
                           public  nl.egem.www.stuf.stuf0205.NoValue getNoValue(){
                               return localNoValue;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NoValue
                               */
                               public void setNoValue(nl.egem.www.stuf.stuf0205.NoValue param){
                            
                                            this.localNoValue=param;
                                    

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
                       GerelateerdOpenbareRuimte.this.serialize(parentQName,factory,xmlWriter);
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
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.vrom.nl/bag/stuf/0120");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":GerelateerdOpenbareRuimte",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "GerelateerdOpenbareRuimte",
                           xmlWriter);
                   }

               
                                            if (localSoortEntiteit != null){
                                        
                                                writeAttribute("",
                                                         "soortEntiteit",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSoortEntiteit), xmlWriter);

                                            
                                      }
                                    
                                      else {
                                          throw new org.apache.axis2.databinding.ADBException("required attribute localSoortEntiteit is null");
                                      }
                                    
                                    
                                    if (localSleutelVerzendend != null){
                                        writeAttribute("http://www.egem.nl/StUF/StUF0205",
                                           "sleutelVerzendend",
                                           localSleutelVerzendend.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localSleutelOntvangend != null){
                                        writeAttribute("http://www.egem.nl/StUF/StUF0205",
                                           "sleutelOntvangend",
                                           localSleutelOntvangend.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localSleutelGegevensbeheer != null){
                                        writeAttribute("http://www.egem.nl/StUF/StUF0205",
                                           "sleutelGegevensbeheer",
                                           localSleutelGegevensbeheer.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localVerwerkingssoort != null){
                                        writeAttribute("http://www.egem.nl/StUF/StUF0205",
                                           "verwerkingssoort",
                                           localVerwerkingssoort.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localNoValue != null){
                                        writeAttribute("http://www.egem.nl/StUF/StUF0205",
                                           "noValue",
                                           localNoValue.toString(), xmlWriter);
                                    }
                                    
                                    if (localIdentificatie==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"identificatie", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"identificatie");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("identificatie");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localIdentificatie.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","identificatie"),
                                        factory,xmlWriter);
                                    }
                                 if (localBronTracker){
                                    if (localBron==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"bron", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"bron");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("bron");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBron.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","bron"),
                                        factory,xmlWriter);
                                    }
                                } if (localGeconstateerdTracker){
                                    if (localGeconstateerd==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"geconstateerd", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"geconstateerd");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("geconstateerd");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localGeconstateerd.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","geconstateerd"),
                                        factory,xmlWriter);
                                    }
                                } if (localInOnderzoekTracker){
                                    if (localInOnderzoek==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"inOnderzoek", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"inOnderzoek");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("inOnderzoek");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localInOnderzoek.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","inOnderzoek"),
                                        factory,xmlWriter);
                                    }
                                }
                                            if (localTijdvakGeldigheid==null){
                                                 throw new org.apache.axis2.databinding.ADBException("tijdvakGeldigheid cannot be null!!");
                                            }
                                           localTijdvakGeldigheid.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","tijdvakGeldigheid"),
                                               factory,xmlWriter);
                                         if (localOpenbareruimteStatusTracker){
                                    if (localOpenbareruimteStatus==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"openbareruimteStatus", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"openbareruimteStatus");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("openbareruimteStatus");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOpenbareruimteStatus.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareruimteStatus"),
                                        factory,xmlWriter);
                                    }
                                } if (localOpenbareRuimteNaamTracker){
                                    if (localOpenbareRuimteNaam==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"openbareRuimteNaam", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"openbareRuimteNaam");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("openbareRuimteNaam");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOpenbareRuimteNaam.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimteNaam"),
                                        factory,xmlWriter);
                                    }
                                } if (localOpenbareRuimteTypeTracker){
                                    if (localOpenbareRuimteType==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"openbareRuimteType", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"openbareRuimteType");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("openbareRuimteType");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOpenbareRuimteType.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimteType"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();
               

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

                
                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdOpenbareRuimte"));
                
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "identificatie"));
                            
                            
                                    elementList.add(localIdentificatie==null?null:
                                    localIdentificatie);
                                 if (localBronTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "bron"));
                            
                            
                                    elementList.add(localBron==null?null:
                                    localBron);
                                } if (localGeconstateerdTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "geconstateerd"));
                            
                            
                                    elementList.add(localGeconstateerd==null?null:
                                    localGeconstateerd);
                                } if (localInOnderzoekTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "inOnderzoek"));
                            
                            
                                    elementList.add(localInOnderzoek==null?null:
                                    localInOnderzoek);
                                }
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "tijdvakGeldigheid"));
                            
                            
                                    if (localTijdvakGeldigheid==null){
                                         throw new org.apache.axis2.databinding.ADBException("tijdvakGeldigheid cannot be null!!");
                                    }
                                    elementList.add(localTijdvakGeldigheid);
                                 if (localOpenbareruimteStatusTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "openbareruimteStatus"));
                            
                            
                                    elementList.add(localOpenbareruimteStatus==null?null:
                                    localOpenbareruimteStatus);
                                } if (localOpenbareRuimteNaamTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "openbareRuimteNaam"));
                            
                            
                                    elementList.add(localOpenbareRuimteNaam==null?null:
                                    localOpenbareRuimteNaam);
                                } if (localOpenbareRuimteTypeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "openbareRuimteType"));
                            
                            
                                    elementList.add(localOpenbareRuimteType==null?null:
                                    localOpenbareRuimteType);
                                }
                            attribList.add(
                            new javax.xml.namespace.QName("","soortEntiteit"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSoortEntiteit));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sleutelVerzendend"));
                            
                                      attribList.add(localSleutelVerzendend.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sleutelOntvangend"));
                            
                                      attribList.add(localSleutelOntvangend.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sleutelGegevensbeheer"));
                            
                                      attribList.add(localSleutelGegevensbeheer.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","verwerkingssoort"));
                            
                                      attribList.add(localVerwerkingssoort.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","noValue"));
                            
                                      attribList.add(localNoValue.toString());
                                

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
        public static GerelateerdOpenbareRuimte parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            GerelateerdOpenbareRuimte object =
                new GerelateerdOpenbareRuimte();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"GerelateerdOpenbareRuimte".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (GerelateerdOpenbareRuimte)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    // handle attribute "soortEntiteit"
                    java.lang.String tempAttribSoortEntiteit =
                        
                                reader.getAttributeValue(null,"soortEntiteit");
                            
                   if (tempAttribSoortEntiteit!=null){
                         java.lang.String content = tempAttribSoortEntiteit;
                        
                                                 object.setSoortEntiteit(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribSoortEntiteit));
                                            
                    } else {
                       
                               throw new org.apache.axis2.databinding.ADBException("Required attribute soortEntiteit is missing");
                           
                    }
                    handledAttributes.add("soortEntiteit");
                    
                    // handle attribute "sleutelVerzendend"
                    java.lang.String tempAttribSleutelVerzendend =
                        
                                reader.getAttributeValue("http://www.egem.nl/StUF/StUF0205","sleutelVerzendend");
                            
                   if (tempAttribSleutelVerzendend!=null){
                         java.lang.String content = tempAttribSleutelVerzendend;
                        
                                                  object.setSleutelVerzendend(
                                                        nl.egem.www.stuf.stuf0205.Sleutel.Factory.fromString(reader,tempAttribSleutelVerzendend));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("sleutelVerzendend");
                    
                    // handle attribute "sleutelOntvangend"
                    java.lang.String tempAttribSleutelOntvangend =
                        
                                reader.getAttributeValue("http://www.egem.nl/StUF/StUF0205","sleutelOntvangend");
                            
                   if (tempAttribSleutelOntvangend!=null){
                         java.lang.String content = tempAttribSleutelOntvangend;
                        
                                                  object.setSleutelOntvangend(
                                                        nl.egem.www.stuf.stuf0205.Sleutel.Factory.fromString(reader,tempAttribSleutelOntvangend));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("sleutelOntvangend");
                    
                    // handle attribute "sleutelGegevensbeheer"
                    java.lang.String tempAttribSleutelGegevensbeheer =
                        
                                reader.getAttributeValue("http://www.egem.nl/StUF/StUF0205","sleutelGegevensbeheer");
                            
                   if (tempAttribSleutelGegevensbeheer!=null){
                         java.lang.String content = tempAttribSleutelGegevensbeheer;
                        
                                                  object.setSleutelGegevensbeheer(
                                                        nl.egem.www.stuf.stuf0205.Sleutel.Factory.fromString(reader,tempAttribSleutelGegevensbeheer));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("sleutelGegevensbeheer");
                    
                    // handle attribute "verwerkingssoort"
                    java.lang.String tempAttribVerwerkingssoort =
                        
                                reader.getAttributeValue("http://www.egem.nl/StUF/StUF0205","verwerkingssoort");
                            
                   if (tempAttribVerwerkingssoort!=null){
                         java.lang.String content = tempAttribVerwerkingssoort;
                        
                                                  object.setVerwerkingssoort(
                                                        nl.egem.www.stuf.stuf0205.Verwerkingssoort.Factory.fromString(reader,tempAttribVerwerkingssoort));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("verwerkingssoort");
                    
                    // handle attribute "noValue"
                    java.lang.String tempAttribNoValue =
                        
                                reader.getAttributeValue("http://www.egem.nl/StUF/StUF0205","noValue");
                            
                   if (tempAttribNoValue!=null){
                         java.lang.String content = tempAttribNoValue;
                        
                                                  object.setNoValue(
                                                        nl.egem.www.stuf.stuf0205.NoValue.Factory.fromString(reader,tempAttribNoValue));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("noValue");
                    
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","identificatie").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setIdentificatie(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setIdentificatie(nl.vrom.www.bag.stuf._0120.Identificatie_type9.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","bron").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBron(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBron(nl.vrom.www.bag.stuf._0120.Bron_type9.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","geconstateerd").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setGeconstateerd(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setGeconstateerd(nl.vrom.www.bag.stuf._0120.Geconstateerd_type9.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","inOnderzoek").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setInOnderzoek(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setInOnderzoek(nl.vrom.www.bag.stuf._0120.InOnderzoek_type9.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","tijdvakGeldigheid").equals(reader.getName())){
                                
                                                object.setTijdvakGeldigheid(nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareruimteStatus").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOpenbareruimteStatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOpenbareruimteStatus(nl.vrom.www.bag.stuf._0120.OpenbareruimteStatus_type4.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimteNaam").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOpenbareRuimteNaam(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOpenbareRuimteNaam(nl.vrom.www.bag.stuf._0120.OpenbareRuimteNaam_type4.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimteType").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOpenbareRuimteType(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOpenbareRuimteType(nl.vrom.www.bag.stuf._0120.OpenbareRuimteType_type4.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          