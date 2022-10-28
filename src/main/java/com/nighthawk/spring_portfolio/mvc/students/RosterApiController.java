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
    GET list of people
     */
    @GetMapping("/")
    public ResponseEntity<List<Roster>> getNames() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    // search events
    @GetMapping("/event/{event}")
    public ResponseEntity<List<Roster>> getEvent(@PathVariable String event) {
        List<Roster> people = new ArrayList<Roster>() ;
        for (long i = 1; repository.existsById(i); i++) {
            Optional<Roster> optional = repository.findById(i);
            Roster person = optional.get();
            if(person.getCategory().contains(event)) {
                people.add(person);
                
            }
        }
        return new ResponseEntity<>( people, HttpStatus.BAD_REQUEST);
    }

    // add events
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

    // remove events
    @GetMapping("/removeEvent/{id}/{event}")
    public ResponseEntity<Roster> delEvent(@PathVariable long id, @PathVariable String event) {

        

        Optional<Roster> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Roster person = optional.get();

            if (person.getCategory().contains(event)) {
                int index = person.getCategory().indexOf(event);
                person.removeCategory(index);
                repository.save(person);
                
                return new ResponseEntity<>(person, HttpStatus.OK);
                
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
