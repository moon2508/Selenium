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
        String radioBtn = "//label[contains(text(),'Female')]";



        WebDriver driver = new ChromeDriver();
        // get url
        driver.get(webUrl);
        Thread.sleep(3000);

        //choose radio button
        WebElement radBtn = driver.findElement(By.xpath(radioBtn));
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
        Assert.assertTrue(radBtn.isSelected(),"Verify is failed");

        Thread.sleep(2000);

//        driver.quit();




    }
}
