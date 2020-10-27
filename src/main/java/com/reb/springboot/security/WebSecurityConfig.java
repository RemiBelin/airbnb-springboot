package com.reb.springboot.security;

import com.reb.springboot.AirbnbUser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/login_page","/postlogin").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
                .and()
           .formLogin()
                //.loginPage("/login_page").loginProcessingUrl("/api/postlogin").usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/api/postlogin").usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .permitAll().and().csrf().disable();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user =
        User.withDefaultPasswordEncoder()
                .username("remi")
                .password("cracky")
                .roles("USER")
                .build();
        
        AirbnbUser airbnbUser = new AirbnbUser(user);
        airbnbUser.setAdresse("2 rue Marcel Sembat");
        airbnbUser.setAge(43);

       return new InMemoryAirbnbUsersManager(airbnbUser);
    }
}