
/**
 * VerblijfsObject_type3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.vrom.www.bag.stuf._0120;
            

            /**
            *  VerblijfsObject_type3 bean class
            */
        
        public  class VerblijfsObject_type3 extends nl.vrom.www.bag.stuf._0120.VerblijfsObjectAntwoord
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = verblijfsObject_type3
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
                        * field for GerelateerdeAdressen
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.HeeftNummerAanduidingAntwoord localGerelateerdeAdressen ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGerelateerdeAdressenTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.HeeftNummerAanduidingAntwoord
                           */
                           public  nl.vrom.www.bag.stuf._0120.HeeftNummerAanduidingAntwoord getGerelateerdeAdressen(){
                               return localGerelateerdeAdressen;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GerelateerdeAdressen
                               */
                               public void setGerelateerdeAdressen(nl.vrom.www.bag.stuf._0120.HeeftNummerAanduidingAntwoord param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGerelateerdeAdressenTracker = true;
                                       } else {
                                          localGerelateerdeAdressenTracker = true;
                                              
                                       }
                                   
                                            this.localGerelateerdeAdressen=param;
                                    

                               }
                            

                        /**
                        * field for GerelateerdPand
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.LigtInPandAntwoord localGerelateerdPand ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGerelateerdPandTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.LigtInPandAntwoord
                           */
                           public  nl.vrom.www.bag.stuf._0120.LigtInPandAntwoord getGerelateerdPand(){
                               return localGerelateerdPand;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GerelateerdPand
                               */
                               public void setGerelateerdPand(nl.vrom.www.bag.stuf._0120.LigtInPandAntwoord param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGerelateerdPandTracker = true;
                                       } else {
                                          localGerelateerdPandTracker = true;
                                              
                                       }
                                   
                                            this.localGerelateerdPand=param;
                                    

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
                       VerblijfsObject_type3.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":verblijfsObject_type3",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "verblijfsObject_type3",
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
                                } if (localVerblijfsObjectGeometrieTracker){
                                    if (localVerblijfsObjectGeometrie==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"verblijfsObjectGeometrie", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"verblijfsObjectGeometrie");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("verblijfsObjectGeometrie");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localVerblijfsObjectGeometrie.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObjectGeometrie"),
                                        factory,xmlWriter);
                                    }
                                } if (localGebruiksdoelVerblijfsobjectTracker){
                                       if (localGebruiksdoelVerblijfsobject!=null){
                                            for (int i = 0;i < localGebruiksdoelVerblijfsobject.length;i++){
                                                if (localGebruiksdoelVerblijfsobject[i] != null){
                                                 localGebruiksdoelVerblijfsobject[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","gebruiksdoelVerblijfsobject"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                            // write null attribute
                                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"gebruiksdoelVerblijfsobject", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"gebruiksdoelVerblijfsobject");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("gebruiksdoelVerblijfsobject");
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

                                                        xmlWriter.writeStartElement(prefix2,"gebruiksdoelVerblijfsobject", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"gebruiksdoelVerblijfsobject");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("gebruiksdoelVerblijfsobject");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localOppervlakteVerblijfsobjectTracker){
                                    if (localOppervlakteVerblijfsobject==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"oppervlakteVerblijfsobject", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"oppervlakteVerblijfsobject");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("oppervlakteVerblijfsobject");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localOppervlakteVerblijfsobject.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","oppervlakteVerblijfsobject"),
                                        factory,xmlWriter);
                                    }
                                } if (localVerblijfsobjectStatusTracker){
                                    if (localVerblijfsobjectStatus==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"verblijfsobjectStatus", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"verblijfsobjectStatus");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("verblijfsobjectStatus");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localVerblijfsobjectStatus.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsobjectStatus"),
                                        factory,xmlWriter);
                                    }
                                } if (localGerelateerdeAdressenTracker){
                                    if (localGerelateerdeAdressen==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"GerelateerdeAdressen", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"GerelateerdeAdressen");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("GerelateerdeAdressen");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localGerelateerdeAdressen.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdeAdressen"),
                                        factory,xmlWriter);
                                    }
                                } if (localGerelateerdPandTracker){
                                    if (localGerelateerdPand==null){

                                            java.lang.String namespace2 = "http://www.vrom.nl/bag/stuf/0120";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"GerelateerdPand", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"GerelateerdPand");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("GerelateerdPand");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localGerelateerdPand.serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdPand"),
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
                    attribList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObject_type3"));
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
                                } if (localVerblijfsObjectGeometrieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "verblijfsObjectGeometrie"));
                            
                            
                                    elementList.add(localVerblijfsObjectGeometrie==null?null:
                                    localVerblijfsObjectGeometrie);
                                } if (localGebruiksdoelVerblijfsobjectTracker){
                             if (localGebruiksdoelVerblijfsobject!=null) {
                                 for (int i = 0;i < localGebruiksdoelVerblijfsobject.length;i++){

                                    if (localGebruiksdoelVerblijfsobject[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "gebruiksdoelVerblijfsobject"));
                                         elementList.add(localGebruiksdoelVerblijfsobject[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "gebruiksdoelVerblijfsobject"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "gebruiksdoelVerblijfsobject"));
                                        elementList.add(localGebruiksdoelVerblijfsobject);
                                    
                             }

                        } if (localOppervlakteVerblijfsobjectTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "oppervlakteVerblijfsobject"));
                            
                            
                                    elementList.add(localOppervlakteVerblijfsobject==null?null:
                                    localOppervlakteVerblijfsobject);
                                } if (localVerblijfsobjectStatusTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "verblijfsobjectStatus"));
                            
                            
                                    elementList.add(localVerblijfsobjectStatus==null?null:
                                    localVerblijfsobjectStatus);
                                } if (localGerelateerdeAdressenTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "GerelateerdeAdressen"));
                            
                            
                                    elementList.add(localGerelateerdeAdressen==null?null:
                                    localGerelateerdeAdressen);
                                } if (localGerelateerdPandTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                      "GerelateerdPand"));
                            
                            
                                    elementList.add(localGerelateerdPand==null?null:
                                    localGerelateerdPand);
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
        public static VerblijfsObject_type3 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            VerblijfsObject_type3 object =
                new VerblijfsObject_type3();

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
                    
                            if (!"verblijfsObject_type3".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (VerblijfsObject_type3)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
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
                
                        java.util.ArrayList list8 = new java.util.ArrayList();
                    
                                    
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObjectGeometrie").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setVerblijfsObjectGeometrie(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setVerblijfsObjectGeometrie(nl.vrom.www.bag._0120.GeometriePunt.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","gebruiksdoelVerblijfsobject").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list8.add(null);
                                                              reader.next();
                                                          } else {
                                                        list8.add(nl.vrom.www.bag.stuf._0120.GebruiksdoelVerblijfsobject_type3.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone8 = false;
                                                        while(!loopDone8){
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
                                                                loopDone8 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","gebruiksdoelVerblijfsobject").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list8.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list8.add(nl.vrom.www.bag.stuf._0120.GebruiksdoelVerblijfsobject_type3.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone8 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setGebruiksdoelVerblijfsobject((nl.vrom.www.bag.stuf._0120.GebruiksdoelVerblijfsobject_type3[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.GebruiksdoelVerblijfsobject_type3.class,
                                                                list8));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","oppervlakteVerblijfsobject").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setOppervlakteVerblijfsobject(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setOppervlakteVerblijfsobject(nl.vrom.www.bag.stuf._0120.OppervlakteVerblijfsobject_type3.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsobjectStatus").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setVerblijfsobjectStatus(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setVerblijfsobjectStatus(nl.vrom.www.bag.stuf._0120.VerblijfsobjectStatus_type3.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdeAdressen").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setGerelateerdeAdressen(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setGerelateerdeAdressen(nl.vrom.www.bag.stuf._0120.HeeftNummerAanduidingAntwoord.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","GerelateerdPand").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setGerelateerdPand(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setGerelateerdPand(nl.vrom.www.bag.stuf._0120.LigtInPandAntwoord.Factory.parse(reader));
                                              
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
           
          