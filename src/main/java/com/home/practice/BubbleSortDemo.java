/**
 * 
 */
package com.home.practice;

import java.util.Arrays;

/**
 * @author Baba
 *
 */
public class BubbleSortDemo {
	public static void main(String[] args) {
		int [] array = CommonUtils.getRandomArray(10, 100);
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(array));
		System.out.println("\nAfter sorting");
		//Instant start = Instant.now();
		sort(array);
		System.out.println(Arrays.toString(array));
		/*Instant end = Instant.now();
		Duration d = Duration.between(start, end);
		System.out.println(d.getSeconds());*/
	}

	private static void sort(int[] array) {
		for(int i = 0; i < array.length-2; i++) {
			boolean sorted = false;
			for(int j = i +1; j < array.length-1; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					sorted = true;
				}
			}
			if(sorted) return;
		}
	}
}
