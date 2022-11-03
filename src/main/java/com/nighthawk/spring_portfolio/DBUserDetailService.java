// package com.nighthawk.spring_portfolio;

// import org.springframework.security.core.userdetails.*;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import com.nighthawk.spring_portfolio.mvc.students.*;

// public class DBUserDetailService implements UserDetailsService {
// // dependency injection
// @Autowired
// private StudentJpaRepository repository;

// @Override
// public UserDetails loadUserByUsername(String loginName) throws
// UsernameNotFoundException {
// Optional<Student> test = repository.findByName(loginName);
// if (test.isPresent()) {
// Student user = test.get();
// return User.builder()
// .username(loginName)
// // This should contain the hashed password for the requested user
// .password("{MD5}" + user.getPasswordHash())
// // If you don't need roles, just provide a default one, eg. "USER"
// .roles("USER")
// .build();
// } else {
// throw new UsernameNotFoundException("User not found");
// }
// }
// }
