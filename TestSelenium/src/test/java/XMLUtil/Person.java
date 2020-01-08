package XMLUtil;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


public class Person {
	public String firstName;
	public String lastName;
	public List<String> phoneNumbers = new ArrayList<>();
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Address> address = new ArrayList<>();
	
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<BasicItem> basicItem = new ArrayList<BasicItem>();
	
	
}

