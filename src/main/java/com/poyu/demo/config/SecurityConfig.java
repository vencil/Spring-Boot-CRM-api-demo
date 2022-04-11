package com.poyu.demo.config;

import com.poyu.demo.util.Util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // To simplify the test process, provide 3 user data here.
        auth.inMemoryAuthentication()
                .withUser("superuser").password("{noop}abc123").roles(Util.UserRoleSuper)
                .and()
                .withUser("manager").password("{noop}abc123").roles(Util.UserRoleManager)
                .and()
                .withUser("operator").password("{noop}abc123").roles(Util.UserRoleOperator);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole(Util.UserRoleManager, Util.UserRoleSuper)
                .antMatchers(HttpMethod.PATCH, "/api/**").hasAnyRole(Util.UserRoleManager, Util.UserRoleSuper)
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole(Util.UserRoleManager, Util.UserRoleSuper)
                .antMatchers(HttpMethod.POST, "/api/**").hasAnyRole(Util.UserRoleOperator, Util.UserRoleSuper)
                .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(Util.UserRoleOperator, Util.UserRoleManager, Util.UserRoleSuper)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/swagger-ui")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
