package webServices_SOAP;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;
/*import utils.ExcelInteractions;*/
//import utils.ReadExcel;
import webServices_SOAP.SoapUIInteraction;

public class TestCase01 {

	//@Test
	public void GetSOAPMethod1() throws Exception {

		String soapURL = "https://rdtafeqa.carmax.org/tafe/v2/Service.svc?wsdl";
		String filePath =  System.getProperty("user.dir") +"/Files/samplerequest.xml";	
		
		
	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	         RestAssured.baseURI=soapURL;

	         Response response=given()
	        		 .request(Method.GET)
	                ;

	        XmlPath jsXpath= new XmlPath(response.asString());//Converting string into xml path to assert
	       
	        String rate=jsXpath.getString("GetConversionRateResult");
	        System.out.println("rate returned is: " +  rate);


	}
	
	//@Test
	public void GetSOAPMethod() throws Exception {

		String soapURL = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL";
		String filePath =  System.getProperty("user.dir") +"/Files/GetSubCategories.xml";	
		
		
	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	         RestAssured.baseURI=soapURL;

	         Response response=given()
	        		 .request(Method.GET)
	                ;

	        XmlPath jsXpath= new XmlPath(response.asString());//Converting string into xml path to assert
	       
	        String rate=jsXpath.getString("GetConversionRateResult");
	        System.out.println("rate returned is: " +  rate);


	}
	
	//@Test
	public void postSOAPMethod() throws Exception {

		String soapURL = "https://ctstsoa.stage.aa.com/ResolutionDiscoveryWeb/sca/ResolutionDiscoveryServiceV2";
		String filePath =  System.getProperty("user.dir") +"/Files/GetSubCategories.xml";	
		
		
	        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
	         RestAssured.baseURI="http://currencyconverter.kowabunga.net";

	         Response response=given()
	        		 
	                .header("Content-Type", "text/xml")
	                .and()
	                .body(IOUtils.toString(fileInputStream,"UTF-8"))
	         .when()
	            .post("/converter.asmx")
	         .then()
	                .statusCode(200)
	                .and()
	                .log().all()
	                .extract().response();

	        XmlPath jsXpath= new XmlPath(response.asString());//Converting string into xml path to assert
	        String rate=jsXpath.getString("GetConversionRateResult");
	        System.out.println("rate returned is: " +  rate);


	}
	
	
	//@Test
	public void ExecuteReasons() throws IOException
	{
		/*String soapURL = "https://ctstsoa.stage.aa.com/ResolutionDiscoveryWeb/sca/ResolutionDiscoveryServiceV2";
		ExcelInteractions excel = new ExcelInteractions();
		String excelData[][]= excel.getAllDataRowsFromSheet("CompensationMatrix","Reasons");
		PrintWriter writer = new PrintWriter(System.getProperty("user.dir") +"/Log/ExecuteReasons.txt", "UTF-8");		
		writer.println(ReadExcel.getCurrentDate());	


		//int num = excelData[0].length;
		boolean soapExecutionStatus = true; 
		for (int rowNum = 0; rowNum < excelData.length; rowNum++) {
			// System.out.println("Category Name:"+excelData[rowNum][0]);

			String filePath =  System.getProperty("user.dir") +"/Files/GetSubCategories.xml";			
			String soapXml = FileUtils.readFileToString(new File(filePath));
			String excelTypeDetails = excelData[rowNum][0];
			if(excelTypeDetails.equalsIgnoreCase("Else"))
			{
				break;
			}
			soapXml= soapXml.replace("CLAIMTYPEDETAILS", excelTypeDetails)
					.replace("&", "&amp;");
			SoapUIInteraction	objprocess = new SoapUIInteraction();
			String responseData =objprocess.SoapUIProcessing(soapURL, soapXml);

			//System.out.println(responseData);			
			for (int columnNum = 1; columnNum < excelData[rowNum].length; columnNum++) {
				if(!excelData[rowNum][columnNum].isEmpty()){					
					String columndata = "<ReasonName>"+excelData[rowNum][columnNum].trim()+"</ReasonName>";
					//System.out.println(columndata);
					if(!columndata.equals("<ReasonName></ReasonName>"))
					{
						if(!responseData.contains(columndata))							
						{
							System.out.println("response data donesnot exists for Category :"+excelData[rowNum][0]+ " and response: "+columndata);
							writer.println("response data donesnot exists for Category :"+excelData[rowNum][0]+ " and response: "+columndata);
							soapExecutionStatus = false;
						}
					}

				}

			}
		}

		if(soapExecutionStatus){
			writer.println("Pass");
			writer.close();
		}
		else{
			writer.println("Fail");
			writer.close();
			Assert.fail();
		}*/
	}

	@Test
	public void basicScript() throws IOException
	{
		/*String soapURL = "https://ctstsoa.stage.aa.com/ResolutionDiscoveryWeb/sca/ResolutionDiscoveryServiceV2";
		String filePath =  System.getProperty("user.dir") +"/Files/GetSubCategories.xml";	
		*/
		String soapURL = "https://rdtafeqa.carmax.org/tafe/v2/Service.svc?wsdl";
		String filePath =  System.getProperty("user.dir") +"/Files/samplerequest.xml";	
		
		
		
		String soapXml = FileUtils.readFileToString(new File(filePath));
		
		/*soapXml= soapXml.replace("CLAIMTYPEDETAILS", "")
				.replace("&", "&amp;");*/
		SoapUIInteraction	objprocess = new SoapUIInteraction();
		String responseData =objprocess.SoapUIProcessing(soapURL, soapXml);
	}

}