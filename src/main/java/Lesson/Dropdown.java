package Lesson;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Dropdown {
    public static void main(String[] args )throws InterruptedException
    {
        //define element
        String webUrl = "https://www.rode.com/wheretobuy";
        String dropDown = "//select[@id='country']";
        String popup ="//div[@id='RODE-GDPRx']";
        String allowButton ="//div[contains(text(),'Allow All')]";
        String searchButton ="//button[contains(text(),'Search')]";
        String distributor="//h4[@class='text-left']";

        String optionValue = "Vietnam";
        WebDriver driver = new ChromeDriver();

        // Access website
        driver.get(webUrl);
        //can waiting web
        Thread.sleep(2000);

        //Can check popup truoc khi click elements
        if(driver.findElement(By.xpath(popup)).isDisplayed()){
            System.out.println("Popup is displayed. Please click Allow all button");
            //click button
            driver.findElement(By.xpath(allowButton)).click();
            System.out.println("Popup is closed");

        }else {
            System.out.println("Popup is not displayed");
        }
        // find Dropdown
        WebElement dropdown = driver.findElement(By.xpath(dropDown));
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
        Assert.assertEquals(options.getFirstSelectedOption().getAttribute("value"),optionValue, "Verify selected value is failed");

        //press into Search button
        driver.findElement(By.xpath(searchButton)).click();
        Thread.sleep(3000);
        //print Distributors
        //Get list
        List<WebElement> distributors = driver.findElements(By.xpath(distributor));
        int count = distributors.size();
        System.out.println("Number of distributors:"+ count);
        for(int i = 0; i< count; i++){
            System.out.println((i+1) + " Distributor Name: " + distributors.get(i).getText());

        }
        Thread.sleep(3000);




    }

}