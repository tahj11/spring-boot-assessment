package com.tahjay.SpringAssessment.repository;

import com.tahjay.SpringAssessment.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Ratings, Long> {
}
