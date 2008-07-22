
/**
 * StuurgegevensChoice_type3.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0205;
            

            /**
            *  StuurgegevensChoice_type3 bean class
            */
        
        public  class StuurgegevensChoice_type3
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = stuurgegevensChoice_type3
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
            
                   localKennisgevingTracker = false;
                
                   localTransactieTracker = false;
                
                   localVraagTracker = false;
                
                   localAntwoordTracker = false;
                
                   localBevestigingTracker = false;
                
                   localFoutTracker = false;
                
            }
        

                        /**
                        * field for Kennisgeving
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Kennisgeving_type1 localKennisgeving ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localKennisgevingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Kennisgeving_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Kennisgeving_type1 getKennisgeving(){
                               return localKennisgeving;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Kennisgeving
                               */
                               public void setKennisgeving(nl.egem.www.stuf.stuf0205.Kennisgeving_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localKennisgevingTracker = true;
                                       } else {
                                          localKennisgevingTracker = false;
                                              
                                       }
                                   
                                            this.localKennisgeving=param;
                                    

                               }
                            

                        /**
                        * field for Transactie
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Transactie_type1 localTransactie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTransactieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Transactie_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Transactie_type1 getTransactie(){
                               return localTransactie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Transactie
                               */
                               public void setTransactie(nl.egem.www.stuf.stuf0205.Transactie_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localTransactieTracker = true;
                                       } else {
                                          localTransactieTracker = false;
                                              
                                       }
                                   
                                            this.localTransactie=param;
                                    

                               }
                            

                        /**
                        * field for Vraag
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Vraag_type1 localVraag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVraagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Vraag_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Vraag_type1 getVraag(){
                               return localVraag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Vraag
                               */
                               public void setVraag(nl.egem.www.stuf.stuf0205.Vraag_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localVraagTracker = true;
                                       } else {
                                          localVraagTracker = false;
                                              
                                       }
                                   
                                            this.localVraag=param;
                                    

                               }
                            

                        /**
                        * field for Antwoord
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Antwoord_type1 localAntwoord ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAntwoordTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Antwoord_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Antwoord_type1 getAntwoord(){
                               return localAntwoord;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Antwoord
                               */
                               public void setAntwoord(nl.egem.www.stuf.stuf0205.Antwoord_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAntwoordTracker = true;
                                       } else {
                                          localAntwoordTracker = false;
                                              
                                       }
                                   
                                            this.localAntwoord=param;
                                    

                               }
                            

                        /**
                        * field for Bevestiging
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Bevestiging_type1 localBevestiging ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBevestigingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Bevestiging_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Bevestiging_type1 getBevestiging(){
                               return localBevestiging;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Bevestiging
                               */
                               public void setBevestiging(nl.egem.www.stuf.stuf0205.Bevestiging_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localBevestigingTracker = true;
                                       } else {
                                          localBevestigingTracker = false;
                                              
                                       }
                                   
                                            this.localBevestiging=param;
                                    

                               }
                            

                        /**
                        * field for Fout
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Fout_type1 localFout ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFoutTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Fout_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Fout_type1 getFout(){
                               return localFout;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fout
                               */
                               public void setFout(nl.egem.www.stuf.stuf0205.Fout_type1 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localFoutTracker = true;
                                       } else {
                                          localFoutTracker = false;
                                              
                                       }
                                   
                                            this.localFout=param;
                                    

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
                       StuurgegevensChoice_type3.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":stuurgegevensChoice_type3",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "stuurgegevensChoice_type3",
                           xmlWriter);
                   }

               
                   }
                if (localKennisgevingTracker){
                                            if (localKennisgeving==null){
                                                 throw new org.apache.axis2.databinding.ADBException("kennisgeving cannot be null!!");
                                            }
                                           localKennisgeving.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","kennisgeving"),
                                               factory,xmlWriter);
                                        } if (localTransactieTracker){
                                            if (localTransactie==null){
                                                 throw new org.apache.axis2.databinding.ADBException("transactie cannot be null!!");
                                            }
                                           localTransactie.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","transactie"),
                                               factory,xmlWriter);
                                        } if (localVraagTracker){
                                            if (localVraag==null){
                                                 throw new org.apache.axis2.databinding.ADBException("vraag cannot be null!!");
                                            }
                                           localVraag.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","vraag"),
                                               factory,xmlWriter);
                                        } if (localAntwoordTracker){
                                            if (localAntwoord==null){
                                                 throw new org.apache.axis2.databinding.ADBException("antwoord cannot be null!!");
                                            }
                                           localAntwoord.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","antwoord"),
                                               factory,xmlWriter);
                                        } if (localBevestigingTracker){
                                            if (localBevestiging==null){
                                                 throw new org.apache.axis2.databinding.ADBException("bevestiging cannot be null!!");
                                            }
                                           localBevestiging.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","bevestiging"),
                                               factory,xmlWriter);
                                        } if (localFoutTracker){
                                            if (localFout==null){
                                                 throw new org.apache.axis2.databinding.ADBException("fout cannot be null!!");
                                            }
                                           localFout.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","fout"),
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

                 if (localKennisgevingTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "kennisgeving"));
                            
                            
                                    if (localKennisgeving==null){
                                         throw new org.apache.axis2.databinding.ADBException("kennisgeving cannot be null!!");
                                    }
                                    elementList.add(localKennisgeving);
                                } if (localTransactieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "transactie"));
                            
                            
                                    if (localTransactie==null){
                                         throw new org.apache.axis2.databinding.ADBException("transactie cannot be null!!");
                                    }
                                    elementList.add(localTransactie);
                                } if (localVraagTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "vraag"));
                            
                            
                                    if (localVraag==null){
                                         throw new org.apache.axis2.databinding.ADBException("vraag cannot be null!!");
                                    }
                                    elementList.add(localVraag);
                                } if (localAntwoordTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "antwoord"));
                            
                            
                                    if (localAntwoord==null){
                                         throw new org.apache.axis2.databinding.ADBException("antwoord cannot be null!!");
                                    }
                                    elementList.add(localAntwoord);
                                } if (localBevestigingTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "bevestiging"));
                            
                            
                                    if (localBevestiging==null){
                                         throw new org.apache.axis2.databinding.ADBException("bevestiging cannot be null!!");
                                    }
                                    elementList.add(localBevestiging);
                                } if (localFoutTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "fout"));
                            
                            
                                    if (localFout==null){
                                         throw new org.apache.axis2.databinding.ADBException("fout cannot be null!!");
                                    }
                                    elementList.add(localFout);
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
        public static StuurgegevensChoice_type3 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            StuurgegevensChoice_type3 object =
                new StuurgegevensChoice_type3();

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
                

                 
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","kennisgeving").equals(reader.getName())){
                                
                                                object.setKennisgeving(nl.egem.www.stuf.stuf0205.Kennisgeving_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","transactie").equals(reader.getName())){
                                
                                                object.setTransactie(nl.egem.www.stuf.stuf0205.Transactie_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","vraag").equals(reader.getName())){
                                
                                                object.setVraag(nl.egem.www.stuf.stuf0205.Vraag_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","antwoord").equals(reader.getName())){
                                
                                                object.setAntwoord(nl.egem.www.stuf.stuf0205.Antwoord_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","bevestiging").equals(reader.getName())){
                                
                                                object.setBevestiging(nl.egem.www.stuf.stuf0205.Bevestiging_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","fout").equals(reader.getName())){
                                
                                                object.setFout(nl.egem.www.stuf.stuf0205.Fout_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          