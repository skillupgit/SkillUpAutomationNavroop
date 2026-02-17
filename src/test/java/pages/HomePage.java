package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

//class
public class HomePage extends BasePage {
   //constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //elements
    @FindBy(xpath="//button[@data-title='Log out']")
    WebElement logoutBtn;
    @FindBy(xpath="//img[@class='inline-block']")
    WebElement logoImage;

   //test1 homeTest
    //elements
    @FindBy(xpath="//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath="//button[@data-testid='view-all-songs-btn']")
    WebElement viewAllBtn ;

    @FindBy(xpath= "//*[@id='mainContent']/section[12]/main/div/div[2]/div/div/div[1]/article")
    WebElement clickFirstSongBtn;
    @FindBy(xpath="//button[normalize-space()='Add To…']")
    WebElement addBtn;
    @FindBy(xpath="//*[@id='mainContent']/section[3]/header/main/div[2]/div/div[2]/div/div[1]/section/ul/li[4]")
    WebElement playlist;
    @FindBy(xpath="//div[@class='popover']")
    WebElement successMsgPopup ;

    //test2
    @FindBy(xpath="//button[@data-title='Play or resume']")
    WebElement playBtn;
    @FindBy(xpath= "//button[@data-title='Play or resume'][@title='Pause']")
    WebElement changeIcon;
    //test3

    @FindBy(xpath= "//a[@href='/#/songs']")
    WebElement allSongBtn;
    @FindBy(xpath= "//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article")
    WebElement rightClick;
    @FindBy(xpath= "//li[@class='has-sub']")
    WebElement hoverOnAddTo;
    @FindBy(xpath= "//template[@class='block']")
    WebElement selectTestOption;

    //test4
    @FindBy(xpath= "//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article")
    WebElement doubleClickOnSong;
    //test5
    @FindBy(xpath= "//button[@title='Create a new playlist or folder']")
    WebElement clickOnPlusBtn;

    @FindBy(xpath= "//li[@data-testid='playlist-context-menu-create-smart']")
    WebElement clickOnPlaylist;

    @FindBy(xpath= "//input[@placeholder='Playlist name']")
    WebElement enterPlaylistName;

 //   @FindBy(xpath="//span[normalize-space()='" + Playlist + "']")
    WebElement contextClickOnPlaylist;

    @FindBy(xpath= "//footer//button[@type='submit']")
    WebElement  clickSaveBtn;
    @FindBy(xpath= "//li[normalize-space()='Delete']")
    WebElement  clickOnDelete;
    @FindBy(xpath= "//div[@class='popover']")
    WebElement  SuccessMsg;


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

        findElement(rightClick);
        actions.contextClick(rightClick).perform();

    }
    public void hoverOnAddToOptipon(){
        findElement(hoverOnAddTo);
        actions.moveToElement(hoverOnAddTo).perform();

    }

    public void ClickOnTestOption(){
        findElement(selectTestOption).click();
    }

//test4
public void doubleClickToPlay(){
   findElement(doubleClickOnSong);
    actions.doubleClick(doubleClickOnSong).perform();

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

    public void selectNewPlaylistByName(String Playlist){
        findElement(contextClickOnPlaylist).sendKeys(Playlist);
        actions.contextClick(contextClickOnPlaylist).click().perform();


    }
    public void deletePlaylist(){
        findElement(clickOnDelete).click();
    }
    public WebElement getconfirmationMsg() {
        return findElement(SuccessMsg);
    }





}
