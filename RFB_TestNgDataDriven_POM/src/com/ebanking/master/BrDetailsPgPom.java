package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrDetailsPgPom {
//Element properties
	@FindBy(xpath = "//*[@id=\"BtnNewBR\"]")
	WebElement nBranch;

	@FindBy(xpath = "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement bHome;

	// Element method
	public void nbr() {
		nBranch.click();
	}

	public void bHome() {
		bHome.click();
	}
}
