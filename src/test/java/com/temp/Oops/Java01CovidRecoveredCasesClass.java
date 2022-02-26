package com.temp.Oops;

/**
 * 
 * @author shiv.mangal
 *
 */

public class Java01CovidRecoveredCasesClass {
	
	private String country ;
	private static int recovered ;
	
	
	//encapsulation
	//binding variables & method 
	
	//constructor
	public Java01CovidRecoveredCasesClass() {
		this.country = null;
	}
	
	Java01CovidRecoveredCasesClass(String country) {
		this.country = country;
	}
	
	//setters and getters
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public static void setRecovered(int recovered) {
		Java01CovidRecoveredCasesClass.recovered = recovered;
	}
	
	public String getCountry() {
		return country;
	}
	
	public static int getRecovered() {
		return recovered++;
	}
	
	
	/**
	 * 
	 */
	
	public void printCountry() {
		System.out.println("country : " + getCountry());
	}
	
	public void printRecovered() {
		System.out.println("Recovered : " + getRecovered());
	}
	
	
}
