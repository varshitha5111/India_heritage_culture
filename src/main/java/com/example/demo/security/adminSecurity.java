package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class adminSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/user/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/admin/login")
                .successHandler((request,response,authentication)->{
                    if(authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"))){
                        response.sendRedirect("/admin/index");
                    }
                    else{
                        response.sendRedirect("/user/index");
                    }
                })
                // .loginProcessingUrl("/admin/loginprocess")
                .permitAll()
            )
            .logout(logout->logout.permitAll());
            // .csrf(csrf -> csrf.disable()); // Disable for simplicity, enable in production
        
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        
        // Custom queries matching the first database schema
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select email, password, enabled from users where email = ?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "select email, role from authorities where email = ?"
        );
        
        return jdbcUserDetailsManager;
    }
}