<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
<dsp:importbean bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler" />
<dsp:form>
	<h1>For Existing Employee</h1>
	<br>
	<b>Enter Employee Id: </b>
	<dsp:input type="text" bean="EmployeeProfileFormHandler.id" /><br>
	<dsp:input type="submit" bean="EmployeeProfileFormHandler.proceed" />
	<br>
	<br>
</dsp:form>
<dsp:form>
	<h1>For RQL</h1>
	<br>
	<b>Enter Id: </b>
	<dsp:input type="text" bean="EmployeeProfileFormHandler.id" /><br>
	<dsp:input type="submit" bean="EmployeeProfileFormHandler.displayData" />
	<br>
	<br>
</dsp:form>
<dsp:importbean bean="/atg/dynamo/droplet/Switch" />
	<dsp:droplet name="Switch">
		<dsp:param
			bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler.formError"
			name="value" />
		<dsp:oparam name="true">
			<dsp:droplet name="/atg/dynamo/droplet/ErrorMessageForEach">
				<dsp:param
					bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler.formExceptions"
					name="exceptions" />
				<dsp:oparam name="output">
					<dsp:valueof param="message" />
				</dsp:oparam>
			</dsp:droplet>
		</dsp:oparam>
	</dsp:droplet>
<h1>For New Employee</h1>
<br>
<button onclick="location.href='EmployeeRegistrationForm.jsp' ">Register</button>
</body>
</html>
</dsp:page>