package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      Library lb=new Library();
      String lUrl=lb.Launch_Url("http://primusbank.qedgetech.com/");
	  System.out.println(lUrl);
	  
	  lb.Login_Admin("Admin", "Admin");
	  
	  FileInputStream fis=new FileInputStream("D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_PrimusBank\\src\\com\\ebanking\\testdata\\Role.xlsx");
	  
	  // Workbook
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  
	  // Sheet
	  XSSFSheet ws=wb.getSheet("Rdata");
	  
	  // Role count
	  int rCount=ws.getLastRowNum();
	  System.out.println(rCount);
	  
	  // Multiple iterations.... loop
	  for(int i=1; i<=rCount; i++) {
		  
		  // Row
		  XSSFRow wr=ws.getRow(i);
		  
		  // Cell
		  XSSFCell wc=wr.getCell(0);
		  XSSFCell wc1=wr.getCell(1);
		  XSSFCell wc2=wr.getCell(2);
		  XSSFCell wc3=wr.createCell(3);
		  
		  // Cell values
		  String role=wc.getStringCellValue();
		  String rDesc=wc1.getStringCellValue();
		  String rType=wc2.getStringCellValue();
		  
		String res=lb.Role_Creation(role, rDesc, rType);
		System.out.println(res);
		wc3.setCellValue(res);
	  }
	  FileOutputStream fos=new FileOutputStream("D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_PrimusBank\\src\\com\\ebanking\\results\\Res_role.xlsx");
      wb.write(fos);
      wb.close();
	}

}
