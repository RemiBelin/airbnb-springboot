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
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/login1","/postlogin").permitAll()
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
              //  .and().exceptionHandling().defaultAuthenticationEntryPointFor(loginUrlauthenticationEntryPoint(), new AntPathRequestMatcher("/**"))
                .and().formLogin()
                //.loginPage("/login_page").loginProcessingUrl("/api/postlogin").usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/api/postlogin").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/",true)
                .permitAll()
                .and()
            .logout()
                .permitAll().and().csrf().disable();
    }

    @Bean
    public AuthenticationEntryPoint loginUrlauthenticationEntryPoint(){
        LoginUrlAuthenticationEntryPoint url = new LoginUrlAuthenticationEntryPoint("/login1");
        //url.setUseForward(true);
        return url;
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