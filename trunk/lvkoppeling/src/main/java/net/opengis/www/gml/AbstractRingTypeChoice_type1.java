
/**
 * AbstractRingTypeChoice_type1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package net.opengis.www.gml;
            

            /**
            *  AbstractRingTypeChoice_type1 bean class
            */
        
        public  class AbstractRingTypeChoice_type1
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AbstractRingTypeChoice_type1
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
            
                   localAbstractRingTypeChoice_type0Tracker = false;
                
                   localPosListTracker = false;
                
                   localCoordinatesTracker = false;
                
                   localCoordTracker = false;
                
            }
        

                        /**
                        * field for AbstractRingTypeChoice_type0
                        * This was an Array!
                        */

                        
                                    protected net.opengis.www.gml.AbstractRingTypeChoice_type0[] localAbstractRingTypeChoice_type0 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAbstractRingTypeChoice_type0Tracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.AbstractRingTypeChoice_type0[]
                           */
                           public  net.opengis.www.gml.AbstractRingTypeChoice_type0[] getAbstractRingTypeChoice_type0(){
                               return localAbstractRingTypeChoice_type0;
                           }

                           
                        


                               
                              /**
                               * validate the array for AbstractRingTypeChoice_type0
                               */
                              protected void validateAbstractRingTypeChoice_type0(net.opengis.www.gml.AbstractRingTypeChoice_type0[] param){
                             
                              if ((param != null) && (param.length < 4)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param AbstractRingTypeChoice_type0
                              */
                              public void setAbstractRingTypeChoice_type0(net.opengis.www.gml.AbstractRingTypeChoice_type0[] param){
                              
                                   validateAbstractRingTypeChoice_type0(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localAbstractRingTypeChoice_type0Tracker = true;
                                          } else {
                                             localAbstractRingTypeChoice_type0Tracker = false;
                                                 
                                          }
                                      
                                      this.localAbstractRingTypeChoice_type0=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param net.opengis.www.gml.AbstractRingTypeChoice_type0
                             */
                             public void addAbstractRingTypeChoice_type0(net.opengis.www.gml.AbstractRingTypeChoice_type0 param){
                                   if (localAbstractRingTypeChoice_type0 == null){
                                   localAbstractRingTypeChoice_type0 = new net.opengis.www.gml.AbstractRingTypeChoice_type0[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localAbstractRingTypeChoice_type0Tracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localAbstractRingTypeChoice_type0);
                               list.add(param);
                               this.localAbstractRingTypeChoice_type0 =
                             (net.opengis.www.gml.AbstractRingTypeChoice_type0[])list.toArray(
                            new net.opengis.www.gml.AbstractRingTypeChoice_type0[list.size()]);

                             }
                             

                        /**
                        * field for PosList
                        */

                        
                                    protected net.opengis.www.gml.DirectPositionListType localPosList ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPosListTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return net.opengis.www.gml.DirectPositionListType
                           */
                           public  net.opengis.www.gml.DirectPositionListType getPosList(){
                               return localPosList;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PosList
                               */
                               public void setPosList(net.opengis.www.gml.DirectPositionListType param){
                            
                                clearAllSettingTrackers();
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPosListTracker = true;
                                       } else {
                                          localPosListTracker = false;
                                              
                                       }
                                   
                                            this.localPosList=param;
                                    

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
                             
                              if ((param != null) && (param.length < 4)){
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
                       AbstractRingTypeChoice_type1.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.opengis.net/gml");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":AbstractRingTypeChoice_type1",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AbstractRingTypeChoice_type1",
                           xmlWriter);
                   }

               
                   }
                if (localAbstractRingTypeChoice_type0Tracker){
                                     
                                      if (localAbstractRingTypeChoice_type0!=null){
                                            for (int i = 0;i < localAbstractRingTypeChoice_type0.length;i++){
                                                if (localAbstractRingTypeChoice_type0[i] != null){
                                                 localAbstractRingTypeChoice_type0[i].serialize(null,factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type0 cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type0 cannot be null!!");
                                     }
                                 } if (localPosListTracker){
                                            if (localPosList==null){
                                                 throw new org.apache.axis2.databinding.ADBException("posList cannot be null!!");
                                            }
                                           localPosList.serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","posList"),
                                               factory,xmlWriter);
                                        } if (localCoordinatesTracker){
                                            if (localCoordinates==null){
                                                 throw new org.apache.axis2.databinding.ADBException("coordinates cannot be null!!");
                                            }
                                           localCoordinates.serialize(new javax.xml.namespace.QName("http://www.opengis.net/gml","coordinates"),
                                               factory,xmlWriter);
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

                 if (localAbstractRingTypeChoice_type0Tracker){
                             if (localAbstractRingTypeChoice_type0!=null) {
                                 for (int i = 0;i < localAbstractRingTypeChoice_type0.length;i++){

                                    if (localAbstractRingTypeChoice_type0[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                          "AbstractRingTypeChoice_type0"));
                                         elementList.add(localAbstractRingTypeChoice_type0[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type0 cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("AbstractRingTypeChoice_type0 cannot be null!!");
                                    
                             }

                        } if (localPosListTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "posList"));
                            
                            
                                    if (localPosList==null){
                                         throw new org.apache.axis2.databinding.ADBException("posList cannot be null!!");
                                    }
                                    elementList.add(localPosList);
                                } if (localCoordinatesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.opengis.net/gml",
                                                                      "coordinates"));
                            
                            
                                    if (localCoordinates==null){
                                         throw new org.apache.axis2.databinding.ADBException("coordinates cannot be null!!");
                                    }
                                    elementList.add(localCoordinates);
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
        public static AbstractRingTypeChoice_type1 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AbstractRingTypeChoice_type1 object =
                new AbstractRingTypeChoice_type1();

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
                

                 
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                        
                                         try{
                                    
                                    if (reader.isStartElement() ){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list1.add(net.opengis.www.gml.AbstractRingTypeChoice_type0.Factory.parse(reader));
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){

                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                list1.add(net.opengis.www.gml.AbstractRingTypeChoice_type0.Factory.parse(reader));
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        object.setAbstractRingTypeChoice_type0((net.opengis.www.gml.AbstractRingTypeChoice_type0[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                net.opengis.www.gml.AbstractRingTypeChoice_type0.class,
                                                                list1));

                                                 
                              }  // End of if for expected property start element
                                
                                
                                 } catch (java.lang.Exception e) {}
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","posList").equals(reader.getName())){
                                
                                                object.setPosList(net.opengis.www.gml.DirectPositionListType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","coordinates").equals(reader.getName())){
                                
                                                object.setCoordinates(net.opengis.www.gml.CoordinatesType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.opengis.net/gml","coord").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list4.add(net.opengis.www.gml.CoordType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
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
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.opengis.net/gml","coord").equals(reader.getName())){
                                                                    list4.add(net.opengis.www.gml.CoordType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setCoord((net.opengis.www.gml.CoordType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                net.opengis.www.gml.CoordType.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          