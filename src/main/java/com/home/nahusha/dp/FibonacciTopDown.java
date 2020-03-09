package com.home.nahusha.dp;

import java.util.Scanner;

public class FibonacciTopDown {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Which Fibonacci term do you want ? ");
		int n = scan.nextInt();
		scan.close();
		int[] dp = new int[n+1];
		System.out.println(FibonacciTopDown.fib(n, dp));
	}
	
	private static int fib(int n, int [] dp) {
		if (n < 2)
			return n;
		if (dp[n] != 0)
			return dp[n];
		dp[n] = fib(n-1, dp) + fib(n-2, dp);
		return dp[n];
	}
}
