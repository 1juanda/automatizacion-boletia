package paginas;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Boleta {

    WebDriver driver;
    ExtentTest test;

    @FindBy(xpath = "//*[contains(text(), 'GRATIS ')]/following::button[2]")
    public WebElement clickBoletoGratis;

    @FindBy(xpath = "(//button[normalize-space()='Comprar 1 boleto'])[1]")
    public WebElement clickComprarBoleto;

    public Boleta(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void daClickBoletasGratis() throws InterruptedException {
        Thread.sleep(3000);
        clickBoletoGratis.click();
        test.log(Status.INFO,"Da click en boleta gratis");
    }

    public void daClickComprarBoleto() throws InterruptedException {
        Thread.sleep(3000);
        clickComprarBoleto.click();
        test.log(Status.INFO,"Da click en comprar boleto");
    }
}