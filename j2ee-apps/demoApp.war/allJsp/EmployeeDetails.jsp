<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:droplet name="/com/droplet/EmployeeLookup">
		<dsp:param name="id" param="empid"/>
		<dsp:oparam name="output">
		<dsp:getvalueof param="element" var="element"/>  
		<pre>
		Employee Id :      ${element.id}
		Employee Name :    ${element.empName}
		Employee Address : ${element.empAddress} 	
		Employee City :    ${element.empCity}
		Employee Dob  :    ${element.dob}
		Employee Age  :    ${element.age}
		</pre>
		</dsp:oparam>
		
		<dsp:oparam name="error">
		error
		</dsp:oparam>
		
		
		<dsp:oparam name="empty">
		empty
		
		
		</dsp:oparam>
		
	</dsp:droplet>
</dsp:page>
