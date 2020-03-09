package com.home.nahusha.leetcode;

public class MaxDiff {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 90, 10, 110};
		System.out.println(maxDiff(a));
	}

	public static int maxDiff(int[] arr) {
		int minElem = arr[0];
		int maxDiff = arr[1] - arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - minElem > maxDiff)
				maxDiff = arr[i] - minElem;
			if (arr[i] < minElem)
				minElem = arr[i];
		}
		return maxDiff;
	}	
}
