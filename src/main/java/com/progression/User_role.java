package com.progression.progressioncapstone;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class User_role {

    @Id
    @GeneratedValue
    private long user_id;

    @Column(nullable = false)
    private int role_id;

    @Column(nullable = false)
    private String role;

    public User_role{
    }

    public User_role(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

