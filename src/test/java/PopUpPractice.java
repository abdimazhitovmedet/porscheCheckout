import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PopUpPractice extends TestBase {
   // @Test
    public void test() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");


        WebElement element=driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']")) ;
        element.click();
        Alert alert =driver.switchTo().alert();
        //TO BE ABLE TO HANDLE POPUP ON THE PAGE WE CAN USE TWO DIFFERENT Method 1-Accept 2-Dismiss
        alert.accept();

        WebElement element1=driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']")) ;
        element1.click();

        alert.dismiss();

        WebElement element2=driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']")) ;
        element2.click();
        Thread.sleep(4000);
        alert.sendKeys("Something else");
        Thread.sleep(4000);
        alert.accept();
    }
    @Test
    public void test1(){
        driver.get("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//div[@class='comparison-container']/div[@class='page-container']/div[3]/button[@class='preview']")).click();
        driver.findElement(By.xpath("//body/div[5]/div[@role='dialog']/div[@class='swal-footer']//button[@class='swal-button swal-button--confirm']")).click();
   // driver.findElement(By.linkText("OK")).click();
    }
}
