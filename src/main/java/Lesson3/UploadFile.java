package Lesson3;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UploadFile {
    public static void main(String[] args) throws InterruptedException {
        String url ="https://blueimp.github.io/jQuery-File-Upload/";
//        String path ="H:/";
        String image1 ="H:/image1.png";
        String image2 ="H:/image2.png";
        String image3 ="H:/image3.png";

        //get url
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //sendkeys image
        WebElement addBtn = driver.findElement(By.xpath("//input[@name='files[]']"));

        addBtn.sendKeys(image1);
        Thread.sleep(3000);
        addBtn.sendKeys(image2);
        Thread.sleep(3000);
        addBtn.sendKeys(image3);
        Thread.sleep(3000);

        //Check upload process successfully
        List <WebElement> file = driver.findElements(By.xpath("//p[@class='name']"));



        Thread.sleep(10000);
        driver.quit();

    }
}
