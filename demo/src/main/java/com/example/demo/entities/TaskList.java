package com.example.demo.entities;
import com.example.demo.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private String nombre;
    private List<Task> taskList;

    public TaskList(String nombre){
        this.setNombre(nombre);
        this.taskList = new ArrayList<Task>();
    }

    public void AddTask(Task tarea){
        this.taskList.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }


}
