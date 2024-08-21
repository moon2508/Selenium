package Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PopupRandom {
    public static void main(String[] args) throws InterruptedException {
        //define element
        String webUrl ="https://dehieu.vn/";
        String expectedUrl ="https://dehieu.vn/signin?redirect=https%3A%2F%2Fdehieu.vn%2F";

        WebDriver driver =  new ChromeDriver();
        //get url
        driver.get(webUrl);

        //Check popup isDisplay?
        WebElement popup= driver.findElement(By.xpath("//div[@class='modal-content css-modal-bt']"));
        if (popup.isDisplayed()){
            System.out.println("Popup is displayed");
            driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
        }else {
            System.out.println("Popup is not displayed");
        }

        // click login button
        driver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]")).click();

        //verify url
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl, "Current url "+ currentUrl);
        Thread.sleep(1000);
        driver.quit();
    }
}
