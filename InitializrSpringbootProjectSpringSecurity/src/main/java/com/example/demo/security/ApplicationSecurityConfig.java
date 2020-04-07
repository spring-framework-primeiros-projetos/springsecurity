/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author Alvaro
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
    
    private final PasswordEncoder passowordEncoder;
    
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passowordEncoder){
        this.passowordEncoder = passowordEncoder;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/index","/css/**","/js/**").permitAll()
                .antMatchers("/api/**").hasRole(ApplicationUserRole.STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();     
    }
    
    
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        UserDetails annaSmithUser = User.builder() 
                .username("annasmith")
                .password(passowordEncoder.encode("password"))
                .roles(ApplicationUserRole.STUDENT.name())
                .build(); //ROLE_STUDENT
        
       UserDetails Linda = User.builder()
                .username("Linda")
                .password(passowordEncoder.encode("password123"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(
                annaSmithUser,
                Linda
        );
    }
    
}

