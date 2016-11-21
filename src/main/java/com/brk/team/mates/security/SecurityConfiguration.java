package com.brk.team.mates.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private StoreLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private StoreAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        /*builder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select userName, password, enabled from user where userName=?")
                .authoritiesByUsernameQuery("select userName, role from user where userName=?");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT).hasRole("ADMIN")
                .antMatchers("/login").permitAll()
                .antMatchers("/secure/**").authenticated()
                .and().logout().permitAll().logoutUrl("/logout").deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and().headers().httpStrictTransportSecurity().includeSubDomains(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
