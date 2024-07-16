package com.Todo.List.service;

public class LinkedList{
	
	public LinkedList()
	{
	
	}
	Node head;
	public void addTask(String task)
	{
		Node newTask=new Node(task);
		if(head==null)
		{
			head=newTask;
			return;
		}
		else
		{
			Node current=head;
			if(current.task.equals(task))
				return;
			while(current!=null &&current.next!=null)
			{
				if(current.task.equals(task))
					return;
				current=current.next;
			}
			current.next=newTask;
		}
	}
	public void reset()
	{
		head=null;
	}
	public void markTaskAsCompleted(String task)
	{
		if(head==null)
			return ;
		Node current=head;
		while(current!=null)
		{
			if(current.task.equals(task))
			{
				current.completed=true;
				System.out.println("true");
				return;
			}
			current=current.next;
		}
	}
	public void removeTask(String task)
	{
		Node current=head;
		if(current!=null &&current.task.equals(task)) {
			head=null;
			return;
		}
		Node prev=current;
		current=current.next;
		while(current!=null)
		{
			if(current.task.equals(task)) {
				prev.next=current.next;
				return;
			}
			prev=current;
			current=current.next;	
		}
	}
	
	public void moveToPending(String task)
	{
		Node current=head;
		while(current!=null)
		{
			if(current.task.equals(task))
			{
				current.completed=false;
				break;
			}
			current=current.next;
		}
	}
	public void printTasks()
	{
		if(head==null)
			return;
		Node current=head;
		while(current!=null)
		{
			System.out.println((current.completed?"[X]":"[]")+current.task);
			current=current.next;	
		}
	}
}