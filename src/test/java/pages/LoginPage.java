package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
//constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //elements
//enter valid email field
    @FindBy(xpath="//input[@type='email']")
    WebElement emailField;

    //enter valid password
    @FindBy(xpath="//input[@type='password']")
    WebElement passwordField;

    //Login button
    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;


    //forgot password button
    @FindBy(xpath = "//a[@role='button']")
           WebElement forgetpasswordBtn;
   // By forgetpasswordBtn =By.xpath("//a[@role='button']");




    //helper methods
    public void provideEmail(String email) {
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        findElement(loginBtn).click();
    }

    public WebElement getforgetPasswordBtn() {
        return findElement((forgetpasswordBtn));


    }

    public void loginToAppWithvalidEmail() throws InterruptedException {

        //enter valid email address
        provideEmail("student@skillup.study");
        //enter valid password
        providePassword("Intern$hip001");
        //click submit button
        clickLoginBtn();
    }
}