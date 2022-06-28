package com.springboot.todoapp.repository;

import com.springboot.todoapp.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface GroupRepository extends JpaRepository<Group,Integer> {

    @Modifying
    @Transactional
    @Query("update Group g set g.groupname=?1 where g.id=?2")
    public void updateGroupName(String newGroupName, Integer Id);


}
