package com.ebanking.masters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmpNgDataProvider extends MainTestNg{
  
	@Test(dataProvider="eData")
	public static void Employee(String empName,String lgpswd,String role,String branch) throws Exception {
		// Library.Employee_Creation("hkhkdds", "dhbkjkjnd", "RestApiTester", "Yogendra");
	
    	Library.Employee_Creation(empName, lgpswd, role, branch);
    }
    @DataProvider
    public Object[][] eData(){
    	Object [][]obj=new Object[3][4];
    	
    	obj[0][0]="hkjljdf";
    	obj[0][1]="hbkhjlkjlk";
    	obj[0][2]="jhkjkjhjk";
    	obj[0][3]="Mjkjlkjsljk";
    	
    	obj[1][0]="hkjljhghgdf";
    	obj[1][1]="hbkhggjlkjlk";
    	obj[1][2]="jhkjkjhjk";
    	obj[1][3]="Mjkjlkjsljk";
    	
    	obj[2][0]="hkjlghjdf";
    	obj[2][1]="hbkhhjjjlkjlk";
    	obj[2][2]="jhkjkjhjk";
    	obj[2][3]="Mjkjlkjsljk";
		return obj;
    	
    	
    }
}
