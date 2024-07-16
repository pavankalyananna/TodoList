package com.Todo.List.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//ToDoListService.java// ToDoListService.java
@Service
public class ToDoListService {
    private LinkedList todoList;

    public ToDoListService() {
        todoList = new LinkedList();
    }

    public void addTask(String task) {
        todoList.addTask(task);
    }

    public void reset() {
        todoList.reset();
    }

    public void markTaskAsCompleted(String task) {
        todoList.markTaskAsCompleted(task);
    }
    public void removeTask(String task)
    {
    	todoList.removeTask(task);
    }
    public void moveToPending(String task)
    {
    	todoList.moveToPending(task);
    }

    public List<String> getTasks() {
        List<String> tasks = new ArrayList<>();
        Node current = todoList.head;
        while (current!= null) {
        	if(!current.completed)
            tasks.add(current.task);
            current = current.next;
        }
       
        return tasks;
    }
    public List<String> getCompletedTasks() {
        List<String> tasks = new ArrayList<>();
        Node current = todoList.head;
        while (current!= null) {
        	if(current.completed)
            tasks.add(current.task);
            current = current.next;
        }
        return tasks;
    }
}