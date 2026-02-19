import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //test-1
@Test
public void loginWithvalidEmail() throws InterruptedException {

    //page objects
    LoginPage loginpage = new LoginPage(driver);
    HomePage homepage = new HomePage(driver);

    //enter valid email address
   loginpage.provideEmail("student@skillup.study");
    //enter valid password
    loginpage.providePassword("Intern$hip001");
    //click submit button
    loginpage.clickLoginBtn();

    Assert.assertTrue(homepage.getlogoutBtn().isDisplayed());


}
//test2
@Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestNGDataProvider.class)
public void negativeLoginTests(String email,String password) throws InterruptedException {

    LoginPage loginpage = new LoginPage(driver);
    //enter valid email address
    loginpage.provideEmail(email);
    //enter valid password
    loginpage.providePassword(password);
    //click submit button
    loginpage.clickLoginBtn();


    //assertion
    Assert.assertTrue(loginpage.getforgetPasswordBtn().isDisplayed());

}

//test-3 logout varification
@Test
    public void logoutVarification() throws InterruptedException {
    LoginPage loginpage = new LoginPage(driver);
    HomePage homepage = new HomePage(driver);

    loginpage.loginToAppWithvalidEmail();
    Assert.assertTrue(homepage.getlogoImage().isDisplayed());

    }

    }



