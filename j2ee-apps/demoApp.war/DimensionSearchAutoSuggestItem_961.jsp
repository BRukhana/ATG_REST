<%-- To see autosuggest items pass Ntt query parameter like "bla*" --%>
ganesh escrowdds 
<%@ taglib uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0" prefix="dsp" %>

<dsp:page>
	
<dsp:getvalueof var="contextPath" bean="/OriginatingRequest.contextPath" />
<dsp:importbean bean="/atg/endeca/assembler/droplet/InvokeAssembler"/>
<dsp:droplet name="InvokeAssembler">
<dsp:param name="contentCollection" value="/content/Web/AutoSuggest/AutoSuggestPage"/>
  <dsp:param name="Dy"  value="1"/>
  <c:set var="itemNum" value="${0}" />
   <dsp:oparam name="output">
   ganpati
    <dsp:getvalueof vartype="com.endeca.infront.assembler.ContentItem" param="contentItem" var="autoSuggestItems"/> @@@${autoSuggestItems}@@@
	<dsp:getvalueof  value="${autoSuggestItems.contents[0]}" var="content"/>!!!${content}!!!
	<dsp:getvalueof  value="${content['autoSuggest']}" var="autoSuggestresults"/>	&&&${autoSuggestresults}&&&
	 -mm--${autoSuggestresults[0].dimensionSearchGroups}-mmm--
	 	 	<c:forEach var="dimensionSearchGroups" items="${autoSuggestresults[0].dimensionSearchGroups}">
-####-${dimensionSearchGroups.dimensionName}-	
	<c:set var="itemNum" value="${itemNum+1}" />
		</c:forEach>
  </dsp:oparam>
</dsp:droplet>
</dsp:page>