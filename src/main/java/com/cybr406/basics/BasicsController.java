package com.cybr406.basics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class BasicsController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }
    
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello, world.";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {
        return String.format("Hello, %s.", name);
    }

    @GetMapping("/path/to/{name}")
    public String pathGreeting(@PathVariable String name) {
        return String.format("You're on the path to %s!", name);
    }

    @GetMapping("/map")
    public String map(@RequestParam MultiValueMap<String, String> params) {
        return params.entrySet().stream()
                .map(entry -> entry.getKey() + " values = " + String.join(", ", entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
    
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
