package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {


    public static void main(String[] args) throws InterruptedException {
        String url ="https://automationfc.github.io/dynamic-loading/";
        String expectedResult = "Hello World!";


        // get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        //define implicit wait ( > 2s => TC fail)

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


        //Click start btn
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();


        //check result
        WebElement result = driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertEquals(result.getText(), expectedResult);

        Thread.sleep(1000);
        driver.quit();

    }
}
