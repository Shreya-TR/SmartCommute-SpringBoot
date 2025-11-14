package com.smartcommute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/api/**").permitAll() // ✅ allow root and all /api paths
                        .anyRequest().permitAll() // ✅ allow everything else too
                )
                .csrf(csrf -> csrf.disable()) // ✅ disable CSRF for REST APIs
                .httpBasic(httpBasic -> httpBasic.disable()) // ✅ disable basic auth
                .formLogin(formLogin -> formLogin.disable()) // ✅ disable default login page
                .build();
    }
}
