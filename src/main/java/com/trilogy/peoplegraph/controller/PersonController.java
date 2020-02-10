package com.trilogy.peoplegraph.controller;

import com.trilogy.peoplegraph.entity.Person;
import com.trilogy.peoplegraph.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }
}
