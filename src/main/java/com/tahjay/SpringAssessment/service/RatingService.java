package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.entity.EntityNotFoundException;
import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.model.Ratings;
import com.tahjay.SpringAssessment.repository.MovieRepository;
import com.tahjay.SpringAssessment.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    private MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }

    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Ratings getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rating with id " + id + "not found"));
    }

    public Ratings saveRating(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    public void addRatingsToMovies(Long ratingId, Long movieId) {
        Movies movies = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        Ratings ratings = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found"));

        movies.getRatings().add(ratings);
        ratings.getMovies_ratings().add(movies);

        ratingRepository.save(ratings);
        movieRepository.save(movies);
    }

    public List<Movies> getMoviesForRatings(Long ratingId) {
        Ratings ratings = ratingRepository.findById(ratingId)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found"));

        return new ArrayList<>(ratings.getMovies_ratings());
    }
}
