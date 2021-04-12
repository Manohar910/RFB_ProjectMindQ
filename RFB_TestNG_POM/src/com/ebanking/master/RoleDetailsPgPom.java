package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetailsPgPom {
	// Element Properties
	@FindBy(xpath = "//*[@id=\"btnRoles\"]")
	WebElement nRole;

	@FindBy(xpath = "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement rHome;

	// Element methods
	public void nRl() {
		nRole.click();
	}

	public void rHome() {
		rHome.click();
	}
}
