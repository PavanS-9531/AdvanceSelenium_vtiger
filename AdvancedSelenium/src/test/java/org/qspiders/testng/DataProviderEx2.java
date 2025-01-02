package org.qspiders.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	
	@Test(dataProvider ="getData")
	public void bookTickets(String srcLoc, String DestLoc) {
		
		System.out.println("Book tickets from "+ srcLoc + "----->" + DestLoc);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Mysore";
		objArr[1][0]="Kolar";
		objArr[1][1]="Hasan";
		objArr[2][0]="Mangalore";
		objArr[2][1]="Hubli";
		
		return objArr;
		
		
	}

}
