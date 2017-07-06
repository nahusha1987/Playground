package com.home.practice.streams;

import java.util.List;

public class WorkingWithStreams02 {

	List<Movie> movies = MovieUtil.createMovies();
	
	private void findMoviesByDirector(String director) {
		movies.stream().
		filter(m -> m.getDirector().equals(director)).
		//map(Movie::getName).
		//distinct().
		forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		new WorkingWithStreams02().findMoviesByDirector("Steven Speilberg");
	}

}
