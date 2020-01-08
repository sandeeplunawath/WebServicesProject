package XMLClassFiles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateResultClass {
	
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<ItemsClass> Items = new ArrayList<ItemsClass>();

}
