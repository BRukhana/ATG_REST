<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>

<dsp:page>

	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Details</title>
	<script>
	function removeItem(selectbox)
{
var i=selectbox.selectedIndex;
alert(i);
selectbox.remove(i);
}
	</script>
	</head>
	<body>
	<center>
	<h1>Employee Details</h1>
	</center>

	<dsp:importbean
		bean="/com/logixal/training/FormHandler/EmployeeProfileFormHandler" />

	<dsp:form action="FormSubmitted.jsp" method="post">

		<b>Employee Id:
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.id" />
		<br>
		<br>
		<b>Password:
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
		<dsp:input type="password"
			bean="EmployeeProfileFormHandler.empPassword" />
		<br>
		<br>
		<b>Name:
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
		<dsp:input type="text" bean="EmployeeProfileFormHandler.empName" />
		<br>
		<br>
		<b>Address : -&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
		<dsp:textarea bean="EmployeeProfileFormHandler.empAddress" />
		<br>
		<br>
		<b>Account Number: -&nbsp; </b>
		<dsp:select id="item" bean="EmployeeProfileFormHandler.Accounts">
			<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
			<dsp:droplet name="ForEach">
				<dsp:param bean="EmployeeProfileFormHandler.Accounts" name="array" />
				<dsp:oparam name="output">
					<dsp:option>
						<dsp:valueof param="element">&nbsp;</dsp:valueof>
					</dsp:option>
					<br />
				</dsp:oparam>
			</dsp:droplet>
		</dsp:select>&nbsp;<input type=button
			onClick="removeItem(document.getElementById('item'));"
			value='Remove Selected Item'>
		<br>
		<br>
		<b>Bank Name: - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
		<dsp:select id="id" bean="EmployeeProfileFormHandler.Accounts">
			<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
			<dsp:droplet name="ForEach">
				<dsp:param bean="EmployeeProfileFormHandler.Accounts" name="array" />
				<dsp:oparam name="output">
					<dsp:option>
						<dsp:valueof param="element.bankName">&nbsp;</dsp:valueof>
					</dsp:option>
					<br />
				</dsp:oparam>
			</dsp:droplet>
		</dsp:select>&nbsp;<input type=button
			onClick="removeItem(document.getElementById('id'));"
			value='Remove Selected Item'>
		<br>
		<br>
		<b>Account details &nbsp; <b> <dsp:a
			href="EmployeeAddAccount.jsp">Click Here to Add Account Details
			<dsp:param name="EmployeeId" bean="EmployeeProfileFormHandler.id" />
		</dsp:a> <br>
		<br>
		<dsp:input type="submit" bean="EmployeeProfileFormHandler.update" />
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