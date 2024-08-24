package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Visible {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://automationfc.github.io/dynamic-loading/";
        String expectedResult = "Hello World!";

        // get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        //Click start BTN
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        // waiting result
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']")));

        //check result
        WebElement result = driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertEquals(result.getText(), expectedResult,"Current result: " + result.getText());


        Thread.sleep(1000);
        driver.quit();


    }
}