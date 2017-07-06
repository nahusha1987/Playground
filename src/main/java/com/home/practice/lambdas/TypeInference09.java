package com.home.practice.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nahusha
 *
 */
public class TypeInference09 {

	public interface Pricer {
		List<String> skew(String tradeName, PriceSkewerAlgo pricingAlgorithm);
	}
	
	class PriceSkewerAlgo {
		
	}
	
	private void testTypeInference(Pricer pricer) {
		String tradeName = "name";
		PriceSkewerAlgo algorithm = new PriceSkewerAlgo();
		List<String> list = pricer.skew(tradeName, algorithm);
		System.out.println(list.size());
	}
	
	public static void main(String[] args) {
		// Type inference goes here. No type defined for name and algo
		new TypeInference09().testTypeInference((name, algo) -> {
			// logic goes here
			return new ArrayList<>();
		});
	}
}
