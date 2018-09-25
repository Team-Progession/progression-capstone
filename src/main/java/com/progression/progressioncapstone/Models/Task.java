package com.progression.progressioncapstone.Models;
import javax.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double taskOrder;

    @Column(nullable = false)
    private boolean isComplete;

    @ManyToOne
    @JoinColumn(name = "project")
    private Project project;

    public Task() {
    }

    public Task(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Task(String title, String description, double taskOrder, boolean isComplete, Project project) {
        this.title = title;
        this.description = description;
        this.taskOrder = taskOrder;
        this.isComplete = isComplete;
        this.project = project;
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

    public double getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(double taskOrder) {
        this.taskOrder = taskOrder;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

