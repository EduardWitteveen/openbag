<?php 
class Adres {
    /**
     * @var string
     */
     var $authentiek;
    /**
     * @var string
     */
     var $woonplaatsauthentiek;
    /**
     * @var string
     */
     var $openbareruimteauthentiek;
    /**
     * @var string
     */
     var $nummeraanduidingauthentiek;
    /**
     * @var string
     */
    var $onderzoek;
    /**
     * @var string
     */
     var $woonplaatsonderzoek;
    /**
     * @var string
     */
     var $openbareruimteonderzoek;
    /**
     * @var string
     */
     var $nummeraanduidingonderzoek;
    /**
     * @var string
     */
     var $woonplaatsterugmelding;
    /**
     * @var string
     */
     var $openbareruimteterugmelding;
    /**
     * @var string
     */
     var $nummeraanduidingterugmelding;
    /**
     * @var string
     */
    var $straatnaam;
    /**
     * @var int
     */
    var $huisnummer;
    /**
     * @var string
     */
    var $huisletter;
    /**
     * @var string
     */
    var $huistoevoeging;
    /**
     * @var string
     */
    var $woonplaats;
    /**
     * @var string
     */
    var $postcode;

    /**
     * Constructor, sets up the whole needed data to make it possible to
     * create a Adres within one line of code
     *
     * @param string $authentiek
     * @param string $woonplaatsauthentiek;
     * @param string $openbareruimteauthentiek;
     * @param string $nummeraanduidingauthentiek;
     * @param string $onderzoek
     * @param string $woonplaatsonderzoek;
     * @param string $openbareruimteonderzoek;
     * @param string $nummeraanduidingonderzoek;
     * @param string $woonplaatsterugmelding;
     * @param string $openbareruimteterugmelding;
     * @param string $nummeraanduidingterugmelding;
     * @param string $straatnaam
     * @param string $huisnummer
     * @param string $huisletter
     * @param string $huistoevoeging
     * @param string $woonplaats
     * @param string $postcode
     * @return Adres
     */
    public function Adres(
	    $authentiek, 
	    $woonplaatsauthentiek, 
	    $openbareruimteauthentiek, 
	    $nummeraanduidingauthentiek,
	    
	    $onderzoek,
	    $woonplaatsonderzoek,
	    $openbareruimteonderzoek,
	    $nummeraanduidingonderzoek,
	    
     	    $woonplaatsterugmelding,
     	    $openbareruimteterugmelding,
     	    $nummeraanduidingterugmelding,
	    
	    $straatnaam, 
	    $huisnummer, 
	    $huisletter, 
	    $huistoevoeging, 
	    $woonplaats, 
	    $postcode
	    ) 
    {
	    $this->authentiek = $authentiek;
	    $this->woonplaatsauthentiek = $woonplaatsauthentiek;
     	    $this->openbareruimteauthentiek = $openbareruimteauthentiek; 
     	    $this->nummeraanduidingauthentiek = $nummeraanduidingauthentiek;
	    
     	    $this->onderzoek = $onderzoek;
	    $this->woonplaatsonderzoek = $woonplaatsonderzoek;
     	    $this->openbareruimteonderzoek = $openbareruimteonderzoek;
     	    $this->nummeraanduidingonderzoek = $nummeraanduidingonderzoek;
	    
     	    $this->woonplaatsterugmelding = $woonplaatsterugmelding;
     	    $this->openbareruimteterugmelding = $openbareruimteterugmelding;
     	    $this->nummeraanduidingterugmelding = $nummeraanduidingterugmelding;
	    
	    $this->straatnaam = $straatnaam;
	    $this->huisnummer = $huisnummer;
	    $this->huisletter = $huisletter;
	    $this->huistoevoeging = $huistoevoeging;
	    $this->woonplaats = $woonplaats;
	    $this->postcode = $postcode;
    }
    public static function CreateFromRecord($record) {
		//print_r($record);
	    return new Adres(
			// FOR ALL INFORMATION
			// FOR ALL INFORMATION
			$record['BAGOBJECT'],
			// FOR THE woonplaats
			$record['BAGWOONPLAATS'],
			// FOR THE openbareruimte
			$record['BAGOPENBARERUIMTE'],
			// FOR THE nummeraanduiding
			$record['BAGNUMMERAANDUIDING'],
			
			// FOR ALL INFORMATION
			$record['ONDERZOEKOBJECT'],
			// FOR THE woonplaats
			$record['ONDERZOEKWOONPLAATS'],
			// FOR THE openbareruimte
			$record['ONDERZOEKOPENBARERUIMTE'],
			// FOR THE nummeraanduiding
			$record['ONDERZOEKNUMMERAANDUIDING'],
					
			// NOT TERUGMELDINGEN YET
			'not yet terugmeldingen woonplaats',
			'not yet terugmeldingen openbareruimte',
			'not yet terugmeldingen nummeraanduiding',
									
			$record['OPENBARERUIMTENAAM'],
			$record['HUISNUMMER'],
			$record['HUISLETTER'],
			$record['HUISNUMMERTOEVOEGING'],
			$record['WOONPLAATSNAAM'],
			$record['POSTCODE']					
		);
    }
}
?>
