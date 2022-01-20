package com.Testyantra.github.genericlib;

public interface IEndPoints {

	String getOperation="/orgs/{org}/repos";
	String postOperation="/user/repos";
	String updateOperation="/repos/{owner}/{repo}";
	String deleteOperation="/repos/{owner}/{repo}";
	
	String propertyFilepath="./src/test/resources/data.properties";
	String verificationcode="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";
}
