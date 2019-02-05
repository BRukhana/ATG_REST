<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
	<dsp:importbean bean="/atg/dynamo/droplet/Range" />

	<dsp:droplet name="Range">
		<dsp:param bean="/com/logixal/dspAssignment/Person.personAge"
			name="array" />
		<dsp:param name="howMany" value="2" />
		<dsp:oparam name="outputStart">
			<h3>Initial data:</h3>
			<ul>
		</dsp:oparam>
		<dsp:oparam name="output">
			<li><dsp:valueof param="element">&nbsp;</dsp:valueof>
		</dsp:oparam>
		<dsp:oparam name="outputEnd">
			</ul>
		</dsp:oparam>
	</dsp:droplet>
	</body>
	</html>
</dsp:page>
