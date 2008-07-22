
/**
 * LinearRingType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  LinearRingType bean class
            */
        
        public  class LinearRingType extends net.opengis.www.gml.AbstractRingType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = LinearRingType
                Namespace URI = http://www.opengis.net/gml
                Namespace Prefix = ns3
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.opengis.net/gml")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for AbstractRingTypeChoice_type1
                        */

                        
                                    protected net.opengis.www.gml.AbstractRingTypeChoice_type1 localAbstractRingTypeChoice_type1 ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.AbstractRingTypeChoice_type1
                           */
                           public  net.opengis.www.gml.AbstractRingTypeChoice_type1 getAbstractRingTypeChoice_type1(){
                               return localAbstractRingTypeChoice_type1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AbstractRingTypeChoice_type1
                               */
                               public void setAbstractRingTypeChoice_type1(net.opengis.www.gml.AbstractRingTypeChoice_type1 param){
                            
                                            this.localAbstractRingTypeChoice_type1=param;
                                    

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
                       LinearRingType.this.serialize(parentQName,factory,xmlWriter);
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
                

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.opengis.net/gml");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":LinearRingType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "LinearRingType",
                           xmlWriter);
                   }

               
                                            if (localId != null){
                                        
                                                writeAttribute("http://www.opengis.net/gml",
                                                         "id",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId), xmlWriter);

                                            
                                      }
                                    
                                            if (localGid != null){
                                        
                                                writeAttribute("",
                                                         "gid",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGid), xmlWriter);

                                            
                                      }
                                    
                                            if (localSrsName != null){
                                        
                                                writeAttribute("",
                                                         "srsName",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSrsName), xmlWriter);

                                            
                                      }
                                    
                                            if (localSrsDimension != null){
                                        
                                                writeAttribute("",
                                                         "srsDimension",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSrsDimension), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localAxisLabels != null){
                                        writeAttribute("",
                                           "axisLabels",
                                           localAxisLabels.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localUomLabels != null){
                                        writeAttribute("",
                                           "uomLabels",
                                           localUomLabels.toString(), xmlWriter);
                                    }
                                    
                                            if (localStandardObjectProperties==null){
                                                 throw new org.apache.axis2.databinding.ADBException("StandardObjectProperties cannot be null!!");
                                            }
                                           localStandardObjectProperties.serialize(null,factory,xmlWriter);
                                        
                                            if (localAbstractRingTypeChoice_type1==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type1 cannot be null!!");
                                            }
                                           localAbstractRingTypeChoice_type1.serialize(null,factory,xmlWriter);
                                        
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
                    attribList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml","LinearRingType"));
                
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "StandardObjectProperties"));
                            
                            
                                    if (localStandardObjectProperties==null){
                                         throw new org.apache.axis2.databinding.ADBException("StandardObjectProperties cannot be null!!");
                                    }
                                    elementList.add(localStandardObjectProperties);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "AbstractRingTypeChoice_type1"));
                            
                            
                                    if (localAbstractRingTypeChoice_type1==null){
                                         throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type1 cannot be null!!");
                                    }
                                    elementList.add(localAbstractRingTypeChoice_type1);
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.opengis.net/gml","id"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localId));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","gid"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGid));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","srsName"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSrsName));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","srsDimension"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSrsDimension));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","axisLabels"));
                            
                                      attribList.add(localAxisLabels.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","uomLabels"));
                            
                                      attribList.add(localUomLabels.toString());
                                

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
        public static LinearRingType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            LinearRingType object =
                new LinearRingType();

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
                    
                            if (!"LinearRingType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (LinearRingType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    // handle attribute "id"
                    java.lang.String tempAttribId =
                        
                                reader.getAttributeValue("http://www.opengis.net/gml","id");
                            
                   if (tempAttribId!=null){
                         java.lang.String content = tempAttribId;
                        
                                                 object.setId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToID(tempAttribId));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("id");
                    
                    // handle attribute "gid"
                    java.lang.String tempAttribGid =
                        
                                reader.getAttributeValue(null,"gid");
                            
                   if (tempAttribGid!=null){
                         java.lang.String content = tempAttribGid;
                        
                                                 object.setGid(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribGid));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("gid");
                    
                    // handle attribute "srsName"
                    java.lang.String tempAttribSrsName =
                        
                                reader.getAttributeValue(null,"srsName");
                            
                   if (tempAttribSrsName!=null){
                         java.lang.String content = tempAttribSrsName;
                        
                                                 object.setSrsName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(tempAttribSrsName));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("srsName");
                    
                    // handle attribute "srsDimension"
                    java.lang.String tempAttribSrsDimension =
                        
                                reader.getAttributeValue(null,"srsDimension");
                            
                   if (tempAttribSrsDimension!=null){
                         java.lang.String content = tempAttribSrsDimension;
                        
                                                 object.setSrsDimension(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToPositiveInteger(tempAttribSrsDimension));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("srsDimension");
                    
                    // handle attribute "axisLabels"
                    java.lang.String tempAttribAxisLabels =
                        
                                reader.getAttributeValue(null,"axisLabels");
                            
                   if (tempAttribAxisLabels!=null){
                         java.lang.String content = tempAttribAxisLabels;
                        
                                                  object.setAxisLabels(
                                                        net.opengis.www.gml.NCNameList.Factory.fromString(reader,tempAttribAxisLabels));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("axisLabels");
                    
                    // handle attribute "uomLabels"
                    java.lang.String tempAttribUomLabels =
                        
                                reader.getAttributeValue(null,"uomLabels");
                            
                   if (tempAttribUomLabels!=null){
                         java.lang.String content = tempAttribUomLabels;
                        
                                                  object.setUomLabels(
                                                        net.opengis.www.gml.NCNameList.Factory.fromString(reader,tempAttribUomLabels));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("uomLabels");
                    
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() ){
                                
                                                object.setStandardObjectProperties(net.opengis.www.gml.StandardObjectProperties.Factory.parse(reader));
                                            
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() ){
                                
                                                object.setAbstractRingTypeChoice_type1(net.opengis.www.gml.AbstractRingTypeChoice_type1.Factory.parse(reader));
                                            
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
           
          