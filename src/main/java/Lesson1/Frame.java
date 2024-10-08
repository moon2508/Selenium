package Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Frame {
    public static void main(String[] args) throws InterruptedException {
        //define elements
        String webUrl ="https://netbanking.hdfcbank.com/netbanking/";
        String value ="automationtest";

        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(webUrl);
        Thread.sleep(2000);
        WebElement frame = driver.findElement(By.name("login_page"));
        driver.switchTo().frame(frame);

        //sendkey
       driver.findElement(By.xpath("//input[@name='fldLoginUserId']"))
               .sendKeys(value);


       driver.findElement(By.xpath("//a[contains(text(), 'CONTINUE')]")).click();
       Thread.sleep(15000);


        //verify Password textbox

        driver.switchTo().defaultContent();
        WebElement passTxtBtn = driver.findElement(By.xpath("//input[@id='keyboard']"));
        Assert.assertTrue(passTxtBtn.isDisplayed());

        Thread.sleep(1000);
        driver.quit();

    }
}
