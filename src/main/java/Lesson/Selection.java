package Lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Selection {

    public static void main(String[] args) throws InterruptedException {
        String web_url = "https://react.semantic-ui.com/maximize/dropdown-example-search-selection";
        String searchSelect = "//@id=[search]";
        String selectOption = ".visible.menu.transition>div>.text";
        String valueSelect = "Benin";

        WebDriver driver = new ChromeDriver();

        // get url
        driver.get(web_url);
        //find element
        WebElement elementSel = driver.findElement(By.xpath(searchSelect));
        WebElement options = driver.findElement(By.cssSelector(selectOption));
        elementSel.click();
//        Select list = new Select(options);
//        list.selectByValue(valueSelect);
        Thread.sleep(2000);
        driver.quit();
    }

}
