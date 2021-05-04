import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void titleTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ponomid/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        //navigate to url
        driver.get("https://www.selenium.dev/");
        // click button Documentation text on header
        WebElement documentationTextButton = driver.findElement(By.xpath("//nav/a[3]"));
        documentationTextButton.click();
        //type 'element' in search field
        Thread.sleep(1000);
        driver.findElement(By.id("search-by")).sendKeys("element");
        //click first result
        Thread.sleep(1000);
        WebElement firstResult = driver.findElement(By.xpath("//div[@data-title='Web element']"));
        firstResult.click();
        //assert text 'Web element' on header
        WebElement pageTitleWE = driver.findElement(By.tagName("h1"));
        String pageTitle = pageTitleWE.getText();
        Assert.assertEquals(pageTitle, "Web element");

        Thread.sleep(2000);
        driver.quit();


    }
}
