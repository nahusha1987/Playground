package com.home.nahusha.leetcode;

public class Sample {
	public static void main(String[] args) {
		/*
		 * List<Integer> list1 = Arrays.asList(new Integer[2]); List<Integer>
		 * list = new ArrayList<Integer>(2); list1.add(1); list1.add(2);
		 * list1.add(3); System.out.println(list1);
		 */
		Sample sample = new Sample();
		//System.out.println(sample.singleNumber(new int[] { 4, 1, 2, 1, 3 }));
		int arr[] = {3, 3};
		System.out.println(sample.containsDuplicate(arr));
		int arr_size = arr.length;
		System.out.println("Arr length = " + arr.length);
		sample.printRepeating(arr , arr_size);
	}

	public int singleNumber(int[] nums) {
		int ret = 0;
		for (int i = 0; i < nums.length; i++) {
			ret ^= nums[i];
		}
		return ret;
	}

	public boolean containsDuplicate(int[] nums) {
		System.out.println("Nums length = " + nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (nums[Math.abs(nums[i])] >= 0)
				nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
			else
				return true;
		}
		return false;
	}
	
	void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[ Math.abs(arr[i])] >= 0) 
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  
}
