package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageFactory extends BasePage {


    //Selenium Page Factory Locators Start Here//
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailFieldXPath;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordFieldXPath;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtnXPath;

    public LoginPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPageFactory provideEmailUsingElement(String email){
        findElement(emailFieldXPath).clear();
        findElement(emailFieldXPath).sendKeys(email);
        return this;
    }



    public LoginPageFactory providePasswordUsingElement(String password){
        findElement(passwordFieldXPath).clear();
        findElement(passwordFieldXPath).sendKeys(password);
        return this;
    }

    public LoginPageFactory clickLoginUsingElement(){
        findElement(loginBtnXPath).click();
        return this;
    }


}
