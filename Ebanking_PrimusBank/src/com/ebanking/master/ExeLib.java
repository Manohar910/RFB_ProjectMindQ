package com.ebanking.master;

public class ExeLib {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Library lib=new Library();
		String lUrl=lib.Launch_Url("http://primusbank.qedgetech.com/");
		System.out.println(lUrl);
		lib.Login_Admin("Admin","Admin");
		lib.Branch_Creation("Yogendra","Nellore","Kavali","Jaladanki","Kvl","64768","INDIA","Andhra Pradesh","Hyderabad");
		lib.Role_Creation("RestApiTester","sample","E");
		lib.Employee_Creation("ManoharSv","Manohar910","RestApiTester","Yogendra");
		lib.LogOut();
		lib.Close();
	}

}
