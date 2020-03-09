package com.home.nahusha.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s.isEmpty() || s.length() == 0 || s.length() == 1)
			return true;
		int i = 0, j = s.length() - 1;
		boolean palin = false;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) i++;
			else if (!Character.isLetterOrDigit(s.charAt(j))) j--;
			else
				if(Character.toLowerCase(s.charAt(i++)) == Character.toLowerCase(s.charAt(j--)))
					palin = true;
				else
					palin = false;
		}
		return palin;
	}

	public static void main(String[] args) {
		ValidPalindrome p = new ValidPalindrome();
		System.out.println(p.isPalindrome("a."));
	}

}
