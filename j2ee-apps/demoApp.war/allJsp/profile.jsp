<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Repository</title>
	</head>
	<body>

	<dsp:importbean bean="/com/logixal/training/RepositoryData" />
	
	<dsp:droplet name="RepositoryData">
		
		<dsp:oparam name="output">
				<b>User Name :</b> <dsp:valueof param="UserName" />
				</br>
				<b>User Age : </b><dsp:valueof param="UserAge" />
		</dsp:oparam>
		
	</dsp:droplet>
	</body>
	</html>
</dsp:page>




