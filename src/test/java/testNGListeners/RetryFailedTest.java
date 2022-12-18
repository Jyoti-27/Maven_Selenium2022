package testNGListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

	int count = 0;
	int retrylimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (count < retrylimit) {
			count++; // o/p count=1, next o/p count=1
			System.out.println("Retrying with attempt-" + count);
			return true; // retry
		}

		return false; // if o/p count>2 then false
	}

}
