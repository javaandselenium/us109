package com.Testyantra.github.genericlib;

import java.util.Random;

public class JavaUtility {
	
	public static int getRandomNum() {
		Random ran=new Random();
		int numb = ran.nextInt();
		return numb;
	}

}
