package com.cybr406.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BasicsRestController {

    @Value("${app.environment}")
    String environment;

    @Autowired
    Greeter greeter;
    
    @InitBinder("user")
    public void initUserBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }
    
    @GetMapping("/helloworld")
    public String helloWorld() {
        System.out.println(greeter);
        return greeter.greeting("world");
    }

    @GetMapping("/path/to/{name}")
    public String pathGreeting(@PathVariable String name) {
        return String.format("You're on the path to %s!", name);
    }

    @GetMapping("/map")
    public String map(@RequestParam MultiValueMap<String, String> params) {
        // Possibility 1 - steams api
        return params.entrySet().stream()
                .map(entry -> String.format("%s values = %s", entry.getKey(), String.join(", ", entry.getValue())))
                .collect(Collectors.joining("\n"));
        
//        // Possibility 2 - For loop & String.join
//        List<String> parts = new ArrayList<>();
//        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
//            parts.add(entry.getKey() + " values = " + String.join(", ", entry.getValue()));
//        }
//        return String.join("\n", parts);
        
//        // Possibility 3 - For loop, string concatenation.
//        // The trouble here is its hard to know when you are on the last entry.
//        String output = "";
//        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
//            output += entry.getKey() + " values = " + String.join(", ", entry.getValue()) + "\n";
//        }
//        // Manually remove the last newline
//        String result = output.trim();
//        return result;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/register/map")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, Object> notUser) {
        return new ResponseEntity<>(notUser, HttpStatus.CREATED);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }
    
    @GetMapping("/env")
    public String environment() {
        return environment;
    }

}
