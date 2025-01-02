package org.qspiders.DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;


public class InsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Connection conn= DriverManager.getConnection(url, user, password);
		
		//String query="insert into studentInfo(id,first_name,last_name,address) values('Ratan','Tata','India')";
		//Statement statement = conn.createStatement();
		
		//int result = statement.executeUpdate(query);
		
		//if(result==1) {
			//System.out.println("Data is inserted");
		//}else {
			//System.out.println("Data is not inserted");
		//}
			
		
		//conn.close();

	}

}
