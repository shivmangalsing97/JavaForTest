package com.temp.Foundations;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author shiv.mangal
 *
 */

public class Java02Variables {

	String testUrl = "teststaging.barclays.com";
	long membership = 12345678;
	int passcode = 4929;

	static int numOfLoginAttempts = 0;

	private void loginAttempt() {
		numOfLoginAttempts++;
		System.out.println("User login attempt : " + numOfLoginAttempts);
		String expectedAccountLockedMessage = "Account locked contact Bank";

		try {
			if (numOfLoginAttempts == 3) {
				System.out.println(expectedAccountLockedMessage);
				Assert.assertEquals(expectedAccountLockedMessage, "Account locked contact us");
				System.out.println("Tset Passed");
			}
		} catch (AssertionError e) {
			System.out.println("Tset Failed");
			Assert.fail("Message Dose not match");
		}
	}

	@Test
	public void testVariables() {
		System.out.println("Test URL : " + testUrl);
		System.out.println("Membership : " + membership);
		System.out.println("Passcode : " + passcode);

		loginAttempt();
		loginAttempt();
		loginAttempt();
	}

}
