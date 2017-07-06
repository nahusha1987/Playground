package com.home.practice.lambdas;

import java.util.concurrent.Callable;

public class ExampleLambdaExpression02 {

	public void methodAcceptingRunnable(Runnable r) {
	}
	
	public void methodAcceptingCallable(Callable<String> c) {
	}
	
	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Hello, Lambda");
		new ExampleLambdaExpression02().methodAcceptingRunnable(r);
		// 				OR
		//	create inline lambda expression
		new ExampleLambdaExpression02().methodAcceptingRunnable(() -> {
			System.out.println("Hello, Lambda");
			persist();
			email();
		});
		

		Callable<String> c = () -> "Hello world!";
		new ExampleLambdaExpression02().methodAcceptingCallable(c);
		//				OR
		//		create inline lambda expression
		new ExampleLambdaExpression02().methodAcceptingCallable(() -> {
			return "Hello World";
		});
	}

	private static void email() {
	}

	private static void persist() {
	}
}
