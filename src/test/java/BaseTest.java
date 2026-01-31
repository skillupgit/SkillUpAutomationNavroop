import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver driver;
    public WebDriverWait wait;

    public FluentWait<WebDriver> fluentWait;

    public Actions actions;

    //public String url = "http://testkoel.skillup.study/#/home";

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String url) throws MalformedURLException{
        //Pre-Condition: Browser must be open
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        //fluent wait setup
        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        actions = new Actions(getDriver());
        navigateToUrl(url);
    }

  /*  @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }*/

/*    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String url) throws MalformedURLException{
        //Pre-Condition: Browser must be open
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //fluent wait setup
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500));
        actions = new Actions(driver);
        navigateToUrl(url);
    }*/


    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://192.168.2.138:4444/";


        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);

            case "grid-MicrosoftEdge":
                capabilities.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);

            case "grid-chrome":
                capabilities.setCapability("browserName","chome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                return driver = new ChromeDriver(options);
        }
    }

    /*@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }*/
    @AfterMethod
    public void closeBrowser(){
        getDriver().quit();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "adminskillup";
        String password = "dFTFsQkkLQRcy1VEg9XAK9YXduFwzQ2139OBSNGzwDA0SHS";
        String gridUrl = "@hub.lambdatest.com/wd/hub";
        //Set Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserVersion", "122.0");

        //ChromeOptions browserOptions = new ChromeOptions();
        //browserOptions.setPlatformName("Windows 11");
        //browserOptions.setBrowserVersion("dev");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "adminskillup");
        ltOptions.put("accessKey", "LT_dFTFsQkkLQRcy1VEg9XAK9YXduFwzQ2139OBSNGzwDA0SHS");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        //browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Options", ltOptions);
        return driver = new RemoteWebDriver(new URL("https://"+username+":"+password + gridUrl),capabilities);
    }

    //Helper Methods
    /*public void navigateToUrl(String url) {
        driver.get(url);
    }*/
    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public void enterEmail(){
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys("student@skillup.study");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Intern$hip001");
    }

    public void clickLogin(){
        //WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        loginBtn.click();
    }

    public void loginKoelApp() throws InterruptedException {
        Thread.sleep(2000);
        enterEmail();
        Thread.sleep(2000);
        enterPassword();
        Thread.sleep(2000);
        clickLogin();
        Thread.sleep(2000);
    }
}