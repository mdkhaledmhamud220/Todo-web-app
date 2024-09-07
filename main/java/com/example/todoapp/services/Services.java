package com.example.todoapp.services;

import com.example.todoapp.model.Model;
import com.example.todoapp.model.Task;

import java.util.Map;

public class Services {
    Model tasks = new Model();

    public Map<Integer, Task> showTasks(){
        return tasks.getTasks();
    }

    public Task showTask(int id){
        return tasks.getTask(id);
    }


    public int addTask(String title, String description){
        return tasks.setTask(title, description);
    }

    public boolean modifyTask(int id, String title, String description){
        boolean hasTask = tasks.hasTask(id);
        if(hasTask) tasks.modifyTask(id, title, description);
        return hasTask;
    }

    public String deleteTask(int id){
        boolean hasTask = tasks.hasTask(id);
        if(hasTask){
            tasks.deleteTask(id);
            return "Delete succsessfully "+id+" task";
        }
        else {
            return "Invalid task Id";
        }
    }
    
}
