<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<dsp:page>

	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Details</title>
	</head>
	
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<body>
	<center>
	<h1>Employee Details</h1>
	</center>

<dsp:layerBundle basename="com.test.resources" >

	<dsp:importbean
		bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler" />

	<dsp:form action="FormSubmitted.jsp" method="post">

		<b><fmt:message key = "employee.id.label"/></b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.id" />
		<br>
		<br>
		<b><fmt:message key = "employee.password.label "/></b>
		<dsp:input type="password"
			bean="EmployeeProfileFormHandler.empPassword" />
		<br>
		<br>
		<b>Name: </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.empName" />
		<br>
		<br>
		<b>Address : - </b>
		<dsp:textarea bean="EmployeeProfileFormHandler.empAddress" />
		<br>
		<b>City: </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.empCity" />
		<br>
		<b>Phone No: </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.empPhoneNo" />
		
		Date: <dsp:input type="text" bean="EmployeeProfileFormHandler.dateOfBirth" />

		<br>
		<br>
		<dsp:input type="submit" bean="EmployeeProfileFormHandler.add" />

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
	</body>
	</html>
	<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
 </dsp:layerBundle>
</dsp:page>
