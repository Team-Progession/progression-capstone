package com.progression.progressioncapstone.Models;
import javax.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long project_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double taskOrder;

    public Task(){
    }

    public Task(long id, long project_id, String title, String description, double taskOrder) {
        this.id = id;
        this.project_id = project_id;
        this.title = title;
        this.description = description;
        this.taskOrder = taskOrder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
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

    public double getOrder() {
        return taskOrder;
    }

    public void setOrder(double order) {
        this.taskOrder = taskOrder;
    }
}

