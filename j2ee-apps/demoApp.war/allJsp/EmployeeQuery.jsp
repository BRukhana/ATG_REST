<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>


<dsp:droplet name="/atg/dynamo/droplet/RQLQueryForEach">
  <dsp:param name="queryRQL" value="empCity='Mumbai'"/>
  <dsp:param name="repository"
  value="/com/logixal/training/properties/EmployeeProfileRepository/"/>
  <dsp:param name="itemDescriptor" value="employee"/>
  <dsp:oparam name="output">
    <p><dsp:valueof param="element.empName"/>
  </dsp:oparam>
</dsp:droplet>

</dsp:page>


