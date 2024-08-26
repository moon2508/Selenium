package PracticeLesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class UploadFile {
    public static void main(String[] args) throws InterruptedException{
        String url ="https://blueimp.github.io/jQuery-File-Upload/ ";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(url);

        // set property
        String path = System.getProperty("user.dir");

        String image1 = path + "/image/image1.png";
        String image2 = path + "/image/image2.png";
        String image3 = path + "/image/image3.png";

        //sendkeys

        WebElement inputBtn = driver.findElement(By.xpath("//input[@name='files[]']"));
        inputBtn.sendKeys(image1 + "\n "+ image2 + "\n" + image3);

        // check loading success

        List <WebElement> files = driver.findElements(By.xpath("//button[@class='btn btn-success edit']"));

        for (WebElement file : files ){
            Assert.assertTrue(file.isDisplayed());
        }

        // click start button
        driver.findElement(By.xpath("//span[contains(text(),'Start upload')]")).click();
        Thread.sleep(1000);

        //check upload success
        List <WebElement> lists = driver.findElements(By.xpath("//span[text()[normalize-space() = 'Delete']]"));

        for(WebElement list : lists){
            Assert.assertTrue(list.isDisplayed());
        }

        Thread.sleep(1000);
        driver.quit();






    }

}
