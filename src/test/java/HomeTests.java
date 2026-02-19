import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.UUID;

public class HomeTests extends BaseTest {
    //test-1 add song to test playlist
    @Test
    public void AddSongToPlaylistTest() throws InterruptedException {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();

        //search song
        homepage.searchSongField();

        //click view all btn
        homepage.clickViewAllBtn();

        //select first song
        homepage.selectFirstSong();

        //click add to btn
        homepage.clickAddToBtn();

        //select playlist
        homepage.SelectPlayList();

        //assertion

        Assert.assertTrue(homepage.getsuccessMsg().isDisplayed());
    }


    //test-2 play song
    @Test
    public void play() throws InterruptedException {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();

        //click on play button
        homepage.clickOnplayButton();

        //assert result
        Assert.assertTrue(homepage.getturnPlayBtn().isDisplayed());

    }


    //test3
    @Test
    public void hoverAddToOption() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();

        //click on all songs
        homepage.clickAllSongsBtn();
        //right click on first song from the list
        homepage.contextClickOnFirstSong();
        //hover to add to option
        homepage.hoverOnAddToOptipon();
        //select test option
        homepage.ClickOnTestOption();
        //Assertion
        Assert.assertTrue(homepage.getsuccessMsg().isDisplayed());


    }


    //test4
    @Test
    public void doubleClickPlaySong() throws InterruptedException {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();

        //click on all songs
        homepage.clickAllSongsBtn();
        //play song with double click
        homepage.doubleClickToPlay();
        //assert result
        Assert.assertTrue(homepage.getturnPlayBtn().isDisplayed());

    }



//test5
    @Test
    public void createAndDeletePlaylist() throws InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        //login with valid credentials
        loginpage.loginToAppWithvalidEmail();
        //click on plus button
       homepage.clickPlusBtn();

        //click on new playlist
        homepage.selectPlaylist();
        //enter new playlist name
        homepage.provideNewPlaylistName();
        //click on save button
        homepage.clickSaveBtn();
        //delete playlist by entering name
        selectNewPlaylistByName("NewSongsPlaylist");
        //click On delete to delete the playlist
        homepage.deletePlaylist();
        //assertion
        Assert.assertTrue(homepage.getconfirmationMsg().isDisplayed());
    }

    private void selectNewPlaylistByName(String Playlist) {
        WebElement contextClickOnPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[normalize-space()='" + Playlist + "']")));
        actions.contextClick(contextClickOnPlaylist).perform();
    }



    }





