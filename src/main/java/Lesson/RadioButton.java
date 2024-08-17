package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButton {
    public static void main(String[] args) throws InterruptedException {
        //define elements
        String webUrl = "https://demoqa.com/automation-practice-form";

        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        // get url
        driver.get(webUrl);
        Thread.sleep(1000);

        //choose radio button
        WebElement radBtn = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        // check radio button isSelected

        if(!radBtn.isSelected()){//return true
            System.out.println("Radio Button is not selected");
            radBtn.click();

        }
        else//return false
        {
            System.out.println("Radio Button is selected");
        }
        Thread.sleep(3000);

        //verify IF/ASSERT ket qua chon
        WebElement inputRadBtn = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
        Assert.assertTrue(inputRadBtn.isSelected());

//        if(inputRadBtn.isSelected()){
//            System.out.println("Button Female Gender is selected");
//        }



        Thread.sleep(2000);

        driver.quit();




    }
}
