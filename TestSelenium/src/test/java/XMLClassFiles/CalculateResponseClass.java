package XMLClassFiles;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


public class CalculateResponseClass {

	@JacksonXmlElementWrapper(useWrapping = false)
	public List<CalculateResultClass> CalculateResult = new ArrayList<CalculateResultClass>();
	
}
