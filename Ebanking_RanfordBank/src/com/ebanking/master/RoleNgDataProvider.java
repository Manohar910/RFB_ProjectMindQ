package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleNgDataProvider extends MainTestNg {
	@Test(dataProvider = "Rdata")
	public static void Role(String role, String rDesc, String rType) throws Exception {
		// Library.Role_Creation("Clerkjhjh", "kjhkjkjc", "E");

		Library.Role_Creation(role, rDesc, rType);
	}

	@DataProvider
	public Object[][] Rdata() {
		Object[][] obj = new Object[3][3];

		obj[0][0] = "jhkjkjhjk";
		obj[0][1] = "bkdhkjldj";
		obj[0][2] = "E";

		obj[1][0] = "jhkjkhghjjhjk";
		obj[1][1] = "bkdhhjghkjldj";
		obj[1][2] = "E";

		obj[2][0] = "jhkhjjkjhjk";
		obj[2][1] = "bkhhdhkjldj";
		obj[2][2] = "E";
		return obj;

	}
}
