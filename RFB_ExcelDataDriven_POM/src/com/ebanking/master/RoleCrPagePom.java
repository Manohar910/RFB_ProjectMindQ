package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCrPagePom {

	@FindBy(xpath="//*[@id=\"txtRname\"]")
	WebElement rn;
	
	@FindBy(xpath="//*[@id=\"txtRDesc\"]")
	WebElement rDesc;
	
	@FindBy(xpath="//*[@id=\"lstRtypeN\"]")
	WebElement rty;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement sbmt;
	
	public void rcreation(String rnm,String rd,String rt) {
		rn.sendKeys(rnm);
		rDesc.sendKeys(rd);
		Select rt1=new Select(rty);
		rt1.selectByVisibleText(rt);
		sbmt.click();
	}
}
