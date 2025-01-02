package org.qspiders.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx3 {
	

	@Test(dataProvider ="getData")
	public void bookTickets(String srcLoc, String DestLoc, int passengers) {
		
		System.out.println("Book tickets from "+ srcLoc + "----->" + DestLoc +" with " + passengers + " passengers");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
			Object[][] objArr = new Object[3][3];
			
			objArr[0][0]="Bangalore";
			objArr[0][1]="Mysore";
			objArr[0][2]=20;
			
			objArr[1][0]="Kolar";
			objArr[1][1]="Hasan";
			objArr[1][2]=30;
			
			objArr[2][0]="Mangalore";
			objArr[2][1]="Hubli";
			objArr[2][2]=40;
			
			return objArr;
			
			
		
		
		
		
		
		
	}

}
