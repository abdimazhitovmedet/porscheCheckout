import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectPractice  extends TestBase{
    @Test
    public void test(){
        driver.get("https://www.spicejet.com/");
        WebElement box = driver.findElement(By.xpath("//div[@id='flightSearchContainer']//div[@class='currency-dropdown']/select[@name='ctl00$mainContent$DropDownListCurrency']"));
        Select select = new Select(box);
        select.selectByVisibleText("USD");
        select.selectByValue("AED");
        select.selectByIndex(1);
    }
}
