import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void testKoelPage() throws InterruptedException {
        navigateToUrl();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Step 1
        navigateToUrl();
        //Step 2: Enter Valid Email Address
        enterEmail("student@skillup.study");
        //Step 3: Enter Valid Password
        enterPassword("Intern$hip001");
        Thread.sleep(2000);
        //Step 4: Click on Login button
        clickLogin();
        Thread.sleep(2000);
        //Expected vs Actual Result
        WebElement profileIcon = driver.findElement(By.xpath("//a[@data-testid='view-profile-link']"));
        Assert.assertTrue(profileIcon.isDisplayed());
    }


    //Helper Methods

    public void enterEmail(String email){
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }





}
