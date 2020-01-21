package com.cybr406.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicsController {

    @RequestMapping("/helloworld/all")
    public @ResponseBody String helloWorld() {
        return "Hello, world.";
    }

}
