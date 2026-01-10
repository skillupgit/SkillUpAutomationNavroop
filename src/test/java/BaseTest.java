import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    //public String url = "http://testkoel.skillup.study/#/home";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String url){
        //Pre-Condition: Browser must be open
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToUrl(url);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    //Helper Methods
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void enterEmail(){
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("student@skillup.study");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Intern$hip001");
    }

    public void clickLogin(){
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
    }

    public void loginKoelApp() throws InterruptedException {
        Thread.sleep(2000);
        enterEmail();
        Thread.sleep(2000);
        enterPassword();
        Thread.sleep(2000);
        clickLogin();
        Thread.sleep(2000);
    }
}