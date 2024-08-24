package Lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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
