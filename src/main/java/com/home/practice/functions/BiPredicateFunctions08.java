/**
 * 
 */
package com.home.practice.functions;

import java.util.function.BiPredicate;

/**
 * TWO argument functions: BiPredicate
 * 
 * @author nahusha
 *
 */
public class BiPredicateFunctions08 {
	
	BiPredicate<Employee, Manager> empManagerBiPredicate = 
			(emp, manager) -> emp.getManager().equals(manager) ? true : false;
			
	private void testBiPredicate(Employee emp, Manager manager) {
		System.out.println(empManagerBiPredicate.test(emp, manager));
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		Manager manager = new Manager();
		
		new BiPredicateFunctions08().testBiPredicate(emp, manager);
	}
}
