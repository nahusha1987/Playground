package com.home.nahusha.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LevelOrderBottom {
	public static void main(String[] args) {
		int a = 15;
		float b = a >> 1;
		System.out.println(b);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			List<Integer> list = new ArrayList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			result.add(0, list);
		}
		return result;
	}
}
