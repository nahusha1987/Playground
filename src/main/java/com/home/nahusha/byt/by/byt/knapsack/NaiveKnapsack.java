package com.home.nahusha.byt.by.byt.knapsack;

public class NaiveKnapsack {
	public static void main(String[] args) {
		int[] weights = {10, 20, 30};
		int[] vals = {60, 100, 120};
		int W = 60;
		System.out.println(knapsack(W, weights, vals));
	}
	
	public static int knapsack(int W, int[] weights, int[] vals) {
		return knapsack(W, weights, vals, 0);
	}
	
	private static int knapsack(int W, int[] weights, int[] vals, int i) {
		if (i == weights.length) return 0;
		if (W - weights[i] < 0) return knapsack(W, weights, vals, i+1);
		return Math.max(knapsack(W - weights[i], weights, vals, i+1) + vals[i],
				knapsack(W, weights, vals, i+1));
	}
}
