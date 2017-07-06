package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 * Method references are a shorthand way of writing lambda
 * expressions.
 * 
 */
public class MethodReferencing07 {

	interface IMovie {
		public boolean check(int id);
	}
	
	public static boolean isClassic(int movieId) {
		return movieId < 100 ? true:false;
	}
	
	public boolean isTop10(int movieId) {
		return movieId > 10 && movieId < 100 ? true : false;
	}
	public static void main(String[] args) {
		// Normal lambda expression
		IMovie m1 = (i) -> i < 100 ? true:false;
		m1.check(10);
		
		// This is static method referencing
		IMovie m2 = MethodReferencing07::isClassic;
		m2.check(0);
		
		// This is instance method referencing
		MethodReferencing07 methodRef = new MethodReferencing07();
		IMovie m3 = methodRef::isTop10;
		m3.check(10);
		
		
	}

}
