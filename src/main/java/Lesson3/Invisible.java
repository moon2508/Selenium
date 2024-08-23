package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Invisible {
    public static void main(String[] args) throws  InterruptedException{
        String url = "https://automationfc.github.io/dynamic-loading/";
        String expectedResult = "Hello World!";

        // get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);


        //Click start BTN
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        // waiting icon
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[@id='finish']"),expectedResult));

        Thread.sleep(1000);
        driver.quit();


    }
}
