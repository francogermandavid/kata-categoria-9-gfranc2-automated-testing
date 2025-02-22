package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public final class ExtentManager {

    private ExtentManager() {
        throw new IllegalStateException("Extent Manager class");
    }

    public static ExtentReports createInstance(final String fileName) {
        ExtentReports extent;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Germán Franco");
        extent.setSystemInfo("Organization", "Banco de Bogotá");
        extent.setSystemInfo("Team", "OpenBanking");

        return extent;
    }

}
