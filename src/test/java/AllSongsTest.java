import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest{

    @Test
    public void rightClickAndPlaySongFromAllSongs() throws InterruptedException {
        //Login
        loginKoelApp();
        //navigate to All Songs
        navigateToAllSongs();
        Thread.sleep(4000);
        //ContextClick (Right Click) on first Song
        contextClickSongSearchedByName();
        //Choose Play
        choosePlayFromRightClickMenu();
        //Assert Song is Playing
        Assert.assertTrue(isSongPlaying());
    }

    public boolean isSongPlaying(){
        WebElement pauseBtn = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer//button[@title='Pause']")));
        return pauseBtn.isDisplayed();
    }


    private void choosePlayFromRightClickMenu() {
        WebElement optionPlayContextMenu = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//nav[@data-testid='song-context-menu']//li/span[.='Play']")));
    }

    private void contextClickSongSearchedByName() {
        WebElement firstSongAllSongsList = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mainContent']/section[12]/main/div/div[2]/div/div/div[1]/article")));
        actions.contextClick(firstSongAllSongsList);
    }

    private void navigateToAllSongs() {
        WebElement allSongsList = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//li[@data-testid='sidebar-item']//a/span[.=' All Songs ']")));
        allSongsList.click();
    }


    private void ClickOnPlaylist(String playlistName) {
        WebElement selectTestOption = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//template[@class='block']//li[.='"+playlistName+"']")));
        actions.click(selectTestOption).perform();
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        //Login
        loginKoelApp();
        Thread.sleep(2000);
        //Choose playlist by Name
        choosePlaylistByName("test");
        //Count and Print All Songs
        countAndPrintSongs();
        //Assert contains the right amount of songs.
        String playListDetails = getPlaylistDetails();
        System.out.println(playListDetails);
        //Actual vs Expected (Count in Playlist Details vs actual count.)
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    private void countAndPrintSongs() {
        //Since no Ids or unique class names are present
        List<WebElement> songs = driver.findElements(By.xpath("//*[@id='mainContent']/section[6]/main/div/div[2]/div/div/div"));
        System.out.println("Number of Songs found: "+countSongs());
        for (WebElement e : songs){
            System.out.println(e.getText());
        }
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.xpath("//*[@id='mainContent']/section[6]/header/main/div[1]/span/span[1]")).getText();
    }

    private int countSongs() {
        return driver.findElements(By.xpath("//*[@id='mainContent']/section[6]/main/div/div[2]/div/div/div")).size();
    }

    private void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a/span[.='"+" "+playlistName+"']"))).click();
    }


}
