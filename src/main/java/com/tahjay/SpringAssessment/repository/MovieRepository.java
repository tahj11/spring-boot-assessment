package com.tahjay.SpringAssessment.repository;

import com.tahjay.SpringAssessment.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies, Long> {
}
