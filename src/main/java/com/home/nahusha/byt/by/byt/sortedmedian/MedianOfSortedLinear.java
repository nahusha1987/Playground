package com.home.nahusha.byt.by.byt.sortedmedian;

public class MedianOfSortedLinear {
	public static void main(String[] args) {
		int [] arr1 = {1, 12, 15, 26, 38 };
		int [] arr2 = {2, 13, 17, 30, 45 };
		if (arr1.length != arr2.length)
			System.out.println("Arrays not of equal size");
		System.out.println(getMedian(arr1, arr2));
		
	}
	
	private static double getMedian(int[] ar1, int [] ar2) {
		int i = 0, j = 0, m1 = -1, m2 = -1, n = ar1.length;
		for (int count = 0; count <= n; count++) {
			if (i == n) {
				m1 = m2;
				m2 = ar2[0];
				break;
			}
			if (j == n) {
				m1 = m2;
				m2 = ar1[0];
				break;
			}
			if (ar1[i] < ar2[j]) {
				m1 = m2;
				m2 = ar1[i++];
			} else {
				m1 = m2;
				m2 = ar2[j++];
			}
		}
		return (m1 + m2) / 2;
		
	}
}
