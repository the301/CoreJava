package com.operationjava;

public class Linkedlist {

	public static void main(String[] args) {

		TheLinkedList list = new TheLinkedList();

		list.traverse();

		System.out.println(list.isEmpty());

		Node node1 = new Node(1, null);

		list.add(node1);

		list.traverse();

		Node node2 = new Node(2, null);
		Node node3 = new Node(3, null);
		Node node4 = new Node(4, null);
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);

		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		list.add(node6);

		list.traverse();

		System.out.println(list.size());
		System.out.println(list.isEmpty());

		System.out.println(list.isElementPresent(0));
		System.out.println(list.isElementPresent(4));

		list.removeHead();

		list.traverse();

		System.out.println(list.size());

		list.removeTail();

		list.traverse();

		System.out.println(list.size());

		list.removeElement(4);

		list.traverse();

		System.out.println(list.size());

		list.removeElement(6);

		list.traverse();

		System.out.println(list.size());

		list.removeElement(2);

		list.traverse();

		System.out.println(list.size());

		list.removeElement(5);

		list.traverse();

		System.out.println(list.size());
		
		list.removeElement(3);

		list.traverse();

		System.out.println(list.size());
		
		list.removeElement(1);

		list.traverse();

		System.out.println(list.size());

	}

}

class Node {

	private int data;
	private Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

class TheLinkedList {

	Node head = null;
	Node currnode = null;
	private int size = 0;

	public void add(Node node) {

		if (head == null) {
			head = node;
			currnode = head;
		} else {
			currnode.setNext(node);
			currnode = node;
		}

		size++;
	}

	public void removeHead() {

		Node tempnode = head;

		if (tempnode == null) {
			System.out.println("Empty list");
			return;
		}

		if (tempnode.getNext() == null) {
			head = null;
			size--;
			return;
		}

		head = tempnode.getNext();
		tempnode = null;
		size--;

	}

	public void removeTail() {

		Node tempnode = head;
		Node prevnode = head;

		if (tempnode == null) {
			System.out.println("Empty list");
			return;
		}

		if (tempnode.getNext() == null) {
			head = null;
			size--;
			return;
		}

		while (tempnode.getNext() != null) {
			prevnode = tempnode;
			tempnode = tempnode.getNext();
		}

		prevnode.setNext(null);
		tempnode = null;
		prevnode = tempnode;
		size--;

	}

	public void removeElement(int data) {
		Node tempnode = head;
		Node prevnode = head;

		if (tempnode == null) {
			System.out.println("Empty list");
			return;
		}

		if (tempnode.getData() == data) {
			this.removeHead();
			return;
		}

		while (tempnode.getNext() != null) {
			prevnode = tempnode;
			tempnode = tempnode.getNext();

			if (tempnode.getData() == data) {
				System.out.println("Found");
				prevnode.setNext(tempnode.getNext());
				tempnode = prevnode;
				size--;
				return;
			}
		}

		if (tempnode.getData() == data) {
			System.out.println("Found");
			this.removeTail();
			size--;
		} else {
			System.out.println("Not found");
		}
	}

	public boolean isElementPresent(int data) {

		Node tempnode = head;
		boolean present = false;

		if (tempnode == null) {
			return present;
		}

		while (tempnode.getNext() != null) {

			if (tempnode.getData() == data) {
				present = true;
				break;
			}

			tempnode = tempnode.getNext();
		}

		return present;
	}

	public void traverse() {

		Node tempnode = head;

		if (tempnode == null) {
			System.out.println("Empty list");
			return;
		}

		while (tempnode.getNext() != null) {
			System.out.print(tempnode.getData() + " -> ");
			tempnode = tempnode.getNext();
		}

		System.out.println(tempnode.getData());
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size > 0) ? false : true;
	}
}
