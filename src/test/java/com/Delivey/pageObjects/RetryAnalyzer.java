package com.Delivey.pageObjects;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 2; // retry failed test 2 times

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // retry the test
        }
        return false; // stop retrying
    }
}
