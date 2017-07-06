package com.home.practice.streams;

import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams03 {
	
	// From Collection
	private void testCollectionStreams() {
		List<Movie> movies = MovieUtil.createMovies();
		movies.stream().forEach(System.out::println);
	}
	
	// Empty Stream
	private void testEmptyStreams() {
		Stream<Movie> emptyMovieSteam = Stream.empty();
		System.out.println(emptyMovieSteam.count());
	}
	
	// From values / arrays
	private void testStreamsFromValues() {
		Stream<String> movieNames =Stream.of("Gods must be crazy", "Back to the future");
		movieNames.forEach(System.out::println);
		
		String[] moviesString = {"Gods must be crazy", "Back to the future"};
		Stream<String> moviesStringStream = Stream.of(moviesString);
		moviesStringStream.forEach(System.out::println);
	}
	
	// Generate and iterate streams
	private void testGenerateIterateStreams() {
		Stream<Double> randomNumbers = Stream.generate(Math::random);
		//randomNumbers.forEach(System.out::println);
		
		Stream<Integer> wholeNumbers = Stream.iterate(1, i -> i+1);
		wholeNumbers.
		filter(j -> j % 2 == 0).
		forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		new CreatingStreams03().testEmptyStreams();
		new CreatingStreams03().testCollectionStreams();
		new CreatingStreams03().testStreamsFromValues();
		new CreatingStreams03().testGenerateIterateStreams();
	}
}
