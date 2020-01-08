package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class items {

	@JacksonXmlProperty(localName="a:RuleCalculationResult")
	public List<RuleCalculationResult> ruleCalculationResult = new ArrayList<RuleCalculationResult>();

}
