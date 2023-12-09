package sesame.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef {
	public WebDriver driver;

	@Given("I open google search page")
	public void i_open_google_search_page() {
		 System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		 driver = new FirefoxDriver();
		 driver.get("https://www.google.fr");
	}
	@When("I lookup the word {string}")
	public void i_lookup_the_word(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys(string);
	    WebElement submit=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
	    JavascriptExecutor javax=(JavascriptExecutor)driver;
	    javax.executeScript("scroll(0,200)");
	    submit.click();
	}
	@Then("Search results display the word {string}")
	public void search_results_display_the_word(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle().contains(string));
		driver.close();
	}
}
