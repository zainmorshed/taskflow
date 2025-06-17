package com.taskflow.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private String createdBy;
    private LocalDate createdAt;

@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
private final List<Task> tasks = new ArrayList<>();


    public Project(Long id, String name, String description, String createdBy, LocalDate createdAt){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public Project(){
       
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getCreatedBy(){
        return createdBy;
    }
    public LocalDate getCreatedAt(){
        return createdAt;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    public void setCreatedAt(LocalDate createdAt){
        this.createdAt = createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }
   
}