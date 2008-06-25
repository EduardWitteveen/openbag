<?xml version="1.0" encoding="UTF-8"?>
<?php 
	include_once "../include/util/url.php"; 
?>
<definitions name="config"
	targetNamespace="urn:config"
	xmlns:typens="urn:config"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns="http://schemas.xmlsoap.org/wsdl/"
>
	<!-- type: a container for data type definitions using some type system (such as XSD) -->
	<types>
        	<xsd:schema xmlns="http://www.w3.org/2001/XMLSchema" targetNamespace="urn:config">
			<!-- definitie van Setting -->
			<xsd:complexType name="Setting">
				<xsd:all>
					<xsd:element name="key" type="xsd:string" />
					<xsd:element name="value" type="xsd:string" />
				</xsd:all>
			</xsd:complexType>
			<!-- definitie van Settings array -->
			<xsd:complexType name="Settings">
				<xsd:complexContent>
					<xsd:restriction base="soapenc:Array">
						<xsd:attribute ref="soapenc:arrayType" wsdl:arrayType="typens:Setting[]"/>
					</xsd:restriction>
				</xsd:complexContent>
			</xsd:complexType>
		</xsd:schema>
    </types>    
    <!-- Message: an abstract, typed definition of the data being communicated. -->
    <message name="version-response">
        <part name="version-response-result" type="xsd:string"/>
    </message>
    <message name="configsettings-request">
        <part name="configsettings-request-filter" type="xsd:string"/>
    </message>
    <message name="configsettings-response">
    	<part name="configsettings-response-response" type="typens:Settings"/>
    </message>    
    
    <!-- Port Type: an abstract set of operations supported by one or more endpoints. -->
    <portType name="config-port">
    	<!-- Operation: an abstract description of an action supported by the service. -->
        <operation name="version">
            <output message="typens:version-response"/>
        </operation>
        <operation name="configsettings">
            <input message="typens:configsettings-request"/>
            <output message="typens:configsettings-response"/>
        </operation>	
    </portType>

    <!-- Binding: a concrete protocol and data format specification for a particular port type. -->
    <binding name="config-binding" type="typens:config-port">        
    	<soap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>	
	<operation name="version">
		<soap:operation soapAction="urn:version-action"/>
                <output>
                    <soap:body use="encoded" namespace="urn:version" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>		
	</operation>
        <operation name="configsettings">
        	<soap:operation soapAction="urn:configsettings-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:configsettings-request" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:configsettings-response" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>
    </binding>    
    
    <!-- Service: a collection of related endpoints. -->
    <service name="config-service">
    	<!-- Port: a single endpoint defined as a combination of a binding and a network address. -->
        <port name="config-port" binding="typens:config-binding">
            <soap:address location="<?php echo(getURL('config.php')) ?>"/>
        </port>
    </service>
</definitions>