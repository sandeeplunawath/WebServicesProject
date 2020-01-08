package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


/*@JsonIgnoreProperties(ignoreUnknown = true)*/
@XmlRootElement(name="a:Items")
public class CalculateResult {
	@JacksonXmlProperty(localName="a:Items")
	public List<items> Item = new ArrayList<items>();

}
