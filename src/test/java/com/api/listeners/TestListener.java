package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("Test suite started : {}", context.getSuite().getName());
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite finished : {}", context.getSuite().getName());
	}

	public void onTestStart(ITestResult result) {
		logger.info("Test case started : {}", result.getMethod().getMethodName());
		logger.info("Test case description : {}", result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test case PASSED : {}", result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Test case FAILED : {}", result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn("Test case SKIPPED : {}", result.getMethod().getMethodName());
	}
}
