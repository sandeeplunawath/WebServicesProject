package XMLClassFiles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


/*@JsonIgnoreProperties(ignoreUnknown = true)*//*
@XmlRootElement(name="CalculateResult")*/

public class BodyClass {
	
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<CalculateResponseClass> CalculateResponse = new ArrayList<CalculateResponseClass>();

}
