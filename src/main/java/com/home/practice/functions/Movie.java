package com.home.practice.functions;

public class Movie {
	private String name;

	Movie(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + "]";
	}
}
