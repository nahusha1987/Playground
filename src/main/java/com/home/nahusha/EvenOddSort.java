package com.home.nahusha;

import java.util.Arrays;

public class EvenOddSort {

	public static void main(String[] args) {
		int [] nums = { 55, 2, 109, 111, 60, 43, 766, 1009, 8, 44, 556 };
		int i = 0, j = nums.length -1, n = nums.length - 1;
		while (i <= j) {
			while (i <= n && nums[i] % 2 == 0) i++;
			while (j > 0 && nums[j] % 2 == 1) j--;
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		Arrays.stream(nums).forEach(System.out::println);
	}

}
