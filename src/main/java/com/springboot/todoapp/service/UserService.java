package com.springboot.todoapp.service;

import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.mapper.TaskMapper;
import com.springboot.todoapp.mapper.UserMapper;
import com.springboot.todoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public record UserService(UserRepository userRepository) {

    public void addUser(UserMapper userMapper){

        User user = new User(userMapper.Id(), userMapper.username(), userMapper.password());

        userRepository.save(user);

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
