
/**
 * Stuurgegevens_type0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0205;
            

            /**
            *  Stuurgegevens_type0 bean class
            */
        
        public  class Stuurgegevens_type0
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = stuurgegevens_type0
                Namespace URI = http://www.egem.nl/StUF/StUF0205
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.egem.nl/StUF/StUF0205")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Berichtsoort
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Berichtsoort_type1 localBerichtsoort ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Berichtsoort_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Berichtsoort_type1 getBerichtsoort(){
                               return localBerichtsoort;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Berichtsoort
                               */
                               public void setBerichtsoort(nl.egem.www.stuf.stuf0205.Berichtsoort_type1 param){
                            
                                            this.localBerichtsoort=param;
                                    

                               }
                            

                        /**
                        * field for Sectormodel
                        */

                        
                                    protected java.lang.String localSectormodel ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSectormodel(){
                               return localSectormodel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sectormodel
                               */
                               public void setSectormodel(java.lang.String param){
                            
                                            this.localSectormodel=param;
                                    

                               }
                            

                        /**
                        * field for VersieStUF
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Versienr localVersieStUF ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Versienr
                           */
                           public  nl.egem.www.stuf.stuf0205.Versienr getVersieStUF(){
                               return localVersieStUF;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VersieStUF
                               */
                               public void setVersieStUF(nl.egem.www.stuf.stuf0205.Versienr param){
                            
                                            this.localVersieStUF=param;
                                    

                               }
                            

                        /**
                        * field for VersieSectormodel
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Versienr localVersieSectormodel ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Versienr
                           */
                           public  nl.egem.www.stuf.stuf0205.Versienr getVersieSectormodel(){
                               return localVersieSectormodel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param VersieSectormodel
                               */
                               public void setVersieSectormodel(nl.egem.www.stuf.stuf0205.Versienr param){
                            
                                            this.localVersieSectormodel=param;
                                    

                               }
                            

                        /**
                        * field for Zender
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Systeem localZender ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Systeem
                           */
                           public  nl.egem.www.stuf.stuf0205.Systeem getZender(){
                               return localZender;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zender
                               */
                               public void setZender(nl.egem.www.stuf.stuf0205.Systeem param){
                            
                                            this.localZender=param;
                                    

                               }
                            

                        /**
                        * field for Ontvanger
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Systeem localOntvanger ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Systeem
                           */
                           public  nl.egem.www.stuf.stuf0205.Systeem getOntvanger(){
                               return localOntvanger;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ontvanger
                               */
                               public void setOntvanger(nl.egem.www.stuf.stuf0205.Systeem param){
                            
                                            this.localOntvanger=param;
                                    

                               }
                            

                        /**
                        * field for Referentienummer
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.RefNummer localReferentienummer ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.RefNummer
                           */
                           public  nl.egem.www.stuf.stuf0205.RefNummer getReferentienummer(){
                               return localReferentienummer;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Referentienummer
                               */
                               public void setReferentienummer(nl.egem.www.stuf.stuf0205.RefNummer param){
                            
                                            this.localReferentienummer=param;
                                    

                               }
                            

                        /**
                        * field for TijdstipBericht
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Tijdstip localTijdstipBericht ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Tijdstip
                           */
                           public  nl.egem.www.stuf.stuf0205.Tijdstip getTijdstipBericht(){
                               return localTijdstipBericht;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TijdstipBericht
                               */
                               public void setTijdstipBericht(nl.egem.www.stuf.stuf0205.Tijdstip param){
                            
                                            this.localTijdstipBericht=param;
                                    

                               }
                            

                        /**
                        * field for StuurgegevensChoice_type0
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0 localStuurgegevensChoice_type0 ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0
                           */
                           public  nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0 getStuurgegevensChoice_type0(){
                               return localStuurgegevensChoice_type0;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StuurgegevensChoice_type0
                               */
                               public void setStuurgegevensChoice_type0(nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0 param){
                            
                                            this.localStuurgegevensChoice_type0=param;
                                    

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
                       Stuurgegevens_type0.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.egem.nl/StUF/StUF0205");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":stuurgegevens_type0",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "stuurgegevens_type0",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localBerichtsoort==null){
                                                 throw new org.apache.axis2.databinding.ADBException("berichtsoort cannot be null!!");
                                            }
                                           localBerichtsoort.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","berichtsoort"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sectormodel", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sectormodel");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sectormodel");
                                    }
                                

                                          if (localSectormodel==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sectormodel cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSectormodel);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localVersieStUF==null){
                                                 throw new org.apache.axis2.databinding.ADBException("versieStUF cannot be null!!");
                                            }
                                           localVersieStUF.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","versieStUF"),
                                               factory,xmlWriter);
                                        
                                            if (localVersieSectormodel==null){
                                                 throw new org.apache.axis2.databinding.ADBException("versieSectormodel cannot be null!!");
                                            }
                                           localVersieSectormodel.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","versieSectormodel"),
                                               factory,xmlWriter);
                                        
                                            if (localZender==null){
                                                 throw new org.apache.axis2.databinding.ADBException("zender cannot be null!!");
                                            }
                                           localZender.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","zender"),
                                               factory,xmlWriter);
                                        
                                            if (localOntvanger==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ontvanger cannot be null!!");
                                            }
                                           localOntvanger.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","ontvanger"),
                                               factory,xmlWriter);
                                        
                                            if (localReferentienummer==null){
                                                 throw new org.apache.axis2.databinding.ADBException("referentienummer cannot be null!!");
                                            }
                                           localReferentienummer.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","referentienummer"),
                                               factory,xmlWriter);
                                        
                                            if (localTijdstipBericht==null){
                                                 throw new org.apache.axis2.databinding.ADBException("tijdstipBericht cannot be null!!");
                                            }
                                           localTijdstipBericht.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","tijdstipBericht"),
                                               factory,xmlWriter);
                                        
                                            if (localStuurgegevensChoice_type0==null){
                                                 throw new org.apache.axis2.databinding.ADBException("stuurgegevensChoice_type0 cannot be null!!");
                                            }
                                           localStuurgegevensChoice_type0.serialize(null,factory,xmlWriter);
                                        
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

                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "berichtsoort"));
                            
                            
                                    if (localBerichtsoort==null){
                                         throw new org.apache.axis2.databinding.ADBException("berichtsoort cannot be null!!");
                                    }
                                    elementList.add(localBerichtsoort);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "sectormodel"));
                                 
                                        if (localSectormodel != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSectormodel));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sectormodel cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "versieStUF"));
                            
                            
                                    if (localVersieStUF==null){
                                         throw new org.apache.axis2.databinding.ADBException("versieStUF cannot be null!!");
                                    }
                                    elementList.add(localVersieStUF);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "versieSectormodel"));
                            
                            
                                    if (localVersieSectormodel==null){
                                         throw new org.apache.axis2.databinding.ADBException("versieSectormodel cannot be null!!");
                                    }
                                    elementList.add(localVersieSectormodel);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "zender"));
                            
                            
                                    if (localZender==null){
                                         throw new org.apache.axis2.databinding.ADBException("zender cannot be null!!");
                                    }
                                    elementList.add(localZender);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "ontvanger"));
                            
                            
                                    if (localOntvanger==null){
                                         throw new org.apache.axis2.databinding.ADBException("ontvanger cannot be null!!");
                                    }
                                    elementList.add(localOntvanger);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "referentienummer"));
                            
                            
                                    if (localReferentienummer==null){
                                         throw new org.apache.axis2.databinding.ADBException("referentienummer cannot be null!!");
                                    }
                                    elementList.add(localReferentienummer);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "tijdstipBericht"));
                            
                            
                                    if (localTijdstipBericht==null){
                                         throw new org.apache.axis2.databinding.ADBException("tijdstipBericht cannot be null!!");
                                    }
                                    elementList.add(localTijdstipBericht);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "stuurgegevensChoice_type0"));
                            
                            
                                    if (localStuurgegevensChoice_type0==null){
                                         throw new org.apache.axis2.databinding.ADBException("stuurgegevensChoice_type0 cannot be null!!");
                                    }
                                    elementList.add(localStuurgegevensChoice_type0);
                                

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
        public static Stuurgegevens_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Stuurgegevens_type0 object =
                new Stuurgegevens_type0();

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
                    
                            if (!"stuurgegevens_type0".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Stuurgegevens_type0)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","berichtsoort").equals(reader.getName())){
                                
                                                object.setBerichtsoort(nl.egem.www.stuf.stuf0205.Berichtsoort_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sectormodel").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSectormodel(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","versieStUF").equals(reader.getName())){
                                
                                                object.setVersieStUF(nl.egem.www.stuf.stuf0205.Versienr.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","versieSectormodel").equals(reader.getName())){
                                
                                                object.setVersieSectormodel(nl.egem.www.stuf.stuf0205.Versienr.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","zender").equals(reader.getName())){
                                
                                                object.setZender(nl.egem.www.stuf.stuf0205.Systeem.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","ontvanger").equals(reader.getName())){
                                
                                                object.setOntvanger(nl.egem.www.stuf.stuf0205.Systeem.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","referentienummer").equals(reader.getName())){
                                
                                                object.setReferentienummer(nl.egem.www.stuf.stuf0205.RefNummer.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","tijdstipBericht").equals(reader.getName())){
                                
                                                object.setTijdstipBericht(nl.egem.www.stuf.stuf0205.Tijdstip.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() ){
                                
                                                object.setStuurgegevensChoice_type0(nl.egem.www.stuf.stuf0205.StuurgegevensChoice_type0.Factory.parse(reader));
                                            
                              }  // End of if for expected property start element
                                  
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
           
          