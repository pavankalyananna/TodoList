package com.Todo.List.service;

public class Node {
	String task;
	Node next;
	Boolean completed;
	public Node(String task) {
		this.task = task;
		completed=false;
		
	}

}
