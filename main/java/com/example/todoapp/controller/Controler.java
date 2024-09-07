package com.example.todoapp.controller;

import com.example.todoapp.model.Task;
import com.example.todoapp.services.Services;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController

public class Controler {
    Services services = new Services();

    // view
    @GetMapping("/view")
    public Map <Integer, Task> view() {
        return services.showTasks();
    }
    @GetMapping("/view/{id}")
    public Task view(@PathVariable int id) {
        return services.showTask(id);
    }

    // ADD
    @PostMapping("/addTask")
    public String addTask(@RequestParam(value = "title") String title, @RequestParam(value = "description") String description) {
        int id = services.addTask(title, description);
        return String.format("Task added: %s .\nTask id: %d", title, id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String modifyTask(@PathVariable int id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String description) {
        boolean hasTask = services.modifyTask(id, title, description);
        if(hasTask) {
            return String.format("Task id: %d .\nTask modify successfully", id);
        }
        else {
            return "Invalid task id";
        }
    }

    // DELETE 
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return services.deleteTask(id);
        
    }
}


