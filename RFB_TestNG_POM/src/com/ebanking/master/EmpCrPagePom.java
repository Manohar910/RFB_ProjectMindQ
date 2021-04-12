package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmpCrPagePom {
	@FindBy(xpath = "//*[@id=\"txtUname\"]")
	WebElement ename;

	@FindBy(xpath = "//*[@id=\"txtLpwd\"]")
	WebElement lgpsd;

	@FindBy(xpath = "//*[@id=\"lst_Roles\"]")
	WebElement role;

	@FindBy(xpath = "//*[@id=\"lst_Branch\"]")
	WebElement branch;

	@FindBy(xpath = "//*[@id=\"BtnSubmit\"]")
	WebElement submt;

	public void empcr(String enm,String lp,String rle,String brc) {
		ename.sendKeys(enm);
		lgpsd.sendKeys(lp);

		Select rl = new Select(role);
		rl.selectByVisibleText(rle);

		Select br = new Select(branch);
		br.selectByVisibleText(brc);

		submt.click();
	}

}
