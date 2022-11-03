package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    // JPA has many built in methods, these few have been prototyped for this
    // application
    void save(String Student);

    List<Student> findAllByOrderByNameAsc();

    List<Student> findByNameIgnoreCase(String name);

    List<Student> findByEmailIgnoreCase(String email);

    List<Student> findByEvent(String event);
    Optional<Student> findByName(String name);
}
