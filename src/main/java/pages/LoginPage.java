package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set explicit wait
        PageFactory.initElements(driver, this);
    }

    // In a larger project, it would be better to abstract this wait logic to a BasePage class
    // and have all page objects inherit from it. This keeps code DRY and makes maintenance easier
    private WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Page actions
    public void enterUsername(String username) {
        waitForElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitForElement(loginButton).click();
    }

    public String getErrorMessage() {
        return waitForElement(errorMessage).getText();
    }

    public boolean checkForInventoryContainer() {
        return waitForElement(inventoryContainer).isDisplayed();
    }
}

