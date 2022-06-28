package com.springboot.todoapp.repository;

import com.springboot.todoapp.entity.Task;
import com.springboot.todoapp.mapper.TaskMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    String FIND_BY_USER_ID_QUERY = "SELECT t FROM Task t WHERE t.userId= :userId AND t.active= :isActive";
    String FILTER_PRIORITY_QUERY = "SELECT t FROM Task t WHERE t.userId= :userId AND t.active= :isActive AND t.priority= :priority";
    String FILTER_GROUP_QUERY = "SELECT t FROM Task t WHERE t.userId= :userId AND t.active= :isActive AND t.groupId= :groupId";
    String FILTER_DATE_QUERY = "SELECT t FROM Task t WHERE t.userId= :userId AND t.active= :isActive AND t.dueDate= :dueDate";
    //String FIND_BY_USER_NAME_QUERY ="SELECT u.Id FROM Users u WHERE t.username= :username" BUNU USER REPOYA YAZCAN
    @Query(FIND_BY_USER_ID_QUERY)
    List<Task> findByUserId(@Param("userId") Integer userId, @Param("isActive") Boolean isActive);

    @Query(FILTER_PRIORITY_QUERY)
    List<Task> filterPriority(@Param("userId") Integer userId, @Param("isActive") Boolean isActive, @Param("priority") Integer priority);

    @Query(FILTER_GROUP_QUERY)
    List<Task> filterGroup(@Param("userId") Integer userId, @Param("isActive") Boolean isActive, @Param("groupId") Integer groupId);

    @Query(FILTER_DATE_QUERY)
    List<Task> filterDate(@Param("userId") Integer userId, @Param("isActive") Boolean isActive, @Param("dueDate") Date dueDate);

    @Modifying
    @Transactional
    @Query("update Task t set t.description=?1 where t.id=?2")
    public void updateDescription(String newDesc, Long Id);

    @Modifying
    @Transactional
    @Query("update Task t set t.groupId=?1 where t.id=?2")
    public void updateGroup(Integer newGroupId, Long Id);

    @Modifying
    @Transactional
    @Query("update Task t set t.active=?1 where t.id=?2")
    public void updateTaskState(Boolean newActivity, Long Id);

    @Modifying
    @Transactional
    @Query("update Task t set t.dueDate=?1 where t.id=?2")
    public void updateDueDate(Date newDueDate, Long Id);

    @Modifying
    @Transactional
    @Query("update Task t set t.priority=?1 where t.id=?2")
    public void updatePriority(Integer newPriority, Long Id);
}
