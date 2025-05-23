package com.rahil.auto_rest_curd_jparepo_demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

        @Bean
        UserDetailsManager userDetailsManager(DataSource source) {

                JdbcUserDetailsManager theJdbcUserDetailsManager = new JdbcUserDetailsManager(source);

                // define query to retrive a user by username.
                theJdbcUserDetailsManager.setUsersByUsernameQuery(
                                "select user_id, pw, active from members where user_id = ?");

                // define query to retrive the authorities/roles by username.

                theJdbcUserDetailsManager
                                .setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

                return theJdbcUserDetailsManager;
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(
                                configure -> configure.requestMatchers(HttpMethod.GET, "/api/employees")
                                                .hasRole("EMPLOYEE")
                                                .requestMatchers(HttpMethod.GET, "/api/employees/**")
                                                .hasRole("EMPLOYEE")
                                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**")
                                                .hasRole("ADMIN"));

                // use http with basic authentication
                http.httpBasic(Customizer.withDefaults());

                // disable csrf
                http.csrf(csrf -> csrf.disable());
                return http.build();
        }

        // @Bean
        // UserDetailsManager userDetailsManager() {

        // UserDetails john = User.builder()
        // .username("john")
        // .password("{noop}test123")
        // .roles("EMPLOYEE")
        // .build();

        // UserDetails marry = User.builder()
        // .username("marry")
        // .password("{noop}test123")
        // .roles("EMPLOYEE", "MANAGER")
        // .build();

        // UserDetails susan = User.builder()
        // .username("susan")
        // .password("{noop}test123")
        // .roles("EMPLOYEE", "MANAGER", "ADMIN")
        // .build();

        // return new InMemoryUserDetailsManager(john, marry, susan);

        // }
}
