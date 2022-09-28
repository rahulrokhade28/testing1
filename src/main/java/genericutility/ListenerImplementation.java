package genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
private ExtentReports rep;
private ExtentTest test;
public static ExtentTest stest;

	
	@Override//@BM
	public void onTestStart(ITestResult result) {
		test=rep.createTest(result.getMethod().getMethodName());
		stest=test;
	}

	@Override//@AM
	public void onTestSuccess(ITestResult result) {
test.pass(result.getMethod().getMethodName()+"pass");
		
	}
/*
 * this is used to store the screenshot photo in screenshot folder
 * new webdriverutility().screenshot(baseclaas.sjv.baseclass
 */
	@Override//@AM
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"fail");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		String path=new webdriverutility().screenshot(BaseTestclass.sdriver);
				test.addScreenCaptureFromBase64String(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	test.skip("Test1 skip");
	test.fail(result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter sp=new ExtentSparkReporter("./extentReport/extentreport.html");
		sp.config().setDocumentTitle("Document title-zoomg");
		sp.config().setReportName("sale and inventory");
		sp.config().setTheme(Theme.DARK);
		rep=new ExtentReports();
		rep.attachReporter(sp);
		rep.setSystemInfo("Author", "rahul");
		rep.setSystemInfo("os","windows 10");
		rep.setSystemInfo("browser", "chrome");
		
			
		
	}

	@Override
	public void onFinish(ITestContext context) {
	rep.flush();
	}

}
