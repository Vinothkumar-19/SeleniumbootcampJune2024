package org.testngwithbaseclassexcelintegration.copy;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedRetry implements IRetryAnalyzer  {
	
	int count=0;
	int max_count=3;
	

	@Override
	public boolean retry(ITestResult result) 
	{
		while(count<max_count){
			count++;
			return true;
			
			
		}
		return false;
	}

}
