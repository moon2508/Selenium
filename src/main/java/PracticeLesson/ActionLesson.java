package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;

public class ActionLesson {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://live.techpanda.org/";
        String expectMessage = "IPhone was added to your shopping cart.";
        String valueInput = "hang1110@gmail.com";
        String expectedSuccessMess ="Thank you for your subscription.";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(url);
        Thread.sleep(1000);


        Actions action = new Actions(driver);
        //Click Mobile
        WebElement mobileBtn = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
        action.click(mobileBtn).perform();

        //add product
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'IPhone')]"));
        action.click(product).perform();
        WebElement addBtn = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        action.click(addBtn).perform();
        Thread.sleep(1000);

        //verify message
        WebElement successMsg = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(successMsg.getText(),expectMessage);


        //Scroll into newsletter
        WebElement txt = driver.findElement(By.xpath("//span[contains(text(),'Newsletter')]"));
        WheelInput.ScrollOrigin elementOrigin = WheelInput.ScrollOrigin.fromElement(txt);
        action.scrollFromOrigin(elementOrigin, 0, 300).perform();

        // input value
        WebElement input =  driver.findElement(By.xpath("//input[@id='newsletter']"));
        action.sendKeys(input,valueInput).perform();

        //click Subscribe
        WebElement subscribeBtn = driver.findElement(By.xpath("//span[contains(text(),'Subscribe')]"));
        action.click(subscribeBtn).perform();

        //verify text
        WebElement txtMsg = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(txtMsg.getText(),expectedSuccessMess);

        Thread.sleep(1000);
        driver.quit();



    }
}
