package com.Testyantra.github.genericlib;

public interface IEndPoints {

	String getOperation="/orgs/{org}/repos";
	String postOperation="/user/repos";
	String updateOperation="/repos/{owner}/{repo}";
	String deleteOperation="/repos/{owner}/{repo}";
	
	String propertyFilepath="./src/test/resources/data.properties";
	String verificationcode="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";
}
