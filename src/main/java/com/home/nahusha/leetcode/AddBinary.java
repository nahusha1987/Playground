package com.home.nahusha.leetcode;

import java.util.Stack;

public class AddBinary {
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		System.out.println(ab.addBinary(a, b));
	}

	public String addBinary(String a, String b) {
	        if (a.equals("0") && b.equals("0")) return "0";
	        Stack<Long> stack = new Stack<>();
	        StringBuffer sb = new StringBuffer();
	        long n = Integer.valueOf(a, 2) + Integer.valueOf(b, 2);
	        while ( n > 0) {
	            stack.push(n % 2);
	            n = n/2;
	        }
	        while (!stack.isEmpty())
	            sb.append(stack.pop());
	        return sb.toString();
	    }
}
