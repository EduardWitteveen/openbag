
/**
 * EnvelopeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  EnvelopeType bean class
            */
        
        public  class EnvelopeType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = EnvelopeType
                Namespace URI = http://www.opengis.net/gml
                Namespace Prefix = ns3
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.opengis.net/gml")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        
            /** Whenever a new property is set ensure all others are unset
             *  There can be only one choice and the last one wins
             */
            private void clearAllSettingTrackers() {
            
                   localEnvelopeTypeSequence_type0Tracker = false;
                
                   localCoordTracker = false;
                
                   localPosTracker = false;
                
                   localCoordinatesTracker = false;
                
            }
        

                        /**
                        * field for EnvelopeTypeSequence_type0
                        */

                        
                                    protected net.opengis.www.gml.EnvelopeTypeSequence_type0 localEnvelopeTypeSequence_type0 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEnvelopeTypeSequence_type0Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.EnvelopeTypeSequence_type0
                           */
                           public  net.opengis.www.gml.EnvelopeTypeSequence_type0 getEnvelopeTypeSequence_type0(){
                               return localEnvelopeTypeSequence_type0;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EnvelopeTypeSequence_type0
                               */
                               public void setEnvelopeTypeSequence_type0(net.opengis.www.gml.EnvelopeTypeSequence_type0 param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localEnvelopeTypeSequence_type0Tracker = true;
                                       } else {
                                          localEnvelopeTypeSequence_type0Tracker = false;
                                              
                                       }
                                   
                                            this.localEnvelopeTypeSequence_type0=param;
                                    

                               }
                            

                        /**
                        * field for Coord
                        * This was an Array!
                        */

                        
                                    protected net.opengis.www.gml.CoordType[] localCoord ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCoordTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.CoordType[]
                           */
                           public  net.opengis.www.gml.CoordType[] getCoord(){
                               return localCoord;
                           }

                           
                        


                               
                              /**
                               * validate the array for Coord
                               */
                              protected void validateCoord(net.opengis.www.gml.CoordType[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Coord
                              */
                              public void setCoord(net.opengis.www.gml.CoordType[] param){
                              
                                   validateCoord(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localCoordTracker = true;
                                          } else {
                                             localCoordTracker = false;
                                                 
                                          }
                                      
                                      this.localCoord=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param net.opengis.www.gml.CoordType
                             */
                             public void addCoord(net.opengis.www.gml.CoordType param){
                                   if (localCoord == null){
                                   localCoord = new net.opengis.www.gml.CoordType[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localCoordTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localCoord);
                               list.add(param);
                               this.localCoord =
                             (net.opengis.www.gml.CoordType[])list.toArray(
                            new net.opengis.www.gml.CoordType[list.size()]);

                             }
                             

                        /**
                        * field for Pos
                        * This was an Array!
                        */

                        
                                    protected net.opengis.www.gml.DirectPositionType[] localPos ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPosTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.DirectPositionType[]
                           */
                           public  net.opengis.www.gml.DirectPositionType[] getPos(){
                               return localPos;
                           }

                           
                        


                               
                              /**
                               * validate the array for Pos
                               */
                              protected void validatePos(net.opengis.www.gml.DirectPositionType[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Pos
                              */
                              public void setPos(net.opengis.www.gml.DirectPositionType[] param){
                              
                                   validatePos(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localPosTracker = true;
                                          } else {
                                             localPosTracker = false;
                                                 
                                          }
                                      
                                      this.localPos=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param net.opengis.www.gml.DirectPositionType
                             */
                             public void addPos(net.opengis.www.gml.DirectPositionType param){
                                   if (localPos == null){
                                   localPos = new net.opengis.www.gml.DirectPositionType[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localPosTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPos);
                               list.add(param);
                               this.localPos =
                             (net.opengis.www.gml.DirectPositionType[])list.toArray(
                            new net.opengis.www.gml.DirectPositionType[list.size()]);

                             }
                             

                        /**
                        * field for Coordinates
                        */

                        
                                    protected net.opengis.www.gml.CoordinatesType localCoordinates ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCoordinatesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.CoordinatesType
                           */
                           public  net.opengis.www.gml.CoordinatesType getCoordinates(){
                               return localCoordinates;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Coordinates
                               */
                               public void setCoordinates(net.opengis.www.gml.CoordinatesType param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localCoordinatesTracker = true;
                                       } else {
                                          localCoordinatesTracker = false;
                                              
                                       }
                                   
                                            this.localCoordinates=param;
                                    

                               }
                            

                        /**
                        * field for SrsName
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.URI localSrsName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSrsNameTracker = false ;
                           

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
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSrsNameTracker = true;
                                       } else {
                                          localSrsNameTracker = false;
                                              
                                       }
                                   
                                            this.localSrsName=param;
                                    

                               }
                            

                        /**
                        * field for SrsDimension
                        * This was an Attribute!
                        */

                        
                                    protected org.apache.axis2.databinding.types.PositiveInteger localSrsDimension ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSrsDimensionTracker = false ;
                           

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
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localSrsDimensionTracker = true;
                                       } else {
                                          localSrsDimensionTracker = false;
                                              
                                       }
                                   
                                            this.localSrsDimension=param;
                                    

                               }
                            

                        /**
                        * field for AxisLabels
                        * This was an Attribute!
                        */

                        
                                    protected net.opengis.www.gml.NCNameList localAxisLabels ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAxisLabelsTracker = false ;
                           

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
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAxisLabelsTracker = true;
                                       } else {
                                          localAxisLabelsTracker = false;
                                              
                                       }
                                   
                                            this.localAxisLabels=param;
                                    

                               }
                            

                        /**
                        * field for UomLabels
                        * This was an Attribute!
                        */

                        
                                    protected net.opengis.www.gml.NCNameList localUomLabels ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUomLabelsTracker = false ;
                           

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
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localUomLabelsTracker = true;
                                       } else {
                                          localUomLabelsTracker = false;
                                              
                                       }
                                   
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
                       EnvelopeType.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":EnvelopeType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "EnvelopeType",
                           xmlWriter);
                   }

               
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
                                     if (localEnvelopeTypeSequence_type0Tracker){
                                            if (localEnvelopeTypeSequence_type0==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EnvelopeTypeSequence_type0 cannot be null!!");
                                            }
                                           localEnvelopeTypeSequence_type0.serialize(null,factory,xmlWriter);
                                        } if (localCoordTracker){
                                       if (localCoord!=null){
                                            for (int i = 0;i < localCoord.length;i++){
                                                if (localCoord[i] != null){
                                                 localCoord[i].serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","coord"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("coord cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("coord cannot be null!!");
                                        
                                    }
                                 } if (localPosTracker){
                                       if (localPos!=null){
                                            for (int i = 0;i < localPos.length;i++){
                                                if (localPos[i] != null){
                                                 localPos[i].serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","pos"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("pos cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("pos cannot be null!!");
                                        
                                    }
                                 } if (localCoordinatesTracker){
                                            if (localCoordinates==null){
                                                 throw new org.apache.axis2.databinding.ADBException("coordinates cannot be null!!");
                                            }
                                           localCoordinates.serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","coordinates"),
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

                 if (localEnvelopeTypeSequence_type0Tracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "EnvelopeTypeSequence_type0"));
                            
                            
                                    if (localEnvelopeTypeSequence_type0==null){
                                         throw new org.apache.axis2.databinding.ADBException("EnvelopeTypeSequence_type0 cannot be null!!");
                                    }
                                    elementList.add(localEnvelopeTypeSequence_type0);
                                } if (localCoordTracker){
                             if (localCoord!=null) {
                                 for (int i = 0;i < localCoord.length;i++){

                                    if (localCoord[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                          "coord"));
                                         elementList.add(localCoord[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("coord cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("coord cannot be null!!");
                                    
                             }

                        } if (localPosTracker){
                             if (localPos!=null) {
                                 for (int i = 0;i < localPos.length;i++){

                                    if (localPos[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                          "pos"));
                                         elementList.add(localPos[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("pos cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("pos cannot be null!!");
                                    
                             }

                        } if (localCoordinatesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "coordinates"));
                            
                            
                                    if (localCoordinates==null){
                                         throw new org.apache.axis2.databinding.ADBException("coordinates cannot be null!!");
                                    }
                                    elementList.add(localCoordinates);
                                }
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
        public static EnvelopeType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            EnvelopeType object =
                new EnvelopeType();

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
                    
                            if (!"EnvelopeType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (EnvelopeType)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
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
                
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                        java.util.ArrayList list3 = new java.util.ArrayList();
                       
                while(!reader.isEndElement()) {
                    if (reader.isStartElement() ){
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                        
                                         try{
                                    
                                    if (reader.isStartElement() ){
                                
                                                object.setEnvelopeTypeSequence_type0(net.opengis.www.gml.EnvelopeTypeSequence_type0.Factory.parse(reader));
                                            
                              }  // End of if for expected property start element
                                
                                
                                 } catch (java.lang.Exception e) {}
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","coord").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list2.add(net.opengis.www.gml.CoordType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone2 = false;
                                                        while(!loopDone2){
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
                                                                loopDone2 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.opengis.net/gml","coord").equals(reader.getName())){
                                                                    list2.add(net.opengis.www.gml.CoordType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setCoord((net.opengis.www.gml.CoordType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                net.opengis.www.gml.CoordType.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","pos").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list3.add(net.opengis.www.gml.DirectPositionType.Factory.parse(reader));
                                                                
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
                                                                if (new javax.xml.namespace.QName("http://www.opengis.net/gml","pos").equals(reader.getName())){
                                                                    list3.add(net.opengis.www.gml.DirectPositionType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setPos((net.opengis.www.gml.DirectPositionType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                net.opengis.www.gml.DirectPositionType.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","coordinates").equals(reader.getName())){
                                
                                                object.setCoordinates(net.opengis.www.gml.CoordinatesType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
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
           
          