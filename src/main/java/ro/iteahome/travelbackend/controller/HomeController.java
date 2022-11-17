package ro.iteahome.travelbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Travel";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "Welcome to Restricted Area";
    }

}
