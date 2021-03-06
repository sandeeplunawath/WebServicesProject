package XMLClassFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLDeseralizeToClass {

	private String filePath;
	public XMLDeseralizeToClass FilePath(String XMLfilePath)
	{
		filePath = XMLfilePath;
		return this;
	}
	

	//@Test
	public void Sample_Person() throws IOException {	

		
		XmlMapper xmlMapper = new XmlMapper();	
		
		String xmlContent = ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/CalculateResponse1.xml");
		xmlContent = xmlContent
		.replaceAll("<s:", "<")
		.replaceAll("</s:", "</")
		.replaceAll("<a:", "<")
		.replaceAll("</a:", "</")
		.replaceAll("<Tag i:nil=\"true\"/>"," <Tag>null</Tag>")
		
		;
		
		
		EnvelopeClass value  = xmlMapper.readValue(xmlContent, EnvelopeClass.class);	
		List<RuleCalculationResultClass>  objte =  value.Body.get(0).CalculateResponse.get(0).CalculateResult.get(0).Items.get(0).RuleCalculationResult;
		System.out.println(value);
		
		
	}
	
	@Test
	public void ConvertClassObjectToString() throws IOException {	

		
		XmlMapper xmlMapper = new XmlMapper();	
		
		String xmlContent = ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/CalculateResponse1.xml");
		xmlContent = xmlContent
		.replaceAll("<s:", "<")
		.replaceAll("</s:", "</")
		.replaceAll("<a:", "<")
		.replaceAll("</a:", "</")
		.replaceAll("<Tag i:nil=\"true\"/>"," <Tag>null</Tag>")
		
		;
		
		
		EnvelopeClass value  = xmlMapper.readValue(xmlContent, EnvelopeClass.class);	
		List<RuleCalculationResultClass>  objte =  value.Body.get(0).CalculateResponse.get(0).CalculateResult.get(0).Items.get(0).RuleCalculationResult;
		
		
		 String xml = xmlMapper.writeValueAsString(value);
		 System.out.println(xml);
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



