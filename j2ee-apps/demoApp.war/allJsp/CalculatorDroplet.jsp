<%@taglib prefix="dsp"
uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:importbean bean="/com/droplet/CalculatorDroplet" />
 
<dsp:page>
  <div id="calculator">
     <dsp:droplet name="CalculatorDroplet">
        <dsp:param value="+" name="operator" />
        <dsp:param value="12,7" name="operands" />
        <dsp:oparam name="output">
            <dsp:valueof param="result" />
        </dsp:oparam>
     </dsp:droplet>
     <br/>
     <dsp:droplet name="CalculatorDroplet">
        <dsp:param value="-" name="operator" />
        <dsp:param value="12,7" name="operands" />
        <dsp:oparam name="output">
            <dsp:valueof param="result" />
        </dsp:oparam>
     </dsp:droplet>
     <br/>
     <dsp:droplet name="CalculatorDroplet">
        <dsp:param value="*" name="operator" />
        <dsp:param value="12,7" name="operands" />
        <dsp:oparam name="output">
           <dsp:valueof param="result" />
        </dsp:oparam>
     </dsp:droplet>
  </div>
</dsp:page>