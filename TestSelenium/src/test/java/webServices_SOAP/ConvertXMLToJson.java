package webServices_SOAP;
import org.json.JSONObject;
import org.json.XML;

import XMLUtil.XMLDeseralizeToClass;

public class ConvertXMLToJson {

	public static void main(String[] args) {
		XMLDeseralizeToClass obj = new XMLDeseralizeToClass();		
		convertjson(obj.ReadDataFromXMLFileAndAssignRetunAsString(System.getProperty("user.dir") +"/Files/CalculateResponse.xml"));
	}

	public static void convertjson(String xmlFormattedString)
	{		
		//converting xml to json
		JSONObject JsonXmlObj = XML.toJSONObject(xmlFormattedString);
		System.out.println(JsonXmlObj.toString());
	}
}
