package com.tahjay.SpringAssessment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movies {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title;

    private int year;

    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    private Set<Directors> directors = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "movies_ratings")
    private Set<Ratings> ratings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Directors> getDirectors() {
        return directors;
    }

    public Set<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Ratings> ratings) {
        this.ratings = ratings;
    }

    public void setDirectors(Set<Directors> directors) {
        this.directors = directors;
    }

}
