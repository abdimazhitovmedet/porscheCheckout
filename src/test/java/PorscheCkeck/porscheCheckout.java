package PorscheCkeck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class porscheCheckout {

    static WebDriver driver;
    @Before
    public void beforeMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
       driver.get("https://www.porsche.com/usa/modelstart/");

    }
    @Test
    public void test1() throws InterruptedException{
        driver.findElement(By.xpath("//div[@class='b-standard-module-wrapper']//img[@alt='Porsche - 718']")).click();
      // driver.findElement(By.xpath("/div[@class='b-standard-module-wrapper']/div[@class='b-teaser-wrapper']/a[@href='/usa/modelstart/all/?modelrange=718']//img[@alt='Porsche - 718']")).click();
       String caymanPrice=driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]")).getText().substring(7,13).replace(",","");
        //driver.findElement(By.xpath("//*[@id=\"m982120\"]/div[1]/div[2]/div[2]")).click();
        driver.get("https://cc.porsche.com/icc_pcna/ccCall.do?rt=1558200381&screen=1280x800&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");
        String totalPrice=driver.findElement(By.xpath("//section[@id='s_iccCca']/div/div[@class='row highlighted priceTotal separator']/div[@class='cca-price']")).getText().substring(1).replace(",","");
       // Assert.assertEquals(caymanPrice,basePrce);
        driver.findElement(By.xpath("//*[@id=\"s_iccCca\"]/div[1]/div[4]/div[1]/span")).click();
        String equpmentPrice=driver.findElement(By.xpath("//section[@id='s_iccCca']/div/div[@class='row']/div[@class='cca-price']")).getText().substring(1).replace(",","");
        Assert.assertEquals("0",equpmentPrice);
        String basePrice= driver.findElement(By.xpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']")).getText().substring(1).replace(",","");
        Assert.assertEquals(caymanPrice,basePrice);
        String deliveryFee = driver.findElement(By.xpath("//*[@id=\'s_iccCca\']/div[1]/div[3]/div[2]")).getText().substring(1).replace(",","");
        Integer deliveryFee1= Integer.valueOf(deliveryFee);
        Integer basePrice1 = Integer.valueOf(basePrice);
        Integer equpmentprice1= Integer.valueOf(equpmentPrice);
        Integer totalPrice1= Integer.valueOf(totalPrice);
        Integer grandTotal=deliveryFee1+equpmentprice1+basePrice1;
        Assert.assertEquals(totalPrice1,grandTotal);
        WebDriverWait wait=new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"s_exterieur_x_FJ5\"]/span"))).click();
        String miamiBlue = driver.findElement(By.xpath("//div[@id='s_exterieur_x_IAF']//div[@style='visibility: visible;']")).getText().substring(1).replace(",","");
        Integer miamiBlue1=Integer.valueOf(miamiBlue);
        //Thread.sleep(3000);
        String equpmentPriceC=driver.findElement(By.xpath("//section[@id='s_iccCca']/div/div[@class='row']/div[@class='cca-price']")).getText().substring(1).replace(",","");
        Integer equpmentPriceC1=Integer.valueOf(equpmentPriceC);
        Assert.assertEquals(equpmentPriceC1,miamiBlue1);
        Integer grandTotal1=deliveryFee1+equpmentPriceC1+basePrice1;
        String totalPrice2=driver.findElement(By.xpath("//section[@id='s_iccCca']/div/div[@class='row highlighted priceTotal separator']/div[@class='cca-price']")).getText().substring(1).replace(",","");
        Integer totalPrice3= Integer.valueOf(totalPrice2);
        Assert.assertEquals(totalPrice3,grandTotal1);

//        driver.findElement(By.id("s_exterieur_x_MXRD")).click();
//        String carrera = driver.findElement(By.xpath("/div[@id='s_exterieur_x_IRA']//div[.='$3,750']")).getText().substring(1).replace(",","");
//        Integer carrera1=Integer.valueOf(carrera);
//        System.out.println(carrera1);
//        System.out.println(carrera);
       driver.findElement(By.xpath("//li[@id='s_exterieur_x_MXRD']")).click();
        String sWheels=driver.findElement(By.xpath("//div[@id='s_exterieur_x_IRA']//div[@class='content']//div[@class='tt_price tt_cell']")).getText().substring(1).replace(",","");
        int sw=Integer.parseInt(sWheels);
        Assert.assertEquals("Sport Wheels price are different", 3750, sw);
    //        Actions action = new Actions(driver) ;
    //        action.click(driver.findElement(By.id("s_interieur_x_PP06"))).click();

//15
      //driver.findElement(By.id("s_interieur_x_PP06")).click();

    driver.findElement(By.xpath("//div[@id='seatGroup_73']//div[@data-camera-command='set_SeatsMemory']")).click();

        String seatPrice=driver.findElement(By.xpath("//div[@id='seats_73']//div[@data-camera-command='set_SeatsMemory']//div[@class='pBox']")).getText().substring(1).replace(",", "");
        int sP=Integer.parseInt(seatPrice);
        Assert.assertEquals("Seat price are different", 2330,sP);
//18
       // driver.findElement(By.xpath("//span[@id='vs_table_IIC_x_PEKH_x_c01_PEKH']")).click();

        JavascriptExecutor cb = (JavascriptExecutor)driver;
        cb.executeScript("scroll(0, 2600);");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IIC_subHdl']"))).click();
        WebElement icfi=driver.findElement(By.xpath("//section[@id='vs_table_IIC']//div[@id='vs_table_IIC_x_PEKH']//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']"));
        Actions actions2=new Actions(driver);
        actions2.moveToElement(icfi).click().build().perform();

       String carbonPrice= driver.findElement(By.xpath("//section[@id='s_individual']//div[@id='s_individual_x_IIC']//div[@class='content']//section[@id='vs_table_IIC']//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']")).getText().substring(1).replace(",","");
        int cbp=Integer.parseInt(carbonPrice);
        Assert.assertEquals("Carbon Filter price is different",1540,cbp);
       String basePriceAfterCarbon = driver.findElement(By.xpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']")).getText().substring(1).replace(",","");
        Integer BPAC= Integer.valueOf(basePriceAfterCarbon);

//22
        JavascriptExecutor performance = (JavascriptExecutor)driver;
        performance.executeScript("scroll(0, 2300);");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IMG_subHdl']"))).click();;

//23
        WebElement pdk= driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']"));
        pdk.click();
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("scroll(0, 2300)");
        String pdkP=driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']//div[@class='box']//div[@class='pBox']")).getText();
        pdkP=pdkP.substring(1).replace(",", "");
        int pdkp=Integer.parseInt(pdkP);
        Assert.assertEquals("Porsche Doppelkupplung price is different",3210,pdkp);


        //Task 24. Select Porsche Ceramic Composite Brakes
        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("scroll(0, 3100)");
        Thread.sleep(2000);
        WebElement pccb=driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450_x_c84_M450_x_shorttext']"));
        pccb.click();

        String pccbPrice=driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450']//div[@class='box']//div[@class='pBox']")).getText();
        pccbPrice=pccbPrice.substring(1).replace(",", "");
        int pccbP=Integer.parseInt(pccbPrice);
        Assert.assertEquals("Porsche Ceramic Composite Brakes price is different", 7410, pccbP);





    }

    //@After
    public void afterMethod(){


        driver.quit();


    }

}
