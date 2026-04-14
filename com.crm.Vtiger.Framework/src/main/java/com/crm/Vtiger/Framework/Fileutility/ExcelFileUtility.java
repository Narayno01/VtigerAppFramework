package com.crm.Vtiger.Framework.Fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.Vtiger.Framework.ListenerUtility.IpathConstants;

public class ExcelFileUtility implements IpathConstants {

	public String getDataFromExcelFile(String Sheetname,int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream(Excelpath);

				Workbook wb=WorkbookFactory.create(fis1);
				Sheet sh=wb.getSheet(Sheetname);
				Row r=sh.getRow(rownum);
				Cell c=r.getCell(cellnum);
				
				String data=c.getStringCellValue();
		
		return data;
	}
	
	public int getDataFromExcel_Rowcount(String Sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream
				("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Testdata\\TestScriptmxjdata.xlsx");

				Workbook wb=WorkbookFactory.create(fis1);
				Sheet sh=wb.getSheet(Sheetname);
				int data=sh.getLastRowNum();
				return data;
				
		
	}
	
	public void setDataIntoExcelFile(String Sheetname,int rownum, int cellnum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis1=new FileInputStream
				("C:\\Users\\aDMIN\\eclipse-workspace\\com.Mavenselenium\\src\\test\\resources\\Testdata\\TestScriptmxjdata.xlsx");

				Workbook wb=WorkbookFactory.create(fis1);
				Sheet sh=wb.getSheet(Sheetname);
				Row row=sh.getRow(rownum);
				Cell cel=row.createCell(cellnum);
				//cel.setCellType(CellType.STRING);
				cel.setCellValue(data); 
				FileOutputStream fos= new FileOutputStream("C:\\Users\\aDMIN\\Desktop\\Data\\Testdata.xlsx");
				wb.write(fos);
				
				
	}
	

}
