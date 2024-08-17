package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PopupRandom {
    public static void main(String[] args) {
        //define element
        String webUrl ="https://dehieu.vn/";
        String popup ="//body/div[@id='modalPopupForm']/div[1]/div[1]";
        String closeBtn="//span[contains(text(),'×')]";
        String loginBtn ="//body/div[4]/nav[1]/div[5]/ul[2]/li[7]/a[1]";
        String loginUrl ="https://dehieu.vn/dang-nhap";

        WebDriver driver =  new ChromeDriver();
        //get url
        driver.get(webUrl);

        //Check popup isDisplay?
        WebElement popupElement= driver.findElement(By.xpath(popup));
        if (popupElement.isDisplayed()){
            System.out.println("Popup is displayed");
            driver.findElement(By.xpath(closeBtn)).click();
        }else {
            System.out.println("Popup is not displayed");
        }

        // click login button
        driver.findElement(By.xpath(loginBtn)).click();

        //verify url
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,loginUrl);
    }
}
