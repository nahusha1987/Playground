package com.home.nahusha.leetcode;

public class IntToRoman {
	public static void main(String[] args) {

	}

	public String intToRoman(int num) {
	        if(num < 1 || num > 3999) return "";
	        StringBuffer result = new StringBuffer();
	        String []  roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	        int [] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    
	        int i = 0;
	        while (num > 0) {
	            while (num >= nums[i]) {
	                num-=nums[i];
	                result.append(roman[i]);
	            }
	            i++;
	        }
	        return result.toString();
	    }
}
