package com.temp.Oops;

/**
 * 
 * version v1.0
 * 
 * @author shiv.mangal
 * 
 *         Application: Business Banking Feature: Create Business Bank Account
 *         Valid Inputs for Successful account creation: Rating > A and Interest
 *         Rate between 0.2 to 4.0 Expected Outcomes: Successful, Not Successful
 *         or Invalid Rate (<0)
 * 
 */


public class BankAccountApp {

	// Inputs-> Driven by data provider
	
	// Outcomes
	final String statusSuccessful = "Successful";
	final String statusNotSuccessful = "Not Successful";
	final String statusInvalidRate = "Invalid Rate";

	
	//output
	String bankAccountCreationStatus ;
//	String expectedResult ;
	
	/*
	 * Constructor
	 * 
	 */
	
	public BankAccountApp() {
		bankAccountCreationStatus  = null ;
	}
	
	/**
	 * Getters And Setters 
	 */
	
	public void setBankAccountCreationStatus(String bankAccountCreationStatus) {
		this.bankAccountCreationStatus = bankAccountCreationStatus;
	}
	
	public String getBankAccountCreationStatus() {
		return bankAccountCreationStatus;
	}
	
	/**
	 * 
	 * This method returns bank Account Creation Status on the basis of parameters
	 * 
	 * 
	 * 
	 * @param rating
	 * @param intrestRate
	 * @return bankAccountCreationStatus
	 */
	public String getBankAccountStatus(String rating, String interestRate) {
		//Block of code 
		bankAccountStatus: {
			
			//edge case empty - empty , special char, null
			if (interestRate == null || interestRate.isEmpty() || !interestRate.matches("^[-0-9.]+$")) {
//				bankAccountCreationStatus = statusInvalidRate;
				setBankAccountCreationStatus(statusInvalidRate);
				break bankAccountStatus ;
			}
			if (Double.parseDouble(interestRate) <= 0) {
//				bankAccountCreationStatus = statusInvalidRate;
				setBankAccountCreationStatus(statusInvalidRate);
				break bankAccountStatus ;
			}
			
			if(rating.equalsIgnoreCase("<A")) {
//				bankAccountCreationStatus = statusNotSuccessful ;
				setBankAccountCreationStatus(statusNotSuccessful);
				break bankAccountStatus ;
				
			}
			
			if(rating.equalsIgnoreCase(">A")) {
				if(Double.parseDouble(interestRate)< 0.2 || Double.parseDouble(interestRate) > 4.0) {
//					bankAccountCreationStatus = statusNotSuccessful ;
					setBankAccountCreationStatus(statusNotSuccessful);
					break bankAccountStatus ;
					
				}
				
				if(Double.parseDouble(interestRate)<= 0.2 || Double.parseDouble(interestRate) <= 4.0) {
//					bankAccountCreationStatus = statusSuccessful ;
					setBankAccountCreationStatus(statusSuccessful);
					break bankAccountStatus ;
				}
			}
		}

		//return bankAccountCreationStatus ;
		return getBankAccountCreationStatus();
	}
	
}
