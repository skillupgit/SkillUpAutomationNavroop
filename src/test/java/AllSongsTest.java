import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
