CREATE OR REPLACE VIEW BAG_GEMEENTE AS
SELECT 
    DATA_OBJECT.CODE, 
    DATA_GEMEENTE.NAAM, 
    DATA_GEMEENTE.GRENS 
FROM DATA_GEMEENTE 
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_GEMEENTE.CODE;

CREATE OR REPLACE VIEW BAG_WOONPLAATS AS
SELECT 
    DATA_OBJECT.CODE,
    DATA_OBJECT.BAGOBJECT,
    DATA_AUTHENTIEK.BEGINGELDIGHEID,
    DATA_AUTHENTIEK.EINDEGELDIGHEID,
    DATA_AUTHENTIEK.DOCUMENTDATUM,
    DATA_AUTHENTIEK.DOCUMENTNUMMER,
    DATA_AUTHENTIEK.STATUS,
    DATA_AUTHENTIEK.INONDERZOEK,    
    DATA_WOONPLAATS.NAAM,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM,
    DATA_WOONPLAATS.GRENS
FROM DATA_WOONPLAATS
LEFT OUTER JOIN DATA_AUTHENTIEK
ON DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW BAG_OPENBARERUIMTE AS
SELECT 
    DATA_OBJECT.CODE,
    DATA_OBJECT.BAGOBJECT,
    DATA_AUTHENTIEK.BEGINGELDIGHEID,
    DATA_AUTHENTIEK.EINDEGELDIGHEID,
    DATA_AUTHENTIEK.DOCUMENTDATUM,
    DATA_AUTHENTIEK.DOCUMENTNUMMER,
    DATA_AUTHENTIEK.STATUS,
    DATA_AUTHENTIEK.INONDERZOEK,    
    DATA_OPENBARERUIMTE.NAAM,
    DATA_WOONPLAATS.NAAM AS WOONPLAATSNAAM,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM,
    DATA_OPENBARERUIMTE.GRENS
FROM DATA_OPENBARERUIMTE
LEFT OUTER JOIN DATA_AUTHENTIEK
ON DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE
LEFT OUTER JOIN DATA_WOONPLAATS
ON DATA_WOONPLAATS.CODE = DATA_OPENBARERUIMTE.WOONPLAATS_CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW BAG_NUMMERAANDUIDING AS
SELECT 
    DATA_OBJECT.CODE,
    DATA_OBJECT.BAGOBJECT,
    DATA_AUTHENTIEK.BEGINGELDIGHEID,
    DATA_AUTHENTIEK.EINDEGELDIGHEID,
    DATA_AUTHENTIEK.DOCUMENTDATUM,
    DATA_AUTHENTIEK.DOCUMENTNUMMER,
    DATA_AUTHENTIEK.STATUS,
    DATA_AUTHENTIEK.INONDERZOEK,    
    DATA_NUMMERAANDUIDING.HUISNUMMER,
    DATA_NUMMERAANDUIDING.HUISLETTER,
    DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,
    DATA_NUMMERAANDUIDING.POSTCODE,
    DATA_NUMMERAANDUIDING.TYPE,
    DATA_OPENBARERUIMTE.NAAM AS OPENBARERUIMTENAAM,
    DATA_WOONPLAATS.NAAM AS WOONPLAATSNAAM,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM,
    DATA_NUMMERAANDUIDING.PUNT    
FROM DATA_NUMMERAANDUIDING
LEFT OUTER JOIN DATA_AUTHENTIEK
ON DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE
LEFT OUTER JOIN DATA_OPENBARERUIMTE
ON DATA_OPENBARERUIMTE.CODE = DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE
LEFT OUTER JOIN DATA_WOONPLAATS
ON DATA_WOONPLAATS.CODE = COALESCE(DATA_NUMMERAANDUIDING.ALT_WOONPLAATS_CODE, DATA_OPENBARERUIMTE.WOONPLAATS_CODE) 
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW BAG_VERBLIJFSOBJECT AS
SELECT 
    DATA_OBJECT.CODE,
    DATA_OBJECT.BAGOBJECT,
    DATA_AUTHENTIEK.BEGINGELDIGHEID,
    DATA_AUTHENTIEK.EINDEGELDIGHEID,
    DATA_AUTHENTIEK.DOCUMENTDATUM,
    DATA_AUTHENTIEK.DOCUMENTNUMMER,
    DATA_AUTHENTIEK.STATUS,
    DATA_AUTHENTIEK.INONDERZOEK,
    DATA_VERBLIJFSPLAATS.NUMMERAANDUIDING_CODE AS NUMMERAANDUIDING_CODE,
    DATA_VERBLIJFSOBJECT.OPPERVLAKTE,
    DATA_VERBLIJFSOBJECT.WOZOBJEKTNR,
    DATA_VERBLIJFSOBJECT.PUNT
