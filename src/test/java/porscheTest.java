

    import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
    public class porscheTest {
        static WebDriver driver;
        @Before
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        public static Integer strConvert(String str, int startPosition) {
            str = str.trim().substring(startPosition).replace(",", "");
            Integer sum = Integer.valueOf(str);
            return sum;
        }
        public static Integer strConvertTwo(String str, int startPosition, int endPosition) {
            str = str.trim().substring(startPosition, endPosition).replace(",", "");
            Integer sum = Integer.valueOf(str);
            return sum;
        }
        public static WebElement findElementByXpath(String str) {
            WebElement element = driver.findElement(By.xpath(str));
            return element;
        }
        @Test
        public void runPorsche() throws InterruptedException {
            driver.get("https://www.porsche.com/usa/modelstart/"); // go to website
            findElementByXpath("//span[contains(text(),'718')]").click(); //find and click 718 porsche
            Integer startPriceOf718 = strConvertTwo(findElementByXpath("//div[@id='m982120']//div[@class='m-14-model-price']")
                    .getText(), 7, 13); // 56900
//        findElementByXpath("//div[contains(text(),'From $ 56,900.00*')]"); // just found didn't click cause no needs
            driver.get("https://cc.porsche.com/icc_pcna/ccCall.do?rt=1558217919&screen=1536x864&userID=USM&lang=us&PARAM=parameter_internet_us&ORDERTYPE=982120&CNR=C02&MODELYEAR=2019&hookURL=https%3a%2f%2fwww.porsche.com%2fusa%2fmodelstart%2fall%2f");
            findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-label']/span[@class='expandButton']").click(); //expand button
            Integer basePriceNextPage = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']")
                    .getText(), 1);
            Assert.assertEquals(startPriceOf718, basePriceNextPage); // check start price and base price on next page
            Integer equipmentPrice = strConvert(findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-price']")
                    .getText(), 1);
            Assert.assertEquals(Integer.valueOf(0), equipmentPrice); // check "0" and equipmentPrice
            Integer totalPrice = strConvert(findElementByXpath("//div[@class='cca-price'][contains(text(),'$58,150')]").getText(), 1);
            Integer basePrice = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']").getText(), 1);
            Integer feeBox = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[3]/div[@class='cca-price']").getText(), 1);
            Integer expectedTPrice = (basePrice + feeBox + equipmentPrice);
            Assert.assertEquals(expectedTPrice, totalPrice);
            findElementByXpath("//span[@style='background-color: rgb(0, 120, 138);']").click();
            Integer priceBlueMiami = strConvert(findElementByXpath("//div[@class='cca-price'][contains(text(),'$2,580')]").getText(), 1);
            Integer eqPriceBoxBlueMiami = strConvert(findElementByXpath("//div[@class='cca-price'][contains(text(),'$2,580')]").getText(), 1);
            Assert.assertEquals(priceBlueMiami, eqPriceBoxBlueMiami);
            Integer totalPriceAfterBlueMiami = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[1]/div[@class='cca-price']").getText(), 1);
            Integer equipmentPriceBlueMiami = strConvert(findElementByXpath("//*[@id=\"s_iccCca\"]/div[1]/div[3]/div[2]").getText(), 1);
            Integer basePriceBlueMiami = strConvert(findElementByXpath("//div[@class='cca-price'][contains(text(),'$56,900')]").getText(), 1);
            Integer expectedBlueMiamiPrice = (priceBlueMiami + basePriceBlueMiami + equipmentPriceBlueMiami);
            Assert.assertEquals(totalPriceAfterBlueMiami, expectedBlueMiamiPrice);
//        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//li[@id='s_exterieur_x_MXRD']//span[@class='img-element']"))).click();
            findElementByXpath("//li[@id='s_exterieur_x_MXRD']").click();
            Integer priceForEqWithWheels = strConvert(findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-price']").getText(), 1);
            Integer expectedWheelPlusBlueMiami = strConvert(findElementByXpath("//div[@id='s_exterieur_x_IRA']//div[.='$3,750']").getText(), 1)
                    + strConvert(findElementByXpath("//div[@id='s_exterieur_x_IAF']//div[.='$2,580']").getText(), 1);
            Assert.assertEquals(priceForEqWithWheels, expectedWheelPlusBlueMiami);
            // sctroll down page to find that element
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, 1800);");
            Thread.sleep(2000);
            driver.findElement(By.id("s_interieur_x_73_x_PP06_x_shorttext")).click(); //click after scroll down
            Integer totalPiceAfterSeats = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[1]/div[@class='cca-price']").getText(), 1);
            Integer basePriceAfterSeats = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']").getText(), 1);
            Integer feeAfterSeats = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[3]/div[@class='cca-price']").getText(), 1);
            Integer eqPriceAfterSeats = strConvert(findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-price']\n").getText(), 1);
            Integer priceForSeats = strConvert(findElementByXpath("//div[contains(text(),'$2,330')]").getText(), 1);
            Integer sumAfterSeats = (priceBlueMiami + strConvert(findElementByXpath("//div[contains(text(),'$3,750')]").getText(), 1)
                    + strConvert(findElementByXpath("//div[contains(text(),'$2,330')]").getText(), 1));
            Assert.assertEquals(eqPriceAfterSeats, sumAfterSeats); //16task
            Integer sumCompareAfterSeats = basePriceAfterSeats + eqPriceAfterSeats + feeAfterSeats;
            Assert.assertEquals(totalPiceAfterSeats, sumCompareAfterSeats); // 17 task
            // Scroll down again and try to find two elements and click on them, task 18
            JavascriptExecutor jse2 = (JavascriptExecutor) driver;
            jse2.executeScript("scroll(0, 2600);");
            Thread.sleep(3000);
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='IIC_subHdl']"))).click();
//        findElementByXpath("//div[@id='IIC_subHdl']").click();
//        findElementByXpath("//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']").click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext']"))).click();
            //task20
            Integer totalPriceAfterCarbon = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[1]/div[@class='cca-price']").getText(), 1);
            Integer basePriceAfterCarbon = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']").getText(), 1);
            Integer feeAfterCarbon = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[3]/div[@class='cca-price']").getText(), 1);
            Integer eqPriceAfterCarbon = strConvert(findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-price']").getText(), 1);
            Integer priceForColorMBAfterCarbon = strConvert(findElementByXpath("//div[@id='s_exterieur_x_IAF']//div[@class='tt_price tt_cell']").getText(), 1);
            Integer priceForWheelsAfterCarbon = strConvert(findElementByXpath("//div[@id='s_exterieur_x_IRA']//div[@class='tt_price tt_cell']").getText(), 1);
            Integer priceForSeatsAfterCarbon = strConvert(findElementByXpath("//div[contains(text(),'$2,330')]").getText(), 1);
            Integer priceForCarbonInterior = strConvert(findElementByXpath("//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']/div[.='$1,540']").getText(), 1);
            Integer sumAfterCarbon = priceForColorMBAfterCarbon + priceForWheelsAfterCarbon + priceForSeatsAfterCarbon + priceForCarbonInterior;
            Assert.assertEquals(eqPriceAfterCarbon, sumAfterCarbon);
            // task21
            Integer sumCheckAfterCarbon = basePriceAfterCarbon + eqPriceAfterCarbon + feeAfterCarbon;
            Assert.assertEquals(totalPriceAfterCarbon, sumCheckAfterCarbon);
            //task22
            JavascriptExecutor jse3 = (JavascriptExecutor) driver;
            jse3.executeScript("window.scrollBy(0,-250)", "");
//        jse2.executeScript("scroll(0, -10);");
            Thread.sleep(2000);
            findElementByXpath("//div[@id='IMG_subHdl']").click();
            Thread.sleep(2000);
            findElementByXpath("//div[@id='vs_table_IMG_x_M250_x_c14_M250_x_shorttext']").click(); //23task
            JavascriptExecutor jse4 = (JavascriptExecutor) driver;
            jse4.executeScript("window.scrollBy(0, 600)");
            Thread.sleep(2000);
            findElementByXpath("//div[@id='vs_table_IMG_x_M450_x_c84_M450_x_shorttext']").click(); //24task
            //task25
            Integer totalPriceAfterPerformance = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[1]/div[@class='cca-price']").getText(), 1);
            Integer basePriceAfterPerformance = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[2]/div[@class='cca-price']").getText(), 1);
            Integer feeAfterPerformance = strConvert(findElementByXpath("//section[@id='s_iccCca']/div[@class='table']/div[3]/div[@class='cca-price']").getText(), 1);
            Integer eqPriceAfterPerformance = strConvert(findElementByXpath("//section[@id='s_iccCca']//div[@class='row']/div[@class='cca-price']").getText(), 1);
            Integer priceForColorMBAfterPerformance = strConvert(findElementByXpath("//div[@id='s_exterieur_x_IAF']//div[@class='tt_price tt_cell']").getText(), 1);
            Integer priceForWheelsAfterPerformance = strConvert(findElementByXpath("//div[@id='s_exterieur_x_IRA']//div[@class='tt_price tt_cell']").getText(), 1);
            Integer priceForSeatsAfterPerformance = strConvert(findElementByXpath("//div[contains(text(),'$2,330')]").getText(), 1);
            Integer priceForCarbonPerformance = strConvert(findElementByXpath("//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']/div[.='$1,540']").getText(), 1);
            Integer sumAfterPerformance = priceForColorMBAfterCarbon + priceForWheelsAfterCarbon + priceForSeatsAfterCarbon + priceForCarbonInterior;
            Integer sevenSpeedPDKPrice = strConvert(findElementByXpath("//div[contains(text(),'$3,210')]").getText(), 1);
            Integer brakesPCCB = strConvert(findElementByXpath("//div[contains(text(),'$7,410')]").getText(), 1);
            Integer sumAfterPerformanceBrakeSpeed = priceForColorMBAfterPerformance + priceForWheelsAfterPerformance + priceForSeatsAfterPerformance + priceForCarbonPerformance
                    + sevenSpeedPDKPrice + brakesPCCB;
            Assert.assertEquals(eqPriceAfterPerformance, sumAfterPerformanceBrakeSpeed); // task 25
            //task26
            Integer sumAfterAll = basePriceAfterPerformance + eqPriceAfterPerformance + feeAfterPerformance;
            Assert.assertEquals(totalPriceAfterPerformance, sumAfterAll);

//    @After
//    public void after() throws InterruptedException {
//        Thread.sleep(30000);
//        driver.close();
//    }
        }
    }

