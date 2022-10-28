package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class StudentInit {
    
    // Inject repositories
    @Autowired StudentJpaRepository repository;
    
    @Bean
    CommandLineRunner runScioly() {  // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // 2d array for names and grades
            final String[][] peopleArray = {
                {"Don Tran", "11"},
                {"Krish Patil", "11"},
                {"Bailey Say", "11"},
                {"Rohan Gaikwad", "11"},
                {"Andrew Meng", "11"},
                {"Nicolas Mounier", "11"},
                {"Nicholas Ramos", "11"},
            };

            // make sure Joke database is populated with starting jokes
            for (int i = 0; i < peopleArray.length; i++) {
                String name = peopleArray[i][0];
                int grade = Integer.parseInt(peopleArray[i][1]);
                List<Student> test = repository.findByNameIgnoreCase(name);  // JPA lookup
                if (test.size() == 0)
                    repository.save(new Student(null, name, new ArrayList<String>(), grade)); //JPA save
            }
            
        };
    }
}