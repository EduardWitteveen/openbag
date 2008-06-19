<?php 
class Setting {
    /**
     * @var string
     */
    var $key;
    /**
     * @var string
     */
    var $value;
    /**
     * Constructor, sets up the whole needed data to make it possible to
     * create a Adres within one line of code
     *
     * @param string $key
     * @param string $value
     * @return Setting
     */
    public function Setting($key, $value) {
	    $this->key = $key;
	    $this->value = $value;
    }
/*    
    public static function CreateFromRecord($record) {
	    //die(var_dump($object));
	    return new Setting(
			utf8_encode($record['key']),
			utf8_encode($record['value'])
		);
    }
*/    
/*    
    public static function CreateFromObject($object) {
	    //die(var_dump($object));
	    return new Setting(
			utf8_encode($object->key),
			utf8_encode($object->value)
		);
    }
*/    
}
?>
