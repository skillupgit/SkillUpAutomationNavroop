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

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
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

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
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
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
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
        Assert.assertTrue(homepage.getconfirmationMsg().isDisplayed());


    }


    //test4
    @Test
    public void doubleClickPlaySong() throws InterruptedException {

        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
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
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
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
        homepage.selectNewPlaylistByName("NewSongsPlaylist");
        //click On delete to delete the playlist
        homepage.deletePlaylist();
        //assertion
        Assert.assertTrue(homepage.getconfirmationMsg().isDisplayed());
    }

    //private void selectNewPlaylistByName(String Playlist) {

        /*WebElement contextClickOnPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//span[normalize-space()='" + Playlist + "']")));
        actions.contextClick(contextClickOnPlaylist).perform();*/
    }








