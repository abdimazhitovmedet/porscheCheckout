import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HoverOver extends TestBase {


    @Test
    public void test() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.cssSelector(".example .figure:nth-child(3) [alt]"))).perform();
        String user1=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText();
        System.out.println(user1);
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.cssSelector(".example .figure:nth-child(4) [alt]"))).perform();
        String user2=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText();
        System.out.println(user2);
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.cssSelector(".example .figure:nth-child(5) [alt]"))).perform();
        String user3=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();
        System.out.println(user3);

    }
}
