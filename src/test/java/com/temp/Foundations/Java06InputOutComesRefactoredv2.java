package com.temp.Foundations;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

/**
 * 
 * @author shiv.mangal
 * 
 *         Application: Business Banking Feature: Create Business Bank Account
 *         Valid Inputs for Successful account creation: Rating > A and Interest
 *         Rate between 0.2 to 4.0 Expected Outcomes: Successful, Not Successful
 *         or Invalid Rate (<0)
 * 
 */

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


@RunWith(DataProviderRunner.class)


public class Java06InputOutComesRefactoredv2 {

	// Inputs
/*	String rating ;
	String interestRate ;
*/
	
	// Outcomes
	String statusSuccessful = "Successful";
	String statusNotSuccessful = "Not Successful";
	String statusInvalidRate = "Invalid Rate";

	
	//output
	String bankAccountCreationStatus ;
	String expectedResult ;
	

	@Before
	public void beforeTest() {
		System.out.println("*************************************************************************\nRun Test :  " + name.getMethodName());
	}

	@After
	public void afterTest() {
		System.out.println("**Test Run Completed : " + name.getMethodName());
		System.out.println("*************************************************************************\n");
	}

	@Rule
	public TestName name = new TestName();
	
	@DataProvider
	public static Object[][] data() {
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


	
	/**
	 * 
	 * This method returns bank Account Creation Status on the basis of parameters
	 * 
	 * @param rating
	 * @param intrestRate
	 * @return bankAccountCreationStatus
	 */
	public String getBankAccountStatus(String rating, String interestRate) {
		String bankAccountCreationStatus = null;
		//Block of code 
		bankAccountStatus: {
			
			//edge case empty - empty , special char, null
			if (interestRate == null || interestRate.isEmpty() || !interestRate.matches("^[-0-9.]+$")) {
				bankAccountCreationStatus = statusInvalidRate;
				break bankAccountStatus ;
			}
			if (Double.parseDouble(interestRate) <= 0) {
				bankAccountCreationStatus = statusInvalidRate;
				break bankAccountStatus ;
			}
			
			if(rating.equalsIgnoreCase("<A")) {
				bankAccountCreationStatus = statusNotSuccessful ;
				break bankAccountStatus ;
				
			}
			
			if(rating.equalsIgnoreCase(">A")) {
				if(Double.parseDouble(interestRate)< 0.2 || Double.parseDouble(interestRate) > 4.0) {
					bankAccountCreationStatus = statusNotSuccessful ;
					break bankAccountStatus ;
					
				}
				
				if(Double.parseDouble(interestRate)<= 0.2 || Double.parseDouble(interestRate) <= 4.0) {
					bankAccountCreationStatus = statusSuccessful ;
					break bankAccountStatus ;
				}
			}
		}

		return bankAccountCreationStatus ;
	}
	
	
	@Test
	@UseDataProvider("data")
	public void testProcessingInputOutComes(String rating, String interestRate, String expectedResult) {
		
		try {
			//rating = ">A";
			//interestRate = "0.2" ;
			//expectedResult = statusSuccessful ;
			
			bankAccountCreationStatus = getBankAccountStatus(rating, interestRate);
			System.out.println("Bank Account Creation Status :" + bankAccountCreationStatus);
			
			Assert.assertEquals(expectedResult,bankAccountCreationStatus);
			System.out.println("Test Passed : ");
		} catch (Exception e) {
			System.out.println("Test Failed : ");
			Assert.fail();
		}catch (AssertionError e) {
			System.out.println("Test Passed : ");
			Assert.fail();
		}
	}
	
	@Test
	@UseDataProvider("smokeTestData")
	public void testProcessingInputOutComesSmokeTestData(String rating, String interestRate, String expectedResult) {
		
		try {
			//rating = ">A";
			//interestRate = "0.2" ;
			expectedResult = statusSuccessful ;
			
			bankAccountCreationStatus = getBankAccountStatus(rating, interestRate);
			System.out.println("Bank Account Creation Status :" + bankAccountCreationStatus);
			
			Assert.assertEquals(expectedResult,bankAccountCreationStatus);
			System.out.println("Test Passed :");
		} catch (Exception e) {
			System.out.println("Test Failed : ");
			Assert.fail();
		}catch (AssertionError e) {
			System.out.println("Test Passed : ");
			Assert.fail();
		}
	}
}