/*

public class HomeTests extends BaseTest {
    //test-1 add song to test playlist
    @Test
    public void AddSongToPlaylistTest() throws InterruptedException {

        //navigate to koel app
        //navigateToKoelApp();

        //login with valid credentials
        provideEmail("student@skillup.study");
        providePassword("Intern$hip001");
        clickLoginBtn();

        //search song
        searchsongfield();


        //click view all btn
        clickviewAllBtn();


        //select first song
        selectFirstSong();


        //click add to btn
        clickAddToBtn();


        //select playlist
        SelectPlayList();


        successMsg();


    }

    //helper methods

    public void successMsg() {
        WebElement successMsgPopup = driver.findElement(By.xpath("//div[@class='popover']"));
        Assert.assertTrue(successMsgPopup.isDisplayed());
    }

    private void SelectPlayList() {

        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContent']/section[3]/header/main/div[2]/div/div[2]/div/div[1]/section/ul/li[4]")));
        playlist.click();

    }

    private void clickAddToBtn() {

        WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add To…']")));
        addBtn.click();
    }

    private void selectFirstSong() {

        WebElement clickFirstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContent']/section[12]/main/div/div[2]/div/div/div[1]/article")));
        clickFirstSong.click();
    }

    private void clickviewAllBtn() {

        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='view-all-songs-btn']")));
        viewAllBtn.click();
    }

    private void searchsongfield() {

        WebElement searchfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));

        searchfield.click();
        searchfield.clear();
        searchfield.sendKeys("Epic Song");
    }

    //test-2 play song
    @Test
    public void play() throws InterruptedException {

        //login with valid credentials
        provideEmail("student@skillup.study");
        providePassword("Intern$hip001");
        clickLoginBtn();

        //click on play button
        clickOnplayButton();

        //assert result
        turnPlayBtn();


    }

    private void turnPlayBtn() {

        WebElement changeIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-title='Play or resume'][@title='Pause']")));
        Assert.assertTrue(changeIcon.isDisplayed());
    }

    private void clickOnplayButton() {

        WebElement playBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-title='Play or resume']")));
        playBtn.click();
    }


    @Test
    public void hoverAddToOption() throws InterruptedException {
        //login with valid credentials
        provideEmail("student@skillup.study");
        providePassword("Intern$hip001");
        clickLoginBtn();

        //click on all songs
        clickAllSongsBtn();
        //right click on first song from the list
        contextClickOnFirstSong();
        //hover to add to option
        hoverOnAddToOptipon();
        //select test option
        ClickOnTestOption();
        //success message
        successMsgPopover();


    }

    public void successMsgPopover() {
        WebElement successMsgPopup = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='popover']")));
        Assert.assertTrue(successMsgPopup.isDisplayed());
    }

    private void ClickOnTestOption() {
        WebElement selectTestOption = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//template[@class='block']")));
        actions.click(selectTestOption).perform();
    }

    private void hoverOnAddToOptipon() {
        WebElement hoverOnAddTo = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@class='has-sub']")));

        actions.moveToElement(hoverOnAddTo).perform();

    }

    private void contextClickOnFirstSong() {
        WebElement contextClick = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article")));

        actions.contextClick(contextClick).perform();
    }

    private void clickAllSongsBtn() {
        WebElement allSongBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@href='/#/songs']")));

        actions.click(allSongBtn).perform();
    }


    @Test
    public void doubleClickPlaySong() throws InterruptedException {

        //login
        provideEmail("student@skillup.study");
        providePassword("Intern$hip001");
        clickLoginBtn();

        //select allSongs
        clickAllSongsBtn();
        //play song with double click
        doubleClickToPlay();
        //assert result
        turnPlayBtn();

    }

    private void doubleClickToPlay() {
        WebElement doubleClickOnSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContent']/section[3]/main/div/div[2]/div/div/div[1]/article")));
        actions.doubleClick(doubleClickOnSong).perform();

    }


    @Test
    public void createAndDeletePlaylist() throws InterruptedException {
        //login
        provideEmail("student@skillup.study");
        providePassword("Intern$hip001");
        clickLoginBtn();

        //click on plus button
        clickPlusBtn();

        //click on new playlist
        selectPlaylist();
        //enter new playlist name
        provideNewPlaylistName();
        //click on save button
        clickSaveBtn();
        //delete playlist by entering name
        selectNewPlaylistByName("NewSongsPlaylist");
        //click On delete to delete the playlist
        deletePlaylist();
        //assertion
        confirmationMsg();
    }

    private void confirmationMsg() {
        WebElement SuccessMsg=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='popover']")));


        Assert.assertTrue(SuccessMsg.isDisplayed());

    }

    private void deletePlaylist() {
        WebElement clickOnDelete=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[normalize-space()='Delete']")));
    }

    private void selectNewPlaylistByName(String Playlist) {
        WebElement contextClickOnPlaylist=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[normalize-space()='"+Playlist+"']")));
        actions.contextClick(contextClickOnPlaylist).perform();
    }


    private void clickSaveBtn() {
        WebElement clickOnSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//button[@type='submit']")));
        actions.click(clickOnSaveBtn).perform();


    }

    private void provideNewPlaylistName() {
        WebElement enterPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@placeholder='Playlist name']")));
        actions.click(enterPlaylistName).perform();
        actions.sendKeys("NewSongsPlaylist");

    }

    private void selectPlaylist() {
        WebElement clickOnPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//li[@data-testid='playlist-context-menu-create-smart']")));
        actions.click(clickOnPlaylist).perform();

    }

    private void clickPlusBtn() {
        WebElement clickOnPlusBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@title='Create a new playlist or folder']")));
        actions.click(clickOnPlusBtn).perform();
    }
*/


