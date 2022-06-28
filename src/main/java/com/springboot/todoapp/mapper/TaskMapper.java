package com.springboot.todoapp.mapper;

import java.sql.Date;

public record TaskMapper(Long Id,
                             String description,
                             Integer userId,
                             Integer groupId,
                             Boolean isActive,
                             Date dueDate,
                             Integer priority
) {
}