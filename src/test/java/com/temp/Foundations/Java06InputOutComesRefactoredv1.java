package com.temp.Foundations;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

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

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Java06InputOutComesRefactoredv1 {

	/*
	 * Operators Comparison -> ==,<,>,<=,>=,!=
	 */

	// Inputs
	String rating ;
	String interestRate ;

	// Outcomes
	String statusSuccessful = "Successful";
	String statusNotSuccessful = "Not Successful";
	String statusInvalidRate = "Invalid Rate";

	
	//output
	String bankAccountCreationStatus ;
	String expectedResult ;
	/**
	 * 
	 */

	@Before
	public void beforeTest() {
		System.out.println("**Run Test :  " + name.getMethodName());
	}

	@After
	public void afterTest() {
		System.out.println("**Test Run Completed : " + name.getMethodName());
		System.out.println();
	}

	@Rule
	public TestName name = new TestName();

	
	/**
	 * 
	 * This method returns bank Account Creation Status on the basis of parameters
	 * 
	 * @param rating
	 * @param intrestRate
	 * @return bankAccountCreationStatus
	 */
	public String getBankAccountStatus(String rating, String intrestRate) {
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
			
			
			
/*			if(rating.equalsIgnoreCase(">A") && (Double.parseDouble(interestRate)< 0.2 || Double.parseDouble(interestRate) > 4.0)) {
				bankAccountCreationStatus = statusNotSuccessful ;
				break bankAccountStatus ;
				
			}
			
			if(rating.equalsIgnoreCase(">A") && (Double.parseDouble(interestRate)<= 0.2 || Double.parseDouble(interestRate) <= 4.0)) {
				bankAccountCreationStatus = statusSuccessful ;
				break bankAccountStatus ;
				
			}*/
			
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
	public void testProcessingInputOutComes() {

		/*
		 * Test Approach basis > requirement,design >manual test cases > automation
		 * scripts
		 * 
		 * Test inputs - 	rating >A , <A 
		 * 					interest rate (text field) 
		 * 					positive test 0.2 to 4.0 (ECP = 2.0 happy path) 
		 * 					negative test (valid input) <0.2 or >4.0 
		 * 					negative test (Invalid input) <0 
		 * 					edge case empty - empty , special char, null
		 * 
		 * 
		 * Test Outcomes - 	Status Message 
		 * 					Successful 
		 * 					Not Successful 
		 * 					Invalid Rate
		 */
		
		rating = ">A";
		interestRate = "0.2" ;
		expectedResult = statusSuccessful ;
		
		bankAccountCreationStatus = getBankAccountStatus(rating, interestRate);
		System.out.println("Bank Account Creation Status :" + bankAccountCreationStatus);
		
		Assert.assertEquals(expectedResult,bankAccountCreationStatus);
	}
	
	@Test
	public void testProcessingInputOutComesLessThanANotSuccesful() {

		/*
		 * Test Approach basis > requirement,design >manual test cases > automation
		 * scripts
		 * 
		 * Test inputs - 	rating >A , <A 
		 * 					interest rate (text field) 
		 * 					positive test 0.2 to 4.0 (ECP = 2.0 happy path) 
		 * 					negative test (valid input) <0.2 or >4.0 
		 * 					negative test (Invalid input) <0 
		 * 					edge case empty - empty , special char, null
		 * 
		 * 
		 * Test Outcomes - 	Status Message 
		 * 					Successful 
		 * 					Not Successful 
		 * 					Invalid Rate
		 */
		
		rating = "<A";
		interestRate = "0.2" ;
		expectedResult = statusNotSuccessful ;
		
		bankAccountCreationStatus = getBankAccountStatus(rating, interestRate);
		System.out.println("Bank Account Creation Status :" + bankAccountCreationStatus);
		
		Assert.assertEquals(expectedResult,bankAccountCreationStatus);
	}

}