FROM DATA_VERBLIJFSOBJECT
LEFT OUTER JOIN DATA_VERBLIJFSPLAATS
ON DATA_VERBLIJFSPLAATS.CODE = DATA_VERBLIJFSOBJECT.CODE
LEFT OUTER JOIN DATA_AUTHENTIEK
ON DATA_AUTHENTIEK.CODE = DATA_VERBLIJFSPLAATS.CODE
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE;

CREATE OR REPLACE VIEW BAG_PAND AS
SELECT 
    DATA_OBJECT.CODE,
    DATA_OBJECT.BAGOBJECT,
    DATA_AUTHENTIEK.BEGINGELDIGHEID,
    DATA_AUTHENTIEK.EINDEGELDIGHEID,
    DATA_AUTHENTIEK.DOCUMENTDATUM,
    DATA_AUTHENTIEK.DOCUMENTNUMMER,
    DATA_AUTHENTIEK.STATUS,
    DATA_AUTHENTIEK.INONDERZOEK,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM,
    DATA_PAND.BOUWJAAR,
    DATA_PAND.GRENS
FROM DATA_PAND
LEFT OUTER JOIN DATA_AUTHENTIEK
ON DATA_AUTHENTIEK.CODE = DATA_PAND.CODE
LEFT OUTER JOIN DATA_OBJECT 
ON DATA_OBJECT.CODE = DATA_AUTHENTIEK.CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_PAND.GEMEENTE_CODE;

CREATE OR REPLACE VIEW GIS_WOONPLAATS AS
SELECT     
    DATA_WOONPLAATS.CODE AS WOONPLAATSCODE,
    DATA_WOONPLAATS.NAAM AS WOONPLAATSNAAM,
    DATA_WOONPLAATS.GRENS AS WOONPLAATSGRENS,
    (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_WOONPLAATS.CODE ) AS BAGWOONPLAATS,
    (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE) AS ONDERZOEKWOONPLAATS,
    DATA_GEMEENTE.CODE AS GEMEENTECODE,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM
FROM DATA_WOONPLAATS
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW GIS_OPENBARERUIMTE AS
SELECT 
    DATA_OPENBARERUIMTE.CODE AS OPENBARERUIMTECODE,
    DATA_OPENBARERUIMTE.NAAM AS OPENBARERUIMTENAAM,
    DATA_OPENBARERUIMTE.GRENS AS OPENBARERUIMTEGRENS,
    (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_OPENBARERUIMTE.CODE) AS BAGOPENBARERUIMTE,
    (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE) AS ONDERZOEKOPENBARERUIMTE,    
    DATA_WOONPLAATS.CODE AS WOONPLAATSCODE,
    DATA_WOONPLAATS.NAAM AS WOONPLAATSNAAM,
    (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_WOONPLAATS.CODE ) AS BAGWOONPLAATS,
    (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE) AS ONDERZOEKWOONPLAATS,
    DATA_GEMEENTE.CODE AS GEMEENTECODE,
    DATA_GEMEENTE.NAAM AS GEMEENTENAAM
FROM DATA_OPENBARERUIMTE
LEFT OUTER JOIN DATA_WOONPLAATS
ON  DATA_WOONPLAATS.CODE = DATA_OPENBARERUIMTE.WOONPLAATS_CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW GIS_ADRES AS
SELECT   
  ADRES.CODE AS ADRESCODE,
  ADRES.PUNT AS ADRESPUNT,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = ADRES.CODE) AS BAGADRES,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = ADRES.CODE) AS ONDERZOEKADRES,  
  DATA_NUMMERAANDUIDING.CODE AS NUMMERAANDUIDINGCODE,
  DATA_NUMMERAANDUIDING.HUISNUMMER,
  DATA_NUMMERAANDUIDING.HUISLETTER,
  DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,
  DATA_NUMMERAANDUIDING.POSTCODE,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_NUMMERAANDUIDING.CODE) AS BAGNUMMERAANDUIDING,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE) AS ONDERZOEKNUMMERAANDUIDING,  
  DATA_OPENBARERUIMTE.CODE AS OPENBARERUIMTECODE,
  DATA_OPENBARERUIMTE.NAAM AS OPENBARERUIMTENAAM,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_OPENBARERUIMTE.CODE) AS BAGOPENBARERUIMTE,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE) AS ONDERZOEKOPENBARERUIMTE,    
  DATA_WOONPLAATS.CODE AS WOONPLAATSCODE,
  DATA_WOONPLAATS.NAAM  AS WOONPLAATSNAAM ,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_WOONPLAATS.CODE ) AS BAGWOONPLAATS,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE) AS ONDERZOEKWOONPLAATS, 
  DATA_GEMEENTE.CODE AS GEMEENTECODE,
  DATA_GEMEENTE.NAAM AS GEMEENTENAAM
