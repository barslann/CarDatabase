package com.coderman.cardatabase.security;

import com.coderman.cardatabase.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;
import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    // in this method we can define which endpoints in our application are secure and which are not!
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    //Filter for the api/login requests
                    .addFilterBefore(new LoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                    //Filter for other request to check JWT in header
                    .addFilterBefore(new AuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
    }

    // We will add a CORS(Cross Origin Resource Sharing) filter in our security config.
    // This is needed for the frontend, which is sending requests from the other origin.
    // The Cors filter intercepts requests, and if these are identified as cross-origin, it adds proper headers to the request.
    //For that, we will use Spring Security's CorsConfigurationSource interface.
    // In this example, we will allow all HTTP methods and headers(using *).
    //We can define the list of all permissible origins, methods and headers here if we require more finely graded definition.

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**",config);
        return source;
    }



    //Basic Authentication
    // this method enables user from the database. We should never save the password as plain text to the database.
    //Therefore, we will define a password hashing algorithm  in this emthod.
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }





    //add in memory users to our application by adding UserDetailsService() method
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
