package com.example.todoapp.model;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private int id;
    private final Map <Integer, Task> map = new HashMap<>();
    
    public Model(){
        id = 1000;
    }

    private int getId(){
        id = id+1;
        return id;
    }

    public Map <Integer, Task> getTasks(){
        return map;
    }
    
    public Task getTask(int id){
        if(hasTask(id))
            return map.get(id);
        else{
            Task task = new Task();
            task.setTitle("Invalid Task id ");
            task.setDescription("Invalid Task with id: "+id);
            return task;
        }
    }


    public int setTask(String title, String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        int uniqueId = getId();
        map.put(uniqueId, task);
        return uniqueId;
    }

    public void modifyTask(int id, String title, String description){
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        map.put(id, task);
    }

    public boolean hasTask(int id){
        return map.containsKey(id);
    }

    public void deleteTask(int id){
        map.remove(id);
    }

}



