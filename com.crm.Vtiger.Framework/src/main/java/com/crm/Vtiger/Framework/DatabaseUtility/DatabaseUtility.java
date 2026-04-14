package com.crm.Vtiger.Framework.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crm.Vtiger.Framework.ListenerUtility.IpathConstants;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility implements IpathConstants {

	Connection conn;
	
	public void getDatabaseconnection() throws SQLException {
	
	try {
	
	
	Driver driverref= new Driver();
	DriverManager.registerDriver(driverref);
	
	
	conn=DriverManager.getConnection(Databasepath,Database_UserId,Database_Password);
	} catch(Exception e) {
		System.out.println("handle exception");
		
	}
	}
	
	public void closeDatabaseConnection() throws SQLException  {
		conn.close();
	}


	public ResultSet ExecuteSelectQuery(String Query) throws SQLException {
		ResultSet result=null;
		
		try {
		
		Statement stat=conn.createStatement();
		ResultSet Rset=stat.executeQuery(Query);
		
		return Rset;
		}
		catch(Exception e){
			
			return result;
			
		}
	}
	
	public int ExecuteNonSelectQuery(String Query) throws SQLException {
		int result=0;

		try {

		Statement stat=conn.createStatement();

		 result=stat.executeUpdate(Query);

		

		}

		catch(Exception e) {}

		return result;
	}
}