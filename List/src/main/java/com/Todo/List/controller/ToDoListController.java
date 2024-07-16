package com.Todo.List.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Todo.List.service.ToDoListService;

//ToDoListController.java
@Controller
public class ToDoListController {
 @Autowired
 private ToDoListService todoListService;

 @GetMapping("/")
 public String index(Model model) {
     model.addAttribute("tasks", todoListService.getTasks());
     model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
     return "index";
 }

 @GetMapping("/add-task")
 public String addTask() {
     return "add-task";
 }

 @PostMapping("/addTask")
 public String addTask(@RequestParam("task") String task, Model model) {
     todoListService.addTask(task);
     System.out.print(task);
     model.addAttribute("tasks", todoListService.getTasks());
     model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
     return "index";
 }
 
 @PostMapping("/reset")
 public String reset() {
     todoListService.reset();
     return "index";
 }

@PostMapping("/my-tasks")
public String mytasks(Model model)
{
	model.addAttribute("tasks", todoListService.getTasks());
	 model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
	return "index";
}

 @GetMapping("/mark-task-as-completed")
 public String markTaskAsCompleted() {
     return "mark-task-as-completed";
 }
 @PostMapping("/removeTask")
 public String removeTask(@RequestParam("task")String task, Model model)
 {
	todoListService.removeTask(task);
	model.addAttribute("tasks", todoListService.getTasks());
	 model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
	return "index";
 }
 @PostMapping("/MoveToPending")
 public String moveToPending(@RequestParam("task") String task,Model model)
 {
	 todoListService.moveToPending(task);
	 model.addAttribute("tasks", todoListService.getTasks());
	 model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
	return "index";
 }

 @PostMapping("/markTaskAsCompleted")
 public String markTaskAsCompleted(@RequestParam("task") String task, Model model) {
	 System.out.println("task is "+task);
     todoListService.markTaskAsCompleted(task);
     
     System.out.print("marked");
     model.addAttribute("tasks", todoListService.getTasks());
     model.addAttribute("CompletedTasks",todoListService.getCompletedTasks());
     return "index";
 }
}