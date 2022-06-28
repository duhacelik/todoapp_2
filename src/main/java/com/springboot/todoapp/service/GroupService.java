package com.springboot.todoapp.service;

import com.springboot.todoapp.entity.Group;
import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.mapper.GroupMapper;
import com.springboot.todoapp.mapper.TaskMapper;
import com.springboot.todoapp.mapper.UserMapper;
import com.springboot.todoapp.repository.GroupRepository;
import com.springboot.todoapp.repository.TaskRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public record GroupService(GroupRepository groupRepository) {

    public void addGroup(GroupMapper groupMapper){

        Group group = new Group(groupMapper.Id(), groupMapper.groupname(), groupMapper.userId());

        groupRepository.save(group);
    }

    public void deleteGroup(Integer groupId){

        groupRepository.deleteById(groupId);
    }

    public void updateGroup(GroupMapper groupMapper) {

        Group group = groupRepository.findById(groupMapper.Id()).get();

        if (!StringUtils.equals(group.getGroupname(), (groupMapper.groupname())))
            groupRepository.updateGroupName(groupMapper.groupname(), group.getId());
    }

    public List<Group> findAll(){
        return groupRepository.findAll();
    }
}
