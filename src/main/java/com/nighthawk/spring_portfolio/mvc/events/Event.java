package com.nighthawk.spring_portfolio.mvc.events;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

// Events
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Stores name of student
    @Column(unique = true)
    private String name;

    // Stores list of events that each student has
    private ArrayList<String> people = new ArrayList<String>();
    // Stores grade level
    private char division;
}