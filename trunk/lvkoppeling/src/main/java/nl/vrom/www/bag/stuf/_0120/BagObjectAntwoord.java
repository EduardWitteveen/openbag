
/**
 * BagObjectAntwoord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.vrom.www.bag.stuf._0120;
            

            /**
            *  BagObjectAntwoord bean class
            */
        
        public  class BagObjectAntwoord
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = BagObjectAntwoord
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
                        * field for Identificatie
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Identificatie_type4 localIdentificatie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIdentificatieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Identificatie_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.Identificatie_type4 getIdentificatie(){
                               return localIdentificatie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Identificatie
                               */
                               public void setIdentificatie(nl.vrom.www.bag.stuf._0120.Identificatie_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIdentificatieTracker = true;
                                       } else {
                                          localIdentificatieTracker = true;
                                              
                                       }
                                   
                                            this.localIdentificatie=param;
                                    

                               }
                            

                        /**
                        * field for Bron
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Bron_type4 localBron ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBronTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Bron_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.Bron_type4 getBron(){
                               return localBron;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Bron
                               */
                               public void setBron(nl.vrom.www.bag.stuf._0120.Bron_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBronTracker = true;
                                       } else {
                                          localBronTracker = true;
                                              
                                       }
                                   
                                            this.localBron=param;
                                    

                               }
                            

                        /**
                        * field for Geconstateerd
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Geconstateerd_type4 localGeconstateerd ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGeconstateerdTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Geconstateerd_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.Geconstateerd_type4 getGeconstateerd(){
                               return localGeconstateerd;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Geconstateerd
                               */
                               public void setGeconstateerd(nl.vrom.www.bag.stuf._0120.Geconstateerd_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGeconstateerdTracker = true;
                                       } else {
                                          localGeconstateerdTracker = true;
                                              
                                       }
                                   
                                            this.localGeconstateerd=param;
                                    

                               }
                            

                        /**
                        * field for InOnderzoek
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.InOnderzoek_type4 localInOnderzoek ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInOnderzoekTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.InOnderzoek_type4
                           */
                           public  nl.vrom.www.bag.stuf._0120.InOnderzoek_type4 getInOnderzoek(){
                               return localInOnderzoek;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InOnderzoek
                               */
                               public void setInOnderzoek(nl.vrom.www.bag.stuf._0120.InOnderzoek_type4 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localInOnderzoekTracker = true;
                                       } else {
                                          localInOnderzoekTracker = true;
                                              
                                       }
                                   
                                            this.localInOnderzoek=param;
                                    

                               }
                            

                        /**
                        * field for Correctie
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Correctie_type0 localCorrectie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCorrectieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Correctie_type0
                           */
                           public  nl.vrom.www.bag.stuf._0120.Correctie_type0 getCorrectie(){
                               return localCorrectie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Correctie
                               */
                               public void setCorrectie(nl.vrom.www.bag.stuf._0120.Correctie_type0 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCorrectieTracker = true;
                                       } else {
                                          localCorrectieTracker = true;
                                              
                                       }
                                   
                                            this.localCorrectie=param;
                                    

                               }
                            

                        /**
                        * field for TijdvakGeldigheid
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid localTijdvakGeldigheid ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTijdvakGeldigheidTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid
                           */
                           public  nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid getTijdvakGeldigheid(){
                               return localTijdvakGeldigheid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TijdvakGeldigheid
                               */
                               public void setTijdvakGeldigheid(nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTijdvakGeldigheidTracker = true;
                                       } else {
                                          localTijdvakGeldigheidTracker = true;
                                              
                                       }
                                   
                                            this.localTijdvakGeldigheid=param;
                                    

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
                       BagObjectAntwoord.this.serialize(parentQName,factory,xmlWriter);
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
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.vrom.nl/bag/stuf/0120");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":BagObjectAntwoord",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "BagObjectAntwoord",
                           xmlWriter);
                   }

               
                   }
                if (localIdentificatieTracker){
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
                                } if (localBronTracker){
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
                                } if (localCorrectieTracker){
                                    if (localCorrectie==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"correctie", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"correctie");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("correctie");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localCorrectie.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","correctie"),
                                        factory,xmlWriter);
                                    }
                                } if (localTijdvakGeldigheidTracker){
                                    if (localTijdvakGeldigheid==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"tijdvakGeldigheid", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"tijdvakGeldigheid");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("tijdvakGeldigheid");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localTijdvakGeldigheid.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","tijdvakGeldigheid"),
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

                 if (localIdentificatieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "identificatie"));
                            
                            
                                    elementList.add(localIdentificatie==null?null:
                                    localIdentificatie);
                                } if (localBronTracker){
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
                                } if (localCorrectieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "correctie"));
                            
                            
                                    elementList.add(localCorrectie==null?null:
                                    localCorrectie);
                                } if (localTijdvakGeldigheidTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "tijdvakGeldigheid"));
                            
                            
                                    elementList.add(localTijdvakGeldigheid==null?null:
                                    localTijdvakGeldigheid);
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
        public static BagObjectAntwoord parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            BagObjectAntwoord object =
                new BagObjectAntwoord();

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
                    
                            if (!"BagObjectAntwoord".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (BagObjectAntwoord)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","identificatie").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setIdentificatie(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setIdentificatie(nl.vrom.www.bag.stuf._0120.Identificatie_type4.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","bron").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBron(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBron(nl.vrom.www.bag.stuf._0120.Bron_type4.Factory.parse(reader));
                                              
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
                                    
                                                object.setGeconstateerd(nl.vrom.www.bag.stuf._0120.Geconstateerd_type4.Factory.parse(reader));
                                              
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
                                    
                                                object.setInOnderzoek(nl.vrom.www.bag.stuf._0120.InOnderzoek_type4.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","correctie").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setCorrectie(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setCorrectie(nl.vrom.www.bag.stuf._0120.Correctie_type0.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","tijdvakGeldigheid").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setTijdvakGeldigheid(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setTijdvakGeldigheid(nl.vrom.www.bag.stuf._0120.TijdvakGeldigheid.Factory.parse(reader));
                                              
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
           
          