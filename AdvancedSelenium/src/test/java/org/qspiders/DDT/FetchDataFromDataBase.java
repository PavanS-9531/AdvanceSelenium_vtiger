package org.qspiders.DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Step 1 : Register driver/load the mysql database.
		 Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
		 
		 //Step : Make connection to the database
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentInformation", "root", "root");

		 //Step 3: Create SQL statement
		 
		 Statement statement = conn.createStatement();
		 
		String query ="select * from studentinfo";
		
		//Step 4: execute the query
		
		 ResultSet result = statement.executeQuery(query);
		 
		 while(result.next()) {
			 System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\n");
			 
			 
		 }
		 
		 conn.close();
	}

}
