package com.taskflow.dto;

import com.taskflow.model.User;

public class TaskDTO {

    /*
     * Why do it this way?
Using a DTO (Data Transfer Object) helps avoid exposing your full Task entity directly.
It simplifies input — you just send IDs for related objects instead of nested full objects.
You control exactly how the data maps from the request to the entity.
     */

    public String title;
    public String description;
    public String status;
    public String priority;
    public String dueDate;
    public Long projectId;
    public Long assignedToId;

    /*
     * ✅ How Spring sets the data from the JSON
Spring Boot uses a library called Jackson (a JSON parser) to automatically:
- Read the incoming JSON body
- Match JSON keys to your DTO fields by name
Assign values by:
- Direct field access (if fields are public), or
- Calling setters (if fields are private with public setters)
     */

    

}
