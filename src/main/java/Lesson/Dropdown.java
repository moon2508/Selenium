package Lesson;
import java.lang.Exception.*;

import org.testng.Assert;
import org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

public class Dropdown {
    public static void main(String[] args )throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        // Access website
        driver.get("https://www.rode.com/wheretobuy");
        // find Dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        // Check dropdown
        boolean isSelected = dropdown.isSelected();
        if(isSelected == false){
            //check Dropdown isMultiSelect
            Select list = new Select(dropdown);
            boolean result = list.isMultiple();
            System.out.println("Dropdown isMultiple Select "+ result);
            //Choose Vietnam value
            list.selectByValue("Vietnam");
            // Check selectedValue
            WebElement selectedOption = list.getFirstSelectedOption();
            Assert.assertEquals(selectedOption.getAttribute("value"),"Vietnam");


        }

        else {
            System.out.println("Dropdown Checked " + isSelected);
        }
        //press into Search button
        WebElement button = driver.findElement(By.xpath("//button[@class= 'btn btn-default']"));
        button.click();
        //Print Distributor name



        Thread.sleep(2000);
//        driver.quit();

    }
}