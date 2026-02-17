package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.BaseTestMethod;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginStepDefinition extends BasePage {




    WebDriver driver;
    WebDriverWait wait;
@Before

    public void openBrowser() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I Open Login Page")
    public void iOpenLoginPage() {

       driver.get("http://testkoel.skillup.study/#home/");

    }

    @When("I Enter Email{string}")
    public void iEnterEmail(String email) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.provideEmail(email);


    }

    @And("I Enter Password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.providePassword(password);


    }

    @And("I Submit")
    public void iSubmit() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.clickLoginBtn();
    }

    @Then("I am Logged In")
    public void iAmLoggedIn() {
        HomePage homepage = new HomePage(driver);
        homepage.getlogoutBtn();
        Assert.assertTrue(homepage.getlogoutBtn().isDisplayed());
    }

    @Then("I am Notlogged In")
    public void iAmNotloggedIn() {
        LoginPage loginpage = new LoginPage(driver);
        Assert.assertTrue(loginpage.getforgetPasswordBtn().isDisplayed());
    }
   /* public void closeBrowser() {
    driver.quit();

    }*/
}