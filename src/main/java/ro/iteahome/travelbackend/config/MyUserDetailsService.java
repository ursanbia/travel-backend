package ro.iteahome.travelbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.iteahome.travelbackend.entity.User;
import ro.iteahome.travelbackend.service.UserService;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByUserName(username);
        if (userOptional.isPresent()) {
            System.err.println("Found!");
            User user = userOptional.get();
            return new MyUserDetails(user);
        } else {
            System.err.println("Not Found!");
            throw new UsernameNotFoundException("User not found in User Service.");
        }

    }
}
