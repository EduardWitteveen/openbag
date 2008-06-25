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
	    return new Adres(
			// FOR ALL INFORMATION
			$record['BAGOBJECT'],
			// FOR THE woonplaats
			$record['BAGOBJECT'],
			// FOR THE openbareruimte
			$record['BAGOBJECT'],
			// FOR THE nummeraanduiding
			$record['BAGOBJECT'],
			
			// FOR ALL INFORMATION
			$record['INONDERZOEK'],
			// FOR THE woonplaats
			$record['INONDERZOEK'],
			// FOR THE openbareruimte
			$record['INONDERZOEK'],
			// FOR THE nummeraanduiding
			$record['INONDERZOEK'],
			
			//utf8_encode(isset($record['WOONPLAATS_TERUGMELDING'])?stream_get_contents($record['WOONPLAATS_TERUGMELDING']):null),
			//utf8_encode(isset($record['OPENBARERUIMTE_TERUGMELDING'])?stream_get_contents($record['OPENBARERUIMTE_TERUGMELDING']):null),
			//utf8_encode(isset($record['NUMMERAANDUIDING_TERUGMELDING'])?stream_get_contents($record['NUMMERAANDUIDING_TERUGMELDING']):null),
			//null,
			//null,
			//null,
			
			// NOT TERUGMELDINGEN YET
			'',
			'',
			'',
			//$record['WOONPLAATS_TERUGMELDING'],
			//$record['OPENBARERUIMTE_TERUGMELDING'],
			//$record['NUMMERAANDUIDING_TERUGMELDING'],
						
			$record['OPENBARERUIMTENAAM'],
			$record['HUISNUMMER'],
			$record['HUISLETTER'],
			$record['HUISNUMMERTOEVOEGING'],
			$record['WOONPLAATSNAAM'],
			$record['POSTCODE']					
		);
    }
   /*    
    public static function CreateFromObject($object) {
	    //die(var_dump($object));
	    return new Adres(
			utf8_encode($object->AUTHENTIEK),
			utf8_encode($object->WOONPLAATS_AUTHENTIEK),
			utf8_encode($object->OPENBARERUIMTE_AUTHENTIEK),
			utf8_encode($object->NUMMERAANDUIDING_AUTHENTIEK),
			
			utf8_encode($object->ONDERZOEK),
			utf8_encode($object->WOONPLAATS_ONDERZOEK),
			utf8_encode($object->OPENBARERUIMTE_ONDERZOEK),
			utf8_encode($object->NUMMERAANDUIDING_ONDERZOEK),
			
			//utf8_encode(isset($object->WOONPLAATS_TERUGMELDING)?stream_get_contents($object->WOONPLAATS_TERUGMELDING):null),
			//utf8_encode(isset($object->OPENBARERUIMTE_TERUGMELDING)?stream_get_contents($object->OPENBARERUIMTE_TERUGMELDING):null),
			//utf8_encode(isset($object->NUMMERAANDUIDING_TERUGMELDING)?stream_get_contents($object->NUMMERAANDUIDING_TERUGMELDING):null),
			null,
			null,
			null,
			
			utf8_encode($object->STRAATNAAM),
			utf8_encode($object->HUISNUMMER),
			utf8_encode($object->HUISLETTER),
			utf8_encode($object->HUISTOEVOEGING),
			utf8_encode($object->WOONPLAATS),
			utf8_encode($object->POSTCODE)					
		);
    }
*/    
}
?>
