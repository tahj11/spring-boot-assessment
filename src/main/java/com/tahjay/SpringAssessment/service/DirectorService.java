package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.entity.EntityNotFoundException;
import com.tahjay.SpringAssessment.exception.ResourceNotFoundException;
import com.tahjay.SpringAssessment.model.Directors;
import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.model.People;
import com.tahjay.SpringAssessment.repository.DirectorRepository;
import com.tahjay.SpringAssessment.repository.MovieRepository;
import com.tahjay.SpringAssessment.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    public Directors createDirector(@RequestBody Directors directors) {
        return directorRepository.save(directors);
    }

    public Directors getDirector(Long director_id) {
        Optional<Directors> optionalDirectors = directorRepository.findById(director_id);
        return optionalDirectors.get();
    }

    public List<Directors> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Directors updateDirector(Directors directors) {
        return null;
    }

    public void deleteDirector(Long director_id) {
        Directors directors = directorRepository.findById(director_id)
                .orElseThrow(() -> new ResourceNotFoundException("Director", "id", director_id));

        directorRepository.delete(directors);
    }

    public void addMovies(Long directorId, Long movieId) {
        Directors directors = directorRepository.findById(directorId)
                .orElseThrow(() -> new ResourceNotFoundException("Director", "id", directorId));

        Movies movies = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        directors.getMovies().add(movies);
        movies.getDirectors().add(directors);

        directorRepository.save(directors);
        movieRepository.save(movies);
    }

    public List<Movies> getMoviesForDirector(Long directorId) {
      Directors directors = directorRepository.findById(directorId)
              .orElseThrow(() -> new EntityNotFoundException("Director not found"));

      return new ArrayList<>(directors.getMovies());
    }

    public List<Directors> getDirectorsForMovies(Long movieId) {
        Movies movies = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        return new ArrayList<>(movies.getDirectors());
    }

    public Directors addExistingPersonToDirector(Long directorId, Long personId) {
        Directors directors = directorRepository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found"));

        People people = peopleRepository.findById(Math.toIntExact(personId))
                        .orElseThrow(() -> new EntityNotFoundException("Person not found"));

        directors.setPerson(people);

        return directorRepository.save(directors);
    }
}
