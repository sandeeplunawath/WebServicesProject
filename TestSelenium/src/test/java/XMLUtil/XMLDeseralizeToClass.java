package XMLUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLDeseralizeToClass {


	//@Test
	public void Sample_Bean() throws IOException {	

		XmlMapper xmlMapper = new XmlMapper();	
		SimpleBean value  = xmlMapper.readValue(ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/SampleBean.xml"), SimpleBean.class);	   
		System.out.println(value);
		
		
	}

	@Test
	public void Sample_Person() throws IOException {	

		XmlMapper xmlMapper = new XmlMapper();	
		Person value  = xmlMapper.readValue(ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/Employee.xml"), Person.class);	   
		System.out.println(value);
		
		
	}


	//@Test
	public void Sample2() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();	    
		Body value  = xmlMapper.readValue(ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/CalculateResponse.xml"), Body.class);	   
		System.out.println(value);
		
	}




	public String ReadDataFromXMLFileAndAssignRetunAsString(String filePath)
	{
		String XML_STRING = null;
		try {		    	
			Path xmlDocPath = Paths.get(filePath);
			XML_STRING = Files.lines(xmlDocPath).collect(Collectors.joining("\n"));
			//System.out.println(XML_STRING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return XML_STRING;

	}

}
