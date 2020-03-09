package com.home.nahusha.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		String s = "dvvdf";
		System.out.println(ls.lengthOfLongestSubstring(s));
	}

	
	public int lengthOfLongestSubstring(String s) {
		int length = 0;
        char [] chArray = s.toCharArray();
		Set<Character> chSet = new HashSet<>();
		int i = 0, j = 0;
		while (i < chArray.length && j < chArray.length) {
			for(int k = i; k <= j; k++)
				System.out.print(chArray[k] + " ");
			if(!chSet.contains(chArray[j])) {
				chSet.add(chArray[j++]);
				length = Math.max(length, j - i);
			} else {
				chSet.remove(chArray[i++]);
			}
			System.out.println();
		}
		System.out.println();
		return length;
	}
}
