package com.home.nahusha.leetcode;

public class LargestContainer {
    public int maxArea(int[] height) {
        int i = 1, j = height.length;
        int area = 0;
	    while ( i < j ) {
            area = Math.max(area, ((j-i) * Math.min(height[i-1], height[j-1])));
            if ( height[i-1] < height[j-1] )
                i++;
            else
                j--;
        }
        return area;
    }
    
    public static void main(String[] args) {
    	int [] height = {2,3,4,5,18,17,6};
    	LargestContainer lc = new LargestContainer();
    	System.out.println(lc.maxArea(height));
	}
}
