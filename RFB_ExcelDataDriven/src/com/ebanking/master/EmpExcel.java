package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmpExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		  @SuppressWarnings("unused")
		Library lb=new Library();
		
		  String lUrl=Library.Launch_Url("http://122.175.8.158/ranford2/");
		  System.out.println(lUrl);
		  
		  Library.Login_Admin("Admin", "Testing@");
		  
		  FileInputStream fis=new FileInputStream("C:\\Users\\jc\\git\\MySeleniumProjects\\Ebanking_PrimusBank\\src\\com\\ebanking\\testdata\\emp123.xlsx");
	
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  
		  XSSFSheet ws=wb.getSheet("Sheet1");
		  
		  int rCount=ws.getLastRowNum();
		  System.out.println(rCount);
		  
		  for(int i=1;i<=rCount;i++) {
			  
			  XSSFRow wr=ws.getRow(i);
			  
			  XSSFCell wc=wr.getCell(0);
			  XSSFCell wc1=wr.getCell(1);
			  XSSFCell wc2=wr.getCell(2);
			  XSSFCell wc3=wr.getCell(3);
			 XSSFCell wc4=wr.createCell(4);
			 
			  String en=wc.getStringCellValue();
			  String lp=wc1.getStringCellValue();
			  String rl=wc2.getStringCellValue();
			  String br=wc3.getStringCellValue();
			  
			  String res=Library.Employee_Creation(en,lp,rl,br);
			  System.out.println(res);
			  wc4.setCellValue(res);
			  
			  FileOutputStream fos=new FileOutputStream("C:\\Users\\jc\\git\\MySeleniumProjects\\Ebanking_PrimusBank\\src\\com\\ebanking\\results\\emp1_res.xlsx");
		  
			  wb.write(fos);
			  wb.close();
		  
		  }
		  
	}

}
