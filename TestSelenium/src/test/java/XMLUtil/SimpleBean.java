package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@JsonIgnoreProperties(ignoreUnknown = true)
*/
@Getter @Setter @NoArgsConstructor
public  class SimpleBean {
	public String firstName;
	public String lastName;
	
	//@JacksonXmlProperty(localName="teacher")
	public Teacher teacher[] = {new Teacher()};

}
