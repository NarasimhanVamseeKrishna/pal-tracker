package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


   // @Value("${welcome.message}")
    String welcomeMessage;

    public WelcomeController(@Value("${welcome.message}") String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return welcomeMessage;
    }
}
