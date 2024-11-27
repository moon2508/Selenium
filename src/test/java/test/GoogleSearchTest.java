package test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages. GoogleSearchPage;
public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
    googleSearch();
    }
    public static void googleSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        Thread.sleep(1000);
//        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
        GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step");
        GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
//        driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
//        driver.close();
    }
}
