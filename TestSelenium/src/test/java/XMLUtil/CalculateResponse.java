package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


/*@JsonIgnoreProperties(ignoreUnknown = true)*/
@XmlRootElement(name="CalculateResult")
public class CalculateResponse {
	public List<CalculateResult> calculateResult = new ArrayList<CalculateResult>();

}
