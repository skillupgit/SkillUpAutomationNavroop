import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void testKoelPage() throws InterruptedException {
        //navigateToUrl();
        String expectedUrl = "http://testkoel.skillup.study/#/home";
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }



    @Test(dataProvider = "PostiveLoginTestData", dataProviderClass= TestDataProvider.class)
    public void loginValidEmailPassword(String email, String password) throws InterruptedException {
        //Step 1: Enter Valid Email Address
        enterEmail(email);
        //Step 3: Enter Valid Password
        enterPassword(password);
        //Step 4: Click on Login button
        clickLogin();
        //Expected vs Actual Result
        //WebElement profileIcon = driver.findElement(By.xpath("//a[@data-testid='view-profile-link']"));
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-testid='view-profile-links']")));
        Assert.assertTrue(profileIcon.isDisplayed());
    }

    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass= TestDataProvider.class)
    public void negativeLoginTests(String email, String password) throws InterruptedException {
        enterEmail(email);
        //Step 3: Enter Valid Password
        enterPassword(password);
        //Thread.sleep(2000);
        //Step 4: Click on Login button
        clickLogin();
        //Thread.sleep(2000);
        //Expected vs Actual Result
        WebElement forgotpasswordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button']")));
        Assert.assertTrue(forgotpasswordBtn.isDisplayed());
    }

    //Helper Methods

    public void enterEmail(String email){
        //WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        //WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }





}
