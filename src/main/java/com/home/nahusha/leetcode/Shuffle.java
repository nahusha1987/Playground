package com.home.nahusha.leetcode;

import java.util.Random;

public class Shuffle {

	public static void main(String[] args) {
		Shuffle s = new Shuffle();
		s.shuffle(new int [] {1,2,3,4,5,6,7,8,9,10});
	}

	private void shuffle(int [] a)
	{
		Random rand = new Random();
		for (int i = 0; i < a.length; i++)
		{
			int r = rand.nextInt(a[i]);
			exch(a, i, r);
		}
		for (int k = 0; k < a.length; k++)
			System.out.print(a[k] + " ");
	}
	
	private void exch(int [] a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
