package com.nighthawk.spring_portfolio.mvc.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/student")
public class StudentApiController {

    // Autowired enables Control to connect HTML and POJO Object to database easily for CRUD operations
    @Autowired
    private StudentJpaRepository repository;

    /*
    GET list of people
     */
    @GetMapping("/")
    public ResponseEntity<List<Student>> getNames() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    // search events
    @GetMapping("/event/{event}")
    public ResponseEntity<List<Student>> getEvent(@PathVariable String event) {
        List<Student> people = new ArrayList<Student>() ;
        for (long i = 1; repository.existsById(i); i++) {
            Optional<Student> optional = repository.findById(i);
            Student person = optional.get();
            if(person.getEvent().contains(event)) {
                people.add(person);
                
            }
        }
        return new ResponseEntity<>( people, HttpStatus.BAD_REQUEST);
    }

    // add events
    @GetMapping("/addEvent/{id}/{event}")
    public ResponseEntity<Student> setEvent(@PathVariable long id, @PathVariable String event) {

        

        Optional<Student> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Student person = optional.get();
            person.addEvent(event);
            repository.save(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // remove events
    @GetMapping("/removeEvent/{id}/{event}")
    public ResponseEntity<Student> delEvent(@PathVariable long id, @PathVariable String event) {

        

        Optional<Student> optional = repository.findById(id);
        if (optional.isPresent()) {  // Good ID
            Student person = optional.get();

            if (person.getEvent().contains(event)) {
                int index = person.getEvent().indexOf(event);
                person.removeEvent(index);
                repository.save(person);
                
                return new ResponseEntity<>(person, HttpStatus.OK);
                
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
