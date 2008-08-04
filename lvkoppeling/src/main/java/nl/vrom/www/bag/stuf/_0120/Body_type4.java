
/**
 * Body_type4.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package nl.vrom.www.bag.stuf._0120;
            

            /**
            *  Body_type4 bean class
            */
        
        public  class Body_type4
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = body_type4
                Namespace URI = http://www.vrom.nl/bag/stuf/0120
                Namespace Prefix = ns5
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.vrom.nl/bag/stuf/0120")){
                return "ns5";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        
            /** Whenever a new property is set ensure all others are unset
             *  There can be only one choice and the last one wins
             */
            private void clearAllSettingTrackers() {
            
                   localPandTracker = false;
                
                   localVerblijfsObjectTracker = false;
                
                   localLigplaatsTracker = false;
                
                   localStandplaatsTracker = false;
                
                   localNummerAanduidingTracker = false;
                
                   localOpenbareRuimteTracker = false;
                
                   localWoonplaatsTracker = false;
                
            }
        

                        /**
                        * field for Pand
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Pand_type2[] localPand ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPandTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Pand_type2[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.Pand_type2[] getPand(){
                               return localPand;
                           }

                           
                        


                               
                              /**
                               * validate the array for Pand
                               */
                              protected void validatePand(nl.vrom.www.bag.stuf._0120.Pand_type2[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Pand
                              */
                              public void setPand(nl.vrom.www.bag.stuf._0120.Pand_type2[] param){
                              
                                   validatePand(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localPandTracker = true;
                                          } else {
                                             localPandTracker = false;
                                                 
                                          }
                                      
                                      this.localPand=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.Pand_type2
                             */
                             public void addPand(nl.vrom.www.bag.stuf._0120.Pand_type2 param){
                                   if (localPand == null){
                                   localPand = new nl.vrom.www.bag.stuf._0120.Pand_type2[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localPandTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPand);
                               list.add(param);
                               this.localPand =
                             (nl.vrom.www.bag.stuf._0120.Pand_type2[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.Pand_type2[list.size()]);

                             }
                             

                        /**
                        * field for VerblijfsObject
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[] localVerblijfsObject ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVerblijfsObjectTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[] getVerblijfsObject(){
                               return localVerblijfsObject;
                           }

                           
                        


                               
                              /**
                               * validate the array for VerblijfsObject
                               */
                              protected void validateVerblijfsObject(nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param VerblijfsObject
                              */
                              public void setVerblijfsObject(nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[] param){
                              
                                   validateVerblijfsObject(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localVerblijfsObjectTracker = true;
                                          } else {
                                             localVerblijfsObjectTracker = false;
                                                 
                                          }
                                      
                                      this.localVerblijfsObject=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4
                             */
                             public void addVerblijfsObject(nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4 param){
                                   if (localVerblijfsObject == null){
                                   localVerblijfsObject = new nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localVerblijfsObjectTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localVerblijfsObject);
                               list.add(param);
                               this.localVerblijfsObject =
                             (nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[list.size()]);

                             }
                             

                        /**
                        * field for Ligplaats
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Ligplaats_type2[] localLigplaats ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLigplaatsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Ligplaats_type2[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.Ligplaats_type2[] getLigplaats(){
                               return localLigplaats;
                           }

                           
                        


                               
                              /**
                               * validate the array for Ligplaats
                               */
                              protected void validateLigplaats(nl.vrom.www.bag.stuf._0120.Ligplaats_type2[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Ligplaats
                              */
                              public void setLigplaats(nl.vrom.www.bag.stuf._0120.Ligplaats_type2[] param){
                              
                                   validateLigplaats(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localLigplaatsTracker = true;
                                          } else {
                                             localLigplaatsTracker = false;
                                                 
                                          }
                                      
                                      this.localLigplaats=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.Ligplaats_type2
                             */
                             public void addLigplaats(nl.vrom.www.bag.stuf._0120.Ligplaats_type2 param){
                                   if (localLigplaats == null){
                                   localLigplaats = new nl.vrom.www.bag.stuf._0120.Ligplaats_type2[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localLigplaatsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localLigplaats);
                               list.add(param);
                               this.localLigplaats =
                             (nl.vrom.www.bag.stuf._0120.Ligplaats_type2[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.Ligplaats_type2[list.size()]);

                             }
                             

                        /**
                        * field for Standplaats
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Standplaats_type2[] localStandplaats ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStandplaatsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Standplaats_type2[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.Standplaats_type2[] getStandplaats(){
                               return localStandplaats;
                           }

                           
                        


                               
                              /**
                               * validate the array for Standplaats
                               */
                              protected void validateStandplaats(nl.vrom.www.bag.stuf._0120.Standplaats_type2[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Standplaats
                              */
                              public void setStandplaats(nl.vrom.www.bag.stuf._0120.Standplaats_type2[] param){
                              
                                   validateStandplaats(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localStandplaatsTracker = true;
                                          } else {
                                             localStandplaatsTracker = false;
                                                 
                                          }
                                      
                                      this.localStandplaats=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.Standplaats_type2
                             */
                             public void addStandplaats(nl.vrom.www.bag.stuf._0120.Standplaats_type2 param){
                                   if (localStandplaats == null){
                                   localStandplaats = new nl.vrom.www.bag.stuf._0120.Standplaats_type2[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localStandplaatsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localStandplaats);
                               list.add(param);
                               this.localStandplaats =
                             (nl.vrom.www.bag.stuf._0120.Standplaats_type2[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.Standplaats_type2[list.size()]);

                             }
                             

                        /**
                        * field for NummerAanduiding
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[] localNummerAanduiding ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNummerAanduidingTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[] getNummerAanduiding(){
                               return localNummerAanduiding;
                           }

                           
                        


                               
                              /**
                               * validate the array for NummerAanduiding
                               */
                              protected void validateNummerAanduiding(nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param NummerAanduiding
                              */
                              public void setNummerAanduiding(nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[] param){
                              
                                   validateNummerAanduiding(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localNummerAanduidingTracker = true;
                                          } else {
                                             localNummerAanduidingTracker = false;
                                                 
                                          }
                                      
                                      this.localNummerAanduiding=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8
                             */
                             public void addNummerAanduiding(nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8 param){
                                   if (localNummerAanduiding == null){
                                   localNummerAanduiding = new nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localNummerAanduidingTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localNummerAanduiding);
                               list.add(param);
                               this.localNummerAanduiding =
                             (nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[list.size()]);

                             }
                             

                        /**
                        * field for OpenbareRuimte
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[] localOpenbareRuimte ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOpenbareRuimteTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[] getOpenbareRuimte(){
                               return localOpenbareRuimte;
                           }

                           
                        


                               
                              /**
                               * validate the array for OpenbareRuimte
                               */
                              protected void validateOpenbareRuimte(nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param OpenbareRuimte
                              */
                              public void setOpenbareRuimte(nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[] param){
                              
                                   validateOpenbareRuimte(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localOpenbareRuimteTracker = true;
                                          } else {
                                             localOpenbareRuimteTracker = false;
                                                 
                                          }
                                      
                                      this.localOpenbareRuimte=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5
                             */
                             public void addOpenbareRuimte(nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5 param){
                                   if (localOpenbareRuimte == null){
                                   localOpenbareRuimte = new nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localOpenbareRuimteTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localOpenbareRuimte);
                               list.add(param);
                               this.localOpenbareRuimte =
                             (nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[list.size()]);

                             }
                             

                        /**
                        * field for Woonplaats
                        * This was an Array!
                        */

                        
                                    protected nl.vrom.www.bag.stuf._0120.Woonplaats[] localWoonplaats ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWoonplaatsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return nl.vrom.www.bag.stuf._0120.Woonplaats[]
                           */
                           public  nl.vrom.www.bag.stuf._0120.Woonplaats[] getWoonplaats(){
                               return localWoonplaats;
                           }

                           
                        


                               
                              /**
                               * validate the array for Woonplaats
                               */
                              protected void validateWoonplaats(nl.vrom.www.bag.stuf._0120.Woonplaats[] param){
                             
                              if ((param != null) && (param.length > 2)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              if ((param != null) && (param.length < 1)){
                                throw new java.lang.RuntimeException();
                              }
                              
                              }


                             /**
                              * Auto generated setter method
                              * @param param Woonplaats
                              */
                              public void setWoonplaats(nl.vrom.www.bag.stuf._0120.Woonplaats[] param){
                              
                                   validateWoonplaats(param);

                               
                                   clearAllSettingTrackers();
                               
                                          if (param != null){
                                             //update the setting tracker
                                             localWoonplaatsTracker = true;
                                          } else {
                                             localWoonplaatsTracker = false;
                                                 
                                          }
                                      
                                      this.localWoonplaats=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param nl.vrom.www.bag.stuf._0120.Woonplaats
                             */
                             public void addWoonplaats(nl.vrom.www.bag.stuf._0120.Woonplaats param){
                                   if (localWoonplaats == null){
                                   localWoonplaats = new nl.vrom.www.bag.stuf._0120.Woonplaats[]{};
                                   }

                            
                                   clearAllSettingTrackers();
                            
                                 //update the setting tracker
                                localWoonplaatsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localWoonplaats);
                               list.add(param);
                               this.localWoonplaats =
                             (nl.vrom.www.bag.stuf._0120.Woonplaats[])list.toArray(
                            new nl.vrom.www.bag.stuf._0120.Woonplaats[list.size()]);

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
                       Body_type4.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.vrom.nl/bag/stuf/0120");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":body_type4",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "body_type4",
                           xmlWriter);
                   }

               
                   }
                if (localPandTracker){
                                       if (localPand!=null){
                                            for (int i = 0;i < localPand.length;i++){
                                                if (localPand[i] != null){
                                                 localPand[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pand"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("pand cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("pand cannot be null!!");
                                        
                                    }
                                 } if (localVerblijfsObjectTracker){
                                       if (localVerblijfsObject!=null){
                                            for (int i = 0;i < localVerblijfsObject.length;i++){
                                                if (localVerblijfsObject[i] != null){
                                                 localVerblijfsObject[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObject"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("verblijfsObject cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("verblijfsObject cannot be null!!");
                                        
                                    }
                                 } if (localLigplaatsTracker){
                                       if (localLigplaats!=null){
                                            for (int i = 0;i < localLigplaats.length;i++){
                                                if (localLigplaats[i] != null){
                                                 localLigplaats[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","ligplaats"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("ligplaats cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("ligplaats cannot be null!!");
                                        
                                    }
                                 } if (localStandplaatsTracker){
                                       if (localStandplaats!=null){
                                            for (int i = 0;i < localStandplaats.length;i++){
                                                if (localStandplaats[i] != null){
                                                 localStandplaats[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","standplaats"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("standplaats cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("standplaats cannot be null!!");
                                        
                                    }
                                 } if (localNummerAanduidingTracker){
                                       if (localNummerAanduiding!=null){
                                            for (int i = 0;i < localNummerAanduiding.length;i++){
                                                if (localNummerAanduiding[i] != null){
                                                 localNummerAanduiding[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","nummerAanduiding"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("nummerAanduiding cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("nummerAanduiding cannot be null!!");
                                        
                                    }
                                 } if (localOpenbareRuimteTracker){
                                       if (localOpenbareRuimte!=null){
                                            for (int i = 0;i < localOpenbareRuimte.length;i++){
                                                if (localOpenbareRuimte[i] != null){
                                                 localOpenbareRuimte[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimte"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("openbareRuimte cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("openbareRuimte cannot be null!!");
                                        
                                    }
                                 } if (localWoonplaatsTracker){
                                       if (localWoonplaats!=null){
                                            for (int i = 0;i < localWoonplaats.length;i++){
                                                if (localWoonplaats[i] != null){
                                                 localWoonplaats[i].serialize(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","woonplaats"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                           throw new org.apache.axis2.databinding.ADBException("woonplaats cannot be null!!");
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("woonplaats cannot be null!!");
                                        
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

                 if (localPandTracker){
                             if (localPand!=null) {
                                 for (int i = 0;i < localPand.length;i++){

                                    if (localPand[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "pand"));
                                         elementList.add(localPand[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("pand cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("pand cannot be null!!");
                                    
                             }

                        } if (localVerblijfsObjectTracker){
                             if (localVerblijfsObject!=null) {
                                 for (int i = 0;i < localVerblijfsObject.length;i++){

                                    if (localVerblijfsObject[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "verblijfsObject"));
                                         elementList.add(localVerblijfsObject[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("verblijfsObject cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("verblijfsObject cannot be null!!");
                                    
                             }

                        } if (localLigplaatsTracker){
                             if (localLigplaats!=null) {
                                 for (int i = 0;i < localLigplaats.length;i++){

                                    if (localLigplaats[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "ligplaats"));
                                         elementList.add(localLigplaats[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("ligplaats cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("ligplaats cannot be null!!");
                                    
                             }

                        } if (localStandplaatsTracker){
                             if (localStandplaats!=null) {
                                 for (int i = 0;i < localStandplaats.length;i++){

                                    if (localStandplaats[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "standplaats"));
                                         elementList.add(localStandplaats[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("standplaats cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("standplaats cannot be null!!");
                                    
                             }

                        } if (localNummerAanduidingTracker){
                             if (localNummerAanduiding!=null) {
                                 for (int i = 0;i < localNummerAanduiding.length;i++){

                                    if (localNummerAanduiding[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "nummerAanduiding"));
                                         elementList.add(localNummerAanduiding[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("nummerAanduiding cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("nummerAanduiding cannot be null!!");
                                    
                             }

                        } if (localOpenbareRuimteTracker){
                             if (localOpenbareRuimte!=null) {
                                 for (int i = 0;i < localOpenbareRuimte.length;i++){

                                    if (localOpenbareRuimte[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "openbareRuimte"));
                                         elementList.add(localOpenbareRuimte[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("openbareRuimte cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("openbareRuimte cannot be null!!");
                                    
                             }

                        } if (localWoonplaatsTracker){
                             if (localWoonplaats!=null) {
                                 for (int i = 0;i < localWoonplaats.length;i++){

                                    if (localWoonplaats[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120",
                                                                          "woonplaats"));
                                         elementList.add(localWoonplaats[i]);
                                    } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("woonplaats cannot be null !!");
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("woonplaats cannot be null!!");
                                    
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
        public static Body_type4 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Body_type4 object =
                new Body_type4();

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
                    
                            if (!"body_type4".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Body_type4)nl.vrom.www.bag.stuf._0120.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                        java.util.ArrayList list5 = new java.util.ArrayList();
                    
                        java.util.ArrayList list6 = new java.util.ArrayList();
                    
                        java.util.ArrayList list7 = new java.util.ArrayList();
                       
                while(!reader.isEndElement()) {
                    if (reader.isStartElement() ){
                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pand").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list1.add(nl.vrom.www.bag.stuf._0120.Pand_type2.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
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
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","pand").equals(reader.getName())){
                                                                    list1.add(nl.vrom.www.bag.stuf._0120.Pand_type2.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setPand((nl.vrom.www.bag.stuf._0120.Pand_type2[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.Pand_type2.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObject").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list2.add(nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4.Factory.parse(reader));
                                                                
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
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","verblijfsObject").equals(reader.getName())){
                                                                    list2.add(nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setVerblijfsObject((nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.VerblijfsObject_type4.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","ligplaats").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list3.add(nl.vrom.www.bag.stuf._0120.Ligplaats_type2.Factory.parse(reader));
                                                                
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
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","ligplaats").equals(reader.getName())){
                                                                    list3.add(nl.vrom.www.bag.stuf._0120.Ligplaats_type2.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setLigplaats((nl.vrom.www.bag.stuf._0120.Ligplaats_type2[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.Ligplaats_type2.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","standplaats").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list4.add(nl.vrom.www.bag.stuf._0120.Standplaats_type2.Factory.parse(reader));
                                                                
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
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","standplaats").equals(reader.getName())){
                                                                    list4.add(nl.vrom.www.bag.stuf._0120.Standplaats_type2.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setStandplaats((nl.vrom.www.bag.stuf._0120.Standplaats_type2[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.Standplaats_type2.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","nummerAanduiding").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list5.add(nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone5 = false;
                                                        while(!loopDone5){
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
                                                                loopDone5 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","nummerAanduiding").equals(reader.getName())){
                                                                    list5.add(nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone5 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setNummerAanduiding((nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.NummerAanduiding_type8.class,
                                                                list5));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimte").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list6.add(nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone6 = false;
                                                        while(!loopDone6){
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
                                                                loopDone6 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","openbareRuimte").equals(reader.getName())){
                                                                    list6.add(nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone6 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setOpenbareRuimte((nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.OpenbareRuimte_type5.class,
                                                                list6));
                                                            
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","woonplaats").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list7.add(nl.vrom.www.bag.stuf._0120.Woonplaats.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone7 = false;
                                                        while(!loopDone7){
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
                                                                loopDone7 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://www.vrom.nl/bag/stuf/0120","woonplaats").equals(reader.getName())){
                                                                    list7.add(nl.vrom.www.bag.stuf._0120.Woonplaats.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone7 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setWoonplaats((nl.vrom.www.bag.stuf._0120.Woonplaats[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                nl.vrom.www.bag.stuf._0120.Woonplaats.class,
                                                                list7));
                                                            
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
           
          