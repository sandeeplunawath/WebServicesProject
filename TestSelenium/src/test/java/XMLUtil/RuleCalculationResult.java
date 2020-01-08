package XMLUtil;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RuleCalculationResult {

	@JacksonXmlProperty(namespace="a:CalculationId")
	public String CalculationId;
	
	@JacksonXmlProperty(namespace="a:CalculationType")
	public String CalculationType;
}
