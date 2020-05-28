package com.home.nahusha.byt.by.byt;

class Node {
	int value;
	Node next;
	
	Node(int val) {
		this.value = val;
		this.next = null;
	}
}

public class ReversePrint {
	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		reversePrint(node);
	}
	
	private static void reversePrint(Node node) {
		if (node.next != null)
			reversePrint(node.next);
		System.out.print(node.value + " ");
	}
}
