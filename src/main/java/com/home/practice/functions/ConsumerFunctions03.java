/**
 * 
 */
package com.home.practice.functions;

import java.util.function.Consumer;

/**
 * A {@link java.util.function.Consumer} is functional interface which provides
 * one abstract method <code>accept</code>. It takes in one parameter and returns nothing.
 * 
 * @author nahusha
 *
 */

public class ConsumerFunctions03 {
	// Consumer for printing movie information
	Consumer<Movie> printInfo = (m) -> System.out.println("Printing movie name : " + m);
	
	// Consumer for persisting movie
	Consumer<Movie> persistMovie = (m) -> System.out.println("Persisting movie " + m);
	
	private void testConsumer(Movie movie) {
		printInfo.accept(movie);
		persistMovie.accept(movie);
	}
	
	private void testAndThen(Movie movie) {
		Consumer<Movie> printAndPersist = printInfo.andThen(persistMovie);
		printAndPersist.accept(movie);
	}
	
	public static void main(String[] args) {
		Movie m1 = new Movie("Gods must be crazy");
		new ConsumerFunctions03().testConsumer(m1);
		new ConsumerFunctions03().testAndThen(m1);
	}
}	
