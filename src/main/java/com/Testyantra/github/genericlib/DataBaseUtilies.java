package com.Testyantra.github.genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DataBaseUtilies {
	public Driver driverref;
	public Connection con;
	public ResultSet result;
	
	public void connectToDb() throws SQLException {
		driverref=new Driver();
		DriverManager.registerDriver(driverref);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		 return result = con.createStatement().executeQuery(query);
		
	}
	
	public void executequeryandgetthedata(String query,String colname,String expdata) throws SQLException {
		result=con.createStatement().executeQuery(query);
		
		while(result.next()) {
			if(result.getString(colname).equals(expdata)) {
				break;
			}
			else {
				System.out.println("data no found");
			}
		}
	}
	public void closedb() throws SQLException {
		con.close();
	}

}
