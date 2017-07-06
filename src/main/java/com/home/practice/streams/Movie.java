package com.home.practice.streams;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String name;
	private String director;
	
	public Movie(String name, String director) {
		this.name = name;
		this.director = director;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + "," + this.director + "]";
	}
	
	@Override
	public boolean equals(Object object) {
		return this.name.equals(((Movie)object).getName());
	}
	
	@Override
	public int hashCode() {
		return name.length() + director.length();
	}
	
	public boolean isClassic() {
		return true;
	}
}

class MovieUtil {
	static List<Movie> createMovies() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Jurrasic Park", "Steven Speilberg"));
		movies.add(new Movie("Jurrasic Park", "Steven Speilberg"));
		movies.add(new Movie("ET", "Steven Speilberg"));
		movies.add(new Movie("Catch me if you can", "Steven Speilberg"));
		movies.add(new Movie("Gods must be crazy", "Jamie Uys"));
		movies.add(new Movie("Back to the future", "Robert Zemeckis"));
		return movies;
				
	}
}
