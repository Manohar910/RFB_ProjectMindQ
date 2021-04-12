package com.ebanking.masters;

public class ExeLibrary {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Library lib = new Library();
		String lUrl = Library.Launch_Url("http://122.175.8.158/ranford2/");
		System.out.println(lUrl);
		Library.Login_Admin("Admin", "Testing@");
		Library.Branch_Creation("Yogendra", "Nellore", "Kavali", "Jaladanki", "Kvl", "64768", "INDIA", "Andhra Pradesh",
				"Hyderabad");
		Library.Role_Creation("RestApiTester", "sample", "E");
		Library.Employee_Creation("ManoharSv", "Manohar910", "RestApiTester", "Yogendra");
		Library.LogOut();
		Library.Close();
	}

}
