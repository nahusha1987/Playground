package com.home.nahusha.leetcode;

public class RotatedArraySearch {
	public int search(int[] nums, int target) {
        if ( nums.length == 0) return -1;
        int i = -1;
        int k = nums.length == 1 ? 0 : findPivot(nums);
        if(target >= nums[nums.length - 1]) {
        	if (nums.length == 2)
        		k++;
        	i = bin_search(nums, 0, k, target);
        }
        else {
        	/*if (nums.length == 2)
        		k++;*/
        	i = bin_search(nums, k, nums.length - 1, target);
        }
        return i;
    }
    private int findPivot(int[] nums) {
    	for (int i = 0; i < nums.length - 1; i++) {
    		if(nums[i] > nums[i+1])
    			return i;
    	}
    	return 0;
    }
    private int bin_search(int [] nums, int i, int j, int X) {
         while (i <= j) {
            int p = i + (j - i)/2;
            if (nums[p] > X)
                j = p - 1;
            else if (nums[p] < X)
                i = p + 1;
            else
            	return p;
        }
        return -1;
    }
    public static void main(String[] args) {
		RotatedArraySearch ras = new RotatedArraySearch();
		System.out.println(ras.search(new int [] {3,1}, 1));
	}
}