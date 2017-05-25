package com.home.practice;

import java.util.Arrays;

public class QuickSortDemo {
	public static void main(String[] args) {
		String a = "zyxwvut";
		System.out.println(a);
		String b = a;
		int i = 0, j = b.length()-1;
		char[] c = b.toCharArray();
		while(i<j) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++; j--;
		}
		System.out.println(new String(c));
		StringBuilder sb = new StringBuilder(a);
		//System.out.println(sb.reverse().toString());
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		//System.out.println(new String(chars));
	}
}
