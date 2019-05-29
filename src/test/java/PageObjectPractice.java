import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObjectPractice extends TestBase {


    //@Test
    public void test(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        username.sendKeys("tester");
        password.sendKeys("test") ;
        if (login.isDisplayed()){
            login.click();
        }
        WebElement pageHead = driver.findElement(By.xpath("//h1"));
        // Web orders title should come from the business requirement.
        //Actual will come from the web application
        //Try to avoid ask business requirements from developer
        Assert.assertEquals("Web Orders",pageHead.getText());

    }
   // @Test
    public void test1(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        //i can send the invalid username but valid password
        //i can send the invalid password but valid usermane
        //i can send the invalid username and password
        //password it should include symbols techtorial2019
        username.sendKeys("techtorial");
        password.sendKeys("test");
        login.click();
        WebElement errorMessage= driver.findElement(By.id("ctl00_MainContent_status"));
        Assert.assertEquals("Invalid Login or Password.",errorMessage.getText());

    }

    //@Test
    public void test2(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        LoginPage log = new LoginPage(driver);
        log.login("Tester","test");
//        log.username.sendKeys("Tester");
//        log.password.sendKeys("test");
//        log.login.click();
    }
    @Test
    public void test3(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        LoginPage log = new LoginPage(driver);
        log.username.sendKeys("Tester");
        log.password.sendKeys("test");
        log.login.click();
        MainPage main = new MainPage(driver);
        for(int i=0;i<main.WebOrders.size();i++){
            System.out.println(main.WebOrders.get(i).getText());
        }

    }
}
