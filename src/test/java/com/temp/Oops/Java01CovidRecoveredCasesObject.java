package com.temp.Oops;

import org.junit.Test;

import org.junit.Assert;

/**
 * 
 * @author shiv.mangal
 *
 */

public class Java01CovidRecoveredCasesObject {

	Java01CovidRecoveredCasesClass covid = new Java01CovidRecoveredCasesClass();
	
	@Test
	public void tsetCovidObject() {
		covid.setCountry("India");
		Java01CovidRecoveredCasesClass.setRecovered(1);
		
		covid.printCountry();
		covid.printRecovered();
		covid.printRecovered();
		covid.printRecovered();
		covid.printRecovered();
		
		
	}
	
	@Test
	public void tsetCovidRecoveredCase() {
		Java01CovidRecoveredCasesClass covid = new Java01CovidRecoveredCasesClass("India");
		covid.printCountry();
		
		
		try {
			int expected = 5;
			int actual  = Java01CovidRecoveredCasesClass.getRecovered();
				
			System.out.println("Expected : " + expected);
			System.out.println("Actual : " + actual);
			Assert.assertEquals(expected, actual);
			System.out.println("Test Passed ");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Test Failed ");
			Assert.fail();
		}
	}
	
	
}
