package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSD {
	WebDriver driver;

	@Given("^User should on ranford home page$")
	public void user_should_on_ranford_home_page() throws Throwable {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// Launch
		driver.get("http://122.175.8.158/ranford2/");

	}

	@When("^User enters \"(.*)\" and \"(.*)\" click on go$")
	public void user_enters_username_and_password_and_click_on_go(String Un,String pswd) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"txtuId\"]")).sendKeys(Un);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"txtPword\"]")).sendKeys(pswd);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
	}

	@Then("^User validates admin login functionality$")
	public void user_validates_admin_login_functionality() throws Throwable {
		String Expv = "Welcome to Admin";
		String Actv = driver
				.findElement(By.xpath(
						"/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font"))
				.getText();

		// Comparision
		if (Expv.equalsIgnoreCase(Actv)) {
			System.out.println("Admin login successfully");
		} else {
			System.out.println("Admin login failed");
		}
	}

}
