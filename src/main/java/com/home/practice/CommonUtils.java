package com.home.practice;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CommonUtils {
	private static SecureRandom secureRandom;
	static {
		try {
			secureRandom = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[] getRandomNumbers(int count, int bound) {
		int[] nums = new int[count];

		int index = 0;
		while (count-- > 0)
			nums[index++] = secureRandom.nextInt(bound);
		return nums;
	}
}