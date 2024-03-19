package com.example.upvote.config;

import com.example.upvote.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomUserService customUserService;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder, CustomUserService customUserService) {
        this.passwordEncoder = passwordEncoder;
        this.customUserService = customUserService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,
                        "/api/ideas").hasRole("VOTER")
                .antMatchers(HttpMethod.PATCH,
                        "/api/ideas/{id}").hasRole("VOTER")
                .antMatchers(HttpMethod.GET,
                        "/api/ideas/listAllNewIdea").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,
                        "/api/ideas/{id}/accept",
                        "/api/ideas/{id}/reject").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,
                        "/api/users").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/api/ideas"
                ).authenticated()
                .anyRequest().denyAll()
                .and()
                .logout().logoutUrl("/api/users/logout")
                .deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }

}
