package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNgDataProvider extends MainTestNg {

	@Test(dataProvider ="Bdata")
	public static void branch(String bName, String Add1, String Add2, String Add3, String area, String zip,
			String country, String state, String city) throws Exception {
	// Single set of data
		// Library.Branch_Creation("Mindqhgjh", "Hyderabad", "jhkhkjks", "kjhkjklj",
		// "Nellore", "77654", "INDIA", "GOA", "GOA");
		Library.Branch_Creation(bName, Add1, Add2, Add3, area, zip, country, state, city);
	}
    //  Using for multiple sets of data
	@DataProvider
	public Object[][] Bdata() {
		Object[][] obj = new Object[3][9];

		obj[0][0] = "Mjkjlkjsljk";
		obj[0][1] = "hghjgkh";
		obj[0][2] = "khjjlk";
		obj[0][3] = "jhkhlj";
		obj[0][4] = "hgjhgkhk";
		obj[0][5] = "76456";
		obj[0][6] = "INDIA";
		obj[0][7] = "Tamil Nadu";
		obj[0][8] = "CHENNAI";

		obj[1][0] = "Mjkhghglkjsljk";
		obj[1][1] = "hghhgjgjgkh";
		obj[1][2] = "khjhjjlk";
		obj[1][3] = "jhhhkhlj";
		obj[1][4] = "hghjhgkhk";
		obj[1][5] = "78456";
		obj[1][6] = "INDIA";
		obj[1][7] = "Tamil Nadu";
		obj[1][8] = "CHENNAI";

		obj[2][0] = "Mjfhgjgkjsljk";
		obj[2][1] = "hghjhgggkh";
		obj[2][2] = "khgjhgjjlk";
		obj[2][3] = "jhkhgfgfhlj";
		obj[2][4] = "hgjhgkhk";
		obj[2][5] = "76356";
		obj[2][6] = "INDIA";
		obj[2][7] = "Tamil Nadu";
		obj[2][8] = "CHENNAI";
		return obj;
	}
}
