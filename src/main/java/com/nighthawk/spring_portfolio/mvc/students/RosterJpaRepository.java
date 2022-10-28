package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface RosterJpaRepository extends JpaRepository<Roster, Long> {
    // JPA has many built in methods, these few have been prototyped for this application
    void save(String Roster);
    List<Roster> findAllByOrderByNameAsc();
    List<Roster> findByNameIgnoreCase(String name);
    List<Roster> findByCategory(String category);
}
