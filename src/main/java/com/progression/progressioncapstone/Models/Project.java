package com.progression.progressioncapstone.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String date;

    @OneToMany(mappedBy = "project")
    private List<Role> userlist;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public Project() {
    }

    public Project(String title, String description, String date, List<Role> userlist, List<Task> tasks, User owner) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.userlist = userlist;
        this.tasks = tasks;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, TITLE: %s, DESCRIPTION: %s", id, title, description);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Role> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<Role> userlist) {
        this.userlist = userlist;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

//format for fK
