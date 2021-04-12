package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BrCreationPgPom {
// Element properties
	@FindBy(xpath = "//*[@id=\"txtbName\"]")
	WebElement bName;

	@FindBy(xpath = "//*[@id=\"txtAdd1\"]")
	WebElement Add1;

	@FindBy(xpath = "//*[@id=\"Txtadd2\"]")
	WebElement Add2;

	@FindBy(xpath = "//*[@id=\"txtadd3\"]")
	WebElement Add3;

	@FindBy(xpath = "//*[@id=\"txtArea\"]")
	WebElement area;

	@FindBy(xpath = "//*[@id=\"txtZip\"]")
	WebElement zip;

	@FindBy(xpath = "//*[@id=\"lst_counrtyU\"]")
	WebElement cntry;

	@FindBy(xpath = "//*[@id=\"lst_stateI\"]")
	WebElement state;

	@FindBy(xpath = "//*[@id=\"lst_cityI\"]")
	WebElement cty;

	@FindBy(xpath = "//*[@id=\"btn_insert\"]")
	WebElement sbmt;

	// Element methods

	public void Branch(String bN, String A1, String A2, String A3, String ar, String zp, String cnty, String st,
			String ct) {
		bName.sendKeys(bN);
		Add1.sendKeys(A1);
		Add2.sendKeys(A2);
		Add3.sendKeys(A3);
		area.sendKeys(ar);
		zip.sendKeys(zp);
		new Select(cntry).selectByVisibleText(cnty);
		new Select(state).selectByVisibleText(st);
		new Select(cty).selectByVisibleText(ct);
		sbmt.click();
	}

}
