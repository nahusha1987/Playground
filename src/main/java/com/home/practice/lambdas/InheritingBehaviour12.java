/**
 * 
 */
package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 */

interface Engine {
	default String make() {
		return "DEFAULT MAKE";
	}
	
	static String manufacturer() {
		return "MANUFACTURER";
	}
}

interface Vehicle {
	default String model() {
		return "DEFAULT MODEL";
	}
	
	static String manufacturer() {
		return "MANUFACTURER";
	}
}

class Car implements Engine, Vehicle {
	public String getMakeAndModel() {
		return Engine.super.make() + 
				Vehicle.super.model();
	}

	@Override
	public String make() {
		// TODO Auto-generated method stub
		return Engine.super.make();
	}
}

public class InheritingBehaviour12 {
	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.make());;
		
	}
}
