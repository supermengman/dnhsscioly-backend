package com.nighthawk.spring_portfolio.mvc.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA is an object-relational mapping (ORM) to persistent data, originally relational databases (SQL). Today JPA implementations has been extended for NoSQL.
public interface EventJpaRepository extends JpaRepository<Event, Long> {
    // JPA has many built in methods, these few have been prototyped for this application
    void save(String Event);
    List<Event> findAllByOrderByNameAsc();
    List<Event> findByNameIgnoreCase(String name);
}
