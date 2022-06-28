package com.springboot.todoapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Groups")
public class Group {

    private Integer Id;
    private String groupname;
    private Integer userId;

    public Group() {
    }

    public Group(Integer id, String groupname, Integer userId) {
        Id = id;
        this.groupname = groupname;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Group_id_sequence"
    )
    @SequenceGenerator(

            name= "Group_id_sequence",
            sequenceName = "Group_id_sequence"

    )
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Column(unique=true)
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
