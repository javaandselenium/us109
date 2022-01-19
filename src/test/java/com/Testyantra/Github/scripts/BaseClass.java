package com.Testyantra.Github.scripts;

import java.sql.SQLException;
import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Testyantra.github.genericlib.DataBaseUtilies;
import com.Testyantra.github.genericlib.PropertyFile;


public class BaseClass {
public DataBaseUtilies dblib=new DataBaseUtilies();
public PropertyFile pdata=new PropertyFile();
	
	
	@BeforeSuite
	public void configBS() throws SQLException {
		 baseURI = "https://api.github.com";
		dblib.connectToDb();
	}
	
	@AfterSuite
	public void configAS() throws SQLException {
		dblib.closedb();
	}
	
}
