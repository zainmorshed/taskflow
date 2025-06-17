package com.taskflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.dto.TaskDTO;
import com.taskflow.model.Project;
import com.taskflow.model.Task;
import com.taskflow.model.User;
import com.taskflow.model.Status;
import com.taskflow.model.Priority;
import com.taskflow.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private com.taskflow.repository.ProjectRepository projectRepository;

    @Autowired
    private com.taskflow.repository.UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }


    @PostMapping("/testdb")
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dto) {

    Project project = projectRepository.findById(dto.projectId).orElseThrow();
    User user = userRepository.findById(dto.assignedToId).orElseThrow();

    Task task = new Task();
    task.setTitle(dto.title);
    task.setDescription(dto.description);
    task.setStatus(Status.valueOf(dto.status));
    task.setPriority(Priority.valueOf(dto.priority));
    task.setDueDate(dto.dueDate);
    task.setProject(project);
    task.setAssignedTo(user);

    return ResponseEntity.ok(taskService.createTask(task));
}



}