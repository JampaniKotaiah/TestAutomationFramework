package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtlity;
import com.utility.LoggerUtlity;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtlity.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReport;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtlity.createExtentTest(result.getMethod().getMethodName());
//		  extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtlity.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAIL");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtlity.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtlity.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");

		String scrneenshotpath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the HTML File");

		ExtentReporterUtlity.getTest().addScreenCaptureFromPath(scrneenshotpath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtlity.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suit Started");

		ExtentReporterUtlity.setupSparkReporter("report.html");

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suit Completed!!!");
		ExtentReporterUtlity.flushReport();
	}

}
