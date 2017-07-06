/**
 * 
 */
package com.home.practice.lambdas;

/**
 * @author nahusha
 *	
 *	Functional interface annotation guarantees that only one 
 *	abstract method is part of this interface
 */
public class FunctionalInterfaces10 {
	
	@FunctionalInterface
	interface Multiplier {
		int multiply(int multiplicand, int multiplier);
	}
	
	@FunctionalInterface
	interface Cruncher {
		int crunch(int a, int b);
	}
	
	public int cruncherService(int a, int b, Cruncher cruncher) {
		return cruncher.crunch(a, b);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaces10 client = new FunctionalInterfaces10();
		
		// client 1
		int ans = client.cruncherService(5, 10, (p,q) -> p+q);
		System.out.println("Ans = " + ans);
		
		// client 2
		ans = client.cruncherService(5, 10, (p,q) -> p-q);
		System.out.println("Ans = " + ans);
		
		// client 3
		ans = client.cruncherService(5, 10, (p,q) -> p*q);
		System.out.println("Ans = " + ans);
		
		// client 4
		ans = client.cruncherService(10, 5, (p,q) -> p/q);
		System.out.println("Ans = " + ans);
	}
}
