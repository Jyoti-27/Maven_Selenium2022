package testNGListeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import selenium_Learning.ScreenshotCaptureDemo;
import testNG_Learning.TestNGDataProviderDemo;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("###############On test Start###################");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("###############On test failure###################");

		try {
			ScreenshotCaptureDemo.getScreenshot(TestNGDataProviderDemo.driver, "onFailure");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("###############On test Success###################");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("###############On test Skipped###################");
	}

}
