package com.home.practice.functions;

import java.util.function.Function;

/**
 * A {@link java.util.function.Function} is functional interface which provides
 * one abstract method <code>apply</code>. It takes in one parameter and returns another parameter
 * 
 * @author nahusha
 *
 */
public class FunctionFunctions05 {
	
	Function<String, Movie> createMovieFunction = (s) -> new Movie(s);
	
	private void testFunction(String movieName) {
		Movie m1 = createMovieFunction.apply(movieName);
		System.out.println(m1);
	}
	
	public static void main(String[] args) {
		new FunctionFunctions05().testFunction("Gods must be crazy");
	}
}
