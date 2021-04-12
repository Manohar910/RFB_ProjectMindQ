package com.ebanking.master;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {

	WebDriver driver;
	String Expval, Actval;
	FileInputStream fis;
	Properties pro;

	public String Launch_Url(String URL) throws Exception {

		fis = new FileInputStream(
				"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\Ebanking_PrimusBank\\src\\com\\ebanking\\properties\\PBanking.properties");
		pro = new Properties();
		pro.load(fis);

		String Expval = "Primus Bank";
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// URL
		driver.get(URL);

		String Actval = driver.findElement(By.xpath(pro.getProperty("pExpval"))).getText();
		// Comparision
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Application launched successfully");
		} else {
			System.out.println("Application launched to failed");
		}
		return "pass";
	}

	public String Login_Admin(String un, String pwd) throws InterruptedException {

		Expval = "Welcome to Admin";
		driver.findElement(By.xpath(pro.getProperty("uName"))).sendKeys(un);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("pswd"))).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("lgbtn"))).click();
		Actval = driver.findElement(By.xpath(pro.getProperty("adminExval"))).getText();

		// Comparision
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Admin login successfully");
		} else {
			System.out.println("Admin login failed");
		}
		Thread.sleep(1000);
		return "pass";

	}

	public String Branch_Creation(String bName, String Add1, String Add2, String Add3, String area, String zip,
			String country, String st, String cty) throws InterruptedException {

		Expval = "Sucessfully";
		driver.findElement(By.xpath(pro.getProperty("bButton"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("nBranch"))).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(pro.getProperty("bName"))).sendKeys(bName);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("add1"))).sendKeys(Add1);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("add2"))).sendKeys(Add2);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("add3"))).sendKeys(Add3);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("Area"))).sendKeys(area);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("zip"))).sendKeys(zip);
		Thread.sleep(1000);

		Select cn = new Select(driver.findElement(By.xpath(pro.getProperty("country"))));
		cn.selectByVisibleText(country); // method1
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(pro.getProperty("state")))).selectByVisibleText(st);
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(pro.getProperty("city")))).selectByVisibleText(cty);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("branchSubmit"))).click();
		Thread.sleep(1000);
		Actval = driver.switchTo().alert().getText();

		// Comparision
		if (Actval.contains(Expval)) {
			System.out.println("Branch created");
		} else {
			System.out.println("Branch already existed");
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(pro.getProperty("bHome"))).click();
		Thread.sleep(1000);
		return "pass";

	}

	public String Role_Creation(String role, String rDesc, String rType) throws InterruptedException {
		Expval = "Successfully";
		driver.findElement(By.xpath(pro.getProperty("rButton"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("nRole"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("rollName"))).sendKeys(role);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("rDesc"))).sendKeys(rDesc);
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(pro.getProperty("rType")))).selectByVisibleText(rType);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("roleSubmit"))).click();
		Actval = driver.switchTo().alert().getText();
		if (Actval.contains(Expval)) {
			System.out.println("Role created successfully");
		} else {
			System.out.println("Role already existed");
		}
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(pro.getProperty("rollHome"))).click();
		return Actval;

	}

	public String Employee_Creation(String empName, String lgpswd, String role, String branch)
			throws InterruptedException {
		Expval = "Successfully";
		driver.findElement(By.xpath(pro.getProperty("empButton"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("nEmp"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("empName"))).sendKeys(empName);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("lgnpswd"))).sendKeys(lgpswd);
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(pro.getProperty("role")))).selectByVisibleText(role);
		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath(pro.getProperty("branch")))).selectByVisibleText(branch);
		Thread.sleep(1000);
		driver.findElement(By.xpath(pro.getProperty("empSubmit"))).click();
		Thread.sleep(1000);
		Actval = driver.switchTo().alert().getText();

		if (Actval.contains(Expval)) {
			System.out.println("Employee created");
		} else {
			System.out.println("Employee already existed");
		}
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath(pro.getProperty("empHome"))).click();
		Thread.sleep(1000);
		return "pass";

	}

	public void LogOut() {
		driver.findElement(By.xpath(pro.getProperty("lgout"))).click();
		System.out.println("Logout successfully");

	}

	public void Close() {
		driver.close();
	}

}
