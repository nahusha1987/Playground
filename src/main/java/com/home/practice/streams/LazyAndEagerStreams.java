package com.home.practice.streams;

import java.util.List;

public class LazyAndEagerStreams {

	List<Movie> movies = MovieUtil.createMovies();
	
	private void testLazy() {
		movies.stream().filter(m -> {
			System.out.println("Inside lazy operation");
			return m.isClassic();
		});
	}
	
	private void testEager() {
		
	}
	
	public static void main(String[] args) {
		new LazyAndEagerStreams().testLazy();
		new LazyAndEagerStreams().testEager();
	}

}
