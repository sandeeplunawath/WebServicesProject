package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class BasicItem {

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<RuleCalculationResult> ruleCalculationResult = new ArrayList<RuleCalculationResult>();
}
