package testBoletia;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paginas.Boleta;
import paginas.InicioVendedor;
import utilidades.Validaciones;
import utilidades.Reporte;
import utilidades.ScreenShot;

import java.io.IOException;
import java.time.Duration;

public class Vendedor {

    public WebDriver driver;
    Boleta landingBoletas;
    InicioVendedor loginVendedor;
    Validaciones validacion;
    ExtentReports extent;
    ExtentTest test;
    String baseUrl = "https://maximus-cupones.plupets.com/";
    Logger log = LoggerFactory.getLogger(Vendedor.class);

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        extent = Reporte.setupExtentReport();
        test = extent.createTest("Test Boletia");
        landingBoletas = new Boleta(driver, test);
        loginVendedor = new InicioVendedor(driver, test);
        validacion= new Validaciones(driver,test);
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @Parameters({"Usuario", "Pass"})
    public void testVendedor(String usuarioVendedor, String password) throws InterruptedException {
        try {
            landingBoletas.daClickBoletasGratis();
            landingBoletas.daClickComprarBoleto();
            loginVendedor.daClickIniciarVendedor();
            loginVendedor.ColcaUsuarioVendedor(usuarioVendedor);
            loginVendedor.ColocaPasswordVendedor(password);
            loginVendedor.daClickIngresarVendedor();

        } catch (Exception e) {
            log.info("Error en el test: " + e);
        }
        validacion.ValidaPantallaFinal("Algo salió mal…","Algo salió mal…");
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws InterruptedException, IOException {
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "El test fue exitoso");
        } else {
            test.log(Status.FAIL, "El test fue Fallido");
        }
        ScreenShot.takeScreenshot(driver, "pantallaFinal");
        extent.flush();
        driver.close();
    }
}