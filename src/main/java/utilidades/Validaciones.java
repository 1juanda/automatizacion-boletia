package utilidades;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Validaciones {

    WebDriver driver;
    ExtentTest test;

    public Validaciones(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void ValidaPantallaFinal(String valorEncontrar, String valorCompara) throws InterruptedException {
        Thread.sleep(3000);
        String textoEncotrado= driver.findElement(By.xpath("//*[contains(text(), '"+valorEncontrar+"')]")).getText();
        Assert.assertEquals(textoEncotrado,valorCompara);
        test.log(Status.INFO,"Valido el texto de la pantalla final");

    }
}
