package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private static Object TimeUnit;

    public static void main(String[] args) throws InterruptedException {
        String url ="https://automationfc.github.io/dynamic-loading/";
        String expectedResult = "Hello World!";
        int timeout = 20;

        // get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        //define implicit wait ( > 2s => TC fail)
        if(timeout == 2){
            driver.manage().timeouts().implicitlyWait(timeout, java.util.concurrent.TimeUnit.SECONDS);
            System.out.println("This page is not responded");;

        }else {
            driver.manage().timeouts().implicitlyWait(timeout, java.util.concurrent.TimeUnit.SECONDS);

        }

        //Click start btn
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();


        //check result
        WebElement result = driver.findElement(By.xpath("//div[@id='finish']"));
        Assert.assertEquals(result.getText(), expectedResult);

        Thread.sleep(1000);
        driver.quit();

    }
}
