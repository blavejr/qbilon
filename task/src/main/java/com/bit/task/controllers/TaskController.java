package com.bit.task.controllers;

import com.bit.task.models.TaskModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/task")
public class TaskController {
    private List<TaskModel> tasks = new ArrayList<>(List.of(
            new TaskModel("Task 1", "Description 1", "1"),
            new TaskModel("Task 2", "Description 2", "2"),
            new TaskModel("Task 3", "Description 3", "3")));

    
    @CrossOrigin(origins = "http://localhost:8081/")
    @GetMapping("/")
    public List<TaskModel> get() {
        return tasks;
    }

    @GetMapping("/{id}")
    public TaskModel getOne(@PathVariable String id) {
        List<TaskModel> filteredTasks = tasks.stream()
                .filter(task -> task.getId().equals(id))
                .collect(Collectors.toList());
        if (filteredTasks.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        return filteredTasks.remove(0);
    }

    @PostMapping("/")
    public String post(@RequestBody TaskModel task) {
        return tasks.add(task) ? "Task added" : "Task not added";
    }

    @PatchMapping("/")
    public String update(@RequestBody TaskModel task) {
        return "Hello Task! (PATCH)";
    }

    @DeleteMapping("/{id}")
    public TaskModel delete(@PathVariable String id) {
        TaskModel taskToDelete = tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        tasks.remove(taskToDelete);

        return taskToDelete;
    }

}