package com.home.nahusha.dp;

import java.util.Scanner;

public class EggDropWithoutDP {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of floor : ");
		int n = scan.nextInt();
		System.out.print("Enter number of eggs : ");
		int e = scan.nextInt();
		scan.close();
		System.out.println("Number of tries : " + eggDrop(n,e));
	}
	
	private static int eggDrop(int n, int e) {
		if (n == 0 || n == 1) return n;
		if (e == 1) return n;
		int res;
		int min = Integer.MAX_VALUE;
		
		for (int k = 1; k <= n; k++) {
			res = Math.max(eggDrop(k-1, e-1), eggDrop(n-k, e));
			if (res < min)
				min = res;
		}
		return min + 1;
		
	}
}
