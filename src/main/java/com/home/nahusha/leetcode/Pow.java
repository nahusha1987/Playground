package com.home.nahusha.leetcode;

public class Pow {
	public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        boolean neg = false;
        double res = 1.0;
        if (n < 0) {
            neg = true;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            res = res*x;
        }
        if (neg)
            return 1/res;
        return res;
    }
	
	public static void main(String[] args) {
		Pow pw = new Pow();
		//System.out.println(pw.myPow(2.00000, 10));
		//System.out.println(pw.myPow(2, -2));
		//System.out.println(pw.myPow(0.00001,2147483647));
		System.out.println(pw.myPow(-2, 2));
	}
}
