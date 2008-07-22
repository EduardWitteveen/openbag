
/**
 * Vraag_type1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0205;
            

            /**
            *  Vraag_type1 bean class
            */
        
        public  class Vraag_type1
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = vraag_type1
                Namespace URI = http://www.egem.nl/StUF/StUF0205
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.egem.nl/StUF/StUF0205")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Entiteittype
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.EntiteitTypeE localEntiteittype ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.EntiteitTypeE
                           */
                           public  nl.egem.www.stuf.stuf0205.EntiteitTypeE getEntiteittype(){
                               return localEntiteittype;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Entiteittype
                               */
                               public void setEntiteittype(nl.egem.www.stuf.stuf0205.EntiteitTypeE param){
                            
                                            this.localEntiteittype=param;
                                    

                               }
                            

                        /**
                        * field for InterpretatieCode
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.InterpretatieCodeE localInterpretatieCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInterpretatieCodeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.InterpretatieCodeE
                           */
                           public  nl.egem.www.stuf.stuf0205.InterpretatieCodeE getInterpretatieCode(){
                               return localInterpretatieCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param InterpretatieCode
                               */
                               public void setInterpretatieCode(nl.egem.www.stuf.stuf0205.InterpretatieCodeE param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localInterpretatieCodeTracker = true;
                                       } else {
                                          localInterpretatieCodeTracker = false;
                                              
                                       }
                                   
                                            this.localInterpretatieCode=param;
                                    

                               }
                            

                        /**
                        * field for Sortering
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.SorteringE localSortering ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSorteringTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.SorteringE
                           */
                           public  nl.egem.www.stuf.stuf0205.SorteringE getSortering(){
                               return localSortering;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sortering
                               */
                               public void setSortering(nl.egem.www.stuf.stuf0205.SorteringE param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSorteringTracker = true;
                                       } else {
                                          localSorteringTracker = false;
                                              
                                       }
                                   
                                            this.localSortering=param;
                                    

                               }
                            

                        /**
                        * field for MaximumAantal
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.MaximumAantalE localMaximumAantal ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMaximumAantalTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.MaximumAantalE
                           */
                           public  nl.egem.www.stuf.stuf0205.MaximumAantalE getMaximumAantal(){
                               return localMaximumAantal;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaximumAantal
                               */
                               public void setMaximumAantal(nl.egem.www.stuf.stuf0205.MaximumAantalE param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localMaximumAantalTracker = true;
                                       } else {
                                          localMaximumAantalTracker = false;
                                              
                                       }
                                   
                                            this.localMaximumAantal=param;
                                    

                               }
                            

                        /**
                        * field for IndicatorHistorisch
                        */

                        
                                    protected boolean localIndicatorHistorisch =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("false");
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIndicatorHistorischTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIndicatorHistorisch(){
                               return localIndicatorHistorisch;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IndicatorHistorisch
                               */
                               public void setIndicatorHistorisch(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIndicatorHistorischTracker = false;
                                              
                                       } else {
                                          localIndicatorHistorischTracker = true;
                                       }
                                   
                                            this.localIndicatorHistorisch=param;
                                    

                               }
                            

                        /**
                        * field for IndicatorVervolgvraag
                        */

                        
                                    protected boolean localIndicatorVervolgvraag =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("false");
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIndicatorVervolgvraagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIndicatorVervolgvraag(){
                               return localIndicatorVervolgvraag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IndicatorVervolgvraag
                               */
                               public void setIndicatorVervolgvraag(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIndicatorVervolgvraagTracker = false;
                                              
                                       } else {
                                          localIndicatorVervolgvraagTracker = true;
                                       }
                                   
                                            this.localIndicatorVervolgvraag=param;
                                    

                               }
                            

                        /**
                        * field for IndicatorAfnemerIndicatie
                        */

                        
                                    protected boolean localIndicatorAfnemerIndicatie =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean("false");
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIndicatorAfnemerIndicatieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getIndicatorAfnemerIndicatie(){
                               return localIndicatorAfnemerIndicatie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IndicatorAfnemerIndicatie
                               */
                               public void setIndicatorAfnemerIndicatie(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (false) {
                                           localIndicatorAfnemerIndicatieTracker = false;
                                              
                                       } else {
                                          localIndicatorAfnemerIndicatieTracker = true;
                                       }
                                   
                                            this.localIndicatorAfnemerIndicatie=param;
                                    

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
                       Vraag_type1.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":vraag_type1",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "vraag_type1",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localEntiteittype==null){
                                                 throw new org.apache.axis2.databinding.ADBException("entiteittype cannot be null!!");
                                            }
                                           localEntiteittype.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","entiteittype"),
                                               factory,xmlWriter);
                                         if (localInterpretatieCodeTracker){
                                            if (localInterpretatieCode==null){
                                                 throw new org.apache.axis2.databinding.ADBException("interpretatieCode cannot be null!!");
                                            }
                                           localInterpretatieCode.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","interpretatieCode"),
                                               factory,xmlWriter);
                                        } if (localSorteringTracker){
                                            if (localSortering==null){
                                                 throw new org.apache.axis2.databinding.ADBException("sortering cannot be null!!");
                                            }
                                           localSortering.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sortering"),
                                               factory,xmlWriter);
                                        } if (localMaximumAantalTracker){
                                            if (localMaximumAantal==null){
                                                 throw new org.apache.axis2.databinding.ADBException("maximumAantal cannot be null!!");
                                            }
                                           localMaximumAantal.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","maximumAantal"),
                                               factory,xmlWriter);
                                        } if (localIndicatorHistorischTracker){
                                    namespace = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"indicatorHistorisch", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"indicatorHistorisch");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("indicatorHistorisch");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("indicatorHistorisch cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorHistorisch));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIndicatorVervolgvraagTracker){
                                    namespace = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"indicatorVervolgvraag", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"indicatorVervolgvraag");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("indicatorVervolgvraag");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("indicatorVervolgvraag cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorVervolgvraag));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localIndicatorAfnemerIndicatieTracker){
                                    namespace = "http://www.egem.nl/StUF/StUF0205";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"indicatorAfnemerIndicatie", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"indicatorAfnemerIndicatie");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("indicatorAfnemerIndicatie");
                                    }
                                
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("indicatorAfnemerIndicatie cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorAfnemerIndicatie));
                                               }
                                    
                                   xmlWriter.writeEndElement();
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

                
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "entiteittype"));
                            
                            
                                    if (localEntiteittype==null){
                                         throw new org.apache.axis2.databinding.ADBException("entiteittype cannot be null!!");
                                    }
                                    elementList.add(localEntiteittype);
                                 if (localInterpretatieCodeTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "interpretatieCode"));
                            
                            
                                    if (localInterpretatieCode==null){
                                         throw new org.apache.axis2.databinding.ADBException("interpretatieCode cannot be null!!");
                                    }
                                    elementList.add(localInterpretatieCode);
                                } if (localSorteringTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "sortering"));
                            
                            
                                    if (localSortering==null){
                                         throw new org.apache.axis2.databinding.ADBException("sortering cannot be null!!");
                                    }
                                    elementList.add(localSortering);
                                } if (localMaximumAantalTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "maximumAantal"));
                            
                            
                                    if (localMaximumAantal==null){
                                         throw new org.apache.axis2.databinding.ADBException("maximumAantal cannot be null!!");
                                    }
                                    elementList.add(localMaximumAantal);
                                } if (localIndicatorHistorischTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "indicatorHistorisch"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorHistorisch));
                            } if (localIndicatorVervolgvraagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "indicatorVervolgvraag"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorVervolgvraag));
                            } if (localIndicatorAfnemerIndicatieTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "indicatorAfnemerIndicatie"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndicatorAfnemerIndicatie));
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
        public static Vraag_type1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Vraag_type1 object =
                new Vraag_type1();

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
                    
                            if (!"vraag_type1".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Vraag_type1)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","entiteittype").equals(reader.getName())){
                                
                                                object.setEntiteittype(nl.egem.www.stuf.stuf0205.EntiteitTypeE.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","interpretatieCode").equals(reader.getName())){
                                
                                                object.setInterpretatieCode(nl.egem.www.stuf.stuf0205.InterpretatieCodeE.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","sortering").equals(reader.getName())){
                                
                                                object.setSortering(nl.egem.www.stuf.stuf0205.SorteringE.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","maximumAantal").equals(reader.getName())){
                                
                                                object.setMaximumAantal(nl.egem.www.stuf.stuf0205.MaximumAantalE.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","indicatorHistorisch").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIndicatorHistorisch(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","indicatorVervolgvraag").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIndicatorVervolgvraag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","indicatorAfnemerIndicatie").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIndicatorAfnemerIndicatie(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
           
          