package com.home.nahusha.leetcode;

public class RomanToInt {
	public static void main(String[] args) {
		RomanToInt sol = new RomanToInt();
		System.out.println(sol.romanToInt("MCMXCIV"));
	}
	public int romanToInt(String s) {
		int value = 0;
		int i = 0;
		while(i < s.length()) {
			if (s.charAt(i) == 'I') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
					value += 4;
					i += 2;
					continue;
				}
				if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
					value += 9;
					i += 2;
					continue;
				}
			}
			if (s.charAt(i) == 'X') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
					value += 40;
					i += 2;
					continue;
				}
				if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
					value += 90;
					i += 2;
					continue;
				}
			}
			if (s.charAt(i) == 'C') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
					value += 400;
					i += 2;
					continue;
				}
				if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
					value += 900;
					i += 2;
					continue;
				}
			}
			value += getValue(s.charAt(i++));
		}
		return value;
	}

	private int getValue(char c) {
		int x = 0;
		switch (c) {
		case 'I':
			x = 1;
			break;
		case 'V':
			x = 5;
			break;
		case 'X':
			x = 10;
			break;
		case 'L':
			x = 50;
			break;
		case 'C':
			x = 100;
			break;
		case 'D':
			x = 500;
			break;
		case 'M':
			x = 1000;
			break;
		}
		return x;
	}
}
