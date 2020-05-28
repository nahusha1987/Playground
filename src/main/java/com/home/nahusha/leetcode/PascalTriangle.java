package com.home.nahusha.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		pt.generate(5);
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> masterAL = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> al = new ArrayList<>(Collections.nCopies(i+1, 0));
            al.set(0, 1);
            al.set(i, 1);
            for (int j = 1; j <= i-1; j++) {
                int x = masterAL.get(i-1).get(j) + masterAL.get(i-1).get(j-1);
                al.set(j, x);
            }
            masterAL.add(al);
        }
        return masterAL;
    }
}
