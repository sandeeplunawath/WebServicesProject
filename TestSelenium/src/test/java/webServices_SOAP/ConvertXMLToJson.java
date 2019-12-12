package webServices_SOAP;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.json.XML;

public class ConvertXMLToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String XML_STRING = null;
		try {		    	
			Path xmlDocPath = Paths.get(System.getProperty("user.dir") +"/Files/CalculateResponse.xml");
			XML_STRING = Files.lines(xmlDocPath).collect(Collectors.joining("\n"));
			//System.out.println(XML_STRING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		convertjson(XML_STRING );
	}

	public static void convertjson(String xmlFormattedString)
	{		
		//converting xml to json
		JSONObject JsonXmlObj = XML.toJSONObject(xmlFormattedString);
		System.out.println(JsonXmlObj.toString());
	}
}
