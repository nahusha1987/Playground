package com.home.nahusha.leetcode;

import java.util.Arrays;

public class MoveZeroes {
	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		//mz.moveZeroes(new int[] {4,2,4,0,0,3,0,5,1,0});
		//mz.moveZeroes(new int[] {1,0,1});
		mz.moveZeroes(new int[] {0,1});
	}

	public void moveZeroes(int[] nums) {
        int i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            while (j < nums.length && nums[j] == 0) j++;
            if (i < nums.length && j < nums.length && i < j) {
                exch(nums, i, j);
                i++;
                j++;
            } else {
            	//i++;
            	j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    
    private void exch(int[] nums, int i, int j) {
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
}
