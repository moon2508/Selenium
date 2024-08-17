package Lesson;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PopupInDom {
    public static void main(String[] args) throws InterruptedException {


    //define elemts
    String weburl ="https://ngoaingu24h.vn/";
    String value ="automationfc";
    String expectedMessage ="Tài khoản không tồn tại ";


    WebDriver driver = new ChromeDriver();

    // get url
    driver.get(weburl);

    //click Dang nhap button
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

    //check popup displayed
        WebElement popup = driver.findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper custom-dialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-67lmme']"));
        Assert.assertTrue(popup.isDisplayed());

    //Type us= pw= automationfc
        driver.findElement(By.xpath("//input[@placeholder='Tài khoản đăng nhập']"))
                .sendKeys(value);
        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).
                sendKeys(value);

    //click Dang nhap button
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"))
                .click();

    //verify message

        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals(alert1.getText(),expectedMessage);
        Thread.sleep(1000);
        driver.quit();
    }
}