FROM (
  SELECT
    CODE,
    PUNT
  FROM DATA_VERBLIJFSOBJECT
--UNION
--  SELECT
--    CODE,
--    SDO_GEOM.SDO_CENTROID(GRENS, 0.001)
--  FROM DATA_LIGPLAATS
--UNION
--  SELECT
--    CODE,
--    SDO_GEOM.SDO_CENTROID(GRENS, 0.001)
--  FROM DATA_STANDPLAATS  
)
ADRES
LEFT OUTER JOIN DATA_VERBLIJFSPLAATS
ON DATA_VERBLIJFSPLAATS.CODE = ADRES.CODE
LEFT OUTER JOIN DATA_NUMMERAANDUIDING
ON DATA_NUMMERAANDUIDING.CODE = DATA_VERBLIJFSPLAATS.NUMMERAANDUIDING_CODE
LEFT OUTER JOIN DATA_OPENBARERUIMTE
ON  DATA_OPENBARERUIMTE.CODE = DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE
LEFT OUTER JOIN DATA_WOONPLAATS
ON  DATA_WOONPLAATS.CODE = DATA_OPENBARERUIMTE.WOONPLAATS_CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;

CREATE OR REPLACE VIEW GIS_PAND AS
SELECT   
  DATA_PAND.CODE AS PANDCODE,
  DATA_PAND.GRENS AS PANDGRENS,
  DATA_GEMEENTE.CODE AS GEMEENTECODE,
  DATA_GEMEENTE.NAAM AS GEMEENTENAAM
FROM DATA_PAND
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_PAND.GEMEENTE_CODE;

CREATE OR REPLACE VIEW MID_ADRES AS
SELECT   
  ADRES.CODE AS ADRESCODE,
  SDO_GEOM.SDO_MIN_MBR_ORDINATE(ADRES.PUNT, 1) AS ADRES_X,
  SDO_GEOM.SDO_MIN_MBR_ORDINATE(ADRES.PUNT, 2) AS ADRES_Y,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = ADRES.CODE) AS BAGADRES,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE) AS ONDERZOEKADRES,  
  DATA_NUMMERAANDUIDING.CODE AS NUMMERAANDUIDINGCODE,
  DATA_NUMMERAANDUIDING.HUISNUMMER,
  DATA_NUMMERAANDUIDING.HUISLETTER,
  DATA_NUMMERAANDUIDING.HUISNUMMERTOEVOEGING,
  DATA_NUMMERAANDUIDING.POSTCODE,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_NUMMERAANDUIDING.CODE) AS BAGNUMMERAANDUIDING,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_NUMMERAANDUIDING.CODE) AS ONDERZOEKNUMMERAANDUIDING,  
  DATA_OPENBARERUIMTE.CODE AS OPENBARERUIMTECODE,
  DATA_OPENBARERUIMTE.NAAM AS OPENBARERUIMTENAAM,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_OPENBARERUIMTE.CODE) AS BAGOPENBARERUIMTE,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_OPENBARERUIMTE.CODE) AS ONDERZOEKOPENBARERUIMTE,
  DATA_WOONPLAATS.CODE AS WOONPLAATSCODE,
  DATA_WOONPLAATS.NAAM  AS WOONPLAATSNAAM ,
  (SELECT BAGOBJECT FROM DATA_OBJECT WHERE DATA_OBJECT.CODE = DATA_WOONPLAATS.CODE ) AS BAGWOONPLAATS,
  (SELECT INONDERZOEK FROM DATA_AUTHENTIEK WHERE DATA_AUTHENTIEK.CODE = DATA_WOONPLAATS.CODE) AS ONDERZOEKWOONPLAATS,
  DATA_GEMEENTE.CODE AS GEMEENTECODE,
  DATA_GEMEENTE.NAAM AS GEMEENTENAAM
FROM (
  SELECT
    CODE,
    PUNT
  FROM DATA_VERBLIJFSOBJECT
--UNION
--  SELECT
--    CODE,
--    SDO_GEOM.SDO_CENTROID(GRENS, 0.001)
--  FROM DATA_LIGPLAATS
--UNION
--  SELECT
--    CODE,
--    SDO_GEOM.SDO_CENTROID(GRENS, 0.001)
--  FROM DATA_STANDPLAATS  
)
ADRES
LEFT OUTER JOIN DATA_VERBLIJFSPLAATS
ON DATA_VERBLIJFSPLAATS.CODE = ADRES.CODE
LEFT OUTER JOIN DATA_NUMMERAANDUIDING
ON DATA_NUMMERAANDUIDING.CODE = DATA_VERBLIJFSPLAATS.NUMMERAANDUIDING_CODE
LEFT OUTER JOIN DATA_OPENBARERUIMTE
ON  DATA_OPENBARERUIMTE.CODE = DATA_NUMMERAANDUIDING.OPENBARERUIMTE_CODE
LEFT OUTER JOIN DATA_WOONPLAATS
ON  DATA_WOONPLAATS.CODE = DATA_OPENBARERUIMTE.WOONPLAATS_CODE
LEFT OUTER JOIN DATA_GEMEENTE
ON DATA_GEMEENTE.CODE = DATA_WOONPLAATS.GEMEENTE_CODE;