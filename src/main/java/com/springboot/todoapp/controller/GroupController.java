package com.springboot.todoapp.controller;


import com.springboot.todoapp.entity.Group;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.mapper.GroupMapper;
import com.springboot.todoapp.mapper.TaskMapper;
import com.springboot.todoapp.service.GroupService;
import com.springboot.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public String addGroup(@RequestBody GroupMapper groupMapper){

        if(groupMapper.groupname()!=null && groupMapper.userId()!=null) {
            groupService.addGroup(groupMapper);
            return "New group is created!";
        }
        return "missing value";
    }

    @DeleteMapping
    public void deleteGroup(@RequestParam Integer id){

        try {
            groupService.deleteGroup(id);

        }
        catch (Exception e){
            throw e;
        }
    }

    @PutMapping
    public void updateGroup(@RequestBody GroupMapper groupMapper){

        try {
            groupService.updateGroup(groupMapper);

        }
        catch (Exception e){
            throw e;
        }
    }

    @GetMapping
    public List<Group> findAllGroups(){
        return groupService.findAll();
    }


}
