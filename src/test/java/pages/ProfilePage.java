package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    //class
    public class ProfilePage extends BasePage {
        //constructor
        public ProfilePage(WebDriver givenDriver) {
            super(givenDriver);
        }
            // Locators

                @FindBy(xpath = "//a[@data-title='Profile and preferences']")
                WebElement profileBtn;
                @FindBy(xpath = "//input[@data-testid='currentPassword']")
                WebElement currentPasswordField;
                @FindBy(xpath = "//input[@data-testid='newPassword']")
                WebElement newPasswordField;
                @FindBy(xpath = "//input[@data-testid='name']")
                WebElement profileNameField;
                @FindBy(xpath = "//input[@data-testid='email']")
                WebElement profileEmailField;
                @FindBy(xpath = "//footer[@class='mt-8']//button[@type='submit']")
                WebElement savebtn;
                @FindBy(xpath = "//div[@class='popover']")
                WebElement updatenotification;

                //helper methods

        public void clickProfileIconBtn() {
           findElement(profileBtn).click();
        }

        public void provideProfileEmail(String profileEmail) {

            findElement(profileEmailField).click();
            findElement(profileEmailField).clear();
            findElement(profileEmailField).sendKeys(profileEmail);
        }
        public void provideProfileName(String newName) {

            findElement(profileNameField).click();
            findElement(profileNameField).clear();
            findElement(profileNameField).sendKeys(newName);

        }
        public void provideNewPassword(String newPassword) {

            findElement(newPasswordField).click();
           findElement(newPasswordField).clear();
            findElement(newPasswordField).sendKeys(newPassword);
        }
        public void provideCurrentPassword(String currentPassword) {

            findElement(currentPasswordField).click();
            findElement(currentPasswordField).clear();
            findElement(currentPasswordField).sendKeys(currentPassword);
        }
        public void clickSave() {

            findElement(savebtn).click();
        }
        public void successnotification(){
            findElement(updatenotification);
            Assert.assertTrue(updatenotification.isDisplayed());
        }

    }
