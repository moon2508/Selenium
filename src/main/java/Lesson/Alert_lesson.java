package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.testng.Assert;

public class Alert_lesson {
    public static void main(String[] args) throws InterruptedException {
        //define element
        String webUrl="https://automationfc.github.io/basic-form/index.html";
        String alertBtn ="//button[contains(text(),'Click for JS Alert')]";
        String expectMessageAlert = "I am a JS Alert";
        String result ="//p[@id='result']";
        String expectMessage = "You clicked an alert successfully";

        WebDriver driver = new ChromeDriver();
        //get url
        driver.get(webUrl);
        Thread.sleep(1000);

        //choose Click for js allert button
        driver.findElement(By.xpath(alertBtn)).click();

        //verify message - using Assert
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectMessageAlert);


        //Click OK in popup
        alert.accept();
        //verify message result - using Assert
        Assert.assertEquals(driver.findElement(By.xpath(result)).getText(), expectMessage);
    }
}
