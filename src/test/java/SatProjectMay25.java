import org.junit.Test;
import org.openqa.selenium.By;

public class SatProjectMay25 extends TestBase{

    @Test
    public void test() throws InterruptedException{
     //   WebElement element=driver.findElement(By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']")) ;
//        element.click();
////        Alert alert =driver.switchTo().alert();
//       Actions action =new Actions(driver);
//       action.sendKeys(Keys.PAGE_DOWN).perform();
//        alert.


        driver.get("https://calculator.s3.amazonaws.com/index.html");
        //1ROW
        driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//tr[@class='footer']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table'][1]//td[@class='cell'][4]//img")).click();
        driver.findElement(By.xpath("//input[@id='gwt-uid-199']")).click();
        driver.findElement(By.xpath("//button[.='Close and Save']")).click();
       driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[1]")).sendKeys("T1 Linux Micro (Free)");

       //2ROW
        driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//tr[@class='footer']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table'][2]//td[@class='cell'][4]//img")).click();
        driver.findElement(By.xpath("//div[.='t2.micro']/../preceding-sibling::td/span/input")).click();
        driver.findElement(By.xpath("//button[.='Close and Save']")).click();
        driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[2]")).sendKeys("T1 Linux Micro 2");

        //3ROW
        driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//tr[@class='footer']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table'][3]//td[@class='cell'][4]//img")).click();
        driver.findElement(By.xpath("//div[.='t2.medium']/../preceding-sibling::td/span/input")).click();
        driver.findElement(By.xpath("//button[.='Close and Save']")).click();
        driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[3]")).sendKeys("T1 Linux Medium");

        //4ROW
        driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//tr[@class='footer']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table'][4]//td[@class='cell'][4]//img")).click();
        driver.findElement(By.xpath("//div[.='t2.large']/../preceding-sibling::td/span/input")).click();
        driver.findElement(By.xpath("//button[.='Close and Save']")).click();
        driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[4]")).sendKeys("T1 Linux Large");

        //5ROW
        driver.findElement(By.xpath("//div[@class='cell Instances rowsSection']//tr[@class='footer']//img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table'][5]//td[@class='cell'][4]//img")).click();
        driver.findElement(By.xpath("//div[.='t2.xlarge']/../preceding-sibling::td/span/input")).click();
        driver.findElement(By.xpath("//button[.='Close and Save']")).click();
        driver.findElement(By.xpath("(//table[@class='SF_EC2_INSTANCE_FIELD_DESCRIPTION field textField']//input[@class='gwt-TextBox input'])[5]")).sendKeys("T1 Linux XtraLarge)");
    }

}
