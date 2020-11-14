package com.home.practice.lambdas;

public class CreatingLambdas01 {
	
	interface Greeting {
		public String sayHello(String name);
	}
	
	// Simple example
	public void testGreeting(String name, Greeting greeting) {
		String result = greeting.sayHello(name);
		System.out.println(result);
	}
	
	private void testRunnable(Runnable runnable) {
		new Thread(runnable).start();
	}

	public static void main(String[] args) {
		
		new CreatingLambdas01().testGreeting("nahusha", new Greeting() {
			@Override
			public String sayHello(String name) {
				 return "Hello " + name;
			}
		});

		new CreatingLambdas01().testGreeting("nahusha", (String s) -> "Hello " + s);
		
		new CreatingLambdas01().testGreeting("", (String s) -> s.isEmpty() ? "Did you miss something? " : "Hello "+ s);
		
		
		new CreatingLambdas01().testRunnable(() -> System.out.println("Testing interface"));
	}
}
