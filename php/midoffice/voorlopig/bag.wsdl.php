<?xml version="1.0" encoding="UTF-8"?>
<?php 
	include_once "../../common/util/url.php"; 
?>
<definitions name="bag"
	targetNamespace="urn:bag"
	xmlns:typens="urn:bag"
	xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns="http://schemas.xmlsoap.org/wsdl/"
>
	<!-- type: a container for data type definitions using some type system (such as XSD) -->
	<types>
        	<xsd:schema xmlns="http://www.w3.org/2001/XMLSchema" targetNamespace="urn:bag">
			<!-- definitie van Adres -->
			<xsd:complexType name="Adres">
				<xsd:all>
					<xsd:element name="authentiek" type="xsd:string" />					
					<xsd:element name="woonplaatsauthentiek" type="xsd:string" />
					<xsd:element name="openbareruimteauthentiek" type="xsd:string" />
					<xsd:element name="nummeraanduidingauthentiek" type="xsd:string" />					
					
					<xsd:element name="onderzoek" type="xsd:string" />
					<xsd:element name="woonplaatsonderzoek" type="xsd:string" />
					<xsd:element name="openbareruimteonderzoek" type="xsd:string" />
					<xsd:element name="nummeraanduidingonderzoek" type="xsd:string" />					

					<xsd:element name="woonplaatsterugmelding" type="xsd:string" />
					<xsd:element name="openbareruimteterugmelding" type="xsd:string" />
					<xsd:element name="nummeraanduidingterugmelding" type="xsd:string" />					
					
					<xsd:element name="straatnaam" type="xsd:string" />
					<xsd:element name="huisnummer" type="xsd:int" />
					<xsd:element name="huisletter" type="xsd:string" />
					<xsd:element name="huistoevoeging" type="xsd:string" />
					<xsd:element name="woonplaats" type="xsd:string" />
					<xsd:element name="postcode" type="xsd:string" />
				</xsd:all>
			</xsd:complexType>
			<!-- definitie van Adressen array -->
			<xsd:complexType name="Adressen">
				<xsd:complexContent>
					<xsd:restriction base="soapenc:Array">
						<xsd:attribute ref="soapenc:arrayType" wsdl:arrayType="typens:Adres[]"/>
					</xsd:restriction>
				</xsd:complexContent>
			</xsd:complexType>
		</xsd:schema>
    </types>
    
    <!-- Message: an abstract, typed definition of the data being communicated. -->
    <message name="version-response">
        <part name="version-response-result" type="xsd:string"/>
    </message>
    <message name="zoekadres-request">
        <part name="zoekadres-request-filter" type="xsd:string"/>
    </message>
    <message name="zoekadres-response">
    	<part name="zoekadres-response-response" type="typens:Adressen"/>
    </message>        
    <message name="zoekadresmetfilter-request">
    	<!-- should be "typens:Adres", but doesnt work!! -->
        <part name="zoekadresmetfilter-request-filter" type="xsd:Adres"/>
    </message>
    <message name="zoekadresmetfilter-response">
    	<part name="zoekadresmetfilter-response-response" type="typens:Adressen"/>
    </message>
    <message name="gishtmlviewadres-request">
        <part name="gishtmlviewadres-request-filter" type="xsd:string"/>
        <part name="gishtmlviewadres-request-height" type="xsd:int"/>
        <part name="gishtmlviewadres-request-width" type="xsd:int"/>
    </message>    
    <message name="gishtmlviewadres-response">
        <part name="gishtmlviewadres-response-response" type="xsd:string"/>
    </message>
    <message name="gishtmlviewadresmetfilter-request">
    	<!-- should be "typens:Adres", but doesnt work!! -->
        <part name="gishtmlviewadresmetfilter-request-filter" type="xsd:Adres"/>
        <part name="gishtmlviewadresmetfilter-request-height" type="xsd:int"/>
        <part name="gishtmlviewadresmetfilter-request-width" type="xsd:int"/>
    </message>    
    <message name="gishtmlviewadresmetfilter-response">
        <part name="gishtmlviewadresmetfilter-response-response" type="xsd:string"/>
    </message>
    <message name="terugmelding-request">
    	<!-- should be "typens:Adres", but doesnt work!! -->
        <part name="terugmelding-request-filter" type="xsd:Adres"/>
	<part name="terugmelding-request-username" type="xsd:string"/>
	<part name="terugmelding-request-onderdeel" type="xsd:string"/>
	<part name="terugmelding-request-melding" type="xsd:string"/>
    </message>
    
    <!-- Port Type: an abstract set of operations supported by one or more endpoints. -->
    <portType name="bag-port">
    	<!-- Operation: an abstract description of an action supported by the service. -->
        <operation name="version">
            <output message="typens:version-response"/>
        </operation>
        <operation name="zoekadres">
            <input message="typens:zoekadres-request"/>
            <output message="typens:zoekadres-response"/>
        </operation>	
        <operation name="zoekadresmetfilter">
            <input message="typens:zoekadresmetfilter-request"/>
            <output message="typens:zoekadresmetfilter-response"/>
        </operation>
        <operation name="zoekadresmetfilter">
            <input message="typens:zoekadresmetfilter-request"/>
            <output message="typens:zoekadresmetfilter-response"/>
        </operation>
        <operation name="gishtmlviewadres">
            <input message="typens:gishtmlviewadres-request"/>
            <output message="typens:gishtmlviewadres-response"/>
        </operation>
        <operation name="gishtmlviewadresmetfilter">
            <input message="typens:gishtmlviewadresmetfilter-request"/>
            <output message="typens:gishtmlviewadresmetfilter-response"/>
        </operation>
        <operation name="terugmelding">
            <input message="typens:terugmelding-request"/>
        </operation>
   </portType>

    <!-- Binding: a concrete protocol and data format specification for a particular port type. -->
    <binding name="bag-binding" type="typens:bag-port">        
    	<soap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>	
	<operation name="version">
		<soap:operation soapAction="urn:version-action"/>
                <output>
                    <soap:body use="encoded" namespace="urn:version" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>		
	</operation>
        <operation name="zoekadres">
        	<soap:operation soapAction="urn:zoekadres-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:zoekadres" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:zoekadres" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>	
        <operation name="zoekadresmetfilter">
        	<soap:operation soapAction="urn:zoekadresmetfilter-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:zoekadresmetfilter" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:zoekadresmetfilter" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>
        <operation name="gishtmlviewadres">
        	<soap:operation soapAction="urn:gishtmlviewadres-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:gishtmlviewadres" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:gishtmlviewadres" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>
        <operation name="gishtmlviewadresmetfilter">
        	<soap:operation soapAction="urn:gishtmlviewadresmetfilter-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:gishtmlviewadresmetfilter" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:gishtmlviewadresmetfilter" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>
        <operation name="terugmelding">
        	<soap:operation soapAction="urn:terugmelding-action"/>
		<input>
		    <soap:body use="encoded" namespace="urn:terugmelding" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </input>
                <output>
                    <soap:body use="encoded" namespace="urn:terugmelding" encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                </output>
        </operation>
    </binding>    
    
    <!-- Service: a collection of related endpoints. -->
    <service name="bag-service">
    	<!-- Port: a single endpoint defined as a combination of a binding and a network address. -->
        <port name="bag-port" binding="typens:bag-binding">
            <soap:address location="<?php echo(getURL('bag.php')) ?>"/>
        </port>
    </service>
</definitions>