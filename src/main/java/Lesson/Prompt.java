package Lesson;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Prompt {
    public static void main(String[] args) {
        //define element
        String webUrl="https://automationfc.github.io/basic-form/index.html";
        String promptBtn ="//button[contains(text(),'Click for JS Prompt')]";
        String expectedMessage ="I am a JS prompt";
        String result ="//p[@id='result']";
        String value ="hangthanh";


        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(webUrl);

        //click JS prompt button
        driver.findElement(By.xpath(promptBtn)).click();

        //verify message
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Assert.assertEquals(text,expectedMessage);

        //Type value and verify value
        alert.sendKeys(value);
        alert.accept();
        String actualResult = driver.findElement(By.xpath(result)).getText();
        Assert.assertEquals(actualResult,"You entered: " + value);

    }
}
