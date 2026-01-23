import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions  = new Actions(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get(baseURL);
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    //Helper methods
    public void clickLoginBtn() throws InterruptedException {
        WebElement loginbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        //WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginbtn.click();


    }

    public void providePassword(String password) throws InterruptedException {
      WebElement passwordField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        // WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);


    }

    public void provideEmail(String email) throws InterruptedException {
        WebElement emailField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);

    }

   /* public void navigateToKoelApp() {
        String url = "http://testkoel.skillup.study/#home/";
        driver.get(url);*/


}


