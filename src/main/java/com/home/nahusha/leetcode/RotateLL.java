package com.home.nahusha.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RotateLL {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		ListNode first = head;
		ListNode ptr = head;
		while (k-- > 0) {
			ptr = ptr.next;
			if (ptr == null)
				ptr = first;
		}
		ListNode term = null;
		while (ptr != null) {
			term = first;
			first = first.next;
			ptr = ptr.next;
		}
		term.next = null;
		ListNode prev = null, cur = first;
		while (cur != null) {
			prev = cur;
			cur = cur.next;
		}
		if (prev != null) {
			prev.next = head;
			head = first;
		}
		return head;
	}
	public static void main(String[] args) {
		RotateLL rll = new RotateLL();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = rll.rotateRight(head, 2);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}