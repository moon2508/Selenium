package Lesson1;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Dropdown {
    public static void main(String[] args )throws InterruptedException
    {

        String webUrl = "https://www.rode.com/wheretobuy";
        String optionValue = "Vietnam";
        WebDriver driver = new ChromeDriver();

        // Access website
        driver.get(webUrl);
        //can waiting web
        Thread.sleep(1000);

        //Can check popup truoc khi click elements
        WebElement popup =driver.findElement(By.xpath("//div[@id='RODE-GDPRx']"));
        if(popup.isDisplayed()){
            System.out.println("Popup is displayed. Please click Allow all button");
            //click button
            driver.findElement(By.xpath("//div[contains(text(),'Allow All')]")).click();
            System.out.println("Popup is closed");

        }else {
            System.out.println("Popup is not displayed");
        }
        // find Dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select options = new Select(dropdown);

        //Check button isMultiSelect?
        if(options.isMultiple()){//return true
            System.out.println("Dropdown is chose multiple options");
        }
        else {
            System.out.println("Dropdown is not chose mutilple options");
        }
        // choose Vietnam value
        options.selectByValue(optionValue);
        //Verify selected value
        Assert.assertEquals(options.getFirstSelectedOption().getAttribute("value"),optionValue);

        //press into Search button
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchBtn.click();
        Thread.sleep(3000);
        //print Distributors
        //Get list
        List<WebElement> distributors = driver.findElements(By.xpath("//h4[@class='text-left']"));
        for  (WebElement distributor: distributors){
        System.out.println("Distributor name: " + distributor.getText());
    }

        Thread.sleep(1000);
        driver.quit();




    }

}