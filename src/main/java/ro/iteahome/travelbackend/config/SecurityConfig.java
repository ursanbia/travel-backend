package ro.iteahome.travelbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bianca")
                .password("password")
                .roles("USER")
                .and()
                .withUser("radu")
                .password("password")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordIncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
