
/**
 * PolygonType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  PolygonType bean class
            */
        
        public  class PolygonType extends net.opengis.www.gml.AbstractSurfaceType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = PolygonType
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
                        * field for Exterior
                        */

                        
                                    protected net.opengis.www.gml.AbstractRingPropertyType localExterior ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExteriorTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.AbstractRingPropertyType
                           */
                           public  net.opengis.www.gml.AbstractRingPropertyType getExterior(){
                               return localExterior;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Exterior
                               */
                               public void setExterior(net.opengis.www.gml.AbstractRingPropertyType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localExteriorTracker = true;
                                       } else {
                                          localExteriorTracker = false;
                                              
                                       }
                                   
                                            this.localExterior=param;
                                    

                               }
                            

                        /**
                        * field for Interior
                        * This was an Array!
                        */

                        
                                    protected net.opengis.www.gml.AbstractRingPropertyType[] localInterior ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localInteriorTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.AbstractRingPropertyType[]
                           */
                           public  net.opengis.www.gml.AbstractRingPropertyType[] getInterior(){
                               return localInterior;
                           }

                           
                        


                               
                              /**
                               * validate the array for Interior
                               */
                              protected void validateInterior(net.opengis.www.gml.AbstractRingPropertyType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Interior
                              */
                              public void setInterior(net.opengis.www.gml.AbstractRingPropertyType[] param){
                              
                                   validateInterior(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localInteriorTracker = true;
                                          } else {
                                             localInteriorTracker = false;
                                                 
                                          }
                                      
                                      this.localInterior=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param net.opengis.www.gml.AbstractRingPropertyType
                             */
                             public void addInterior(net.opengis.www.gml.AbstractRingPropertyType param){
                                   if (localInterior == null){
                                   localInterior = new net.opengis.www.gml.AbstractRingPropertyType[]{};
                                   }

                            
                                 //update the setting tracker
                                localInteriorTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localInterior);
                               list.add(param);
                               this.localInterior =
                             (net.opengis.www.gml.AbstractRingPropertyType[])list.toArray(
                            new net.opengis.www.gml.AbstractRingPropertyType[list.size()]);

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
                       PolygonType.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":PolygonType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "PolygonType",
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
                                         if (localExteriorTracker){
                                            if (localExterior==null){
                                                 throw new org.apache.axis2.databinding.ADBException("exterior cannot be null!!");
                                            }
                                           localExterior.serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","exterior"),
                                               factory,xmlWriter);
                                        } if (localInteriorTracker){
                                       if (localInterior!=null){
                                            for (int i = 0;i < localInterior.length;i++){
                                                if (localInterior[i] != null){
                                                 localInterior[i].serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","interior"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("interior cannot be null!!");
                                        
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
                    attribList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml","PolygonType"));
                
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "StandardObjectProperties"));
                            
                            
                                    if (localStandardObjectProperties==null){
                                         throw new org.apache.axis2.databinding.ADBException("StandardObjectProperties cannot be null!!");
                                    }
                                    elementList.add(localStandardObjectProperties);
                                 if (localExteriorTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "exterior"));
                            
                            
                                    if (localExterior==null){
                                         throw new org.apache.axis2.databinding.ADBException("exterior cannot be null!!");
                                    }
                                    elementList.add(localExterior);
                                } if (localInteriorTracker){
                             if (localInterior!=null) {
                                 for (int i = 0;i < localInterior.length;i++){

                                    if (localInterior[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                          "interior"));
                                         elementList.add(localInterior[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("interior cannot be null!!");
                                    
                             }

                        }
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
        public static PolygonType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            PolygonType object =
                new PolygonType();

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
                    
                            if (!"PolygonType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (PolygonType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
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
                
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() ){
                                
                                                object.setStandardObjectProperties(net.opengis.www.gml.StandardObjectProperties.Factory.parse(reader));
                                            
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","exterior").equals(reader.getName())){
                                
                                                object.setExterior(net.opengis.www.gml.AbstractRingPropertyType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","interior").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list3.add(net.opengis.www.gml.AbstractRingPropertyType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone3 = false;
                                                        while(!loopDone3){
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
                                                                loopDone3 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.opengis.net/gml","interior").equals(reader.getName())){
                                                                    list3.add(net.opengis.www.gml.AbstractRingPropertyType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setInterior((net.opengis.www.gml.AbstractRingPropertyType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                net.opengis.www.gml.AbstractRingPropertyType.class,
                                                                list3));
                                                            
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
           
          