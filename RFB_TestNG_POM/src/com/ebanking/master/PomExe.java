package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

	@Test(dataProvider = "Bdata")
	public void Branch(String bN, String A1, String A2, String A3, String ar, String zp, String cnty, String st,
			String ct) throws InterruptedException {

		// Branch
		AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
		ahp.br();
		Thread.sleep(1000);
		BrDetailsPgPom bdp = PageFactory.initElements(driver, BrDetailsPgPom.class);
		bdp.nbr();
		Thread.sleep(1000);
		BrCreationPgPom bcp = PageFactory.initElements(driver, BrCreationPgPom.class);
		bcp.Branch(bN, A1, A2, A3, ar, zp, cnty, st, ct);

		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		bdp.bHome();
	}

	@DataProvider
	public Object[][] Bdata() {
		Object[][] obj = new Object[3][9];

		obj[0][0] = "Mjkjlkjsljk";
		obj[0][1] = "hghjgkh";
		obj[0][2] = "khjjlk";
		obj[0][3] = "jhkhlj";
		obj[0][4] = "hgjhgkhk";
		obj[0][5] = "76456";
		obj[0][6] = "INDIA";
		obj[0][7] = "Tamil Nadu";
		obj[0][8] = "CHENNAI";

		obj[1][0] = "Mjkhghglkjsljk";
		obj[1][1] = "hghhgjgjgkh";
		obj[1][2] = "khjhjjlk";
		obj[1][3] = "jhhhkhlj";
		obj[1][4] = "hghjhgkhk";
		obj[1][5] = "78456";
		obj[1][6] = "INDIA";
		obj[1][7] = "Tamil Nadu";
		obj[1][8] = "CHENNAI";

		obj[2][0] = "Mjfhgjgkjsljk";
		obj[2][1] = "hghjhgggkh";
		obj[2][2] = "khgjhgjjlk";
		obj[2][3] = "jhkhgfgfhlj";
		obj[2][4] = "hgjhgkhk";
		obj[2][5] = "76356";
		obj[2][6] = "INDIA";
		obj[2][7] = "Tamil Nadu";
		obj[2][8] = "CHENNAI";
		return obj;
	}

	@Test(dataProvider = "Rdata")
	public void Role(String rnm, String rd, String rty) throws InterruptedException {
		// Role
		AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
		ahp.rol();
		Thread.sleep(1000);
		RoleDetailsPgPom rdp = PageFactory.initElements(driver, RoleDetailsPgPom.class);
		rdp.nRl();
		Thread.sleep(1000);
		RoleCrPagePom rcp = PageFactory.initElements(driver, RoleCrPagePom.class);
		rcp.rcreation(rnm, rd, rty);

		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		rdp.rHome();
	}

	@DataProvider
	public Object[][] Rdata() {
		Object[][] obj = new Object[3][3];
		obj[0][0] = "jhkjkjhjk";
		obj[0][1] = "bkdhkjldj";
		obj[0][2] = "E";

		obj[1][0] = "jhkjkhghjjhjk";
		obj[1][1] = "bkdhhjghkjldj";
		obj[1][2] = "E";

		obj[2][0] = "jhkhjjkjhjk";
		obj[2][1] = "bkhhdhkjldj";
		obj[2][2] = "E";
		return obj;
	}

	@Test(dataProvider = "Edata")
	public void Employee(String enm, String lp, String rle, String brc) throws InterruptedException {
		// Employee
		AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
		ahp.emp();
		Thread.sleep(1000);
		EmpDetailsPgPom edp = PageFactory.initElements(driver, EmpDetailsPgPom.class);
		edp.nEmp();
		Thread.sleep(1000);
		EmpCrPagePom ecp = PageFactory.initElements(driver, EmpCrPagePom.class);
		ecp.empcr(enm, lp, rle, brc);

		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		edp.eHome();

	}

	@DataProvider
	public Object[][] Edata() {
		Object[][] obj = new Object[3][4];

		obj[0][0] = "hkjljdf";
		obj[0][1] = "hbkhjlkjlk";
		obj[0][2] = "jhkjkjhjk";
		obj[0][3] = "Mjkjlkjsljk";

		obj[1][0] = "hkjljhghgdf";
		obj[1][1] = "hbkhggjlkjlk";
		obj[1][2] = "jhkjkjhjk";
		obj[1][3] = "Mjkjlkjsljk";

		obj[2][0] = "hkjlghjdf";
		obj[2][1] = "hbkhhjjjlkjlk";
		obj[2][2] = "jhkjkjhjk";
		obj[2][3] = "Mjkjlkjsljk";
		return obj;

	}

}
