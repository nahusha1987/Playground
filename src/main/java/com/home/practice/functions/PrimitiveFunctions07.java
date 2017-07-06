package com.home.practice.functions;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

public class PrimitiveFunctions07 {
	
	// Wrapper Integer used here
	Predicate<Integer> evenNumberPredicate = x -> x % 2 == 0;
	
	// Primitive int used here
	IntPredicate evenNumberIntPredicate = x -> x % 2 == 0;
	
	// Primitive double and long used here
	DoublePredicate doublePredicate = null;
	LongPredicate longPredicate = null;
	
	// Primitive Consumers
	IntConsumer intConsumer = null;
	LongConsumer longConsumer = null;
	DoubleConsumer doubleConsumer = null;
	
	// Primitive Suppliers
	IntSupplier intSupplier = null;
	LongSupplier longSupplier = null;
	DoubleSupplier doubleSupplier = null;
	
	// Primitive Functions. Input is implicitly primitive type
	IntFunction<Employee> empIntFunction = null;
	DoubleFunction<Employee> empDoubelFunction = null;
	LongFunction<Employee> empLongFunction = null;
	
	
	private void testPredicate(int i) {
		System.out.println(evenNumberIntPredicate.test(i));
	}
	
	public static void main(String[] args) {
		new PrimitiveFunctions07().testPredicate(100);
	}
}
