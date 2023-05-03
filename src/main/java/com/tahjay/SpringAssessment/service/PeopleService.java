package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.model.People;
import com.tahjay.SpringAssessment.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService{
    private PeopleRepository peopleRepository;

    public People createPerson(@RequestBody People people) {
        return peopleRepository.save(people);
    }


    public People getPerson(int person_id) {
        return null;
    }


    public List<People> getAllPersons() {
        return peopleRepository.findAll();
    }

    public People updatePerson(People people) {
        return null;
    }

    public void deletePerson(int person_id) {

    }
}
