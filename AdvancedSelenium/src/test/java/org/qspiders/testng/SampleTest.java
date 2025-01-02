package org.qspiders.testng;

import org.testng.annotations.Test;


public class SampleTest {
	
	@Test(invocationCount=3)
	public void CreateContact() {
		
		System.out.println("Contact Created");
		
	}
	
	@Test
	public void modifyContact() {
		System.out.println("Contact Modified");
	}
	
	@Test
	public void deleteContact() {
		System.out.println("Contact Deleted");
	}
	

}
