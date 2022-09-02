package me.hero.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {
    private final Environment env;

    public UserApplication(Environment environment) {
        this.env = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "User" + env.getProperty("user.name");
    }
}
