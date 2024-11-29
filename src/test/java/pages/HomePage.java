package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    //Create constructor
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

   //Locator for login button
    By loginBtn = By.id("login");

    //Method to click login button
    public void clickLogIn(){
        driver.findElement(loginBtn).click();
    }
}
