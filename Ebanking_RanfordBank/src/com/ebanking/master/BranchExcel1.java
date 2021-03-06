package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BranchExcel1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Library lb = new Library();
		Library.Launch_Url("http://122.175.8.158/ranford2/");
		Library.Login_Admin("Admin", "Testing@");

		FileInputStream fis = new FileInputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_RanfordBank\\src\\com\\ebanking\\testdata\\RanBranchSh2.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet2");

		int rCount = ws.getLastRowNum();
		System.out.println(rCount);

		for (int i = 1; i <= rCount; i++) {
			XSSFRow wr = ws.getRow(i);

			XSSFCell wc = wr.getCell(0);		
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			XSSFCell wc4 = wr.getCell(4);
			XSSFCell wc5 = wr.getCell(5);
			XSSFCell wc6 = wr.getCell(6);
			XSSFCell wc7 = wr.getCell(7);
			XSSFCell wc8 = wr.getCell(8);
			XSSFCell wc9 = wr.createCell(9);

			String bn = wc.getStringCellValue();
			String ad1 = wc1.getStringCellValue();
			String ad2 = wc2.getStringCellValue();
			String ad3 = wc3.getStringCellValue();
			String ar = wc4.getStringCellValue();
			String zp = wc5.getStringCellValue();
			String cnt = wc6.getStringCellValue();
			String st = wc7.getStringCellValue();
			String ct = wc8.getStringCellValue();

			
			String res = Library.Branch_Creation(bn, ad1, ad2, ad3, ar, zp, cnt, st, ct);
			System.out.println(res);
			wc9.setCellValue(res);
		}
		FileOutputStream fos = new FileOutputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_RanfordBank\\src\\com\\ebanking\\results\\BranchRan2.xlsx");
		wb.write(fos);
		wb.close();
	}

}
