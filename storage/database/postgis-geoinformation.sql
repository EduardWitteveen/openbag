--
-- PostgreSQL database dump
--

-- Started on 2008-05-31 17:07:23 CEST

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2370 (class 0 OID 18489)
-- Dependencies: 2011
-- Data for Name: geometry_columns; Type: TABLE DATA; Schema: public; Owner: hibernate
--

INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_gemeente', 'grens', 2, -1, 'POLYGON');
INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_nummeraanduiding', 'punt', 2, -1, 'POINT');
INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_openbareruimte', 'grens', 2, -1, 'POLYGON');
INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_pand', 'grens', 2, -1, 'MULTIPOLYGON');
INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_woonplaats', 'grens', 2, -1, 'POLYGON');
INSERT INTO geometry_columns (f_table_catalog, f_table_schema, f_table_name, f_geometry_column, coord_dimension, srid, "type") VALUES ('', 'public', 'data_verblijfsobject', 'punt', 2, -1, 'POINT');


-- Completed on 2008-05-31 17:07:24 CEST

--
-- PostgreSQL database dump complete
--

