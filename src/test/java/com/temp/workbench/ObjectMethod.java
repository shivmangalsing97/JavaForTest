package com.temp.workbench;

import org.junit.Test;

/**
 * 
 * 
 * @author shiv.mangal
 *
 */

public class ObjectMethod {

	/*
	 * 
	 */
	@Test
	public void tset() {
		String[] str = {"tester1","tester2","tester3","tester4"};
		System.out.println(str.length);
		System.out.println(str[0]);
		
		System.out.println("************************");
		
		Object[] obj = {"tester1","tester2","tester3","tester4"};
		System.out.println(obj.length);
		System.out.println(obj[0]);
		
		System.out.println("************************");
		
		Object[][] multiObj = {
				{">A","2.0","Succesful"},
				{">A","4.0","Succesful"},
				{"<A","2.0","Not Succesful"}
		};
		System.out.println(multiObj[0][0]);
		System.out.println(multiObj[0][1]);
		System.out.println(multiObj[0][2]);
	}
	
}
