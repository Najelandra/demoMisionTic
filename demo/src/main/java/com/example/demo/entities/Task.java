package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;

//la anotación permite que la clase se cree como tabla
@Entity
@Table(name = "task")
public class Task {
    //Cada atributo se convierte en una columna de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "description")
    private String description;
    @Column(name = "done")
    private boolean done;

    @Column(name = "due_date")
    private LocalDate due_date;

    //constructor
    public Task(){

    }
    public Task(String desc, boolean done, LocalDate dueDate){
        this.description = desc;
        this.done = done;
        this.setDue_date(dueDate);
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String descp){
        this.description = descp;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDate() {
        return getDue_date();
    }

    public void setDueDate(LocalDate dueDate) {
        this.setDue_date(dueDate);
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }
}
