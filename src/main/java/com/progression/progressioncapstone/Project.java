package com.progression.progressioncapstone;

import javax.persistence.*;

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

    public Project(){

    }

    public Project(String title, String description, String date){
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Project(long id, String title, String description, String date){
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }
    @Override
    public String toString() {
        return String.format("ID: %d, TITLE: %s, DESCRIPTION: %s", id, title, description);
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


    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.title = title;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}

//format for fK
