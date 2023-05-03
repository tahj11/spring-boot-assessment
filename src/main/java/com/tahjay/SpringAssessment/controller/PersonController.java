package com.tahjay.SpringAssessment.controller;

import com.tahjay.SpringAssessment.model.People;
import com.tahjay.SpringAssessment.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
public class PersonController {
    private PeopleService peopleService;

    @PostMapping
    public ResponseEntity<People> createPerson(@RequestBody People people) {
        People savedPerson = peopleService.createPerson(people);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public List<People> getAllPersons() {
        return peopleService.getAllPersons();
    }
}
