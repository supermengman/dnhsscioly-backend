package com.nighthawk.spring_portfolio.mvc.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/roster")
public class RosterApiController {

    // Autowired enables Control to connect HTML and POJO Object to database easily for CRUD operations
    @Autowired
    private RosterJpaRepository repository;

    /*
    GET List of Jokes
     */
    @GetMapping("/")
    public ResponseEntity<List<Roster>> getNames() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/addEvent/{id}/{event}")
    public ResponseEntity<Roster> setEvent(@PathVariable long id, @PathVariable String event) {

        Optional<Roster> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Roster person = optional.get();
            person.addCategory(event);
            repository.save(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
