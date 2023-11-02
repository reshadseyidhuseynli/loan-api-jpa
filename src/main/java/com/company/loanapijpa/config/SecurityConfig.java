package com.company.loanapijpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("LEAD").password("{noop}12345")
                .and()
                .withUser("CREDITOR").password("{noop}12345");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http
                .authorizeHttpRequests()
                .antMatchers("/api/v1/lead/**").hasRole("LEAD")
                .antMatchers("api/v1/creditor/**").hasRole("CREDITOR");
    }

}
