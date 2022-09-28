package genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryimplemenetation implements IRetryAnalyzer {
int count=0;
int maxretires=5;
@Override
public boolean retry(ITestResult result) {
	if(count<maxretires) {
		count++;
		return true;
	}
	return false;
}
}
