/**
 * 
 */
package com.home.practice.functions;

import java.util.function.Predicate;

/**
 * @author nahusha
 *
 */
public class PredicateFunction01 {
	Predicate<String> isEmptyString = (s) -> s.isEmpty();
	public static void main(String[] args) {
		System.out.println(new PredicateFunction01().isEmptyString.test("nash"));
	}
}
