/**
 * 
 */
package com.home.practice;

import java.util.Arrays;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @author Baba
 *
 */
public class InsertionSortDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strings = new String[10];
		populateArray(strings);
		System.out.println("Before Sorting");
		System.out.println(Arrays.toString(strings));
		System.out.println("After Sorting");
		insertionSort(strings);
	}

	private static void insertionSort(String [] strings) {
		
	}
	
	private static void populateArray(String [] strs) {
		for(int i = 0; i < strs.length; i++)
			strs[i] = RandomStringUtils.randomAlphabetic(5);
	}
}
