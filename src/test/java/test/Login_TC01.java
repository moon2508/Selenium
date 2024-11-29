package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.HomePage;
import pages.DashBoard;
public class Login_TC01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");

        driver.manage().window().maximize();

        //Create Object of homePage
        HomePage homePage = new HomePage(driver);

        // Create Object of Login Page
        LoginPage loginPage = new LoginPage(driver);

        //Create Object of Dashboard Page
        DashBoard dashBoard = new DashBoard(driver);

        //Click on Login button
        homePage.clickLogIn();

        //Enter username & password
        loginPage.enterUsername("hangptt");
        loginPage.enterPassword("Hang@123");

        //Click on login button
        loginPage.clickLoginBtn();
        Thread.sleep(1000);

        //Capture the page heading and print console
//        System.out.println(" The page heading is --- "+ dashBoard.getHeading());

        dashBoard.enterSearchStr("Book");
        //Click on logout button
//        dashBoard.clickLogout();

        //Close browser instance
        driver.quit();
        System.out.println("Test is success");
    }
}
