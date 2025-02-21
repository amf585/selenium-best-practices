package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    // @Before, @After, and other annotations can also be abstracted to a Hooks.java file
    // if multiple test step files need to inherit them. This keeps code DRY and makes maintenance easier
    @Before
    public void setup(){
        // Normally with Selenium 4.6+ Driver downloads are automagically handled, but on my system
        // explicitly setting the driver was needed for consistency and proper functionality
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Given("I enter a valid username and password")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @Given("I enter {string} and {string}")
    public void i_enter_invalid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.checkForInventoryContainer(), "Login failed!");
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedError) {
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError);
    }
}
