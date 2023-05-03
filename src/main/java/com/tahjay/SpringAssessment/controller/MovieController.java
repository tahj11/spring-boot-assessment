package com.tahjay.SpringAssessment.controller;

import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.model.Ratings;
import com.tahjay.SpringAssessment.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movies> createMovie(@RequestBody Movies movies) {
        Movies savedMovie = movieService.createMovie(movies);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Movies>> getAllMovies() {
        List<Movies> movies = movieService.getAllMovies();

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("{movieId}/ratings")
    public List<Ratings> getRatingsForMovies(@PathVariable Long movieId) {
        return movieService.getRatingsForMovie(movieId);
    }
}
