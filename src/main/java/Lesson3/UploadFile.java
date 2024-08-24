package Lesson3;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UploadFile {
    public static void main(String[] args) throws InterruptedException {
        String url ="https://blueimp.github.io/jQuery-File-Upload/";

        //get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(1000);
        String path = System.getProperty("user.dir");
        String image1 = path + "/image/image1.png";
        String image2 = path + "/image/image2.png";
        String image3 = path + "/image/image3.png";

        System.out.println(path);

        //sendkeys image

//       String[] images = {image1,image2,image3};
//       for (String image : images){
//           WebElement addBtn = driver.findElement(By.xpath("//input[@name='files[]']"));
//           addBtn.sendKeys(image);
//       }
        WebElement addBtn = driver.findElement(By.xpath("//input[@name='files[]']"));
        addBtn.sendKeys(image1 +"\n"+ image2 + "\n" +image3);

        //Check loading success
        List <WebElement> images = driver.findElements(By.xpath("//button[@class ='btn btn-success edit']"));

        for (WebElement image: images){
            Assert.assertTrue(image.isDisplayed());
        }

        //Click start btn
        driver.findElement(By.xpath("//span[contains(text(),'Start upload')]")).click();
        Thread.sleep(2000);

        // check file upload success - check loading btn invisible

       List <WebElement> delBtns = driver.findElements(By.xpath("//span[text()[normalize-space() = 'Delete']]"));
        for (WebElement delBtn : delBtns){
            Assert.assertTrue(delBtn.isDisplayed());
        }
        Thread.sleep(1000);
        driver.quit();

    }
}
