package com.taskflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.model.Project;
import com.taskflow.repository.ProjectRepository;

@Service
public class ProjectService {
   
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject){
        return projectRepository.findById(id).map(project -> {
            project.setName(updatedProject.getName());
            project.setDescription(updatedProject.getDescription());
            return projectRepository.save(project);
        }).orElseThrow(() -> new RuntimeException("Project not found with id: "+ id));
    }

    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }



    }