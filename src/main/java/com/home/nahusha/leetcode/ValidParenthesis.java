package com.home.nahusha.leetcode;

public class ValidParenthesis {
	public boolean isValid(String s) {
		if (s == null)
			return false;
		if (s.isEmpty())
			return true;
		int flowerCount = 0, squareCount = 0, roundCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				roundCount++;
			if (s.charAt(i) == ')')
				roundCount--;
			if (s.charAt(i) == '[')
				squareCount++;
			if (s.charAt(i) == ']')
				squareCount--;
			if (s.charAt(i) == '{')
				flowerCount++;
			if (s.charAt(i) == '}')
				flowerCount--;
		}
		if (flowerCount == 0 && squareCount == 0 && roundCount == 0)
			return true;
		return false;
	}
}











