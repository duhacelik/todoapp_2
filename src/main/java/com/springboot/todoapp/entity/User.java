package com.springboot.todoapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    private Integer Id;
    private String username;
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "User_id_sequence"
    )
    @SequenceGenerator(

            name= "User_id_sequence",
            sequenceName = "User_id_sequence"

    )
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Column(unique=true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
