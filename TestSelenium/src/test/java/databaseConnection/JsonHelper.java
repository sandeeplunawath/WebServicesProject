package databaseConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
public class JsonHelper {

	public boolean CompareTwoJSONObject(JSONObject jsonObj1, JSONObject jsonObj2)
	{
		String actualValue = "";
		String expectedValue = "";
		String key = "";
		boolean isMatching = true;
		if(jsonObj1.length() != jsonObj2.length())
		{
			isMatching = false;
			System.out.println("Number of records do not match.");
			System.out.println("The response from first JSONObject is " + jsonObj1);
			System.out.println("The response from second JSONObject is " + jsonObj2);
		}
		else
		{
			System.out.println("Count of records matches. The count is " + jsonObj1.length());
			for(int i = 0; i < jsonObj1.length(); i++)
			{
				key = jsonObj1.names().getString(i);
				actualValue = String.valueOf(jsonObj1.get(key)).trim();
				expectedValue = String.valueOf(jsonObj2.get(key));
				expectedValue = expectedValue.trim();

				if(actualValue.equals(expectedValue))
				{
					System.out.println("Actual Value " + actualValue + " is matching with expected value " + expectedValue + " for key " + key);
				}
				else
				{
					System.out.println("Actual Value " + actualValue + " is NOT matching with expected value " + expectedValue + " for key " + key);
					isMatching = false;
				}
			}
		}
		return isMatching;

	}

	//applicable only for one row of data
	public JSONObject convertResultSetToJson(ResultSet resultSet) throws SQLException
	{
		ResultSetMetaData metadata = resultSet.getMetaData();
		int numColumns = metadata.getColumnCount();
		JSONObject obj = new JSONObject();
		while(resultSet.next())             //iterate rows
		{
			//extends HashMap
			for (int i = 1; i <= numColumns; ++i)           //iterate columns
			{
				String column_name = metadata.getColumnName(i);
				obj.put(column_name, resultSet.getString(column_name));
			}
		}
		return obj;
	}

	public String ReadJSONArray(JSONObject jsonObj, String arrKey)
	{
		JSONArray arrObj = jsonObj.getJSONArray(arrKey);
		System.out.println(arrKey);
		String result = "";
		for(int i = 0; i <= arrObj.length()-1; i++)
		{
			result = result + arrObj.getString(i) + ":";
		}
		return result;
	}

	//	    public String ReadJSONObject(JSONObject jsonObj, String arrKey)
	//
	//	       {
	//	            //JSONObject jsonObject = new JSONObject(JSON);
	//	            JSONObject newjsonObj = jsonObj.getJSONObject("LanguageLevels");
	//	            
	//	       }


	//applicable for multiple rows of data
	public String convertResultSetToString(ResultSet resultSet) throws SQLException
	{
		ResultSetMetaData metadata = resultSet.getMetaData();
		int numColumns = metadata.getColumnCount();
		String result = "";
		while(resultSet.next())             //iterate rows
		{
			//extends HashMap
			for (int i = 1; i <= numColumns; ++i)           //iterate columns
			{
				String column_name = metadata.getColumnName(i);
				result = result + column_name + ":" + resultSet.getString(column_name) + "|";
			}
		}
		return result;
	}

	public String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/java/com/qa/Data/" + fileName));
		//
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			System.out.println("The response from API is " + sb.toString());
			return sb.toString();
		} finally {
			br.close();
		}
	}

	public void ConvertJsonToXmlFile(String jsonFile, String xmlfile) throws IOException {
		String jsonPath = System.getProperty("user.dir") + "/src/main/java/com/qa/Data/" +jsonFile+ ".json";
		String xmlPath = System.getProperty("user.dir") + "/src/main/java/com/qa/Data/"+xmlfile+".xml";
		String jsonStr = new String(Files.readAllBytes(Paths.get(jsonPath)));
		JSONObject jsonObj = new JSONObject(jsonStr); 

		//JSONArray jsonA = new JSONArray(jsonStr);

		FileWriter fileWriter = new FileWriter(xmlPath);
		fileWriter.write(XML.toString(jsonObj, "Student"));
		fileWriter.close();

	}
}
