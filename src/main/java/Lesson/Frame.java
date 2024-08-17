package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
    public static void main(String[] args) throws InterruptedException {
        //define elements
        String webUrl ="https://netbanking.hdfcbank.com/netbanking/";
        String cusID ="//input[@name='fldLoginUserId']";
        String value ="automationtest";

        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(webUrl);
        Thread.sleep(2000);

        //input Customer ID
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement input = driver.findElement(By.xpath(cusID));
        js.executeScript("document.getElementByName('fldLoginUserId').setAttribute('value','123456');");
// not sendkeys

    }
}
