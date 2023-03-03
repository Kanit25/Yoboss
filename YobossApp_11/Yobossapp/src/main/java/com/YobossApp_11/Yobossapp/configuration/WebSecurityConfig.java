package com.YobossApp_11.Yobossapp.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.YobossApp_11.Yobossapp.security.JWTAuthenticationFilter;
import com.YobossApp_11.Yobossapp.security.JWTAuthorizationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {


private final UserDetailsService userDetailsService;
private final JWTAuthorizationFilter jwtAuthorizationFilter;


@Bean
SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager AuthenticationManager) throws Exception{

    JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
    jwtAuthenticationFilter.setAuthenticationManager(AuthenticationManager);
    jwtAuthenticationFilter.setFilterProcessesUrl("/login");
     
  http
    .cors()
    .and()
    .csrf().disable()
    .authorizeHttpRequests()
    //.requestMatchers("/api/registro")
    //.permitAll()
    .anyRequest()
    .authenticated()
    .and()
    .httpBasic()
    .and()
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
    .addFilter(jwtAuthenticationFilter)
    .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

    
return http.build();
}

/* 
@Bean
UserDetailsService userDetailsService(){

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("admin")
    .password(passwordEncoder().encode("admin"))
    .roles()
    .build());

    return manager;
}
*/


@Bean
AuthenticationManager authenticatedAuthorizationManager (HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
    return http.getSharedObject(AuthenticationManagerBuilder.class)
    .userDetailsService(userDetailsService)
    .passwordEncoder(passwordEncoder)
    .and()
    .build();

    
}

@Bean
PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

    
}
