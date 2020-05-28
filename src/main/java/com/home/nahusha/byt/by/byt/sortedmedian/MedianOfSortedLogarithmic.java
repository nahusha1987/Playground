package com.home.nahusha.byt.by.byt.sortedmedian;

class Subarray {
	private int start, size;
	private int[] inner;
	
	public static Subarray fromArray(int[] arr) {
		Subarray s = new Subarray();
		s.inner = arr;
		s.start = 0;
		s.size = arr.length;
		return s;
	}

	public Subarray subArray(int i, int j) {
		if (i > j) throw new IllegalArgumentException();
		if (j > this.size) throw new IndexOutOfBoundsException();
		Subarray s = new Subarray();
		s.inner = this.inner;
		s.start = start + i;
		s.size = j - i;
		return s;
	}

	public int getSize() {
		return size;
	}
	
	public int getFirst() {
		return inner[start];
	}
	
	public int getLast() {
		return inner[start + size -1];
	}
	
	public double getMedian() {
		if (size % 2 == 0)
			return (inner[start + size / 2 - 1] + inner[start + size / 2]) / 2;
		return inner[start + size / 2];
	}
}

public class MedianOfSortedLogarithmic {
	public static void main(String[] args) {
		//int [] arr1 = {1, 12, 15, 26, 38 };
		//int [] arr2 = {2, 13, 17, 30, 45 };
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,8};
		System.out.println(getMedian(arr1, arr2));
	}
	
	private static double getMedian(int[] ar1, int[] ar2) {
		if (ar1.length == 0 || ar1.length != ar2.length) throw new IllegalArgumentException();
		return median(Subarray.fromArray(ar1), Subarray.fromArray(ar2));
	}
	
	private static double median(Subarray s1, Subarray s2) {
		if (s1.getSize() == 1)
			return (s1.getFirst() + s2.getFirst()) / 2.;
		if (s1.getSize() == 2)
			return (Math.max(s1.getFirst(), s2.getFirst()) + Math.min(s1.getLast(), s2.getLast())) / 2.;
		
		double median1 = s1.getMedian();
		double median2 = s2.getMedian();
		
		if (median1 == median2) return median1;
		
		if(median1 > median2)
			return median(s1.subArray(0, s1.getSize() / 2 + 1), s2.subArray((s2.getSize() - 1)/2, s2.getSize()));
		return median(s1.subArray((s1.getSize() - 1) / 2, s1.getSize()), s2.subArray(0, s2.getSize() / 2 + 1));
	}
}
