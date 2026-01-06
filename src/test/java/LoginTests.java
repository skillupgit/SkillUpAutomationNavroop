import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        String url = "http://testkoel.skillup.study/#/home";
        driver.get(url);

        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //Pre-Condition: Browser must be open
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        //Step 1
        String url = "http://testkoel.skillup.study/#/home";
        driver.get(url);
        //Step 2: Enter Valid Email Address
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("student@skillup.study");
        Thread.sleep(2000);

        //Step 3: Enter Valid Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Intern$hip001");
        Thread.sleep(2000);

        //Step 4: Click on Login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);

        //Expected vs Actual Result
        WebElement profileIcon = driver.findElement(By.xpath("//a[@data-testid='view-profile-link']"));
        Assert.assertTrue(profileIcon.isDisplayed());
        //Close browser
        driver.quit();

    }

}
