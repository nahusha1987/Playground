package com.home.nahusha.leetcode;

public class RepeatedSubstring {
	public static void main(String[] args) {
		RepeatedSubstring rs = new RepeatedSubstring();
		//System.out.println(rs.repeatedSubstringPattern("ababababab"));;
		System.out.println(rs.repeatedSubstringPattern("abab"));;
	}

	public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2 || s.isEmpty()) return false; 
        boolean repeated = false;
        int n = s.length();
        for (int i = n/2; i > 0; i--) {
            String pattern = s.substring(0,i);
            int m = pattern.length();
            int startIndex = 0, endIndex = m;
            while (endIndex <= n) {
                String next = s.substring(startIndex, endIndex);
                if (next.equals(pattern))
                    repeated = true;
                else {
                    repeated = false;
                    break;
                }
                startIndex+=m;
                endIndex+=m;
            }
            if (repeated && endIndex == n+m)
                return true;
        }
        return repeated;
    }
}
