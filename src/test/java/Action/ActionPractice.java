package Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionPractice {

    static WebDriver driver;

    @Before
    public void beforeMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();


    }

    //@Test
    public void test() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String location = "/Users/aidaomuralieva/Desktop/TechtorialLOGO.png";
        chooseFile.sendKeys(location);
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
    }


    // @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        Actions action = new Actions(driver);
        WebElement doubleC = driver.findElement(By.id("fold_content"));
        Thread.sleep(2000);
        action.doubleClick(doubleC).perform();
        Thread.sleep(2000);
    }

   // @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        WebElement hoverOver = driver.findElement(By.id("nav-link-accountList"));
        Thread.sleep(2000);
        action.moveToElement(hoverOver).perform();
        Thread.sleep(2000);

    }
    //@Test
    public void test4() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
       action.sendKeys(Keys.PAGE_DOWN).perform();
       Thread.sleep(3000);
       action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_UP).perform();
    }
    //@Test
    public void test5() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions action = new Actions(driver);
        WebElement dragAndDropA = driver.findElement(By.xpath("/html//div[@id='draggable']"));
        WebElement dragAndDropB = driver.findElement(By.xpath("//div[@id='droptarget']/div[@class='test1']"));
        action.moveToElement(dragAndDropA).clickAndHold().moveToElement(dragAndDropB).release().build().perform();
        //action.dragAndDrop(dragAndDropA, dragAndDropB).build().perform();
//action.moveToElement(dragAndDropA).clickAndHold().moveToElement(dragAndDropB,10,150).release().build().perform();
    }
    @Test
    public void test6() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        Actions action = new Actions(driver);
        WebElement dragAndDropA = driver.findElement(By.xpath("/html//div[@id='column-a']"));
        WebElement dragAndDropB = driver.findElement(By.xpath("/html//div[@id='column-b']"));
        action.moveToElement(dragAndDropA).clickAndHold().moveToElement(dragAndDropB).release().build().perform();
        //action.dragAndDrop(dragAndDropA, dragAndDropB).build().perform();
//action.moveToElement(dragAndDropA).clickAndHold().moveToElement(dragAndDropB,10,150).release().build().perform();
    }
    // @After
    public void afterMethod() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();


    }
}
