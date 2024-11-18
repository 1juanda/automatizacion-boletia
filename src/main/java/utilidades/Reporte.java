package utilidades;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporte {

    public static ExtentReports extent;

    public static ExtentReports setupExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
        sparkReporter.config().setReportName("Reporte de Pruebas Boletia");
        sparkReporter.config().setDocumentTitle("Resultados de Automatización Boletia");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Automatizador", "Juan David Coronado");
        return extent;
    }

}
