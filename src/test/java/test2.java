
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
public class test2 {


    WebDriver driver;

    @Before

    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.porsche.com/usa/modelstart");
    }


    @Test

    public void test() throws InterruptedException{

        //Select model 718
        driver.findElement(By.xpath("//a[@href='/usa/modelstart/all/?modelrange=718']")).click();;

        //Price of 718 Cayman
        String cayman718 = driver.findElement(By.xpath("//div[@class='m-14-model-name']//following::div[@class='m-14-model-price']")).getText();
        cayman718 = cayman718.substring(7,13).replace(",", "");
        int cm=Integer.parseInt(cayman718);

        driver.get("https://cc.porsche.com/icc_pcna/ccCall.do?rt=1558201355&screen=1280x800&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");

        WebElement button = driver.findElement(By.xpath("//*[@id=\'s_iccCca\']/div[1]/div[4]/div[1]/span"));
        button.click();

        String basePrice = driver.findElement(By.xpath("//div[@class='row highlighted priceTotal separator']//following::div[@class='row additional']/div[2]")).getText();		basePrice = basePrice.substring(1).replace(",", "");
        int prB=Integer.parseInt(basePrice);
        Assert.assertEquals("Base price is not verified", 56900, prB);
        System.out.println("Base price: $"+prB);


        String equipment=driver.findElement(By.xpath("//div[@class='row']/div[2]")).getText();
        equipment=equipment.substring(1).replace(",", "");
        int eq=Integer.parseInt(equipment);
        System.out.println("Price for Equipment: $"+equipment);
        Assert.assertEquals("price equipment is not equal to 0", 0, eq);


        String delivery=driver.findElement(By.xpath("//section[@id='s_iccCca']//following::div[@class='row additional'][2]//div[@class='cca-price']")).getText();
        delivery=delivery.substring(1).replace(",", "");
        int del=Integer.parseInt(delivery);
        System.out.println("Delivery, Processing and Handling: $"+del);
        Assert.assertEquals("Delivery is not free",1250, del);

        String totalPrice=driver.findElement(By.xpath("//section[@id='s_iccCca']//div[@class='row highlighted priceTotal separator']//div[@class='cca-price']")).getText();
        totalPrice=totalPrice.substring(1).replace(",", "");
        int ttl=Integer.parseInt(totalPrice);
        System.out.println("Total price $"+ttl+" is the sum of base price $"+prB+" and delivery,processing and handling fee $"+del);
        Assert.assertEquals("prices are not same", 58150, ttl);


        int totalP=prB+eq+del;


        System.out.println("=================================================");

        // Task9. Select color "Mami Blue"
        WebElement color=driver.findElement(By.xpath("//span[@style='background-color: rgb(0, 120, 138);']"));
        color.click();

        String miamiBlue=driver.findElement(By.xpath("//div[@id='s_exterieur_x_IAF']//div[@class='content recommendContainer hideRecommendationFootnote']"
                + "//div[@class='tt']//div[@class='tt_row']//div[@style='visibility: visible;']")).getText();
        miamiBlue=miamiBlue.substring(1).replace(",", "");
        int miami=Integer.parseInt(miamiBlue);
        Assert.assertEquals("Miami Blue color's price is different", 2580, miami);

        //Task 10.
        System.out.println("Price for Equipment is equal to Miami Blue price $"+miami);

        //Task 11.
        System.out.println("Total price is $"+totalP+" the sum of base price $"+prB+" and price for equipment "+eq+" and deliver,processing and handling fee $"+del);


        System.out.println("=================================================");

        //Task 12. Select 20" Carrera Sport Wheels
        WebElement wheels=driver.findElement(By.xpath("//li[@id='s_exterieur_x_MXRD']"));
        wheels.click();

        String sWheels=driver.findElement(By.xpath("//div[@id='s_exterieur_x_IRA']//div[@class='content']//div[@class='tt_price tt_cell']")).getText();
        sWheels=sWheels.substring(1).replace(",", "");
        int sw=Integer.parseInt(sWheels);
        Assert.assertEquals("Sport Wheels price are different", 3750, sw);

        //Task 13.
        int equipmentP=miami+sw;
        System.out.println("Price for Equipment is $"+equipmentP+" the sum of Miami Blue price $"+miami+" and 20' Carrera Sport Wheels $"+sw);

        //Task 14.
        System.out.println("Total price is $"+totalP+" the sum of base price $"+prB+" price for equipment $"+equipmentP+" and deliver,processing and handling fee $"+del);

        System.out.println("=================================================");

        //Task 15. Select "Power Sport Seats Seats (14-way) with Memory Package"
        WebElement seat=driver.findElement(By.xpath("//div[@id='seatGroup_73']//div[@data-camera-command='set_SeatsMemory']"));
        seat.click();

        String seatPrice=driver.findElement(By.xpath("//div[@id='seats_73']//div[@data-camera-command='set_SeatsMemory']//div[@class='pBox']")).getText();
        seatPrice=seatPrice.substring(1).replace(",", "");
        int sP=Integer.parseInt(seatPrice);
        Assert.assertEquals("Seat price are different", 2330,sP);

        //Task 16.
        int eqP=miami+sw+sP;
        System.out.println("Price for Equipment is $"+eqP+" the sum of Miami Blue price $"+miami+" and 20' Carrera Sport Wheels $"+sw+" Power Sport Seats = $"+sP);

        //Task 17.
        System.out.println("Total price is $"+totalP+" the sum of base price $"+prB+" price for equipment $"+eqP+" and deliver,processing and handling fee $"+del);

        System.out.println("=================================================");

        //Task 18. Click on Interior Carbon Fiber
        JavascriptExecutor cb = (JavascriptExecutor)driver;
        cb.executeScript("scroll(0, 2600);");
        Thread.sleep(3000);
        //Interior Carbon Fiber button
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IIC_subHdl']"))).click();


        //Task 19.
        WebElement icfi=driver.findElement(By.xpath("//section[@id='vs_table_IIC']//div[@id='vs_table_IIC_x_PEKH']//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']"));
        Actions actions2=new Actions(driver);
        actions2.moveToElement(icfi).click().build().perform();

        String carbonPrice=driver.findElement(By.xpath("//section[@id='s_individual']//div[@id='s_individual_x_IIC']//div[@class='content']//section[@id='vs_table_IIC']//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']")).getText();
        carbonPrice=carbonPrice.substring(1).replace(",", "");
        int cbp=Integer.parseInt(carbonPrice);
        Assert.assertEquals("Carbon Filter price is different",1540,cbp);


        //Task 20.
        int eqPr=miami+sw+sP+cbp;
        System.out.println("Price for Equipment is $"+eqPr+" the sum of Miami Blue price $"+miami+" and 20' Carrera Sport Wheels $"+sw+" Power Sport Seats $"+sP);

        //Task 21.
        System.out.println("Total price is $"+totalP+" the sum of base price $"+prB+" price for equipment $"+eqPr+" and deliver,processing and handling fee $"+del);

        System.out.println("=================================================");

        //Task 22. Click on Performance
        JavascriptExecutor performance = (JavascriptExecutor)driver;
        performance.executeScript("scroll(0, 2300);");
        Thread.sleep(3000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IMG_subHdl']"))).click();;
        Thread.sleep(3000);


        // Task 23. Select 7-speed Porsche Doppelkupplung
        WebElement pdk= driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']"));
        pdk.click();
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("scroll(0, 2300)");
        Thread.sleep(2000);

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

        //Task 25.
        int eqPrice=miami+sw+sP+cbp+pdkp+pccbP;
        System.out.println("Price for Equipment is the sum of Miami Blue price $"+miami+" and 20' Carrera Sport Wheels $"+sw+" Power Sport Seats  $"
                +sP+" Interior Trim in Carbon Fiber i.c.w. Standard Interior $"+eq+" 7-speed Porsche Doppelkupplung $"+pdkp+" Porsche Ceramic Composite Brakes $"+pccbP);

        //Task 26.
        System.out.println("Total price $"+totalP+" is the sum of base price $"+prB+" price for equipment $"+eqPrice+" and deliver,processing and hangling fee $"+del);


        //TotalPrice
        int sumOfTotal=prB+eq+del+miami+sw+sP+cbp+pdkp+pccbP;
        System.out.println("Total price of your Porche Cayman 718 is: $"+sumOfTotal);


    }

    @After
    public void end() {

        driver.quit();
    }}