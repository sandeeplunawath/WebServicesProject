package ExcelUtil;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



public class ExcelUtils {


	String workbookpath = System.getProperty("user.dir")+"/TestData/Excel/";
//	String storeState = "";
//	String scenario = "";
//	String customerState = "";
//	String storeId = "";
//	String effectiveDate = "";
//	String Status_check = "";
	String[] inputDetails = new String[] {"Scenario","Store_State","Customer_State","Store_Location_Number","Effective_Date","Status"};
	static HashMap<String, HashMap<String, String>> inputExcelDetails = new HashMap<String, HashMap<String, String>>();

	ExcelUtils(String excelFileName)
	{
		workbookpath = workbookpath+ excelFileName;
	}
	
	@Test
	public  void testMethod1() {
		//System.out.println("yes work");
		//	ExcelRead objTest = new ExcelRead();
		new ExcelUtils("TAFE_Scenarios.xlsx").getSheetDetails("Input");
		System.out.println(inputExcelDetails);
	}

	public void getSheetDetails(String sheetName) 
	{
		for (int excelRowNum = 0; excelRowNum < GetRowCount(sheetName); excelRowNum++) 
		{
			Row row=GetRow(sheetName, excelRowNum);
			//System.out.println(excelRowNum);
			HashMap<String, String> inputRowDetails = new HashMap<String, String> ();
			for (int columnNames = 1; columnNames < inputDetails.length; columnNames++) 
			{
				String inputColumnName = inputDetails[columnNames];
			//	System.out.println(inputColumnName);
				Cell celDetails=row.getCell(getColoumnIndex(inputColumnName, sheetName));
				String inputColumnValue =null;
				if(celDetails != null)
				{
					celDetails.setCellType(Cell.CELL_TYPE_STRING);
					inputColumnValue = celDetails.getStringCellValue().toString();	
				}
				inputRowDetails.put(inputColumnName, inputColumnValue);
			}

			Cell celDetailsScenarioName=row.getCell(getColoumnIndex("Scenario", sheetName));
			if(celDetailsScenarioName != null)
			{
				celDetailsScenarioName.setCellType(Cell.CELL_TYPE_STRING);
				String scenarioName = celDetailsScenarioName.getStringCellValue().toString();	
				inputExcelDetails.put(scenarioName, inputRowDetails);
			}
		}

	}


	public Row GetRow(String sheetName,int RowNo) 
	{
		File file=new File(workbookpath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(RowNo);
		return row;
	}

	public int GetRowCount(String sheetName) 
	{
		File file=new File(workbookpath);
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetName);
		return sheet.getLastRowNum();
	}

	public int getColoumnIndex(String colName,String sheetName) 
	{	 
		int colIndex=0;
		File file=new File(workbookpath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Workbook wb=null;
		try{
			wb= WorkbookFactory.create(fis);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Sheet sheet=wb.getSheet(sheetName);
		//To read the header row in the Excel
		Row row=sheet.getRow(0);

		for (colIndex = 0; colIndex < row.getPhysicalNumberOfCells(); colIndex++) {
			try{
				String cell=row.getCell(colIndex).getStringCellValue();
				if (cell != null) {
					if ( cell.equalsIgnoreCase(colName)) {
						break;
					}
				}else{
					System.out.println("coloumn with name: "+colName+" not found in "+sheetName+" table");
				}
			}
			catch(Exception e)
			{
				System.out.println("in catch block"+e.getMessage());

			}
		}
		return colIndex;

	}


}
