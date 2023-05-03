package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.model.People;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PeopleService {
    People createPerson(People people);

    People getPerson(int person_id);

    List<People> getAllPersons(People people);

    People updatePerson(People people);

    void deletePerson(int person_id);
}
