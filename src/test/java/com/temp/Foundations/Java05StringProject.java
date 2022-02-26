package com.temp.Foundations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 */

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Java05StringProject {
	
	/**
	 * Bank Transaction Message (Ex: Transaction TN1230000001 was successfully completed), 
	 * Bank Transaction Status (Pending), 
	 * BusinessName and Amount
	 */
	
	private String actualBankTransactionMessage = "Transaction TN1230000001 was successfully completed";
	private String actualBankTransactionStatus = "Pending";
	private String actualBankBusinessName = "Abc Inc." ; 
	private String actualBankAmount = "$5000764";
	
	
	@Before
	public void beforeTest() {
		System.out.println("**Run Test :  "+ name.getMethodName() );
	}
	
	@After
	public void afterTest() {
		System.out.println("**Test Run Completed : " + name.getMethodName() );
		System.out.println();
	}
	
	@Rule
	public TestName name = new TestName();
	
	
	
	/**
	 * 
	 * 
	 */
	@Test
	public void test01TransactionLowerUpperCase() {
		String strLowercase = actualBankTransactionMessage.toLowerCase();
		System.out.println(strLowercase);
		
	}
	
	@Test
	public void test02TransactionIgnoreCase() {
		try {
			String expectedBankTransactionStatus = "pending";
			Assert.assertTrue(expectedBankTransactionStatus.equalsIgnoreCase(actualBankTransactionStatus));
			System.out.println("Test Passed");
		} catch (AssertionError e) {
			System.out.println("Test Failed");
		}
		
	}
	
	@Test
	public void test03TransactionContains() {
		try {
			String  expected = "successfully completed" ;
			boolean actual = actualBankTransactionMessage.contains(expected);
			Assert.assertTrue(actual);
			System.out.println("Test Passed");
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test04TransactionStartsWith() {
		try {
			String  expected = "Transaction" ;
			boolean actual = actualBankTransactionMessage.startsWith(expected);
			Assert.assertTrue(actual);
			System.out.println("Test Passed");
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test05TransactionEndsWith() {
		try {
			String  expected = "completed" ;
			boolean actual = actualBankTransactionMessage.endsWith(expected);
			Assert.assertTrue(actual);
			System.out.println("Test Passed");
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test06TransactionEmpty() {
		try {
			String  APIBankTransactionMessage = "Transaction TN1230000001 was successfully completed";
//			String  APIBankTransactionMessage = "";
			boolean empty = APIBankTransactionMessage.isEmpty();
			System.out.println("APIBankTransactionMessage : " + APIBankTransactionMessage);
			Assert.assertTrue(!empty);
			System.out.println("Test Passed");
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test07TransactionNUll() {
		try {
			String  APIBankTransactionMessage = "test";
			boolean nullValue = (APIBankTransactionMessage!=null);
			System.out.println("nullValue : " + nullValue);
			
			System.out.println("APIBankTransactionMessage : " + APIBankTransactionMessage);
			
			Assert.assertNotNull(APIBankTransactionMessage);
			System.out.println("Test Passed : "+ APIBankTransactionMessage);
		
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test08TransactionMatches() {
		try {
			actualBankBusinessName = "ABC Ltd";
			String regEx = "^[a-zA-Z. ]+$";
			
			boolean name = actualBankBusinessName.matches(regEx);
			System.out.println("Name : "+ name);
			
			Assert.assertTrue(Pattern.matches(regEx, actualBankBusinessName));
			System.out.println("Test Passed : "+ name);
			
		
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	@Test
	public void test09TransactionTrim() {
		try {
			String expected = "ABC Ltd." ;
			System.out.println("Expected : "+ expected);
			
			actualBankBusinessName = "     ABC Ltd.   ";
			System.out.println("actualBankBusinessName : "+ actualBankBusinessName);
			System.out.println("After Trim : "+ actualBankBusinessName.trim());
			
		
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	
	@Test
	public void test10TransactionExtract() {
		try {
			actualBankTransactionMessage = "Transaction TN1230000001 was successfully completed" ; 
			System.out.println("TN No : "+ actualBankTransactionMessage.substring(12, 25));
			
			String regEx = "(TN\\d+)";
			Pattern pattern = Pattern.compile(regEx);
			Matcher match = pattern.matcher(actualBankTransactionMessage);
			
			while (match.find()) {
				System.out.println("Matched Group : " + match.group(1));
			}
		
		} catch (AssertionError e) {
			System.out.println("Test Fail");
			Assert.fail();
		}
		
	}
	
	
}
