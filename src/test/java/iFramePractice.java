import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class iFramePractice {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    //@Test
    public void test() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");

        //Selenium can handle just one html
        //this is finding the element of second iframe
        WebElement frame= driver.findElement(By.tagName("iframe"));
        //it is switchiing to sub html(iframe)
        driver.switchTo().frame(frame);

        WebElement element= driver.findElement(By.id("tinymce"));
        element.clear();
        element.sendKeys("something else");
        //this method will switch to default main html
        driver.switchTo().defaultContent();
        WebElement text = driver.findElement(By.xpath("//div//h3"));
        System.out.println(text.getText());

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.toolsqa.com/iframe-practice-page/");
        //int number start from the 0 and it will increase
        WebElement frame1= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(1);

        String name=driver.findElement(By.xpath("/html//div[@id='content']/div[1]/div//span[.='Automation Tools Tutorial']")).getText();
        System.out.println(name);


        WebElement dragable= driver.findElement(By.xpath("iframe"));
        //dragable.click();
        System.out.println(dragable.getText());

    }
    //@Test
    public void test2() throws InterruptedException {
        driver.get("https://www.toolsqa.com/iframe-practice-page/");
        //int number start from the 0 and it will increase
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());
        WebElement frame1= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("iframe1");

        String name=driver.findElement(By.xpath("/html//div[@id='content']/div[1]/div//span[.='Automation Tools Tutorial']")).getText();
        System.out.println(name);}


        //@After
    public void afterMethod() throws InterruptedException {

        //Thread.sleep(3000);
        driver.quit();


    }

}
