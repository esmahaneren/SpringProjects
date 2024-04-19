package com.eren.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT USER_ID,PW,ACTIVE FROM MEMBERS WHERE USER_ID = ?");
        // define query to retrieve the authorities/roles  by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT USER_ID,ROLE FROM ROLES WHERE USER_ID=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {

        http.authorizeHttpRequests(config -> config
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use  Http Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery(CSRF)
        //in general ,not required for stateless REST APIs that use POST,DELETE and/or PATCH
        http.csrf(csrf ->csrf.disable());
        return  http.build();
    }


/*    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//        return  new InMemoryUserDetailsManager(john,mary,susan);
*/    }







