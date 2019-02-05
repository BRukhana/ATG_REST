<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
<dsp:importbean bean="/com/training/Person" />

First Name :<dsp:valueof bean="Person.firstName"/>

Last Name : <dsp:valueof bean="Person.lastName"/>



Using EL 

<dsp:getvalueof bean="Person" var="Person"/>

FirstName : ${Person.firstName}
Last Name : ${Person.lastName}
 


</dsp:page>




