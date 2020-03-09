package com.home.nahusha.leetcode;

public class ATOI {
	public int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		int i = 0, total = 0, sign = 1;
		while (str.charAt(i) == ' ' && i < str.length())
			i++;
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			sign = str.charAt(i) == '+' ? 1 : -1;
			i++;
		}
		while (i < str.length()) {
			int digit = str.charAt(i) - '0';
			if (digit < 0 || digit > 9)
				break;
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			total = 10 * total + digit;
			i++;
		}
		return total * sign;
	}
}
