package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Selenium By Class Locators start here//

    //Email Field
    By emailField = By.xpath("//input[@type='email']");

    //Password Field
    By passwordField = By.xpath("//input[@type='password']");

    //Login button
    By loginBtn = By.xpath("//button[@type='submit']");
    //Forgot Password link

    By forgotPasswordLink = By.xpath("//a[@role='button']");

    //Helper Methods
    public void provideEmail(String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        findElement(loginBtn).click();
    }

    public void loginToKoelApp(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickLogin();
    }

    public WebElement getForgotPasswordLink(){
        return findElement(forgotPasswordLink);
    }



}
