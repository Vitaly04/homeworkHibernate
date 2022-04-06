package ru.netology.homeworkhibernate.securityconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("vitaly").password("{noop}1111").authorities("age")
                .and()
                .withUser("alexey").password("{noop}2222").authorities("city")
                .and()
                .withUser("sergey").password("{noop}3333").roles("READ")
                .and()
                .withUser("max").password("{noop}4444").roles("WRITE")
                .and()
                .withUser("tom").password("{noop}5555").roles("DELETE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/name*").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/age*").hasAuthority("age")
                .and()
                .authorizeRequests().antMatchers("/persons/city*").hasAuthority("city")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
