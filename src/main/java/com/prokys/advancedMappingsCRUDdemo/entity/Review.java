package com.prokys.advancedMappingsCRUDdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    //define and annotate fields
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment")
    String comment;

    //define constructors
    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    //define getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //define toString
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
