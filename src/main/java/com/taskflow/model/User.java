package com.taskflow.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;
    private String password;
    private String role;

@OneToMany(mappedBy = "assignedTo")
private final List<Task> assignedTasks = new ArrayList<>();


    public User(Long id, String username, String email, String password, String role){
        this.userId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(){

    }

    public Long getId(){
        return userId;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }

    public void setId(Long id){
        this.userId = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRole(String role){
        this.role = role;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks.clear();
        if (assignedTasks != null) {
            this.assignedTasks.addAll(assignedTasks);
        }
    }
}