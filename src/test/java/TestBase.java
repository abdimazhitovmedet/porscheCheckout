import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    //@Test
    public void test6() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        Actions action = new Actions(driver);}



    public void switchWindow(String window){
        Set<String>windows= driver.getWindowHandles();
        if(window.contains("http")){
            for (String each:windows){
                driver.switchTo().window(each);
                if(driver.getCurrentUrl().equals(windows)) {
                    break;
                }}
        }
        else{

            for (String each:windows){
                driver.switchTo().window(each);
                if(driver.getTitle().equals(window)){
                    break;
                }
            }}
    }





    //@After
    public void afterMethod() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();


    }
}
