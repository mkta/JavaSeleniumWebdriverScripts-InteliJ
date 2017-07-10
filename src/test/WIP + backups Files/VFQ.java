import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by catalinf on 03-Apr-17.
 */
public class VFQ {

    @Test
    public void test() throws InterruptedException {

        String chromeDrvPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDrvPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        int prodloop;
        int prodloops = 19;
        int prodd = 2;
        for (prodloop = prodloops; prodloop < 20; prodloop++) {

            driver.get("https://vfq-preprod.pjmedia.co.uk/");
            Actions actions = new Actions(driver);
            WebElement moveonmenu = driver.findElement(By.xpath("html/body/div[3]/div/header/nav/div/div/div/div[4]/div/div/div[1]/div[1]/ul/li[1]/a"));
            actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("html/body/div[3]/div/header/nav/div/div/div/div[4]/div/div/div[2]/div[1]/div[2]/div[2]/a"))).click().perform();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //phone listing
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/div/div/div[3]/div[2]/div/div/div/ul/li[" + prodd + "]/div/div[3]/a")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[3]/div/div/div/div[3]/div[2]/div/div/div/ul/li[" + prodd + "]/div/div[3]/a")));
            WebElement footer = driver.findElement(By.xpath("html/body/div[3]/div/footer"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", footer);
            WebElement CTAbutton = driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[3]/div[2]/div/div/div/ul/li[" + prodd + "]/div/div[3]/a"));
            actions.moveToElement(CTAbutton).click().perform();
            driver.findElement(By.xpath("html/body/div[3]/div/div/div/div[3]/div[2]/div/div/div/ul/li[" + prodd + "]/div/div[3]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[4]/div/div/div[2]/h1")));
            //phone detail
            if (driver.findElements(By.xpath("html/body/div[4]/div/div/div[2]/div[1]/div[3]/div/div/div[3]/form/button")).size() != 0) {
                System.out.println("on stokc");
            } else {
                System.out.println("out of stock");
            }
        }
    }
}

