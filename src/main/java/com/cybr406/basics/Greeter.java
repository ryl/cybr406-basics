package com.cybr406.basics;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

    String greeting;

    public Greeter() {
        greeting = "Hello";
    }

    public Greeter(String greeting) {
        this.greeting = greeting;
    }

    public String greeting(String name) {
        return String.format("%s, %s.", greeting, name);
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
