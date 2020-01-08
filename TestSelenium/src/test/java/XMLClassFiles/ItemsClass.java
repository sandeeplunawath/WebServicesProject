package XMLClassFiles;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class ItemsClass {

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<RuleCalculationResultClass> RuleCalculationResult = new ArrayList<RuleCalculationResultClass>();
}
