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

		<dsp:param name="url" bean="/OriginatingRequest.requestURL" />
		<dsp:param name="map" bean="/OriginatingRequest.parameterMap" />

		<dsp:oparam name="outputStart">
			<b>URL Given by User : </b>
			<dsp:valueof param="url" />
			</br>
			<b> Encoded URL by Droplet : </b>
			<dsp:valueof param="EncodedURL" />
			</br>
			<table align="center" border="1">
				<tr>
					<th>Key</th>
					<th>Value</th>
				</tr>
		</dsp:oparam>

		<dsp:oparam name="output">
					<tr>
						<dsp:getvalueof var="mapkey" param="key"
							vartype="java.lang.String" />
						<td>${mapkey}</td>
						<dsp:getvalueof var="mapdata" param="value"
							vartype="java.lang.String" />
						<td>${mapdata}</td>
					</tr>
		</dsp:oparam>

		<dsp:oparam name="outputEnd">
			</table>
		</dsp:oparam>

	</dsp:droplet>
	</body>
	</html>
</dsp:page>




