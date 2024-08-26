package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JsExecutor {
    public static void main(String[] args) throws InterruptedException {
        String url = "http://live.techpanda.org/";
        String expectedDomain = "live.techpanda.org";
        String expectedSuccessMsg ="IPhone was added to your shopping cart.";
        String valueInput ="hangptt250801@gmail.com";
        String expectedTxtMsg ="Thank you for your subscription.";

        WebDriver driver = new ChromeDriver();
        //get url

        driver.get(url);
        Thread.sleep(1000);

        //use JavascriptExecutor - verify domain
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String currentDomain = js.executeScript("return document.domain").toString();
        Assert.assertEquals(currentDomain, expectedDomain);

        //use JavascriptExecutor - verify url
        String currentUrl = js.executeScript("return document.URL").toString();
        Assert.assertEquals(currentUrl, url);

        //Click MOBILE
        WebElement mobileTxt = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
        js.executeScript("arguments[0].click()",mobileTxt);

        // add a product
        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'IPhone')]"));
        js.executeScript("arguments[0].click()", product);

        WebElement addBtn = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        js.executeScript("arguments[0].click()",addBtn);
        Thread.sleep(1000);

        //verify success message

        WebElement successMsg = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(successMsg.getText(),expectedSuccessMsg);

        //Scroll into NEWSLETTER
        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'Newsletter')]"));
        js.executeScript("arguments[0].scrollIntoView(true)", text);

        //input into textbox
        WebElement txtBox = driver.findElement(By.xpath("//input[@id='newsletter']"));
        js.executeScript("arguments[0].setAttribute('value', arguments[1])", txtBox,valueInput);

        //Click Subscribe
        WebElement subBtn = driver.findElement(By.xpath("//span[contains(text(),'Subscribe')]"));
        js.executeScript("arguments[0].click()",subBtn);

        //verify text
        WebElement txtMsg = driver.findElement(By.xpath("//li[@class='success-msg']"));
        Assert.assertEquals(txtMsg.getText(),expectedTxtMsg);

        Thread.sleep(1000);
        driver.quit();
    }
}
