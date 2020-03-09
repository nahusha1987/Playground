package com.home.nahusha.dp;

import java.util.Scanner;

public class FibonacciBottomUp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Which Fibonacci term do you want ? ");
		int n = scan.nextInt();
		scan.close();
		System.out.println(FibonacciBottomUp.fib(n));
	}
	
	private static int fib(int n) {
		int[] arr = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		for (int k = 2; k < n; k++) {
			arr[k] = arr[k-1] + arr[k-2];
		}
		return arr[n-1];
	}
}
