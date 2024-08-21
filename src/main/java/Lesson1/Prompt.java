package Lesson1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Prompt {
    public static void main(String[] args) throws InterruptedException {
        //define element
        String webUrl="https://automationfc.github.io/basic-form/index.html";
        String expectedMessage ="I am a JS prompt";
        String value ="hangthanh";


        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(webUrl);
        Thread.sleep(1000);

        //click JS prompt button
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();

        //verify message
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);

        //Type value and verify value
        alert.sendKeys(value);
        alert.accept();
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(resultMessage.getText(),"You entered: " + value);
        Thread.sleep(1000);
        driver.quit();

    }
}
