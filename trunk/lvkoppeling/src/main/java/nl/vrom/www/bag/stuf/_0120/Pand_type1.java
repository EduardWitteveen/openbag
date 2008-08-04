
/**
 * Pand_type1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.vrom.www.bag.stuf._0120;
            

            /**
            *  Pand_type1 bean class
            */
        
        public  class Pand_type1 extends nl.vrom.www.bag.stuf._0120.PandAntwoord
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = pand_type1
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
                        * field for GerelateerdeVerblijfsObject
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[] localGerelateerdeVerblijfsObject ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGerelateerdeVerblijfsObjectTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[] getGerelateerdeVerblijfsObject(){
                               return localGerelateerdeVerblijfsObject;
                           }

                           
                        


                               
                              /**
                               * validate the array for GerelateerdeVerblijfsObject
                               */
                              protected void validateGerelateerdeVerblijfsObject(nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param GerelateerdeVerblijfsObject
                              */
                              public void setGerelateerdeVerblijfsObject(nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[] param){
                              
                                   validateGerelateerdeVerblijfsObject(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localGerelateerdeVerblijfsObjectTracker = true;
                                          } else {
                                             localGerelateerdeVerblijfsObjectTracker = true;
                                                 
                                          }
                                      
                                      this.localGerelateerdeVerblijfsObject=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord
                             */
                             public void addGerelateerdeVerblijfsObject(nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord param){
                                   if (localGerelateerdeVerblijfsObject == null){
                                   localGerelateerdeVerblijfsObject = new nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[]{};
                                   }

                            
                                 //update the setting tracker
                                localGerelateerdeVerblijfsObjectTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localGerelateerdeVerblijfsObject);
                               list.add(param);
                               this.localGerelateerdeVerblijfsObject =
                             (nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[list.size()]);

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
                       Pand_type1.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":pand_type1",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "pand_type1",
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
                                } if (localPandGeometrieTracker){
                                    if (localPandGeometrie==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"pandGeometrie", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"pandGeometrie");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("pandGeometrie");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localPandGeometrie.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pandGeometrie"),
                                        factory,xmlWriter);
                                    }
                                } if (localBouwjaarTracker){
                                    if (localBouwjaar==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"bouwjaar", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"bouwjaar");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("bouwjaar");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localBouwjaar.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","bouwjaar"),
                                        factory,xmlWriter);
                                    }
                                } if (localPandstatusTracker){
                                    if (localPandstatus==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"pandstatus", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"pandstatus");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("pandstatus");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localPandstatus.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pandstatus"),
                                        factory,xmlWriter);
                                    }
                                } if (localGerelateerdeVerblijfsObjectTracker){
                                       if (localGerelateerdeVerblijfsObject!=null){
                                            for (int i = 0;i < localGerelateerdeVerblijfsObject.length;i++){
                                                if (localGerelateerdeVerblijfsObject[i] != null){
                                                 localGerelateerdeVerblijfsObject[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdeVerblijfsObject"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                            // write null attribute
                                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"GerelateerdeVerblijfsObject", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"GerelateerdeVerblijfsObject");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("GerelateerdeVerblijfsObject");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                // write null attribute
                                                java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"GerelateerdeVerblijfsObject", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"GerelateerdeVerblijfsObject");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("GerelateerdeVerblijfsObject");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
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
                    attribList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pand_type1"));
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
                                } if (localPandGeometrieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "pandGeometrie"));
                            
                            
                                    elementList.add(localPandGeometrie==null?null:
                                    localPandGeometrie);
                                } if (localBouwjaarTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "bouwjaar"));
                            
                            
                                    elementList.add(localBouwjaar==null?null:
                                    localBouwjaar);
                                } if (localPandstatusTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "pandstatus"));
                            
                            
                                    elementList.add(localPandstatus==null?null:
                                    localPandstatus);
                                } if (localGerelateerdeVerblijfsObjectTracker){
                             if (localGerelateerdeVerblijfsObject!=null) {
                                 for (int i = 0;i < localGerelateerdeVerblijfsObject.length;i++){

                                    if (localGerelateerdeVerblijfsObject[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "GerelateerdeVerblijfsObject"));
                                         elementList.add(localGerelateerdeVerblijfsObject[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "GerelateerdeVerblijfsObject"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "GerelateerdeVerblijfsObject"));
                                        elementList.add(localGerelateerdeVerblijfsObject);
                                    
                             }

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
        public static Pand_type1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Pand_type1 object =
                new Pand_type1();

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
                    
                            if (!"pand_type1".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Pand_type1)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
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
                
                        java.util.ArrayList list10 = new java.util.ArrayList();
                    
                                    
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
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pandGeometrie").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setPandGeometrie(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setPandGeometrie(nl.vrom.www.bag._0120.GeometrieVlak.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","bouwjaar").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setBouwjaar(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setBouwjaar(nl.vrom.www.bag.stuf._0120.Bouwjaar_type2.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pandstatus").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setPandstatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setPandstatus(nl.vrom.www.bag.stuf._0120.Pandstatus_type2.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdeVerblijfsObject").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list10.add(null);
                                                              reader.next();
                                                          } else {
                                                        list10.add(nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone10 = false;
                                                        while(!loopDone10){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone10 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdeVerblijfsObject").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list10.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list10.add(nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone10 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setGerelateerdeVerblijfsObject((nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.BevatVerblijfsObjectAntwoord.class,
                                                                list10));
                                                            
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
           
          