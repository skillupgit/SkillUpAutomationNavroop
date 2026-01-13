import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    //Helper methods
    public void clickLoginBtn() throws InterruptedException {
        WebElement loginbtn=driver.findElement(By.xpath("//button[@type='submit']"));
        loginbtn.click();
        Thread.sleep(2000);

    }

    public void providePassword() throws InterruptedException {
        WebElement passwordField= driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Intern$hip001");
        Thread.sleep(2000);

    }
    public void provideEmail() throws InterruptedException {
        WebElement emailField= driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        Thread.sleep(2000);
        emailField.sendKeys("student@skillup.study");
        Thread.sleep(2000);
    }

    public void navigateToKoelApp() {
        String url = "http://testkoel.skillup.study/#home/";
        driver.get(url);

    }
}


