<?xml version="1.0" encoding="ISO-8859-1"?>
<StyledLayerDescriptor version="1.0.0"
	xsi:schemaLocation="http://www.opengis.net/sld StyledLayerDescriptor.xsd"
	xmlns="http://www.opengis.net/sld"
	xmlns:ogc="http://www.opengis.net/ogc"
	xmlns:xlink="http://www.w3.org/1999/xlink"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<!-- a named layer is the basic building block of an sld document -->
	<NamedLayer>
		<Name>Verblijfsobject BAG</Name>
		<UserStyle>
			<FeatureTypeStyle>
				<FeatureTypeName>Verblijfsobject</FeatureTypeName>
				<Rule>
					<Name>verblijfsobject</Name>
					<Title>verblijfsobject punt</Title>
					<Abstract>Abstract</Abstract>
					<PointSymbolizer>
						<Graphic>
							<Mark>
								<WellKnownName>circle</WellKnownName>
								<Fill>
									<CssParameter name="fill">
										#ff0000
									</CssParameter>
								</Fill>
							</Mark>
							<Size>8.0</Size>
						</Graphic>
					</PointSymbolizer>
				</Rule>
			</FeatureTypeStyle>
		</UserStyle>
	</NamedLayer>
</StyledLayerDescriptor>
