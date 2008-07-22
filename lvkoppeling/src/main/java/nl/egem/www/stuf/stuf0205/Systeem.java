
/**
 * Systeem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.egem.www.stuf.stuf0205;
            

            /**
            *  Systeem bean class
            */
        
        public  class Systeem
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Systeem
                Namespace URI = http://www.egem.nl/StUF/StUF0205
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.egem.nl/StUF/StUF0205")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Organisatie
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Organisatie_type1 localOrganisatie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOrganisatieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Organisatie_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Organisatie_type1 getOrganisatie(){
                               return localOrganisatie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Organisatie
                               */
                               public void setOrganisatie(nl.egem.www.stuf.stuf0205.Organisatie_type1 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localOrganisatieTracker = true;
                                       } else {
                                          localOrganisatieTracker = false;
                                              
                                       }
                                   
                                            this.localOrganisatie=param;
                                    

                               }
                            

                        /**
                        * field for Applicatie
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Applicatie_type1 localApplicatie ;
                                

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Applicatie_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Applicatie_type1 getApplicatie(){
                               return localApplicatie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Applicatie
                               */
                               public void setApplicatie(nl.egem.www.stuf.stuf0205.Applicatie_type1 param){
                            
                                            this.localApplicatie=param;
                                    

                               }
                            

                        /**
                        * field for Administratie
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Administratie_type1 localAdministratie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAdministratieTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Administratie_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Administratie_type1 getAdministratie(){
                               return localAdministratie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Administratie
                               */
                               public void setAdministratie(nl.egem.www.stuf.stuf0205.Administratie_type1 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAdministratieTracker = true;
                                       } else {
                                          localAdministratieTracker = false;
                                              
                                       }
                                   
                                            this.localAdministratie=param;
                                    

                               }
                            

                        /**
                        * field for Gebruiker
                        */

                        
                                    protected nl.egem.www.stuf.stuf0205.Gebruiker_type1 localGebruiker ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGebruikerTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.egem.www.stuf.stuf0205.Gebruiker_type1
                           */
                           public  nl.egem.www.stuf.stuf0205.Gebruiker_type1 getGebruiker(){
                               return localGebruiker;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Gebruiker
                               */
                               public void setGebruiker(nl.egem.www.stuf.stuf0205.Gebruiker_type1 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localGebruikerTracker = true;
                                       } else {
                                          localGebruikerTracker = false;
                                              
                                       }
                                   
                                            this.localGebruiker=param;
                                    

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
                       Systeem.this.serialize(parentQName,factory,xmlWriter);
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
                           namespacePrefix+":Systeem",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Systeem",
                           xmlWriter);
                   }

               
                   }
                if (localOrganisatieTracker){
                                            if (localOrganisatie==null){
                                                 throw new org.apache.axis2.databinding.ADBException("organisatie cannot be null!!");
                                            }
                                           localOrganisatie.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","organisatie"),
                                               factory,xmlWriter);
                                        }
                                            if (localApplicatie==null){
                                                 throw new org.apache.axis2.databinding.ADBException("applicatie cannot be null!!");
                                            }
                                           localApplicatie.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","applicatie"),
                                               factory,xmlWriter);
                                         if (localAdministratieTracker){
                                            if (localAdministratie==null){
                                                 throw new org.apache.axis2.databinding.ADBException("administratie cannot be null!!");
                                            }
                                           localAdministratie.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","administratie"),
                                               factory,xmlWriter);
                                        } if (localGebruikerTracker){
                                            if (localGebruiker==null){
                                                 throw new org.apache.axis2.databinding.ADBException("gebruiker cannot be null!!");
                                            }
                                           localGebruiker.serialize(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","gebruiker"),
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

                 if (localOrganisatieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "organisatie"));
                            
                            
                                    if (localOrganisatie==null){
                                         throw new org.apache.axis2.databinding.ADBException("organisatie cannot be null!!");
                                    }
                                    elementList.add(localOrganisatie);
                                }
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "applicatie"));
                            
                            
                                    if (localApplicatie==null){
                                         throw new org.apache.axis2.databinding.ADBException("applicatie cannot be null!!");
                                    }
                                    elementList.add(localApplicatie);
                                 if (localAdministratieTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "administratie"));
                            
                            
                                    if (localAdministratie==null){
                                         throw new org.apache.axis2.databinding.ADBException("administratie cannot be null!!");
                                    }
                                    elementList.add(localAdministratie);
                                } if (localGebruikerTracker){
                            elementList.add(new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205",
                                                                      "gebruiker"));
                            
                            
                                    if (localGebruiker==null){
                                         throw new org.apache.axis2.databinding.ADBException("gebruiker cannot be null!!");
                                    }
                                    elementList.add(localGebruiker);
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
        public static Systeem parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Systeem object =
                new Systeem();

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
                    
                            if (!"Systeem".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Systeem)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","organisatie").equals(reader.getName())){
                                
                                                object.setOrganisatie(nl.egem.www.stuf.stuf0205.Organisatie_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","applicatie").equals(reader.getName())){
                                
                                                object.setApplicatie(nl.egem.www.stuf.stuf0205.Applicatie_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","administratie").equals(reader.getName())){
                                
                                                object.setAdministratie(nl.egem.www.stuf.stuf0205.Administratie_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.egem.nl/StUF/StUF0205","gebruiker").equals(reader.getName())){
                                
                                                object.setGebruiker(nl.egem.www.stuf.stuf0205.Gebruiker_type1.Factory.parse(reader));
                                              
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
           
          