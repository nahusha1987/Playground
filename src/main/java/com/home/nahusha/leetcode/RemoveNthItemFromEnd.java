package com.home.nahusha.leetcode;

public class RemoveNthItemFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		/*ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 1; i <= n + 1; i++)
			second = second.next;
		while (second != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
		return dummy.next;*/
		ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (n-- > 0 && second.next != null)
            second = second.next;
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		RemoveNthItemFromEnd sol = new RemoveNthItemFromEnd();
		ListNode ret = sol.removeNthFromEnd(a, 1);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
}
