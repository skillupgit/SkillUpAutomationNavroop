package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By profileIcon = By.xpath("//a[@data-testid='view-profile-link']");

    //Helper Methods

    public WebElement getProfileIcon(){
        return findElement(profileIcon);
    }


}
