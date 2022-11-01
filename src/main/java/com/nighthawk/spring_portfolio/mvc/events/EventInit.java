package com.nighthawk.spring_portfolio.mvc.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class EventInit {
    
    // Inject repositories
    @Autowired EventJpaRepository repository;
    
    @Bean
    CommandLineRunner runSciolyEvents() {  // The run() method will be executed after the application starts
        return args -> {
            // Fail safe data validations

            // 2d array for names and grades
            final String[] eventArrayB = {
                "anatomy and physiology",
                "bio process lab",
                "disease detectives",
                "forestry",
                "green generation",
                "dynamic planet",
                "meteorology",
                "road scholar",
                "rocks and minerals",
                "solar system",
                "cant judge a power",
                "crave the wave",
                "crime busters",
                "sounds of music",
                "storm the castle",
                "bridge",
                "flight",
                "roller coaster",
                "wheeled vehicle",
                "codebusters",
                "experimental design",
                "fast facts",
                "write it do it",
            };

            // make sure Joke database is populated with starting jokes
            for (int i = 0; i < eventArrayB.length; i++) {
                String name = eventArrayB[i];
                List<Event> test = repository.findByNameIgnoreCase(name);  // JPA lookup
                if (test.size() == 0)
                    repository.save(new Event(null, name, new ArrayList<String>(), 'b')); //JPA save
            }
            
            final String[] eventArrayC = {
                "anatomy and physiology",
                "cell biology",
                "disease detectives",
                "forestry",
                "green generation",
                "astronomy",
                "dynamic planet",
                "remote sensing",
                "rocks and minerals",
                "chem lab",
                "forensics",
                "its about time",
                "trajectory",
                "wifi lab",
                "environmental chemistry",
                "bridge",
                "detector building",
                "flight",
                "scrambler",
                "codebusters",
                "experimental design",
                "fermi questions",
                "write it do it",
            };

            for (int i = 0; i < eventArrayC.length; i++) {
                String name = eventArrayC[i];
                List<Event> test = repository.findByNameIgnoreCase(name);  // JPA lookup
                if (test.size() == 0)
                    repository.save(new Event(null, name, new ArrayList<String>(), 'b')); //JPA save
            }
        };
    }
}