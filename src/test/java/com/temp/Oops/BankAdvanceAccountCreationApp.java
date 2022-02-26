package com.temp.Oops;

/**
 * version v2.0
 * 
 * 
 * @author shiv.mangal
 * 
 *         Application: Business Banking Feature: Create Business Bank Account
 *         Valid Inputs for Successful account creation: Rating > A and Interest
 *         Rate between 0.2 to 4.0 Expected Outcomes: Successful, Not Successful
 *         or Invalid Rate (<0)
 * 
 */


public class BankAdvanceAccountCreationApp extends BankAccountApp {

	// Inputs-> Driven by data provider
	
	// Outcomes
	final String statusBussinessAccountType = "Invalid Account Type" ;
	
	/*
	 * Constructor 
	 */
	public BankAdvanceAccountCreationApp() {
		super() ;
	}
	
	
	
	/**
	 * 
	 * This method returns bank Account Creation Status on the basis of parameters
	 * 
	 * version v2.0
	 * 
	 * @param rating
	 * @param intrestRate
	 * @param bussinessAccountType
	 * @return bankAccountCreationStatus
	 */
	public String getBankAccountStatus(String rating, String interestRate, String bussinessAccountType) {
		//Block of code 
		bankAccountStatus: {
			
			//edge case empty - empty , special char, null
			if (interestRate == null || interestRate.isEmpty() || !interestRate.matches("^[-0-9.]+$")) {
				setBankAccountCreationStatus(statusInvalidRate);
				break bankAccountStatus ;
			}
			if (Double.parseDouble(interestRate) <= 0) {
				setBankAccountCreationStatus(statusInvalidRate);
				break bankAccountStatus ;
			}
			
			if (!bussinessAccountType.equalsIgnoreCase("current account")) {
				setBankAccountCreationStatus(statusBussinessAccountType);
				break bankAccountStatus ;
			}
			
			if(rating.equalsIgnoreCase("<A")) {
				setBankAccountCreationStatus(statusNotSuccessful);
				break bankAccountStatus ;
				
			}
			
			if(rating.equalsIgnoreCase(">A") && bussinessAccountType.equalsIgnoreCase("current account")) {
				if(Double.parseDouble(interestRate)< 0.2 || Double.parseDouble(interestRate) > 4.0) {
					setBankAccountCreationStatus(statusNotSuccessful);
					break bankAccountStatus ;
					
				}
				
				if(Double.parseDouble(interestRate)<= 0.2 || Double.parseDouble(interestRate) <= 4.0) {
					setBankAccountCreationStatus(statusSuccessful);
					break bankAccountStatus ;
				}
			}
		}
		return getBankAccountCreationStatus();
	}
	
}
