/**
 * 
 */
package com.home.practice.functions;

import java.util.function.Function;

/**
 * Here we look at the {@link Function#compose} and {@link Function#identity} methods
 * in action
 * 
 * @author nahusha
 *
 */
public class ComposingFunctions06 {
	
	Function<Employee, Manager> managerFinder = emp -> getManager(emp);
	
	Function<Manager, Employee> assistantFinder = manager -> getPersonalAssistant(manager);
	
	private void testAndThen(Employee emp) {
		Function<Employee, Employee> empManagerAssistantFinder = 
				managerFinder.andThen(assistantFinder);
		System.out.println(empManagerAssistantFinder.toString());
	}

	private void testCompose(Employee emp) {
		Function<Employee, Employee> employee = 
				assistantFinder.compose(managerFinder);
		System.out.println(employee.toString());
	}
	
	private void testIdentity() {
		Function<String, String> id = Function.identity();
		String result = id.apply("ABCD");
		System.out.println("Result : " + result);
	}
	
	private Employee getPersonalAssistant(Manager manager) {
		return manager.getPersonalAssistant();
	}

	private Manager getManager(Employee emp) {
		return emp.getManager();
	}

	public static void main(String[] args) {
		Employee emp = new Employee();
		new ComposingFunctions06().testAndThen(emp);
		new ComposingFunctions06().testCompose(emp);
		new ComposingFunctions06().testIdentity();
	}
}
