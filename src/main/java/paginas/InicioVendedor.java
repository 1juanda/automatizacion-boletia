package paginas;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InicioVendedor {

    WebDriver driver;
    ExtentTest test;

    @FindBy(xpath="(//button[normalize-space()='Inicia sesión como vendedor'])[1]")
    public WebElement clickIniciarVendedor;

    @FindBy(xpath="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-3znlpb']")
    public WebElement ingresaUsuarioVendedor;

    @FindBy(xpath="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall MuiInputBase-inputAdornedEnd css-2wl3e3']")
    public WebElement ingresaPasswordVendedor;

    @FindBy(xpath="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-colorPrimary css-1uez4il']")
    public WebElement clickIngresarVendedor;

    public InicioVendedor(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public void daClickIniciarVendedor() throws InterruptedException{
        Thread.sleep(3000);
        clickIniciarVendedor.click();
        test.log(Status.INFO,"Da click en iniciar como vendedor");
    }

    public void ColcaUsuarioVendedor(String usuario) throws InterruptedException{
        Thread.sleep(3000);
        ingresaUsuarioVendedor.sendKeys(usuario);
        test.log(Status.INFO,"Ingresa el usuario del vendedor");
    }

    public void ColocaPasswordVendedor(String pass) throws InterruptedException{
        Thread.sleep(1000);
        ingresaPasswordVendedor.sendKeys(pass);
        test.log(Status.INFO,"Ingresa la contraseña del vendedor");
    }

    public void daClickIngresarVendedor() throws InterruptedException{
        Thread.sleep(2000);
        clickIngresarVendedor.click();
        test.log(Status.INFO,"Da click en ingresar como vendedor");
    }
}