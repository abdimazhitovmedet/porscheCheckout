import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomeWorkSwitchWindow extends TestBase {

   // @Test
    public void HomeWork1(){
        driver.get("https://www.quirksmode.org/iframetest.html");

        WebElement frame= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);

        String text=driver.findElement(By.xpath("/html//h1[.='Test page in iframe']")).getText();
        System.out.println(text);
    }
  // @Test
    public void HomeWork2(){
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        Actions action = new Actions(driver);
        //5000-1
        WebElement source= driver.findElement(By.xpath("/html//li[@id='fourth']/a[@class='button button-orange']"));
        WebElement target = driver.findElement(By.xpath("/html//main[@id='g-mainbar']/div[@class='g-grid']/div[@class='g-block size-100']//div[@class='item-page']/table/tbody/tr/td[1]/table//tr/td[2]/div[@class='shoppingCart']//ol[@class='field13 ui-droppable ui-sortable']/li[@class='placeholder']"));
        action.dragAndDrop(source,target).perform();
        //5000-2
        WebElement source2= driver.findElement(By.xpath("//div[@id='products']//ul/li[4]/a[@class='button button-orange']"));
        WebElement target2 = driver.findElement(By.xpath("/html//main[@id='g-mainbar']/div[@class='g-grid']/div[@class='g-block size-100']//div[@class='item-page']/table/tbody/tr/td[2]/table//tr/td[2]/div[@class='shoppingCart']//ol[@class='field13 ui-droppable ui-sortable']/li[@class='placeholder']"));
        action.dragAndDrop(source2,target2).perform();
        //BANK
        WebElement sourceBANK= driver.findElement(By.xpath("//div[@id='products']//li[@class='block14 ui-draggable']/a[@class='button button-orange']"));
        WebElement targetBANK = driver.findElement(By.xpath("//ol[@id='bank']/li[@class='placeholder']"));
        action.dragAndDrop(sourceBANK,targetBANK).perform();
        //SALES
        WebElement sourceSALES= driver.findElement(By.xpath("//div[@id='products']//li[@class='block15 ui-draggable']/a[@class='button button-orange']"));
        WebElement targetSALES= driver.findElement(By.xpath("//ol[@id='loan']/li[@class='placeholder']"));
        action.dragAndDrop(sourceSALES,targetSALES).perform();
    }

    @Test
    public void HomeWork3() {
        driver.get("https://www.toolsqa.com/iframe-practice-page/");
        WebElement element = driver.findElement(By.tagName("iframe"));
//        JavascriptExecutor cb = (JavascriptExecutor)driver;
//        cb.executeScript("scroll(0, 1000);");
//        Actions action = new Actions(driver);
//        action.moveToElement(element).click().build().perform();
//        driver.switchTo().frame(1);
//        //action.moveToElement(driver.findElement(By.xpath("//div[@id='page']/div[@role='banner']//a[@href='https://www.toolsqa.com/']/img[@alt='TOOLSQA']")));
//        driver.findElement(By.xpath("//div[@id='page']/div[@role='banner']//a[@href='https://www.toolsqa.com/']/img[@alt='TOOLSQA']")).click();
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println(frames.size());
        driver.switchTo().frame("iframe2");
       String sortable= driver.findElement(By.xpath("//div[@id='sidebar']/aside[1]/ul//a[@href='https://demoqa.com/sortable/']")).getText();
        System.out.println(sortable);


    }



}
