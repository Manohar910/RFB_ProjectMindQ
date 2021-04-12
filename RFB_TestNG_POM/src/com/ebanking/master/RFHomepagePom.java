package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RFHomepagePom {

	// Element properties

	@FindBy(xpath = "//*[@id=\"txtuId\"]")
	WebElement uName;

	@FindBy(xpath = "//*[@id=\"txtPword\"]")
	WebElement pswd;

	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement lgn;

	// Element methods

	public void Login() {
		uName.sendKeys("Admin");
		pswd.sendKeys("Testing@");
		lgn.click();
	}

}
