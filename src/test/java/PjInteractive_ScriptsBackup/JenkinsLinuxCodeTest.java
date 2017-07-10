import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class JenkinsLinuxCodeTest {

    @Test
    public void startTest() throws Exception {

        System.setOut(new PrintStream(new FileOutputStream(System.getProperty("user.dir") + "/Logs/" + "Maven Logs " + ".txt")));


        String chromeDrvPath = System.getProperty("user.dir") + "/Drivers/" + "chromedriver.exe";
        String fireFoxDrvPath = System.getProperty("user.dir") + "/Drivers/" + "geckodriver.exe";
        String phantomJSrvPath = System.getProperty("user.dir") + "/Drivers/" + "phantomjs.exe";
        String fireFoxDrvPathLinux = System.getProperty("user.dir") + "/Drivers/Linux/" + "geckodriver";
        String chromeDrvPathLinux = System.getProperty("user.dir") + "/Drivers/Linux/" + "chromedriver";

        //System.setProperty("webdriver.chrome.driver", chromeDrvPath);
        //System.setProperty("webdriver.chrome.driver", chromeDrvPathLinux);
        System.setProperty("webdriver.gecko.driver", fireFoxDrvPathLinux);
        System.setProperty("webdriver.PhantomJSDriver.driver", phantomJSrvPath);

        String site = "https://tst.bpc-aws.com/";
        String country = "us";

        //String xnavListing = "html/body/section[2]/header/nav/div[2]/ul/li[1]/a/span";

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-gpu --headless --remote-debugging-port=9222 https://chromium.org");
        //WebDriver driver = new ChromeDriver(options);

        //WebDriver driver = new FirefoxDriver();


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSrvPath);

        WebDriver driver = new PhantomJSDriver(caps);


        //HtmlUnitDriver driver = new HtmlUnitDriver();

        //WebDriverWait wait = new WebDriverWait(driver, 10);


        driver.get(site + country);

        Thread.sleep(10000);
        String title = driver.getTitle();
        System.out.println("---------    " + title);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xnavListing)));
    }
}