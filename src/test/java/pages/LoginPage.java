package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    //Create constructor
    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    //Locator for username id
    By userName = By.id("userName");
    //Locator for password field
    By psw = By.id("password");

    //Locator for login button
    By loginBtn = By.id("login");

    //Method to enter username
    public void  enterUsername(String user){
        driver.findElement(userName).sendKeys(user);
    }

    //Method to enter password
    public  void enterPassword(String pass){
        driver.findElement(psw).sendKeys(pass);
    }

    //Method to click login button
    public void clickLoginBtn() throws InterruptedException {
        driver.findElement(loginBtn).sendKeys(Keys.RETURN);
        Thread.sleep(1000);
    }

}
