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
    private double tOrder;

    public Task(){
    }

    public Task(long id, long project_id, String title, String description, double tOrder) {
        this.id = id;
        this.project_id = project_id;
        this.title = title;
        this.description = description;
        this.tOrder = tOrder;
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

    public double gettOrder() {
        return tOrder;
    }

    public void settOrder(double order) {
        this.tOrder = tOrder;
    }
}

