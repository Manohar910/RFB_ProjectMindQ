package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PomExe {
	WebDriver driver;

	@BeforeTest
	public void Login() throws InterruptedException {

		driver = new FirefoxDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("http://122.175.8.158/ranford2/");
		Thread.sleep(1000);
		RFHomepagePom rfh = PageFactory.initElements(driver, RFHomepagePom.class);
		rfh.Login();
	}

	@Test
	public void Branch(String bN, String A1, String A2, String A3, String ar, String zp, String cnty, String st,
			String ct) throws InterruptedException, IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_RanfordBank\\src\\com\\ebanking\\testdata\\RanBranchSh2.xlsx");

		@SuppressWarnings("resource")
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
			// XSSFCell wc9 = wr.createCell(9);

			String bn = wc.getStringCellValue();
			String ad1 = wc1.getStringCellValue();
			String ad2 = wc2.getStringCellValue();
			String ad3 = wc3.getStringCellValue();
			String ar1 = wc4.getStringCellValue();
			String zp1 = wc5.getStringCellValue();
			String cnt1 = wc6.getStringCellValue();
			String st1 = wc7.getStringCellValue();
			String ct1 = wc8.getStringCellValue();

			// Branch
			AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
			ahp.br();
			Thread.sleep(1000);
			BrDetailsPgPom bdp = PageFactory.initElements(driver, BrDetailsPgPom.class);
			bdp.nbr();
			Thread.sleep(1000);
			BrCreationPgPom bcp = PageFactory.initElements(driver, BrCreationPgPom.class);
			bcp.Branch(bn, ad1, ad2, ad3, ar1, zp1, cnt1, st1, ct1);

			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			bdp.bHome();
		}
	}

	@Test
	public void Role(String rnm, String rd, String rty) throws InterruptedException, IOException {
		// Role
		FileInputStream fis = new FileInputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_ExcelDataDriven\\src\\com\\ebanking\\testdata\\RFB_BranchDataDriven.xlsx");

		// Workbook
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet
		XSSFSheet ws = wb.getSheet("Sheet3");

		// Role count
		int rCount = ws.getLastRowNum();
		System.out.println(rCount);

		// Multiple iterations.... loop
		for (int i = 1; i <= rCount; i++) {

			// Row
			XSSFRow wr = ws.getRow(i);

			// Cell
			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			// XSSFCell wc3 = wr.createCell(3);

			// Cell values
			String role1 = wc.getStringCellValue();
			String rDesc1 = wc1.getStringCellValue();
			String rType1 = wc2.getStringCellValue();

			AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
			ahp.rol();
			Thread.sleep(1000);
			RoleDetailsPgPom rdp = PageFactory.initElements(driver, RoleDetailsPgPom.class);
			rdp.nRl();
			Thread.sleep(1000);
			RoleCrPagePom rcp = PageFactory.initElements(driver, RoleCrPagePom.class);
			rcp.rcreation(role1, rDesc1, rType1);

			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			rdp.rHome();
		}
	}

	@Test
	public void Employee(String enm, String lp, String rle, String brc) throws InterruptedException, IOException {
		// Employee
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\jc\\git\\MySeleniumProjects\\Ebanking_PrimusBank\\src\\com\\ebanking\\testdata\\emp123.xlsx");

		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet ws = wb.getSheet("Sheet1");

		int rCount = ws.getLastRowNum();
		System.out.println(rCount);

		for (int i = 1; i <= rCount; i++) {

			XSSFRow wr = ws.getRow(i);

			XSSFCell wc = wr.getCell(0);
			XSSFCell wc1 = wr.getCell(1);
			XSSFCell wc2 = wr.getCell(2);
			XSSFCell wc3 = wr.getCell(3);
			// XSSFCell wc4=wr.createCell(4);

			String en = wc.getStringCellValue();
			String lp1 = wc1.getStringCellValue();
			String rl = wc2.getStringCellValue();
			@SuppressWarnings("unused")
			String br = wc3.getStringCellValue();

			AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
			ahp.emp();
			Thread.sleep(1000);
			EmpDetailsPgPom edp = PageFactory.initElements(driver, EmpDetailsPgPom.class);
			edp.nEmp();
			Thread.sleep(1000);
			EmpCrPagePom ecp = PageFactory.initElements(driver, EmpCrPagePom.class);
			ecp.empcr(en, lp1, rl, brc);

			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			edp.eHome();

		}

	}
}
