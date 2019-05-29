import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class WindowPractice  extends TestBase{

    @Test
    public void test(){
        driver.get("http://the-internet.herokuapp.com/windows");
        //this method will return Id for current page
        String defaultWindow= driver.getWindowHandle();
       // System.out.println(defaultWindow);

        //getWindowHandles() method will return all the tabs which are opened. Rerurn type is SET

        driver.findElement(By.xpath("//div[@id='content']//a[@href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        for (String each: windows){
            if (!each.equals(defaultWindow)){
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
            }
            System.out.println(each);
        }


    }
}
