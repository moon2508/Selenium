package Lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyHtml5 {
    public static void main(String[] args) throws InterruptedException {
       String url="https://login.ubuntu.com/" ;
       String expectedMessage = "Please fill out this field.";

       //get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        //click login
        driver.findElement(By.xpath("//button[@data-qa-id='login_button']")).click();

        //verify
        WebElement email = driver.findElement(By.xpath("//input[@class='textType']"));
        String validateMessage = email.getAttribute("validationMessage");
        Assert.assertEquals(validateMessage,expectedMessage);

        Thread.sleep(1000);
        driver.quit();
    }
}
