package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hybrid {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Library LB = new Library();

		String Res = null;

		String Kpath = "D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_KeyWordDriven\\src\\com\\ebanking\\testdata\\keyword_data.xlsx";

		String Kout = "D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_KeyWordDriven\\src\\com\\ebanking\\results\\keywordRes_data.xlsx";

		FileInputStream fi = new FileInputStream(Kpath);

		// Workbook
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// Sheet
		XSSFSheet ws = wb.getSheet("TestCase");
		XSSFSheet ws1 = wb.getSheet("TestSteps");

		// XSSFSheet ws2=wb.getSheet("TestData");

		// Row count

		int tcRc = ws.getLastRowNum();
		System.out.println(tcRc);

		int tsRc = ws1.getLastRowNum();
		System.out.println(tsRc);

		// test cases

		for (int i = 1; i <= tcRc; i++) {
			String exe = ws.getRow(i).getCell(2).getStringCellValue();
			if (exe.equalsIgnoreCase("Y")) {
				String tcId = ws.getRow(i).getCell(0).getStringCellValue();
				System.out.println(tcId);

				// test steps

				for (int j = 1; j <= tsRc; j++) {
					String tsTcid = ws1.getRow(j).getCell(0).getStringCellValue();
					// System.out.println(tsTcid);
					if (tcId.equalsIgnoreCase(tsTcid)) {
						String key = ws1.getRow(j).getCell(3).getStringCellValue();
						System.out.println(key);
						switch (key) {
						case "RLanch":
							Res = Library.Launch_Url("http://122.175.8.158/ranford2/");
							break;
						case "RLogin":
							Res = Library.Login_Admin("Admin", "Testing@");
							break;
						case "RLogout":
							Library.LogOut();
							break;
						case "RBranch":
							Library.Branch_Creation("ghddjh", "hjhgjkh", "hihikh", "hkjhkjh", "hukjhjk", "64758",
									"INDIA", "Tamil Nadu", "CHENNAI");
							break;
						case "RRole":
							// For Multi sets of data we can use Hybrid framework
							FileInputStream fis = new FileInputStream(
									"D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_HybridFrameWork\\src\\src\\com\\ebanking\\testdata\\RoleHybrid.xlsx");

							XSSFWorkbook wb1 = new XSSFWorkbook(fis);
							XSSFSheet ws11 = wb1.getSheet("Sheet1");

							int rCount = ws11.getLastRowNum();
							System.out.println(rCount);

							for (int i1 = 1; i1 <= rCount; i1++) {
								XSSFRow wr = ws11.getRow(i1);

								XSSFCell wc = wr.getCell(0);
								XSSFCell wc1 = wr.getCell(1);
								XSSFCell wc2 = wr.getCell(2);
								XSSFCell wc3 = wr.createCell(3);

								String rln = wc.getStringCellValue();
								String rds = wc1.getStringCellValue();
								String rtp = wc2.getStringCellValue();

								String res = Library.Role_Creation(rln, rds, rtp);
								System.out.println(res);
								wc3.setCellValue(res);
							}
							break;
						case "RClose":
							Library.Close();
							break;

						default:
							System.out.println("Pass a Valid Keyword");
							break;
						}

						// result updation in test steps sheet

						ws1.getRow(j).createCell(4).setCellValue(Res);

						// result updation in test case sheet

						if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail")) {
							ws.getRow(i).createCell(3).setCellValue(Res);
						} else {
							ws.getRow(i).createCell(3).setCellValue("Fail");
						}

					}

				}

			} else {
				ws.getRow(i).createCell(3).setCellValue("BLOCKED");
			}
		}
		FileOutputStream fo = new FileOutputStream(Kout);
		wb.write(fo);
		wb.close();

	}

}
