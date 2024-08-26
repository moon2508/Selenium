package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Invisible {
    public static void main(String[] args) throws  InterruptedException {
        String url = "https://automationfc.github.io/dynamic-loading/ ";
        String expectedTxt ="Hello World!";
        WebDriver driver =new ChromeDriver();
        //get url
        driver.get(url);

        // Click start btn

        WebElement startBtn = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
        startBtn.click();

        //Wait loading icon invisible

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

        //Check result text is: “Hello World”
        WebElement result = driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertEquals(result.getText(), expectedTxt);

        Thread.sleep(1000);
        driver.quit();

    }
}
