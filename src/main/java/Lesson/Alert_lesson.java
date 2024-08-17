package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.testng.Assert;

public class Alert_lesson {
    public static void main(String[] args) throws InterruptedException {
        //define element
        String webUrl="https://automationfc.github.io/basic-form/index.html";
        String expectMessageAlert = "I am a JS Alert";
        String expectMessage = "You clicked an alert successfully";

        WebDriver driver = new ChromeDriver();
        //get url
        driver.get(webUrl);
        Thread.sleep(1000);

        //choose Click for js allert button
        WebElement alertBtn = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        alertBtn.click();

        //verify message - using Assert
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectMessageAlert);


        //Click OK in popup
        alert.accept();
        //verify message result - using Assert
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertEquals(resultMessage.getText(), expectMessage);
        Thread.sleep(1000);
        driver.quit();
    }
}
