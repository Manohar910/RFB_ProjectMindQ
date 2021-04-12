package com.ebanking.testngbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgBasic {

	static WebDriver driver;
	static String Expval1, Actval1;

	@BeforeSuite
	public static void SetUp() {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Launch
		// String Expval1 = "Primus Bank";
		driver.get("http://primusbank.qedgetech.com/");

		// String Actval1 = driver
		// .findElement(By
		// .xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span"))
		// .getText();
		// Comparision
		// if (Expval1.equalsIgnoreCase(Actval1)) {
		// System.out.println("Application launched successfully");
		// } else {
		// System.out.println("Application launched to failed");
		// }

		// Login
		// @BeforeMethod
		// public void Admin_Login() throws Exception {
		String Expval1 = "Welcome to Admin";
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		// Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		// Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		String Actval1 = driver
				.findElement(By.xpath(
						"/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font"))
				.getText();

		// Comparision
		if (Expval1.equalsIgnoreCase(Actval1)) {
			System.out.println("Admin login successfully");
		} else {
			System.out.println("Admin login failed");
		}
	}

	@Test(enabled = true, priority = 1, groups = "branch")
	public static void Branches() throws Exception {
		// Branches
		Expval1 = "Sucessfully";
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='BtnNewBR']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"txtbName\"]")).sendKeys("Yogendra");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtAdd1\"]")).sendKeys("Nellore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Txtadd2\"]")).sendKeys("Kavali");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtadd3\"]")).sendKeys("Jaladanki");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtArea\"]")).sendKeys("Kvl");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtZip\"]")).sendKeys("64768");
		Thread.sleep(1000);

		Select cntry = new Select(driver.findElement(By.xpath("//*[@id=\"lst_counrtyU\"]")));
		cntry.selectByVisibleText("INDIA"); // method1
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//*[@id=\"lst_stateI\"]"))).selectByVisibleText("Andhra Pradesh");
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//*[@id=\"lst_cityI\"]"))).selectByVisibleText("Hyderabad");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"btn_insert\"]")).click();
		Thread.sleep(1000);
		Actval1 = driver.switchTo().alert().getText();

		// Comparision
		if (Actval1.contains(Expval1)) {
			System.out.println("Branch created");
		} else {
			System.out.println("Branch already existed");
		}
		driver.switchTo().alert().accept();

	}

	@Test(enabled = true, priority = 2, groups = "Role")
	// Roles
	public static void Roles() throws Exception {
		Expval1 = "Successfully";
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"btnRoles\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtRname\"]")).sendKeys("RestApiTester");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtRDesc\"]")).sendKeys("sample");
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//*[@id=\"lstRtypeN\"]"))).selectByVisibleText("E");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"btninsert\"]")).click();
		Actval1 = driver.switchTo().alert().getText();
		if (Actval1.contains(Expval1)) {
			System.out.println("Role created successfully");
		} else {
			System.out.println("Role already existed");
		}
		driver.switchTo().alert().accept();
	}

	@Test(enabled = true, priority = 3, groups = "Employee")
	public static void Employee() throws Exception {
		// Employee
		Expval1 = "Successfully";
		driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"BtnNew\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("ManoharSv");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtLpwd\"]")).sendKeys("Manohar910");
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//*[@id=\"lst_Roles\"]"))).selectByVisibleText("RestApiTester");
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//*[@id=\"lst_Branch\"]"))).selectByVisibleText("Yogendra");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"BtnSubmit\"]")).click();
		Thread.sleep(1000);
		Actval1 = driver.switchTo().alert().getText();

		if (Actval1.contains(Expval1)) {
			System.out.println("Employee created");
		} else {
			System.out.println("Employee already existed");
		}
		driver.switchTo().alert().accept();

		// driver.findElement(By.xpath(
		// "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img"))
		// .click();
		// Thread.sleep(1000);
	}

	@AfterMethod
	public static void Logout() {
		// LogOut
		driver.findElement(By.xpath(
				"/html/body/form/div[3]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img"))
				.click();
		System.out.println("Logout successfully");
	}

}
