package com.tahjay.SpringAssessment.service;

import com.tahjay.SpringAssessment.model.People;
import com.tahjay.SpringAssessment.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PeopleServiceImpl implements PeopleService{
    private PeopleRepository peopleRepository;
    @Override
    public People createPerson(@RequestBody People people) {
        return peopleRepository.save(people);
    }

    @Override
    public People getPerson(int person_id) {
        return null;
    }

    @Override
    public List<People> getAllPersons(People people) {
        return null;
    }

    @Override
    public People updatePerson(People people) {
        return null;
    }

    @Override
    public void deletePerson(int person_id) {

    }
}
