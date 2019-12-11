package webServices_SOAP;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import junit.framework.Assert;
/*import utils.ExcelInteractions;*/
//import utils.ReadExcel;
import webServices_SOAP.SoapUIInteraction;

public class TestCase01 {

	@Test
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
		String soapURL = "https://ctstsoa.stage.aa.com/ResolutionDiscoveryWeb/sca/ResolutionDiscoveryServiceV2";
		String filePath =  System.getProperty("user.dir") +"/Files/GetSubCategories.xml";			
		String soapXml = FileUtils.readFileToString(new File(filePath));
		
		soapXml= soapXml.replace("CLAIMTYPEDETAILS", "")
				.replace("&", "&amp;");
		SoapUIInteraction	objprocess = new SoapUIInteraction();
		String responseData =objprocess.SoapUIProcessing(soapURL, soapXml);
	}

}