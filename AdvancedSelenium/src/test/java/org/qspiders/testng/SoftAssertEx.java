package org.qspiders.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	
	@Test
	public void sam1() {
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
		sa.assertAll();//This is mandatory at the end to method close for validation to happen
	}

}
