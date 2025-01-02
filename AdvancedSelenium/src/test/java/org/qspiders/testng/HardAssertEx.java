package org.qspiders.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
	@Test(enabled=false)
	public void m1() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
	}
	@Test(enabled=false)
	public void m2() {
		String actData ="Bangalore";
		String expData ="Bangalore";
		Assert.assertEquals(actData, expData);
	}
	
	@Test(enabled=false)
	public void m3() {
		int a=1;
		int b=10;
		// if the assertion is passed then the assertion message will not be displayed
		//Only if the assertion fails then assertion message is printed and execution stops
		Assert.assertEquals(b, a, "Assertion failed");
		
		System.out.println("Assertion passed");
	}
	
	@Test(enabled=false)
	public void m4() {
		int c=10;
		int d=9;
		Assert.assertNotEquals(c, d, "it is equal");
		System.out.println("Not equal");
	}
	@Test(enabled=false)
	public void m5() {
		String s1="INDIA";
		String s2="INDIA Shining";
		Assert.assertTrue(s1.equalsIgnoreCase(s2));
		System.out.println("Assert Pass");
		
	}
	
	@Test(enabled=false)
	public void m6() {
		String s1="INDIA";
		String s2="INDIA";
		Assert.assertTrue(s1.equalsIgnoreCase(s2), "Strings are not equal");
		System.out.println("Assert Pass");
		
	}
	
	@Test(enabled=false)
	public void m7() {
		String s1 = "Mysore";
		String s2 = "Mysore1";
		Assert.assertFalse(s1.equalsIgnoreCase(s2),"Strings are equal");
		System.out.println("The string values are not same");
	}
	
	@Test(enabled=false)
	public void m8() {
		String s1=null;
		Assert.assertNull(s1, "The String is not null");
		System.out.println("The string has null value");
	}
		
	@Test(enabled=false)
	public void m9() {
		String s2=null;
		Assert.assertNotNull(s2, "The String has null values");
		System.out.println("The string is not null");
	}
	
	@Test(enabled=false)
	public void m10() {
		String s1 ="Mysore";
		String s2 ="Mysore1";
		Assert.assertSame(s2, s1, "Strings are not same");
		System.out.println("The string values are same");
		
	}
	
	@Test
	public void m11() {
		String s1 ="Mysore";
		String s2 ="Mysore";
		Assert.assertNotSame(s2, s1, "Strings are same");
		System.out.println("The string values are not same");
		
	}
	
	@Test
	public void m12() {
		String s1 ="Mysore";
		String s2 ="Mysore1";
		Assert.assertNotSame(s2, s1, "Strings are same");
		System.out.println("The string values are not same");
		
	}
	
	@Test
	public void m13() {
		Assert.fail();
	}
}
