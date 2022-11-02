package ro.iteahome.travelbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()

                .and()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/").permitAll()
                        .antMatchers("/restricted").authenticated()
//                        .antMatchers("/client-confirmation").hasRole("CLIENT")
//                        .antMatchers("/admin-confirmation").hasRole("ADMIN")
//                        .antMatchers("/clients", "/roles", "/privileges").hasAuthority("CAN_READ")
                        .antMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated())

                .csrf().disable()                   // Allows the H2 console to open properly
                .headers().frameOptions().disable() // Allows the H2 console to render properly

                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
