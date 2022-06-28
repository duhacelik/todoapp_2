package com.springboot.todoapp.service;

import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.mapper.TaskMapper;
import com.springboot.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Service
public record TaskService(TaskRepository taskRepository) {


    public List<Task> getAllTasks(Integer userId, Boolean isActive){

        // string username=tokenmanager.getUsernameToken(token);
        // Integer userId= taskRepository.findByUserName(username);
        return taskRepository.findByUserId(userId, isActive);

    }

    public List<Task> filterPriority(Integer userId, Boolean isActive, Integer priority){
        return taskRepository.filterPriority(userId, isActive, priority);
    }

    public List<Task> filterGroup(Integer userId, Boolean isActive, Integer groupId){
        return taskRepository.filterGroup(userId, isActive, groupId);
    }

    public List<Task> filterDate(Integer userId, Boolean isActive, Date dueDate){
        return taskRepository.filterDate(userId, isActive, dueDate);
    }

    public void addTask(TaskMapper t) {

        Task task = new Task(t.Id(), t.priority(), t.description(), t.isActive(), t.userId(), t.groupId(), t.dueDate());
        boolean isDueEntered = true;

        if (task.getPriority() == null)
            task.setPriority(1);

        if (task.isActive() == null)
            task.setActive(true);

        if (task.getDueDate() == null)
            isDueEntered = false;

        if (1 <= task.getPriority() && task.getPriority() <= 3) {
            if (isDueEntered) {
                if (!task.getDueDate().after(new Date()))
                    return;
            }
            taskRepository.save(task);
        }

    }

    public void deleteTask(Long taskId){

        taskRepository.deleteById(taskId);
    }

    public void updateTask(TaskMapper taskMapper){

        Task task = taskRepository.findById(taskMapper.Id()).get();

        if(task.isActive() != taskMapper.isActive())
            taskRepository.updateTaskState(taskMapper.isActive(),task.getId());
        else{
            if(!StringUtils.equals(task.getDescription(),(taskMapper.description())))
                taskRepository.updateDescription(taskMapper.description(),task.getId());
            if(task.getGroupId() != taskMapper.groupId())
                taskRepository.updateGroup(taskMapper.groupId(),task.getId());
            if(task.getDueDate() != taskMapper.dueDate() && taskMapper.dueDate().after(new Date()))
                taskRepository.updateDueDate(taskMapper.dueDate(),task.getId());
            if(task.getPriority() != taskMapper.priority())
                taskRepository.updatePriority(taskMapper.priority(),task.getId());
        }
    }
}
