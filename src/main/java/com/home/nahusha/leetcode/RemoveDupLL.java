package com.home.nahusha.leetcode;

import java.util.Stack;

public class RemoveDupLL {

	public ListNode deleteDuplicates(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		while (head != null) {
			if (stack.isEmpty()) {
				stack.push(head.val);
				head = head.next;
			} else if (stack.peek() != head.val) {
				stack.push(head.val);
				head = head.next;
			} else if (stack.peek() == head.val) {
				while (head.next != null && head.val == head.next.val) head = head.next;
				head = head.next;
				stack.pop();
			}
		}
		ListNode first = null;
		for (int x : stack) {
			ListNode l = new ListNode(x);
			if (first == null) {
				first = l;
				continue;
			}
			ListNode tmp = first;
			while (tmp.next != null) tmp = tmp.next;
			tmp.next = l;
		}
		return first;
	}
	
	public static void main(String[] args) {
		RemoveDupLL removeDLL = new RemoveDupLL();
		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(3);
		node.next.next.next.next.next = new ListNode(3);
		node.next.next.next.next.next.next = new ListNode(5);
		ListNode head = removeDLL.deleteDuplicates(node);
		while ( head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
