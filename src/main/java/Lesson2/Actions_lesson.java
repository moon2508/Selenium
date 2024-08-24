package Lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;

public class Actions_lesson {
    public static void main(String[] args) throws InterruptedException {
        String url ="http://live.techpanda.org/";
        String expectMessage = "IPhone was added to your shopping cart.";
        String valueInput = "hang1110@gmail.com";
        String expectedSuccessMess ="Thank you for your subscription.";

        //get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);

        //Click MOBILE
        Actions action = new Actions(driver);
        WebElement mobileLink = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));

        action.click(mobileLink).perform();

        //add a product
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'IPhone')]"));
        action.click(product).perform();
        WebElement addBtn = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        action.click(addBtn).perform();
        Thread.sleep(1000);

        //verify message
        WebElement successMessage = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(successMessage.getText(),expectMessage);

        //scroll into newsletter
        WebElement newsletter = driver.findElement(By.xpath("//span[contains(text(),'Newsletter')]"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(newsletter);
        action.scrollFromOrigin(scrollOrigin,0,300).perform();

        //input value
        WebElement input = driver.findElement(By.xpath("//input[@id='newsletter']"));
        action.sendKeys(input,valueInput).perform();
        //click Subscribe btn
        WebElement subscribeBtn = driver.findElement(By.xpath("//span[contains(text(),'Subscribe')]"));
        action.click(subscribeBtn).perform();
        //verify message
        WebElement message = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(message.getText(),expectedSuccessMess);
        Thread.sleep(1000);
        driver.quit();
    }
}
