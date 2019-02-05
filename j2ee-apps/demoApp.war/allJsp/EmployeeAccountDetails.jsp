<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>

<dsp:page>

	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Account Details</title>
	</head>
	<body>
	<center>
	<h1>Employee Details</h1>
	</center>

	<dsp:importbean
		bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler" />

	<dsp:form action="EmployeeRegistrationForm.jsp" method="post">
		
		<b>Employee Id  : - </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.id" />
		<br>
		<b>Account Id: </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.account_id" />
		<br>
		<br>
		<b>Bank Name: </b>
		<dsp:input type="text"
			bean="EmployeeProfileFormHandler.bankName" />
		<br>
		<br>
		<b>Account Balance: </b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.accountBalance" />
		<br>
		<br>
		<br>
		<dsp:input type="submit" bean="EmployeeProfileFormHandler.addAccount" />

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
</dsp:page>