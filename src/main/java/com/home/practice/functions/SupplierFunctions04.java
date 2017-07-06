/**
 * 
 */
package com.home.practice.functions;

import java.util.function.Supplier;

/**
 * A {@link java.util.function.Supplier} is functional interface which provides
 * one abstract method <code>get</code>. It does not takes in any arguments but
 * returns an Object of the same type
 * 
 * @author nahusha
 *
 */
public class SupplierFunctions04 {
	
	Supplier<String[]> fruitSupplier = () -> new String[]{"Apple", "Banana", "Orange", "Avacado"};
	
	private void testSupplier() {
		String[] fruits = fruitSupplier.get();
		for(String fruit : fruits)
			System.out.println("Fruit is " + fruit);
	}
	
	public static void main(String[] args) {
		new SupplierFunctions04().testSupplier();
	}
}
