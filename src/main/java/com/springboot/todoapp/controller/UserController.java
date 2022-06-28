package com.springboot.todoapp.controller;

import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.mapper.UserMapper;
import com.springboot.todoapp.service.TaskService;
import com.springboot.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public String addUser(@RequestBody UserMapper userMapper){
        try {
            userService.addUser(userMapper);
            return "New user is created!";
        }
        catch (Exception e){
            return "Something went wrong! ";
        }
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAll();
    }

}
