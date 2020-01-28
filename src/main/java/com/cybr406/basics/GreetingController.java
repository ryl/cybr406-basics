package com.cybr406.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    Greeter greeter;

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {
        System.out.println(greeter);
        return greeter.greeting(name);
    }

}
