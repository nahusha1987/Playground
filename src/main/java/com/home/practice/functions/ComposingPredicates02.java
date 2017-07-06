/**
 * 
 */
package com.home.practice.functions;

import java.util.function.Predicate;

import com.home.practice.lambdas.Trade;

/**
 *	A Predicate<T> function is a <code>functional interface </code> which provides 
 *	a single abstract method <code>test</<code>
 *
 *	@author nahusha
 */
public class ComposingPredicates02 {
	
	private void testPredicates(Trade trade) {
		// LOGICAL AND
		Predicate<Trade> isBigTrade = (t) -> t.isBigTrade();
		Predicate<Trade> isCancelledTrade = (t) -> t.isCancelledTrade();
		
		Predicate<Trade> isBigAndCancelled1 = (t) -> t.isBigTrade() &&  t.isCancelledTrade();
		// using default function "and" here
		Predicate<Trade> isBigAndCancelled2 = isBigTrade.and(isCancelledTrade);
		
		// LOGICAL OR
		Predicate<Trade> isBigAndCancelled3 = isBigTrade.or(isCancelledTrade);
		
		// NEGATE
		Predicate<Trade> isBigAndCancelled4 = isBigTrade.negate();
		
	}
}
