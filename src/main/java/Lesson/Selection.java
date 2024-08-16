package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Selection {

    public static void main(String[] args) throws InterruptedException {
        String webUrl = "https://react.semantic-ui.com/maximize/dropdown-example-search-selection";
        String searchSelect = "//input[@class='search']";
        String valueSelect = "Benin";
        String textBox = "//body/div[@id='root']/div[1]/div[1]/div[1]";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(webUrl);
        Thread.sleep(1000);
        //find element
        WebElement elementSel = driver.findElement(By.xpath(searchSelect));
        elementSel.click();

        elementSel.sendKeys(valueSelect);
        elementSel.sendKeys(Keys.ENTER);

        //Verify data
        WebElement data = driver.findElement(By.xpath(textBox));
        Assert.assertEquals(data.getText(),valueSelect);
        Thread.sleep(2000);
//        driver.quit();
    }

}
