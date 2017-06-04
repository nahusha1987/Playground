package com.home.practice.lambdas;

public class CreatingLambdas {
	
	interface Greeting {
		public String sayHello(String name);
	}
	
	// Simple example
	public void testGreeting(String name, Greeting greeting) {
		String result = greeting.sayHello(name);
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		new CreatingLambdas().testGreeting("nahusha", new Greeting() {
			
			@Override
			public String sayHello(String name) {
				 return "Hello " + name;
			}
		});
		
		
		new CreatingLambdas().testGreeting("nahusha", (String s) -> "Hello " + s);
		
		new CreatingLambdas().testGreeting("", (String s) -> s.isEmpty() ? "Did you miss something? " : "Hello "+ s);
		
	}
}
