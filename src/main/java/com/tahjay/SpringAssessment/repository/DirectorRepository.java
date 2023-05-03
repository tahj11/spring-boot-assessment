package com.tahjay.SpringAssessment.repository;

import com.tahjay.SpringAssessment.model.Directors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Directors, Long> {
}
