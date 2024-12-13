package com.msrapunzel;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS", schema = "APP")
@NamedQuery(name = "Users.findAll", query = "SELECT e FROM Users e")
public class Users {
    
    public Users() {}

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}