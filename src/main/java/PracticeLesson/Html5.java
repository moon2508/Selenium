package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Html5 {
    public static void main(String[] args) throws InterruptedException {
        String url ="https://login.ubuntu.com/";
        String expectedTxt = "Please fill out this field.";
        WebDriver driver = new ChromeDriver();
        //get url
        driver.get(url);
        Thread.sleep(1000);

        //Click login
        WebElement logBtn = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        logBtn.click();

        //verify
        WebElement email = driver.findElement(By.xpath("//input[@id='id_email']"));
        String validateTxt = email.getAttribute("validationMessage");
        Assert.assertEquals(validateTxt,expectedTxt);

        Thread.sleep(1000);
        driver.quit();
    }
}
