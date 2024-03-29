
/**
 * SurfacePropertyType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  SurfacePropertyType bean class
            */
        
        public  class SurfacePropertyType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = SurfacePropertyType
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
                        * field for _Surface
                        */

                        
                                    protected net.opengis.www.gml.AbstractSurfaceType local_Surface ;
                                

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.AbstractSurfaceType
                           */
                           public  net.opengis.www.gml.AbstractSurfaceType get_Surface(){
                               return local_Surface;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param _Surface
                               */
                               public void set_Surface(net.opengis.www.gml.AbstractSurfaceType param){
                            
                                            this.local_Surface=param;
                                    

                               }
                            

                        /**
                        * field for Type
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localType ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){
                            
                                            this.localType=param;
                                    

                               }
                            

                        /**
                        * field for Href
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localHref ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.URI
                           */
                           public  org.apache.axis2.databinding.types.URI getHref(){
                               return localHref;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Href
                               */
                               public void setHref(org.apache.axis2.databinding.types.URI param){
                            
                                            this.localHref=param;
                                    

                               }
                            

                        /**
                        * field for Role
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localRole ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.URI
                           */
                           public  org.apache.axis2.databinding.types.URI getRole(){
                               return localRole;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Role
                               */
                               public void setRole(org.apache.axis2.databinding.types.URI param){
                            
                                            this.localRole=param;
                                    

                               }
                            

                        /**
                        * field for Arcrole
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localArcrole ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.URI
                           */
                           public  org.apache.axis2.databinding.types.URI getArcrole(){
                               return localArcrole;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Arcrole
                               */
                               public void setArcrole(org.apache.axis2.databinding.types.URI param){
                            
                                            this.localArcrole=param;
                                    

                               }
                            

                        /**
                        * field for Title
                        * This was an Attribute!
                        */

                        
                                    protected java.lang.String localTitle ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTitle(){
                               return localTitle;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Title
                               */
                               public void setTitle(java.lang.String param){
                            
                                            this.localTitle=param;
                                    

                               }
                            

                        /**
                        * field for Show
                        * This was an Attribute!
                        */

                        
                                    protected org.w3.www._1999.xlink.Show_type0 localShow ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.w3.www._1999.xlink.Show_type0
                           */
                           public  org.w3.www._1999.xlink.Show_type0 getShow(){
                               return localShow;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Show
                               */
                               public void setShow(org.w3.www._1999.xlink.Show_type0 param){
                            
                                            this.localShow=param;
                                    

                               }
                            

                        /**
                        * field for Actuate
                        * This was an Attribute!
                        */

                        
                                    protected org.w3.www._1999.xlink.Actuate_type0 localActuate ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.w3.www._1999.xlink.Actuate_type0
                           */
                           public  org.w3.www._1999.xlink.Actuate_type0 getActuate(){
                               return localActuate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Actuate
                               */
                               public void setActuate(org.w3.www._1999.xlink.Actuate_type0 param){
                            
                                            this.localActuate=param;
                                    

                               }
                            

                        /**
                        * field for RemoteSchema
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localRemoteSchema ;
                                

                           /**
                           * Auto generated getter method
                           * @return org.apache.axis2.databinding.types.URI
                           */
                           public  org.apache.axis2.databinding.types.URI getRemoteSchema(){
                               return localRemoteSchema;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RemoteSchema
                               */
                               public void setRemoteSchema(org.apache.axis2.databinding.types.URI param){
                            
                                            this.localRemoteSchema=param;
                                    

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
                       SurfacePropertyType.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":SurfacePropertyType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "SurfacePropertyType",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localType != null){
                                        
                                                writeAttribute("",
                                                         "type",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType), xmlWriter);

                                            
                                      }
                                    
                                            if (localHref != null){
                                        
                                                writeAttribute("http://www.w3.org/1999/xlink",
                                                         "href",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHref), xmlWriter);

                                            
                                      }
                                    
                                            if (localRole != null){
                                        
                                                writeAttribute("http://www.w3.org/1999/xlink",
                                                         "role",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRole), xmlWriter);

                                            
                                      }
                                    
                                            if (localArcrole != null){
                                        
                                                writeAttribute("http://www.w3.org/1999/xlink",
                                                         "arcrole",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localArcrole), xmlWriter);

                                            
                                      }
                                    
                                            if (localTitle != null){
                                        
                                                writeAttribute("http://www.w3.org/1999/xlink",
                                                         "title",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTitle), xmlWriter);

                                            
                                      }
                                    
                                    
                                    if (localShow != null){
                                        writeAttribute("http://www.w3.org/1999/xlink",
                                           "show",
                                           localShow.toString(), xmlWriter);
                                    }
                                    
                                    
                                    if (localActuate != null){
                                        writeAttribute("http://www.w3.org/1999/xlink",
                                           "actuate",
                                           localActuate.toString(), xmlWriter);
                                    }
                                    
                                            if (localRemoteSchema != null){
                                        
                                                writeAttribute("http://www.opengis.net/gml",
                                                         "remoteSchema",
                                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemoteSchema), xmlWriter);

                                            
                                      }
                                    
                                            if (local_Surface==null){
                                                 throw new org.apache.axis2.databinding.ADBException("_Surface cannot be null!!");
                                            }
                                           local_Surface.serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","_Surface"),
                                               factory,xmlWriter);
                                        
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

                
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "_Surface"));
                            
                            
                                    if (local_Surface==null){
                                         throw new org.apache.axis2.databinding.ADBException("_Surface cannot be null!!");
                                    }
                                    elementList.add(local_Surface);
                                
                            attribList.add(
                            new javax.xml.namespace.QName("","type"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","href"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHref));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","role"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRole));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","arcrole"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localArcrole));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","title"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTitle));
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","show"));
                            
                                      attribList.add(localShow.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.w3.org/1999/xlink","actuate"));
                            
                                      attribList.add(localActuate.toString());
                                
                            attribList.add(
                            new javax.xml.namespace.QName("http://www.opengis.net/gml","remoteSchema"));
                            
                                      attribList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemoteSchema));
                                

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
        public static SurfacePropertyType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            SurfacePropertyType object =
                new SurfacePropertyType();

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
                    
                            if (!"SurfacePropertyType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (SurfacePropertyType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    // handle attribute "type"
                    java.lang.String tempAttribType =
                        
                                reader.getAttributeValue(null,"type");
                            
                   if (tempAttribType!=null){
                         java.lang.String content = tempAttribType;
                        
                                                 object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribType));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("type");
                    
                    // handle attribute "href"
                    java.lang.String tempAttribHref =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","href");
                            
                   if (tempAttribHref!=null){
                         java.lang.String content = tempAttribHref;
                        
                                                 object.setHref(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(tempAttribHref));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("href");
                    
                    // handle attribute "role"
                    java.lang.String tempAttribRole =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","role");
                            
                   if (tempAttribRole!=null){
                         java.lang.String content = tempAttribRole;
                        
                                                 object.setRole(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(tempAttribRole));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("role");
                    
                    // handle attribute "arcrole"
                    java.lang.String tempAttribArcrole =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","arcrole");
                            
                   if (tempAttribArcrole!=null){
                         java.lang.String content = tempAttribArcrole;
                        
                                                 object.setArcrole(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(tempAttribArcrole));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("arcrole");
                    
                    // handle attribute "title"
                    java.lang.String tempAttribTitle =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","title");
                            
                   if (tempAttribTitle!=null){
                         java.lang.String content = tempAttribTitle;
                        
                                                 object.setTitle(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(tempAttribTitle));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("title");
                    
                    // handle attribute "show"
                    java.lang.String tempAttribShow =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","show");
                            
                   if (tempAttribShow!=null){
                         java.lang.String content = tempAttribShow;
                        
                                                  object.setShow(
                                                        org.w3.www._1999.xlink.Show_type0.Factory.fromString(reader,tempAttribShow));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("show");
                    
                    // handle attribute "actuate"
                    java.lang.String tempAttribActuate =
                        
                                reader.getAttributeValue("http://www.w3.org/1999/xlink","actuate");
                            
                   if (tempAttribActuate!=null){
                         java.lang.String content = tempAttribActuate;
                        
                                                  object.setActuate(
                                                        org.w3.www._1999.xlink.Actuate_type0.Factory.fromString(reader,tempAttribActuate));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("actuate");
                    
                    // handle attribute "remoteSchema"
                    java.lang.String tempAttribRemoteSchema =
                        
                                reader.getAttributeValue("http://www.opengis.net/gml","remoteSchema");
                            
                   if (tempAttribRemoteSchema!=null){
                         java.lang.String content = tempAttribRemoteSchema;
                        
                                                 object.setRemoteSchema(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToAnyURI(tempAttribRemoteSchema));
                                            
                    } else {
                       
                    }
                    handledAttributes.add("remoteSchema");
                    
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","_Surface").equals(reader.getName())){
                                
                                                object.set_Surface(net.opengis.www.gml.AbstractSurfaceType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
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
           
          