package com.temp.Oops;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;

import com.tngtech.java.junit.dataprovider.UseDataProvider;
@RunWith(DataProviderRunner.class)

public class BankAccountAppTest extends BaseTest {
	
	
	
	@Test
	@UseDataProvider("regressionTestData")
	public void testProcessingInputOutComes(String rating, String interestRate, String expectedResult) {
		
		try {
			
			String bankAccountCreationStatus = bankAccount.getBankAccountStatus(rating, interestRate);
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
		
			String bankAccountCreationStatus = bankAccount.getBankAccountStatus(rating, interestRate) ;
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
	
	@Test
	@UseDataProvider("regressionAdvanceTestData")
	public void testProcessingRegressionAdvanceTestData(String rating, String interestRate, String accountType, String expectedResult) {
		
		try {
			
			String bankAccountCreationStatus = bankAccount.getBankAccountStatus(rating, interestRate,accountType) ;
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
