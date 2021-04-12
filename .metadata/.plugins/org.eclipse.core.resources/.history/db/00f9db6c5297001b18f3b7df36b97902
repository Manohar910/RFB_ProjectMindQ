package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid1 {
	DesiredCapabilities Cap;

	@Parameters("Browser")
	@Test
	public void GD(String BR) throws MalformedURLException, InterruptedException {
		if (BR.equalsIgnoreCase("firefox")) {
			Cap = new DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);
		} else if (BR.equalsIgnoreCase("chrome")) {
			Cap = new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.WINDOWS);

		}

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.108:4444/wd/hub"), Cap);
		driver.manage().window().maximize();
		// System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		driver.get("http://122.175.8.158/ranford2/");

		RFHomepagePom rfh = PageFactory.initElements(driver, RFHomepagePom.class);
		rfh.Login();

		AdminHomePagePom ahp = PageFactory.initElements(driver, AdminHomePagePom.class);
		ahp.rol();
		Thread.sleep(1000);
		RoleDetailsPgPom rdp = PageFactory.initElements(driver, RoleDetailsPgPom.class);
		rdp.nRl();
		Thread.sleep(1000);
		RoleCrPagePom rcp = PageFactory.initElements(driver, RoleCrPagePom.class);
		rcp.rcreation("Telleret", "sammjasd", "E");

		driver.switchTo().alert().accept();

	}

}
