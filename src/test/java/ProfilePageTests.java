import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.UUID;

public class ProfilePageTests extends BaseTest {

    @Test(dataProvider = "AddProfileTestData", dataProviderClass = TestNGDataProvider.class)
    public void changeProfileNameTest(String currentPassword, String newPassword, String newName, String profileEmail) throws InterruptedException {


        ProfilePage profilepage = new ProfilePage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        LoginPage loginpage = new LoginPage(getDriver());
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();
        //click profile icon
        profilepage.clickProfileIconBtn();

        //enter current password
        profilepage.provideCurrentPassword(currentPassword);

        profilepage.provideNewPassword(newPassword);

        //entre profile name
        profilepage.provideProfileName(newName);

        //enter email
        profilepage.provideProfileEmail(profileEmail);

        //click on save button
        profilepage.clickSave();

        //assertion
        profilepage.successnotification();

    }
}

    /*private void successnotification() {
       // WebElement updatenotification = driver.findElement(By.xpath("//div[@class='popover']"));
        WebElement updatenotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popover']")));
        Assert.assertTrue(updatenotification.isDisplayed());
    }*/

    //helper methods
    /*public void clickSave() {
   WebElement savebtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@class='mt-8']//button[@type='submit']")));
        //WebElement savebtn= driver.findElement(By.xpath("//footer[@class='mt-8']//button[@type='submit']"));
        savebtn.click();
    }*/


   /* public void provideCurrentPassword(String currentPassword) {
        //WebElement currentPasswordField = driver.findElement(By.xpath("//input[@data-testid='currentPassword']"));
       WebElement currentPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='currentPassword']")));
        currentPasswordField.click();
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }*/

    /*public void provideNewPassword(String newPassword) {
       // WebElement newPasswordField = driver.findElement(By.xpath("//input[@data-testid='newPassword']"));
       WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='newPassword']")));
        newPasswordField.click();
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
    }*/
   /* public void provideProfileName(String newName) {
       // WebElement profileNameField = driver.findElement(By.xpath("//input[@data-testid='name']"));
        WebElement profileNameField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='name']")));
        profileNameField.click();
        profileNameField.clear();
        profileNameField.sendKeys(newName);

    }*/

    /*public void provideProfileEmail(String profileEmail) {
       // WebElement profileEmailField = driver.findElement(By.xpath("//input[@data-testid='email']"));
        WebElement profileEmailField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='email']")));
        profileEmailField.click();
        profileEmailField.clear();
        profileEmailField.sendKeys(profileEmail);*/

/*
    public void clickProfileIconBtn() {
        //WebElement savebtn = driver.findElement(By.xpath("//a[@data-title='Profile and preferences']"));
        WebElement profileBtn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-title='Profile and preferences']")));
        profileBtn.click();
    }*/








