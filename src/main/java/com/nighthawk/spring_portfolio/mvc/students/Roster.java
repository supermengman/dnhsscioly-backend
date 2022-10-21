package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Roster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String name;

    private ArrayList<String> category;
    private int grade;

    // delombok: class definition
    public Roster(Long id, String name, ArrayList<String> category, int grade) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.grade = grade;
    }

    // no args
    public Roster() {
    }

    // getters and settesr
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
    public ArrayList<String> getCategory() {
        return category;
    }
    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public void addCategory(String category) {
        this.category.add(category);
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // data: tostring
    @Override
    public String toString() {
        return "Roster [id=" + id + ", name=" + name + ", category=" + category + ", grade=" + grade + "]";
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
        Roster other = (Roster) obj;
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
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (grade != other.grade)
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
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + grade;
        return result;
    }
}