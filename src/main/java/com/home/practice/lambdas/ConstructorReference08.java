package com.home.practice.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nahusha
 *
 * The only difference between a Constructor Reference and a method
 * reference is that the method name is always NEW in case of a 
 * method reference
 * 
 */
public class ConstructorReference08 {

	class Movie {
		public Movie(int movieId) {
			
		}
		
		public Movie(int movieId, String name) {
			
		}
	}
	
	interface MovieFactory {
		public Movie createMovie(int id);
	}
	
	
	interface ArrayFactory {
		public String[] createArray(int size);
	}
	
	void checkSize(ArrayFactory arrayFactory) {
		System.out.println(arrayFactory.createArray(10).length);
	}
	
	public void Main() {
		// Normal Lambda
		MovieFactory m1 = i -> new Movie(i);
		m1.createMovie(10);
		
		// Constructor Referencing in action
		MovieFactory m2 = Movie::new;
		
		// Normal Lambda
		ArrayFactory arrayFactory = (size) -> new String[size];
		
		// Constructor Referencing in action
		ArrayFactory arrayFactory2 = String[]::new;
		
		new ConstructorReference08().checkSize(arrayFactory);
		new ConstructorReference08().checkSize(arrayFactory2);
		
	}

	public static void main(String[] args) {
		new ConstructorReference08().Main();
	}
}
