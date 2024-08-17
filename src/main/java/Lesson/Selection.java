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
        String valueSelect = "Benin";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(webUrl);
        Thread.sleep(1000);
        //find element
        WebElement elementSel = driver.findElement(By.xpath("//input[@class='search']"));
        elementSel.click();

        elementSel.sendKeys(valueSelect);
        elementSel.sendKeys(Keys.ENTER);

        //Verify data
        WebElement selectedValue = driver.findElement(By.xpath("//div[@class='divider text']"));
        Assert.assertEquals(selectedValue.getText(),valueSelect);
        Thread.sleep(2000);
        driver.quit();
    }

}
