package com.home.nahusha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ComparingMaps {
	public static void main(String[] args) {
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		map1.put("name", "nahusha");
		map2.put("name", "nahusha");
		map2.put("name", "beena");
		System.out.println(map1.equals(map2));
	}
}
