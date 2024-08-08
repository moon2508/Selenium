package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Selection {

    public static void main(String[] args) throws InterruptedException {
        String web_url = "https://react.semantic-ui.com/maximize/dropdown-example-search-selection";
        String searchSelect = "//input[@class='search']";
        String selectOption = ".visible.menu.transition>.selected.item>span";
        String valueSelect = "Benin";
        String textbox = ".divider.text";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(web_url);
        //find element
        WebElement elementSel = driver.findElement(By.xpath(searchSelect));
        elementSel.click();

        WebElement options = driver.findElement(By.cssSelector(selectOption));
        elementSel.sendKeys(valueSelect);
        elementSel.sendKeys(Keys.ENTER);

        //Verify data
        WebElement data = driver.findElement(By.cssSelector(textbox));
        Assert.assertEquals(data.getText(),valueSelect);
        Thread.sleep(2000);
        driver.quit();
    }

}
