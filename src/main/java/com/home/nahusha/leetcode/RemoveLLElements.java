package com.home.nahusha.leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveLLElements {

	public static void main(String[] args) {
		RemoveLLElements ll = new RemoveLLElements();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(6);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);
		ListNode head = ll.removeElements(node, 6);
		while ( head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	 public ListNode removeElements(ListNode head, int val) {
	        ListNode cur = head;
	        ListNode prev = null;
	        while (cur != null) {
	            if (cur.val == val) {
	                prev.next = cur.next;
	                cur = cur.next;
	            } else {
	                prev = cur;
	                cur = cur.next;
	            }
	        }  
	        return head;
	    }
}
