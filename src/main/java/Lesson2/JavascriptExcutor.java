package Lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExcutor {
    public static void main(String[] args) throws InterruptedException{
        String url ="http://live.techpanda.org/";
        String expectedDomain = "live.techpanda.org";
        String expectedUrl ="http://live.techpanda.org/";
        String expectMessage = "IPhone was added to your shopping cart.";
        String valueInput = "hang1110@gmail.com";
        String expectedSuccessMess ="Thank you for your subscription.";

        WebDriver driver = new ChromeDriver();

        //get url
        driver.get(url);
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //get domain & verify
        String domain = js.executeScript("return document.domain").toString();
        Assert.assertEquals(domain,expectedDomain);
        //get url & verify

        String webUrl = js.executeScript("return document.URL").toString();
        Assert.assertEquals(webUrl, expectedUrl);
        //click MOBILE
        WebElement mobileLink = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
        js.executeScript("arguments[0].click()", mobileLink);
        Thread.sleep(1000);

        // add a product in cart
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'IPhone')]"));
        js.executeScript("arguments[0].click()",product);
        Thread.sleep(1000);
        WebElement addBtn = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        js.executeScript("arguments[0].click()",addBtn);
        Thread.sleep(1000);

        //verify message
        WebElement successMessage = driver.findElement(By.xpath("//li[@class='success-msg']"));
//        System.out.println(successMessage.getText());
        Assert.assertEquals(successMessage.getText(),expectMessage);

        //scroll down page at 'NEWSLETTER'
        WebElement newsletter = driver.findElement(By.xpath("//span[contains(text(),'Newsletter')]"));
        js.executeScript("arguments[0].scrollIntoView(true);",newsletter);

        //input in newsletter text box
        WebElement input = driver.findElement(By.xpath("//input[@id='newsletter']"));
        js.executeScript("arguments[0].setAttribute('value',arguments[1]);",input,valueInput);

        //Click Subscribe btn
        WebElement subscribeBtn = driver.findElement(By.xpath("//span[contains(text(),'Subscribe')]"));
        js.executeScript("arguments[0].click()", subscribeBtn);


        //verify text = "Thank you for your subscription
        WebElement message = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(message.getText(),expectedSuccessMess);
        Thread.sleep(1000);
        driver.quit();
    }

}
