package code.practice;

public class CreatingLambdas {
	
	interface Greeting {
		public String sayHello(String name);
	}
	
	// Simple example
	public void testGreeting(String name, Greeting greeting) {
		String result = greeting.sayHello(name);
		System.out.println(result);
	}
	
	// Target Types
	public void methodAcceptingTestInterface(TestInterface testInterface) {
		System.out.println(testInterface.sayHello("Nash"));
	}
	
	// Capturing Lambda
	public void methodAcceptingNull(String name) {
		TestInterface ti = (greet) -> name.trim().isEmpty() ? "Hi " : "Hello " + name;
		System.out.println(ti.sayHello(name));
	}
	
	public static void main(String[] args) {
		
		new CreatingLambdas().testGreeting("nahusha", new Greeting() {
			
			@Override
			public String sayHello(String name) {
				// TODO Auto-generated method stub
				 return "Hello " + name;
			}
		});
		
		
		new CreatingLambdas().testGreeting("nahusha", (String s) -> "Hello " + s);
		
		new CreatingLambdas().testGreeting("", (String s) -> s.isEmpty() ? "Did you miss something? " : "Hello "+ s);
		
		TestInterface tI = (s) -> {
			return "Hi, " + s;
		};
		
		new CreatingLambdas().methodAcceptingTestInterface(tI);
		
		new CreatingLambdas().methodAcceptingNull("  ");
		
	}
}
