package com.home.nahusha;

import java.util.Arrays;

public class Kadane {
	public static void main(String[] args) {
		int [] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
		Arrays.asList(nums);
		System.out.println(maxSum(nums));
	}
	
	private static int maxSum(int [] arr) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i = 0; i < arr.length; i++) {
			max_ending_here += arr[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
				
		}
		return max_so_far;
	}
}
