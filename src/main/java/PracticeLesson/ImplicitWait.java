package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ImplicitWait {
    public static void main(String[] args) throws InterruptedException{

        String url  = "https://automationfc.github.io/dynamic-loading/";
        String expectedTxt ="Hello World!";

        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(url);

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement startBtn = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        startBtn.click();

        //check result
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement result = driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertEquals(result.getText(), expectedTxt);
        Thread.sleep(1000);
        driver.quit();

    }
}
