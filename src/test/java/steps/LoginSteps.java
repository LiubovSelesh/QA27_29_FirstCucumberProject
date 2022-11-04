package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;

    @Given("Navigate to Home Page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("Click on Login tab")
    public void clickOnLoginTab() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    @Then("Appear LoginRegistration form")
    public void isLoginRegistrationFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));
        driver.quit();
    }

    @And("Enter valid data")
    public void enterValidData() {
        type(By.cssSelector("[placeholder='Email']"), "ron+21@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Ro1234567$");
    }

    @And("Click on Login button")
    public void ClickOnLoginButton() {
        click(By.xpath("//button[.=' Login']"));
    }

    @Then("SignOut button displayed")
    public void isSignOutPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
        driver.quit();
    }

    @And("Enter valid email and invalid password")
    public void enterInvalidPassword(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);

    }

    @Then("Alert appeared")
    public void isAlertAppeared() {
        Assert.assertTrue(isAlertPresent());
    }

    @And("Click on ADD tab")
    public void clickOnAddTab() {
        click(By.xpath("//*[.='ADD']"));
    }

    @And("Enter data form for contacts")
    public void EnterDataFormForContacts() {
        type(By.cssSelector("[placeholder='Name']"), "Max");
        type(By.cssSelector("[placeholder='Last Name']"), "Miller");
        type(By.cssSelector("[placeholder='Phone']"), "741258963");
        type(By.cssSelector("[placeholder='email']"), "miller@qm.com");
        type(By.cssSelector("[placeholder='Address']"), "Lee");
        type(By.cssSelector("[placeholder='description']"), "Friend");
    }

    @And("Click on Save button")
    public void clickOnSaveButton() {
        click(By.xpath("//b[contains(text(),'Save')]"));
    }

    @Then("Appear contact")
    public void isContactPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".contact-item_card__2SOIM")));
//        driver.quit();
    }

    @And("Click on contact tab")
    public void clickOnContactTab() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
    }
    @And("Click on Remove button")
    public void clickOnRemoveButton() {
        click(By.xpath("//button[contains(text(),'Remove')]"));
    }
    @Then("Appear message")
    public void isMessagePresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".contact-page_message__2qafk")));
//        driver.quit();
    }

    private boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }

    }

    private void type(By locator, String text) {
        if (text !=null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
