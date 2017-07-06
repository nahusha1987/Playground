/**
 * 
 */
package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 */

@FunctionalInterface
interface Employee {
	Employee find(int id);
	
	// Default methods
	default boolean isExecutive(int id) {
		// logic to find if id is an executive
		return true;
	}
	
	// Static methods
	static String getDefaultCountry() {
		return "India";
	}
}

public class DefaultAndStaticMethods11 {
	
	class EmployeeImpl implements Employee {

		@Override
		public Employee find(int id) {
			boolean isExec = isExecutive(id);
			return null;
		}
	}
	
	public static void main(String[] args) {
		EmployeeImpl impl = new DefaultAndStaticMethods11().new EmployeeImpl();
		impl.find(100);
		impl.isExecutive(100);
		
		Employee.getDefaultCountry();
	}
	
}
