package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmpDetailsPgPom {

	@FindBy(xpath = "//*[@id=\"BtnNew\"]")
	WebElement nemp;

	@FindBy(xpath = "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement ehome;

	public void nEmp() {
		nemp.click();
	}

	public void eHome() {
		ehome.click();
	}
}
