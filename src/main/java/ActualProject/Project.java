package ActualProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project {

    public  void login(WebDriver driver, String url, String username, String password) throws InterruptedException {
        // get url
        driver.get(url);

        // click login Btn
        driver.findElement(By.xpath("//span[contains(text(),'Tài khoản')]")).click();
        Thread.sleep(1000);

        //login
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='btnsignin']")).click();


    }
    public  void search(WebDriver driver, String value) throws InterruptedException{
        //input value
      driver.findElement(By.xpath("//input[@class='searchInput']")).sendKeys(value);
      driver.findElement(By.xpath("//input[@class='btnSearch']")).click();
      Thread.sleep(1000);

    }
    public void clickDetail(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//h3[@class='pro-name']")).click();
        Thread.sleep(1000);

    }
    public String getNameProduct(WebDriver driver){
        WebElement name = driver.findElement(By.xpath("//h1[@class='tp_product_detail_name']"));
        return name.getText();

    }
    public String getColorProduct(WebDriver driver){
        WebElement color = driver.findElement(By.xpath("//span[@class='nameColor']"));
        return color.getText();

    }
    public void TC01(WebDriver driver, String url, String username, String password, String value) throws InterruptedException {
        //login
        login(driver, url, username, password);
        Thread.sleep(1000);
        //search product
        search(driver,value);
        Thread.sleep(1000);
        //click detail
        clickDetail(driver);
        Thread.sleep(1000);
        //get information
        String name = getNameProduct(driver);
        System.out.println(name);

        String color = getColorProduct(driver);
        System.out.println(color);



    }

    public static void main(String[] args) throws InterruptedException {
        String url = "https://scottplaton.vn/";
        String username ="hangptt@imediatech.com.vn";
        String password = "25082001";
        String product1 = "Áo Tuyển Tập Ngoại Giao Capybara";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Project project = new Project();

        project.TC01(driver,url,username,password,product1);


        Thread.sleep(1000);
        driver.quit();


    }
}
