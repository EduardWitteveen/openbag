
/**
 * CoordinatesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  CoordinatesType bean class
            */
        
        public  class CoordinatesType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = CoordinatesType
                Namespace URI = http://www.opengis.net/gml
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.opengis.net/gml")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for String
                        */

                        
                                    protected java.lang.String localString ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getString(){
                               return localString;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param String
                               */
                               public void setString(java.lang.String param){
                            
                                            this.localString=param;
                                    

                               }
                            

                            public java.lang.String toString(){
                                
                                        return localString.toString();
                                    
                            }
                        

                        /**
                        * field for Decimal
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localDecimal =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(".");
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDecimal(){
                               return localDecimal;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Decimal
                               */
                               public void setDecimal(java.lang.String param){
                            
                                            this.localDecimal=param;
                                    

                               }
                            

                        /**
                        * field for Cs
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localCs =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(",");
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCs(){
                               return localCs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cs
                               */
                               public void setCs(java.lang.String param){
                            
                                            this.localCs=param;
                                    

                               }
                            

                        /**
                        * field for Ts
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localTs =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(" ");
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTs(){
                               return localTs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ts
                               */
                               public void setTs(java.lang.String param){
                            
                                            this.localTs=param;
                                    

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
                       CoordinatesType.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.opengis.net/gml");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":CoordinatesType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "CoordinatesType",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localDecimal != null){
                                        
                                                writeAttribute("",
                                                         "decimal",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDecimal), xmlWriter);

                                            
                                      }
                                    
                                            if (localCs != null){
                                        
                                                writeAttribute("",
                                                         "cs",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCs), xmlWriter);

                                            
                                      }
                                    
                                            if (localTs != null){
                                        
                                                writeAttribute("",
                                                         "ts",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTs), xmlWriter);

                                            
                                      }
                                    

                                          if (localString==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("string cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localString);
                                            
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

                
                                     
                                     elementList.add(org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT);
                                 
                                        if (localString != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localString));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("string cannot be null!!");
                                        }
                                    
                            attribList.add(
                            new javax.xml.namespace.QName("","decimal"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDecimal));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","cs"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCs));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","ts"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTs));
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        
                public static CoordinatesType fromString(java.lang.String value,
                                                    java.lang.String namespaceURI){
                    CoordinatesType returnValue = new  CoordinatesType();
                    
                            returnValue.setString(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));
                        

                    return returnValue;
                }

                public static CoordinatesType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                                    java.lang.String content) {
                    if (content.indexOf(":") > -1){
                        java.lang.String prefix = content.substring(0,content.indexOf(":"));
                        java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                        return CoordinatesType.Factory.fromString(content,namespaceUri);
                    } else {
                       return CoordinatesType.Factory.fromString(content,"");
                    }
                }

            

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static CoordinatesType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            CoordinatesType object =
                new CoordinatesType();

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
                    
                            if (!"CoordinatesType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CoordinatesType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    // handle attribute "decimal"
                    java.lang.String tempAttribDecimal =
                        
                                reader.getAttributeValue(null,"decimal");
                            
                   if (tempAttribDecimal!=null){
                         java.lang.String content = tempAttribDecimal;
                        
                                                 object.setDecimal(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribDecimal));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("decimal");
                    
                    // handle attribute "cs"
                    java.lang.String tempAttribCs =
                        
                                reader.getAttributeValue(null,"cs");
                            
                   if (tempAttribCs!=null){
                         java.lang.String content = tempAttribCs;
                        
                                                 object.setCs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribCs));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("cs");
                    
                    // handle attribute "ts"
                    java.lang.String tempAttribTs =
                        
                                reader.getAttributeValue(null,"ts");
                            
                   if (tempAttribTs!=null){
                         java.lang.String content = tempAttribTs;
                        
                                                 object.setTs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribTs));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("ts");
                       
                while(!reader.isEndElement()) {
                    if (reader.isStartElement()  || reader.hasText()){
                
                                    if (reader.isStartElement()  || reader.hasText()){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setString(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          