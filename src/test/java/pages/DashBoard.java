package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {
    WebDriver driver;
    //Create constructor
    public  DashBoard(WebDriver driver){
        this.driver = driver;
    }

    //Locators for the page title and the logout button
    By heading = By.xpath("//div[@class=\"main-header\"]");
    By logoutBtn = By.id("submit");

    //Locators for search field and search button
    By searchField = By.id("searchBox");
    By searchBtn = By.xpath("//*[@id=\"basic-addon2\"]");

    //Method to capture the page heading
    public  String getHeading(){
        return driver.findElement(heading).getText();
    }

    public void enterSearchStr(String string){
        driver.findElement(searchField).sendKeys(string);
        System.out.printf(" The search string is %s %n", string);
        driver.findElement(searchBtn).click();
    }

    //Method to click logout button
    public void clickLogout(){
        driver.findElement(logoutBtn).click();
    }

}
