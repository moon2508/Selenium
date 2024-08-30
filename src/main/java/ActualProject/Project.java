package ActualProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
        //choose size

    }
    public void chooseColor(WebDriver driver, String color) throws InterruptedException {
        //choose color
        driver.findElement(By.xpath("//label[@data-name='" + color +"']")).click();
        Thread.sleep(1000);
    }
    public void chooseSize(WebDriver driver, String size) throws InterruptedException {
        //choose size
        driver.findElement(By.xpath("//label[@data-name='" + size +"']")).click();
        Thread.sleep(1000);

    }
    public void setCount(WebDriver driver, String count){
        WebElement inputValue = driver.findElement(By.xpath("//input[@id='quantity']"));
        inputValue.clear();
        inputValue.sendKeys(count);

    }
    public void buyProduct(WebDriver driver, String color, String size) throws InterruptedException {
        chooseColor(driver,color);
        chooseSize(driver, size);
        //Click Mua
        driver.findElement(By.xpath("//button[@id='addQuickCart']")).click();
        Thread.sleep(10000);


    }

    public void addToCart(WebDriver driver, String color, String size) throws InterruptedException {
        chooseColor(driver, color);
        chooseSize(driver,size);
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
        Thread.sleep(1000);
    }

    public void processOrder(WebDriver driver){
        driver.findElement(By.xpath("//a[@class='checkLimitCart linktocheckout button dark']")).click();
    }

    public String getNameProduct(WebDriver driver){
        WebElement name = driver.findElement(By.xpath("//h1[@class='tp_product_detail_name']"));
        return name.getText();

    }
    public  String getPrice(WebDriver driver){
        WebElement price = driver.findElement(By.xpath("//span[@class='pro-price tp_product_detail_price']"));
        return  price.getText();
    }



    public void TC01(WebDriver driver, String url, String username, String password, String value, String color, String size) throws InterruptedException {
        //login
        login(driver, url, username, password);
        Thread.sleep(1000);

        //search product
        search(driver,value);
        Thread.sleep(1000);

        //click detail
        clickDetail(driver);
        Thread.sleep(1000);

        //verify information - product name
        String name = getNameProduct(driver);
//        System.out.println(name);
        Assert.assertEquals(name, value);
        String priceProduct = getPrice(driver);

        //Click Mua
        buyProduct(driver,color, size);
        Thread.sleep(1000);


        //verify  price, color, size, name, count
        String getInfo = driver.findElement(By.xpath("//img[@class='product-thumbnail-image']")).getAttribute("alt");
//        System.out.println(getInfo);
        Thread.sleep(1000);
        String price = driver.findElement(By.xpath("//span[@class='order-summary-emphasis']")).getAttribute("innerHTML");
//        System.out.println(price);
        String count = driver.findElement(By.xpath("//input[@class='tc line-item-qty item-quantity']")).getAttribute("value");
//        System.out.println(count);
        Assert.assertEquals(getInfo, name + " - " + size + " - " + color);
        Assert.assertEquals(price.replaceAll("\\s+", ""),priceProduct);
        Assert.assertEquals(count, "1");

    }

    public void TC02(WebDriver driver, String url, String username, String password, String value, String color, String size) throws InterruptedException {
        //login
        login(driver, url, username, password);
        Thread.sleep(1000);

        //search product
        search(driver,value);
        Thread.sleep(1000);

        //click detail
        clickDetail(driver);
        Thread.sleep(1000);

        //verify information - product name
        String name = getNameProduct(driver);
//        System.out.println(name);
        Assert.assertEquals(name, value);
        String priceProduct = getPrice(driver);

        //Click ADD to cart
        addToCart(driver,color, size);
        Thread.sleep(1000);

        //process order
        processOrder(driver);


        //verify  price, color, size, name, count
        String getInfo = driver.findElement(By.xpath("//img[@class='product-thumbnail-image']")).getAttribute("alt");
//        System.out.println(getInfo);
        Thread.sleep(1000);
        String price = driver.findElement(By.xpath("//span[@class='order-summary-emphasis']")).getAttribute("innerHTML");
//        System.out.println(price);
        String count = driver.findElement(By.xpath("//input[@class='tc line-item-qty item-quantity']")).getAttribute("value");
//        System.out.println(count);
        Assert.assertEquals(getInfo, name + " - " + size + " - " + color);
        Assert.assertEquals(price.replaceAll("\\s+", ""),priceProduct);
        Assert.assertEquals(count, "1");

    }

    public void TC03(WebDriver driver, String url, String username, String password, String value, String color, String size) throws InterruptedException {
        //login
        login(driver, url, username, password);
        Thread.sleep(1000);

        //search product
        search(driver,value);
        Thread.sleep(1000);

        //click detail
        clickDetail(driver);
        Thread.sleep(1000);

        //verify information - product name
        String name = getNameProduct(driver);
//        System.out.println(name);
        Assert.assertEquals(name, value);
        String priceProduct = getPrice(driver);

        //Click ADD to cart
        addToCart(driver,color, size);
        Thread.sleep(1000);

        //process order
        processOrder(driver);


        //verify  price, color, size, name, count
        String getInfo = driver.findElement(By.xpath("//img[@class='product-thumbnail-image']")).getAttribute("alt");
//        System.out.println(getInfo);
        Thread.sleep(1000);
        String price = driver.findElement(By.xpath("//span[@class='order-summary-emphasis']")).getAttribute("innerHTML");
//        System.out.println(price);
        String count = driver.findElement(By.xpath("//input[@class='tc line-item-qty item-quantity']")).getAttribute("value");
//        System.out.println(count);
        Assert.assertEquals(getInfo, name + " - " + size + " - " + color);
        Assert.assertEquals(price.replaceAll("\\s+", ""),priceProduct);
        Assert.assertEquals(count, "1");

    }
    public static void main(String[] args) throws InterruptedException {
        String url = "https://scottplaton.vn/";
        String username ="hangptt@imediatech.com.vn";
        String password = "25082001";
        String product1 = "Áo Tuyển Tập Ngoại Giao Capybara";
        String color ="Forest Green";
        String size = "XL";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Project project = new Project();

        //buy a product
//        project.TC01(driver,url,username,password,product1, color, size );

        //add to cart
        project.TC02(driver,url,username,password,product1, color, size );


        Thread.sleep(1000);
//        driver.quit();


    }
}
