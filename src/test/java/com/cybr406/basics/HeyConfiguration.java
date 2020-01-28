package com.cybr406.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("hey")
@Configuration
public class HeyConfiguration {

    @Autowired
    public void configureGreeter(Greeter greeter) {
        greeter.setGreeting("Hey");
    }

}
