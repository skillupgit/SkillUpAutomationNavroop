import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;
public class ChangeProfileName extends BaseTest {

    @Test
    public void changeProfileNameTest() throws InterruptedException {
    //navigate to koel app
    navigateToKoelApp();

    //login with valid credentials
    provideEmail();
    providePassword();
    clickLoginBtn();

    //click profile icon
     clickProfileIconBtn();
     Thread.sleep(2000);
     //create random name
     String randomName= generateRandomName();
     System.out.println("random name is: "+randomName);
     Thread.sleep(2000);
     //enter current password
     provideCurrentPassword();
     Thread.sleep(2000);
     provideNewPassword();
     Thread.sleep(2000);
     //entre profile name
     provideProfileName(randomName);
     Thread.sleep(2000);
     //enter email
     provideProfileEmail();
     Thread.sleep(2000);
     //click on save button
     clickSave();
     Thread.sleep(2000);

     //varify result
       // WebElement updatenotification = driver.findElement(By.xpath("[//article[@title='Click to dismiss']"));
      // System.out.println(updatenotification.getText());
        //Assert.assertTrue(updatenotification.isDisplayed());

        }

//helper methods
    public void clickSave() {
    WebElement Savebtn= driver.findElement(By.xpath("//footer[@class='mt-8']//button[@type='submit']"));
    }


    public void provideCurrentPassword() {
    WebElement currentPasswordField = driver.findElement(By.xpath("//input[@data-testid='currentPassword']"));
    currentPasswordField.click();
    currentPasswordField.clear();
    currentPasswordField.sendKeys("Intern$hip001");
    }

    public void provideNewPassword() {
        WebElement newPasswordField = driver.findElement(By.xpath("//input[@data-testid='newPassword']"));
        newPasswordField.click();
        newPasswordField.clear();
        newPasswordField.sendKeys("Intern$hip001");
    }
    public void provideProfileName(String newName) {
    WebElement profileNameField = driver.findElement(By.xpath("//input[@data-testid='name']"));
    profileNameField.click();
    profileNameField.clear();
    profileNameField.sendKeys(newName);

    }

    public void provideProfileEmail() {
    WebElement profileEmailField = driver.findElement(By.xpath("//input[@data-testid='email']"));
    profileEmailField.click();
    profileEmailField.clear();
    profileEmailField.sendKeys("student@skillup.study");
    }

    public String generateRandomName() {
    return UUID.randomUUID().toString().replace("-", "");
    }


    public void clickProfileIconBtn() {
    WebElement savebtn= driver.findElement(By.xpath("//a[@data-title='Profile and preferences']"));
    savebtn.click();

    }


}
