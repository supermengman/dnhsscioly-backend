package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Annotation to simplify creating an entity, which is a lightweight persistence
        // domain object. Typically, an entity represents a table in a relational
        // database, and each entity instance corresponds to a row in that table.
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Stores name of student
    @Column(unique = true)
    private String name;

    // Stores list of events that each student has
    private ArrayList<String> event = new ArrayList<String>();
    // Stores graduating year
    private int graduatingYear;

    // delombok: class definition
    public Student(Long id, String name, ArrayList<String> event, int graduatingYear) {
        this.id = id;
        this.name = name;
        if (this.event != null)
            this.event = event;
        this.graduatingYear = graduatingYear;
    }

    // no args
    public Student() {
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getEvent() {
        return event;
    }

    public boolean doesEventExist(String event) {
        if (event.contains(event))
            return true;
        else
            return false;
    }

    public void setEvent(ArrayList<String> event) {
        this.event = event;
    }

    public void removeEvent(int index) {
        this.event.remove(index);
    }

    public void addEvent(String event) {
        this.event.add(event);
    }

    public int getGraduatingYear() {
        return graduatingYear;
    }

    public void setGraduatingYear(int graduatingYear) {
        this.graduatingYear = graduatingYear;
    }

    // data: tostring
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", event=" + event + ", graduatingYear=" + graduatingYear + "]";
    }

    // data: check if equal for anything
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (event == null) {
            if (other.event != null)
                return false;
        } else if (!event.equals(other.event))
            return false;
        if (graduatingYear != other.graduatingYear)
            return false;
        return true;
    }

    // not sure what hashcode is
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + graduatingYear;
        return result;
    }
}