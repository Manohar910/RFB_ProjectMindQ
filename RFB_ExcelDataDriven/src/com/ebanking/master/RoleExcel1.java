package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RoleExcel1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Library lb = new Library();
		Library.Launch_Url("http://122.175.8.158/ranford2/");
		Library.Login_Admin("Admin", "Testing@");

		FileInputStream fis = new FileInputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_ExcelDataDriven\\src\\com\\ebanking\\testdata\\RoleExcelDatadriven.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("rData");

		int rCount = ws.getLastRowNum();
		System.out.println(rCount);

		for (int i = 1; i <= rCount; i++) {
			XSSFRow wr = ws.getRow(i);

			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.createCell(3);

			String rln = wc.getStringCellValue();
			String rds = wc1.getStringCellValue();
			String rtp = wc2.getStringCellValue();

			String res = Library.Role_Creation(rln, rds, rtp);
			System.out.println(res);
			wc3.setCellValue(res);
		}
		FileOutputStream fos = new FileOutputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_ExcelDataDriven\\src\\com\\ebanking\\results\\RlResu.xlsx");
		wb.write(fos);
		wb.close();
	}

}
