package com.nighthawk.spring_portfolio.mvc.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController // annotation to simplify the creation of RESTful web services
@RequestMapping("/api/events")
public class EventApiController {

    // Autowired enables Control to connect HTML and POJO Object to database easily for CRUD operations
    @Autowired
    private EventJpaRepository repository;

    /*
    GET list of people
     */
    @GetMapping("/")
    public ResponseEntity<List<Event>> getNames() {
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }

    // search events
    @GetMapping("/{event}")
    public ResponseEntity<List<Event>> getEvent(@PathVariable String event) {
        
        return new ResponseEntity<>( repository.findByNameIgnoreCase(event), HttpStatus.OK);
    }

    
}

