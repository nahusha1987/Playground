package com.home.practice;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.lang.RandomStringUtils;

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

	public static int getRandomNumber(int bound) {
		return secureRandom.nextInt(bound);
	}
	
	public static int[] getRandomArray(int count, int bound) {
		int[] nums = new int[count];

		int index = 0;
		while (count-- > 0)
			nums[index++] = secureRandom.nextInt(bound);
		return nums;
	}
	
	public static String getRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public static double getRandomDouble() {
		return Math.round(secureRandom.nextDouble() * 100);
	}
}