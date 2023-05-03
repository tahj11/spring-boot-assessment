package com.tahjay.SpringAssessment.controller;

import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.model.Ratings;
import com.tahjay.SpringAssessment.service.MovieService;
import com.tahjay.SpringAssessment.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private final RatingService ratingService;
    private final MovieService movieService;
    public RatingController(RatingService ratingService, MovieService movieService) {
        this.ratingService = ratingService;
        this.movieService = movieService;
    }

    @GetMapping
    public List<Ratings> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @PostMapping
    public Ratings createRating(@RequestBody Ratings ratings) {
        return ratingService.saveRating(ratings);
    }

    @GetMapping("/{id}")
    public Ratings getRatingById(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }

    @PostMapping("{ratingId}/movies/{movieId}")
    public ResponseEntity<Void> addRatingToMovie(@PathVariable Long ratingId, @PathVariable Long movieId) {
        ratingService.addRatingsToMovies(ratingId, movieId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{ratingId}/movies")
    public List<Movies> getMoviesForRatings(@PathVariable Long ratingId) {
        return ratingService.getMoviesForRatings(ratingId);
    }
}
