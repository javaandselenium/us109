package com.Testyantra.Github.scripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;


import com.Testyantra.github.genericlib.IEndPoints;

import io.restassured.http.ContentType;

public class GetOperation extends BaseClass {

	@Test
	public void tc1() throws FileNotFoundException, IOException {
		given()
		.pathParam("ownerName",pdata.getData("ownername"))
		.pathParam("repoName",pdata.getData("reponame"))
		
		.when()
		.get("https://api.github.com/repos/{ownerName}/{repoName}")
		.then().log().all()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON);
		
		Reporter.log("Get opertion is scussefull");
		
		
	}
	
}
