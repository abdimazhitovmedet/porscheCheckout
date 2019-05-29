package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Inside our page class we need to create the constractor which initilize and final all the elements
    //Easy to forget but very important for page object model
    public LoginPage(WebDriver driver){
        //initElement method will initilizing the webelement of the page
        //we should always initilize the webelement otherwise it wil throw Exeption
        PageFactory.initElements(driver,this);
    }
    //FindBy annotation is used to store the element of the page
    //FindBy annotation is coming from selenium

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement login;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errormessage;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.click();
    }
}
