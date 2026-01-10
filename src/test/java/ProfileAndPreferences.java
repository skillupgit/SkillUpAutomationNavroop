import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileAndPreferences extends BaseTest{

    @Test
    public void changeUserName() throws InterruptedException {
        //Login with valid credentials
        //navigateToUrl();
        loginKoelApp();
        //click on profile icon
        clickOnProfileIcon();
        Thread.sleep(2000);
        //enter current password
        enterCurrentPassword("Intern$hip001");
        Thread.sleep(2000);
        //Change user's name
        enterNewUserName(generateRandomName());
        Thread.sleep(2000);
        //click save
        clickSaveBtn();
        Thread.sleep(2000);
        //verify success message
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='popover']//main['Profile updated.']"));
        String successMessageText = successMessage.getText();
        System.out.println(successMessageText);
        Assert.assertTrue(successMessage.isDisplayed());
    }

    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.xpath("//form[@data-testid='update-profile-form']//button[@type='submit']"));
        saveBtn.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
        //Goerge-Brown  "-", ""
    }

    public void enterNewUserName(String newUserName) {
        WebElement nameField = driver.findElement(By.xpath("//input[@data-testid='name']"));
        nameField.click();
        nameField.clear();
        nameField.sendKeys(newUserName);
    }

    public void enterCurrentPassword(String currentPassword) {
        WebElement enterCurrentPasswordField = driver.findElement(By.xpath("//input[@data-testid='currentPassword']"));
        enterCurrentPasswordField.click();
        enterCurrentPasswordField.clear();
        enterCurrentPasswordField.sendKeys(currentPassword);
    }

    public void clickOnProfileIcon() {
        WebElement profileIcon = driver.findElement(By.xpath("//a[@data-testid='view-profile-link']"));
        profileIcon.click();
    }

}
