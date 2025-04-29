package br.com.futurodev.API_Sustentavel.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())

                .authorizeHttpRequests( (request) -> request
                .requestMatchers(HttpMethod.POST, "/Acoes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/Acoes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Acoes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/Acoes/**").hasRole("USER")
                .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
         UserDetails admin = User.withDefaultPasswordEncoder()
                 .username("admin")
                 .password("admin")
                 .roles("ADMIN", "USER")
                 .build();

         UserDetails user = User.withDefaultPasswordEncoder()
                 .username("user")
                 .password("user")
                 .roles("USER")
                 .build();

         return new InMemoryUserDetailsManager(admin, user);
    }


}
