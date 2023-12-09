package sesame.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefEx2 {
	public WebDriver driver;

	@Given("Open the Chrome and launch the application")
	public void open_the_Firefox_and_launch_the_application() {
		 System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		 driver = new FirefoxDriver();
		 driver.get("https://demo.guru99.com/v4");
	}
	@When("Enter the Username {string} and Password {string}")
	public void enter_the_username_and_password(String username,String password) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.name("uid")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}
	@Then("Reset the credential")
	public void reset_the_credential() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("btnReset")).click();
		driver.close();
	}
}
