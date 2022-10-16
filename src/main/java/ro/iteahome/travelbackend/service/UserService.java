package ro.iteahome.travelbackend.service;

import org.springframework.stereotype.Service;
import ro.iteahome.travelbackend.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(){{
        add(new User(1,"bianca","password", "ROLE_USER"));
        add(new User(1,"razvan","password", "ROLE_USER"));
        add(new User(1,"radu","password", "ROLE_ADMIN"));
    }};


    public Optional<User> findByUserName(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();

    }
}
