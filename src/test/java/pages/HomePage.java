package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//class
public class HomePage extends BasePage {
   //constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //elements
    By logoutBtn = By.xpath("//button[@data-title='Log out']");
    By logoImage = By.xpath("//img[@class='inline-block']");
   //test1 homeTest
    By searchField = By.xpath("//input[@name='q']");
    By viewAllBtn = By.xpath("//button[@data-testid='view-all-songs-btn']");
    By clickFirstSongBtn = By.xpath("//*[@id='mainContent']/section[12]/main/div/div[2]/div/div/div[1]/article");
    By addBtn = By.xpath("//button[normalize-space()='Add To…']");
    By playlist =By.xpath("//*[@id='mainContent']/section[3]/header/main/div[2]/div/div[2]/div/div[1]/section/ul/li[4]");
    By successMsgPopup=By.xpath("//div[@class='popover']");
    //test2
    By  playBtn = By.xpath("//button[@data-title='Play or resume']");
    By changeIcon = By.xpath("//button[@data-title='Play or resume'][@title='Pause']");
   //test 3
    By allSongBtn = By.xpath("//a[@href='/#/songs']");
    By rightClick =By.xpath("//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article");
    By hoverOnAddTo =By.xpath("//li[@class='has-sub']");
    By selectTestOption=By.xpath("//template[@class='block']");
   //test4
    By  doubleClickOnSong = By.xpath("//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article");
//test5
    By clickOnPlusBtn  = By.xpath("//button[@title='Create a new playlist or folder']");
    By clickOnPlaylist = By.xpath("//li[@data-testid='playlist-context-menu-create-smart']");
    By enterPlaylistName = By.xpath("//input[@placeholder='Playlist name']");
    By  clickSaveBtn = By.xpath("//footer//button[@type='submit']");
    By clickOnDelete = By.xpath("//li[normalize-space()='Delete']");
    By SuccessMsg = By.xpath("//div[@class='popover']");
    //test loginPage
    public WebElement getlogoutBtn() {
     return findElement((logoutBtn));
 }
    public WebElement getlogoImage(){
        return findElement((logoImage));
 }
//test1 homeTest
    public void searchSongField() {
        findElement(searchField).click();
        findElement(searchField).clear();
        findElement(searchField).sendKeys("Epic Song");
    }
    public void clickViewAllBtn(){
        findElement(viewAllBtn).click();
    }
    public void selectFirstSong(){
        findElement(clickFirstSongBtn).click();

    }
    public void clickAddToBtn(){
        findElement(addBtn).click();
    }
    public void SelectPlayList(){
        findElement(playlist).click();
    }
    public WebElement getsuccessMsg() {
        return findElement(successMsgPopup);
    }
    //test2
    public void clickOnplayButton(){
        findElement( playBtn).click();
    }
    public WebElement getturnPlayBtn(){
        return findElement(changeIcon);
    }

    //test3
    public void clickAllSongsBtn(){
       findElement(allSongBtn).click();

    }

    public void contextClickOnFirstSong() {

        WebElement rightClickFirstSong = driver.findElement(rightClick);
        actions.contextClick(rightClickFirstSong).perform();
    }
    public void hoverOnAddToOptipon(){
        WebElement hover = driver.findElement(hoverOnAddTo);
        actions.moveToElement(hover).perform();
    }

    public void ClickOnTestOption(){
        findElement(selectTestOption).click();
    }

//test4
public void doubleClickToPlay(){
    WebElement rightClickToPlay = driver.findElement(doubleClickOnSong);
    actions.doubleClick(rightClickToPlay).perform();
}
    //test5

    public void clickPlusBtn(){
        findElement(clickOnPlusBtn).click();
    }
    public void selectPlaylist(){
        findElement(clickOnPlaylist).click();
    }
    public void provideNewPlaylistName() {
        findElement(enterPlaylistName).click();
        findElement(enterPlaylistName).sendKeys("NewSongsPlaylist");
    }
        public void clickSaveBtn(){
            findElement(clickSaveBtn).click();
        }

    public void deletePlaylist(){
        findElement(clickOnDelete).click();
    }
    public WebElement getconfirmationMsg() {
        return findElement(SuccessMsg);
    }




}
