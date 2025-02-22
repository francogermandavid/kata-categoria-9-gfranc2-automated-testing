package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ExtentListeners implements ITestListener {

    private static String fileName = "AutomationReport.html";

    private static ExtentReports extent = ExtentManager.createInstance(fileName);

    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();


    @Override
    public void onTestStart(final ITestResult result) {

        ExtentTest test = extent.createTest(
                result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(final ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(m);
    }

    @Override
    public void onTestFailure(final ITestResult result) {

        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
                + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" + exceptionMessage.replace(",", "<br>") + "</details>"
                + " \n");

        String failureLogg = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, m);
    }

    @Override
    public void onFinish(final ITestContext context) {

        if (extent != null) {
            extent.flush();
        }
    }

    public void remove() {
        testReport.remove();
    }
}
