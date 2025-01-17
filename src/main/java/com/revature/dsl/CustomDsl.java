package com.revature.dsl;

import com.revature.filters.CustomAuthenticationFilter;
import com.revature.filters.CustomAuthorizationFilter;
import com.revature.models.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {

    @Override
    public void init(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                // enabling h2 console
                .and()
                .headers().frameOptions().disable()
                // end of h2 console block
                .and()
                .authorizeHttpRequests((authorize) -> authorize
                        .antMatchers(HttpMethod.GET, "/token/refresh/**").permitAll()
                        .antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(Role.ADMIN.toString())
                        .antMatchers(HttpMethod.GET, "/trainer/**").hasAnyAuthority(Role.TRAINER.toString())
                        .anyRequest().permitAll()
                )
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.addFilter(new CustomAuthenticationFilter(authenticationManager));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}