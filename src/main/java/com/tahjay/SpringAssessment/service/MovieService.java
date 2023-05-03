package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.entity.EntityNotFoundException;
import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.model.Ratings;
import com.tahjay.SpringAssessment.repository.DirectorRepository;
import com.tahjay.SpringAssessment.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService{

    private MovieRepository movieRepository;
    private DirectorRepository directorRepository;

    public Movies createMovie(Movies movies) {
        return movieRepository.save(movies);
    }


    public Movies getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException(("Movie not found")));
    }


    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movies updateMovie(Movies movies) {
        return null;
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    public List<Ratings> getRatingsForMovie(Long movieId) {
        Movies movies = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        return new ArrayList<>(movies.getRatings());
    }
}
