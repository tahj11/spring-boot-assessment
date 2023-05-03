package com.tahjay.SpringAssessment.repository;

import com.tahjay.SpringAssessment.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
