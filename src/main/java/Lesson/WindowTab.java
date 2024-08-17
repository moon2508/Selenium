package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.StringReader;

public class WindowTab {
    public static void main(String[] args) throws InterruptedException {
        //define elements
        String webUrl ="https://automationfc.github.io/basic-form/index.html";
        String expectedTitle ="Google";


        WebDriver driver = new ChromeDriver();
        //get url
        driver.get(webUrl);
        String originalWindow = driver.getWindowHandle();


        //Click 'Google'
        driver.findElement(By.xpath("//a[contains(text(),'GOOGLE')]")).click();
        Thread.sleep(2000);
        //Verify title Google


        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        //Switch parent tab
        driver.switchTo().window(originalWindow);



    }
}