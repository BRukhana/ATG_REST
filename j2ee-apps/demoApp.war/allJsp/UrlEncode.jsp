<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Droplet</title>
	</head>
	<body>

	<dsp:importbean bean="/com/logixal/urlEncodeDroplet/urlEncodeDroplet" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
	<dsp:droplet name="urlEncodeDroplet">

		<dsp:param name="url"
			bean="/OriginatingRequest.requestURIWithQueryString" />
			URL Given by User :	 <dsp:valueof param="url" />
		</br>
		<dsp:oparam name="output">
				Encoded URL by Droplet : <dsp:valueof param="EncodedURL" />
		</dsp:oparam>

		<dsp:droplet name="/atg/dynamo/droplet/ForEach">
			<dsp:param name="array" bean="/OriginatingRequest.parameterMap" />
			<dsp:setvalue param="Key" paramvalue="key" />
			<dsp:setvalue param="url" paramvalue="element" />
			<dsp:oparam name="outputStart">
				<table align="center" border="1">
					<tr>
						<th>Key</th>
						<th>Value</th>
					</tr>
					</dsp:oparam>
					<dsp:oparam name="output">
						<tr>
							<td><dsp:valueof param="Key" /></td>
							<dsp:getvalueof var="map" param="url" vartype="java.lang.String" />
							<td>${map}</td>
						</tr>
					</dsp:oparam>
					<dsp:oparam name="outputEnd">
				</table>
			</dsp:oparam>
		</dsp:droplet>
		</oparam>
	</dsp:droplet>
	</body>
	</html>
</dsp:page>




