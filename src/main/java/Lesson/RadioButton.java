package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // get url
        driver.get("https://demoqa.com/automation-practice-form");
        //choose radio button
        WebElement radBtn = driver.findElement(By.xpath("//*[@id = 'gender-radio-2']"));
        // check radio button isSelected
        boolean isSelected = radBtn.isSelected();
        if(isSelected == false){
            WebElement btnRadlabel= driver.findElement(By.xpath("//label[@for ='gender-radio-2']"));
            btnRadlabel.click();
        }
        else
        {
            System.out.println("Radio Button is selected");
        }

        boolean isChecked = radBtn.isSelected();
        System.out.println("Sport Checked: " + isChecked);

        Thread.sleep(2000);

        driver.quit();




    }
}
