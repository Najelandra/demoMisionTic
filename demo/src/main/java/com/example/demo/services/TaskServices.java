package com.example.demo.services;

import com.example.demo.entities.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {

    private TaskRepository repo;
    /*Task tarea1;
    Task tarea2;
    TaskList mejorAnio;*/

    public TaskServices(TaskRepository repo){
        this.repo = repo;
        /*this.tarea1 = new Task("Aprender a decir no",false, LocalDate.of(2022,12,31));
        this.tarea2 = new Task("Aprender a parar",false, LocalDate.of(2022,12,31));
        this.mejorAnio = new TaskList("Propósitos este año");

        mejorAnio.AddTask(tarea1);
        mejorAnio.AddTask(tarea2);*/
    }

    //El controlador llama al servicio y este llama al repositorio
    public List<Task> getTaskList(){

        return this.repo.findAll();
    }

    public Task createTask(Task nuevaTarea){
        return this.repo.save(nuevaTarea); //se guarda la nueva tarea en la bd
    }

    public Boolean markTaskAsFinished(Long id){
        Optional<Task> task = this.repo.findById(id);
        if (task.isPresent()) {
            task.get().setDone(true);
            this.repo.save(task.get());
            return true;
        }
        return false;
    }

    public Boolean deleteTask(Long id){
        this.repo.deleteById(id);
        return true;
    }

}
