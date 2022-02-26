package com.temp.Oops;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 * 
 * Base Test extended by all test cases
 * 
 * @author shiv.mangal
 *
 */

public class BaseTest {

	BankAdvanceAccountCreationApp bankAccount ;
	
	@Before
	public void beforeTest() {
		if(bankAccount == null) {
			bankAccount = new BankAdvanceAccountCreationApp();	
		}
		System.out.println("*************************************************************************\nRun Test :  " + name.getMethodName());
	}



	@Rule
	public TestName name = new TestName();
	
	
	@DataProvider
	public static Object[][] regressionAdvanceTestData() {
		return new Object[][] {
				{">A","2.0","current account","Successful"},
				{">A","4.1","current account","Not Successful"},
				{"<A","2.0","current account","Not Successful"},
				{"<A","-1","current account","Invalid Rate"},
				{">A","%","current account","Invalid Rate"},
				{">A","","current account","Invalid Rate"},
				{">A",null,"current account","Invalid Rate"}
		};
	}
	
	@DataProvider
	public static Object[][] regressionTestData() {
		return new Object[][] {
				{">A","2.0","Successful"},
				{">A","4.1","Not Successful"},
				{"<A","2.0","Not Successful"},
				{"<A","-1","Invalid Rate"},
				{">A","%","Invalid Rate"},
				{">A","","Invalid Rate"},
				{">A",null,"Invalid Rate"}
		};
	}
	
	@DataProvider
	public static Object[][] smokeTestData() {
		return new Object[][] {
				{">A","2.0","Successful"}
		};
	}


	@After
	public void afterTest() {
		System.out.println("**Test Run Completed : " + name.getMethodName());
		System.out.println("*************************************************************************\n");
	}	
		
}
