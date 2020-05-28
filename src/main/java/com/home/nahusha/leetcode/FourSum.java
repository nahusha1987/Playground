package com.home.nahusha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Set<List<Integer>>> twoSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                Set<List<Integer>> mySetList;
                if (twoSum.containsKey(target - sum)) {
                	mySetList = twoSum.get(target-sum);
                } else {
                	mySetList = new HashSet<>();
                }
                mySetList.add(new ArrayList<>(Arrays.asList(i, j)));
                twoSum.put(target-sum, mySetList);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        Set<Set<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (twoSum.containsKey(sum)) {
                    Set<List<Integer>> mySetList = twoSum.get(sum);
                    Set<Integer> ms = null;
                    for (List<Integer> l : mySetList) {
                    	ms = new TreeSet<>();
                    	ms.add(l.get(0));
                    	ms.add(l.get(1));
                    	ms.add(i);
                    	ms.add(j);
                    }
                    set.add(ms);
                }
            }
        }
        for (Set<Integer> s : set) {
        	List<Integer> ls = null;
        	if(s.size() == 4) {
        		ls = new ArrayList<>();
        		for (int x : s)
        			ls.add(nums[x]);
        	}
        	if (ls != null && !res.contains(ls)) res.add(ls);
        }
        return res;
    }

    public static void main(String[] args) {
		FourSum fs = new FourSum();
		List<List<Integer>> res = fs.fourSum(new int[] {-3,-2,-1,0,0,1,2,3}, 0);
		System.out.println(res.size());
		res.forEach(al -> {
			al.forEach(a -> System.out.print(a + " "));
			System.out.println();
		});
	}
}
