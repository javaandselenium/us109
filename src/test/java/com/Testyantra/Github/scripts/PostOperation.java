package com.Testyantra.Github.scripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;


import com.Testyantra.github.genericlib.IEndPoints;
import com.Testyantra.github.genericlib.JavaUtility;
import com.Testyantra.github.pojo.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.Response;


public class PostOperation extends BaseClass{
	@Test
	public void tc2() throws FileNotFoundException, IOException {
		String name = pdata.getData("namerepo")+JavaUtility.getRandomNum();
		
		Project p=new Project(name,pdata.getData("description") );
  Response resp = given()
		.body(p)
		.contentType(ContentType.JSON)
		.auth().oauth2(IEndPoints.verificationcode)
		
		.when()
		.post(IEndPoints.postOperation);
		
		resp.then().log().all()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON);
    
String gitreponame = resp.jsonPath().get("name");
Reporter.log("repro is created successfuly",true);

   
   //patch operation on dynamic created repository
    Project p1=new Project(name,"patch repo");
    given()
    .pathParam("ownerName",pdata.getData("ownername"))
	.pathParam("repoName",gitreponame)
    .auth().oauth2(IEndPoints.verificationcode)
    .body(p1)
	.contentType(ContentType.JSON)
	
	.when()
	.patch("https://api.github.com/repos/{ownerName}/{repoName}")
	.then().log().all();
    
    Reporter.log("repro is been updated successfuly",true);
	
    
   //delete the dynamic cretaed repro
    given()
    .auth().oauth2(IEndPoints.verificationcode)
    .pathParam("ownerName",pdata.getData("ownername"))
   	.pathParam("repoName",gitreponame)
    
    .when()
    .delete("/repos/{ownerName}/{repoName}")
    .then().log().all();
    Reporter.log("repro is deleted successfuly",true);
		
		

		
	}

}
