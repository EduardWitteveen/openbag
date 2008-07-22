
/**
 * AbstractGeometryType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  AbstractGeometryType bean class
            */
        
        public abstract class AbstractGeometryType extends net.opengis.www.gml.AbstractGMLType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AbstractGeometryType
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
                        * field for Gid
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localGid ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGid(){
                               return localGid;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gid
                               */
                               public void setGid(java.lang.String param){
                            
                                            this.localGid=param;
                                    

                               }
                            

                        /**
                        * field for SrsName
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localSrsName ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.URI
                           */
                           public  org.apache.axis2.databinding.types.URI getSrsName(){
                               return localSrsName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SrsName
                               */
                               public void setSrsName(org.apache.axis2.databinding.types.URI param){
                            
                                            this.localSrsName=param;
                                    

                               }
                            

                        /**
                        * field for SrsDimension
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.PositiveInteger localSrsDimension ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.PositiveInteger
                           */
                           public  org.apache.axis2.databinding.types.PositiveInteger getSrsDimension(){
                               return localSrsDimension;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SrsDimension
                               */
                               public void setSrsDimension(org.apache.axis2.databinding.types.PositiveInteger param){
                            
                                            this.localSrsDimension=param;
                                    

                               }
                            

                        /**
                        * field for AxisLabels
                        * This was an Attribute!
                        */

                        
                                    protected net.opengis.www.gml.NCNameList localAxisLabels ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.NCNameList
                           */
                           public  net.opengis.www.gml.NCNameList getAxisLabels(){
                               return localAxisLabels;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AxisLabels
                               */
                               public void setAxisLabels(net.opengis.www.gml.NCNameList param){
                            
                                            this.localAxisLabels=param;
                                    

                               }
                            

                        /**
                        * field for UomLabels
                        * This was an Attribute!
                        */

                        
                                    protected net.opengis.www.gml.NCNameList localUomLabels ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.NCNameList
                           */
                           public  net.opengis.www.gml.NCNameList getUomLabels(){
                               return localUomLabels;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param UomLabels
                               */
                               public void setUomLabels(net.opengis.www.gml.NCNameList param){
                            
                                            this.localUomLabels=param;
                                    

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
                       AbstractGeometryType.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":AbstractGeometryType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AbstractGeometryType",
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
                    attribList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml","AbstractGeometryType"));
                
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "StandardObjectProperties"));
                            
                            
                                    if (localStandardObjectProperties==null){
                                         throw new org.apache.axis2.databinding.ADBException("StandardObjectProperties cannot be null!!");
                                    }
                                    elementList.add(localStandardObjectProperties);
                                
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
        public static AbstractGeometryType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AbstractGeometryType object =
                null;

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
                    
                            if (!"AbstractGeometryType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AbstractGeometryType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        
                        throw new org.apache.axis2.databinding.ADBException("The an abstract class can not be instantiated !!!");
                    

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
                   
                while(!reader.isEndElement()) {
                    if (reader.isStartElement() ){
                
                                    if (reader.isStartElement() ){
                                
                                                object.setStandardObjectProperties(net.opengis.www.gml.StandardObjectProperties.Factory.parse(reader));
                                            
                              }  // End of if for expected property start element
                                
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
           
          