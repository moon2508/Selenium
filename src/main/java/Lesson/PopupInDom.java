package Lesson;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PopupInDom {
    public static void main(String[] args) {


    //define elemts
    String weburl ="https://ngoaingu24h.vn/";
    String loginBtn ="//body/div[@id='__next']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]";
    String popup ="//body/div[@id='custom-dialog']/div[3]/div[1]";
    String userTxtBox="//input[@placeholder='Tài khoản đăng nhập']";
    String passTxtBox="//input[@placeholder='Mật khẩu']";
    String value ="automationfc";
    String submitBtn ="//body/div[@id='custom-dialog']/div[3]/div[1]/div[1]/form[1]/div[4]/button[1]";
    String expectedMessage ="Tài khoản không tồn tại ";


    WebDriver driver = new ChromeDriver();

    // get url
    driver.get(weburl);

    //click Dang nhap button
        driver.findElement(By.xpath(loginBtn)).click();

    //check popup displayed
        WebElement popupShow = driver.findElement(By.xpath(popup));
        Assert.assertTrue(popupShow.isDisplayed());

    //Type us= pw= automationfc
        driver.findElement(By.xpath(userTxtBox)).sendKeys(value);
        driver.findElement(By.xpath(passTxtBox)).sendKeys(value);

    //click Dang nhap button
        driver.findElement(By.xpath(submitBtn)).click();

    //verify message

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
    }
}
