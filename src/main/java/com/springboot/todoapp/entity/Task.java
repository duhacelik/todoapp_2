package com.springboot.todoapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    private Long Id;
    private Integer priority;
    private String description;
    private Boolean isActive;
    private Integer userId;
    private Integer groupId;
    private Date dueDate;

    public Task() {
    }

    public Task(Long id, Integer priority, String description, Boolean isActive, Integer userId, Integer groupId, Date dueDate) {
        Id = id;
        this.priority = priority;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
        this.groupId = groupId;
        this.dueDate = dueDate;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Task_id_sequence"
    )
    @SequenceGenerator(

            name= "Task_id_sequence",
            sequenceName = "Task_id_sequence"

    )
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
