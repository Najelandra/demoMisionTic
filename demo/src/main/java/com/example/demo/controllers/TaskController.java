package com.example.demo.controllers;

import com.example.demo.entities.Task;
import com.example.demo.services.TaskServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//para que java habilite un end point, que a la larga es una url
@RestController
public class TaskController {
    TaskServices servicio;

    public TaskController(TaskServices servicio){

        this.servicio = servicio;
    }

    /* pasa al front
    @GetMapping("/tasks")
    public List<Task> TaskList(){

        return servicio.getTaskList();
    }*/
    @PostMapping("/tasks")
    public RedirectView createTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Task tarea, Model model){ //verificar si la Task se puede llamar diferente o si tiene que ser task
        //la anotación requestBody permite que lo que se reciba se adapte al tipo de dato necesitado
        model.addAttribute(tarea);
        tarea.setDone(false);
        this.servicio.createTask(tarea);
        return new RedirectView("/tasks");
    }

    //rutas dinámicas
    @PatchMapping("/task/{id}")
    public RedirectView updateTask(@PathVariable("id") long id){
        this.servicio.markTaskAsFinished(id);
        return new RedirectView("/tasks");
    }

    //rutas dinámicas
    @DeleteMapping("/task/{id}")
    public RedirectView deleteTask(@PathVariable("id") long id){
        this.servicio.deleteTask(id);
        return new RedirectView("/tasks");
    }
}
