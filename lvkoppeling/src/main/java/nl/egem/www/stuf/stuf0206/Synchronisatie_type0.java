
/**
 * Synchronisatie_type0.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0206;
            

            /**
            *  Synchronisatie_type0 bean class
            */
        
        public  class Synchronisatie_type0
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = synchronisatie_type0
                Namespace URI = http://www.egem.nl/StUF/StUF0206
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.egem.nl/StUF/StUF0206")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Entiteittype
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.EntiteitType localEntiteittype ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.EntiteitType
                           */
                           public  nl.egem.www.stuf.stuf0206.EntiteitType getEntiteittype(){
                               return localEntiteittype;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Entiteittype
                               */
                               public void setEntiteittype(nl.egem.www.stuf.stuf0206.EntiteitType param){
                            
                                            this.localEntiteittype=param;
                                    

                               }
                            

                        /**
                        * field for Mutatiesoort
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.Mutatiesoort localMutatiesoort ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.Mutatiesoort
                           */
                           public  nl.egem.www.stuf.stuf0206.Mutatiesoort getMutatiesoort(){
                               return localMutatiesoort;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mutatiesoort
                               */
                               public void setMutatiesoort(nl.egem.www.stuf.stuf0206.Mutatiesoort param){
                            
                                            this.localMutatiesoort=param;
                                    

                               }
                            

                        /**
                        * field for EventCode
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.EventCode localEventCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEventCodeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.EventCode
                           */
                           public  nl.egem.www.stuf.stuf0206.EventCode getEventCode(){
                               return localEventCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EventCode
                               */
                               public void setEventCode(nl.egem.www.stuf.stuf0206.EventCode param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEventCodeTracker = true;
                                       } else {
                                          localEventCodeTracker = false;
                                              
                                       }
                                   
                                            this.localEventCode=param;
                                    

                               }
                            

                        /**
                        * field for InterpretatieCode
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.InterpretatieCode localInterpretatieCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInterpretatieCodeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.InterpretatieCode
                           */
                           public  nl.egem.www.stuf.stuf0206.InterpretatieCode getInterpretatieCode(){
                               return localInterpretatieCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InterpretatieCode
                               */
                               public void setInterpretatieCode(nl.egem.www.stuf.stuf0206.InterpretatieCode param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localInterpretatieCodeTracker = true;
                                       } else {
                                          localInterpretatieCodeTracker = false;
                                              
                                       }
                                   
                                            this.localInterpretatieCode=param;
                                    

                               }
                            

                        /**
                        * field for IndicatorOvername
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.IndicatorOvername localIndicatorOvername ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIndicatorOvernameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.IndicatorOvername
                           */
                           public  nl.egem.www.stuf.stuf0206.IndicatorOvername getIndicatorOvername(){
                               return localIndicatorOvername;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IndicatorOvername
                               */
                               public void setIndicatorOvername(nl.egem.www.stuf.stuf0206.IndicatorOvername param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localIndicatorOvernameTracker = true;
                                       } else {
                                          localIndicatorOvernameTracker = false;
                                              
                                       }
                                   
                                            this.localIndicatorOvername=param;
                                    

                               }
                            

                        /**
                        * field for TijdstipMutatie
                        */

                        
                                    protected nl.egem.www.stuf.stuf0206.Tijdstip localTijdstipMutatie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTijdstipMutatieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0206.Tijdstip
                           */
                           public  nl.egem.www.stuf.stuf0206.Tijdstip getTijdstipMutatie(){
                               return localTijdstipMutatie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TijdstipMutatie
                               */
                               public void setTijdstipMutatie(nl.egem.www.stuf.stuf0206.Tijdstip param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTijdstipMutatieTracker = true;
                                       } else {
                                          localTijdstipMutatieTracker = false;
                                              
                                       }
                                   
                                            this.localTijdstipMutatie=param;
                                    

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
                       Synchronisatie_type0.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.egem.nl/StUF/StUF0206");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":synchronisatie_type0",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "synchronisatie_type0",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localEntiteittype==null){
                                                 throw new org.apache.axis2.databinding.ADBException("entiteittype cannot be null!!");
                                            }
                                           localEntiteittype.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","entiteittype"),
                                               factory,xmlWriter);
                                        
                                            if (localMutatiesoort==null){
                                                 throw new org.apache.axis2.databinding.ADBException("mutatiesoort cannot be null!!");
                                            }
                                           localMutatiesoort.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","mutatiesoort"),
                                               factory,xmlWriter);
                                         if (localEventCodeTracker){
                                            if (localEventCode==null){
                                                 throw new org.apache.axis2.databinding.ADBException("eventCode cannot be null!!");
                                            }
                                           localEventCode.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","eventCode"),
                                               factory,xmlWriter);
                                        } if (localInterpretatieCodeTracker){
                                            if (localInterpretatieCode==null){
                                                 throw new org.apache.axis2.databinding.ADBException("interpretatieCode cannot be null!!");
                                            }
                                           localInterpretatieCode.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","interpretatieCode"),
                                               factory,xmlWriter);
                                        } if (localIndicatorOvernameTracker){
                                            if (localIndicatorOvername==null){
                                                 throw new org.apache.axis2.databinding.ADBException("indicatorOvername cannot be null!!");
                                            }
                                           localIndicatorOvername.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","indicatorOvername"),
                                               factory,xmlWriter);
                                        } if (localTijdstipMutatieTracker){
                                            if (localTijdstipMutatie==null){
                                                 throw new org.apache.axis2.databinding.ADBException("tijdstipMutatie cannot be null!!");
                                            }
                                           localTijdstipMutatie.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","tijdstipMutatie"),
                                               factory,xmlWriter);
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

                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "entiteittype"));
                            
                            
                                    if (localEntiteittype==null){
                                         throw new org.apache.axis2.databinding.ADBException("entiteittype cannot be null!!");
                                    }
                                    elementList.add(localEntiteittype);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "mutatiesoort"));
                            
                            
                                    if (localMutatiesoort==null){
                                         throw new org.apache.axis2.databinding.ADBException("mutatiesoort cannot be null!!");
                                    }
                                    elementList.add(localMutatiesoort);
                                 if (localEventCodeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "eventCode"));
                            
                            
                                    if (localEventCode==null){
                                         throw new org.apache.axis2.databinding.ADBException("eventCode cannot be null!!");
                                    }
                                    elementList.add(localEventCode);
                                } if (localInterpretatieCodeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "interpretatieCode"));
                            
                            
                                    if (localInterpretatieCode==null){
                                         throw new org.apache.axis2.databinding.ADBException("interpretatieCode cannot be null!!");
                                    }
                                    elementList.add(localInterpretatieCode);
                                } if (localIndicatorOvernameTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "indicatorOvername"));
                            
                            
                                    if (localIndicatorOvername==null){
                                         throw new org.apache.axis2.databinding.ADBException("indicatorOvername cannot be null!!");
                                    }
                                    elementList.add(localIndicatorOvername);
                                } if (localTijdstipMutatieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206",
                                                                      "tijdstipMutatie"));
                            
                            
                                    if (localTijdstipMutatie==null){
                                         throw new org.apache.axis2.databinding.ADBException("tijdstipMutatie cannot be null!!");
                                    }
                                    elementList.add(localTijdstipMutatie);
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
        public static Synchronisatie_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Synchronisatie_type0 object =
                new Synchronisatie_type0();

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
                    
                            if (!"synchronisatie_type0".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Synchronisatie_type0)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","entiteittype").equals(reader.getName())){
                                
                                                object.setEntiteittype(nl.egem.www.stuf.stuf0206.EntiteitType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","mutatiesoort").equals(reader.getName())){
                                
                                                object.setMutatiesoort(nl.egem.www.stuf.stuf0206.Mutatiesoort.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","eventCode").equals(reader.getName())){
                                
                                                object.setEventCode(nl.egem.www.stuf.stuf0206.EventCode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","interpretatieCode").equals(reader.getName())){
                                
                                                object.setInterpretatieCode(nl.egem.www.stuf.stuf0206.InterpretatieCode.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","indicatorOvername").equals(reader.getName())){
                                
                                                object.setIndicatorOvername(nl.egem.www.stuf.stuf0206.IndicatorOvername.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0206","tijdstipMutatie").equals(reader.getName())){
                                
                                                object.setTijdstipMutatie(nl.egem.www.stuf.stuf0206.Tijdstip.Factory.parse(reader));
                                              
                                        reader.next();
                                    
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
           
          