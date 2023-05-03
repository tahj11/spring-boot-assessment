package com.tahjay.SpringAssessment.controller;

import com.tahjay.SpringAssessment.model.Directors;
import com.tahjay.SpringAssessment.model.Movies;
import com.tahjay.SpringAssessment.service.DirectorService;
import com.tahjay.SpringAssessment.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @Autowired
    private MovieService movieService;

    //create Director Api
    @PostMapping
    public ResponseEntity<Directors> createDirector(@RequestBody Directors directors) {
        Directors savedDirectors = directorService.createDirector(directors);
        return new ResponseEntity<>(savedDirectors, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Directors> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable(value = "id") Long id) {
        directorService.deleteDirector(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("{directorId}/movies/{movieId}")
    public ResponseEntity<Void> addMovieToDirector(@PathVariable Long directorId, @PathVariable Long movieId) {
        directorService.addMovies(directorId, movieId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{directorId}/movies")
    public List<Movies> getMoviesForDirector(@PathVariable Long directorId) {
        return directorService.getMoviesForDirector(directorId);
    }

    @GetMapping("{movieId}/directors")
    public List<Directors> getDirectorsForMovie(@PathVariable Long movieId) {
        return directorService.getDirectorsForMovies(movieId);
    }
}
