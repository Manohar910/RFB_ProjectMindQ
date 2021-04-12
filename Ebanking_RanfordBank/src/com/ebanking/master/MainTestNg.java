package com.ebanking.master;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MainTestNg {
	static Library lb = new Library();

	@BeforeTest
	public static void beforeTest() {
		Library.Login_Admin("Admin", "Testing@");

	}

	@AfterTest
	public static void afterTest() {
		Library.LogOut();
	}

	@BeforeSuite
	public static void beforeSuite() throws Exception {
		Library.Launch_Url("http://122.175.8.158/ranford2");

	}

	@AfterSuite
	public static void afterSuite() {
		Library.Close();
	}

}
