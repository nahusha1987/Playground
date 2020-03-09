package com.home.nahusha.leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
	        int carry = 0;
	        for (int i = digits.length - 1; i >= 0; i--) {
	            int sum = 0;
	        	sum += (i == digits.length - 1) ? digits[i] + 1 : digits[i] + carry;
	            carry = sum >= 10 ? 1 : 0;
	            digits[i] = sum % 10;
	            if (carry == 0) break;
	        }
	        if (carry == 0)
	            return digits;
	        int [] newDigits = new int[digits.length + 1];
	        newDigits[0] = 1;
	        return newDigits;
	    }
	
	public int[] plusOneLeet(int[] digits) {
	    int n = digits.length;
	    for(int i=n-1; i>=0; i--) {
	        if(digits[i] < 9) {
	            digits[i]++;
	            return digits;
	        }
	        digits[i] = 0;
	    }
	    int[] newNumber = new int [n+1];
	    newNumber[0] = 1;
	    return newNumber;
	}
}
