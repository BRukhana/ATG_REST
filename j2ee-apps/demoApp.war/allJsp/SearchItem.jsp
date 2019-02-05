<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>

<%@ page isELIgnored="false"%>
<dsp:page>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Search Repository</title>
	</head>
	<body>
	<br>
	<dsp:importbean
		bean="/atg/searchadmin/SearchAdminRepository" />

	<b>Repository component </b>
	- /atg/searchadmin/SearchAdminRepository/
	<br>
	<b>ItemDescriptor </b>
	- contentSourceAdapter
	<br>
	<br>
	<dsp:droplet name="/atg/dynamo/droplet/RQLQueryRange">
		<dsp:oparam name="outputStart">
			<b>Displaying first 15 items in the repository -</b>
			<br>
			<ol>
		</dsp:oparam>
		<dsp:param name="repository" bean="SearchAdminRepository" />
		<dsp:param name="itemDescriptor" value="contentSourceAdapter" />
		<dsp:param name="queryRQL" value="ALL" />
		<dsp:param name="howMany" value="15" />
		<dsp:oparam name="output">
			<li><dsp:valueof param="element" /></li>
			<br>
		</dsp:oparam>
		<dsp:oparam name="outputEnd">
			</ol>
		</dsp:oparam>
	</dsp:droplet>
	</body>
	</html>
</dsp:page>
