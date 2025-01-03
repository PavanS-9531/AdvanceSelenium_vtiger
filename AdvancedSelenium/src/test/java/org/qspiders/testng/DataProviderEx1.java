package org.qspiders.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	//This is a data provider for push
	@Test(dataProvider ="getData")
	public void bookTickets(String srcLoc, String DestLoc) {
		
		System.out.println("Book tickets from "+ srcLoc + "----->" + DestLoc);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] objArr = new Object[2][2];
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Mysore";
		objArr[1][0]="Kolar";
		objArr[1][1]="Hasan";
		
		return objArr;
		
		
	}

}
