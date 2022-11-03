// package com.nighthawk.spring_portfolio;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig {

// @Bean
// public PasswordEncoder passwordEncoder() {
// return PasswordEncoderFactories.createDelegatingPasswordEncoder();
// }

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// .cors().and().csrf().disable()
// .authorizeHttpRequests((requests) -> requests
// .antMatchers("/", "/dnscioly-frontend").permitAll()
// .anyRequest().authenticated())
// .formLogin((form) -> form
// .loginPage("/login")
// .permitAll())
// .logout((logout) -> logout.permitAll());

// return http.build();
// }

// // @Bean
// // public UserDetailsService userDetailsService() {
// // UserDetails user = User.withDefaultPasswordEncoder()
// // .username("user")
// // .password("password")
// // .roles("USER")
// // .build();

// // return new InMemoryUserDetailsManager(user);
// // }

// @Bean
// public UserDetailsService userDetailsService() {
// return new DBUserDetailService();
// }
// }