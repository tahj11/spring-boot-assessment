package com.tahjay.SpringAssessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Ratings {
    @Id
    @GeneratedValue
    private int Id;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private int votes;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_ratings",
            joinColumns = @JoinColumn(name = "rating_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movies> movies_ratings = new HashSet<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Set<Movies> getMovies_ratings() {
        return movies_ratings;
    }

    public void setMovies_ratings(Set<Movies> movies_ratings) {
        this.movies_ratings = movies_ratings;
    }
}
