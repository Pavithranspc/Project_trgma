package org.trmga.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerUtility implements IRetryAnalyzer {

	int upperLimit = 3;
	int num = 0;
	
	@Override
	public boolean retry(ITestResult result) {

		if (num<upperLimit) {
			
			num++;
			return true;
			
		}
		
		return false;
	}

}
